# Run 12 implementation update — Cloudflare backend

**Observed:** August 12, 2026. **Status:** owner-directed implementation
override after the approved conditional go.

## Compatibility conclusion

Cloudflare is compatible with the selected native Kotlin and Jetpack Compose
stack. The Android product depends on a versioned HTTPS contract, not on a
Supabase client SDK, so the backend substitution does not change the selected
platform, local-first core loop, RevenueCat store flavors, or later Apple
option. The Android Play and Galaxy debug variants both compile with the new
contract present.

The smallest replacement is:

- Cloudflare Workers for the thin HTTPS boundary;
- D1 for install credentials, allowance, idempotency, content-free request
  state, and feature flags; and
- Workers AI as the proposed single transcription and drafting provider.

R2, KV, Queues, Durable Objects, public database access, accounts, sync, and a
provider router are excluded. They are not required by the current contract.

## Privacy and failure boundary

The device remains the source of truth. It encrypts and commits capture content
before an optional request. The Worker does not persist audio, transcript,
draft, action, or evidence text. D1 stores opaque installation and request IDs,
state, input mode, model name, error class, timestamps, and an output hash.
Cloud failure returns the user to owned local deterministic recovery.

Cloudflare states that Workers AI does not train or improve its services with
customer content without explicit consent. That does not remove the need to
name Cloudflare and the selected model licensors in the final processor and
privacy inventory.

## Free-tier fit and unresolved constraint

Current official documentation lists 100,000 Worker requests per day on Free,
10 ms CPU per invocation, 128 MB memory, and a 100 MB request-body limit. D1
Free lists 5 million rows read and 100,000 rows written per day, 5 GB total
account storage, and 500 MB per database. Workers AI includes 10,000 Neurons
per day. These are provider limits observed on August 12, not product demand or
recommended usage targets.

The bounded text path is compatible. Cloud voice remains conditional because
Base64 handling and audio orchestration may exceed the Free Worker's 10 ms CPU
allowance even though network and database wait time do not count as CPU. The
required technical spike is to measure a real 60-second AAC request. Failure
means optimize the path, obtain owner approval for Workers Paid, or disable
cloud voice; it does not remove local voice capture or text recovery.

Anonymous installation issuance can currently reset a per-install allowance.
Cloud enablement therefore also remains blocked until an enrollment abuse
control is selected from measured traffic and an owner-approved cost ceiling.
No arbitrary request limit is introduced in this setup run.

## Implemented proof

- Local D1 migration applied successfully.
- Worker TypeScript compilation and 9 focused tests passed.
- Cloud recovery is disabled by both environment and D1 flags.
- Android Play and Galaxy debug APKs compiled with the store-specific
  RevenueCat dependencies and Cloudflare API client.
- No Cloudflare account, remote database, secret, deployment, real AI result,
  or physical-device behavior is claimed.

## Current official sources

- [Workers limits](https://developers.cloudflare.com/workers/platform/limits/)
- [Workers pricing](https://developers.cloudflare.com/workers/platform/pricing/)
- [D1 pricing](https://developers.cloudflare.com/d1/platform/pricing/)
- [D1 limits](https://developers.cloudflare.com/d1/platform/limits/)
- [Workers AI pricing](https://developers.cloudflare.com/workers-ai/platform/pricing/)
- [Workers AI data use](https://developers.cloudflare.com/workers-ai/platform/data-usage/)
- [Whisper Large V3 Turbo](https://developers.cloudflare.com/workers-ai/models/whisper-large-v3-turbo/)
