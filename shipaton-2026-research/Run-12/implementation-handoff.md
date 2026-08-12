# Restart Thread — one-page design and engineering handoff

**Decision:** Build the RevenueCat Design core as a native Kotlin and Jetpack
Compose Android API-36 app. Use one Gradle project with Play and conditional
Galaxy flavors. Treat Galaxy and OneSignal as removable evidence layers. Apple
work begins only after the September 30 submission.

## Product contract

**Promise:** “Speak where you are. Return to one clear first step.”

**User:** A US adult who self-identifies with ADHD, time blindness,
interruption sensitivity, or recurring restart difficulty. Do not require a
diagnosis or make treatment claims.

**Core value:** Preserve or reconstruct interrupted state, turn it into one
grounded and editable action, show the source evidence, and let the user tap
Start. A capture, draft, app open, push click, or purchase is not success;
`verified_restart_started` is.

## Build this loop first

1. Enter through app, text, Share, shortcut, or a proven quick surface.
2. Speak for up to 60 seconds or type the current state.
3. Commit encrypted local content and show **Saved on this device**.
4. After separate cloud consent, request bounded transcription and grounded
   drafting through Cloudflare Workers, D1 metadata, and Workers AI.
5. Show **You said**, one editable **Start here**, no more than three later
   steps, and **Why this?** with the Direct Trace-back Connector.
6. Require edit or confirmation, then Start.
7. On denial, offline, timeout, or unsafe AI output, preserve the local thread
   and offer the deterministic matter → blocker → action reset.

Never acknowledge save before the local commit. Never expose content on a
locked surface or in a notification. Never let the model start an action.

## Essential surfaces

Implement first launch/example; voice, text, and Share capture; local-save and
processing states; AI review and evidence; deterministic reset; Now and Return
Card; history/detail/delete/export; paywall/purchase/restore/status; settings;
and one shared error/recovery system. Quick/locked entry is conditional on the
device spike. OneSignal is conditional on core stability and proof value.

## Design system

Use H2 Forward Thread: paper, ink, editorial red, a large present-state dot,
dotted context line, forward arrow, restrained tactile button depth, and the
single-state generic quick-surface treatment. The signature interaction is
I2-V1 Direct Trace-back Connector.

Use semantic light, dark, and increased-contrast roles; Roboto/system body;
48 dp targets; `sp` text; TalkBack semantics; logical focus; color-independent
state; and one-handed reach. Motion families are 80–120 ms press, 160–220 ms
state, and 220–280 ms spatial. Reduced motion uses static evidence links and
instant or crossfade state changes. Haptics and sound are optional and never the
only feedback.

## Architecture and data

Use one Activity and Compose navigation with `ui`, `domain`, `data.local`,
`data.remote`, `billing`, `platform`, and `telemetry` packages. Use Room for
metadata and opaque IDs. Store content in AES-256-GCM encrypted app-private
files with a non-exportable Keystore key; exclude vault files from backup and
export only through the system picker.

Use a thin Cloudflare Worker with an install-scoped credential, allowance,
idempotency, validation, Workers AI, and no server content persistence. D1 holds
only content-free operational metadata and feature flags. Keep provider and
RevenueCat secret keys off the client. Feature flags must disable cloud, locked
entry, Galaxy, OneSignal, and sharing without blocking owned local recovery.
Do not add R2, KV, Queues, Durable Objects, accounts, sync, or a provider router
to the first slice. Free-plan cloud voice remains conditional on its Worker CPU
spike; text and local recovery do not depend on it.

RevenueCat uses one `pro` entitlement, `default` Offering, monthly and annual
packages, anonymous first value, explicit Restore, and lifecycle-safe free
fallback. Price hypotheses are US$4.99 monthly and US$39.99 annual. Seven cloud
drafts per rolling 30 days is remotely configurable and unvalidated.

## Proof that blocks release

Any lost committed capture, private locked-surface exposure, reversed negation,
wrong charge or entitlement, unrecoverable purchase, or blocking accessibility
defect stops the candidate. Grounded output needs at least 90% factual citation
coverage and zero reversed negations. Four of five formative users must begin
prepared recording within five seconds and confirm/edit plus Start within 60
seconds. The behavioral core passes at 50% or more of at least 20 genuine events
across five users reaching meaningful action within two minutes; below 25% or
prompted-only use kills the concept.

## Metrics and award cuts

A1 is draft-open to confirmed/edited Start within 120 seconds. A2 diagnoses the
full intent-to-Start funnel. R1 is a second distinct restart within seven days.
Keep R2 split same/distinct, R3 D1 continuity, and R4 D30 recurrence visible.
Event properties must never include user content or sensitive data.

Design is primary. Keep Galaxy only after a live listing, physical purchase,
adaptive-state proof, and polished store assets. Keep OneSignal only after one
requested reminder resolves safely to a verified Start. When a conditional
gate fails, delete the award claim and its demo segment; do not expand scope to
rescue it.

## Immediate owner actions

Confirm the permanent package ID, Play account type and tester gate, Samsung
seller status, physical Galaxy access, and Cloudflare account/processor terms.
The API-36 project, store flavors, local encrypted slice, and disabled-by-
default Cloudflare foundation now exist. Continue the three spikes in this
order: durable capture and quick-entry truth; Play/Galaxy RevenueCat purchase
and restore; bounded grounded-cloud recovery. Preserve dated targets only when
their prerequisites are real.
