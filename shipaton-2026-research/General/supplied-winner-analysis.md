# Shipaton 2024–2025 winner analysis

The strongest Shipaton winners do not share one genre, platform, or visual
style. They share a tighter relationship: the user problem, signature product
mechanism, monetization or sponsor integration, judging criterion, and demo
story reinforce one another. The product does not look as if it was built first
and attached to an award later.

This report analyzes all 39 placed projects named by RevenueCat across 2024 and
2025, with deeper study of the 13 first-place projects. It uses official winner
announcements, historical Devpost rules, contemporaneous Devpost submissions,
submission media, and linked store or builder evidence.

## Executive findings

The cross-year findings are strong enough to guide 2026 research, but they are
not a causal recipe for winning.

1. **Winners turn a broad track into one concrete mechanism.** Karo removed the
   collaborator-install requirement from shared tasks. Dayloop made visual
   progress instantly visible through automatic alignment. Vector Guard made
   monetization itself the access mechanism. Heartbeat Hero turned a phone into
   training equipment.
2. **The most persuasive apps have a ten-second explanation and a demonstrable
   value moment.** Their descriptions use a familiar frame—chat for tasks,
   fitness tracking for cooking, one-tap timers for meditation—then reveal one
   important difference.
3. **The user's existing friction often becomes the design brief.** Winning
   flows remove accounts, co-user adoption, blank states, equipment, editing,
   jargon, or content-production effort before they add sophistication.
4. **Visual style follows the emotional job.** There is no winner palette.
   Successful work ranges from Karo's sunny, social yellow to Heartbeat Hero's
   direct coral and clinical white, Momental's dark quiet, and ReadHim's niche-
   specific pink. Color and type make the product legible to its audience.
5. **Native capability is used as product leverage, not a technology demo.**
   Screen Time, Vision, ARKit, IMU fusion, on-device speech, HealthKit, and
   platform notifications create the visible user outcome.
6. **Monetization is strongest when it expresses the product's value boundary.**
   Karo restricts collaboration and AI after free value is understood. Vector
   Guard connects a subscription to subsidized access. SkillMe personalized
   paywall language to the user's stated goal.
7. **Proof matters as much as polish in growth categories.** Payout, Gurwi,
   ReadHim, and Momental presented users, sessions, revenue, reviews, or reach.
   They also explained the actions or iterations behind those outcomes.
8. **Build-in-public winners show a feedback loop, not a posting streak.** The
   useful unit is public artifact → response → decision → product change →
   lesson.
9. **The submission is part of the product.** Strong pages make the inspiration,
   product mechanism, hard implementation choice, proof, and next step easy for
   a judge to repeat.
10. **A focused primary category is more persuasive than feature-based award
    stacking.** Secondary categories work only when the same core loop and
    evidence satisfy them without a second persona or a sponsor-only feature.

## Research method and confidence

Exa MCP was the primary search and extraction layer. `web_fetch_exa` collected
the official RevenueCat announcements and Devpost submissions;
`web_search_exa` resolved project pages, historical rules, and corroborating
sources. Browser inspection was used for submission images because Exa's text
extraction cannot evaluate visual hierarchy, color, or typography.

The source order was:

- Official rules and RevenueCat winner announcements.
- Contemporaneous Devpost project pages and submission media.
- Event-period store, video, builder, and sponsor evidence.
- Current pages only when historical evidence was unavailable.

The visual findings come from submitted images and videos, not installed app
builds. No analytics, click tracking, or eye tracking were available. Every
attention map in this report is therefore a predicted focus map, not a measured
heatmap. Exact typefaces and contrast ratios cannot be confirmed from raster
images alone.

The main primary sources are the
[2024 winner announcement](https://www.revenuecat.com/blog/company/2024-ship-a-ton-winners),
[2025 winner announcement](https://www.revenuecat.com/blog/company/shipaton-2025-winners),
[2024 gallery](https://revenuecat-ship-a-ton.devpost.com/project-gallery),
[2025 gallery](https://revenuecat-shipaton-2025.devpost.com/project-gallery?page=1),
and [2025 official rules](https://revenuecat-shipaton-2025.devpost.com/rules).
The supplied 2026 rules file controls the 2026 comparison.

## Historical winner corpus

The 2024 event placed nine projects across three categories. The 2025 event
placed 30 projects across ten categories. The larger 2025 program makes direct
cross-year comparisons unreliable unless the original award wording is also
compared.

### 2024 placements

The inaugural event used three broad award families.

- **Most Likely to Make Money:** Karo, Zerocam Mono, and Party Animals.
- **RevenueCat Design:** Flowmino, Rakun Talk, and Apol.
- **`#BuildInPublic`:** Meshing, Food Sense, and BJJ Evolve.

### 2025 placements

The second event split business, growth, impact, tooling, and platform craft
into more specific awards.

- **Grand Prize: Build & Grow:** Payout.
- **`#BuildInPublic`:** Gurwi, Echo Reminder, and Tomo Japan.
- **RevenueCat Design:** Dayloop, SkillMe, and PitchLab.
- **Buzziest Launch:** ReadHim, Shutter Declutter, and MemoLune.
- **HAMM:** Vector Guard, Napkinmatic AI3D, and Kigaru Talks.
- **RevenueCat Peace Prize:** Heartbeat Hero, Hearing Buddy, and MoodHaven.
- **Best Vibes:** Otter Day, Dripped, and MaestLog.
- **OneSignal Boost:** Cooked This, Voicetree, Friendy+, Studient, and Camp
  Notes.
- **Kotlin Multiplatform Reach:** Momental, Posturely, Steps Share, DrawIt, and
  ClipUGC.
- **Staff and Sponsors:** Crystal Abyss.

## How first-place winners interpreted their tracks

The first-place projects reveal how teams translated award language into
product choices. The “why it worked” column is an evidence-backed analyst
interpretation, not a disclosed judge score.

| Project | Historical track | Interpretation | Core user loop | Why the fit was legible |
| --- | --- | --- | --- | --- |
| [Karo](https://devpost.com/software/karo-trj4av) | 2024 business viability | Make task delegation behave like messaging and work even when the recipient has no app | Select contact → assign → deliver by Karo, WhatsApp, or SMS → remind → completion feedback | It reduced the hardest adoption friction and created organic exposure through ordinary use |
| [Flowmino](https://devpost.com/software/flowmino) | 2024 Design | Fuse time blocking with Screen Time app blocking | Plan block → enter flow → block distractions → receive progress and completion feedback | The innovation, animation, haptics, and native API all supported “protect attention” |
| [Meshing](https://devpost.com/software/meshing) | 2024 `#BuildInPublic` | Let public feedback shape both a visual tool and its roadmap | Start from prompt, photo, or template → manipulate → preview → export | The public journey produced named features, iterative design changes, and reusable community content |
| [Payout](https://devpost.com/software/payout-cwdniv) | 2025 Grand Prize | Convert an obscure legal-information problem into a consumer money utility | Discover settlement → understand eligibility → claim → track status → receive new alerts | The app paired a clear financial outcome with launch numbers: 17,000 users, $30,017 revenue, 1,750 payers, and 500,000 social impressions |
| [Gurwi](https://devpost.com/software/gurwi-learn-anything) | 2025 `#BuildInPublic` | Turn a founder's education-access story into an interactive, multilingual content format | Choose lesson → advance through visual pages → answer → earn points and streaks | The story, long public journey, 13,000 users, 1,000+ reviews, and 4.9 rating made process and outcome visible |
| [Dayloop](https://devpost.com/software/dayloop-everyday-timelapse) | 2025 Design | Remove the labor from creating a personal timelapse | Import or capture → auto-align → scrub through time → export → return on reminder | Vision-based alignment, Ghost Photo, a playful slider, local privacy, and sub-minute value all reinforced design craft |
| [ReadHim](https://devpost.com/software/readhim) | 2025 Buzziest Launch | Select a socially discussable niche and build the launch around it | Upload message screenshots → analyze → receive pattern and response guidance | A niche-specific brand, meme funnel, influencer partnership, publicity stunt, six million views, and $1,100 MRR directly answered visibility, creativity, and engagement |
| [Vector Guard](https://devpost.com/software/vector-gaurd) | 2025 HAMM | Make monetization a cross-subsidy mechanism | See local risk → identify vector → understand danger → take prevention action | The $2.99 “1:50 Justice Model” was memorable, differentiated, and inseparable from the access mission |
| [Heartbeat Hero](https://devpost.com/software/heartbeat-hero) | 2025 Peace Prize | Turn the phone into private, offline CPR practice equipment | Choose mode → perform rhythm or depth practice → receive multimodal feedback → review results | Native sensors created feasibility; free core learning, student access, accessibility, and offline operation strengthened impact |
| [Otter Day](https://devpost.com/software/otter-day-weekday-guesser) | 2025 Best Vibes | Use AI tools to make a narrow mental-math trick into a character-led learning game | Learn one rule → practice dates → receive immediate correction → increase difficulty and rewards | AI supported dialogue, illustration, animation, and voice inside a coherent steampunk-otter direction rather than replacing the product idea |
| [Cooked This](https://devpost.com/software/cooked-this) | 2025 OneSignal Boost | Apply the familiar fitness-tracker loop to cooking consistency | Log meal → update variety or streak → celebrate milestone → receive a timely reminder | OneSignal messages were tied to a positive behavior loop and tuned to avoid fatigue |
| [Momental](https://devpost.com/software/momental) | 2025 Kotlin Multiplatform Reach | Make cross-platform craft serve radical friction reduction | Open → choose meditation, sleep, or focus and sound → start → complete → view streak | “One page. One tap. Nothing more,” no account, native audio components, 4,200 sessions, and consistent iOS/Android delivery made the platform work observable |
| [Crystal Abyss](https://devpost.com/software/crystal-abyss) | 2025 Staff and Sponsors | Reframe Columns through Dante and Monument Valley while documenting AI-assisted implementation | Drop jewels → match → cascade → progress through themed circles | A recognizable mechanic, strong art thesis, smooth feedback, and explicit RevenueCat unlocking made concept, execution, and monetization easy to see |

## Important award-definition changes

Historical titles are not interchangeable with 2026 titles. Several apparent
equivalents changed what must be proved.

### Grand Prize changed substantially

The three business-oriented awards ask different questions.

- **2024 Most Likely to Make Money** emphasized business viability, execution,
  monetization, onboarding, paywall design, and ASO.
- **2025 Grand Prize** emphasized innovation, execution, feasibility, and
  integration.
- **2026 Grand Prize** first uses RevenueCat-reported revenue for shortlisting,
  then evaluates early effective release and growth by numbers, including the
  quality, efficiency, and sustainability of growth.

Karo is most useful as a model of product-led distribution and value-gated
monetization. Payout is useful as a model of clear outcome and quantified
traction. Neither historical win proves that the same submission would satisfy
the 2026 trajectory rubric without dated experiments and causal learning.

### Design remained relatively stable

The Design Award consistently rewards innovative UX or technology plus
aesthetic delight, gesture quality, animation, and feedback. Flowmino and
Dayloop are therefore the cleanest cross-year comparisons. Both use one native
capability to make an ordinary activity feel unusually direct.

### Build in public remained a feedback award

The public story, community response, feedback-driven product change, and
lesson persist across years. Meshing, Gurwi, Echo Reminder, and Friendy+ show
that the strongest evidence is a changed product or audience definition, not a
large follower count.

### 2025 Buzziest Launch became a narrower 2026 viral award

ReadHim won on visibility, creativity, and engagement through memes,
influencers, and a physical stunt. The 2026 Most Viral App additionally requires
Noise, repeatable creative or UGC formats, scalability, and conversion
relevance. A one-time spectacle is therefore less transferable than a reusable
content format that clearly converts attention into downloads.

### Sponsored awards became more outcome-specific

The 2025 OneSignal award already rewarded implementation, experience impact,
and creativity. The 2026 Keep Them Coming Back award makes user value and
resourceful messaging even more explicit. The Kotlin award continues to reward
cross-platform quality and optional community contribution, but 2026 requires
published iOS and Android apps. Best Vibes has no direct 2026 equivalent.

## Product and user-flow patterns

Winning flows are shorter than their feature lists suggest. The central loop
usually removes a known obstacle before asking the user to learn a new model.

### Eliminate adoption friction

Karo does not require the assignee to install the app. That is both onboarding
design and distribution. It turns the recipient's existing channel into a
bridge instead of making network adoption a prerequisite.

The transferable principle is not “use messaging.” It is: identify the actor,
account, device, permission, or content prerequisite that blocks first value,
then design a bridge around it.

### Eliminate cold-start friction

Dayloop originally required users to return for days before seeing a compelling
timelapse. Importing existing photos and auto-aligning them moved the value
moment to under a minute. The project explicitly describes this as a churn
reduction and “magic” improvement.

This is one of the strongest winner patterns: a product with long-term value
still creates a credible preview of that value in the first session.

### Eliminate configuration friction

Momental uses no login and no traditional onboarding. The user chooses a mode
and starts. Flowmino combines planning and protection instead of asking users
to configure separate systems. Payout translates legal notices into plain
eligibility and deadline information.

Short onboarding is not the goal by itself. The goal is to postpone decisions
that the user cannot make before they have experienced the product.

### Turn feedback into the interface

Heartbeat Hero's visible result is not a lesson completion badge; it is rhythm,
depth, accuracy, and qualitative performance. Otter Day uses correction,
difficulty, character response, and reward. Cooked This celebrates meaningful
cooking variety and consistency instead of arbitrary engagement.

The best feedback is specific enough to teach the next action. Generic points,
streaks, and confetti are weaker unless they summarize real progress.

### Use progressive disclosure for high-stakes information

Vector Guard places red, yellow, or green risk and an immediate prevention step
before dense epidemiology. Heartbeat Hero separates learning, rhythm, depth,
call rehearsal, and AED discovery into modes. This reduces information load
without hiding the evidence advanced users need.

## Onboarding and journey patterns

The strongest onboarding choices are contextual. A universal multi-slide tour
does not emerge as a winner pattern.

- **Product-first entry:** Momental goes directly to the usable product.
- **Existing-content import:** Dayloop creates an immediate artifact from the
  user's photo library.
- **Familiar mental model:** Karo looks like a conversation; Cooked This borrows
  the fitness-tracker frame.
- **Mode selection by intent:** Heartbeat Hero and Momental organize by the
  outcome the user wants now.
- **Just-in-time permissions:** Camera, photos, notifications, contacts, or
  location are most defensible when requested at the task that needs them.
- **Free safety-critical entry:** Heartbeat Hero leaves Learn and AED access
  free; students receive full access.
- **Evidence-based exception:** Gurwi reports that an immediate subscription
  prompt after registration increased subscriptions. This is a project result,
  not a universal recommendation. The lesson is to test the value narrative
  and timing, including uncomfortable hypotheses.

A robust 2026 journey needs the unglamorous states as well: denied permissions,
empty data, slow or missing network, expired entitlement, restore purchase,
partial AI failure, notification suppression, and safe cancellation.

## Visual design, color, and typography

The inspected submission images reject the idea that one “winning” aesthetic
exists. They do reveal consistent use of visual hierarchy and emotional fit.

### Color follows the job

- **Flowmino:** black, white, and a controlled violet glow create a quiet,
  concentrated state. The accent is concentrated around entering flow and the
  active timer rather than distributed across every control.
- **Meshing:** the created gradient is the hero content. The chrome remains
  largely neutral so the artifact dominates.
- **Dayloop:** warm orange, red, and dark brown evoke memory, film, and time.
  The imagery and date treatment become part of the product's signature.
- **Payout:** saturated blue, cyan, green success states, bold illustration, and
  money motifs make a legal process feel like a consumer reward product.
- **ReadHim:** pink and lavender speak directly to the chosen dating-advice
  niche. A single upload action receives the strongest saturation.
- **Vector Guard:** muted public-health green supports trust and environmental
  context. Risk and completion use conventional semantic colors.
- **Heartbeat Hero:** coral store assets create memorability, while the app uses
  white surfaces, blue actions, and green success feedback for clarity.
- **Momental:** dark navy and black reduce visual noise; soft illustrated
  soundscapes and restrained periwinkle accents introduce warmth.
- **Otter Day:** dark, retro-futurist screens and character art make mental math
  feel like a game rather than coursework.
- **Karo:** warm yellow and message-like cards keep task delegation social and
  approachable rather than enterprise-oriented.

The pattern is semantic and emotional consistency, not a color family. In most
app screens, one accent owns the primary action. Store assets may be more
expressive than the in-product interface, but the promise remains recognizable.

### Typography separates brand from operation

The inspected assets often pair expressive display type with a restrained UI
face.

- Dayloop uses a high-contrast serif or italic display treatment for memory and
  time, then a plain sans-serif for controls and explanations.
- Otter Day uses a techno display face for the game fantasy while keeping
  answers and controls legible.
- Payout uses large, heavy, compressed or italic marketing type to communicate
  reward and urgency, while the app uses conventional UI type for settlement
  details.
- Heartbeat Hero and Vector Guard favor large, direct sans-serif hierarchy that
  suits safety-critical information.
- Karo uses informal display lettering around a familiar conversation layout.

Exact font families cannot be confirmed from the raster evidence. The
transferable principle is role separation: use distinctive typography for the
product's emotional thesis, and use a highly readable, scalable treatment for
instructions, live values, forms, and results. Dynamic values such as timers,
money, dates, scores, and percentages also benefit from stable-width numerals.

### Visual hierarchy centers one artifact or number

The strongest screens make the thing the user came for dominant:

- Dayloop centers the photo and scrubber.
- Payout centers estimated value, a settlement card, and its claim state.
- Heartbeat Hero centers current rhythm or depth feedback.
- Momental centers the timer and session state.
- Vector Guard centers the local map, identified species, risk, and next action.
- Karo centers the assigned task card inside a conversation.

Secondary controls remain at the edges or behind menus. This makes the primary
flow easy to demonstrate in a short submission video.

## Predicted attention and interaction maps

These sequences are hypotheses derived from submitted screens. They are not
analytics or eye-tracking results.

| App and critical screen | Predicted focus sequence | Main interaction risk |
| --- | --- | --- |
| Dayloop first-use screen | “Create your life's timelapse” → import/take-one-a-day explanation → **Get Started** | Expressive background and small developer note may compete with the core choice |
| Dayloop timeline | Face/photo → glowing date → scrubber → add or camera action | Decorative digital date style may be less readable at small sizes |
| Payout settlement feed | Brand and estimated payout → **Claim** → deadline/progress → filters | Reward-heavy art can overpromise if eligibility uncertainty is not equally prominent |
| Heartbeat Hero live rhythm | qualitative state → 110 BPM → safe range → rhythm pattern → audio threshold | Several live metrics may overload first-time learners unless the dominant cue is unambiguous |
| Heartbeat Hero result | completion mark → average versus target → performance summary → **Done** | Color must not be the only cue for correct performance |
| Momental start | mode → duration or sound → **Start** | A large sound library can reintroduce the decision load the concept promises to remove |
| Karo group thread | colored assignment card → assignee → task and deadline → completion state | Chat familiarity can cause users to mistake a task for an ordinary message, a problem the team reported iterating on |
| Vector Guard map or identification | local risk → nearby species or match → danger assessment → prevention action | Map density and scientific terms can overwhelm low-literacy users without progressive disclosure |
| ReadHim home | upload-screenshots action → privacy reassurance → Pro state → analysis result | High-stakes relationship guidance needs limitations and uncertainty near the output, not only in settings |
| Gurwi lesson discovery | class image and title → topic filters → lesson start → question and progress | Multiple cards, points, streaks, banners, and navigation can compete with the next lesson action |

## Accessibility, trust, and safety

Several winners treated inclusion as part of the core product rather than a
submission checkbox.

- Heartbeat Hero describes VoiceOver, Dynamic Type, voice guidance, haptics,
  torch pulses, and a Focus mode for ADHD, dyslexia, and other reading needs.
- Meshing added VoiceOver and Voice Control support and exposed more precise
  color editing.
- Vector Guard uses offline data, Spanish-first support, visual guidance, and
  progressive disclosure for low-connectivity and lower-literacy communities.
- Rakun Talk made assistive communication itself the product.
- Hearing Buddy used private, on-device captions and speaker differentiation.
- Dayloop kept photos on-device.
- Momental removed accounts and reduced decisions.

Submission images cannot verify focus order, screen-reader announcements,
contrast, hit targets, reduced-motion behavior, or error recovery. These remain
required test areas for a 2026 project. In medical, relationship, nutrition,
fitness, or career-coaching concepts, uncertainty, professional boundaries,
privacy, and escalation paths must be visible in the product and demo.

## Monetization patterns

The strongest monetization examples answer three questions clearly: what value
is free, what recurring or discrete value is paid, and why the boundary is fair
for this audience.

### Monetization as a value boundary

Karo lets users experience the task model, then restricts collaboration scale
and AI assistance. Dayloop's submitted export screen shows a watermark-removal
control, suggesting a clear output-quality boundary. Heartbeat Hero protects
free safety-critical learning while monetizing advanced practice and granting
students access.

### Monetization as the product mechanism

Vector Guard's 1:50 model made a subscription purchase fund access for
high-risk ZIP codes. This was stronger than a generic “percentage donated”
claim because it connected price, beneficiary, and product access in one
repeatable story. The economic ratio still needs transparent validation before
reuse.

### Hybrid monetization for variable cost

Napkinmatic combined consumable credits with subscription bundles for
AI-generated creative output. This aligns variable inference cost with usage.
The lesson is not to add multiple revenue streams for HAMM; it is to match each
stream to a distinct value or cost behavior.

### Personalization at the paywall

SkillMe adapted paywall copy to the skill selected by the user. Gurwi tested an
immediate subscription prompt and reported a material subscription increase.
Both examples connect the payment message to context. Neither justifies a
generic hard paywall before users understand value.

## Growth, retention, and build-in-public patterns

Growth winners treated distribution as a system that could be described,
measured, and iterated.

- Payout paired high-value search terms, social reach, cross-platform launch,
  and price testing with revenue and payer numbers.
- ReadHim chose a highly discussable niche, used a repeatable meme page,
  partnered with a niche-aligned influencer, and added a physical stunt. The
  repeatable content engine is more transferable to 2026 than the stunt.
- Gurwi validated the original problem through a viral founder video, then
  maintained a long public narrative around product, funding, and education.
- Meshing named the features that community response produced: noise,
  animation, text masking, favorites, and copy behavior.
- Echo Reminder observed users in public and changed keyboard dismissal, voice
  prompts, and onboarding.
- Friendy+ used public feedback to reject close friends as the initial audience
  and focus on professional acquaintances.
- Momental used Reddit demand, a feature board, analytics, and A/B testing to
  double down on soundscapes.
- Cooked This made re-engagement a continuation of the core behavior: log,
  celebrate, return. It avoided treating notification volume as success.

A 2026 growth log must retain dates, hypothesis, channel or product surface,
message, audience, result, cost, product change, and next experiment. Screenshots
of posts without decisions or outcome evidence are weak.

## Technical and architecture patterns

Winning stacks are diverse because the visible product mechanism determines the
technology.

- **SwiftUI plus native frameworks:** Dayloop used Vision, SwiftData, and camera
  and export frameworks. Flowmino used Screen Time. Heartbeat Hero used ARKit,
  high-frequency IMU data, adaptive filtering, AVAudioEngine, and on-device
  feedback.
- **Kotlin Multiplatform plus native seams:** Momental shared the product while
  implementing native audio components per platform. Posturely combined phone,
  laptop, and AirPods signals. Steps Share integrated platform health data.
- **Flutter for simultaneous delivery:** Gurwi and Otter Day used Flutter for
  iOS and Android while building custom content or game systems.
- **React Native for launch velocity:** Payout used React Native for both mobile
  stores with a TypeScript service layer and analytics stack.
- **Offline and on-device choices:** Heartbeat Hero, Hearing Buddy, Dayloop, and
  Vector Guard made privacy, reliability, or access part of the architecture.

The repeated architectural principle is “build the hard thing that creates the
magic, buy or simplify the rest.” Platform choice by itself did not win. The
stack made one differentiating behavior feasible and reliable.

The hidden burdens deserve early research:

- Gurwi's app also required a content editor and proprietary lesson format.
- Vector Guard required trustworthy, local, current public-health data.
- Karo depended on SMS costs and WhatsApp approval.
- Dayloop had image orientation, memory, and coordinate-system risks.
- Heartbeat Hero needed calibration, sensor fusion, and safe communication.
- AI products needed inference cost, latency, privacy, and output limitations.

## Submission and demo patterns

Strong Devpost pages use the standard sections as a narrative rather than a
feature dump.

1. **Inspiration:** Establish a credible human problem or observation.
2. **What it does:** State the mechanism and core loop in plain language.
3. **How it was built:** Explain the hard implementation choice that enables
   the value.
4. **Challenges:** Show a tradeoff, failure, or constraint that required product
   judgment.
5. **Accomplishments:** Present sourced metrics, a difficult working behavior,
   or a meaningful user outcome.
6. **What was learned:** Connect testing or public feedback to a decision.
7. **What's next:** Demonstrate scope discipline and credible continuation.

Visual assets work best when each image carries one promise. Payout's store art
uses “claim cash,” “big brands owe you money,” and a concrete wallet. Heartbeat
Hero uses one training promise per asset. Momental assigns soundscape, instant
start, and streak progress to separate screenshots.

For 2026, the less-than-two-minute video needs to show the target user, the
working app on-device, the core value moment, RevenueCat or ad behavior in
context, and the primary criterion's proof. Judges may never test the build, so
unshown functionality receives no assumed credit.

## What is not a reliable winner pattern

Several visible traits are tempting but weak as general rules.

- **AI usage:** Some winners used extensive AI; others won through native craft,
  domain expertise, or process. AI was decisive only when it improved the
  product, workflow, or historical award criterion.
- **Cross-platform scope:** KMP winners needed both platforms. Many other
  winners shipped one platform and used that platform more deeply.
- **Maximum feature count:** Winners frequently described cuts, MVPs, or one
  strong loop. Gurwi's large system is an exception supported by a longer
  history and existing traction.
- **One visual aesthetic:** Winner palettes and type styles are deliberately
  different.
- **A huge audience:** `#BuildInPublic` explicitly values learning and response,
  not follower count.
- **Generic polish:** Beautiful surfaces without a distinctive mechanism or
  visible criterion evidence do not explain the winning examples.
- **Award-first bolt-ons:** ReadHim was intentionally designed for a launch
  award, but its audience, topic, content formats, brand, and acquisition were
  one coherent system. That is different from adding an unrelated sponsor SDK
  near the deadline.

## Transfer to the 2026 award system

The following mapping identifies which historical evidence is most useful for
current planning.

| 2026 award family | Most useful historical references | Transfer condition |
| --- | --- | --- |
| Grand Prize | Payout, Karo, Gurwi, ReadHim | Add early-release dates, RevenueCat revenue shortlisting, experiment chronology, efficient acquisition, retention, and causal learning |
| `#BuildInPublic` | Meshing, Gurwi, Echo, Friendy+ | Show public artifact → response → product change → lesson; audience size is secondary |
| Design | Flowmino, Dayloop, PitchLab, Heartbeat Hero | Make the innovative behavior, gestures, motion, haptics, and feedback visible and performant |
| Peace Prize | Heartbeat Hero, Hearing Buddy, Vector Guard, MoodHaven | Validate impact mechanism, domain safety, feasibility, access, and reach or depth |
| HAMM | Vector Guard, Napkinmatic, Karo, SkillMe | Make pricing and packaging fit the target market and delivered value; prove conversion or economics |
| Best Game | Crystal Abyss, Otter Day, DrawIt, Party Animals | Prioritize control feel, fun, progression, replayability, art, and genre-appropriate monetization |
| Catvertising | No direct historical first-place equivalent | Ads must add, unlock, or fund value and fit the broader revenue model without breaking the experience |
| Influencer Awards | Use product patterns, not historical equivalence | Start from the exact influencer audience and required job; one influencer category only |
| Ship Kotlin Everywhere | Momental, Posturely, Steps Share, DrawIt | Publish both iOS and Android; share code where valuable and adapt native seams where necessary |
| Most Viral App | ReadHim, Dayloop, ClipUGC | Use Noise, repeatable content or UGC formats, clear value communication, and conversion to downloads |
| Keep Them Coming Back | Cooked This, Voicetree, Friendy+, Camp Notes | Tie OneSignal to a useful moment, segment, suppress fatigue, deep-link correctly, and measure outcome |
| Growth Loop | Friendy+, Momental, ReadHim | Define audience, message, surface, experiment, signal, learning, and next iteration through Layers |
| Funnel Vision | Payout and ReadHim provide acquisition lessons only | Prove the full ad → RevenueCat Funnel → Stripe checkout → app install → entitlement → first-value path |
| Best App for Galaxy | KMP winners provide cross-platform lessons only | Use foldables, multi-window, or Samsung hardware because the core task benefits, and polish the store listing |
| Idea to Income | Payout and Gurwi provide trajectory lessons only | Verify Replit implementation, returning payers, week-over-week transactions, craft, and social pull |

## Category-targeting discipline for 2026

Use one primary award and no more than two secondary non-influencer awards. A
secondary award is natural only when it reuses the same target user, core loop,
implementation, and evidence.

Examples of natural historical alignments include:

- **Vector Guard:** HAMM primary with Peace Prize secondary because the same
  access model and risk workflow create both monetization and social impact.
- **Heartbeat Hero:** Peace Prize primary with Design secondary because the
  same sensor feedback, accessibility, and offline experience prove feasibility
  and craft.
- **Karo:** a Productivity-style primary with Keep Them Coming Back secondary
  only if reminders and follow-up remain essential to task completion.
- **Momental:** Yoga and Fitness or Design as primary with Ship Kotlin secondary
  only if the team can publish and polish both platforms without weakening the
  one-tap experience.
- **Dayloop:** Design primary with Most Viral secondary only if generated output
  naturally produces repeatable content and Noise distribution converts it.

Reject a secondary category when it adds a new persona, a separate home screen,
an unrelated data model, or an SDK surface that exists only for eligibility.
Grand Prize and `#BuildInPublic` are outcomes and evidence programs, not excuses
to enlarge the feature set.

## Recommended decision gate

The research is now broad enough to narrow. Select three 2026 opportunity
families for current audience and pain-point research.

- **Design-led native utility:** one memorable interaction or device capability.
- **Impact plus sustainable access:** Peace Prize with a natural HAMM or Design
  relationship.
- **Focused productivity:** Apple power-user capture and retrieval with useful
  re-engagement.
- **Daily wellness clarity:** personalized movement or recovery with strong
  information restraint.
- **Game or gaming companion:** an intrinsically enjoyable loop, not a utility
  decorated with points.
- **Growth-led consumer concept:** a highly legible, repeatable acquisition or
  UGC format with measurable conversion.

Do not select a final idea at this gate. The next run must research current
audience pain, workarounds, competing apps, pricing, reachable communities,
platform context, and build risk inside the three chosen families.

## Limitations

The historical sources are winner-heavy. A true differentiator study requires
matched non-winning submissions from the same year, platform, and entered
award, but Devpost does not consistently expose entered categories or complete
historical media for non-winners. The findings should therefore be treated as
strong recurring mechanisms, not causal winner predictors.

Several metrics are builder- or organizer-reported and were not independently
audited. Current store listings may differ from the builds judges saw. Visual
inspection covered submitted assets, not keyboard, screen-reader, performance,
purchase restoration, or edge-state testing in installed apps.

## Next steps

Use this report as the evidence base for runs 3 through 5 in
`shipaton-2026-research-prompts.md`. Confirm three opportunity families, then
run current user and competitor research before generating concepts.

## August 8, 2026 independent-research addendum

An independent source pass was completed before this report was compared or
amended. The new pass used live official rules, official winner announcements,
all 39 placed projects, 13 first-place Devpost dossiers, and 13 plausible
non-winning controls. The controls are matched by year, platform, mechanism,
or sponsor eligibility where public evidence permits. Devpost does not always
show which award a non-winner entered, so these comparisons constrain claims
but do not establish why judges selected a winner.

The independent pass confirms this report's main conclusion: the most useful
historical pattern is alignment among the user problem, signature product
mechanism, monetization or sponsor integration, criterion, proof, and demo.
It also requires the following corrections and refinements:

1. **Correct the 2025 Grand Prize criteria.** The official 2025 rules list
   Early and Effective Release first and Growth-by-numbers second. The 2025
   winner recap later printed innovation, execution, feasibility, and
   integration, which conflicts with the rules. Historical interpretation must
   use the rules as controlling.
2. **Keep ReadHim metrics separate.** The official recap reports 5.2 million
   Instagram views, an influencer with more than 2.3 million TikTok followers,
   and `$1,100` MRR after ten days. The Devpost tagline separately claims more
   than six million views. A follower count is not a view count, and the view
   claims may cover different periods.
3. **Date Gurwi metrics.** The official recap reports 13,000-plus users and
   1,000-plus reviews. A Devpost update dated October 3, 2025, reports 17,696
   users, 228 active subscriptions, `$1,145` MRR, `$2,668` total revenue, and
   3.3 million social views. These are separate snapshots.
4. **Narrow the native-technology claim.** Mood Dial and FoxyFocus show that
   native APIs, animation, and polished interaction existed outside the Design
   placements. Native technology becomes persuasive when it produces a clear,
   award-relevant outcome.
5. **Narrow the sponsor-depth claim.** Memory Hammer documented a broader
   OneSignal system and early user metrics outside the placement list. Cooked
   This remains the cleaner example of one valuable, behavior-linked return
   loop; deeper integration by itself was not unique to the winner.
6. **Narrow the KMP claim.** Restia, Kittysplit, and Ask2Color shipped serious
   Kotlin Multiplatform or Compose Multiplatform work. Momental's stronger
   transfer is cross-platform product coherence and low friction, not technical
   complexity alone.
7. **Retain the survivorship-bias warning.** The new controls improve the
   analysis, but award-entry opacity still prevents causal winner claims.

The complete independent artifacts are in the
[Run 0 report](../Run-0/report.md), [winner corpus](../Run-1/winner-corpus.csv),
[Run 2 dossier index](../Run-2/project-dossiers/README.md), and
[independent winner patterns](../Run-0/independent-winner-patterns.md).
