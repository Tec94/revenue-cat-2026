# Run 2 batch 5: cross-platform, retention, and game craft

This final dossier batch covers three different award families. Cooked This is
tested against a deeper OneSignal implementation; Momental against a more
technically ambitious Kotlin Multiplatform product; and Crystal Abyss against a
same-year native SpriteKit game. The controls prevent integration depth,
cross-platform complexity, or game technology from being mistaken for unique
winner evidence. Scores are analyst judgments, not official results.

## Cooked This: Cooking Diary and Tracker

**Winner and match.** Cooked This won the 2025 OneSignal Boost Award. Memory
Hammer is the control: both are 2025 mobile habit products that use tags,
notifications, in-app messages, lifecycle timing, and RevenueCat context to
support repeat behavior. Cooked This is iOS; Memory Hammer was Android-first,
so the platform match is weaker than the OneSignal and retention match.

### 1. Track interpretation

The award judged Integration, Impact, and Creativity in using OneSignal.
Cooked This interpreted OneSignal as behavioral feedback attached to the
product loop: remind a user to log a real meal, preserve a cooking streak, and
celebrate frequency, variety, batch cooking, or a newly tried dish. The
organizer emphasized careful tuning and autonomy.

Memory Hammer interpreted the track as a comprehensive lifecycle system:
motivation-tagged onboarding, permission prompts, review reminders,
subscription tags, inactive/engaged segments, and multi-step push/email/in-app
journeys. It is technically deeper and more varied than the winner, making it
a strong survivorship-bias control.

### 2. Product thesis

Cooked This prioritizes home cooks who repeat four or five meals and want the
same visible progress that fitness tracking provides. The trigger is cooking a
meal; the workaround is memory, a recipe app, or photos without progress. The
job is to build consistency and variety without making logging another chore.
The wedge is a kitchen-specific progress model rather than calorie tracking.

Memory Hammer prioritizes learners who want durable recall but find manual
flashcard creation tedious. It generates cards or visual mnemonics from notes
and photos, then schedules review with FSRS. Its trigger and retention need are
strong, but the audience and health-adjacent memory promise are broader.

### 3. Core loop

Cooked This: cook → tap plus → enter or reuse dish name → optionally add photo,
notes, meal type, batch-cooked, and first-time flags → see variety/frequency
progress → receive timely reminder or milestone celebration → cook/log again.
OneSignal enters at the repeat trigger and result, not before first value.

Memory Hammer: capture material → generate cards → review with FSRS → receive
behavior/motivation-specific prompt → preserve recall → create more cards. Its
OneSignal system reaches more lifecycle stages, including onboarding,
permission, updates, review, churn risk, and subscription state.

### 4. Journey

Cooked This's demo shows a bottom-tab app, a prominent plus, a Log Meal sheet,
autocompleted dish name, optional photo, expandable details, simple switches,
and Save. Diary and Insights expose progress. Notifications and custom HTML/CSS
in-app messages use tags and triggers. Permission timing, notification controls,
paywall, deletion, empty states, and missed-log recovery are not shown.

Memory Hammer asks why the user wants to improve memory, adapts onboarding,
requests notification permission, accepts text or camera input, generates
cards, schedules review, exposes trial limits/paywall, and sends segmented
push/email sequences. The completeness creates more opportunities for fatigue
and inconsistent state.

### 5. UI and interaction

Cooked This's demo frame shows a native dark Log Meal form. Predicted attention:
title/dish name → food thumbnail and photo add slots → meal-type segmented
control → first-time/batch switches → Save at the upper right. The common inputs
are above optional details, and autocomplete reduces repetition. Save is less
thumb-reachable than a bottom action, but the short form remains manageable.

Memory Hammer's inspected capture screen uses a standard Android camera with a
large bottom shutter, source preview, close, flash, and camera-flip controls.
Predicted attention: document → shutter → “Tap to take photo” → close/flash.
The creation action is clear; downstream onboarding, paywall, and message
screens add greater decision density.

### 6. Visual system

Cooked This uses black/charcoal surfaces, white text, orange state accents,
small food photography, familiar SF-like typography, and restrained icons. The
food supplies warmth. The event video composition makes the form readable but
the submission lacks a full screenshot gallery.

Memory Hammer's promotional system uses saturated purple, device mockups, a
hammer mascot, and many instructional panels. It communicates scope but is less
visually restrained. Its notification/email system risks brand and tone drift
across channels.

### 7. UX quality

Cooked This makes photos and notes optional and logs in a few taps, shortening
time to value. Metrics are linked to desired behaviors rather than arbitrary
engagement. Notification quiet hours, snooze, frequency caps, accessibility,
data export, and failure states are unknown. The organizer explicitly reports
fatigue avoidance, but no experiment or opt-out rate is visible.

Memory Hammer's generated cards reduce setup and its scheduled reviews have a
legitimate urgency. However, messages such as “You're going to be dumb” and
“You're going to forget everything” use fear/shame and contradict the claim of
not irritating users. The app also handles images, study data, email, and AI,
creating privacy and error risks.

### 8. Monetization

Cooked This's Devpost page does not disclose a RevenueCat package, price,
paywall, or free/paid boundary, despite hackathon eligibility implying RevenueCat
use. OneSignal's value is independent of payment in the visible loop.

Memory Hammer offers a seven-day trial across three creation modes, generation
limits, and premium upgrade from a limits widget or account page. RevenueCat
entitlement tags feed OneSignal segmentation. Payment aligns with ongoing AI
generation, but aggressive renewal/churn messaging could exploit anxiety.

### 9. Growth and retention

Cooked This's utility retention is weekly cooking, reinforced by streaks,
variety, batch meals, milestones, and future widgets/sharing. No installs,
active users, opt-in rate, message CTR, meal logs, retention cohort, or revenue
are disclosed.

Memory Hammer reports 3,000 installs and 2,000 users in three weeks and initial
premium purchases. Its behavioral tags—last card saved and last review—are
better instrumentation than Cooked This publicly shows. This means metric
volume and automation depth were not unique to the winner.

### 10. Technical and operational shape

Cooked This uses SwiftUI, SwiftData, OneSignal, and RevenueCat. The small stack
fits a solo builder and the local log is likely resilient, though sync is not
disclosed. Custom HTML/CSS/JavaScript in-app messages increase creative range
and testing surface. Tag accuracy and duplicate notification prevention are
the main operational concerns.

Memory Hammer uses Flutter, AI generation, cloud sync, FSRS, RevenueCat,
OneSignal REST/API integrations, push, email, and in-app messages. It is more
complex and costly. Segment logic depends on accurate timestamps and
subscription identity across services.

### 11. Submission craft

Cooked This opens with an immediately understandable analogy, demonstrates
logging in real time, then explains how OneSignal tags/triggers attach to
meaningful moments. The organizer could repeat the loop in one paragraph. The
submission is thin on metrics, error handling, and screenshots, but the sponsor
integration is judge-observable.

Memory Hammer provides an exhaustive screenshot inventory and exact tag,
segment, and Journey logic. That proves implementation depth. The same detail
also exposes coercive copy and makes the desired user outcome less prominent
than the automation machinery.

### 12. Rubric mapping

| Historical criterion | Cooked This evidence | Counterevidence | Analyst score | Control score | Confidence |
|---|---|---|---:|---:|---|
| Integration | Push, custom in-app messages, tags, triggers tied to meal behavior | No code, delivery, or reliability metric | 4 | 5 | High/medium |
| Impact on experience | Timely reminders and celebrations reinforce cooking goals | No measured retention or opt-out effect | 5 | 4 | High/medium |
| Creativity | Kitchen-specific milestones and dynamic messages | Uses common habit-notification primitives | 4 | 5 | Medium |

### What the evidence supports

Cooked This's advantage is not deeper tooling. It is a clearer relationship
between a notification and user-chosen real-world progress. Memory Hammer is
strong counterevidence against calling advanced segmentation a winner trait.

### What remains unknown

Cooked This's user scale, RevenueCat model, notification settings, actual
message examples, delivery outcomes, and retention are unknown. Memory Hammer's
adoption, conversion, and message harm are not independently measured.

### What may transfer to 2026

Define the product behavior worth repeating first. Then use the fewest messages
needed to remind, recover, or celebrate that behavior, with user-controlled
frequency and a measurable fatigue guardrail.

## Momental

**Winner and match.** Momental won the 2025 Kotlin Multiplatform Reach Award.
Restia is the control: both shipped production iOS and Android apps with shared
Kotlin logic, native platform seams, RevenueCat subscriptions, offline
behavior, and public technical learning. Restia is the stronger engineering
stress test; Momental is the stronger consumer-experience comparison.

### 1. Track interpretation

The rules rewarded uncompromising quality across iOS and Android using Kotlin
and Compose Multiplatform, plus community sharing. The recap additionally
described technical execution and design consistency. Momental interpreted
quality as identical radical simplicity on both platforms, while writing native
Swift/Kotlin audio components where shared code would compromise behavior.

Restia interpreted quality as shared domain, state, and CRDT sync logic for a
multi-device restaurant POS, plus platform-native AI. It demonstrates more
technical complexity and more published KMP resources, so the winner cannot be
explained by shared-code ambition alone.

### 2. Product thesis

Momental prioritizes people who want calm, sleep, or focus but abandon
meditation apps burdened by logins, guided programs, ads, and choices. The
trigger is noise or a desired session. The wedge is “one page, one tap,” with
optional timers, bells, and mixable soundscapes. Founder experience in a Nepal
monastery and failed habit grounds the thesis.

Restia prioritizes restaurant staff whose network varies as they move between
tables and kitchen. The workaround is a centralized POS that stalls offline.
Its wedge is local-first finality with CRDT merging and near-real-time sync.
This is a severe operational problem, but the buyer/user set is larger and
more complex.

### 3. Core loop

Momental: need to meditate, sleep, or focus → choose mode/duration/soundscape →
tap start → hear seamless layered audio and interval/end cues → complete → see
streak/calendar or journal → repeat. The first value requires no account or
onboarding.

Restia: staff opens local table/order state → changes an order instantly →
local transaction commits → sync engine merges with other devices when
connected → kitchen/service continues → manager reviews register history.
RevenueCat gates Pro functionality.

### 4. Journey

Momental begins on one page with no login, ads, onboarding, or guided content.
The user can set duration, warmup, bells, silence, or mix from 60+ soundscapes.
Sleep fades audio; Focus adds interval bells; streak, calendar, journal, and
sync support repeat use. Paywall, purchase restore, audio-download failure,
storage management, and cancellation are not shown.

Restia includes AI-assisted menu scanning, table/order management, cash
register, local operations, reconnect/sync, and on-device AI. It ships on both
stores. Roles, staff onboarding, conflict explanation, entitlement loss,
printer failure, and disaster recovery are not fully shown.

### 5. UI and interaction

Momental's inspected campaign image is not an in-app screen, so the demo is the
better interaction source. It shows one centered timer page with mode,
duration, bell, soundscape, and Start. Predicted attention: remaining/session
time → Start → selected soundscape → secondary settings. The primary action is
thumb-reachable and the low decision density is intentional, though 60+
soundscapes require a contained selection surface.

Restia's inspected dark register-history screen uses large totals, four metric
tiles per shift, collapsible sections, and a three-item bottom bar. Predicted
attention: current total → sold/placed/served/money tiles → yesterday cards →
Cash Registry tab. It is scannable for staff but denser, and emoji-like metric
icons weaken professional consistency.

### 6. Visual system

Momental uses blurred atmospheric photography, muted blue-gray, white type, a
soft cloud/headphones icon, and audio imagery. The in-app system is described
as minimalist and consistently praised in reviews; the supplied assets do not
permit a full contrast audit.

Restia uses black, charcoal, white, muted gold, blue/green emoji, large rounded
panels, and bold numeric typography. It is function-first. The cross-platform
visual parity is described but not exhaustively observed.

### 7. UX quality

Momental has exceptional time to first value and minimal cognitive load. No
account increases privacy and reduces abandonment. Downloaded audio supports
offline sessions. Unexpected tinnitus and autistic-child uses are builder-
reported and should not become medical claims. Accessibility, reduced motion,
hearing alternatives, sleep-timer failure, and accountless sync identity are
not fully documented.

Restia's local-first behavior improves latency and outage recovery. CRDTs avoid
blocking conflict dialogs, but invisible merge rules can create trust problems
for money/orders without audit and correction. Role access, security, payment
data, accessibility, and error reconciliation are high stakes.

### 8. Monetization

Momental's RevenueCat package and paywall are not described in the Devpost
artifact. The value likely lies in expanded soundscapes or configuration, but
free value, trial, price, restore, and cross-store entitlement behavior remain
unknown.

Restia uses RevenueCat subscriptions to unlock Pro features and integrates
entitlements into shared state. Price and package are unknown. A business POS
can sustain subscription pricing, but offline entitlement expiry and multi-
device account rules require careful handling.

### 9. Growth and retention

Momental validated demand on Reddit, built a community and Featurebase board,
ran Google Analytics/Firebase A/B tests, and iterated more than ten times. It
reports 4,200 sessions in four weeks; the recap rounds to 4,000+. User-reported
sleep, focus, and tinnitus uses shaped positioning. Sessions are builder-
reported, not unique users or retention.

Restia released both stores, shipped feedback-driven onboarding and bug fixes,
and published KMP articles plus a Kotlin Phoenix repository. It supplies no
restaurant, staff, order, retention, or revenue metrics. Its natural retention
is business operations, not a consumer habit.

### 10. Technical and operational shape

Momental uses Kotlin/Compose Multiplatform for shared experience, native Swift
and Kotlin audio seams, Firebase/Firestore/Analytics/A/B testing, downloaded
audio, and RevenueCat. Audio licensing was controlled through CC0 and AI-
generated tracks edited in Audacity. Cross-platform audio, background behavior,
downloads, mixing, and store entitlements are the primary seams.

Restia shares domain logic, sync engine, and state in KMP; uses CRDTs, Phoenix
WebSockets, Elixir, Hetzner/Kubernetes, OpenTelemetry, OpenRouter, and native
iOS Foundation Models. It is technically impressive but has far more backend,
observability, infrastructure, and operational touchpoints than Momental.

### 11. Submission craft

Momental's demo frames problem, competitor friction, one-page mechanism,
feedback, sleep/focus expansion, KMP implementation, 4,000+ sessions, and a
personal 30-day streak. It presents the same coherent result on both stores.
The story emphasizes why shared technology serves an experience.

Restia shows a no-cut real-time sync demo, on-device AI, production screens,
and public technical resources. It makes shared engineering more observable
than Momental does, but the user story and visual consistency are less concise.

### 12. Rubric mapping

| Historical criterion | Momental evidence | Counterevidence | Analyst score | Control score | Confidence |
|---|---|---|---:|---:|---|
| Quality across iOS/Android | Shipped both; native audio seams; coherent one-tap product; 4,200 sessions | No performance, accessibility, or parity test matrix | 5 | 5 | High/medium |
| Community sharing | Reddit, X, Featurebase, public feedback/A/B loop | Few KMP-specific technical resources in submission | 4 | 5 | Medium/high |

### What the evidence supports

Momental's award evidence is a unified product thesis delivered across both
platforms, not maximum shared-code percentage. Restia equals or exceeds it on
technical difficulty and public Kotlin learning.

### What remains unknown

Momental's unique users, retention, paid package, parity bugs, audio licensing
audit, and accessibility are unknown. Restia's live business adoption, security,
and failure rate are unknown.

### What may transfer to 2026

Use KMP to preserve one audience and one loop, then spend native code where it
protects platform behavior. Demonstrate parity with the same task on both
devices, including one offline or lifecycle edge case.

## Crystal Abyss

**Winner and match.** Crystal Abyss won the 2025 Staff and Sponsors Award.
Tilt Runner is the control: both are 2025 iOS SpriteKit games with Swift,
RevenueCat, IAP, physics or motion, level/item unlocks, and event-period App
Store review work. Tilt Runner's Devpost start timestamp and asset generation
confirm the 2025 match.

### 1. Track interpretation

The Staff/Sponsor rubric judged App Concept, Execution, and Monetization.
Crystal Abyss combines a known Columns loop with Dante's nine circles and a
serene Monument Valley-inspired direction. Its concept is a recognizable game
plus a legible thematic progression. Execution emphasizes cascades, animation,
particles, audio, tutorial, difficulty, and 60 fps. Monetization unlocks choice
of premium starting level.

Tilt Runner combines a gyroscope maze/runner with collectible rewards,
different balls and arenas, virtual currency, and IAP. It uses more distinctive
device input, but its visual and progression execution is closer to an MVP.

### 2. Product thesis

Crystal Abyss serves casual puzzle players who want nostalgic matching with a
modern, meditative atmosphere and escalating journey. The trigger is a short
game session; the workaround is Columns or other match-three games. The wedge
is Dante-themed progression and calm art direction around a familiar loop.

Tilt Runner serves players who want a light physical-control challenge. The
trigger is pick-up-and-play movement; the wedge is tilting the phone to guide a
ball past holes while collecting rewards. The audience and desired emotional
result are less specifically articulated.

### 3. Core loop

Crystal Abyss: start a circle → drop/rotate a three-jewel stack → match three
in any direction → see sequential clears/cascades/particles → score and survive
speed increase → clear or fail → descend/replay. Pro can select a starting
level, while ordinary progression retains context.

Tilt Runner: select ball/arena → tilt to steer → avoid holes and collect coins
or rewards → score → unlock or buy balls/arenas → replay. Device motion is the
primary feedback loop; the submission does not describe session length,
difficulty curve, or loss/recovery.

### 4. Journey

Crystal Abyss's menu offers Play, Choose Level, Settings, and Statistics. An
interactive tutorial explains the stack and matches; nine circles increase
speed and visual theme. Pause/resume, rotation-near-landing, and collisions were
known edge cases. Paywall placement, purchase restore, failure screen,
accessibility, and save-state recovery are not fully shown.

Tilt Runner includes home, options, control instructions, ball inventory,
selected loadout, arena inventory, and play. App Review forced consumables to
non-consumables. Restore is implemented. Motion calibration, orientation,
accessibility alternatives, interruption, and purchase-failure paths are not
documented.

### 5. UI and interaction

Crystal Abyss's inspected menu uses a green low-poly landscape, white serif
title, four translucent outlined buttons, and three faceted jewels. Predicted
attention: title → Play → jewel row → Choose Level → Settings/Statistics. The
primary action is large and reachable; the similar button weights slightly
flatten hierarchy. In play, the falling stack and grid center dominate; rotate
controls must remain reachable without obscuring the board.

Tilt Runner's inspected play screen is a full green felt maze with a white ball,
orange hole, star coin, top-left pause, and top-right score. Predicted attention:
ball → hole → star → score → pause. Tilt input is invisible, so the separate
instructions screen is essential. The sparse HUD reduces distraction but does
not show calibration or feedback about tilt sensitivity.

### 6. Visual system

Crystal Abyss uses soft green atmospheric gradients, faceted red/green/purple
jewels, white typography, translucent slate panels, low-poly landscapes, and
different circle themes. The “Dante darkness” is gentler than the text premise;
that tension creates a distinctive meditative quality. The designer's pending
improvements mean event visuals were not final.

Tilt Runner uses photographic or textured green felt, saturated blue pause,
orange coin/hole, a plain white ball, and simple score type. Objects are clear
against the field, but art styles are less cohesive and less narratively
distinctive.

### 7. UX quality

Crystal Abyss relies on a learned but familiar matching rule and provides a
tutorial. Cascade feedback, particles, and sound reinforce success. Color-only
jewel differentiation, reduced-motion support, haptic/sound controls, pause
recovery, screen sizes, and input accessibility are unknown. No dark pattern is
visible.

Tilt Runner's tilt input can feel immediate but excludes or discomforts some
users and needs calibration, sensitivity, neutral-position reset, and an
alternative control. Holes and rewards are visually distinct. Motion sickness,
device posture, interruption, and fair IAP balance are unaddressed.

### 8. Monetization

Crystal Abyss's Pro entitlement unlocks starting-level selection. This sells
convenience/agency rather than energy, but can weaken progression if offered too
early. Price, trial, free levels, paywall narrative, and conversion are unknown.
RevenueCat integration reportedly took under an hour.

Tilt Runner mixes virtual-currency unlocks with non-consumable IAP for balls and
fields after App Review rejected the original consumable logic. It implements
offerings, purchase, and restore. Exact prices, earn rate, item advantage, and
fairness are unknown.

### 9. Growth and retention

Crystal Abyss has nine levels, rising speed, scoring, statistics, and planned
leaderboards/achievements/multiplayer. No players, session count, completion,
level funnel, revenue, social loop, or store outcome are reported.

Tilt Runner has unlockable balls/arenas and score chasing. Version 2.0 planned
more polish, interaction, consumables, and items. No player, retention, economy,
or acquisition evidence is available. Both therefore offer retention
mechanisms without outcome proof.

### 10. Technical and operational shape

Crystal Abyss uses SpriteKit rendering/physics/animation, SwiftUI menus, custom
managers, RevenueCat, handmade music, and AI-assisted code. The builder reports
60 fps after optimization. Coordinate transforms, duplicate scaling, collision
masks, rotation, and pause state created repeated regressions; CLAUDE.md,
logging, isolated tests, and architecture rules helped.

Tilt Runner uses SpriteKit for physics and UI, CoreMotion for tilt, Swift, and
RevenueCat. The stack is smaller, but sensor noise, frame-rate/device variation,
orientation, calibration, and game-economy persistence remain. App Review
required a monetization redesign.

### 11. Submission craft

Crystal Abyss's demo opens with the Dante line, immediately explains Columns-
style matching, rotation, cascades, nine-circle escalation, AI-assisted solo
build, and store availability. Six event screenshots span menu and named
levels. The Devpost story is unusually candid about circular AI regressions and
human oversight.

Tilt Runner's gallery covers icon, home, options, instructions, inventories,
loadout, and live game. It proves feature breadth and store/IAP learning, but
the story is brief and does not demonstrate progression, polish, performance,
or a differentiated monetization thesis.

### 12. Rubric mapping

| Historical criterion | Crystal Abyss evidence | Counterevidence | Analyst score | Control score | Confidence |
|---|---|---|---:|---:|---|
| App concept | Familiar loop with coherent Dante/serene reframe | Mechanic itself is not novel | 5 | 4 | High |
| Execution | Working tutorial, nine levels, cascades, audio, particles, reported 60 fps | Known pause/rotation bugs; design work still pending | 4 | 3 | High/medium |
| Monetization | Pro starting-level choice via RevenueCat | Price, package, and demand absent; modest novelty | 3 | 3 | Medium |

### What the evidence supports

Crystal Abyss presents a more coherent art/narrative/gameplay package and a
more transparent engineering story. Tilt Runner controls for SpriteKit,
RevenueCat, store approval, device-native input, and item unlocks.

### What remains unknown

Both games lack player, retention, balance, accessibility, monetization, and
store-performance evidence. Crystal Abyss's 60 fps is builder-reported and not
tested across devices.

### What may transfer to 2026

For a game or delight-led submission, show the loop, escalation, feedback, and
failure/retry within the first minute. A coherent theme should change pacing,
sound, level progression, and monetization—not only rename screens.

## Batch evidence and uncertainty ledger

| Claim or artifact | Status | Source tier | Date or state | Confidence |
|---|---|---|---|---|
| OneSignal criteria and Cooked This placement | Observed | A | 2025 rules/recap | High |
| Cooked This logging and OneSignal behavior | Builder/organizer-described; demo-observed | A/B | Event period | High |
| Memory Hammer integration and 3,000 installs/2,000 users | Builder-described/measured | B | Event period | Medium |
| KMP rules and Momental placement | Observed | A | 2025 rules/recap | High |
| Momental two-store product, native audio seams, and 4,200 sessions | Builder-described/measured; organizer-repeated as 4,000+ | A/B | Event period/recap | High/medium |
| Restia production dual-platform CRDT system and public resources | Builder-described; partially observed | B | Event period/current update mixed | High/medium |
| Staff/Sponsor criteria and Crystal placement | Observed | A | 2025 rules/recap | High |
| Crystal gameplay, 60 fps, AI workflow, and RevenueCat integration | Builder-described; demo/asset-observed | B | Event period | High/medium |
| Tilt Runner same-year SpriteKit game and purchase/restore path | Builder-described; asset-observed | B | 2025 event period | High |
| Predicted attention maps | Analyst hypothesis | D | Observed 2026-08-09 from event assets | Medium |

Exa was used for discovery, full Devpost and official-page extraction, and
video transcripts. Firecrawl extracted dynamic Devpost screenshot and video
links. Vision inspection was the fallback for event screens; Cooked This had no
separate Devpost images, so its event video frame was used.

## Batch contradictions and missing evidence

- Cooked This has less visible OneSignal depth and no adoption metrics, while
  Memory Hammer has more of both. Integration volume therefore cannot be
  treated as the winner explanation.
- The organizer says Cooked This balanced reminders with autonomy; message
  frequency and fatigue outcomes are not public.
- Momental's submission reports 4,200 sessions; the official recap rounds this
  to more than 4,000. Neither number is unique users or retention.
- Momental's campaign image says “3,000 escaping the noise,” which may be a
  different snapshot or people claim and is not merged with session count.
- Restia's screenshots and updates include post-event material. Technical
  claims tied to later updates are labeled rather than assumed judge-visible.
- Crystal's Devpost says the targeted Monument Valley aesthetic was achieved
  and also says it was “not yet achieved”; this indicates an evolving,
  subjective art-direction claim rather than a factual contradiction.
- Tilt Runner's App Review forced a consumable-to-non-consumable change; future
  consumables were planned, not shipped evidence.

## Batch recommendation

Carry forward “integration serves the core behavior,” “cross-platform
coherence before shared-code ambition,” and “coherent submission arc with
observable feedback” as candidate patterns. Do not yet call advanced SDK use,
KMP engineering complexity, AI-assisted velocity, or SpriteKit a winner
differentiator; matched controls display each.

## Next steps

All five batches are complete. Assemble the Run 2 index, evidence ledger,
candidate-pattern menu, and one decision gate. Do not test or synthesize the
candidate patterns until the user's selection.
