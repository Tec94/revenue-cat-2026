# Restart Thread Cloudflare backend

This Worker is Restart Thread's selected cloud boundary. Calling it remains an
optional product path: each native client is the source of truth, the app must
commit protected local content before a request, and every API failure returns
to local deterministic recovery.

## Cloudflare substitution

Cloudflare is compatible with the approved KMP client and its native Android
and iOS shells. The current mapping is deliberately small:

- Workers replaces the Supabase Edge Function HTTPS boundary.
- D1 replaces Postgres for install credentials, allowance, idempotency, feature
  flags, and content-free operational metadata.
- Workers AI is the proposed single provider for transcription and drafting.
- R2, KV, Queues, Durable Objects, and a public data API are excluded from this
  slice.

The Worker never stores audio, transcript, draft, action, or source content.
Idempotency records contain only opaque IDs, state, model name, error class, and
an output hash. Because responses are not persisted, a replay after a completed
request returns a safe conflict instead of returning sensitive server data.

## Local setup

Generate an ignored local secret, then install and verify the Worker:

```powershell
powershell -ExecutionPolicy Bypass -File scripts/initialize-local-secrets.ps1
cmd /c npm install
cmd /c npm run d1:migrate:local
cmd /c npm run check
cmd /c npm run dev
```

The script creates `backend/.env` without printing its value and retains an
existing valid value. `.env.example` documents the required name without
containing a usable secret. Do not reuse the local value in Cloudflare.

Cloud recovery is disabled in both `wrangler.jsonc` and D1 until the Workers AI
spike, privacy copy, grounding fixtures, and anonymous-enrollment abuse control
pass. The installation endpoint can otherwise reset a per-install allowance;
do not enable paid AI from a public deployment until that boundary is selected
from measured traffic and an owner-approved cost ceiling. Enable both feature
controls only for a bounded test:

```sql
UPDATE feature_flags
SET value = 'true', updated_at = CURRENT_TIMESTAMP
WHERE key = 'cloud_enabled';
```

Change `AI_MODE` from `deterministic` to `workers-ai` for a real remote test.
Wrangler invokes Workers AI remotely even during local development and the call
consumes the Cloudflare account's current allocation.

## API

- `GET /health` returns content-free service status.
- `POST /v1/installations` creates a resettable install-scoped credential.
- `POST /v1/recoveries/text` accepts bounded text JSON.
- `POST /v1/recoveries/audio` accepts a Base64 app-recorded audio JSON payload.

Recovery requests require `Authorization: Bearer <installation token>` and a
UUID `Idempotency-Key`. Production clients must keep both the token and user
content in protected app storage.

## Free-tier compatibility

Observed August 12, 2026, Cloudflare documents 100,000 Worker requests per day,
10 ms CPU per free Worker invocation, D1 free daily row allowances and 5 GB
total account storage, and 10,000 Workers AI Neurons per day. Free limits fail
closed when exhausted. The text path is a strong fit. The audio path remains a
technical spike because parsing or transforming a large Base64 body may exceed
the free Worker's 10 ms CPU budget. If measured audio requests consistently hit
that ceiling, the choices are to optimize the payload path, move to the Workers
Paid minimum, or keep cloud voice disabled; local voice and deterministic
recovery must not change.

Workers AI states that it does not train or improve its services with customer
content without explicit consent, but the final privacy policy must still name
Cloudflare, the selected third-party model licenses, actual retention behavior,
and all enabled storage products.

## External setup

The following Cloudflare state was provisioned on August 12, 2026:

| Environment | Worker | D1 database | Status |
| --- | --- | --- | --- |
| Development | `restart-thread-api` | `restart-thread-dev` | Deployed, cloud off |
| Production | `restart-thread-api-production` | `restart-thread-production` | Deployed, cloud off |

Migration `0001_initial.sql` is applied to both databases. Each Worker has a
different generated `INSTALLATION_TOKEN_SECRET` stored as a Cloudflare secret,
and both health endpoints return HTTP 200:

- `https://restart-thread-api.jack-cao.workers.dev/health`
- `https://restart-thread-api-production.jack-cao.workers.dev/health`

Cloudflare is operational, but owner approval of processor terms, privacy
disclosure, and the final D1 primary location is still required before enabling
remote user data. Follow the root [`MANUAL_SETUP.md`](../MANUAL_SETUP.md).
Never paste secrets into research files or chat.
