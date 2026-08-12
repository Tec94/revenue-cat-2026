# Run 7 — UX architecture, journey, and attention

Run 7 now recommends **Flow A — Instant Voice Thread** for Restart Thread. A
prepared Lock Screen control or widget starts a short voice note where the
platform permits it, the app commits audio locally, and AI asynchronously drafts
one grounded first action plus at most three later steps. Context + Voice remains
an alternate entry, and Voice Rescue handles interruptions that were not
captured. This is the strongest revised UX hypothesis, not a validated result.

The concept remains C13 Reset Button plus C14 Breadcrumb. AI is now a bounded
drafting mechanism inside that loop, not a general planner. C15 Start Together
is not in the MVP, onboarding, information architecture, retention loop,
paywall, or test-critical path.

The controlling revision is documented in
[voice-ai-revision.md](./voice-ai-revision.md). It supersedes the original
manual-capture flow comparison wherever the two conflict.

## Executive summary

- The selected concept has not yet cleared its Run 6 behavioral thresholds.
  This run turns it into an observable prototype and test plan; it does not
  relabel selection as validation.
- The new default lets a user speak a messy state immediately. The audio note
  becomes durable before transcription or AI begins; AI failure therefore never
  loses the user's thought.
- A no-unlock experience is conditional. Android keyguard widgets and
  microphone foreground-service rules provide a viable path on supported
  Android 16+ hosts. Samsung proves the experience with its own Voice Recorder,
  but third-party Galaxy behavior still needs a device spike. Apple provides
  Lock Screen controls and `AudioRecordingIntent`, but current locked iOS 26
  behavior also needs physical-device proof.
- Two newly found first-party product pages narrow differentiation. Focs already
  markets `context plus one next task`, while What Next describes saving and
  reopening exact desktop files and URLs. These are current vendor descriptions,
  not independent adoption evidence. Restart Thread must therefore win on the
  measured mobile interruption handoff—Android share target, local durability,
  one user-authored step, and rescue—not on the generic phrase `resume with
  context`.
- Revised Flow A scores 4.15/5 in the fixed analyst comparison. Context + Voice
  scores 3.95; Voice Rescue scores 3.45. Scores organize trade-offs and are
  neither user data nor judges' scores.
- The first useful capture can be one action: **Record a thread**. A 60-second
  voice limit, second-tap stop, generic locked status, and local-first save keep
  the interruption small. Text and Share remain equivalent alternatives.
- AI returns **You said**, one editable **Start here** action, up to three later
  steps, questions, assumptions, confidence, and transcript evidence. Nothing
  becomes active until the user confirms or edits the first action.
- No account, notification permission, paywall, project hierarchy, timer,
  streak, or ADHD questionnaire appears before the first saved thread. A short
  unlocked setup must precede locked microphone use and must separate microphone
  permission from consent for cloud AI processing.
- The product works from Now and the widget when notification permission is
  denied. A return cue is one user-scheduled message that deep-links to the
  exact thread; it never repeats because the user did not respond.
- Existing thread data remains readable and exportable after purchase
  cancellation, billing problems, or expiry. Purchase and notification states
  are independent of the local thread state.
- Accessibility acceptance criteria include 200% text scaling and reflow,
  TalkBack/VoiceOver semantics, 48 dp Android and 44 pt Apple targets,
  color-independent states, complete keyboard/back behavior, reduced motion,
  captions, optional haptics, and one-handed reach.
- The revised gate is UX-only: select Instant Voice Thread, keep voice and AI
  but require unlock, or keep voice while postponing AI. It does not authorize
  visual styling or final stack selection.

The complete specification is in [ux-blueprint.md](./ux-blueprint.md). The
moderated protocol and thresholds are in
[usability-test-plan.md](./usability-test-plan.md). The evidence trail is in
[source-ledger.csv](./source-ledger.csv), and the fixed flow comparison is in
[flow-scorecard.csv](./flow-scorecard.csv). The platform feasibility matrix is
in [locked-surface-feasibility.csv](./locked-surface-feasibility.csv).

## Run status and fixed boundary

The builder selected Run 6 Option A on August 10, 2026. That decision advances
Restart Thread into UX design; it does not supply interviews, observed tasks,
spontaneous capture behavior, payment choices, or a technical spike.

The fixed product thesis is:

> Preserve the thread of interrupted work, return to the relevant artifact,
> and start one feasible user-authored action without rebuilding a whole plan.

The target is an adult who experiences recurring loss of task state after
interruptions, including—but not diagnosis-gated to—people with ADHD or time
blindness. The launch claim is functional and nonclinical.

Primary award: **RevenueCat Design Award**. Conditional secondary awards:
**Best App for Galaxy** and **Keep Them Coming Back Award**. Both remain
conditional because they require the same loop to work on relevant devices and
through a respectful deployed campaign. Neither justifies a new persona, social
loop, or decorative feature.

The first version excludes:

- C15 invitations, contacts, recipient accounts, chat, video, or stranger
  matching;
- a task manager, project planner, calendar, or general knowledge system;
- autonomous AI priorities, uncited plans, or steps that become active without
  user confirmation;
- passive screen recording, automatic desktop surveillance, or background
  capture;
- streaks, points, pets, focus gardens, performance scores, or shame copy;
- medical, diagnostic, therapeutic, crisis, or guaranteed-performance claims;
- native macOS scope; the planned Apple-silicon Mac path remains compatible
  iPhone/iPad execution unless a later stack decision changes it.

AI may transcribe the user's voice and draft a bounded recovery plan. Every
factual plan item must cite transcript evidence; unsupported content must be an
explicit assumption or question. The app retains a local voice note and
deterministic reset when transcription, AI, consent, network, or quota is
unavailable.

## Method and source discipline

Exa was the primary discovery and full-text extraction system. The run used
query variations for Android share and notification behavior, adaptive Galaxy
layouts, Apple accessibility and purchase states, and current context-capture
experiences. Exa then fetched every material known URL used in the report.

Exa extracted all material pages except the body of Google's Android lock-screen
widget FAQ. Firecrawl was used once for that page and also returned a blocked
body shell, but it recovered official metadata. The FAQ claims were
cross-checked against official Android API pages and indexed passages. No
browser, screenshot, video, or vision fallback was needed. Product pages
describe current vendor positioning and available features; they do not measure
effectiveness, retention, paid conversion, prevalence, or product quality.
Platform and store documentation is treated as current official guidance or
policy observed on August 10, 2026. Research papers support mechanisms and
problem context, not the efficacy of Restart Thread.

Source tiers in the ledger are:

- **A:** primary research, official standards, platform guidance, store policy,
  or official sponsor documentation;
- **C:** current first-party product or support material;
- **D:** analyst inference.

Every material record identifies whether the evidence is observed, described,
measured, or inferred. No current interface is used as historical Shipaton
evidence.

## Adjacent experience research

The adjacent set covers five specific UX problems rather than five visual
identities to copy.

| Adjacent experience | UX problem examined | Current evidence | Transferable principle | What Restart Thread must not copy or assume |
|---|---|---|---|---|
| Apple Quick Notes and Reminders | Capture without leaving the current context; return to the source | Apple documents notes over another app, stored links/highlights, contextual resurfacing, capture from another app, widgets, and reminder cues | Preserve source context automatically; let the user confirm it; make the return link first class | Do not reproduce Apple's layout or imply equal system integration on Android/iOS; do not turn the thread into a general note |
| Google Keep | Make one current record and quick capture available on the Android home screen | Google documents single-note, collection, and quick-capture widgets plus timed reminders | Offer a single-current-thread widget and a separate quick capture; make the minimum widget useful | Do not show a note collection at the smallest size or treat a notification as guaranteed return |
| Todoist | Provide multiple low-friction entry surfaces and reversible task actions | Todoist documents add-task, task-list, productivity, and voice-capture widgets plus direct quick add | Match entry surface to the moment; keep completion/archive reversible | Do not inherit Karma, productivity goals, natural-language scheduling, or a full task model |
| Tiimo and Llama Life | Reduce decision density for people who find normal planners overwhelming | Vendor pages describe visual next-up/timer surfaces, widgets, and one-task-at-a-time focus | Keep `current` and `next` visible; show one active action; make time optional | Do not copy visual identity, AI planning, a daily schedule, timer-centered loop, or neurodivergent efficacy claims |
| Focs and What Next | Examine the closest current `restart with context` propositions | Vendor pages describe one selected task with context and automatic desktop context capture/reopen | The generic proposition is already occupied; Restart Thread needs a narrower, demonstrated mobile handoff and honest rescue | Do not claim novelty from `resume with context`; do not add rich notes, vaults, desktop automation, or a backlog to match feature breadth |

### Interaction principles extracted

1. **Capture should begin where the interruption happens.** Android's Sharesheet
   and a quick-capture widget are not conveniences around the product; they are
   part of the core mechanism.
2. **Incoming context is a draft, not truth.** Android guidance says the user
   should be able to confirm and edit shared data. Restart Thread previews the
   source and never executes, uploads, or trusts it automatically.
3. **One visible current item beats a miniature backlog.** The smallest widget
   and the Now screen show one current thread. A collection appears only after
   the user chooses All threads or has sufficient window width.
4. **The action remains user-authored.** Adjacent AI planners increase feature
   overlap and failure risk. The reset flow helps the user name a verb-led step;
   it does not infer the correct priority.
5. **Notification consent follows a chosen benefit.** A system prompt appears
   only after a real thread is saved and the user elects to set a cue. Denial
   leaves Now and the widget intact.
6. **Continuity is observable.** Android process death, fold/unfold, rotation,
   multi-window, and Galaxy DeX should preserve the exact draft, selected
   thread, and navigation location.
7. **Recovery is part of the core interaction.** Missing source access, stale
   state, absent next step, archive, deletion, purchase cancellation, and
   notification denial all have durable nonshaming paths.

### Late competitive finding

Run 7 found two close first-party product pages that were not part of the Run 6
red-team evidence set.

- **Focs** says it keeps a full list nearby while showing one task and context,
  and explicitly positions itself as built for restart.
- **What Next** says a desktop hotkey saves file, URL, app, screenshot, and
  reminder context, then reopens the exact source.

Observed: these propositions are close. Unknown: whether the products are
shipped in all stated forms, have material adoption, work reliably, or satisfy
the same mobile interruption segment. Inferred: Restart Thread's defensible
wedge must be behaviorally narrower—mobile share-to-breadcrumb-to-action,
local/offline durability, under-30-second capture, honest no-step recovery, and
measured resumption—not a broad notes, vault, timer, or task-list bundle.

This is a differentiation warning, not a reason to copy either product. It is
also a new Run 8 research obligation if Flow A advances.

## Platform and accessibility constraints

The following are design inputs, not later engineering polish.

### Android and Galaxy

- On Android 16+ hosts that expose AOSP lock-screen widgets, Restart Thread can
  publish a keyguard-capable widget. A tap can enter a recorder activity that
  uses `showWhenLocked`; widget interaction is an explicit foreground-service
  exemption for while-in-use microphone access after `RECORD_AUDIO` is granted.
- The app must run one unlocked setup before promising locked capture. That
  setup explains microphone use, obtains permission, lets the user separately
  enable or reject cloud transcription/AI, and verifies the device's quick
  surface end to end.
- Samsung's native Voice Recorder demonstrates direct lock-screen recording,
  and Galaxy supports lock-screen widgets, the Now Bar, and Side-button
  shortcuts. These do not prove arbitrary third-party no-unlock behavior across
  models, regions, and One UI versions. The Galaxy promise remains conditional
  on a physical-device matrix.
- A microphone recording that continues outside a visible activity needs the
  correct foreground-service type, permissions, persistent system indication,
  safe interruption handling, and immediate local commit on stop.
- Receive only supported MIME categories. Validate size, type, and access;
  process binary content off the main thread; show a recognizable receiving
  surface; let the user confirm or edit.
- Store the thread locally before acknowledging save. Critical reads, capture,
  widget return, and reset work offline.
- Persist committed thread data separately from transient Compose UI state.
  Restore draft input and navigation after configuration change or process
  recreation.
- The widget is useful at its minimum size, supports empty/loading/error states,
  has accurate preview assets, resizes, and refreshes after a thread action.
- Use current window size classes. Compact windows show one pane; medium and
  expanded widths can show All threads and selected detail together.
- Fold/unfold, multi-window, freeform windows, and DeX preserve task, state, and
  location. A Galaxy submission also needs physical or Remote Test Lab QA,
  successful sharing/back/orientation behavior, accurate listing assets, and a
  proven purchase path.
- Predictive back previews the correct destination. Canceling the gesture does
  not discard fields or change the selected thread.

### iOS, iPadOS, and compatible Mac

- The preferred Apple primitive for one-tap voice is a Lock Screen or Action
  button **control** backed by `AudioRecordingIntent`, not a passive accessory
  widget. The system displays a recording indicator. The control's state and
  content must use authentication and privacy redaction appropriately.
- Official APIs establish intended capability, but current developer reports
  show locked iOS 26 audio-session failures in some configurations. Ship only
  after a physical-device start, stop, screen-off continuation, interruption,
  permission, and authentication spike. The fallback opens the minimal recorder
  after unlock.
- Apple on-device Speech recognition is optional per device and language. Check
  support before requiring it; otherwise save audio and use the user's chosen
  remote-processing or manual path.
- The iOS second release uses a share extension, widgets, local notifications,
  Dynamic Type, VoiceOver, and Apple purchase states to support the same loop.
- The experience adapts to widget family and window context. It does not clone
  Android navigation or promise a native Mac menu-bar/desktop capture product.
- Notification content is concise, valuable, nonrepetitive, and private. A
  complex reset belongs in the app; a simple **Open thread** action may appear
  in the notification.
- Apple-silicon Mac compatibility requires complete keyboard, focus, resizable
  window, and pointer behavior even though native macOS is not a first-version
  promise.

### Accessibility floor

- Text reflows through at least 200% scaling; no required horizontal panning or
  fixed-height clipping.
- Normal text contrast is at least 4.5:1; large text and essential control
  boundaries at least 3:1. Color never carries a state alone.
- Touch targets are at least 48 dp on Android and 44 pt on Apple.
- TalkBack and VoiceOver receive purpose, role, state, error, and durable success
  announcements. Labels persist outside placeholders.
- Keyboard, switch, Voice Control, system Back, and predictive back complete the
  critical path. Gestures have labeled alternatives.
- Reduced motion replaces spatial transformation with a short opacity change or
  no motion. Haptics and sound supplement visible/spoken feedback and can be
  disabled.
- Primary actions remain reachable one-handed and clear of keyboard, safe area,
  navigation, and gesture insets.

## Revised end-to-end user-flow options

The controlling options now share one voice-thread data model and one grounded
AI contract. They differ in what evidence exists when the voice is recorded.

- **A — Instant Voice Thread:** Start from a prepared locked or unlocked voice
  surface, speak, stop, leave, and later confirm one AI-drafted first action.
  This is the recommendation.
- **B — Context + Voice:** Share the source first, speak the state, and let AI
  ground the draft in both. This is an alternate entry to A, not another
  product.
- **C — Voice Rescue:** Speak after context has already been lost. AI presents
  a cautious state hypothesis, a first action, and questions. This is the
  fallback when no breadcrumb exists.

The full steps, AI schema, privacy boundary, locked-state behavior, and
falsification thresholds are in
[voice-ai-revision.md](./voice-ai-revision.md).

## Superseded baseline flow details

The following manual-capture options preserve the pre-revision reasoning. They
do not control the current decision gate.

### Baseline A — Capture-first handoff with rescue

**Thesis:** Preserve state before it decays; use reset only when capture was
missed or the state changed.

- **Acquisition and store expectation:** “Return to interrupted work without
  rebuilding the whole plan.” Screenshots show source-linked capture, focused
  return, and source handoff.
- **First launch and onboarding:** One value screen, then a disposable
  20-second example or a real first thread. No account, category setup, or
  permission.
- **Permission choreography:** The system prompt appears only when the user
  chooses a return cue after a durable save. Soft copy explains the exact cue
  and an equal no-notification path.
- **First input and time to value:** Enter from Share, widget, shortcut, or app.
  Confirm source, write `Where I stopped`, and write `Next visible step` or
  choose `I’m not sure yet`. Target: useful save in 30 seconds.
- **Primary flow and memorable moment:** Shared artifact → compact capture →
  saved Return Card → widget/cue → exact Return Card → **Open source and start**.
  The memorable interaction is the capture compressing into the future card,
  then reappearing with the same source and one action.
- **Feedback, edit, undo, and recovery:** Durable save precedes feedback. Drafts
  survive back/process death. Source can be replaced. Archive/delete have
  persistent recovery. Missing/stale/no-step records enter Reset without losing
  history.
- **Repeat and re-engagement:** The user repeats from contextual system entry,
  not a daily dashboard. One selected cue or the current-thread widget returns
  them. No streak or repeated nonresponse push.
- **Paywall and purchase states:** No paywall before first value. Trigger at the
  fourth active thread or a labeled Plus feature. Preserve draft and data on
  dismiss, cancel, retry, expiry, and restore. Cancellation remains active
  through the paid period.
- **Share or growth:** None in MVP. Demonstration can be shared by the builder,
  but the user's private thread has no social share action. C15 remains a
  separate prototype only.
- **Offline and system states:** Full capture/return/reset offline. Widget has
  active, empty, loading, unavailable, and resized states. Source handoff can
  partially succeed: context stays usable even when the artifact cannot open.

Main advantage: best source fidelity, strongest Android/Galaxy leverage, and
the clearest judge-observable transformation.

Main risk: many interruptions are unplanned, and capture can become another
obligation. The rescue branch mitigates but does not eliminate this adoption
risk.

### Baseline B — Rescue-first reconstruction

**Thesis:** Do not require a pre-interruption habit; help only when the user
already feels stuck.

- **Acquisition and store expectation:** “When you lose the thread, recover one
  next action.” Screenshots show a stale or absent plan becoming one step.
- **First launch and onboarding:** The first screen asks the user to bring one
  recently interrupted task. A sample reset is available.
- **Permission choreography:** A cue can be offered only after a reset is saved;
  the core does not depend on permission.
- **First input and time to value:** Three questions: what still matters, what
  blocks the next move, and what the user can open/write/send/decide in two
  minutes. Target is under 90 seconds, not 30.
- **Primary flow and memorable moment:** User arrives stuck → three questions →
  clutter collapses into one calm action → optional source added → start.
- **Feedback, edit, undo, and recovery:** Every answer is editable; the selected
  blocker is not a diagnosis; the user authors the step; the old state remains
  in history. Empty and canceled resets return safely.
- **Repeat and re-engagement:** User opens the app only after a failure or from
  an optional cue. This makes maintenance low but acquisition and habit
  frequency uncertain.
- **Paywall and purchase states:** The core reset stays free. Paid value is
  harder to justify without history, multiple recipes, or sync, all of which
  risk expanding scope.
- **Share or growth:** No natural share loop. C15 would change the persona and
  operational model and remains excluded.
- **Offline and system states:** Fully offline and technically simple. The main
  partial-success state is `one step saved without a source`; the main failure
  is a vague action that does not restore context.

Main advantage: smallest build and no pre-interruption compliance requirement.

Main risk: weaker differentiation from reset, AI micro-step, and one-task focus
apps; slower value; the app cannot recover source facts that were never saved.

### Baseline C — Persistent current thread

**Thesis:** Keep one active thread continuously visible so there is no separate
return event.

- **Acquisition and store expectation:** “Keep the one thing you’re doing and
  its next step always in reach.” Screenshots center the widget or persistent
  notification.
- **First launch and onboarding:** User chooses a current thread and places a
  widget or enables a persistent cue.
- **Permission choreography:** Notification education arrives earlier because
  the system surface is part of the proposition. Denial materially weakens the
  flow even though a widget fallback exists.
- **First input and time to value:** User enters current state, next step, and
  optional source, then selects the persistent surface.
- **Primary flow and memorable moment:** Active thread lives in widget or
  notification → tap/act → update the current state → return it to the surface.
- **Feedback, edit, undo, and recovery:** Current-state changes need explicit
  revision and stale detection. Suppressed notification, removed widget, reboot,
  or process death must not hide or revert the record.
- **Repeat and re-engagement:** Strong ambient presence, but high fatigue and
  habituation risk. A persistent surface can feel like pressure and conflict
  with the respectful-return thesis.
- **Paywall and purchase states:** The free persistent current thread is the
  whole proposition; monetizing more threads or multiple surfaces risks turning
  it into a conventional task manager.
- **Share or growth:** No natural share behavior. Public or partner presence is
  out of scope.
- **Offline and system states:** Local data works offline, but foreground or
  ongoing-notification behavior adds lifecycle, battery, channel, and OS-policy
  complexity. Empty/loading/permission-denied states are central rather than
  exceptional.

Main advantage: strongest ambient continuity and high platform visibility.

Main risk: notification-first dependence, fatigue, background complexity, and a
weak no-permission experience.

## Superseded baseline comparison

This comparison records the original manual-capture decision. The revised
voice-and-AI comparison below supersedes it.

The fixed comparison weights source preservation most heavily, then time to
value, low burden, and recovery. Platform leverage cannot compensate for weak
user value.

| Criterion | Weight | A Capture-first | B Rescue-first | C Persistent |
|---|---:|---:|---:|---:|
| Preserves exact interruption context | 20% | 5 | 3 | 4 |
| Time to first meaningful value | 15% | 5 | 3 | 4 |
| Low decision and maintenance burden | 15% | 4 | 3 | 4 |
| Works without notifications | 10% | 5 | 5 | 2 |
| Failure and recovery coverage | 15% | 5 | 4 | 3 |
| Android and Galaxy leverage | 10% | 5 | 3 | 5 |
| Solo-builder feasibility | 10% | 4 | 5 | 3 |
| Judge-observable design proof | 5% | 5 | 4 | 4 |
| **Weighted total** | **100%** | **4.75** | **3.60** | **3.65** |

Recommend **Flow A** with four fixed safeguards:

1. **Rescue is built in.** A missed or unplanned interruption is not a dead end.
2. **The next step can be unknown.** The user never fabricates certainty to
   satisfy a required field.
3. **Notification denial is first class.** Now and the widget support the whole
   loop without push.
4. **Capture stays narrow.** No tags, projects, priority, energy, duration,
   timer, or social invitation enters the default capture.

Flow B is the fallback if field tests show that users do not create breadcrumbs
without study prompts. Flow C should not advance unless repeated user evidence
shows that ambient presence is desired and notification denial does not break
the experience.

## Controlling revised comparison and recommendation

The revised model gives capture friction and context fidelity 20% each. AI
grounding and locked-surface feasibility receive 15% each. Offline fallback and
solo buildability receive 10% each; platform leverage and judge-observable proof
receive 5% each.

| Criterion | Weight | A Instant voice | B Context + voice | C Voice rescue |
|---|---:|---:|---:|---:|
| Capture/start friction | 20% | 5 | 3 | 5 |
| Context fidelity | 20% | 4 | 5 | 2 |
| AI grounding and user trust | 15% | 4 | 5 | 2 |
| Locked-surface feasibility | 15% | 3 | 2 | 3 |
| Works when offline or AI fails | 10% | 5 | 5 | 5 |
| Solo-builder feasibility | 10% | 3 | 3 | 4 |
| Android and Galaxy leverage | 5% | 5 | 5 | 4 |
| Judge-observable proof | 5% | 5 | 5 | 4 |
| **Weighted total** | **100%** | **4.15** | **3.95** | **3.45** |

Recommend A as the default prototype, B as an alternate source-rich entry to
the same thread, and C as the no-breadcrumb recovery state. This combination
doesn't stack three products: it uses one user, one voice-thread record, one AI
draft schema, and one measured outcome.

The recommendation has two independent proof gates:

1. **Locked capture:** A prepared control starts, indicates, stops, and commits
   audio without unlock on every platform/device for which the app makes that
   promise.
2. **AI grounding:** At least 90% of factual draft statements in the test set
   cite supporting transcript segments, with zero reversed negations.

Failure at the first gate removes the no-unlock promise on that platform; it
doesn't kill voice capture. Failure at the second gate reduces AI to a transcript
summary plus one suggestion or removes AI from the launch path.

## Recommended-flow artifact set

The original blueprint and the controlling voice/AI revision together contain
all nine requested outputs:

1. journey map with stages, goals, actions, questions, emotion hypotheses,
   friction, opportunity, and success signals;
2. information architecture and 31-surface inventory;
3. thread, onboarding, notification, and entitlement state transitions;
4. screen-by-screen critical-path interaction specification;
5. nine predicted attention maps explicitly labeled as hypotheses;
6. visual hierarchy and UX-writing system;
7. nudge inventory with suppression and dark-pattern checks;
8. Android, Apple, and cross-platform accessibility requirements;
9. a five-participant moderated usability script plus the seven-day behavioral
   pilot and falsification thresholds.

The revision adds locked-surface states, AI grounding, audio/privacy fallbacks,
and new falsification thresholds. The blueprint still supplies the broader
journey, purchase, accessibility, and instrumentation structure.

## Monetization state and trade-off

The free/paid boundary is still a hypothesis. Free includes local voice/text
capture, playback, deterministic recovery, three active threads, a widget, one
cue per thread, personal-data export, deletion, and recovery. AI needs a useful
free trial before the paywall, such as a small monthly draft allowance. Paid can
test more grounded drafts, unlimited active threads/history, and multiple
configurable cues. Encrypted sync is paid value only after it exists and has a
reliable privacy and conflict model.

Run 6 proposed $2.99 monthly, $24.99 yearly, and a $29 local-only lifetime
choice for testing. Run 7 does not select a price or subscription. Google policy
requires sustained recurring value for subscriptions; a local-only product may
fit a lifetime purchase better. The prototype must require a forced choice
after value rather than asking abstract willingness to pay.

AI introduces continuing compute cost and may support recurring value, but cost
alone doesn't justify a subscription. The pricing test must show that users pay
for trustworthy recovery drafts rather than voice storage they expect to be
free. Record audio duration, transcription cost, planning cost, retries,
latency, and correction rate without sending private content to analytics.

RevenueCat purchase requirements influence the UX:

- show localized full price, billing period, renewal, and cancellation terms;
- keep restore user-triggered and available in the paywall and Settings;
- handle pending, success, cancel, fail, already-owned, retry/grace, cancel-
  pending, expired, and restore states;
- preserve drafts and all existing data through every outcome;
- expose manage/cancel through the appropriate store path;
- do not assume RevenueCat Customer Center is free-tier infrastructure because
  its current documentation lists Pro and Enterprise availability.

## Submission and judge observability

If Flow A passes validation, a strong 30-second demonstration can show:

1. A locked supported Android or Galaxy device shows **Record a thread** with
   no private content.
2. One tap starts a visible recording; the user speaks a messy interruption
   state and taps **Stop recording**.
3. **Voice thread saved** appears immediately, before any network result.
4. The app produces a draft whose first action links to highlighted transcript
   evidence and exposes an assumption instead of inventing certainty.
5. The user edits or selects **Use this first step** and opens the source when
   one exists.
6. Airplane mode or a forced AI failure still leaves playable local audio and a
   deterministic reset path.
7. Fold/unfold or process death preserves the recording and draft state.
8. TalkBack, 200% text, and the expanded Galaxy layout demonstrate that the same
   loop remains usable.

This is a potential proof arc, not evidence that judges will reward it. The
Galaxy entry remains conditional on a published Galaxy Store build, purchase
spike, real-device testing, adaptive behavior, and polished metadata/assets.
The OneSignal entry remains conditional on a deployed campaign, correct deep
link, permission timing, fatigue controls, and measured start behavior.

## Evidence and uncertainty ledger

| Material conclusion | Evidence status | Confidence | What remains unknown |
|---|---|---|---|
| External cues can reduce interruption resumption lag in a controlled task environment | Measured in one historical laboratory study | Medium-high for mechanism; low for product efficacy | Whether mobile breadcrumbs change real behavior for this audience |
| Adults with ADHD may experience task management as emotional and relational as well as procedural | Described in two current preprints; one contains 22 interviews and a 20-person concept exercise | Medium | Representativeness, replication, and the needs of the reachable launch segment |
| Contextual capture and source return are established interaction patterns | Observed in Apple and Google support material and current product pages | High for availability | Which exact fields users need; whether they remember to capture |
| One-current-item widgets and one-task views reduce interface decision density by design | Observed/described current features; analyst mechanism | Medium | Whether lower visible density improves completion or only preference |
| Android share targets should validate and allow confirmation/editing | Official observed guidance | High | Required native bridge and edge cases under the final stack |
| Notification permission must be just in time and denial-safe | Official Android/Apple/OneSignal guidance | High | Actual opt-in, cue utility, fatigue, and start lift |
| Local/offline durability and process recovery are core feasibility constraints | Official Android guidance plus Run 6 concept dependence | High | Spike results across devices, attachments, and forced terminations |
| Adaptive list-detail and fold continuity naturally support the same core loop | Official Android/Samsung guidance; analyst mapping | Medium-high | Physical Samsung behavior and whether it materially improves users' task |
| Flow A is the best of the three options | Analyst comparison | Medium | Prototype behavior, spontaneous use, accessibility defects, and close-competitor switching reason |
| Subscription is an appropriate business model | Unproven | Low | Recurring value, price choice, sync need, and paid conversion |
| Focs and What Next materially threaten differentiation | Current vendor descriptions | Medium | Availability, adoption, reliability, exact audience overlap, and switching behavior |
| Android lock-screen voice can be a supported-device path | Official keyguard widget, showWhenLocked, foreground-service, and microphone guidance | Medium-high for platform capability | OEM adoption, physical device behavior, reboot state, and final stack bridge |
| Galaxy can support direct locked voice recording | Observed official Samsung Voice Recorder behavior | High for Samsung's own app; low for Restart Thread | Third-party widget, Side button, Now Bar, model, region, and One UI behavior |
| Apple exposes system controls and AudioRecordingIntent | Official Apple API and WWDC guidance | High for intended API; medium for this implementation | Locked iOS 26 audio-session reliability and App Review behavior |
| AI can create a trustworthy grounded recovery draft | Proposed structured-output and evidence contract | Low until tested | Negation, omissions, correction burden, latency, provider retention, and unit cost |
| Voice capture lowers effective interruption friction | Analyst hypothesis | Medium-low | Actual activation time, social context, speech accessibility, and spontaneous use |

The complete 62-record ledger includes URL, title, date, tier, temporal status,
claim status, confidence, material use, and fallback record.

## Contradictions and missing evidence

1. **The Run 7 prompt says validated concept; Restart Thread is not behaviorally
   validated.** It was selected as the best surviving pivot. No interviews,
   observed prototype tasks, landing-page test, technical spike, payment choice,
   or seven-day pilot has occurred.
2. **The loop still depends on capture, even when voice makes it faster.** Voice
   Rescue handles unplanned interruptions, yet the product still fails if
   spontaneous voice threads are rare or socially awkward to record.
3. **The product's phrase-level differentiation has weakened.** Focs and What
   Next use close restart/context language. A prototype must prove a narrower
   mobile interaction and the next research run should verify those products
   independently.
4. **The target segment is inclusive but not yet precise enough for
   acquisition.** `Adults with ADHD or time blindness` is not a channel or a
   triggering work context. Interviews must identify whether study, freelance
   knowledge work, household admin, or another interruption setting is the
   first beachhead.
5. **The minimum useful voice content is unproven.** Users may omit the decision,
   source, blocker, or intended next move that AI needs. The product must learn
   whether one lightweight spoken prompt improves later recovery or merely
   interrupts the interruption.
6. **AI may add more correction work than it removes.** A fluent plan can reverse
   a negation, hide uncertainty, or invent a priority. Grounding and correction
   time are kill metrics, not polish metrics.
7. **A source deep link is not a meaningful action.** Instrumentation needs a
   participant confirmation or later behavioral signal; judges should not be
   shown link taps as outcome proof.
8. **Notifications are optional but the OneSignal award requires a deployed
   campaign.** The award is coherent only if the same return cue improves the
   measured start outcome without pressure. Eligibility cannot drive prompt
   timing or frequency.
9. **Galaxy billing and physical QA remain unresolved.** A polished layout is
   insufficient without a working purchase path, Seller account, distribution,
   and real-device coverage.
10. **Recurring paid value is not established.** Unlimited local records alone
    may fit lifetime purchase better than a subscription. Do not design the
    product around a yearly plan before choice evidence.
11. **Current platform guidance can change.** Recheck store, permission,
    subscription, and Galaxy policies at implementation and submission.
12. **Lock-screen voice isn't universal Android behavior.** AOSP capability does
    not require every OEM to expose the same host. Samsung's native recorder
    doesn't prove third-party no-unlock access.
13. **The first locked tap can't carry all consent work.** Microphone permission
    and cloud-processing consent need an unlocked, explicit setup. A user who
    skips or denies either choice still needs a complete text/local path.
14. **Apple's intended API still needs a real-device proof.** ControlWidget and
    AudioRecordingIntent exist, but current developer reports show locked audio
    execution failures in some iOS 26 configurations.
15. **Voice creates accessibility and situational exclusions.** A user may be
    nonspeaking, in public, have a speech difference, or use a language without
    reliable recognition. Text, Share, and manual reset must remain equal entry
    points rather than buried fallbacks.

## Recommendation

Select **Flow A — Instant Voice Thread** for prototype design. Implement Context
+ Voice as an alternate entry to the same record and Voice Rescue as the
no-breadcrumb state.

This structure minimizes capture friction without sacrificing source-rich
recovery. It uses locked platform surfaces only where proven, commits audio
before AI processing, keeps private content off the lock screen, makes every AI
claim traceable to transcript evidence, and preserves a local deterministic
fallback.

Do not begin visual styling by choosing a mascot, palette, animation identity,
or gamification layer. First prototype the semantic hierarchy and critical
states in grayscale. The next proofs are independent: prepared recording starts
in five seconds, locked capture survives the device matrix, at least 90% of
factual draft statements are transcript-grounded with no reversed negation, and
at least half of real voice threads lead to meaningful action within two minutes
of opening the draft.

## Decision gate

Choose one revised direction before visual styling or implementation planning:

- **Option A — select the revision:** Instant Voice Thread is the default;
  Context + Voice is an alternate entry; Voice Rescue is the fallback.
- **Option B — require unlock for launch:** Keep voice and grounded AI, but use
  home widget, Share, shortcut, and in-app recording during the hackathon.
- **Option C — postpone AI:** Keep low-friction voice capture and deterministic
  reset until AI grounding, privacy, latency, and cost pass separately.

## Updated research state

```yaml
RESEARCH_STATE:
  completed_run: 7
  rules_version_observed: "Live official rules and award inventory carried forward through August 10, 2026; August 1 is the accepted official start; Galaxy optimization is 20% of the otherwise applicable score."
  builder_constraints:
    team_and_skills: "Solo developer; can own development and marketing; AI-assisted implementation acceptable."
    available_hours: "No fixed cap; estimates must include debug, store review, testing, and rework."
    budget: "Prefer free tiers, credits, and existing subscriptions."
    eligible_platforms: "Android first on Windows; iOS/iPadOS second through MacinCloud; compatible Apple-silicon Mac build later; no native Mac promise."
    developer_accounts: "One Apple and one Google Play account planned; Samsung Seller account not confirmed."
    student_status: "Qualifying student email available."
    sponsor_employee_status: "No conflict reported."
    geography_and_store_access: "United States; US distribution available."
    backend_and_ai_tolerance: "Open. Voice commits locally first; AI may transcribe and draft a bounded grounded recovery plan; a deterministic no-AI fallback remains mandatory."
    regulated_or_sensitive_domains_to_avoid: "No clinical claim; captured work can be sensitive, so local storage, deletion, and privacy restraint are required."
  selected_primary_award: "RevenueCat Design Award"
  allowed_secondary_awards:
    - "Best App for Galaxy, conditional on same-loop adaptive value, Galaxy Store release, physical QA, and purchase-path proof"
    - "Keep Them Coming Back Award, conditional on one respectful deep-linked return campaign and measured start value"
  shortlisted_award_families:
    - "Design and native craft"
    - "Cross-platform and respectful retention"
  selected_opportunity_territories:
    - "T5 respectful return loops for intermittent goals"
  selected_problems:
    - "T5-S1 adults with ADHD or time blindness who lose task state after interruptions"
  shortlisted_concepts:
    - "R1 Restart Thread: C13 Reset Button plus C14 Breadcrumb"
  selected_concept: "R1 Restart Thread; C13+C14 core; C15 outside MVP and tested separately only if requested by evidence"
  ux_options_at_gate:
    - "A Instant Voice Thread default; Context plus Voice alternate entry; Voice Rescue fallback — recommended"
    - "B Voice and grounded AI with unlock required during the hackathon"
    - "C Voice capture with deterministic recovery; postpone AI"
  recommended_ux_direction: "A Instant Voice Thread with local-first save, grounded AI draft, conditional locked surfaces, Context plus Voice alternate entry, and Voice Rescue fallback"
  selected_ux_direction:
  selected_visual_direction:
  rejected_directions:
    - "Treating concept selection as behavioral validation."
    - "Capture-only flow with no path for unplanned interruptions."
    - "Forcing a next step when the user is not sure."
    - "Notification permission, account, paywall, project setup, or ADHD questionnaire before first saved value."
    - "Generic or autonomous AI planner, uncited plan, timer, streak, pet, points, or productivity score."
    - "C15 social support in the MVP, navigation, paywall, or core retention path."
    - "Notification delivery or source-link taps counted as meaningful action."
    - "Holding existing thread data behind an expired entitlement."
    - "Copying Apple, Google, Todoist, Tiimo, Llama Life, Focs, or What Next visual identity."
    - "Claiming novelty from the broad phrase resume with context."
    - "Visual styling before the critical flow and state model are selected."
    - "Making lock-screen voice a universal promise before physical-device proof."
    - "Showing transcript, source, task, or plan content on the locked screen by default."
    - "Requesting microphone permission or cloud-processing consent for the first time from a locked dead-end."
    - "Uploading voice before durable local save or using provider keys in the client app."
    - "Letting an AI draft create reminders, contact people, choose high-stakes priorities, or become active without confirmation."
    - "Removing text, Share, or deterministic reset alternatives for people who cannot or do not want to speak."
  accepted_evidence:
    - "Run 6 Option A selected on August 10, 2026."
    - "The Run 7 ledger now contains 62 records, including 60 external URLs and two analyst syntheses."
    - "Exa remained primary. Firecrawl was used once after Exa could discover but not fully extract the Android lock-screen FAQ; Firecrawl also returned a blocked-body shell, so the claim was cross-checked against official Android API pages and indexed FAQ passages."
    - "Quick Notes, Reminders, Keep, Todoist, Tiimo, and Llama Life provide current adjacent interaction evidence."
    - "Focs and What Next are close current vendor-described restart/context propositions and narrow the defensible wedge."
    - "Official Android guidance establishes share confirmation, widget quality, just-in-time permission, offline-first data, process recovery, predictive back, scalable content, and adaptive list-detail constraints."
    - "Official Samsung guidance establishes fold/unfold state continuity, resizable multi-window behavior, Galaxy QA, and listing-quality constraints."
    - "Official Apple and WCAG guidance establishes notification, widget, Dynamic Type, VoiceOver, contrast, reflow, focus, and target requirements."
    - "RevenueCat and store documentation establishes user-triggered restore, purchase outcome states, transparent subscription terms, and the need to handle expiry and billing retry."
    - "Android documents keyguard widgets, showWhenLocked activities, widget-triggered microphone foreground-service exemptions, and local audio capture prerequisites."
    - "Samsung documents native no-unlock Voice Recorder capture, lock-screen widgets, supported active-app Now Bar control, and configurable Side-button shortcuts; third-party behavior remains unproven."
    - "Apple documents Lock Screen/Action button controls, AudioRecordingIntent, control privacy/authentication, and conditional on-device speech recognition."
    - "Revised Flow A received the highest fixed analyst score, 4.15/5; this is not user or judge evidence."
  unresolved_questions:
    - "Which revised Run 7 voice/AI direction will the builder select?"
    - "Will four of five users start a prepared voice capture in five seconds or less without help?"
    - "Can each platform and claimed device start, indicate, stop, and durably save while locked without exposing private content?"
    - "Will at least 90% of factual draft statements cite supporting transcript segments with zero reversed negations?"
    - "Will four of five users correct or confirm the first action and start within 60 seconds of opening a ready draft?"
    - "Will at least 50% of 20 genuine voice threads lead to a meaningful action within two minutes without study reminders?"
    - "Does AI reduce recovery work after correction, or take longer than writing one next step?"
    - "Which first beachhead context has the highest recurring loss-of-state pain and reachable acquisition channel?"
    - "Do the three reset questions feel supportive or like another planner?"
    - "Can Restart Thread establish a switching reason against Focs, What Next, Quick Notes, Keep, Todoist, and ordinary self-messages?"
    - "Is a lifetime purchase more credible than subscription before sync exists?"
    - "Does the final stack support share, widget, deep-link, process recovery, Galaxy billing, and iOS share-extension requirements with acceptable native-bridge risk?"
    - "Is a Samsung Seller account and physical or Remote Test Lab device coverage available?"
  next_decision: "Select revised Option A, require unlock with Option B, or postpone AI with Option C before visual styling or implementation planning."
```
