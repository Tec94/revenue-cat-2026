# Run 12 — final product and research decision brief

Observed and synthesized August 12, 2026. The builder approved Run 11 Option A:
prioritize RevenueCat Design criterion D1, keep Galaxy and OneSignal conditional,
and use the 1:58 demo storyboard with its documented replacement segment. This
brief closes the research sequence and does not reopen rejected concepts.

## Executive summary

**Recommendation: conditional go.** Build **Restart Thread** as a native Kotlin
and Jetpack Compose Android app. Its promise is: **“Speak where you are. Return
to one clear first step.”** The product lets a person preserve or reconstruct
the state of interrupted work, saves that thread locally before optional cloud
processing, drafts one evidence-linked next action, and leaves the user in
control of editing, confirming, and starting it.

The concept is coherent and buildable because C13 Reset Button and C14
Breadcrumb serve the same user, trigger, and core loop. Its strongest
differentiator is not voice capture or generic AI planning. It is the complete
chain from private, durable context to one grounded, inspectable, user-confirmed
restart. That chain naturally supports the primary **RevenueCat Design Award**.

Two secondary awards remain conditional. **Best App for Galaxy** stays only if
the same loop is live in Galaxy Store and passes physical purchase, adaptive,
fold, multi-window, and store-quality proof. **Keep Them Coming Back** stays
only if one user-requested OneSignal reminder is deployed and produces a safe
return to a verified Start. Neither secondary is part of the minimum viable
entry.

The evidence supports a build decision, not a demand or revenue claim. Research
shows a plausible interruption-recovery pain and a differentiated mechanism,
but no target-user study, behavioral pilot, price test, production purchase,
store acceptance, locked-surface result, or retention cohort exists yet. The
project may proceed only with early proof gates for store access, durable
capture, AI grounding, and RevenueCat purchase behavior.

## Final product thesis

Restart Thread treats interruption recovery as a **loss-of-state problem**, not
as a motivation deficit or a need for another task manager. A user should be
able to state what they were doing with almost no setup, trust that the capture
is safe before the network is involved, and later recover one truthful next
move without reconstructing the whole plan.

The one-sentence product promise is:

> **Speak where you are. Return to one clear first step.**

The positioning may explain the mechanism as “save the thought, verify the next
move, start again.” It must not promise ADHD treatment, improved health, or a
clinically effective intervention.

## Target user, trigger, job, and evidence

The first segment is **US adults who self-identify with ADHD, time blindness,
interruption sensitivity, or recurring trouble restarting work**. Diagnosis is
not required or recorded. The product remains useful to a wider interrupted-
work audience, but the initial research and usability recruitment stay narrow
enough to test one recurring job.

The trigger is a task or project that has lost momentum after an interruption,
context switch, pause, or failed attempt to resume. The job story is:

> **When** an interruption leaves me unsure where I stopped, **I want** to
> capture or quickly reconstruct the state and see one grounded first move,
> **so I can** restart without rebuilding the whole plan.

Current workarounds include planners, calendar entries, alarms, notes,
self-messages, task breakdown tools, timers, and body-doubling services. These
can preserve tasks or create motivation, but they do not consistently preserve
the reasoning state that made the next action make sense. Rich context-memory
products exist, but they introduce broader capture, surveillance, desktop, or
knowledge-management scope.

The evidence is **medium**, not measured demand. Run 4 found recurring direct
user language about resuming, transitions, time blindness, and reconstructing
work. Run 6 found that generic “just start,” AI microsteps, focus gardens,
timers, and forgiving streaks are crowded and should not be treated as the
differentiator. Interruption research and current substitutes support the
mechanism, but no Restart Thread interviews or observed adoption exist.

## Differentiation and product boundary

The sharp difference is **state restoration with provenance**. Restart Thread
connects the user's own capture to the proposed action through the Direct
Trace-back Connector. The AI must show what in the capture supports the action;
the user can inspect, edit, or reject it before Start.

The product is not:

- a general task manager or calendar;
- an autonomous AI planner;
- a health, therapy, or ADHD-treatment product;
- a continuous desktop-surveillance or memory system;
- a body-doubling network, stranger-matching service, chat, or social feed;
- a streak, score, garden, collectible, or guilt-based gamification system; or
- a partner-coordination product. C15 Start Together remains outside the MVP.

## Awards and exact evidence strategy

The award strategy has one primary and two conditional secondary
non-influencer awards. All three use the same audience, recovery loop, and
working build. No Influencer Award is selected.

### Primary — RevenueCat Design Award

The primary entry must make D1 Innovative ideas observable before relying on
visual polish. The visible innovation is the combined local-save-first capture,
grounded evidence link, editable first action, human-confirmed Start, and
deterministic fallback. D2 Aesthetics is the Forward Thread system applied to
that behavior: paper, ink, editorial red, the large present-state dot, dotted
context line, arrow-forward mark, tactile controls, purposeful motion, and an
equivalent reduced-motion state.

### Conditional secondary — Best App for Galaxy

Galaxy remains natural only while it improves the same recovery flow. It must
show a live US Galaxy Store listing, an actual RevenueCat purchase and restore
on physical Galaxy hardware, state continuity across fold, unfold, rotation,
and multi-window, and polished Galaxy-specific metadata and assets. Generic
locked entry is shown only if the physical spike proves it.

The rules assign 20% of the category score to Galaxy optimization, including
device-specific behavior and store quality. The remaining 80% uses the
otherwise applicable standard criteria, but their exact decomposition and tie
order are not published. The brief does not invent them.

### Conditional secondary — Keep Them Coming Back

OneSignal remains natural only as one user-requested reminder for an action the
user already confirmed. Implementation proof includes scheduling, stored
message ID, state-aware suppression, safe stale-link recovery, and exact-thread
resolution. User value is a later app-owned verified Start, not a send,
delivery, or click. If only delivery evidence exists, remove the award.

The exact criterion rows, observable proof, demo timestamps, and removal gates
are in [rubric-evidence-map.csv](./rubric-evidence-map.csv).

## Platform decision

The approved ship platform is **native Kotlin and Jetpack Compose on Android,
targeting API 36**. Use one Gradle project with Google Play and conditional
Galaxy product flavors. Android is the only pre-deadline product scope. iOS and
macOS remain post-submission follow-ons.

This is the smallest credible implementation path because the differentiating
work is Android recording, foreground-service, widget, keyguard, adaptive,
fold, multi-window, purchase, and accessibility behavior. Native Android also
fits the builder's Windows test environment and avoids adding a cross-platform
runtime plus native bridges before September 30. Capacitor, React Native,
Kotlin Multiplatform, SwiftUI, iOS, and macOS are rejected from the 2026 ship
scope, not rejected forever.

## Smallest launchable core loop

The must-ship loop is one end-to-end promise with safe alternatives:

1. The user enters from the app, text, Share, app shortcut, or a proven quick
   surface.
2. The user speaks for up to 60 seconds or types the interrupted state.
3. The app commits the capture to encrypted app-private storage and shows
   **Saved on this device** before optional cloud work.
4. With separate consent, transcription and grounded drafting run through one
   thin server boundary.
5. The ready state shows **You said**, one editable **Start here** action, no
   more than three later steps, and **Why this?** evidence.
6. The user inspects, edits or confirms, then taps **Start**.
7. Offline, denied, or failed cloud paths retain the saved thread and offer the
   deterministic three-question reset: what still matters, what blocks it, and
   one next action.

Success is `verified_restart_started`. Recording, generating a draft, opening
the app, receiving a push, or starting checkout does not count as recovery.

Explicit launch non-goals are accounts, cross-device sync, team spaces,
partner activation, stranger matching, public profiles, chat, video, multiple
AI providers, desktop surveillance, automatic project ingestion, referrals,
trials, lifetime products, ads, streak pressure, advanced game systems, and an
Apple client.

## Experience and recovery journey

The journey protects the value moment from setup, monetization, and permissions.
Every permission and offer follows a user action that explains why it is useful.

### Acquisition and onboarding

The store page shows the interruption, voice or text capture, grounded first
action, local durability, and one real failure-recovery state. First launch
offers a disposable example or a first thread. It does not require an account,
paywall, notification permission, microphone permission, or cloud consent.

Microphone permission appears after the user chooses voice. Cloud processing
consent is separate and states what is sent, why, who processes it, and the
current retention policy. Quick-surface setup is offered after first value or
when the user explicitly asks for it.

### Value moment

The memorable moment is the Direct Trace-back Connector: opening **Why this?**
draws or reveals the dotted relationship between the first action and the
specific captured words that support it. The action remains editable. Tapping
Start resolves the thread forward with restrained motion and tactile feedback.

### Retention

Retention comes from the next interruption and from returning to the same saved
thread, not from artificial daily use. The Now screen shows one active thread;
history remains private and searchable. After a verified Start, a user may
request one reminder. Denial removes no product value, and every reminder is
suppressed after start, completion, replacement, deletion, or opt-out.

### Monetization

M1 Value-first Pro keeps unlimited local voice and text capture, Share entry,
playback, deterministic recovery, inspect, edit, export, and delete free. Free
users receive a remotely configurable sample of cloud recovery. Seven drafts
per rolling 30 days is a launch hypothesis, not a proven fair boundary.

Pro adds ongoing cloud transcription and grounded AI recovery. Initial US price
hypotheses are **US$4.99 monthly** and **US$39.99 annually**. There is no launch
trial, lifetime product, or ad. The paywall appears only after the first verified
value or before a later cloud request beyond the allowance. Dismissal,
cancellation, grace, and expiry never remove owned threads or local recovery.

### Failure and recovery

Network, transcription, model, evidence, purchase, and reminder failure all
return to an owned local thread. Microphone denial exposes text. Unsupported
locked entry unlocks into a prepared recorder. Source loss exposes a neutral
missing-source state. A stale AI draft requires review. Purchase cancellation
returns to free value; restore remains user-triggered and visible. Deleted or
replaced reminder targets open a neutral recovery screen without private text.

## Screen inventory

The accepted Run 7 inventory contains 31 surfaces. Implementation may combine
screens in navigation, but it must preserve the named states and recovery paths.

| Group | Surfaces | Launch responsibility |
|---|---|---|
| Promise and onboarding | S00 Store; S01 First launch; S02 Guided example | Explain the same capture-to-restart promise and allow value before setup |
| Capture and durability | S03 Capture editor; S04 Save confirmation; S09 Share receiver | Accept voice, text, and shared context; prove local save; reject unsupported or oversized inputs safely |
| Current work and deterministic recovery | S07 Now empty; S08 Now active; S11 Return Card; S12 Matter; S13 Blocker; S14 Action | Keep one current thread primary and provide the non-AI reset path |
| Voice and AI | S24 Voice/AI setup; S25 Locked control; S26 Recorder; S27 Saved/processing; S28 AI review; S29 Transcript/evidence; S30 AI privacy/deletion | Separate local save, cloud consent, processing, provenance, correction, and deletion |
| External return surfaces | S05 Cue rationale; S06 System permission; S10 Widget | Request only contextual permissions and expose no private locked content |
| Records and data | S15 Thread detail; S16 All threads; S17 Recently deleted | Edit, find, restore, export, and delete owned information |
| Billing and settings | S18 Paywall; S19 Purchase outcome; S20 Restore; S21 Plan status; S22 Settings | Implement M1, lifecycle recovery, privacy controls, and account-free value |
| Shared recovery | S23 Error/recovery | Preserve work and provide retry or safe fallback for every critical failure |

## Visual, motion, haptic, and sound direction

The locked direction is **H2 Forward Thread** with **I2-V1 Direct Trace-back
Connector**. A4 supplies the dominant paper, ink, and editorial-red system. A2
supplies the large present-state dot and dotted evidence thread. A4's arrow
communicates moving ahead, A3 supplies restrained tactile depth for primary
controls, and A5 supplies the corrected single-state lock-surface treatment.

Use semantic light, dark, and increased-contrast roles. Pair every color state
with text, shape, or iconography. Android uses Roboto or the active system
family for body text; a display face is permitted only for tested editorial
headings. Preserve 48 dp targets, scalable `sp` text, logical focus, TalkBack
semantics, system insets, and one-handed access.

Motion must explain cause, state, hierarchy, provenance, or progress. Prototype
families are 80–120 ms for press response, 160–220 ms for local state change,
and 220–280 ms for short spatial transitions. Animations start from the current
state, accept interruption, and never block an action. Reduced motion uses a
static connector, instant state change, or short opacity crossfade.

Haptics are optional, causal, and paired with visible state for record start,
local save, confirmation, and error. Sound is off by default, never plays while
the microphone is recording, respects device modes, and is never the only cue.

## RevenueCat model and event taxonomy

RevenueCat owns the paid access decision. Use one `pro` entitlement, one
`default` Offering, and monthly and annual packages mapped to store-specific
Play and Galaxy products. The app begins with an anonymous RevenueCat user and
no product account. CustomerInfo refresh, restore, webhook handling, grace,
expiry, cancellation, refund, and store management must preserve free and owned
content.

Judge access may use a server-side code that grants a time-bounded RevenueCat
entitlement. This is technically supported, but organizer acceptance as the
required promo-code route is unknown. Confirm it; otherwise provide an accepted
store-native free-access route.

The complete privacy-safe schema is in
[Run 9 event taxonomy](../Run-9/event-taxonomy.csv). Its controlling event
families are:

- acquisition: landing, waitlist, and later sanitized referral events;
- capture: intent, permission, record, local save, and local-save failure;
- processing: consent, transcription, draft request, completion, and failure;
- value: draft open, evidence open, edit, confirm, verified Start, and complete;
- data: export and deletion;
- billing: paywall, checkout, purchase, entitlement, restore, grace, refund,
  renewal, and expiry;
- optional reminder: soft prompt, permission, schedule, suppression, send,
  open, deep-link resolution, and verified Start; and
- Galaxy: physical purchase result and adaptive window-state change.

No event may contain audio, transcript, action text, free text, thread title,
source contents, health data, contacts, precise location, credentials, payment
data, or secrets.

The smallest useful dashboard has value funnel, return cohorts, monetization,
and reliability/notification panels. A1 is the primary activation metric: a
first opened draft reaches edit or confirm plus Start within 120 seconds. A2
diagnoses the full intent-to-Start funnel. R1 is the primary retention metric:
a second distinct verified restart within seven days. R3 measures D1 meaningful
same-thread or new-action return, R4 measures a second distinct restart within
30 days, and R2 remains a derived D7 union split into same-thread and distinct-
thread components.

## Architecture and dependencies

The app uses one Activity with Compose navigation and small package boundaries:
`ui`, `domain`, `data.local`, `data.remote`, `billing`, `platform`, and
`telemetry`. Use explicit construction rather than adding a dependency-
injection framework for the first release.

Room stores metadata and opaque identifiers. Audio, transcript, and derived
content live in encrypted app-private files. A non-exportable Android Keystore
key protects AES-256-GCM content. Protected vault files are excluded from Auto
Backup; export is explicit through the system file picker. Process-independent
state records distinguish recording, committed local save, queued processing,
ready draft, confirmed action, active, complete, deleted, and recoverable
failure.

A thin Cloudflare Worker and D1 metadata layer expose one versioned HTTPS
boundary. This owner-directed substitution was accepted after the Run 12 gate
and does not change the native Android client architecture. The client uses a
resettable install-scoped credential. The server applies allowance,
idempotency, validation, and provider policy. Workers AI is the proposed single
provider for bounded transcription and grounded drafting. The server does not
persist user content after the request. Direct provider secrets and RevenueCat
secret keys never enter the Android client. R2, KV, Queues, Durable Objects,
accounts, sync, and a provider router remain outside the first slice.

Cloudflare's Free Worker CPU limit makes the audio route a measured technical
spike rather than an assumed capability. The text path and local deterministic
recovery are not conditional on cloud voice. See the
[Cloudflare implementation update](cloudflare-backend-update.md).

OneSignal is absent from the must-ship architecture. Add it only after the core
slice is stable and the conditional award proof can be completed. Crashlytics
is opt-in and content-free; Play vitals and bounded server logs supply minimum
operational evidence. Feature flags can disable cloud samples, AI drafting,
locked entry, Galaxy-specific presentation, OneSignal, and experimental sharing
without blocking owned local recovery.

Critical external dependencies are Google Play Console, Samsung Seller Portal,
a physical Galaxy or qualified Remote Test Lab path, RevenueCat, Cloudflare
Workers, D1, Workers AI, and conditionally OneSignal. Store eligibility and physical
purchase proof are dependencies, not implementation details.

## Privacy, safety, accessibility, and policy contract

The release must preserve these hard boundaries:

- local durable save precedes optional cloud work;
- microphone permission and cloud-processing consent are separate and
  just-in-time;
- locked surfaces and generic notifications expose no private thread content;
- the AI labels its output, cites supporting segments, shows uncertainty, and
  never starts an action for the user;
- users can inspect, edit, export, delete, decline cloud processing, and keep
  using deterministic recovery;
- privacy notices name the actual processor, purpose, retention, deletion, and
  current provider controls;
- metadata avoids diagnosis, treatment, therapeutic outcome, or medical claims;
- purchases use store-localized products, a visible free path, clear recurring
  terms, Restore, Manage plan, grace, and respectful expiry; and
- screenshots, logs, notifications, analytics, and support artifacts use
  synthetic content and contain no secrets.

Critical-path accessibility requires correct name, role, state, heading, and
live-region semantics; TalkBack, Switch or Voice Access, keyboard where
relevant, 200% text, magnification, color independence, 48 dp targets, reduced
motion, captions, visual equivalents for haptics and sound, and a one-handed
critical path. Any blocking accessibility defect blocks the affected release.

## Validation and falsification thresholds

Validation uses technical spikes, a five-participant formative study, a seven-
day unprompted behavioral pilot, signed-build verification, and production
instrumentation. No result is implied before the test is run.

| Claim | Pass | Pivot | Stop, suppress, or kill |
|---|---|---|---|
| Promise and first action | 4/5 participants explain the promise and choose the correct first control | 3/5 | 2/5 or fewer |
| Prepared voice start | 4/5 begin unassisted within 5 seconds | 3/5 with one repeated repairable issue | 2/5 or fewer; retain text and prepared unlock fallback |
| Durable capture | 5/5 study captures and all 50 technical-spike commits survive | 4/5 only after an immediate fix and rerun | Any lost committed capture blocks release |
| Capture effort | Median 2 or lower on a 1-easy to 5-heavy scale | Median 3 | Median 4 or higher |
| AI identity | 4/5 recognize generated, editable output | 3/5 | 2/5 or fewer |
| Evidence grounding | At least 90% of factual statements have supporting segments; zero reversed negations | 75–89% with no critical error | Any reversed negation or below 75% suppresses AI |
| Return correctness | 4/5 confirm or edit and Start within 60 seconds of a ready draft | 3/5 with one repairable issue | 2/5 or fewer |
| Permission and purchase comprehension | 5/5 distinguish mic from cloud consent and understand owned/free access | 4/5 | 3/5 or fewer |
| Locked privacy | 5/5 tested states expose no private content | One nonprivate label issue | Any private exposure removes the surface and blocks release |
| Accessibility | Zero blocking critical-path defects; median SEQ at least 6/7 | One minor defect fixed and rerun; median SEQ 5 | Any blocker or median SEQ 4 or lower |
| Behavioral core | At least 50% of at least 20 genuine events across five users reach meaningful action within two minutes | 25–49% with one repeated repairable cause | Below 25%, or use occurs only because the study prompts it, kills the core |

The 60-second formative return test and the 120-second A1 product metric are
both retained. The first tests interface clarity under observation; the second
tracks the broader real product funnel after a draft opens.

## Build, release, learning, and submission milestones

The dates are owner targets derived in Run 10. They do not assert store-review
turnaround.

| Date | Required outcome |
|---|---|
| August 12 | Create the API-36 Compose project, provisional package ID, Play/Galaxy flavors, and local disabled-by-default Cloudflare foundation; owner creates store, RevenueCat, and Cloudflare account resources |
| August 13–16 | Prove durable capture and the truthful quick/locked entry path on Android and Galaxy |
| August 14–18 | Prove Play/Galaxy RevenueCat lifecycle and the bounded grounded-AI path; drop failed conditional claims |
| August 17–19 | Confirm applicable Play tester requirements, recruit the required cohort, and start the meaningful closed slice |
| August 19–25 | Complete encrypted local recovery, deterministic reset, grounded review, Start, history, export, delete, offline, and failure states |
| August 23–28 | Complete M1, privacy-safe events, Forward Thread, accessibility, adaptive layout, and five-user formative study |
| August 26–September 2 | Freeze first Galaxy candidate; iterate the closed test; complete privacy, metadata, icon, screenshots, and G1–G3 evidence only when allowed |
| September 3–11 | Apply for Play production access when eligible; freeze and submit Galaxy September 8; submit Play when access exists |
| September 12–18 | Resolve store findings, collect real-user evidence, and remove unproven secondary paths; by September 18 one store must be in review or accepted |
| September 20–24 | Freeze dependencies and product; run Devpost intake September 22; target an accepted public US listing and judge install by September 24 |
| September 25–28 | Record the working-build demo, archive evidence, verify assets, and submit Devpost September 28 |
| September 29–30 | Verify public links, package, store access, video, categories, and assets; make blocking corrections only before the September 30 deadline |

## Two-minute demo and submission assets

The approved primary cut is **1:58**. It must show a signed build on the target
device and preserve the fallback edit when a conditional award fails.

| Time | Proof |
|---|---|
| 00:00–00:07 | Establish the interrupted-work problem |
| 00:07–00:15 | Show a truthful generic quick surface or unlock-to-prepared recorder |
| 00:15–00:29 | Speak, stop, and visibly commit **Saved on this device** |
| 00:29–00:38 | Show offline or controlled provider failure without losing the thread |
| 00:38–00:58 | Show You said, Start here, and the Direct Trace-back evidence link |
| 00:58–01:08 | Edit or confirm, tap Start, and show reduced-motion equivalence |
| 01:08–01:22 | Reach the later allowance boundary, show RevenueCat paywall, purchase, and active `pro` without hiding free value |
| 01:22–01:36 | If proven, show Galaxy posture/multi-window continuity and live listing; otherwise deepen core reliability proof |
| 01:36–01:47 | If proven, show the requested OneSignal reminder to verified Start; otherwise show restore and TalkBack traversal |
| 01:47–01:58 | Show only sourced evidence, then close on the Forward Thread mark and thesis |

The submission asset set includes the eligible public US store URL, package ID,
RevenueCat proof, working-device video, English captions and transcript, app
icon, required screenshots without device frames, truthful store metadata,
privacy policy, Data Safety disclosures, reviewer instructions, purchase and
Restore instructions, accepted judge-access route, award-specific paragraphs,
source links, BuildInPublic artifacts, and music, font, icon, illustration, and
trademark clearance. Public repository and license are included only if the
selected category or submission form requires them.

## Top ten risks, fallbacks, open questions, and kill criteria

These ten risks determine whether the conditional go remains credible. The
fallbacks preserve the primary loop wherever policy, platform, or sponsor proof
fails.

| Risk | Detection and fallback | Open question or kill criterion |
|---|---|---|
| 1. No eligible production store path | Verify Google account/test gate and Samsung seller status now; run Play and Galaxy paths in parallel | If no eligible public US store listing can exist before the deadline, the ordinary entry is a no-go |
| 2. Galaxy account, hardware, or purchase proof fails | Complete seller setup and physical purchase spike by August 18 | Drop Galaxy flavor and award; do not simulate billing or device proof |
| 3. Third-party locked voice is unsupported or unreliable | Test widget, notification, keyguard, and user-visible paths by August 16 | Remove no-unlock claim; use shortcut/home widget into a prepared recorder |
| 4. A committed capture is lost or corrupted | Atomic writes, process-death and interruption matrix, visible durable-save state | Any committed loss blocks the release until fixed and rerun |
| 5. AI invents context or reverses meaning | Grounding fixtures, cited segments, schema validation, user correction | Any reversed negation suppresses AI; deterministic recovery remains |
| 6. Cloud processing exceeds its bounded path | Measure latency, retry, cost, timeout, and idempotency by August 18 | Keep the saved thread and deterministic path; remove cloud promise until fixed |
| 7. Private content leaks through telemetry, locks, pushes, or assets | Allowlisted metadata, synthetic assets, redaction and locked-state tests | Any private locked exposure blocks release; disable the affected surface or telemetry |
| 8. Encryption, backup, deletion, or export fails | Keystore, backup exclusion, reinstall, deletion, and system-picker tests | Do not claim recoverable backup; block release for unreadable active data or incomplete deletion |
| 9. RevenueCat entitlement, restore, or judge access is inconsistent | Run Play/Galaxy lifecycle matrix and confirm organizer access route | Disable paid cloud requests if access is inconsistent; no working RevenueCat purchase makes the entry ineligible |
| 10. Solo scope, health claims, or conditional awards delay the core | Enforce must-ship traceability, general utility copy, and evidence-date cuts | Drop OneSignal, Galaxy, widget polish, and advanced motion before delaying the Design core; if the behavioral pilot is below 25% or prompted-only, kill the concept |

Open evidence questions remain: whether users create breadcrumbs without study
prompts; whether the grounded draft saves more effort than writing one step;
whether D7 recurrence supports subscription value; whether seven cloud drafts
is fair; whether users will pay the price hypotheses; whether the organizer
accepts the proposed judge entitlement; and what criteria form Galaxy's
remaining 80%.

## Evidence and uncertainty ledger

The complete ledger is in [source-ledger.csv](./source-ledger.csv). It preserves
the original URL or local artifact, observed date, source tier, current versus
historical or selected-specification status, claim type, confidence, and
limitation. No new broad research was performed for Run 12.

| Material area | Status | Confidence | Uncertainty |
|---|---|---|---|
| 2026 eligibility and award wording | Observed in current official rules and award pages | High for visible wording | Rules and process can change; Galaxy's remaining 80% is not decomposed |
| Interruption-recovery pain | Current qualitative user evidence plus research and workarounds | Medium | Segment prevalence, frequency, and switching behavior are unmeasured |
| Restart Thread differentiation | Current competitor and substitute comparison; analyst inference | Medium | Users may not create breadcrumbs or value provenance enough to switch |
| UX and visual direction | Builder-selected specification | High for the decision | No target-user or production-device result exists |
| Native Android architecture | Approved specification supported by official platform docs | Medium-high for feasibility | Integration, OEM, performance, and store results remain untested |
| M1 and prices | Builder-approved hypothesis informed by current competitor pricing | Medium-low for fit | No willingness-to-pay, conversion, renewal, or cost baseline exists |
| Validation thresholds | Prior accepted falsification contract | High for the decision rule | No study or behavioral result exists |
| Judge-visible story | Approved evidence matrix and 1:58 storyboard | High for coverage design | The working proof, store listing, metrics, and final assets do not yet exist |

## Contradictions and missing evidence

The final direction contains no unresolved product-definition contradiction,
but it contains important evidence gaps:

- Samsung documents first-party locked recording and several locked surfaces;
  it does not prove arbitrary third-party no-unlock capture. The claim remains
  conditional on a physical-device spike.
- The Galaxy category publishes a 20% optimization component but not the exact
  standard-criteria breakdown for the other 80%.
- RevenueCat granted entitlements support time-bounded access, but that does not
  prove the organizer will accept an app-issued judge code as the required promo
  route.
- The seven-draft allowance and US$4.99/US$39.99 prices are hypotheses, not
  user-validated limits or willingness-to-pay findings.
- The product uses self-identified ADHD-related pain as a recruiting lens while
  deliberately making no diagnostic or treatment claim.
- A1 may look healthy while users fail before the draft opens; A2 remains
  mandatory diagnostic coverage. R1 may miss same-thread continuity; R2, R3,
  and R4 preserve that coverage without becoming competing primary targets.
- No user, device, AI, purchase, store, accessibility, retention, or revenue
  result has been measured yet.

## Recommendation and gate resolution

The recommendation is **conditional go** because the evidence supports a
coherent problem, differentiated loop, native Android plan, proportional
RevenueCat boundary, and judge-visible Design story. It is not an unconditional
go because store eligibility, real-user behavior, durable capture, grounding,
and purchase lifecycle remain unproven and can still invalidate the entry or
the product thesis.

**Gate complete.** On August 12, 2026, the builder approved Option A and
authorized the conditional implementation. Begin the native Android vertical
slice and the three account and technical spikes. Automatically remove Galaxy,
OneSignal, no-unlock capture, or cloud AI when its documented gate fails while
preserving the RevenueCat Design core.

No research decision gate remains. The next required action is implementation
readiness: confirm the Google Play account and tester path, Samsung seller and
Galaxy-device access, create the API-36 project and store flavors, and execute
the durable-capture, RevenueCat purchase, and grounded-cloud spikes.

## Updated RESEARCH_STATE

This paste-ready state preserves the accepted decisions, rejected directions,
open proof gates, and next owner choice.

```yaml
RESEARCH_STATE:
  completed_run: 12
  rules_version_observed: "Official rules and award pages observed through August 11, 2026. Treat August 1 as the official start. Galaxy optimization is 20% of the category score; the exact remaining standard criteria are not publicly decomposed. Recheck living rules before submission."
  builder_constraints:
    team_and_skills: "Solo developer who owns development and marketing; AI-assisted implementation is acceptable."
    available_hours: "No fixed weekly cap supplied; milestones include debugging rework tests and store-review buffer."
    budget: "Prefer generous free tiers credits and existing subscriptions; paid services require evidence."
    eligible_platforms: "Android is locally testable on Windows; MacinCloud supports later Apple testing and deployment."
    developer_accounts: "One planned Google Play account and one planned Apple Developer account; active status is unconfirmed; Samsung seller status is unconfirmed."
    student_status: "Qualifying academic email available."
    sponsor_employee_status: "No sponsor employment or conflict reported."
    geography_and_store_access: "United States; app can be distributed in the United States."
    backend_and_ai_tolerance: "Thin hosted backend and one AI provider are acceptable; prefer few touchpoints and free tiers."
    regulated_or_sensitive_domains_to_avoid: "No clinical treatment framing; privacy safety and review evidence remain hard gates."
  selected_primary_award: "RevenueCat Design Award"
  allowed_secondary_awards:
    - "Best App for Galaxy, only after live Galaxy listing, physical purchase, adaptive behavior, and store-quality proof."
    - "Keep Them Coming Back, only after a deployed OneSignal campaign produces a safe return to an app-owned verified Start."
  selected_concept: "Restart Thread: C13 Reset Button plus C14 Breadcrumb; C15 remains outside the MVP."
  shortlisted_concepts:
    - "Restart Thread selected for implementation."
  selected_opportunity_territories:
    - "T2 capture-to-usable-artifact workflows for solo work."
    - "T3 small-group utility with recipient-side value."
    - "T4 adaptive cross-device field workflows."
    - "T5 respectful return loops for intermittent goals."
  selected_problems:
    - "Primary: recurring loss of work state after interruption, especially for adults with ADHD-related restart difficulty."
  product_promise: "Speak where you are. Return to one clear first step."
  target_user: "US adults self-identifying with ADHD, time blindness, interruption sensitivity, or recurring restart difficulty; diagnosis is neither required nor treated."
  selected_ux_direction: "Instant Voice Thread: voice, text, or Share entry; local durable save; optional grounded AI; You said plus one editable Start here; Direct Trace-back evidence; user-confirmed Start; deterministic fallback."
  selected_visual_direction: "H2 Forward Thread with paper, ink, editorial red, large present-state dot, dotted context line, forward arrow, tactile controls, corrected generic lock surface, and I2-V1 Direct Trace-back Connector."
  selected_monetization: "M1 Value-first Pro: free owned local recovery, remotely configurable cloud sample, Pro monthly and annual hypotheses, no launch trial, no ads."
  selected_metrics:
    activation_primary: "A1 draft open to edited or confirmed first action plus verified Start within 120 seconds."
    activation_diagnostic: "A2 full recovery intent-to-verified-Start rate and elapsed-stage distribution."
    retention_primary: "R1 second distinct verified restart within seven days."
    retention_diagnostics:
      - "R3 D1 meaningful same-thread or new-action return."
      - "R4 second distinct verified restart within 30 days."
    retention_coverage: "R2 D7 union, reported with same-thread and distinct-thread components."
  selected_platform: "Native Kotlin and Jetpack Compose Android API 36; one Gradle project with Play and conditional Galaxy flavors; Apple post-submission."
  selected_backend: "Encrypted device-owned content; thin Cloudflare Worker and D1 operational metadata; Workers AI as the proposed bounded provider; no server content persistence; cloud voice conditional on measured Free Worker CPU."
  run_11_gate_status: "Option A approved by builder on August 12, 2026. D1 is the evidence priority; Galaxy and OneSignal remain conditional; use the 1:58 storyboard and replacement segment."
  run_12_recommendation: "Conditional go."
  run_12_gate_status: "Option A approved by builder on August 12, 2026. Native Android implementation is authorized under the documented automatic cut rules."
  rejected_directions:
    - "C15 partner-start loop in the MVP."
    - "Clinical or treatment framing."
    - "Generic AI planning, task-manager expansion, stranger matching, chat, video, public feed, streak pressure, or award-only features."
    - "Capacitor, React Native, Kotlin Multiplatform, iOS, or macOS before the 2026 deadline."
    - "Accounts, cross-device sync, referral rewards, ads, trials, lifetime products, multiple AI providers, and desktop surveillance in launch scope."
    - "Unproven no-unlock, Galaxy, OneSignal, traction, performance, or judge-access claims."
  accepted_evidence:
    - "Run 11 Option A approved by the builder."
    - "Run 12 Option A conditional go approved by the builder on August 12, 2026."
    - "Run 6 Restart Thread C13+C14 recommendation and falsification rules."
    - "Run 7 Instant Voice Thread architecture, 31-surface inventory, accessibility contract, and testing thresholds."
    - "Run 8 H2 Forward Thread and I2-V1 Direct Trace-back selection."
    - "Run 9 M1, A1/A2, R1/R2/R3/R4, and G1-G3 decisions."
    - "Run 10 native Android Option A, vertical slice, risk register, three spikes, and dated critical path."
    - "Run 11 evidence matrix, validation plan, 1:58 demo, and submission checklist."
  unresolved_questions:
    - "Will at least one eligible public US store path be active before the deadline?"
    - "Will durable capture, locked entry, grounding, Galaxy billing, RevenueCat lifecycle, accessibility, and store proof gates pass?"
    - "Will users create threads without prompts and meet the behavioral-core threshold?"
    - "Will D7 recurrence and willingness to pay support M1 and its price and allowance hypotheses?"
    - "Will the organizer accept the proposed RevenueCat judge-entitlement route?"
    - "What exact standard criteria form Galaxy's remaining 80%?"
  next_decision: "No research gate remains. Confirm store-account and device prerequisites, then execute the three technical spikes and native Android vertical slice."
```
