# Restart Thread Cloudflare backend

Cloudflare is the selected account and optional recovery boundary. The Android
app remains fully useful offline and commits locally before any remote work.
The Worker never receives or stores thread content during account allowance or
deletion operations.

## API

- `GET /health` — content-free service status.
- `POST /v1/installations` — installation-scoped optional recovery credential.
- `POST /v1/recoveries/text` and `/audio` — feature-gated recovery endpoints.
  They accept either an installation token or an Auth0 token with
  `recovery:create`; authenticated usage is counted against that account.
- `GET /v1/account/allowance` — Auth0-authenticated, scope `account:read`.
- `DELETE /v1/account` — Auth0-authenticated, scope `account:delete`; removes
  the Auth0 user and hashed D1 account metadata.

Auth0 access tokens are accepted only after RS256 signature/JWKS, issuer,
audience, expiry, and scope validation. D1 stores a SHA-256 account key rather
than the Auth0 `sub`. Logs exclude authorization values and user content.

## Local verification

```powershell
cmd /c npm install
cmd /c npm run d1:migrate:local
cmd /c npm run check
cmd /c npm run dev
```

Copy `.env.example` to ignored `.env` for local secrets. Configure the Auth0
issuer and audience in `wrangler.jsonc`. Apply both migrations before deploying.

## Deployment

Create separate Auth0 Management API credentials for account deletion, then
store them and the installation secret with `wrangler secret put`. Never put
them in `wrangler.jsonc`, Android, documentation, or Git.

```powershell
cmd /c npm run d1:migrate:dev
cmd /c npm run d1:migrate:production
cmd /c npm run deploy
cmd /c npm run deploy:production
```

Remote recovery remains disabled by both Worker variable and D1 feature flag.
Do not enable it until provider/privacy terms, bounded audio cost, grounding,
negation, abuse, and local fallback tests pass. See root `MANUAL_SETUP.md`.
