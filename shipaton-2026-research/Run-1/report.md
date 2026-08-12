# Run 1: 2024 and 2025 winner corpus

## Executive summary

Run 1 establishes a deduplicated inventory of 39 official Shipaton winners:
nine from 2024 and 30 from 2025. Every winner is cross-linked to an official
RevenueCat winner index and its Devpost submission. All 39 have contemporaneous
submission-page visual evidence and a recoverable store listing. Direct public
submission-video URLs were recovered for 33 of 39 projects.

This run does not explain why any project won. It freezes the inventory,
historical criteria, source timing, reported metrics, and evidence gaps needed
for a controlled deep analysis. The strongest next sample is a balanced set of
18 winners across five analytical families. It retains both years, native and
cross-platform implementations, multiple monetization models, and projects
with both strong and weak evidence coverage.

The two principal artifacts are the [CSV-ready winner corpus](./winner-corpus.csv)
and the [historical award comparability map](./historical-award-comparability.csv).
The earlier matched controls remain separate in
[the non-winner control file](./nonwinner-controls.csv) so they are available
for Run 2 without contaminating the winner inventory.

## Scope and method

The corpus starts from the official
[2024 winner announcement](https://www.revenuecat.com/blog/company/2024-ship-a-ton-winners)
and [2025 winner announcement](https://www.revenuecat.com/blog/company/shipaton-2025-winners).
The [2025 Devpost winner update](https://revenuecat-shipaton-2025.devpost.com/updates/39047-shipaton-2025-winners-announced)
and both project galleries were used as completeness checks. A gallery winner
badge was not used to infer an award without confirmation from an official
winner announcement or update.

Exa was the primary discovery and full-text system. It was used to search for
every winner, fetch every Devpost submission, fetch the two historical rules,
and recover dated builder or launch artifacts. Exa advanced search was checked
but was not available. Firecrawl was used as a recorded fallback to extract
links from dynamically rendered Devpost and RevenueCat pages when Exa's page
text did not expose embedded video or store URLs. No browser or visual fallback
was needed in this run.

The [2024 rules](https://revenuecat-ship-a-ton.devpost.com/rules) and
[2025 rules](https://revenuecat-shipaton-2025.devpost.com/rules) supply the
original category wording. Current App Store pages are included as durable
listing identifiers, not as evidence of the interface judges saw. Historical
screen interpretation is restricted to submission-period Devpost media and
videos.

## Corpus inventory

The corpus contains the following official placements.

| Year | Award | Winners | Placements |
|---|---|---:|---|
| 2024 | Most Likely to Make Money | 3 | Karo; Zerocam Mono; Party Animals! |
| 2024 | RevenueCat Design | 3 | Flowmino; Rakun Talk; Apol |
| 2024 | #BuildInPublic | 3 | Meshing; Food Sense; BJJ Evolve |
| 2025 | Grand Prize: Build & Grow | 1 | Payout |
| 2025 | #BuildInPublic | 3 | Gurwi; Echo Reminder; Tomo Japan |
| 2025 | RevenueCat Design | 3 | Dayloop; SkillMe; PitchLab |
| 2025 | Buzziest Launch | 3 | ReadHim; Shutter Declutter; MemoLune |
| 2025 | HAMM | 3 | Vector Guard; Napkinmatic AI3D; Kigaru Talks |
| 2025 | RevenueCat Peace Prize | 3 | Heartbeat Hero; Hearing Buddy; MoodHaven |
| 2025 | Best Vibes | 3 | Otter Day; Dripped; MaestLog |
| 2025 | OneSignal Boost | 5 | Cooked This; Voicetree; Friendy+; Studient; Camp Notes |
| 2025 | Kotlin Multiplatform Reach | 5 | Momental; Posturely; Steps Share; DrawIt; ClipUGC |
| 2025 | Staff and Sponsors | 1 | Crystal Abyss |

The inventory is deduplicated by year, award, placement, and Devpost URL. No
project appears in more than one official placement in these winner indexes.

## Source coverage report

Coverage describes what can be examined later; it is not a quality score.

| Evidence type | Coverage | Interpretation |
|---|---:|---|
| Official winner index and placement | 39/39 | Tier A; RevenueCat announcement or official Devpost update |
| Contemporaneous Devpost submission | 39/39 | Tier A/B boundary; entrant-authored evidence hosted by the event platform |
| Contemporaneous screenshots or submission media | 39/39 | Useful for later predicted attention maps; not interaction analytics |
| Store listing URL | 39/39 | Durable release identifier; current page presentation may be post-event |
| Direct public submission video URL | 33/39 | Strongest available artifact for the interface and flow judges could observe |
| Dedicated project website or public repository | 18/39 | Mostly current; only Steps Share exposes a clearly linked public source repository |
| Direct dated builder post or build log | 12/39 | Strongest for tracing decision, feedback, change, and result chains |
| Numeric traction, use, revenue, or impact claim | 13/39 | Almost entirely builder-reported or organizer-repeated; not audited |

The six projects without a recovered direct submission-video URL are Zerocam
Mono, BJJ Evolve, Payout, Kigaru Talks, MaestLog, and Voicetree. This does not
mean they failed to submit a video. Both years required a demonstration video;
it means the embedded or linked public URL could not be recovered from the
currently exposed page state.

The evidence-rich end of the corpus includes Gurwi, Tomo Japan, ReadHim,
Shutter Declutter, Heartbeat Hero, Momental, Steps Share, Meshing, and Food
Sense. The low-evidence end includes Zerocam Mono, BJJ Evolve, Payout's missing
video, Kigaru Talks' missing video, MaestLog, and Voicetree. Low evidence is
useful in a sample because it tests whether a proposed pattern depends on
excellent documentation rather than the judged product.

## Historical criteria and comparability

The historical map uses three labels.

- **Equivalent** means the criterion names and substantive scoring logic are
  stable enough for a direct comparison.
- **Partially comparable** means some underlying evidence transfers, but the
  gate, scoring emphasis, or sponsor requirement changed materially.
- **Not comparable** means there is no defensible historical counterpart.

The most stable lineages are RevenueCat Design, #BuildInPublic, HAMM, and the
RevenueCat Peace Prize. The 2025 Grand Prize is also closely comparable with
2026, but the 2026 RevenueCat-reported revenue shortlist is a material new
gate. Buzziest Launch is only partially comparable with Most Viral because
launch visibility and stunts do not prove a repeatable sharing mechanism,
conversion, or retention.

OneSignal Boost is only partially comparable with Keep Them Coming Back. Both
reward lifecycle engagement, but the 2026 framing is outcome-oriented around
return behavior rather than sponsor-integration depth alone. Kotlin
Multiplatform Reach and Ship Kotlin Everywhere are also partial rather than
automatic equivalents because release and community-contribution expectations
changed.

Best Vibes disappeared. The 2026 Best Game, Catvertising, Next Gen, Influencer,
Make Some Noise, Galaxy, Replit, Layers, and Stripe families have no direct
2024 or 2025 winner lineage. The detailed row-by-row rationale and source links
are in [the comparability CSV](./historical-award-comparability.csv).

## Inventory-level observations

These are scope observations, not explanations of judging outcomes.

The corpus spans native iOS, Flutter, React Native and Expo, Kotlin and Compose
Multiplatform, and a smaller number of Android-first or multi-device projects.
It includes subscriptions, lifetime purchases, freemium unlocks, consumable
credits, virtual currency, impact-linked access, and sponsor-driven retention
flows. Several projects use sensitive health, legal, relationship, or child
data, while others are low-risk creative or productivity utilities.

Reported evidence is highly heterogeneous. Some submissions contain dated
release chronology, experiment results, conversion or revenue snapshots, and
public feedback loops. Others contain only a polished description and media.
That asymmetry must be preserved in Run 2. Absence of a public metric is not
evidence that judges saw no private data, and a builder-reported metric is not
an audited measurement.

## Recommended deep-dive sample

I recommend Option A. It is the largest permitted sample and provides the best
coverage while the builder is still exploring all 2026 families.

### Option A — balanced 18, five families (recommended)

1. **Growth and monetization:** Karo, Payout, ReadHim, Vector Guard.
2. **Design and native craft:** Flowmino, Dayloop, PitchLab.
3. **Build in public and distribution:** Meshing, Gurwi, Echo Reminder, Tomo
   Japan.
4. **Impact, trust, and accessibility:** Rakun Talk, Heartbeat Hero, Hearing
   Buddy, MoodHaven.
5. **Cross-platform, retention, and game execution:** Cooked This, Momental,
   Crystal Abyss.

This set includes four 2024 winners and 14 from 2025; iOS-native, Flutter,
React Native, and Kotlin Multiplatform products; single-platform and dual-store
releases; subscriptions, lifetime access, impact-linked monetization, and
freemium unlocks; plus high- and low-metric projects.

### Option B — solo-builder feasibility 15, five families

Karo, Flowmino, Meshing, Food Sense, Echo Reminder, Tomo Japan, Dayloop,
SkillMe, Shutter Declutter, Vector Guard, Heartbeat Hero, MaestLog, Cooked This,
Momental, and Crystal Abyss.

This option gives more weight to scopes a solo developer could plausibly build,
debug, market, and submit with AI assistance. It sacrifices some cross-platform
and measured-growth contrast.

### Option C — evidence-dense 12, five families

Karo, Meshing, Payout, Gurwi, Tomo Japan, Dayloop, ReadHim, Shutter Declutter,
Kigaru Talks, Heartbeat Hero, Momental, and Steps Share.

This option gives the cleanest decision and metric trails. It carries the
highest documentation bias and therefore needs the matched controls used
aggressively in Run 2.

For any option, Run 2 should pair winners with the plausible non-winners in
[the control file](./nonwinner-controls.csv) wherever same-year,
same-platform, same-family evidence exists. No observed trait should be called
a winner differentiator unless it is less common or better executed in the
winners than in those controls.

## Evidence and uncertainty ledger

| Claim or artifact | Status | Source tier | Timing | Confidence |
|---|---|---|---|---|
| 39 official placements | Observed | A | Historical official announcements | High |
| Award and placement for every corpus row | Observed | A | 2024-09-23 or 2025-10-13 recap | High |
| Problem, promise, stack, and monetization descriptions | Described unless directly shown | B | Contemporaneous Devpost submission | High for description; medium for behavior |
| Submission screenshots and demos | Observed | B | Contemporaneous | High for visible state; no analytics inference |
| Store availability | Observed | A/B | URL durable; page content often current | High for listing identity; medium for event UI |
| Revenue, users, sessions, reviews, conversions, or reach | Measured only when a metric and provenance are stated; generally builder-reported | B | Mostly submission period | Medium |
| Press, talks, or App Store featuring | Described or observed when a dated source exists | B/C | Event or post-event as labeled | Medium-high |
| Current websites and current store copy | Observed current | C | Observed 2026-08-08 | High for current state only |
| Judge reasoning beyond published criteria or ceremony remarks | Unknown | D if inferred | Not used in Run 1 | Low |

No heatmaps are claimed. If Run 2 analyzes screens or videos without analytics,
the output will be a predicted attention and interaction map labeled as a
hypothesis, including likely first fixation, scan path, actions, thumb reach,
decision density, gesture discoverability, and attention conflicts.

## Contradictions and missing evidence

- The 2025 rules define the submission period from July 31, while the official
  overview and release requirement describe new store releases from August 1.
  The corpus distinguishes submission-window wording from eligible release
  timing rather than silently merging them.
- The 2025 rules anticipated a winner announcement around October 14, while the
  official RevenueCat recap is dated October 13.
- Napkinmatic's submission described Google Play as live before the deadline
  and iOS as future; current official and Devpost links expose both stores. iOS
  release timing remains unresolved.
- Hearing Buddy links two Apple listings. The listing and device combination
  used for judging needs confirmation in a deep dive.
- The award-ceremony description uses “Kotlin Multiplatform Boost” while the
  official rules and winner index use “Kotlin Multiplatform Reach.” The rules
  name controls the historical map.
- Six direct demo URLs and most public repositories were not recoverable.
- Almost every quantitative claim is entrant-reported or organizer-repeated.
  None is treated as audited unless an independent provenance is stated.
- Sponsor employee status for the current builder remains unknown. This matters
  only if the 2026 Conflict of Interest rules apply.

## Recommendation

Select Option A unless the immediate objective is to minimize Run 2 research
time. It is the smallest sample that preserves all of the tensions most likely
to matter later: growth versus craft, native depth versus cross-platform reach,
high-evidence versus low-evidence submissions, low-risk utilities versus
sensitive domains, and conventional subscriptions versus more distinctive
monetization.

This is a recommendation about the next research sample, not a decision about
an app concept or primary 2026 award.

## Decision gate

Choose one sample before Run 2:

1. **Option A:** balanced 18 across five families — recommended.
2. **Option B:** solo-builder feasibility 15 across five families.
3. **Option C:** evidence-dense 12 across five families.

You may also replace up to three projects in the selected option while keeping
the sample between 12 and 18 and the family count between three and five.

## Updated research state

```yaml
RESEARCH_STATE:
  completed_run: 1
  rules_version_observed: "Live 2026 rules observed 2026-08-08; treat 2026-08-01 as the official planning and release start. Galaxy uses 80% standard applicable Shipaton criteria and 20% Galaxy optimization. No non-Influencer category-count limit."
  builder_constraints:
    team_and_skills: "Solo developer who can own development and marketing; AI-assisted implementation is acceptable."
    available_hours: "No fixed weekly cap; use task-based estimates including debugging, testing, store review, and rework."
    budget: "Prefer free tiers, event credits, and existing subscriptions."
    eligible_platforms: "Android on Windows; iOS and macOS through MacinCloud. No code or designs exist yet."
    developer_accounts: "One planned Apple Developer account and one planned Google Play account; activation not confirmed."
    student_status: "Qualifying student email available."
    sponsor_employee_status: unknown
    geography_and_store_access: "United States; app can be distributed in the United States."
    backend_and_ai_tolerance: "Open; available options include CockroachDB, MongoDB, QwenCloud, OpenRouter, OpenAI, and Ollama cloud models."
    regulated_or_sensitive_domains_to_avoid: "None categorically; medical requires compliance and legal or financial products require stronger security, performance, review, and claims discipline."
    native_or_cross_platform_preference: "Open; fewer architectural touchpoints preferred. Capacitor is attractive but not selected."
    audience_access: "Plan later through social-media waitlists and promotion."
    build_in_public_willingness: "Open."
  selected_primary_award:
  allowed_secondary_awards: []
  shortlisted_award_families:
    - "Open exploration across all eligible families; Run 1 recommends five analytical families for the next sample."
  selected_opportunity_territories: []
  selected_problems: []
  shortlisted_concepts: []
  selected_concept:
  selected_ux_direction:
  selected_visual_direction:
  rejected_directions:
    - "Using July 31 as the 2026 planning or release start."
    - "Treating current store presentation as the interface historical judges saw."
    - "Treating builder-reported historical metrics as audited."
    - "Treating AI usage, native APIs, cross-platform scope, visual polish, feature count, or sponsor-integration depth as a winner formula without controls."
    - "Equating renamed awards solely from similar titles."
    - "Adding sponsor or award-only features that do not serve the same user and core loop."
  accepted_evidence:
    - "Official 2024 and 2025 rules, winner announcements, Devpost winner update, and project galleries."
    - "All 39 official winning Devpost submissions and contemporaneous submission media."
    - "33 recovered direct submission-video URLs and 39 store-listing URLs."
    - "Historical award comparability map using original criteria."
    - "13 plausible same-year, same-platform, or same-family non-winning controls retained separately."
  unresolved_questions:
    - "Which Run 2 sample: balanced 18, solo-builder 15, evidence-dense 12, or a limited substitution?"
    - "Which three to five analytical award families should control Run 2 if the recommended five are not accepted?"
    - "Is the builder employed by RevenueCat, a category sponsor, a judge, or an affiliate?"
    - "When will the Apple and Google developer accounts be active?"
    - "Is a Samsung developer account feasible if Galaxy becomes strategically attractive?"
    - "Can the six missing historical submission-video URLs be recovered from builders or archived pages?"
  next_decision: "Select one 12-to-18-project sample and three to five analytical award families before Run 2."
```

## Next steps

After the sample decision, Run 2 can perform project-level UX, product,
monetization, distribution, feasibility, and judge-observable evidence analysis
with matched controls. It should not generate or select a final Shipaton 2026
concept unless the later requested run explicitly opens that gate.
