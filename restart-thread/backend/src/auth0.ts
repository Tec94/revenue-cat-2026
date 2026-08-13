import {
	createRemoteJWKSet,
	jwtVerify,
	type JWTVerifyGetKey,
} from "jose";

export interface Auth0Configuration {
	AUTH0_ISSUER_BASE_URL: string;
	AUTH0_AUDIENCE: string;
}

export interface VerifiedAccount {
	subject: string;
	scopes: ReadonlySet<string>;
}

const remoteKeySets = new Map<string, JWTVerifyGetKey>();

export async function verifyAuth0AccessToken(
	token: string,
	env: Auth0Configuration,
	keySet?: JWTVerifyGetKey,
): Promise<VerifiedAccount> {
	const issuer = normalizeIssuer(env.AUTH0_ISSUER_BASE_URL);
	if (!env.AUTH0_AUDIENCE) throw new Error("AUTH0_AUDIENCE is not configured");
	const keys = keySet ?? remoteKeysFor(issuer);
	const { payload } = await jwtVerify(token, keys, {
		issuer,
		audience: env.AUTH0_AUDIENCE,
		algorithms: ["RS256"],
	});
	if (!payload.sub) throw new Error("Auth0 access token is missing sub");
	return {
		subject: payload.sub,
		scopes: new Set(typeof payload.scope === "string" ? payload.scope.split(" ") : []),
	};
}

export function requireScope(account: VerifiedAccount, scope: string): void {
	if (!account.scopes.has(scope)) throw new MissingScopeError(scope);
}

export class MissingScopeError extends Error {
	constructor(readonly scope: string) {
		super(`Missing required scope: ${scope}`);
		this.name = "MissingScopeError";
	}
}

export function normalizeIssuer(value: string): string {
	const url = new URL(value);
	if (url.protocol !== "https:" || url.username || url.password) {
		throw new Error("AUTH0_ISSUER_BASE_URL must be an HTTPS origin");
	}
	url.search = "";
	url.hash = "";
	return url.toString().replace(/\/+$/, "") + "/";
}

function remoteKeysFor(issuer: string): JWTVerifyGetKey {
	const cached = remoteKeySets.get(issuer);
	if (cached) return cached;
	const keySet = createRemoteJWKSet(new URL(".well-known/jwks.json", issuer));
	remoteKeySets.set(issuer, keySet);
	return keySet;
}
