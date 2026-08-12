import {
	createRecoveryDraft,
	parseAudioRecoveryInput,
	parseTextRecoveryInput,
	type RecoveryInput,
} from "./recovery";
import { issueInstallationToken, verifyInstallationToken } from "./security";

type WorkerEnv = Omit<
	Env,
	"AI_MODE" | "CLOUD_RECOVERY_ENABLED" | "ENVIRONMENT" | "FREE_CLOUD_ALLOWANCE"
> & {
	AI_MODE: "workers-ai" | "deterministic" | "disabled";
	CLOUD_RECOVERY_ENABLED: string;
	ENVIRONMENT: "development" | "production" | "test";
	FREE_CLOUD_ALLOWANCE: string;
};

interface CloudConfig {
	cloudEnabled: boolean;
	freeAllowance: number;
}

interface InstallationRecord {
	id: string;
	revoked_at: string | null;
}

const JSON_HEADERS = {
	"content-type": "application/json; charset=utf-8",
	"cache-control": "no-store",
};

export default {
	async fetch(request, env): Promise<Response> {
		const url = new URL(request.url);
		const requestId = request.headers.get("x-request-id") ?? crypto.randomUUID();

		try {
			if (request.method === "GET" && url.pathname === "/health") {
				return json({
					status: "ok",
					service: "restart-thread-api",
					environment: env.ENVIRONMENT,
					requestId,
				});
			}

			if (request.method === "POST" && url.pathname === "/v1/installations") {
				return await createInstallation(env, requestId);
			}

			if (
				request.method === "POST" &&
				(url.pathname === "/v1/recoveries/text" ||
					url.pathname === "/v1/recoveries/audio")
			) {
				return await recover(request, env, requestId, url.pathname.endsWith("/audio"));
			}

			return json({ error: "not_found", requestId }, 404);
		} catch (error) {
			// Never add request bodies, authorization headers, transcript text, or model
			// output to this log. The request ID is random and contains no user content.
			console.error(
				JSON.stringify({
					event: "request_failed",
					requestId,
					errorClass: error instanceof Error ? error.name : "UnknownError",
				}),
			);
			return json({ error: "internal_error", requestId }, 500);
		}
	},
} satisfies ExportedHandler<WorkerEnv>;

async function createInstallation(env: WorkerEnv, requestId: string): Promise<Response> {
	assertSecretConfigured(env);

	const installationId = crypto.randomUUID();
	const issuedAt = new Date().toISOString();
	const token = await issueInstallationToken(
		installationId,
		issuedAt,
		env.INSTALLATION_TOKEN_SECRET,
	);

	await env.DB.prepare(
		"INSERT INTO installations (id, created_at) VALUES (?, ?)",
	)
		.bind(installationId, issuedAt)
		.run();

	return json(
		{
			installationId,
			token,
			issuedAt,
			requestId,
		},
		201,
	);
}

async function recover(
	request: Request,
	env: WorkerEnv,
	requestId: string,
	isAudio: boolean,
): Promise<Response> {
	assertSecretConfigured(env);

	const authorization = request.headers.get("authorization");
	const token = authorization?.startsWith("Bearer ")
		? authorization.slice("Bearer ".length)
		: null;
	if (!token) {
		return json({ error: "missing_installation_token", requestId }, 401);
	}

	const tokenResult = await verifyInstallationToken(
		token,
		env.INSTALLATION_TOKEN_SECRET,
	);
	if (!tokenResult.ok) {
		return json({ error: "invalid_installation_token", requestId }, 401);
	}

	const installation = await env.DB.prepare(
		"SELECT id, revoked_at FROM installations WHERE id = ? LIMIT 1",
	)
		.bind(tokenResult.installationId)
		.first<InstallationRecord>();
	if (!installation || installation.revoked_at) {
		return json({ error: "inactive_installation", requestId }, 401);
	}

	const idempotencyKey = request.headers.get("idempotency-key");
	if (!idempotencyKey || !isUuid(idempotencyKey)) {
		return json({ error: "invalid_idempotency_key", requestId }, 400);
	}

	const config = await loadCloudConfig(env);
	if (!config.cloudEnabled || env.AI_MODE === "disabled") {
		return json(
			{
				error: "cloud_recovery_unavailable",
				fallback: "use_local_deterministic_recovery",
				requestId,
			},
			503,
		);
	}

	let input: RecoveryInput;
	try {
		const body = await request.json<unknown>();
		input = isAudio ? parseAudioRecoveryInput(body) : parseTextRecoveryInput(body);
	} catch (error) {
		return json(
			{
				error: error instanceof Error ? error.message : "invalid_request_body",
				requestId,
			},
			400,
		);
	}

	const reservation = await reserveRecovery(
		env,
		installation.id,
		idempotencyKey,
		requestId,
		input.mode,
		config.freeAllowance,
	);
	if (reservation === "duplicate") {
		return json(
			{
				error: "idempotency_replay_without_payload",
				fallback: "use_the_locally_saved_thread",
				requestId,
			},
			409,
		);
	}
	if (reservation === "allowance_exhausted") {
		return json({ error: "free_cloud_allowance_exhausted", requestId }, 402);
	}

	try {
		const draft = await createRecoveryDraft(input, env.AI_MODE, env.AI);
		const outputHash = await sha256(JSON.stringify(draft));
		await env.DB.prepare(
			`UPDATE recovery_requests
			 SET status = 'complete', completed_at = ?, provider_model = ?, output_hash = ?
			 WHERE request_id = ?`,
		)
			.bind(new Date().toISOString(), draft.model, outputHash, requestId)
			.run();

		return json({ draft, requestId });
	} catch (error) {
		await env.DB.prepare(
			`UPDATE recovery_requests
			 SET status = 'failed', completed_at = ?, error_class = ?
			 WHERE request_id = ?`,
		)
			.bind(
				new Date().toISOString(),
				error instanceof Error ? error.name : "UnknownError",
				requestId,
			)
			.run();
		return json(
			{
				error: "cloud_recovery_failed",
				fallback: "use_local_deterministic_recovery",
				requestId,
			},
			502,
		);
	}
}

async function loadCloudConfig(env: WorkerEnv): Promise<CloudConfig> {
	const result = await env.DB.prepare(
		"SELECT key, value FROM feature_flags WHERE key IN ('cloud_enabled', 'free_allowance')",
	).all<{ key: string; value: string }>();
	const flags = new Map(result.results.map((row) => [row.key, row.value]));
	const configuredAllowance = Number(
		flags.get("free_allowance") ?? env.FREE_CLOUD_ALLOWANCE,
	);

	return {
		cloudEnabled:
			env.CLOUD_RECOVERY_ENABLED === "true" && flags.get("cloud_enabled") === "true",
		freeAllowance:
			Number.isInteger(configuredAllowance) && configuredAllowance > 0
				? configuredAllowance
				: 7,
	};
}

async function reserveRecovery(
	env: WorkerEnv,
	installationId: string,
	idempotencyKey: string,
	requestId: string,
	inputMode: RecoveryInput["mode"],
	allowance: number,
): Promise<"reserved" | "duplicate" | "allowance_exhausted"> {
	const now = new Date();
	const windowStart = new Date(now);
	windowStart.setUTCDate(windowStart.getUTCDate() - 30);

	const inserted = await env.DB.prepare(
		`INSERT INTO recovery_requests
		 (request_id, installation_id, idempotency_key, status, input_mode, created_at)
		 SELECT ?, ?, ?, 'accepted', ?, ?
		 WHERE (
		   SELECT COUNT(*) FROM recovery_requests
		   WHERE installation_id = ?
		     -- A provider failure can still consume AI allocation. Count it so
		     -- repeated failing inputs cannot bypass the configured allowance.
		     AND status IN ('accepted', 'complete', 'failed')
		     AND created_at >= ?
		 ) < ?
		 ON CONFLICT (installation_id, idempotency_key) DO NOTHING
		 RETURNING request_id`,
	)
		.bind(
			requestId,
			installationId,
			idempotencyKey,
			inputMode,
			now.toISOString(),
			installationId,
			windowStart.toISOString(),
			allowance,
		)
		.first<{ request_id: string }>();

	if (inserted) return "reserved";

	const duplicate = await env.DB.prepare(
		`SELECT request_id FROM recovery_requests
		 WHERE installation_id = ? AND idempotency_key = ? LIMIT 1`,
	)
		.bind(installationId, idempotencyKey)
		.first<{ request_id: string }>();

	return duplicate ? "duplicate" : "allowance_exhausted";
}

function assertSecretConfigured(env: WorkerEnv): void {
	if (!env.INSTALLATION_TOKEN_SECRET || env.INSTALLATION_TOKEN_SECRET.length < 32) {
		throw new Error("INSTALLATION_TOKEN_SECRET is not configured");
	}
}

function isUuid(value: string): boolean {
	return /^[0-9a-f]{8}-[0-9a-f]{4}-[1-8][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$/i.test(
		value,
	);
}

async function sha256(value: string): Promise<string> {
	const digest = await crypto.subtle.digest(
		"SHA-256",
		new TextEncoder().encode(value),
	);
	return Array.from(new Uint8Array(digest), (byte) =>
		byte.toString(16).padStart(2, "0"),
	).join("");
}

function json(body: unknown, status = 200): Response {
	return new Response(JSON.stringify(body), {
		status,
		headers: JSON_HEADERS,
	});
}
