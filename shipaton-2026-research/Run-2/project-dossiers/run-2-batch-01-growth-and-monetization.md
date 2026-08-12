# Run 2 batch 1: growth and monetization

This batch analyzes four winners from Option A: Karo, Payout, ReadHim, and
Vector Guard. Each winner is paired with a plausible non-winning control from
the same event year and at least one matching shipped platform. Controls were
selected for comparable product or award evidence, not because they are weak.

## Karo

**Historical award:** 2024 Most Likely to Make Money, first place.

**Matched control:** HabitBuds, a 2024 iOS habit app using SwiftUI, SwiftData,
CloudKit, and RevenueCat. Both products proposed social accountability as their
business wedge. The decisive matching difference is observable: Karo shipped
the cross-person task loop, while HabitBuds disclosed that its sharing and
accountability feature was still unfinished.

### 1. Track interpretation

The original track scored business viability, design and execution,
monetization strategy, onboarding and paywall design, and ASO. Karo interpreted
the track as a complete commercial system. It emphasized an adoption wedge,
paid boundaries, launch discipline, and store presentation. It did not provide
audited conversion, retention, or unit-economic evidence.

Karo narrowly solved collaboration friction, then reframed the category around
distribution: ordinary delegation exposes Karo to a recipient who has not
installed it. HabitBuds also used a social thesis, but the judged build only
tracked individual habits. The control therefore supports the importance of
shipping the differentiating mechanism; it does not prove that social loops or
polish alone caused the result.

### 2. Product thesis

| Element | Karo | HabitBuds control |
|---|---|---|
| Audience | Friends, families, and small teams delegating through chat | People who want friend accountability for habits |
| Trigger | A request appears in WhatsApp, SMS, or conversation | A recurring habit needs completion |
| Pain | Tasks disappear inside conversation; shared tools require adoption | Self-directed routines are easy to skip |
| Workaround | Re-message the person or persuade everyone to install a task app | Video calls, reminders, or a private tracker |
| Job | Get another person to act and know when they finish | See consistency and eventually involve friends |
| Promise | Assign to any contact; Karo delivers, reminds, and reports completion | Track habits through heatmaps, widgets, and reminders |
| Wedge | The assignee can act without installing Karo | Attractive native tracking with a future social layer |
| Founder insight | The builder observed tasks sent by his mother and wife getting lost | Group video workouts made accountability easy during lockdown |

### 3. Core loop

Karo's entry trigger is a task that needs another person. The sender selects a
contact, writes the task, adds timing or an attachment, and sends it. The value
moment occurs when delivery succeeds outside the app and the sender later sees
completion. Reminders and completion notifications close the loop. Recurring
delegation creates repeat use, and delivery to non-users creates product
exposure. Collaboration and AI limits create the monetization moment.

HabitBuds' observed loop is create habit, receive reminder, mark completion,
and see the heatmap or widget change. That is coherent, but the planned
friend-accountability and sharing behavior is absent from the shipped loop.

### 4. Journey

Karo's likely acquisition path was press, App Store featuring, or receiving a
task. Its store assets lead with “still using messaging apps to delegate
tasks?” First launch must explain the task-versus-chat distinction and request
contacts and notification access at a moment tied to delegation. The first
value can occur before a network is built because an assignee can use WhatsApp
or SMS. The visible journey then moves through task creation, delivery,
completion, and confirmation.

The free tier lets a user understand the model before collaboration and AI
limits create a paywall. Purchase, cancellation, restore, delivery failure,
expired links, denied contacts, WhatsApp failure, and SMS fallback are material
recovery paths. Only the fallback strategy is described; the screens are not
all visible. HabitBuds has a simpler permissions and first-value journey, but
its missing social loop delays the product's stated transformation.

### 5. UI and interaction

Karo uses a people-first information architecture: a home summary for personal,
sent, later, and completed tasks, then chat-like group or person views. Task
bubbles distinguish “assigned to you” from “assigned by you.” This borrows a
familiar messaging model while adding checkboxes, deadlines, and attachments.

**Predicted attention map, not analytics:** First fixation is likely the large
central phone and yellow task bubble. The scan path moves to the hand-drawn
annotations, WhatsApp symbol, and completion notification. The primary action
is task composition and assignment; secondary actions are filters, groups,
attachments, and completion. Bottom-screen composition appears thumb-reachable.
The chat metaphor makes vertical scrolling discoverable, while advanced
gestures are unknown. Attention conflicts can arise between decorative notes,
avatars, and task-state detail.

HabitBuds' available visual evidence emphasizes a widget and GitHub-style
heatmap. Its primary action is more obvious but less differentiated. The social
behavior promised by the brand is not visible in the evidence.

### 6. Visual system

Karo uses yellow and warm cream as dominant roles, black for structure, green
for completion, and restrained red for lateness. Rounded cards and chat bubbles
support familiarity. A bold rounded display face and hand-drawn annotations
create an informal family-and-friends brand, while the in-app typography remains
more conventional. Spacing is generous on store panels but task views can
become dense. Contrast appears strong for primary labels; pale metadata needs
verification. Iconography combines system-like task marks with expressive
avatars and stickers.

HabitBuds uses a dark presentation, an iOS home-screen mockup, blue activity
cells, and a conventional widget. It looks native and polished, but the visual
system communicates tracking more strongly than shared accountability.

### 7. UX quality

Karo's time to conceptual value is short because the interaction resembles
messaging. Actual value depends on delivery and another person's response.
The main cognitive risk is distinguishing chat, task ownership, delivery
channel, and state without ambiguity; the builder explicitly reported that
early users mistook the beta for ordinary chat. Trust depends on careful
contacts handling, message consent, delivery transparency, and notification
frequency. Accessibility was roadmap work rather than proven event evidence.
There is dark-pattern risk if collaboration limits block a user only after a
recipient is engaged, but the contemporaneous paywall sequence is not visible.

HabitBuds has lower operational risk and strong privacy claims, but its central
promise exceeds its shipped behavior. Empty, loading, CloudKit conflict, and
sharing-error states remain unknown for both apps.

### 8. Monetization

Karo offered free introductory value, then restricted collaboration and AI.
That boundary aligns payment with repeated delegation rather than basic task
capture. RevenueCat managed products and entitlement experiments. The builder
identified a Blinkist-style paywall and planned free-trial versus paid-upfront
tests. No contemporaneous price or conversion is visible in the reviewed
sources.

HabitBuds implemented onboarding and a RevenueCat paywall even though its most
important paid-worthy social feature was unfinished. That creates weaker value
alignment and a higher risk of monetizing aspiration rather than delivered
outcome.

### 9. Growth and retention

Karo's acquisition hooks were the contrarian category claim, recognizable chat
behavior, press, App Store featuring, and task delivery to non-users. Smart
reminders and completion feedback support utility retention. The submission
reported press and featuring but no cohort or conversion metric. HabitBuds had
widgets and notifications for habit retention but lacked its intended social
acquisition loop.

### 10. Technical and operational shape

Karo combined SwiftUI and UIKit with a Go backend on AWS, Twilio, WhatsApp
Business, and RevenueCat. The architecture introduced multiple external
dependencies, consent and anti-spam obligations, message cost, country
coverage, and delivery failure modes. The builder moved load toward WhatsApp
because Twilio was expensive. Scaling therefore affects both cost and policy
risk. HabitBuds used a smaller Apple-native stack, but SwiftData and CloudKit
version changes blocked its differentiating sharing feature.

### 11. Submission craft

Karo's Devpost opens with a one-sentence mechanism, then repeats it through a
bright video cover and four coherent panels. The screenshots sequence problem,
non-user delivery, reminders, groups, attachments, and completion. The icon is
a yellow rounded square with a black check, which remains legible at small
sizes. Proof visibility is strongest for the workflow and press story, not for
revenue. The demo's recovered transcript contains music rather than narration,
so the visual sequence carries most of the explanation.

HabitBuds presents an attractive feature set and widget, but its own text tells
judges that the core social mechanism is missing. That is honest and useful,
but it weakens observable completion against a business-viability rubric.

### 12. Rubric mapping

Scores are analyst estimates, not judges' actual scores.

| 2024 criterion | Karo evidence | Counterevidence | Score | Control score | Confidence |
|---|---|---|---:|---:|---|
| Overall business viability | Specific adoption wedge, broad delegation market, press, store featuring | No retention, revenue, or conversion metric | 5 | 3 | High |
| App design and execution | Shipped end-to-end non-user delivery and feedback loop | Earlier chat confusion; several external failure modes | 4 | 3 | High |
| Monetization strategy | Collaboration and AI limits match repeated value | Price, conversion, and willingness to pay unknown | 4 | 2 | Medium-high |
| Onboarding and paywall design | Familiar metaphor and described Blinkist paywall | Contemporaneous onboarding and paywall screens not fully recovered | 4 | 3 | Medium |
| ASO best practices | Distinctive name, mechanism-led panels, featuring and press | Keyword rank and product-page conversion unknown | 4 | 3 | Medium-high |

### What the evidence supports

Karo shipped its defining cross-person loop, made the recipient side work
without installation, paired it with an aligned paid boundary, and made that
mechanism highly visible in store and submission assets.

### What remains unknown

Event-period price, trial structure, conversion, retention, message delivery
success, consent handling, accessibility quality, cancellation, restore, and
support burden remain unknown.

### What may transfer to 2026

A strong transfer is to make the product's wedge observable in the first demo
minute and to ensure the paid boundary follows delivered value. “Social” alone
does not transfer; the control shows that the network behavior must ship.

## Payout

**Historical award:** 2025 Grand Prize: Build & Grow, first place.

**Matched control:** PCOS Polly, a 2025 iOS consumer subscription app built with
Expo, Firebase, RevenueCat, OneSignal, and Gemini. Both launched paid consumer
products and reported acquisition and subscriber results. PCOS Polly launched
late and on one store; Payout reported a ten-day v1, both stores, and a much
larger evidence trail.

### 1. Track interpretation

The original rubric scored Early and Effective Release before Growth by
numbers. Payout interpreted it literally: ship a narrow v1 quickly, then run
pricing, keyword, notification, and acquisition work with measurable results.
It emphasized release speed and scale. It ignored detailed disclosure of
experiment baselines, cohorts, spend, retention, and attribution quality.

PCOS Polly also presented strong growth evidence, so numbers alone are not a
winner-only trait. Payout's broader interpretation combined early dual-store
availability, multiple analytics systems, high-value search intent, and a
repeat status journey.

### 2. Product thesis

| Element | Payout | PCOS Polly control |
|---|---|---|
| Audience | US consumers eligible for class-action settlements | Women managing PCOS symptoms and routines |
| Trigger | A new settlement involving a known brand | A diagnosis, symptom flare, meal, medication, or daily routine |
| Pain | Notices are obscure, legalistic, and easy to miss | Advice is fragmented and daily self-management is complex |
| Workaround | Search settlement sites, parse notices, or ignore them | Research across clinicians, social media, notes, and trackers |
| Job | Find eligible money, act before deadlines, and track payment | Turn research into a personalized daily management routine |
| Promise | Discover brands that owe you money and claim in a few taps | Get the PCOS tools and guidance the founder wished she had |
| Wedge | High-intent cash outcome and recognizable brands | Founder insight, condition specificity, and an evolving flower |
| Founder insight | Unclaimed money persists because discovery and comprehension fail | The founder improved symptoms only after prolonged research and experimentation |

### 3. Core loop

Payout's loop is discover settlement, read plain-language eligibility, claim or
mark progress, see an estimated wallet, receive status nudges, and return for
new cases. The money estimate is the value moment. New settlements and slow
administrator timelines create repeat triggers. Recognizable brands and cash
claims create shareable acquisition material. Subscription access occurs near
high-intent discovery or tracking.

PCOS Polly's loop is follow a routine, log food, symptoms, or medication, grow
Polly, and return through reminders. Its value accumulates over days, while its
paywall follows personalized onboarding before the benefit is demonstrated.

### 4. Journey

Payout acquired users through high-value keywords, social impressions, and
brand-specific settlement content. The event-period store panel sequence leads
with social proof, “claim cash in a few taps,” and known brands, then shows a
wallet and settlement feed. First launch likely requires legal framing,
notification rationale, and account or tracking choices. First value can be an
eligible settlement or estimated payout without waiting for payment.

The repeat journey is unusually long: administrators can take months. A status
timeline and “still waiting” nudges bridge the delay. Recovery must handle
ineligibility, expired cases, administrator changes, rejected claims, uncertain
payout, account restoration, and legal complaints. These paths are described
only partially. PCOS Polly's journey has richer daily retention but a more
aggressive paywall position and greater medical-safety exposure.

### 5. UI and interaction

Payout uses a conventional bottom-tab product with a settlement feed, wallet,
status labels, filter chips, recognizable logos, due dates, estimates, and a
blue claim button. The architecture prioritizes scan-and-act behavior.

**Predicted attention map, not analytics:** The first fixation is likely the
Payout logo or blue estimated-payout card. The scan path moves to brand logo,
dollar amount, deadline, and **Claim**. Primary actions are opening or claiming
a settlement; secondary actions are filtering and tracking. Buttons and tabs
are thumb-reachable. Decision density can rise when eligibility, proof,
deadlines, claim status, and legal disclaimers compete for attention. Gesture
requirements are not evident.

PCOS Polly's screenshot uses a native sheet, large symptom cards, a pastel pink
accent, and a disabled bottom action until selection. It is readable but long,
and it asks users to make many health choices before outcome evidence appears.

### 6. Visual system

Payout uses electric blue as brand and action, green as completed, gray for
secondary status, and white cards for clarity. Bold rounded headings and money
imagery create an energetic consumer-finance tone. Store panels have strong
hierarchy but make aggressive claims such as “Big Brands owe you money.”
Recognizable logos shorten comprehension while introducing trademark and
expectation risk.

PCOS Polly uses pink, cream, white, and brown typography. Rounded cards and
plain-language symptom descriptions feel gentle. The visual hierarchy is
clear, but the long list and light secondary text need accessibility testing.

### 7. UX quality

Payout can deliver first perceived value quickly, but actual cash is delayed
and uncertain. Trust depends on accurate eligibility, source dates, disclaimers,
proof requirements, and explicit separation from legal advice. The submission
says disclaimers and opt-ins were built into every screen. Empty, stale-data,
claim-rejection, and recovery states are not visible. A dark-pattern risk exists
if estimated payouts or “no proof required” copy overstate certainty.

PCOS Polly offers a specific and empathetic experience, but AI chat, meal
ratings, and symptom guidance enter medical territory. Its control strength is
real growth; its greater weakness is evidence and safety, not execution effort.

### 8. Monetization

Payout uses subscriptions around recurring discovery, alerts, and tracking.
RevenueCat supported entitlements and pricing tests. The product's potential
financial upside can justify payment, but value timing is mismatched when a
claim pays months later. Contemporaneous price, trial, package mix, refunds,
and LTV are not disclosed.

PCOS Polly placed a RevenueCat paywall after personalized onboarding and
reported 40+ paying customers and $3.5K ARR by September 30. A later October 7
update reported $11.1K ARR. Those snapshots are strong but must remain dated.
Its paid boundary appears earlier than observable outcome.

### 9. Growth and retention

Payout reported 17,000+ users, $30,017 revenue, 1,750+ paid subscriptions, and
500,000 social impressions. The submission links pricing A/B tests, LTV
learning, keyword capture, and status nudges to the growth strategy but does not
show experiment-level attribution. The award ceremony adds that paid marketing
was visible in the submission.

PCOS Polly reported 40K TikTok views, 300+ installs, and 40+ paying customers
without paid ads or influencers. It is a strong control because it demonstrates
conversion and founder-led content despite a late launch. Payout's scale,
earlier release, dual-platform reach, and experiment breadth are clearer
differences than the mere presence of metrics.

### 10. Technical and operational shape

Payout used React Native, Node and TypeScript, Vercel, RevenueCat, Adjust, and
Mixpanel. Cost drivers include settlement ingestion and verification,
notifications, analytics, acquisition, legal review, and support. Data freshness
and source provenance are operationally central. The submission says the app
was AI-generated with Claude Code and Cursor, which accelerated release but is
not evidence of reliability.

PCOS Polly used Expo, Firebase, OneSignal, Gemini, and RevenueCat. Its ongoing
AI, health-data, notification, and safety burden may exceed Payout's technical
complexity even though it launched on one platform.

### 11. Submission craft

Payout's private embedded video is a material current evidence gap. The Devpost
story compensates with a terse hook, a strong visual store carousel, a metrics
block, a clear technology list, and named lessons. The icon is bold, game-like,
and money-coded. The strongest proof is numeric and judge-visible; the weakest
proof is experiment causality and the exact product flow.

PCOS Polly presents more product detail and a public demo. Its submission is
credible because it dates both the event-period and post-deadline ARR snapshots.
Payout is more compressed and outcome-led.

### 12. Rubric mapping

| 2025 criterion | Payout evidence | Counterevidence | Score | Control score | Confidence |
|---|---|---|---:|---:|---|
| Early and Effective Release | v1 in 10 days; iOS and Android; narrow discovery and notification loop | Exact release date and first-version feature set not independently verified | 5 | 3 | High |
| Growth by numbers | Users, revenue, subscribers, impressions, pricing tests, keywords, and paid campaigns | Metrics are builder-reported; spend, retention, cohorts, and attribution absent | 5 | 4 | High for reported values; medium for causality |

### What the evidence supports

Payout showed an early, market-facing release and a substantially larger set of
commercial outcomes than most public entries. Its long payout delay was treated
as a retention problem rather than ignored.

### What remains unknown

Acquisition spend, profitability, refund rate, trial conversion, retention,
claim success, legal-review depth, data accuracy, pricing variants, and the
private demo flow remain unknown.

### What may transfer to 2026

Release timing only matters when it creates time for experiments and dated
results. The control shows that a late launch can still convert; Payout shows
why earlier release expands the number of observable decisions and outcomes.

## ReadHim

**Historical award:** 2025 Buzziest Launch, first place.

**Matched control:** Monk, a 2025 native iOS focus app. Both were designed for a
highly specific young audience, used identity-heavy creative, held an in-person
launch activation, generated organic social reach, and reported trials or paid
results. Monk is a deliberately strong control.

### 1. Track interpretation

The rubric scored visibility, creative launch tactics, and audience engagement
and reach. ReadHim built the product itself around marketability. It emphasized
a controversial one-line question, meme distribution, a niche influencer, and
an extravagant local stunt. It gave less attention to safety, consent,
relationship-advice quality, and long-term retention.

Monk interpreted the same launch problem through identity and culture: a film,
Instagram stunt, and Yale event where 50 students entered “Monk Mode.” Because
both controls score strongly on all surface criteria, the evidence supports a
difference in scale and audience-product fit, not a unique use of stunts.

### 2. Product thesis

| Element | ReadHim | Monk control |
|---|---|---|
| Audience | Young women evaluating romantic text conversations | Gen Z students concerned about distraction and “brainrot” |
| Trigger | Ambiguous, inconsistent, or concerning messages | A planned deep-work, morning, or digital-sunset ritual |
| Pain | Emotion and uncertainty make intent hard to judge | Scrolling undermines focus and identity |
| Workaround | Ask friends, search dating advice, or reread messages | Screen Time, blockers, timers, or willpower |
| Job | Decide what the conversation means and what to say next | Enter a focus ritual and see progress as identity |
| Promise | Upload his texts; know what he means; get a reply | Become the kind of person who chooses disciplined focus |
| Wedge | Mild controversy and shareable verdicts | Cinematic status language and cultural belonging |
| Founder insight | The team heard repeated stories of toxic or unclear dating interactions | The founder believed identity and status drive Gen Z adoption |

### 3. Core loop

ReadHim's trigger is uncertain romantic communication. The user uploads up to
five screenshots, identifies speakers, selects a goal, receives a verdict and
red-flag analysis, copies a suggested reply, and can share the report. The
verdict is the value moment. New messages create repeat triggers; screenshots,
reports, and controversy create share behavior; analysis access creates the
subscription moment.

Monk's loop is choose a ritual, block distracting apps, complete focus time,
and update a Monk Mode score. Identity content, challenges, and events create
sharing. It has a clearer repeat behavior, while ReadHim has a stronger
episodic social-sharing object.

### 4. Journey

ReadHim acquired users through an Instagram meme funnel, Trinity Blair's dating
audience, and an IRL nightclub stunt. The store sequence moves from the
question “keeper or red flag?” to upload, intent verdict, and personalized
reply. First launch must explain screenshot privacy and obtain photo access.
The first value requires upload, OCR, speaker correction, analysis, and a goal.

The repeat journey follows new conversations. Purchase and trial occur before
or during analysis, but price and exact placement are unknown. Recovery paths
include bad OCR, missing context, mixed speakers, unsupported claims, model
failure, deleted screenshots, purchase restore, and harmful advice. None is
fully documented. Monk has permission and Screen Time API friction but a lower
interpersonal safety burden.

### 5. UI and interaction

ReadHim uses a short linear architecture: upload, speaker labeling, goal,
analysis, verdict, red-flag score, and response options. Pink/magenta actions,
rounded cards, and conversational copy match the dating audience.

**Predicted attention map, not analytics:** First fixation is the provocative
headline, then the large upload button. The scan path continues to “what he
really means,” the green verdict, red-flag score, and copyable replies. Primary
actions are upload and analyze; secondary actions are speaker correction,
goal selection, copy, and share. Bottom actions appear reachable. The analysis
screen has high decision density and an authority conflict: a friendly visual
system presents uncertain inference as a firm verdict.

Monk's recovered visual evidence is strongest for launch theater, not app UI.
That is appropriate for a launch rubric but limits direct usability comparison.

### 6. Visual system

ReadHim uses deep navy and violet store backgrounds, white high-impact type,
pink gradients, and soft pink in-app surfaces. Green signals positive verdicts;
red flags are quantified. Large rounded sans-serif headings make the sequence
easy to scan. Tilted device compositions create energy. The brand is distinct
but gender-coded and may narrow who feels represented.

Monk uses a black, red, and cinematic “Bruce Wayne” aesthetic. Its event
photography shows a dark auditorium, dramatic red light, and a founder onstage.
It is more status-oriented and less product-explanatory than ReadHim's assets.

### 7. UX quality

ReadHim can produce a first result in minutes, but the cognitive and emotional
stakes are high. It asks users to upload private conversations involving people
who did not consent. Trust requires deletion policy, encryption, model limits,
uncertainty language, and crisis or abuse routing. The phrase “evidence backed
verdict” is not supported by disclosed validation. Suggested manipulation to
“get what she wants” introduces safety and ethics risk. A paywall during
emotional uncertainty could exploit vulnerability.

Monk uses aggressive identity framing and a $99 annual trial offer. Its dark
pattern risk is status pressure rather than intimate inference. Both controls
show that strong branding can increase persuasion and risk simultaneously.

### 8. Monetization

ReadHim used a RevenueCat subscription and free trials; a special discount code
connected the meme funnel to conversion. Price and packaging are not visible.
The paid unit aligns with an analysis result, but episodic use may create churn.
Monk reported 100+ trial activations on $99 annual plans in 48 hours. Its annual
commitment is ambitious for a newly launched habit product.

### 9. Growth and retention

ReadHim reported 5.2M Instagram views, more than 0.5M views through the
influencer, 6M organic views overall, more than 1,000 influencer-driven
downloads, hundreds of trials, and $1,100 MRR after ten days. These figures
have overlapping scopes. Monk reported 1,000+ downloads, 50K+ YouTube views,
150K+ Instagram views, 30+ reposts, 150+ five-star reviews, and 100+ trials in
48 hours with no paid ads or influencers.

The control demonstrates that an IRL activation, high-craft creative, and
conversion proof were not exclusive to the winner. ReadHim's documented reach
was substantially larger and the influencer matched the exact audience and
problem.

### 10. Technical and operational shape

ReadHim used SwiftUI, a Vercel endpoint, OCR, a fine-tuned GPT-OSS-120B model,
and RevenueCat. Costs include model inference, image processing, secure data
handling, moderation, and support. App Review required four or five rounds.
The team shipped a UI and model update on September 24 after feedback.

Monk used Swift, Screen Time APIs, and RevenueCat. Its main risks were system
permission complexity, blocking reliability, and sustaining an identity-led
community.

### 11. Submission craft

ReadHim's three-minute video opens with the exact award goal, states results in
the first minute, explains product-market design, then moves through build,
influencer distribution, stunt, and outcomes. The Devpost repeats this arc and
uses media to show product, social proof, and the live event. Metrics are
visible and memorable, though repetitive and unaudited.

Monk's submission is shorter but similarly strong: a cultural thesis, specific
launch assets, an IRL proof image, and dense metrics. ReadHim is more explicit
about award interpretation and revenue.

### 12. Rubric mapping

| 2025 criterion | ReadHim evidence | Counterevidence | Score | Control score | Confidence |
|---|---|---|---:|---:|---|
| Visibility | Meme page, niche influencer, nightclub activation, App Store | No channel-level attribution or paid-partnership cost | 5 | 5 | High |
| Creativity | Product designed for discussability; supercars and robot dog | Spectacle may not create repeatable acquisition | 5 | 5 | High |
| Audience engagement and reach | Multi-million reported views, downloads, trials, and MRR | Overlapping builder-reported scopes; no retention | 5 | 4 | High for claims; medium for attribution |

### What the evidence supports

ReadHim aligned product premise, target audience, influencer, meme content,
share object, physical stunt, and revenue evidence around one launch objective.

### What remains unknown

Price, churn, influencer economics, paid versus organic definitions, safety
evaluation, privacy controls, advice accuracy, consent, moderation, and
long-term brand durability remain unknown.

### What may transfer to 2026

Distribution works best when the product itself produces a discussable artifact
for a specific audience. The control prevents a weaker conclusion: high-craft
events and organic metrics alone did not uniquely distinguish the winner.

## Vector Guard

**Historical award:** 2025 HAMM, first place.

**Matched control:** Vega, a 2025 iOS Flutter product with RevenueCat and
OneSignal. Both target serious information problems, use AI-assisted capture,
and need sustainable subscription economics. Vector Guard exposes a novel
cross-subsidy; Vega discloses only a standard subscription.

### 1. Track interpretation

HAMM scored monetization clarity, creativity, and financial viability. Vector
Guard interpreted monetization as part of the social mechanism: each $2.99
subscription was said to fund 50 free accounts in high-risk ZIP codes. It
emphasized clarity and originality. It did not disclose the cost model,
eligibility automation, actual funded accounts, or conversion.

Vega shipped a broad subscription finance tool, but the submission does not
show which features are free, which are paid, or why the package is distinctive.
The control supports the value of making monetization legible inside the product
thesis; it does not validate Vector Guard's economics.

### 2. Product thesis

| Element | Vector Guard | Vega control |
|---|---|---|
| Audience | Outdoor users plus rural, farmworker, and Indigenous communities | Expats, freelancers, students abroad, and remittance households |
| Trigger | Local vector risk, a bite, or an unknown insect | A purchase, receipt, budget limit, debt, or multi-currency balance |
| Pain | Public-health data is technical, fragmented, and inaccessible offline | Multi-currency tracking is tedious and conventional apps feel clumsy |
| Workaround | Search CDC pages, identify manually, or seek care without context | Spreadsheets, bank apps, manual conversion, and receipt entry |
| Job | Identify a vector, understand local risk, prevent exposure, and decide next action | Capture transactions and understand finances across currencies |
| Promise | Put local disease-vector knowledge and first aid in a private offline app | Make global personal finance flexible through chat, voice, and receipt capture |
| Wedge | Researcher insight plus a 1:50 access model | Multi-modal capture and multi-currency normalization |
| Founder insight | A public-health PhD student saw research remain inside papers and government sites | A freelancer personally managed USD income and VND spending |

### 3. Core loop

Vector Guard begins with local risk, a sighting, or a bite. The user explores a
map or captures an image, receives a species and risk result, opens prevention
or first-aid guidance, and returns when conditions or exposure change. The
value moment is an actionable answer: what is it, is it dangerous, and what
next? A premium purchase simultaneously unlocks value and claims to fund free
access elsewhere.

Vega's loop is capture transaction, confirm categorization and currency,
review balances or budget, receive a limit notification, and return. It has a
stronger natural frequency but a less distinctive payment story.

### 4. Journey

Vector Guard likely acquires through public-health, outdoor, search, and local
risk contexts. First launch must explain location, camera, photo, offline data,
and medical limits before asking permissions. First value can come from a map
without a bite, or from identification after an image. The visible treatment
journey uses first-aid steps and tabs for medical care and prevention.

Recovery must handle low-confidence images, unsupported species, denied
location, stale CDC data, offline model limits, urgent symptoms, and mistaken
identification. These paths are largely unknown. Vega has more conventional
financial trust and categorization recovery paths, but its interface exposes
more screens and ongoing data synchronization.

### 5. UI and interaction

Vector Guard uses map, identify, treatment, and settings destinations. Results
show confidence, species, risk level, characteristics, and prevention tips.
Treatment uses numbered cards and bottom tabs.

**Predicted attention map, not analytics:** On identification, first fixation
is the green completion check and confidence value, then species, risk level,
and bullet list. On treatment, the scan path moves from the condition title to
the numbered first-aid cards and the medical-care tab. Primary actions are
camera/upload and map exploration; secondary actions are filters and tabs.
Bottom navigation is reachable. Dense small body text and a green success
symbol can overstate certainty when confidence is imperfect.

Vega's purple-gradient interface has five bottom tabs, an AI composer, charts,
calendar, budget, savings, and debt cards. It is capable but has higher decision
density and a mascot competing with financial data.

### 6. Visual system

Vector Guard uses pale green as public-health reassurance, darker green for
actions and status, white device surfaces, and restrained risk colors. The
visual system is calm and legible at heading level. Body text in the submitted
panels is small, and relying on red, yellow, or green risk needs non-color
labels. Illustration and field photography are functional rather than
decorative.

Vega uses lavender and violet gradients, white cards, colorful category icons,
and a friendly robot mascot. It feels more consumer and expressive but less
information-restrained.

### 7. UX quality

Vector Guard promises immediate, offline, zero-personal-data access, Spanish,
visual guides, and progressive disclosure. Those are strong trust choices if
implemented as described. Safety risk remains high: an identification can
change care-seeking behavior. “90% confidence” and a green check need explicit
uncertainty and escalation. The demo says the app can say whether a user should
seek medical care, but no clinical validation or regulated-device analysis is
provided.

Vega handles financial data and AI categorization, with timezone and currency
complexity. Both need clear error correction. Vector Guard has lower routine
data collection but higher consequence per wrong answer.

### 8. Monetization

Vector Guard's free value and premium boundary are not fully enumerated. The
visible price is $2.99, and each subscription is described as funding 50 free
accounts in high-risk areas. RevenueCat provides subscription management. The
narrative tightly aligns payment and purpose, but the 1:50 claim needs a cost,
allocation, fraud, eligibility, and reporting model.

Vega uses RevenueCat subscriptions and OneSignal engagement but does not
disclose price, trial, packages, or paid features. Its monetization is easier to
operate and less differentiated.

### 9. Growth and retention

Vector Guard's acquisition hook is local risk plus the justice model. Maps,
identification, weather, seasonality, and alerts can create repeat utility.
The submission reports no users, paid conversion, free-account distribution,
or health outcome. Vega's recurring financial capture offers stronger natural
retention, but it also reports no adoption metric.

### 10. Technical and operational shape

Vector Guard describes Swift, CDC data transformation, an offline local
database, on-device image recognition, weather, sightings, localization, and
zero personal-data collection. Operational work includes scientific updates,
model evaluation across image conditions, geographic data, high-risk ZIP-code
rules, localization, and medical-content governance.

Vega uses Flutter, Riverpod, Supabase, Edge Functions, Hive or Sembast, OpenAI,
Gemini, exchange rates, OneSignal, and RevenueCat. It has more service
touchpoints and variable AI or exchange-rate costs, but a more conventional
liability profile.

### 11. Submission craft

Vector Guard's Devpost is a mission-led essay. Its video is stronger than the
text at showing map, filters, identification, treatment, prevention, and the
payment narrative. The store panel reviewed here demonstrates results and
first aid, but the submission gives no outcome metrics. The icon and complete
store sequence need deeper archive access.

Vega presents a dense four-screen interface image and detailed architecture.
Its sponsor integrations are visible, but the subscription value boundary is
not judge-observable from the extracted evidence.

### 12. Rubric mapping

| 2025 criterion | Vector Guard evidence | Counterevidence | Score | Control score | Confidence |
|---|---|---|---:|---:|---|
| Clarity of Monetization Strategy | $2.99 price and 1:50 promise are memorable and tied to access | Free and paid feature boundaries and allocation mechanics absent | 5 | 3 | High |
| Creativity of Monetization Strategy | Subscription cross-subsidizes high-risk communities | Model resembles buy-one-give-many and is not operationally verified | 5 | 2 | High for concept; medium for implementation |
| Financial Viability | Broad outdoor market and low marginal digital distribution are plausible | No costs, conversion, subsidy accounting, or funded-account evidence | 3 | 3 | Medium |

### What the evidence supports

Vector Guard made monetization part of the product's ethical thesis and
communicated it with unusual clarity. The product also used a founder's domain
expertise to simplify a concrete information gap.

### What remains unknown

Free-versus-paid features, 1:50 economics, actual account allocation, price
duration, conversion, scientific update process, image-model accuracy,
regulatory analysis, and health outcomes remain unknown.

### What may transfer to 2026

An unusual model transfers only when the user can understand the exchange and
the builder can prove it operates. A standard subscription can still work, but
the control shows it supplies little HAMM-specific evidence without explicit
packaging and economics.

## Batch evidence and uncertainty ledger

| Source | Date | Tier | Timing | Use | Confidence |
|---|---|---|---|---|---|
| [2024 official rules](https://revenuecat-ship-a-ton.devpost.com/rules) | Event-period | A | Contemporaneous | Karo rubric | High |
| [2025 official rules](https://revenuecat-shipaton-2025.devpost.com/rules) | Event-period | A | Contemporaneous | Payout, ReadHim, and Vector Guard rubrics | High |
| [2024 official winners](https://www.revenuecat.com/blog/company/2024-ship-a-ton-winners) | September 23, 2024 | A | Contemporaneous recap | Placement and organizer description | High |
| [2025 official winners](https://www.revenuecat.com/blog/company/shipaton-2025-winners) | October 13, 2025 | A | Contemporaneous recap | Placement and organizer description | High |
| [Karo Devpost](https://devpost.com/software/karo-trj4av) and [video](https://www.youtube.com/watch?v=G5_DsAv1nVQ) | Event-period; observed August 9, 2026 | B | Contemporaneous artifacts | Product, stack, media, launch claims | High for visible evidence; medium for claims |
| [Payout Devpost](https://devpost.com/software/payout-cwdniv) | Event-period; observed August 9, 2026 | B | Contemporaneous artifact | Product, stack, metrics, experiments | Medium-high; video is now private |
| [ReadHim Devpost](https://devpost.com/software/readhim) and [video](https://www.youtube.com/watch?v=eQtuOMOvMuE) | September 2025 | B | Contemporaneous | Product, launch arc, metrics | Medium-high |
| [Vector Guard Devpost](https://devpost.com/software/vector-gaurd) and [video](https://www.youtube.com/watch?v=hXMVHLRPAfI) | Event-period | B | Contemporaneous | Product, UI flow, monetization thesis | High for description; medium for feasibility |
| [HabitBuds control](https://devpost.com/software/habitbuds) | 2024 event | B | Contemporaneous | Social-product and execution control | High |
| [PCOS Polly control](https://devpost.com/software/pcos-polly) | September 30 and October 7, 2025 metric snapshots | B | Contemporaneous plus post-deadline update | Growth control | Medium-high |
| [Monk control](https://devpost.com/software/monk-the-monk-mode-app) | September 2025 | B | Contemporaneous | Launch and conversion control | Medium-high |
| [Vega control](https://devpost.com/software/vega-ai-money-tracker) | 2025 event | B | Contemporaneous | Monetization and complexity control | High for description; low for outcomes |
| Devpost screenshot assets extracted with Firecrawl and inspected with vision | Observed August 9, 2026 | B | Contemporaneous submission media | Predicted attention and visual-system analysis | Medium-high |

## Batch contradictions and missing evidence

Payout's embedded Devpost video is now private, so the current analysis cannot
reconstruct its full demo arc. ReadHim's reach figures overlap and cannot be
summed. PCOS Polly's September 30 ARR and October 7 ARR are different snapshots.
Vector Guard's 1:50 model and health claims are described but not operationally
or clinically verified. Monk is a strong control whose public evidence could
plausibly satisfy the Buzziest rubric; why judges ranked it below placed entries
is unknown.

## Batch recommendation

Carry forward, but do not yet synthesize, these candidate observations: shipped
differentiating mechanism, experiment runway, product-distribution alignment,
and judge-visible monetization logic. Each must still be tested against the
remaining winners and the full control corpus.

## Next steps

Continue with Batch 2: Flowmino, Dayloop, and PitchLab, using matched design
controls. Do not select patterns until all five batches are complete.
