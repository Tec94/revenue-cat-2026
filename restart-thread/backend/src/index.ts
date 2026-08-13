import {
	createRecoveryDraft,
	parseAudioRecoveryInput,
	parseTextRecoveryInput,
	type RecoveryInput,
} from "./recovery";
import { issueInstallationToken, verifyInstallationToken } from "./security";
import {
	MissingScopeError,
	normalizeIssuer,
	requireScope,
	verifyAuth0AccessToken,
} from "./auth0";

type WorkerEnv = Omit<
	Env,
	"AI_MODE" | "CLOUD_RECOVERY_ENABLED" | "ENVIRONMENT" | "FREE_CLOUD_ALLOWANCE"
> & {
	AI_MODE: "workers-ai" | "deterministic" | "disabled";
	CLOUD_RECOVERY_ENABLED: string;
	ENVIRONMENT: "development" | "production" | "test";
	FREE_CLOUD_ALLOWANCE: string;
	AUTH0_ISSUER_BASE_URL: string;
	AUTH0_AUDIENCE: string;
	AUTH0_MANAGEMENT_CLIENT_ID: string;
	AUTH0_MANAGEMENT_CLIENT_SECRET: string;
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

			if (request.method === "GET" && url.pathname === "/v1/account/allowance") {
				return await accountAllowance(request, env, requestId);
			}

			if (request.method === "DELETE" && url.pathname === "/v1/account") {
				return await deleteAccount(request, env, requestId);
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
			if (error instanceof MissingScopeError) {
				return json({ error: "insufficient_scope", requestId }, 403);
			}
			if (error instanceof AuthFailureError) {
				return json({ error: "invalid_access_token", requestId }, 401);
			}
			if (error instanceof BackendConfigurationError) {
				return json({ error: "account_service_not_configured", requestId }, 503);
			}
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

async function accountAllowance(
	request: Request,
	env: WorkerEnv,
	requestId: string,
): Promise<Response> {
	const account = await authenticateAccount(request, env);
	requireScope(account, "account:read");
	const accountKey = await sha256(account.subject);
	const createdAt = new Date().toISOString();
	await env.DB.prepare(
		"INSERT INTO accounts (account_key, created_at) VALUES (?, ?) ON CONFLICT DO NOTHING",
	)
		.bind(accountKey, createdAt)
		.run();

	const config = await loadCloudConfig(env);
	const windowStart = new Date();
	windowStart.setUTCDate(windowStart.getUTCDate() - 30);
	const usage = await env.DB.prepare(
		`SELECT COUNT(*) AS count FROM recovery_requests
		 WHERE installation_id = ?
		   AND status IN ('accepted', 'complete', 'failed')
		   AND created_at >= ?`,
	)
		.bind(`account.${accountKey}`, windowStart.toISOString())
		.first<{ count: number }>();
	const used = Number(usage?.count ?? 0);
	return json({
		allowance: config.freeAllowance,
		used,
		remaining: Math.max(0, config.freeAllowance - used),
		window: "rolling_30_days",
		requestId,
	});
}

async function deleteAccount(
	request: Request,
	env: WorkerEnv,
	requestId: string,
): Promise<Response> {
	const account = await authenticateAccount(request, env);
	requireScope(account, "account:delete");
	assertAuth0ManagementConfigured(env);
	const issuer = normalizeIssuer(env.AUTH0_ISSUER_BASE_URL);
	const managementToken = await fetchManagementToken(env, issuer);
	const accountKey = await sha256(account.subject);
	await env.DB.batch([
		env.DB.prepare("DELETE FROM installations WHERE id = ?").bind(`account.${accountKey}`),
		env.DB.prepare("DELETE FROM accounts WHERE account_key = ?").bind(accountKey),
	]);
	const response = await fetch(
		new URL(`api/v2/users/${encodeURIComponent(account.subject)}`, issuer),
		{
			method: "DELETE",
			headers: { authorization: `Bearer ${managementToken}` },
		},
	);
	if (!response.ok && response.status !== 404) {
		return json({ error: "account_deletion_unavailable", requestId }, 502);
	}
	return new Response(null, { status: 204, headers: JSON_HEADERS });
}

async function authenticateAccount(request: Request, env: WorkerEnv) {
	const authorization = request.headers.get("authorization");
	if (!authorization?.startsWith("Bearer ")) throw new AuthFailureError();
	try {
		return await verifyAuth0AccessToken(authorization.slice("Bearer ".length), env);
	} catch (error) {
		if (error instanceof MissingScopeError) throw error;
		throw new AuthFailureError();
	}
}

class AuthFailureError extends Error {
	constructor() {
		super("Invalid Auth0 access token");
		this.name = "AuthFailureError";
	}
}

class BackendConfigurationError extends Error {
	constructor(message: string) {
		super(message);
		this.name = "BackendConfigurationError";
	}
}

async function fetchManagementToken(env: WorkerEnv, issuer: string): Promise<string> {
	const response = await fetch(new URL("oauth/token", issuer), {
		method: "POST",
		headers: { "content-type": "application/json" },
		body: JSON.stringify({
			grant_type: "client_credentials",
			client_id: env.AUTH0_MANAGEMENT_CLIENT_ID,
			client_secret: env.AUTH0_MANAGEMENT_CLIENT_SECRET,
			audience: new URL("api/v2/", issuer).toString(),
		}),
	});
	if (!response.ok) throw new Error("Auth0 Management API token request failed");
	const payload = await response.json<{ access_token?: string }>();
	if (!payload.access_token) throw new Error("Auth0 Management API token is missing");
	return payload.access_token;
}

function assertAuth0ManagementConfigured(env: WorkerEnv): void {
	if (!env.AUTH0_MANAGEMENT_CLIENT_ID || !env.AUTH0_MANAGEMENT_CLIENT_SECRET) {
		throw new BackendConfigurationError(
			"Auth0 Management API credentials are not configured",
		);
	}
}

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

	const principal = await recoveryPrincipal(token, env);
	if (!principal) return json({ error: "invalid_access_token", requestId }, 401);

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
		principal.id,
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

async function recoveryPrincipal(
	token: string,
	env: WorkerEnv,
): Promise<InstallationRecord | null> {
	if (token.startsWith("v1.")) {
		const tokenResult = await verifyInstallationToken(
			token,
			env.INSTALLATION_TOKEN_SECRET,
		);
		if (!tokenResult.ok) return null;
		const installation = await env.DB.prepare(
			"SELECT id, revoked_at FROM installations WHERE id = ? LIMIT 1",
		)
			.bind(tokenResult.installationId)
			.first<InstallationRecord>();
		return installation && !installation.revoked_at ? installation : null;
	}

	try {
		const account = await verifyAuth0AccessToken(token, env);
		requireScope(account, "recovery:create");
		const accountKey = await sha256(account.subject);
		const installationId = `account.${accountKey}`;
		const createdAt = new Date().toISOString();
		await env.DB.batch([
			env.DB.prepare(
				"INSERT INTO accounts (account_key, created_at) VALUES (?, ?) ON CONFLICT DO NOTHING",
			).bind(accountKey, createdAt),
			env.DB.prepare(
				"INSERT INTO installations (id, created_at) VALUES (?, ?) ON CONFLICT DO NOTHING",
			).bind(installationId, createdAt),
		]);
		return { id: installationId, revoked_at: null };
	} catch {
		return null;
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
