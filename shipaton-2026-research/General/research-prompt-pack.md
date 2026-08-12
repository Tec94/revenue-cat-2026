# Shipaton 2026 research prompt pack

This prompt pack turns the Shipaton research into a sequence of decision-gated
runs. It starts with official rules and historical winners, narrows to a small
set of opportunity territories, and ends with one buildable product direction.
Each run stops for your decision. The research agent must not race through the
entire process or generate a large collection of shallow ideas.

## How to use this pack

Use one persistent research task if possible. Paste the shared operating
contract first, then run prompts 0 through 12 one at a time. Give the agent the
previous run's state packet and your decision before starting the next run.

If the agent can create files, ask it to use the following structure:

- Keep shared state, rules, prompt material, and supplied research in
  `General/`.
- Keep every completed stage in `Run-N/`, using `report.md` for the main report.
- Give supporting artifacts descriptive names such as `source-ledger.csv`,
  `scorecard.csv`, `concept-cards.md`, or `project-dossiers/`.
- Add each new run to the research package's root `README.md`.

Do not run more than one decision gate without reviewing the result. The value
of this sequence comes from narrowing the search space, not from maximizing the
amount of generated material.

## Source pack

The research starts with the following primary sources. The local rules file
controls when it conflicts with a screenshot or a historical page.

- 2026 official rules:
  `C:\Users\caoda\.codex\attachments\2dec783a-4a4f-43ca-9a41-802b2fa65095\pasted-text.txt`
- 2026 award screenshots:
  `C:\Users\caoda\AppData\Local\Temp\codex-clipboard-9a6d1f41-0d48-44ed-9b7c-5ff581e68225.png`,
  `C:\Users\caoda\AppData\Local\Temp\codex-clipboard-7167c288-c8c3-43e7-a145-94b97e81b09d.png`,
  and
  `C:\Users\caoda\AppData\Local\Temp\codex-clipboard-2ebc97e0-0ac5-4e43-a2ba-2a115eb48c81.png`
- [2024 Devpost gallery](https://revenuecat-ship-a-ton.devpost.com/project-gallery)
- [2025 Devpost gallery](https://revenuecat-shipaton-2025.devpost.com/project-gallery?page=1)
- [2024 RevenueCat winner announcement](https://www.revenuecat.com/blog/company/2024-ship-a-ton-winners)
- [2025 RevenueCat winner announcement](https://www.revenuecat.com/blog/company/shipaton-2025-winners)
- 2026 Devpost host named in the supplied rules:
  `https://revenuecat-shipaton-2026.devpost.com`

Exa's current default MCP tools are `web_search_exa` and `web_fetch_exa`.
`web_search_advanced_exa` are enabled and ready to use. Firecrawl MCP tools are also enabled and ready to use.

## 2026 constraint capsule

Treat these facts as hard constraints until the official rules change. The
agent must still create a complete rule matrix in run 0.

- The submission period is July 31 through September 30, 2026.
- The first public version must launch during that period.
- The app must target iOS, iPadOS, macOS, or Android. Eligible store releases
  use Apple's App Store, Google Play, or the Samsung Galaxy Store.
- The app must use RevenueCat for at least one in-app or web purchase, or serve
  ads through RevenueCat Ads.
- Judges may evaluate only the description, screenshots, and video. The demo
  video therefore needs to make the product and award evidence observable in
  less than two minutes.
- A project may enter only one Influencer Award. It may also enter eligible
  non-influencer awards.
- Grand Prize shortlisting uses RevenueCat-reported revenue, but final judging
  considers the quality, efficiency, and sustainability of growth.
- Next Gen is student-only and has different repository and store rules.
- Conflict of Interest is limited to eligible RevenueCat or sponsor employees.
- Ship Kotlin Everywhere requires published iOS and Android apps using Kotlin
  Multiplatform or Compose Multiplatform.
- Best App for Galaxy requires a Galaxy Store release. Funnel Vision requires
  RevenueCat Funnels with Stripe. The other sponsored awards also have named
  implementation and proof requirements.
- Testing access, a free trial or promo code where required, a 1024-by-1024 app
  icon, and at least one 1179-by-2556 screenshot without a device frame are part
  of submission readiness.

The 21 award categories shown in the supplied materials are:

- Cross-cutting: Grand Prize and `#BuildInPublic` Award.
- Core: Best Game, RevenueCat Peace Prize, RevenueCat Design, Catvertising,
  Next Gen, HAMM, and Conflict of Interest.
- Influencer: Productivity, Nutrition and Healthy Eating, Career Coaching,
  Gaming, and Yoga and Fitness.
- Sponsored: Ship Kotlin Everywhere, Most Viral App, Best App for Galaxy,
  Replit's Idea to Income, Keep Them Coming Back, The Growth Loop, and Funnel
  Vision.

## Shared operating contract

Paste this contract before the first run. Reuse it if you move the research to
a new task or lose the agent's context.

```text
You are the research lead and decision facilitator for a Shipaton 2026 mobile
or Mac app. This is an evidence-first, staged research project. Work on only the
requested run. Do not continue through a decision gate without my choice.

Use Exa MCP as the primary discovery and content-extraction system:
1. Use web_search_exa for discovery and query variations.
2. Use web_fetch_exa for every important known URL and for the full text needed
   to support a claim.
3. If web_search_advanced_exa is enabled, use domain, publication-date, crawl-
   date, and content filters when they materially improve precision. Do not
   assume it is enabled.
4. Use a browser or vision-capable tool only when a dynamic page, video,
   screenshot, or interactive state cannot be evaluated through Exa. Record
   every fallback.

Prioritize sources in this order:
A. Official Shipaton rules, official winner announcements, historical official
   rules, and the project's contemporaneous Devpost submission.
B. The submission video, contemporaneous App Store or Play Store assets,
   project website, public repository, and builder posts from the event period.
C. Current store listings, credible interviews, press, reviews, support pages,
   and community discussions.
D. Analyst inference.

For every material claim, record the URL, page title, publication or observed
date when available, source tier, whether it is contemporaneous or current,
and a confidence level. Distinguish:
- observed: directly visible in a source;
- described: claimed by the builder or organizer;
- measured: supported by a reported metric and its provenance;
- inferred: reasoned from incomplete evidence;
- unknown: not supported by available evidence.

Do not treat an app's current interface as the interface that judges saw in
2024 or 2025. Prefer submission videos and event-period screenshots. Label
post-event changes. Do not invent screens, prices, architecture, analytics,
user behavior, or judge reasoning.

Do not claim to have an interaction heatmap without analytics, click tracking,
eye tracking, or an observed usability study. When only screens or video are
available, produce a predicted attention and interaction map and label it as a
hypothesis. Include likely first fixation, scan path, primary and secondary
actions, thumb reach, decision density, gesture discoverability, and possible
attention conflicts.

Control for survivorship bias. When a run evaluates what makes winners
different, compare them with matched non-winning entries from the same year,
platform, and award family when evidence is available. Do not call a pattern a
winner differentiator if it appears just as often in the controls.

Separate historical interpretation from 2026 transferability. Fetch the
original wording and criteria for each historical award. Do not equate renamed
awards only because their titles sound similar. Map what persisted, changed,
or disappeared.

Optimize for a coherent product, not award accumulation. Every concept must
have exactly one primary award. It may have no more than two secondary
non-influencer awards, and only when the same audience, core loop, and evidence
naturally satisfy them. A project may use no more than one Influencer Award.
Reject bolt-on features whose main purpose is category eligibility.

Across the research, examine more than surface aesthetics. Include problem
frequency and severity, founder insight, user workarounds, target-segment
specificity, time to first value, information architecture, cognitive load,
permission timing, empty/loading/error/success states, trust, privacy, safety,
accessibility, platform-native behavior, motion, haptics, sound, monetization
fit, retention, distribution, store presentation, instrumentation, technical
and operational feasibility, App Review risk, demo clarity, and the evidence a
judge can observe.

End every run with:
1. A concise executive summary.
2. The requested structured artifact.
3. An evidence and uncertainty ledger.
4. Contradictions or missing evidence.
5. A recommendation with reasons, not a decision made for me.
6. One explicit decision gate with a small set of choices.
7. An updated RESEARCH_STATE block that I can paste into the next run.
```

## Reusable research state

Carry this state between runs. Preserve rejected directions and reasons so the
agent does not repeatedly reintroduce them.

```yaml
RESEARCH_STATE:
  completed_run: 0
  rules_version_observed:
  builder_constraints:
    team_and_skills:
    available_hours:
    budget:
    eligible_platforms:
    developer_accounts:
    student_status:
    sponsor_employee_status:
    geography_and_store_access:
    backend_and_ai_tolerance:
    regulated_or_sensitive_domains_to_avoid:
  selected_primary_award:
  allowed_secondary_awards: []
  shortlisted_award_families: []
  selected_opportunity_territories: []
  selected_problems: []
  shortlisted_concepts: []
  selected_concept:
  selected_ux_direction:
  selected_visual_direction:
  rejected_directions: []
  accepted_evidence: []
  unresolved_questions: []
  next_decision:
```

## Run 0: Normalize rules and builder constraints

This run creates the legal and strategic boundary before the agent studies
winners or proposes ideas.

```text
RUN 0 — RULES, ELIGIBILITY, AND BUILDER CONSTRAINTS

Read the supplied 2026 rules file in full and inspect all three award-category
screenshots. Use Exa to fetch the current official 2026 Devpost overview,
rules, prize pages, sponsor pages, and any official updates that could modify
the supplied document. Record the observation date. Treat the supplied
official rules as controlling unless a newer official amendment clearly says
otherwise. Flag every discrepancy; do not silently reconcile it.

Create a complete matrix for all 21 awards with:
- exact award name and award family;
- short purpose statement;
- eligibility gates and disqualifiers;
- required platform, store, SDK, service, account, or release;
- required submission evidence;
- every judging criterion in order;
- tie-break implication from criterion order;
- what a judge must be able to observe in the app or submission;
- effort or dependency that is unique to this award;
- whether it can coexist with an Influencer Award;
- confidence and source URL or local-source reference.

Create a separate global compliance checklist for release timing, RevenueCat
usage, store access, testing, video, screenshots, app icon, free trial or promo
code, language, IP, third-party integrations, and US availability.

Then produce a short builder intake. Ask only questions that change category
eligibility or product strategy: team and skills, weekly hours, budget,
platform and developer accounts, student status, sponsor employment, geographic
eligibility, current code or assets, native versus cross-platform preference,
backend and AI appetite, access to domain experts or audiences, willingness to
build in public, comfort with sensitive or regulated domains, and any award
families already preferred or rejected.

Do not research winners or generate app ideas in this run.

DECISION GATE: Ask me to confirm the builder constraints, remove ineligible
awards, and select three to five award families for historical research. Also
let me explicitly choose “open exploration” if I do not want to preselect.
```

## Run 1: Build the historical winner corpus

This run creates a reliable inventory before any pattern analysis. It uses the
official blogs as the winner index and the galleries as the project index.

```text
RUN 1 — 2024 AND 2025 WINNER CORPUS

Using the shared operating contract and confirmed RESEARCH_STATE, build a
deduplicated corpus of official 2024 and 2025 Shipaton winners. Start with the
two official RevenueCat winner announcements. Cross-link every winner to its
Devpost page, award and placement, submission video, event-period store listing
or screenshots, project website, repository when public, and event-period
builder posts. Use the gallery winner badges to catch winners missing from a
blog section, but do not assume a badge identifies the award without a second
source.

Fetch the historical rules or award descriptions for both years. Capture the
original track wording and judging criteria that applied to each winner. Build
an explicit rename or comparability map between 2024, 2025, and 2026. Mark
awards as equivalent, partially comparable, or not comparable, with reasons.

For each winner, capture only inventory-level facts:
- year, award, placement, app name, and URLs;
- one-sentence app promise;
- intended audience and stated problem;
- platform and implementation stack if disclosed;
- RevenueCat and monetization use if disclosed;
- evidence types available for later UX analysis;
- quantitative claims and their stated source;
- source dates and whether the artifact is contemporaneous or current;
- gaps, conflicts, and confidence.

Do not yet explain why an app won. Do not use today's App Store presentation as
historical evidence unless it is clearly labeled as current.

Output a CSV-ready corpus table, a source coverage report, and a recommended
deep-dive sample. The sample must represent both years, the selected award
families, different platforms, different business models, and both high- and
low-evidence projects.

DECISION GATE: Ask me to select 12 to 18 winning projects and three to five
award families for deep analysis. If the corpus is smaller, explain the
coverage limit and propose the smallest defensible sample.
```

## Run 2: Tear down winners and matched controls

This run creates project dossiers in small batches. Run it more than once if
the selected corpus is large.

```text
RUN 2 — PROJECT DOSSIERS AND MATCHED CONTROLS

Analyze the selected winners in batches of no more than four. For each award
family in the batch, select at least one reasonably matched non-winning entry
from the same year and platform when public evidence permits. Explain the
matching rationale. Controls are for comparison, not ridicule.

For each app, create a dossier that covers:
1. Track interpretation: original wording, literal requirements, the app's
   interpretation, what it emphasized, what it ignored, and whether it solved
   the track narrowly or reframed it.
2. Product thesis: audience, triggering situation, pain or desire, existing
   workaround, job to be done, promise, wedge, and founder insight.
3. Core loop: entry trigger, primary action, value moment, feedback, repeat
   trigger, share or growth behavior, and monetization moment.
4. Journey: acquisition source, store page, first launch, onboarding,
   permissions, first value, repeat use, paywall, purchase or ad experience,
   retention, sharing, cancellation, and recovery paths.
5. UI and interaction: information architecture, screen hierarchy, likely
   focus points, predicted attention map, navigation model, gestures, feedback,
   motion, haptics, sound, and platform-native conventions.
6. Visual system: color roles and contrast, typography roles and readability,
   spacing, density, iconography, imagery, illustration or art direction, and
   brand distinctiveness. Use visual evidence; mark unknowns.
7. UX quality: time to first value, cognitive load, information restraint,
   empty/loading/error/success states, accessibility, trust, privacy, safety,
   and dark-pattern risk.
8. Monetization: free value, paid value, product type, placement, packaging,
   trial, price when contemporaneously visible, paywall narrative, ad fit,
   RevenueCat's role, and alignment between payment and delivered value.
9. Growth and retention: acquisition hook, ASO, social or UGC loop,
   notifications, habit or utility loop, build-in-public evidence, experiments,
   and reported outcomes.
10. Technical and operational shape: disclosed architecture, platform leverage,
    data and API dependencies, offline behavior, privacy, cost drivers,
    scalability, and release risk.
11. Submission craft: Devpost story, screenshot sequencing, app icon, demo-video
    arc, proof visibility, metric presentation, and judge observability.
12. Rubric mapping: one row per historical judging criterion with evidence,
    counterevidence, confidence, and a clearly labeled analyst score from 1 to
    5. Do not present the analyst score as the judges' actual score.

End each winner dossier with “What the evidence supports,” “What remains
unknown,” and “What may transfer to 2026.” Compare the winner with its control
on the same dimensions and identify similarities as carefully as differences.

DECISION GATE: After all batches, ask me to select the five to eight patterns I
want tested across the full corpus. Do not synthesize them yet.
```

## Run 3: Synthesize cross-year winner patterns

This run tests candidate patterns rather than collecting attractive anecdotes.

```text
RUN 3 — CROSS-YEAR PATTERN SYNTHESIS

Using the completed dossiers and matched controls, test the selected candidate
patterns across the corpus. Add patterns that emerge repeatedly, but label them
as newly observed. Do not count multiple sources about the same app as multiple
instances.

Build a recurrence matrix with projects as rows and candidate patterns as
columns. For each pattern, report:
- frequency among winners and controls;
- years and award families in which it appears;
- quality and amount of supporting evidence;
- plausible mechanism linking it to judging criteria;
- counterexamples and alternative explanations;
- whether it is a general good-app trait or a winner differentiator;
- whether it transfers to the 2026 rubric;
- confidence: high, medium, low, or untestable.

Specifically test, without assuming they are true, whether winners tend to
have: a ten-second value proposition, personal founder insight, a narrow first
version, one memorable interaction, unusually fast time to value, platform-
native leverage, a coherent monetization-value boundary, visible iteration,
measurable traction, a built-in distribution loop, a distinctive visual or
motion signature, strong accessibility or trust, and a judge-ready story.

Create four outputs:
1. High-confidence transferable patterns.
2. Award-specific patterns that must not be generalized.
3. Common practices that do not distinguish winners from controls.
4. Failure modes, evidence gaps, and misleading heuristics.

Then map changes from 2024 to 2025 and test their relevance against the exact
2026 criteria. Identify opportunity spaces implied by the criteria, but do not
generate product concepts yet.

DECISION GATE: Present three to six opportunity territories. Ask me to select
three for audience and pain-point research, with an option to request a new
territory derived from the evidence.
```

## Run 4: Research audiences, pains, and market gaps

This run moves from hackathon history to current user evidence. It avoids broad
market-size theater and looks for problems a small team can reach and test.

```text
RUN 4 — AUDIENCE AND PROBLEM LANDSCAPE

Research the three selected opportunity territories using current sources.
Use Exa query variations to find app reviews, Reddit and forum discussions,
support threads, public communities, professional guidance where relevant,
research papers for safety-sensitive claims, competitor sites, pricing pages,
and current store listings. Favor direct user language and observable
workarounds. Do not infer prevalence from a few vivid posts.

For each territory, identify two to four precise audience segments and analyze:
- triggering situation and job to be done;
- pain frequency, severity, urgency, and emotional stakes;
- current workaround and switching cost;
- what users already pay for, if anything;
- unmet needs and repeated complaints;
- trust, privacy, accessibility, or safety requirements;
- reachable communities and likely acquisition channels;
- platform context and native capabilities that matter;
- content, data, moderation, or expert dependencies;
- adjacent products and substitutes.

Audit five to eight relevant competitors or substitutes per territory. Capture
their promise, onboarding, time to value, core loop, pricing and paywall,
retention mechanism, store positioning, review themes, strengths, weaknesses,
and gaps. Distinguish missing features from missing product value; a feature gap
is not automatically an opportunity.

Create an opportunity scorecard from 1 to 5 for pain strength, segment focus,
evidence quality, reachability, willingness to pay, differentiation, native-
platform advantage, buildability by this team, operational burden, ethical and
store risk, and natural award fit. Show the weighting and sensitivity. A high
award-fit score cannot rescue weak user value.

DECISION GATE: Ask me to choose two problem statements and one preferred
platform hypothesis for concept generation. Let me reject all territories if
the evidence is weak.
```

## Run 5: Generate disciplined concepts

This run creates a small set of coherent concepts. It rejects category stacking
that requires unrelated features or audiences.

```text
RUN 5 — CONCEPT GENERATION AND AWARD DISCIPLINE

Generate three to five concepts for each selected problem statement. Derive
them from the user evidence, winner-pattern findings, team constraints, and
platform hypothesis. Do not generate generic “AI assistant” concepts unless AI
is necessary to the core job and the input, output, failure mode, and cost are
specific.

Each concept card must include:
- name placeholder and one-sentence promise;
- target user and triggering situation;
- job story in “When / I want / so I can” form;
- current workaround and sharp point of difference;
- core loop and one memorable value moment;
- smallest launchable feature set and explicit non-goals;
- why this belongs on iOS, iPadOS, macOS, or Android;
- natural RevenueCat role and what value is free versus paid;
- retention and distribution hypothesis;
- required data, APIs, content, or experts;
- major safety, privacy, policy, or operational risk;
- evidence that supports demand and evidence still missing;
- exactly one primary award;
- zero to two secondary non-influencer awards;
- why the same core product work and evidence support every selected award;
- features that would be rejected as award-only bolt-ons.

Score award combinations on shared audience, shared core behavior, shared
evidence, incremental implementation cost, and judge clarity. Reject a
secondary award when it introduces a new persona, a separate core loop, or a
major dependency used only for eligibility. Enforce the one-influencer-award
rule.

Rank concepts using user-value evidence, differentiation, time to first value,
buildability before September 30, monetization fit, distribution access,
platform leverage, operational risk, and primary-award fit. Show how the rank
changes under different weightings.

DECISION GATE: Ask me to select five concepts for adversarial research. Let me
combine concepts only if they share the same user and core loop; otherwise
explain why the combination creates feature sprawl.
```

## Run 6: Falsify the shortlisted concepts

This run tries to kill weak ideas cheaply before design and implementation
effort create attachment.

```text
RUN 6 — CONCEPT RED TEAM AND PROOF PLAN

Adversarially research the shortlisted concepts. Your goal is to find the
strongest reason each concept may fail, not to defend it.

For each concept, investigate:
- evidence for recurring demand and willingness to switch or pay;
- close competitors, recently launched substitutes, and easy platform features
  that could erase differentiation;
- required data or API availability, reliability, cost, terms, and licensing;
- App Store, Google Play, Galaxy Store, privacy, health, financial, child-
  safety, accessibility, content-moderation, and IP constraints that apply;
- AI latency, accuracy, explainability, fallback, and unit economics if used;
- subscription, purchase, or ad fit and likely user resistance;
- backend, support, content, and moderation burden after launch;
- the hardest interaction or technical proof;
- what must be true to ship a credible version by the deadline;
- whether the award alignment remains natural under a smaller scope.

Use primary policy and technical documentation for high-risk claims. Produce a
pre-mortem, top assumptions, pass/pivot/kill recommendation, and confidence.

For every surviving concept, design the cheapest validation plan: five target-
user interviews, a clickable prototype task set, a landing-page or message
test, a technical spike, a pricing question, and one behavioral success metric.
Include explicit falsification thresholds and what decision each test unlocks.
Do not fabricate test results.

DECISION GATE: Ask me to select one concept, pivot one concept, or return to run
5. Do not advance a concept with an unresolved fatal dependency.
```

## Run 7: Build the UX and journey blueprint

This run turns one validated concept into a complete, observable experience.
It researches adjacent patterns without copying a competitor's visual identity.

```text
RUN 7 — UX ARCHITECTURE, JOURNEY, AND ATTENTION

Research three to five best-in-class adjacent experiences for specific UX
problems in the selected concept. Include platform guidance and accessibility
standards. Extract interaction principles, not screens to clone.

Create three user-flow options and recommend one. For each option, show:
- acquisition promise and store-page expectation;
- first launch and progressive onboarding;
- permission choreography with just-in-time rationale;
- first meaningful input and time to first value;
- the primary task flow and memorable value moment;
- feedback, edit, undo, recovery, and error paths;
- repeat-use trigger, retention loop, and re-engagement;
- paywall, purchase, restore, cancellation, and expired-entitlement states;
- share or growth behavior when natural;
- offline, empty, loading, success, partial-success, and failure states.

For the recommended option, produce:
1. A journey map with stages, goals, actions, questions, emotion, friction,
   opportunity, and success signal.
2. Information architecture and screen inventory.
3. A state-transition description for the core loop.
4. A screen-by-screen interaction specification for the critical path.
5. A predicted attention map for each critical screen, explicitly labeled as a
   hypothesis, with likely first fixation, scan order, thumb reach, primary and
   secondary actions, decision density, and distraction risk.
6. Visual-hierarchy and UX-writing guidance for titles, body copy, labels,
   calls to action, reassurance, and errors.
7. A nudge inventory with user benefit, timing, suppression rule, and a dark-
   pattern check.
8. Accessibility requirements for Dynamic Type or scalable text, screen
   readers, contrast, color independence, touch targets, keyboard control when
   relevant, reduced motion, captions, haptics, and one-handed use.
9. A usability-test script with target participants, tasks, observation points,
   metrics, and success thresholds.

If UX research, accessibility, layout, or UX-writing skills are installed, use
them in this run and identify which conclusions came from them.

DECISION GATE: Ask me to select or revise one flow before visual styling.
```

## Run 8: Define visual, motion, and sensory directions

This run gives the product a distinct design language tied to its purpose. It
does not use decoration to compensate for an unclear flow.

```text
RUN 8 — VISUAL SYSTEM, MOTION, HAPTICS, AND SOUND

Research visual and interaction references from both adjacent apps and
unrelated products that express the desired emotional qualities. Do not copy a
competitor's layout, trade dress, illustration, or brand assets. Record source
URLs and the transferable principle from each reference.

Create five distinct art directions. For each, define:
- product mood and the user emotion it supports;
- semantic color roles, light and dark modes, contrast checks, and color-blind
  resilience;
- typography roles, type scale, weights, line length, numeric treatment, and
  localization resilience;
- shape language, spacing rhythm, density, elevation, dividers, and surfaces;
- icon, illustration, photography, data-visualization, or game-art approach;
- app icon and store-screenshot concept;
- one signature interaction tied to the core job;
- motion principles, duration ranges, easing character, interruption behavior,
  reduced-motion alternative, and performance risk;
- haptic and sound cues with purpose and quiet-mode behavior;
- iOS, iPadOS, macOS, or Android adaptation without losing the brand;
- accessibility and implementation risks.

Audit each direction against the primary award. If RevenueCat Design is the
primary or secondary award, separately map innovation, aesthetics, delight,
gesture quality, feedback, and animation to observable submission evidence.
Do not overuse motion; every transition must clarify state, hierarchy, cause
and effect, or progress.

If color, typography, accessibility, Apple design, Android design, or animation
skills are installed, use the relevant skills and note material influence.

DECISION GATE: Ask me to choose one art direction and one signature
interaction. Preserve useful elements from rejected directions only when they
remain coherent.
```

## Run 9: Design monetization, retention, and growth

This run makes RevenueCat and growth part of the product logic. Sponsored tools
are included only when their award was already selected.

```text
RUN 9 — MONETIZATION, RETENTION, AND GROWTH SYSTEM

Research current pricing, packaging, trials, paywalls, purchases, ads, and
retention systems in the selected product category. Record country, platform,
currency, and observation date. Separate current competitor practice from
evidence that a model works.

Design three monetization options and recommend one. For each option,
show:
- free value and the moment a user understands the product;
- paid value and why payment is proportional to ongoing or discrete value;
- subscription, non-consumable, consumable, lifetime, web purchase, or ad mix;
- products, packages, offerings, and entitlement logic in RevenueCat;
- paywall trigger, message hierarchy, plan comparison, trial or intro offer,
  restore, cancellation, grace period, and expired state;
- price hypothesis and validation plan, not unsupported certainty;
- unit-cost exposure and abuse risk;
- fairness, accessibility, and dark-pattern check;
- primary-award evidence created by the monetization design.

Create a retention and growth plan with activation, time-to-value, D1 and D7
return behavior, trial start, conversion, paid retention, referral or sharing,
and revenue metrics. Define the event taxonomy and smallest useful dashboard.
Pair every metric with a product hypothesis and decision.

Only if already selected, add the relevant sponsor path:
- RevenueCat Ads: additive placements and the subscription or purchase mix;
- OneSignal: permission timing, one useful campaign or journey, suppression,
  and measurable user value;
- Layers: audience, message, surface or channel, experiment, intended outcome,
  SDK signal, and next iteration;
- Stripe: ad-to-web-checkout-to-app funnel and attribution;
- Noise: repeatable creative and UGC formats that communicate product value;
- Replit: build evidence, returning paid users, and transaction trajectory;
- Kotlin: cross-platform quality and community contribution;
- Galaxy: device-specific experience and store optimization.

Create a lightweight BuildInPublic experiment log even if it is not an award:
hypothesis, artifact shared, audience, response, product change, and lesson.
Audience size is not a proxy for learning.

DECISION GATE: Ask me to approve one monetization model, one activation metric,
one retention metric, and the first three growth experiments.
```

## Run 10: Choose architecture and cut scope

This run selects the smallest credible technical plan for the chosen concept
and award. It avoids cross-platform work unless the product or selected award
actually benefits from it.

```text
RUN 10 — PLATFORM, ARCHITECTURE, AND SHIP SCOPE

Using the chosen concept, UX, visual direction, monetization, team constraints,
and September 30, 2026 deadline, compare only plausible implementation paths.
Consider native Swift or SwiftUI, native Kotlin or Compose, Kotlin
Multiplatform, and a cross-platform framework only when the team can ship it
reliably. If an award mandates a stack or multiple stores, treat that as a hard
constraint. Otherwise prefer the smallest platform scope that proves the
product and primary award.

Use current primary documentation to verify SDK and platform claims. Produce:
- platform and framework decision with rejected alternatives;
- component and data-flow diagram;
- core domain model and local versus server ownership;
- RevenueCat products, entitlements, SDK, webhook, and restore flow;
- authentication decision, including a no-account option when feasible;
- backend, storage, sync, offline, notifications, analytics, and feature flags;
- API, data, content, and licensing dependencies;
- privacy model, permissions, secrets, encryption, deletion, and export;
- performance budgets and failure fallbacks;
- accessibility, unit, integration, UI, purchase, offline, and store-build tests;
- logging, crash reporting, and minimal observability;
- App Review, Play review, or Galaxy review risks and submission buffer;
- operational costs and manual work after launch.

Create a vertical-slice backlog divided into must ship, evidence-enhancing,
post-submission, and cut. Trace every must-ship item to user value, a hard rule,
or the primary award. Remove items without a trace. Include a dated critical
path that prioritizes a live, usable release early enough to learn from real
users before the deadline.

Create a risk register with probability, impact, detection date, mitigation,
fallback, and owner. Identify the three technical spikes that must happen
first.

DECISION GATE: Ask me to approve the platform, vertical slice, cut list, and
first store-submission target date.
```

## Run 11: Plan validation and judge-visible evidence

This run connects product quality to proof. A feature that judges cannot see or
a claim without provenance receives no assumed credit.

```text
RUN 11 — VALIDATION, INSTRUMENTATION, AND SUBMISSION STORY

Create a pre-launch and post-launch validation plan for the selected concept.
Include:
- five-participant formative usability study for the target segment;
- critical tasks, success rate, time, error, hesitation, confidence, and
  comprehension measures;
- first-click or first-action testing for critical screens;
- predicted attention maps before testing and instrumented interaction maps
  after testing when consent and tools permit;
- activation, retention, monetization, notification, and funnel events;
- interview and cancellation questions that avoid leading language;
- issue severity and decision rules;
- accessibility testing with assistive settings and input modes;
- performance, offline, failure, and purchase-restoration scenarios.

Then create a judge-evidence matrix with one row per selected-award criterion:
criterion, product behavior, observable screen or metric, evidence source,
validation status, demo timestamp, Devpost paragraph, screenshot, and remaining
gap. Treat the first criterion as tie-break critical where the rules say so.

Create a less-than-two-minute demo storyboard with timestamps. It must establish
the user and pain, show the working app on its target device, reach the core
value moment quickly, show RevenueCat or ad value naturally, prove the primary
criteria, present only sourced metrics, and end with a concise product thesis.
Do not rely on narration to hide an unshown workflow.

Create the submission-production checklist: app icon, required screenshot
dimensions without device frames, store listing, promo code or trial, testing
instructions, English materials, project description, award-specific
descriptions, source links, music and trademark clearance, public repository
and license when required, and US availability.

Create a BuildInPublic evidence calendar that shares decisions, prototypes,
failures, user feedback, and product changes rather than only polished launch
posts.

DECISION GATE: Ask me to approve the evidence matrix and identify any criterion
that still lacks observable proof.
```

## Run 12: Produce the final decision brief

This run packages the chosen direction for implementation. It does not reopen
discarded ideas unless the evidence exposes a fatal gap.

```text
RUN 12 — FINAL PRODUCT AND RESEARCH DECISION BRIEF

Synthesize the accepted outputs into one implementation-ready decision brief.
Do not perform new broad research. Fetch only the minimum sources needed to
resolve an identified gap.

The brief must contain:
- product thesis and one-sentence promise;
- target user, triggering situation, job to be done, and evidence;
- current workaround and differentiation;
- primary award and zero to two natural secondary non-influencer awards;
- exact rubric-to-product evidence map;
- platform and reason;
- smallest launchable core loop and explicit non-goals;
- onboarding, value moment, retention, monetization, and recovery journey;
- screen inventory and selected visual and motion direction;
- RevenueCat model and event taxonomy;
- architecture and critical dependencies;
- privacy, safety, accessibility, and policy requirements;
- validation plan and falsification thresholds;
- build, early release, learning, store review, and submission milestones;
- two-minute demo outline and submission asset list;
- top ten risks, fallbacks, open questions, and kill criteria;
- source ledger with contemporaneous versus current labels;
- a one-page handoff summary for design and engineering.

End with a go, conditional go, pivot, or no-go recommendation. State the
evidence behind the recommendation and the exact next decision. Do not hide
uncertainty behind a composite score.
```

## Award-lens add-ons

Append the relevant lens to runs 2, 5, 9, and 11 after the primary award is
known. These lenses keep the research aligned with the actual 2026 rubric.

- **Grand Prize:** Prioritize early live release, RevenueCat-reported revenue
  needed for shortlisting, efficient and sustainable growth, causal links
  between product or acquisition changes and measured outcomes, and what the
  team learned. Do not equate the largest revenue total with final victory.
- **`#BuildInPublic`:** Trace the public story, response, feedback, product
  change, and lesson. Audience size alone does not establish quality.
- **Best Game:** Study fun, control feel, progression, replayability, art
  direction, genre fit, session shape, economy, and monetization fairness.
- **Peace Prize:** Verify impact mechanism, affected community, feasibility,
  reach or depth, accessibility, expert input, harm prevention, and sustainable
  access.
- **Design:** Make innovation, aesthetics, gesture quality, feedback, motion,
  haptics, delight, accessibility, and performance observable.
- **Catvertising:** Require ads to add, unlock, or fund value without breaking
  the core experience. Test placement, audience fit, frequency, consent, and
  the relationship with other revenue streams.
- **Next Gen:** Confirm student eligibility, public repository and license,
  clear idea, meaningful working progress, thoughtful RevenueCat use, technical
  choices, product thinking, and video clarity.
- **HAMM:** Focus on paywall craft, pricing and packaging, conversion,
  monetization-product fit, scalability, differentiated revenue logic, and
  sustainability beyond the event.
- **Productivity Influencer:** Optimize fast capture and retrieval for Apple
  power users, organization across content types, intelligent retrieval, and
  native polish.
- **Nutrition Influencer:** Support satisfying meals in real situations without
  calorie counting, macro tracking, restriction, shame, or hidden diet logic.
- **Yoga and Fitness Influencer:** Personalize today's movement or recovery
  plan, make the next action obvious, and show information restraint.
- **Career Coaching Influencer:** Use realistic new-manager scenarios, active
  conversation practice, specific feedback, psychological safety, and evidence
  of increased preparedness.
- **Gaming Influencer:** Make discovery, saving, backlog organization,
  completion, rating, and sharing enjoyable. Avoid turning leisure into admin.
- **Ship Kotlin Everywhere:** Verify published iOS and Android quality,
  meaningful Kotlin or Compose sharing, consistency with platform adaptation,
  and optional useful community contributions.
- **Most Viral App:** Test repeatable creative formats, authentic UGC, niche
  attention, clear value communication, and conversion from attention to an
  app download.
- **Best App for Galaxy:** Design for Galaxy-specific capabilities such as
  foldables or multi-window, and produce a polished Galaxy Store listing. Do
  not add a token Samsung feature that the core job does not need.
- **Idea to Income:** Verify Replit and RevenueCat implementation, returning
  paying users, week-over-week revenue and transaction momentum, product craft,
  and social pull.
- **Keep Them Coming Back:** Make OneSignal stable and useful. Research timing,
  segmentation, suppression, deep links, outcome tracking, and whether the
  message creates user value rather than notification volume.
- **The Growth Loop:** Specify the audience, reason to care, message, surface or
  channel, experiment, outcome, installed and verified Layers SDK, observed
  signal, learning, and next iteration.
- **Funnel Vision:** Trace ad click through RevenueCat Funnel, Stripe checkout,
  app download, account or entitlement connection, and first app value. Measure
  payment volume and conversion without sacrificing trust.
- **Conflict of Interest:** Use only when eligible. Balance concept novelty,
  reliable and polished execution, interesting UX or animation, and strong or
  novel monetization.

## Quality checks for every run

Use this checklist before accepting a research run. It catches the most common
ways an apparently detailed report becomes strategically weak.

- Every important claim has a direct source or an inference label.
- Historical UI claims rely on event-period evidence where possible.
- Winner patterns are compared with controls.
- Historical award criteria are not replaced by 2026 wording.
- Current prices, policies, SDKs, and store facts have observation dates.
- User pain is supported by more than a few isolated anecdotes.
- Heatmaps are called measured only when actual behavioral data exists.
- Analyst scores are not presented as judge scores.
- Accessibility, privacy, safety, empty states, and failure recovery are not
  treated as optional polish.
- Monetization is attached to delivered value, not only to award eligibility.
- Secondary awards reuse the same audience, core loop, and evidence.
- The plan fits the team, store-review lead time, and September 30 deadline.
- The two-minute submission story can visibly prove the primary criteria.
- Rejected directions and reasons remain in the state packet.

## Next steps

Start with the shared operating contract and run 0. After you confirm the
eligibility matrix and builder constraints, continue to run 1. Do not choose a
product idea before the winner corpus, controls, and current pain-point evidence
have narrowed the field.
