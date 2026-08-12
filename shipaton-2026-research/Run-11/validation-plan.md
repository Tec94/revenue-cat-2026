# Run 11 validation and instrumentation plan

Restart Thread needs evidence for product value, safety, accessibility, billing,
and the selected awards. A polished prototype is not enough. This plan separates
formative evidence, behavioral evidence, release verification, and judge-facing
proof so that one type of result is not presented as another.

## Evidence phases

The release sequence follows the approved Run 10 critical path. Dates are owner
targets, not claims about store review time.

| Phase | Timing | Question | Evidence | Decision |
|---|---|---|---|---|
| Technical truth | Aug 13–18 | Can capture, local save, AI grounding, Play billing, and Galaxy billing work as claimed? | Physical-device traces, failure matrix, sandbox purchases, grounded-output fixtures | Remove any claim or conditional award whose dependency fails |
| Formative study | Aug 24–28 | Can five target users complete and understand the critical path? | Moderated task records, first actions, timings, errors, ratings, and consented recordings | Pass, revise, or stop by the accepted Run 7 thresholds |
| Closed-test pilot | From Aug 19 after a usable slice exists | Does the behavior occur without a moderator prompting each recovery? | At least 20 genuine interruption-and-return events across the five-person pilot | Use the accepted 50% pass, 25–49% pivot, and below-25% kill bands for the pilot outcome |
| Release verification | Before each store candidate | Does the signed build preserve privacy, access, purchase, restore, offline, and adaptive behavior? | Automated tests plus clean-install physical-device evidence | Block the affected store candidate until the critical scenario passes |
| Post-launch learning | After a public US listing | Which acquisition, activation, return, payment, and reminder paths deliver value? | Privacy-safe product events, RevenueCat lifecycle data, store data, and conditional OneSignal reports | Compare cohorts and versions; change one bounded hypothesis at a time |
| Submission proof | Sep 22–28 | Can a reviewer see every entered criterion without installing the app? | Evidence matrix, 1:58 device demo, screenshots, listing, testing instructions, and sourced metrics | Omit an award or claim whose proof remains conditional or unknown |

## Formative measures

The full protocol is in
[formative-study-protocol.md](./formative-study-protocol.md). These thresholds
were already accepted in Run 7 and remain the decision contract.

| Measure | Definition | Pass | Pivot | Stop or fail |
|---|---|---:|---:|---:|
| Promise comprehension | Describes interruption capture plus an editable drafted first action | 4/5 | 3/5 | 2/5 or fewer |
| First action from entry | Correct first control from the store promise or entry screen | 4/5 | 3/5 | 2/5 or fewer |
| Voice start | Prepared recording begins unassisted within 5 seconds | 4/5 | 3/5 with one repeated repairable issue | 2/5 or fewer |
| Durable save | Committed capture survives before cloud processing | 5/5 | 4/5 with an immediate fix | Any lost committed capture |
| Capture effort | Median rating on a 1-easy to 5-heavy scale | 2 or lower | 3 | 4 or higher |
| AI identity | Recognizes the output as generated and editable | 4/5 | 3/5 | 2/5 or fewer |
| Evidence grounding | Draft facts supported by cited transcript segments | At least 90%; no reversed negation | 75–89%; no critical error | Below 75% or any reversed negation |
| Resume correctness | Confirms or edits, then starts within 60 seconds | 4/5 | 3/5 with one repeated repairable issue | 2/5 or fewer |
| Permission comprehension | Distinguishes microphone permission from cloud consent and continues after denial | 5/5 | 4/5 | 3/5 or fewer |
| Locked privacy | No private content appears on the locked surface | 5/5 tested states | One nonprivate label issue | Any private-content exposure |
| Data and purchase comprehension | Owned threads remain available after dismiss, cancel, grace, or expiry | 5/5 | 4/5 | 3/5 or fewer |
| Critical-path accessibility | Task-blocking defect count | 0 | One minor defect fixed and rerun | Any blocking defect |
| Single Ease Question | Median after capture and return on a 1-hard to 7-easy scale | 6 or higher | 5 | 4 or lower |

Do not average these measures. Speed cannot compensate for lost content,
private lock-screen disclosure, unsupported AI output, an inaccessible path, or
an incorrect entitlement.

## First-action and interaction evidence

Before testing, use the hypotheses in
[attention-map-hypotheses.csv](./attention-map-hypotheses.csv). They are
predictions, not gaze or interaction data.

With separate research consent, the study build may record a random study
session ID, task ID, screen ID, control ID, normalized tap coordinates,
timestamp from task start, input mode, result, error class, and assistance code.
It must not record audio, transcript, action text, source content, notification
content, contact data, or a stable device identifier.

After the study, report:

- the first control used on each critical screen;
- time to that first action;
- wrong controls, backtracks, and facilitator help;
- aggregate control sequences and normalized tap density; and
- whether the observed path supports or contradicts the prediction.

Call the result an **observed first-action and interaction map**. Do not call it
an eye-tracking, fixation, or attention heatmap. Participants who decline
interaction logging may still join; use facilitator timestamps and exclude them
from coordinate-based denominators.

## Product metrics and funnels

The controlling event definitions remain in
[Run 9's taxonomy](../Run-9/event-taxonomy.csv). Run 11 adds purpose, evidence
owner, and validation status in
[instrumentation-matrix.csv](./instrumentation-matrix.csv).

### Activation

**A1 primary:** among opened recovery drafts, the proportion followed by a
user-confirmed or edited first action and `verified_restart_started` within two
minutes. A1 proves the complete value handoff rather than an app open.

**A2 diagnostic:** among `recovery_intent_started` events, the proportion that
reach `verified_restart_started`, plus elapsed time. Segment it by voice, text,
Share, widget, in-app, offline state, permission result, and app version. A2
locates loss before the draft and prevents A1 from hiding entry or processing
failure.

### Retention

**R1 primary:** D7 second distinct verified restart. The later restart must
belong to a different recovery thread from activation.

**R2 derived coverage:** D7 meaningful return union. Report same-thread progress
and distinct recovery as separate components; never let the union hide which
behavior occurred.

**R3 diagnostic:** D1 meaningful return through a verified start or completion.

**R4 diagnostic:** D30 second distinct verified restart.

R1 remains primary, but R2 is not abandoned. Together, R1–R4 reveal immediate
continuity, recurrence by day seven, and longer-horizon recurrence without
turning a session open into retention.

### Monetization

Report the sequence from post-value `paywall_viewed` through dismiss, checkout,
purchase result, entitlement change, restore, grace or billing issue,
cancellation, renewal, refund, and expiry. Join RevenueCat data by a pseudonymous
install or App User ID only where the consent and privacy policy permit it.
Never send task content or payment data in product analytics.

The approved seven-cloud-draft allowance is a remotely configurable hypothesis,
not a validated fairness boundary. Show the paywall only after verified value or
before a new cloud request beyond the current allowance. Existing content,
local capture, deterministic recovery, export, deletion, accessibility, and
restore remain available.

### Notifications

OneSignal send, confirmed receipt, and click are delivery diagnostics. The
product outcome is the app-owned `verified_restart_started` event on the intended
thread after the deep link resolves. Report reminder requested, scheduled,
suppressed, sent, received, opened, resolved, and verified start. Do not raise
message frequency when starts are weak.

### Smallest useful dashboard

Use one version- and cohort-filterable dashboard with:

1. acquisition source to store or landing conversion;
2. entry to local save to draft open to A1 and A2;
3. R3, R1, R2 split components, and R4;
4. paywall to checkout to entitlement plus restore and failure states;
5. reminder request to verified start, with delivery diagnostics beside it; and
6. reliability panels for data loss, crashes, ANRs, AI failure, latency, offline
   fallback, and content-free accessibility defects.

Every displayed metric needs a numerator, denominator, observation window,
app version, acquisition source when known, sample size, and observation date.
Do not put a metric in the demo until its provenance is archived.

## Post-launch decision rules

The first public cohorts establish baselines; Run 11 does not invent conversion
or retention targets without evidence. Use the following causal order.

| Signal | Interpretation check | Decision |
|---|---|---|
| A2 falls before local save | Entry, permission, capture, or durability friction | Repair the failing stage before changing AI, paywall, or growth |
| Local save is stable but draft-open falls | Latency, failure, ready-state, or deep-link problem | Improve processing fallback and return visibility |
| Draft-open is stable but A1 falls | Evidence, action quality, hierarchy, or Start friction | Review corrections and first-action tests; do not increase notifications |
| A1 is healthy but R1 is weak | First value may be real but not recurrent for the segment | Interview by observed behavior and test recurrence before changing price |
| R2 is healthy only through same-thread progress | The product supports continuity more than recurring interruption recovery | Report that result honestly; do not relabel it R1 |
| Paywall views rise while A1 falls | Monetization may be interrupting value | Restore the post-value boundary before testing copy or price |
| Purchases occur but restore, grace, or expiry fail | Entitlement implementation is unsafe | Block the affected release and fix lifecycle behavior |
| Reminder clicks rise without verified starts | Delivery works but the return experience does not | Fix timing, state, and deep link; do not raise frequency |
| Galaxy posture events rise without A1 or task benefit | Device-feature use is not proven value | Keep only continuity that serves the same core loop |

## Issue severity and release decisions

Severity follows contract impact, not participant enthusiasm or issue count.

| Level | Definition | Examples | Required action |
|---|---|---|---|
| S0 critical | Breaks safety, privacy, data, billing, or truthful submission proof | Private lock content; committed capture loss; reversed negation; wrong charge or entitlement; unrecoverable purchase; crash or ANR on the critical path | Stop the candidate, fix, rerun the exact scenario, and run a regression |
| S1 high | Prevents a critical task or informed choice without a safe equivalent | Voice and text both unavailable; misleading cloud consent; hidden paywall exit; inaccessible Start; unresolvable deep link | Block the affected release or award claim until the path passes |
| S2 medium | Adds meaningful recoverable friction or confusion | Repeated hesitation, wrong first action, unclear evidence connector, repairable focus order | Make the smallest bounded revision and rerun the affected task |
| S3 low | Isolated polish issue that does not change task outcome or understanding | Nonblocking spacing or wording defect | Record for the next polish pass; do not displace an open S0–S2 issue |

Frequency does not downgrade an S0 or S1. For usability measures, use the
accepted pass, pivot, and stop thresholds above. A compliment, stated feature
request, or isolated preference is not proof of a defect or demand.

## Accessibility verification

Test the complete path with TalkBack, Switch Access or Voice Access, external
keyboard where applicable, 200% scalable text, display magnification, reduced
motion, high-contrast or color-correction settings, one-handed use, portrait,
landscape, fold/unfold, and narrow multi-window.

Check names, roles, states, headings, traversal order, polite announcements,
custom actions, visible focus, 48 dp touch targets, color-independent meaning,
captions or transcripts for video, and static equivalents for the animated
trace connector. Automated Compose accessibility checks and semantics tests
supplement, but do not replace, manual assistive-technology tests.

## Performance, offline, failure, and purchase restoration

Run every scenario on a signed release candidate where the dependency applies.

| Scenario | Required observation | Failure response |
|---|---|---|
| Cold start to prepared capture | Macrobenchmark startup trace and visible ready state on target hardware | Keep the universal in-app or shortcut fallback if the quick surface is not dependable |
| Start, stop, and local commit | Capture survives process death, rotation, storage pressure handling, and relaunch | Block release on lost committed content |
| Offline after stop | Local content remains usable; deterministic recovery and retry are clear | Disable the cloud request, not the owned recovery path |
| Slow or failed transcription | One bounded retry, editable transcript path, and voice rescue | Remove unsupported cloud claims if the provider cannot meet the contract |
| Slow or failed draft | Saved state persists; deterministic first-step path remains available | Do not trap the user behind indefinite loading |
| Low-confidence or negated input | Evidence is visible and the user must confirm or edit before Start | Treat reversed negation as critical |
| App process death during purchase | Store and RevenueCat reconcile without duplicate charge or lost draft | Block the store candidate until idempotent recovery passes |
| Purchase cancel or failure | User returns to intact free value with clear status | Remove pressure or destructive state changes |
| Restore after reinstall | Restore finds the correct store purchase and refreshes `pro` | Fix identity and restore before submission |
| Grace, billing retry, expiry, refund | Access follows entitlement state while owned data and free recovery remain | Block release if content is withheld or access is wrong |
| Fold, unfold, rotation, multi-window | Recording, draft, evidence, and focus survive configuration changes | Remove the Galaxy optimization claim that is not proven |

Android Macrobenchmark supplies startup and frame-timing measurements; use a
physical target device for the submission evidence. Samsung Remote Test Lab is
useful for real-device coverage, but a remotely controlled device is not a
substitute for every physical purchase or locked-surface claim.

## Neutral interview and cancellation questions

Ask behavior-first interview questions before explaining the product:

- Tell me about the most recent interruption that was hard to resume.
- What did you do when you came back?
- What did you need to reconstruct, and what was still available?
- What part of the workaround felt like extra work?
- Where would speaking be unsuitable or inaccessible?
- Which part of this draft came from your capture, and which part did the app
  infer?
- What did you change before starting, and why?
- What would you want removed first if you deleted this recovery?

Cancellation must remain immediate and unblocked. Ask only optional questions:

- What changed between subscribing and cancelling?
- Which Pro capability did you use most recently?
- What did you expect but not receive?
- What will you use instead, if anything?
- Was there a particular moment that led to this decision?
- What, if anything, would make Pro worth reconsidering later?

Do not require an answer, hide the management link, or make a retention offer a
condition of cancellation.
