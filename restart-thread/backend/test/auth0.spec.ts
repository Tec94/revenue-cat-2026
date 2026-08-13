import { generateKeyPair, exportJWK, SignJWT, createLocalJWKSet } from "jose";
import { describe, expect, it } from "vitest";
import {
	MissingScopeError,
	requireScope,
	verifyAuth0AccessToken,
} from "../src/auth0";

const issuer = "https://restart-thread-test.us.auth0.com/";
const audience = "https://api.restartthread.app";

async function signedToken(options: { audience?: string; scope?: string } = {}) {
	const { privateKey, publicKey } = await generateKeyPair("RS256");
	const jwk = await exportJWK(publicKey);
	jwk.kid = "test-key";
	const token = await new SignJWT({
		scope: options.scope ?? "account:read account:delete",
	})
		.setProtectedHeader({ alg: "RS256", kid: jwk.kid })
		.setIssuer(issuer)
		.setAudience(options.audience ?? audience)
		.setSubject("auth0|stable-user")
		.setIssuedAt()
		.setExpirationTime("5m")
		.sign(privateKey);
	return { token, keySet: createLocalJWKSet({ keys: [jwk] }) };
}

describe("Auth0 access token verification", () => {
	it("accepts the configured issuer, audience, signature, expiry, and scopes", async () => {
		const { token, keySet } = await signedToken();
		const account = await verifyAuth0AccessToken(
			token,
			{ AUTH0_ISSUER_BASE_URL: issuer, AUTH0_AUDIENCE: audience },
			keySet,
		);
		expect(account.subject).toBe("auth0|stable-user");
		expect(account.scopes.has("account:delete")).toBe(true);
	});

	it("rejects a token issued for a different API", async () => {
		const { token, keySet } = await signedToken({ audience: "https://other.example" });
		await expect(
			verifyAuth0AccessToken(
				token,
				{ AUTH0_ISSUER_BASE_URL: issuer, AUTH0_AUDIENCE: audience },
				keySet,
			),
		).rejects.toThrow();
	});

	it("distinguishes a valid identity from one missing a required scope", async () => {
		const { token, keySet } = await signedToken({ scope: "account:read" });
		const account = await verifyAuth0AccessToken(
			token,
			{ AUTH0_ISSUER_BASE_URL: issuer, AUTH0_AUDIENCE: audience },
			keySet,
		);
		expect(() => requireScope(account, "account:delete")).toThrow(MissingScopeError);
	});
});
