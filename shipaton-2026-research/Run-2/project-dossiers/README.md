# Project dossier index

Run 2 documents the selected Option A sample: 18 winners in five batches, each
with a reasonably matched non-winning control and historical-rubric scoring.
Every dossier covers the twelve requested product, UX, business, technical,
submission, and rubric dimensions. The files distinguish observed, described,
measured, inferred, and unknown evidence.

| Batch | Winners | Principal controls | File |
|---|---|---|---|
| Growth and monetization | Karo; Payout; ReadHim; Vector Guard | HabitBuds; PCOS Polly; Monk; Vega | [`run-2-batch-01-growth-and-monetization.md`](./run-2-batch-01-growth-and-monetization.md) |
| Design and native craft | Flowmino; Dayloop; PitchLab | FoxyFocus; Mood Dial; Challengrs | [`run-2-batch-02-design-and-native-craft.md`](./run-2-batch-02-design-and-native-craft.md) |
| Build in public and distribution | Meshing; Gurwi; Echo Reminder; Tomo Japan | One Step; Memory Hammer; Stupido; Rangelert | [`run-2-batch-03-build-in-public-and-distribution.md`](./run-2-batch-03-build-in-public-and-distribution.md) |
| Impact, trust, and accessibility | Rakun Talk; Heartbeat Hero; Hearing Buddy; MoodHaven | Breathe Zen; LockedIn; CareWatch; PCOS Polly | [`run-2-batch-04-impact-trust-and-accessibility.md`](./run-2-batch-04-impact-trust-and-accessibility.md) |
| Cross-platform, retention, and game craft | Cooked This; Momental; Crystal Abyss | Memory Hammer; Restia; Tilt Runner | [`run-2-batch-05-cross-platform-retention-and-game-craft.md`](./run-2-batch-05-cross-platform-retention-and-game-craft.md) |

The Run 2 handoff and decision gate are in
[`report.md`](../report.md). Candidate patterns are listed in
[`candidate-patterns.csv`](../candidate-patterns.csv)
but have not been tested or synthesized across the full corpus.

## Earlier first-place context

This directory records an independent, source-first review of the 13
first-place projects from RevenueCat's 2024 and 2025 events. The supplied prior
report was not used to form these dossiers. Each dossier distinguishes visible
or reported evidence from interpretation.

## Karo: Social Task Manager

**Award:** 2024 Most Likely to Make Money.

Karo reframed collaborative task management as a conversation. The decisive
mechanism was not the chat styling itself. A recipient could receive and
complete a task through WhatsApp or SMS without first adopting Karo. The sender
then received completion feedback. That mechanism reduced the hardest network
adoption barrier and made ordinary use expose the product to non-users.

The submission also showed unusually concrete product judgment. The team
described cutting five to seven planned features from v1, changing an early
beta that users mistook for ordinary chat, handling US SMS compliance and
WhatsApp approval, and moving traffic toward WhatsApp because Twilio was
expensive. The organizer described a free tier that let users learn the model
before collaboration and AI limits became paid boundaries.

**Evidence status:** The workflow, stack, cuts, and constraints are
builder-described. The organizer's business-fit explanation is observed on the
winner announcement. Press and store featuring are builder-reported. No audited
conversion or retention metric is available.

**Sources:** [Devpost submission](https://devpost.com/software/karo-trj4av),
[official 2024 winner announcement](https://www.revenuecat.com/blog/company/2024-ship-a-ton-winners).

## Flowmino: Time Block & Focus

**Award:** 2024 RevenueCat Design.

Flowmino fused two established jobs: plan the day with time blocks, then use
Apple Screen Time APIs to block distraction during the chosen block. Motion,
haptics, and a visible transition into a flow state supported that functional
change instead of decorating a timer.

The team reported that the native Activity Picker could crash and that the
product needed UX recovery around unstable APIs. They also documented the
difficulty of keeping the app's scope to a minimum lovable product. This is a
strong example of design as a working system: interaction, feedback, native
capability, error handling, and visual tone all supported the same promise.

**Evidence status:** The product flow and technical constraints are observed
or builder-described. The organizer explicitly praised the breathing
animation, transition motion, and haptics. No task-completion or retention
metric is available.

**Sources:** [Devpost submission](https://devpost.com/software/flowmino),
[official 2024 winner announcement](https://www.revenuecat.com/blog/company/2024-ship-a-ton-winners).

## Meshing: AI Mesh Gradient Tool

**Award:** 2024 `#BuildInPublic`.

Meshing turned a SwiftUI mesh-gradient prototype into a direct creation loop:
start from a prompt, photo, or template; manipulate the mesh in real time; add
effects; and export an image or code. The public process changed the product.
RevenueCat's announcement named noise, animation, text masking, favorites, and
copy behavior as community-driven additions.

The builder also documented performance work for animated gradients, repeated
UI iteration, daily video logs, and a late accessibility pass for VoiceOver and
Voice Control. The strongest evidence was therefore not the quantity of posts.
It was the traceable relationship between public response and the app.

**Evidence status:** Named product changes and the daily public process are
organizer-described and builder-described. No audience-size or conversion
metric is necessary for the historical criterion.

**Sources:** [Devpost submission](https://devpost.com/software/meshing),
[official 2024 winner announcement](https://www.revenuecat.com/blog/company/2024-ship-a-ton-winners).

## Payout

**Award:** 2025 Grand Prize: Build & Grow.

Payout translated class-action settlements into a consumer money workflow:
discover a case, read eligibility in plain language, estimate compensation,
track status, and receive alerts. The team reported shipping v1 in ten days and
launching on both stores with 17,000 users, $30,017 in revenue, 1,750 paying
subscribers, and more than 500,000 social impressions.

The app also faced a real trust boundary. It needed to help people file claims
without presenting itself as legal counsel. The submission says disclaimers and
opt-ins were built into the flow. Pricing tests, keyword acquisition, and
status nudges were linked to growth work.

**Evidence status:** The metrics are builder-reported and repeated by the
organizer; they are not independently audited. The official 2025 rules, not the
later recap's generic prose, define the category as Early and Effective Release
followed by Growth-by-numbers.

**Sources:** [Devpost submission](https://devpost.com/software/payout-cwdniv),
[official 2025 rules](https://revenuecat-shipaton-2025.devpost.com/rules),
[official 2025 winner announcement](https://www.revenuecat.com/blog/company/shipaton-2025-winners).

## Gurwi – Learn Anything

**Award:** 2025 `#BuildInPublic`.

Gurwi paired a founder's education-access story with a custom interactive,
visual, multilingual lesson format. The project was larger than the mobile
client: the team also built an editor and a `.gurwi` content format. That
content-production system is both a differentiator and a major operational
burden.

The evidence has multiple dated snapshots. The official recap reported more
than 13,000 users, more than 1,000 reviews, and a 4.9 average. A Devpost update
dated October 3, 2025, reported 17,696 users, 15,000 Android downloads, 6,500
iOS downloads, 1,354 reviews, 228 active subscriptions, $1,145 MRR, $2,668 total
revenue, and 3.3 million social views. These figures must remain attached to
their dates and must not be treated as one simultaneous measurement.

**Evidence status:** The metrics are builder-reported, with a subset repeated
by the organizer. The original problem-validation video reportedly received
more than 200,000 views and 40,000 likes.

**Sources:** [Devpost submission and dated updates](https://devpost.com/software/gurwi-learn-anything),
[official 2025 winner announcement](https://www.revenuecat.com/blog/company/shipaton-2025-winners).

## Dayloop: Everyday Timelapse

**Award:** 2025 RevenueCat Design.

Dayloop removed the delay from a product whose natural value appears over
months. Importing existing photos and using Vision-based auto-alignment let a
new user see a convincing timelapse in the first session. Ghost Photo helped
frame future captures, while a playful scrubber made time itself the primary
interaction.

The builder described image-orientation bugs, memory leaks, coordinate-system
differences, and rejected technical fixes that degraded the experience. Photos
remained on device. This joined a clear value moment, native capability,
privacy, motion, and a distinctive visual artifact.

**Evidence status:** The sub-minute value claim and technical challenges are
builder-described. The organizer described the implementation and use cases.
No event-period user metric is disclosed.

**Sources:** [Devpost submission](https://devpost.com/software/dayloop-everyday-timelapse),
[official 2025 winner announcement](https://www.revenuecat.com/blog/company/shipaton-2025-winners).

## ReadHim

**Award:** 2025 Buzziest Launch.

ReadHim was designed around a socially discussable niche. Users uploaded text
conversation screenshots, received OCR and model-based analysis, and got
relationship-pattern and response guidance. The launch used a meme account, a
large TikTok partner, and a local stunt involving supercars and a robot dog.

Metric provenance needs care. The official announcement reports 5.2 million
Instagram views, a partner with more than 2.3 million TikTok followers, and
$1,100 MRR after ten days. The Devpost tagline separately claims more than six
million views. A follower count is not a view count, and the two view claims
may cover different windows.

**Evidence status:** Metrics and model-performance claims are builder-reported.
Relationship guidance is high stakes; the available submission evidence does
not establish clinical or safety validation.

**Sources:** [Devpost submission](https://devpost.com/software/readhim),
[official 2025 winner announcement](https://www.revenuecat.com/blog/company/shipaton-2025-winners).

## Vector Guard

**Award:** 2025 HAMM.

Vector Guard made monetization part of the access mechanism. The app combined
CDC surveillance data, offline identification, multilingual guidance, and a
$2.99 subscription. The stated 1:50 Justice Model funded 50 free accounts in
high-risk ZIP codes for every paid subscription.

The model was legible because the price, beneficiary, and access outcome could
be repeated in one sentence. It also raises verification questions: the
submission did not disclose acquisition cost, ongoing data or inference cost,
conversion, the number of funded accounts, or independent confirmation of the
ratio.

**Evidence status:** The product and cross-subsidy design are organizer-
described. Economic sustainability and realized impact remain unknown.

**Sources:** [Devpost submission](https://devpost.com/software/vector-gaurd),
[official 2025 winner announcement](https://www.revenuecat.com/blog/company/shipaton-2025-winners).

## Heartbeat Hero

**Award:** 2025 RevenueCat Peace Prize.

Heartbeat Hero turned an iPhone or iPad into CPR practice equipment. Separate
modes covered theory, rhythm, compression depth, emergency-call simulation,
and AED discovery. ARKit, high-frequency motion data, sensor fusion, and
adaptive filtering supported real-time depth feedback without special
hardware.

Offline operation strengthened reliability and privacy. Voice guidance,
haptics, torch flashes, and a focus mode broadened access. Core learning stayed
free, and students received full access. The builder reported training more
than 100 students.

**Evidence status:** The training count and accuracy claims are builder-
reported. The submission does not expose an independent clinical validation
protocol. The organizer nevertheless identified a concrete, feasible impact
mechanism rather than a broad social-good intention.

**Sources:** [Devpost submission](https://devpost.com/software/heartbeat-hero),
[official 2025 winner announcement](https://www.revenuecat.com/blog/company/shipaton-2025-winners).

## Otter Day: Weekday Guesser

**Award:** 2025 Best Vibes.

Otter Day turned a narrow calendar calculation into a character-led learning
game. Perplexity supported dialogue and visuals, KlingAI animated the otters,
and ElevenLabs supplied voice. The tools reinforced one steampunk narrative
and one learn-practise-correct loop.

The builder reported tension between storytelling and cognitive load, then
described supporting visual, auditory, and reading-oriented learning. The
result is useful evidence that AI tooling mattered when it served a coherent
experience, not merely when it generated code or assets.

**Evidence status:** Tool usage and the product flow are builder-described and
organizer-repeated. No learning-outcome or retention metric is disclosed.

**Sources:** [Devpost submission](https://devpost.com/software/otter-day-weekday-guesser),
[official 2025 winner announcement](https://www.revenuecat.com/blog/company/shipaton-2025-winners).

## Cooked This: Cooking Diary and Tracker

**Award:** 2025 OneSignal Boost.

Cooked This applied a fitness-tracker mental model to cooking. Users logged a
meal, saw variety or consistency progress, and received a celebration or
carefully timed reminder tied to real behavior. The organizer emphasized
autonomy and fatigue avoidance rather than notification volume.

The non-winning control Memory Hammer documented a much deeper OneSignal
implementation: motivation tags, dynamic onboarding, RevenueCat subscription
tags, segments, Journeys, push, email, and in-app messages, plus 3,000 installs
and 2,000 users. Because public category-entry status is unknown, this is not a
causal comparison. It does show that integration depth and metric quantity were
not unique to the winner. Cooked This made the user-value loop easier to
explain.

**Evidence status:** Cooked This disclosed no usage metric. The organizer
described its OneSignal behavior. Memory Hammer's figures are builder-reported.

**Sources:** [Cooked This submission](https://devpost.com/software/cooked-this),
[Memory Hammer control](https://devpost.com/software/memory-hammer-7p2dsa),
[official 2025 winner announcement](https://www.revenuecat.com/blog/company/shipaton-2025-winners).

## Momental

**Award:** 2025 Kotlin Multiplatform Reach.

Momental used Kotlin and Compose Multiplatform to deliver the same radical
friction reduction on iOS and Android: no account, no traditional onboarding,
one page, and one tap to begin meditation, sleep, or focus. Native audio seams
handled platform-specific behavior. The builder reported 4,200 sessions in
four weeks; the official recap rounded this to more than 4,000.

The controls Restia, Kittysplit, and Ask2Color shipped credible KMP products.
Restia implemented an offline CRDT synchronization engine. Kittysplit carried a
mature expense product onto both stores. Ask2Color combined KMP with native
Swift seams. Their public category-entry status is unknown, but their existence
means technical complexity, dual release, and sponsor integration cannot be
called unique winner traits. Momental's clearer differentiator was a coherent,
polished cross-platform product thesis.

**Evidence status:** Session counts are builder-reported and organizer-
repeated. Control implementation evidence is builder-described.

**Sources:** [Momental submission](https://devpost.com/software/momental),
[Restia control](https://devpost.com/software/restia),
[Kittysplit control](https://devpost.com/software/kittysplit),
[Ask2Color control](https://devpost.com/software/ask2color-drawing-for-kids),
[official 2025 winner announcement](https://www.revenuecat.com/blog/company/shipaton-2025-winners).

## Crystal Abyss

**Award:** 2025 Staff and Sponsors.

Crystal Abyss combined Columns-style matching, Dante's circles, and a calm
Monument Valley-inspired visual direction. SpriteKit handled the game and
particles, SwiftUI handled surrounding interface, and RevenueCat unlocked
premium starting levels.

The submission is also unusually candid about AI-assisted development. It
documents coordinate-system bugs, duplicate scaling logic, regressions, and
the need for persistent human oversight and project documentation. The game
reportedly reached 60 frames per second, but no player or revenue metric is
available.

**Evidence status:** Performance, architecture, and workflow are builder-
described. The recognizable loop and visual direction are observable in the
submission materials.

**Sources:** [Devpost submission](https://devpost.com/software/crystal-abyss),
[official 2025 winner announcement](https://www.revenuecat.com/blog/company/shipaton-2025-winners).

## Cross-dossier caution

These dossiers are winner-heavy. The controls improve the analysis but do not
solve category-selection opacity: Devpost does not consistently expose which
awards a non-winner entered. Treat a mechanism as a strong planning clue only
when the official criterion, winner evidence, and plausible control comparison
all point in the same direction.
