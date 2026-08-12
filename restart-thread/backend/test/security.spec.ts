import { describe, expect, it } from "vitest";
import { issueInstallationToken, verifyInstallationToken } from "../src/security";

describe("installation credentials", () => {
	it("verifies the exact signed installation token", async () => {
		const secret = "test-secret-with-at-least-thirty-two-characters";
		const token = await issueInstallationToken(
			"70af559a-33f4-4472-893a-a4b6b2328fc4",
			"2026-08-12T00:00:00.000Z",
			secret,
		);

		await expect(verifyInstallationToken(token, secret)).resolves.toMatchObject({
			ok: true,
			installationId: "70af559a-33f4-4472-893a-a4b6b2328fc4",
		});
	});

	it("rejects token tampering", async () => {
		const secret = "test-secret-with-at-least-thirty-two-characters";
		const token = await issueInstallationToken(
			"70af559a-33f4-4472-893a-a4b6b2328fc4",
			"2026-08-12T00:00:00.000Z",
			secret,
		);

		await expect(
			verifyInstallationToken(token.replace("70af", "80af"), secret),
		).resolves.toEqual({ ok: false });
	});
});
