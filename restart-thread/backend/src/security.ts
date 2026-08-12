const encoder = new TextEncoder();

export type VerifiedInstallationToken =
	| { ok: true; installationId: string; issuedAt: string }
	| { ok: false };

export async function issueInstallationToken(
	installationId: string,
	issuedAt: string,
	secret: string,
): Promise<string> {
	const issuedAtEpochMs = Date.parse(issuedAt);
	if (!Number.isFinite(issuedAtEpochMs)) throw new Error("InvalidIssuedAt");
	const payload = `v1.${installationId}.${issuedAtEpochMs}`;
	const key = await importHmacKey(secret, ["sign"]);
	const signature = await crypto.subtle.sign("HMAC", key, encoder.encode(payload));
	return `${payload}.${toBase64Url(new Uint8Array(signature))}`;
}

export async function verifyInstallationToken(
	token: string,
	secret: string,
): Promise<VerifiedInstallationToken> {
	const parts = token.split(".");
	if (parts.length !== 4 || parts[0] !== "v1") return { ok: false };

	const [, installationId, issuedAtEpochMs, encodedSignature] = parts;
	if (!installationId || !issuedAtEpochMs || !encodedSignature) return { ok: false };
	const issuedAtNumber = Number(issuedAtEpochMs);
	if (!Number.isFinite(issuedAtNumber)) return { ok: false };

	try {
		const key = await importHmacKey(secret, ["verify"]);
		const valid = await crypto.subtle.verify(
			"HMAC",
			key,
			fromBase64Url(encodedSignature),
			encoder.encode(`v1.${installationId}.${issuedAtEpochMs}`),
		);
		return valid
			? { ok: true, installationId, issuedAt: new Date(issuedAtNumber).toISOString() }
			: { ok: false };
	} catch {
		return { ok: false };
	}
}

async function importHmacKey(
	secret: string,
	keyUsages: Array<"sign" | "verify">,
): Promise<CryptoKey> {
	return crypto.subtle.importKey(
		"raw",
		encoder.encode(secret),
		{ name: "HMAC", hash: "SHA-256" },
		false,
		keyUsages,
	);
}

function toBase64Url(bytes: Uint8Array): string {
	let binary = "";
	for (const byte of bytes) binary += String.fromCharCode(byte);
	return btoa(binary).replaceAll("+", "-").replaceAll("/", "_").replace(/=+$/, "");
}

function fromBase64Url(value: string): ArrayBuffer {
	const padded = value.replaceAll("-", "+").replaceAll("_", "/").padEnd(
		Math.ceil(value.length / 4) * 4,
		"=",
	);
	const binary = atob(padded);
	const bytes = Uint8Array.from(binary, (character) => character.charCodeAt(0));
	return bytes.buffer;
}
