# Run 9 growth experiments

These experiments test acquisition and sharing without broadening Restart
Thread's persona or core loop. Audience size is context, not learning. None has
run, and no result is implied.

## Shared measurement rules

- Use the same landing destination, visual quality, and distribution effort when
  comparing message variants.
- Tag source, message, platform, and experiment. Do not collect transcript,
  action, contact, health, or location content in analytics.
- Count qualified waitlist completion, verified restart, or recipient activation
  as outcomes. Do not promote impressions, likes, push sends, or app opens to
  product success.
- Preserve the user's selected privacy boundary. All product-content sharing is
  explicit, previewed, editable, and off by default.
- Record a decision and product change after the observation. Do not rationalize
  an inconclusive result as success.

## G1 — Acquisition-promise comparison

### Hypothesis

One of two ten-second promises will attract more people who recognize the exact
interruption-and-recovery job without repositioning the product as a planner or
generic AI assistant.

### Variants

- **A — continuity:** “Pick up where interruption broke your thread.”
- **B — low-friction recovery:** “Say what happened. Get one first step you can
  verify.”

Both use the Forward Thread mark, the same short product clip, the same CTA, and
the same disclosure that AI drafts require user confirmation.

### Audience and channel

Recruit adults who describe task resumption, context loss, executive-function
friction, or long-horizon project interruption in reachable ADHD, student,
creator, solo-work, and build-in-public communities. Follow each community's
promotion rules and avoid diagnostic or treatment claims.

### Instrumentation

- `referral_landing_viewed` with message variant and channel class.
- Scenario-selection completion.
- `waitlist_completed` with consented signup stored outside event payloads.
- Free-text research answers stored separately from product analytics.

### Decision

Select the promise that brings the intended trigger and segment into the waitlist
at comparable measured exposure. If neither attracts the target problem, revise
the beachhead or return to Run 5/6 evidence rather than improving ad creative.

### Falsification condition

The test fails if responses describe generic planning, meeting transcription,
therapy, or autonomous task management more often than interruption recovery, or
if the selected message promises behavior the prototype cannot demonstrate.

## G2 — Physical-Galaxy proof clip

### Hypothesis

An honest physical-device demonstration of low-friction capture, durable state,
evidence, and one verified action will create more qualified interest and clearer
judge evidence than device-feature claims or static mockups.

### Artifact

Create one captioned, uncut clip on a physical Galaxy device:

1. Enter from a proven generic lock control or the universal widget fallback.
2. Record and stop.
3. Show local save before cloud processing.
4. Open the ready draft.
5. Reveal the Direct Trace-back Connector.
6. Confirm or edit the first action and tap **Start**.
7. If proven, continue the same state through fold, unfold, or multi-window.

If locked capture or a device posture has not passed physical testing, state the
limitation in the clip and omit the claim.

### Audience and channel

Galaxy users, Android productivity communities, Samsung developer communities,
and the same target-user waitlist channels used in G1.

### Instrumentation

- Tagged landing visit and waitlist completion.
- Questions classified as problem, trust, privacy, device, price, or unrelated.
- Physical test log for capture, save, purchase, restore, and posture continuity.

### Decision

Keep Galaxy as a secondary award when the same-loop experience is proven and
viewers understand the recovery job. If interest centers on a gadget demo while
the product problem remains unclear, revise the story rather than adding device
features.

### Falsification condition

The test fails if the proof requires a simulation, exposes private locked data,
cannot complete a Galaxy purchase lifecycle, or cannot preserve the active
thread across the claimed device state.

## G3 — Sanitized Restart Card

### Hypothesis

A compact, private-by-default proof of regained agency can create voluntary
distribution without exposing the user's thread or adding a social loop.

### Prototype

Offer a share sheet only after `verified_restart_started`. Its default image
contains:

- “I found my next step.”
- The Forward Thread mark and neutral dotted trace.
- An optional generic category such as **after an interruption**, selected by
  the user.
- A referral link without the source thread identifier.

It never contains transcript, action, source, project, contact, time, streak,
score, diagnosis, health detail, location, or generated confidence. The user can
preview, edit, cancel, or share. Sharing is never preselected.

### Prototype tasks

- Decide whether the card feels safe enough to preview.
- Identify any private meaning inferred from the generic card.
- Cancel sharing and verify that nothing is uploaded.
- Share a test card, open it as a recipient, and reach the correct landing page.

### Instrumentation

- `restart_card_previewed`.
- `restart_card_shared`.
- `referral_landing_viewed`.
- Recipient `waitlist_completed` and later `verified_restart_started` when
  attribution remains consented and privacy-safe.

### Decision

Build the share surface only if target users voluntarily share and recipients
understand and activate the recovery job. If sharing creates discomfort, remove
it. If cards are shared but recipients do not activate, do not add rewards,
leaderboards, or referral pressure.

### Falsification condition

The test fails if users want to include private content to make the card useful,
if recipients misread it as mental-health treatment or generic motivation, or if
the referral cannot be separated from the private thread.

## OneSignal experiment nested inside retention

This is not one of the first three growth experiments. It is the conditional
Keep Them Coming Back proof.

After first verified value, compare a user-initiated **Remind me once** request
with no reminder. The message stays generic and deep-links to the exact private
thread. Record permission, send, open, deep-link resolution, and verified start.
Do not claim causality unless assignment is controlled, and do not respond to a
weak result by increasing frequency.

## BuildInPublic reporting format

For each experiment, publish only what is safe and decision-relevant:

1. Hypothesis.
2. Artifact or prototype.
3. Intended audience and channel.
4. Observed response with denominator and provenance.
5. Product decision or change.
6. Lesson and remaining uncertainty.

The initial log is in [build-in-public-log.csv](./build-in-public-log.csv).

