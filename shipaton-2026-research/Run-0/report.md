# Run 0: Rules, eligibility, and independent historical baseline

Run 0 establishes the controlling 2026 boundary, records all 21 award tracks,
and adds the independent 2024–2025 research requested for this initial pass.
It stops at the required decision gate. It does not select or generate an app
idea.

**Observation date:** August 8, 2026, America/Chicago.

## Executive summary

The controlling source is the supplied 2026 official rules, corroborated
against a live fetch of the current Devpost rules page. The live page matched
the supplied text on the material category gates and ordered criteria. The
overview, category microsite, judging guide, and rules contain several
conflicts, so a conservative compliance plan is necessary.

The most important findings are these:

- The general release window in the rules begins July 31, 2026, at 8:00 a.m.
  PDT, but overview copy repeatedly says August 1. The builder has accepted
  August 1 as the official planning and release start.
- The Devpost overview says ages 13–99, while the official rules require the age
  of majority where the entrant lives. Treat the age-of-majority rule as
  controlling.
- The rules contain two `#BuildInPublic` start times. Use August 1, 2026, at
  8:30 a.m. PT as the conservative evidence window and use both `#Shipaton` and
  `#BuildInPublic` tags.
- The overview reports `$685,000+` in cash while marketing copy says more than
  `$700,000` in cash and the launch update says `$1M` in prizes. The detailed
  Devpost prize rows are the safest source for category-specific value. Best
  App for Galaxy and Conflict of Interest list no cash.
- The overview's general requirements omit RevenueCat Ads as an alternative,
  but the official rules expressly permit a purchase powered by RevenueCat or
  ads served through RevenueCat Ads.
- The official judging guide omits Galaxy Store and Next Gen exceptions when it
  describes intake. It is guidance, not a rules amendment. The official rules
  control.
- The judging guide confirms that category-specific submission questions
  determine category tagging. Leaving one blank can remove the app from that
  category even when the implementation qualifies.
- The independent historical review confirms the prior report's central
  coherence thesis but corrects its 2025 Grand Prize criteria. The official
  2025 rules used Early and Effective Release followed by Growth-by-numbers;
  the winner recap later printed a conflicting generic rubric.
- Non-winner controls show that native APIs, polished animation, deep sponsor
  integrations, ambitious KMP engineering, AI usage, and founder stories were
  all present outside the winner set. The strongest surviving pattern is a
  coherent, visible proof chain tied to the exact criterion.

## Artifact set

The research is split into structured files so later runs can cite facts
without re-reading a narrative report.

- [`rules-and-awards.csv`](../General/rules-and-awards.csv) contains one complete
  row for each of the 21 current awards.
- [`winner-corpus.csv`](../Run-1/winner-corpus.csv) contains all 39 placed 2024–
  2025 projects and 13 plausible matched controls.
- [`project-dossiers/README.md`](../Run-2/project-dossiers/README.md) contains
  independent dossiers for the 13 first-place projects.
- [`independent-winner-patterns.md`](./independent-winner-patterns.md) records the patterns that
  survived comparison and the claims the controls weakened.
- [`research-state.md`](../General/research-state.md) contains the handoff state
  for the next run.

## Source hierarchy and tool record

The supplied operating contract determined source priority. The local rules
file controls when non-rule pages conflict, unless RevenueCat publishes a
clearly newer amendment.

The primary sources were:

- Supplied 2026 rules:
  `C:\Users\caoda\.codex\attachments\5e853158-84c5-4346-835e-6f1840965288\pasted-text.txt`.
- [Current 2026 Devpost rules](https://revenuecat-shipaton-2026.devpost.com/rules).
- [Current 2026 Devpost overview and prizes](https://revenuecat-shipaton-2026.devpost.com/).
- [Official 2026 judging guide](https://www.shipaton.com/blog/how-we-judge-shipaton).
- [Official 2026 category pages](https://www.shipaton.com/#categories).
- [Official 2024 rules](https://revenuecat-ship-a-ton.devpost.com/rules),
  [winner announcement](https://www.revenuecat.com/blog/company/2024-ship-a-ton-winners),
  and [gallery](https://revenuecat-ship-a-ton.devpost.com/project-gallery).
- [Official 2025 rules](https://revenuecat-shipaton-2025.devpost.com/rules),
  [winner announcement](https://www.revenuecat.com/blog/company/shipaton-2025-winners),
  and [gallery](https://revenuecat-shipaton-2025.devpost.com/project-gallery?page=1).

Exa handled semantic discovery and full-text extraction for important known
URLs. Firecrawl performed live scrapes with cache age zero, mapped Devpost and
Shipaton URLs, crawled all 21 category pages, extracted targeted rule and winner
evidence, and gathered gallery controls. Firecrawl's autonomous research jobs
failed because the internal agent reported an invalid search token. Direct
Firecrawl map, search, scrape, query, and crawl calls continued to work. This
fallback is recorded because the operating contract requires it.

The three supplied category screenshots were inspected at original resolution.
They show 21 categories divided into seven core, five influencer, and seven
sponsored categories, plus the cross-cutting Grand Prize and
`#BuildInPublic`. Their names and short purposes match the rules matrix.

## Controlling 2026 boundary

The following boundary applies until RevenueCat publishes an amendment or
answers a rules question in a way that it designates as authoritative.

- Registration runs from May 15, 2026, at 8:00 a.m. PDT through September 30,
  2026, at 11:45 p.m. PDT.
- Submission runs from July 31, 2026, at 8:00 a.m. PDT through September 30,
  2026, at 11:45 p.m. PDT.
- Judging runs from October 1, 2026, at 12:00 a.m. PDT through October 13,
  2026, at 12:00 p.m. PDT.
- Winners are scheduled for October 21, 2026.
- An ordinary entry must release its first public version during the submission
  period on Apple's App Store, Google Play, or Samsung Galaxy Store. A prior
  public release on an eligible store is disqualifying, and an update to an
  existing store app is not eligible.
- An ordinary entry must run on iOS, iPadOS, macOS, or Android and must be
  accessible from the United States.
- The app must use RevenueCat to power at least one in-app or web purchase, or
  it must serve ads through RevenueCat Ads.
- Next Gen replaces the store path with a video and a complete public,
  open-source repository with a visible license.
- RevenueCat and sponsor employees can win only Conflict of Interest.
- An entrant can submit more than one project only when each is unique and
  substantially different.

## Discrepancy ledger

The rules and current official pages disagree in ways that can change
eligibility or effort. None of these conflicts was silently reconciled.

### Release start

The official rules begin the submission period on July 31 at 8:00 a.m. PDT.
The Devpost overview and requirements say the first public version must release
between August 1 and September 30. The launch update also describes an eight-
week event beginning in August.

**Accepted planning interpretation:** Release no earlier than August 1, 2026.
The older July 31 timestamp remains in the source ledger but is not used for
the roadmap.

### Entrant age

The Devpost overview displays ages 13–99. The official rules require the age of
majority where the entrant resides.

**Controlling interpretation:** The age-of-majority rule applies. The overview
widget is not a safe eligibility source.

### `#BuildInPublic` start

Section 1 says on or around July 31 at 8:00 a.m. PDT. The later category section
says on or around August 1 at 8:30 a.m. Pacific Time.

**Conservative interpretation:** Count award evidence from August 1 at 8:30
a.m. PT. Keep earlier work as context, but do not rely on it for eligibility.
Use both `#Shipaton` and `#BuildInPublic` even though the later rules say the
first is expected and the second is optional.

### Cash total and Galaxy prize

The Devpost header says `$685,000+` in cash. The overview narrative says more
than `$700,000` in cash and more than `$1 million` in total value. The launch
update says `$1M` in prizes. The detailed rows total `$685,000+` and list no
cash for Best App for Galaxy or Conflict of Interest.

**Controlling interpretation:** Use the detailed current Devpost prize row for
each category. Do not assume the overview's “all other categories” summary
gives Galaxy a cash prize.

### RevenueCat Ads option

The overview's **What to build** section mentions a RevenueCat-powered
purchase, while the challenge summary and official rules allow a purchase or
RevenueCat Ads.

**Controlling interpretation:** RevenueCat Ads is a valid global qualification
path under the rules. A Catvertising entry still needs RevenueCat Ads
specifically.

### Judging guide store and video language

The judging guide describes App Store or Google Play intake and omits Galaxy
Store and Next Gen. It also says judges watch at least two minutes, while the
rules say the video should be less than two minutes and judges need not watch
beyond two.

**Conservative interpretation:** Follow the rules' Galaxy and Next Gen paths.
Submit a video shorter than two minutes and put every essential proof inside
that duration.

### Best App for Galaxy scoring

The rules assign 20% of the category score to Galaxy optimization. The builder
has clarified the intended interpretation: apply the otherwise applicable
standard Shipaton criteria to 80% of the score, then assign 20% to Samsung-
specific features and Galaxy Store quality. Galaxy exclusivity remains an
optional bonus, not a requirement.

## Global compliance checklist

Use this checklist for every ordinary entry. Apply the Next Gen exceptions
where marked.

### Eligibility and ownership

This group determines whether the entrant and project can be evaluated at all.

- [ ] Every individual entrant is at least the age of majority where they live.
- [ ] No entrant, organization, judge relationship, affiliate, household
  relationship, or prohibited jurisdiction creates an exclusion.
- [ ] If a team or organization enters, it appoints one authorized
  representative.
- [ ] RevenueCat or sponsor employees enter only Conflict of Interest.
- [ ] The project is original, solely owned by the entrant, and does not violate
  copyright, trademark, patent, contract, privacy, or publicity rights.
- [ ] Every open-source component, asset, model, API, dataset, and SDK is used
  under a valid license or authorization.
- [ ] The project did not receive disqualifying financial or preferential
  support from RevenueCat or Devpost before the submission period ends.

### Product and release

This group governs the app, its launch date, and its availability.

- [ ] The app runs consistently on iOS, iPadOS, macOS, or Android.
- [ ] The first public eligible-store release occurs no earlier than August 1,
  2026, under the conservative interpretation, and no later than September 30,
  2026, at 11:45 p.m. PDT.
- [ ] The project was not publicly released on an eligible store before the
  event and is not merely an update to an existing eligible-store app.
- [ ] The ordinary entry is fully published on Apple's App Store, Google Play,
  or Samsung Galaxy Store by the deadline.
- [ ] The app is downloadable and usable from the United States.
- [ ] RevenueCat powers at least one in-app or web purchase, or RevenueCat Ads
  serves ads.
- [ ] The release and bundle or package identifier are connected to the
  RevenueCat project so the intake check can verify integration.
- [ ] Every third-party integration follows its terms, privacy requirements,
  and platform policy.
- [ ] Store review starts early enough for rejection and resubmission.

### Submission package

This group controls what a screener can see without installing the app.

- [ ] The Devpost text describes the target user, problem, mechanism, features,
  and functionality in English or includes a full English translation.
- [ ] The public YouTube or Vimeo demo is shorter than two minutes and shows the
  app working on its target device.
- [ ] The first seconds state the user, problem, and signature mechanism.
- [ ] The video shows RevenueCat purchase behavior or RevenueCat Ads in context.
- [ ] The video shows the primary award's criterion proof, not only features.
- [ ] The video and submission use no unlicensed music, trademarks, footage,
  influencer identity, or copyrighted material.
- [ ] The ordinary entry includes a live store URL.
- [ ] The submission includes a 1024×1024 app icon.
- [ ] The submission includes at least one 1179×2556 screenshot without a
  device frame.
- [ ] Every category-specific question is answered. A blank answer can prevent
  category tagging.
- [ ] The ordinary app provides a free trial or a judge promo code that unlocks
  every premium feature.
- [ ] Testing access remains free and unrestricted through the judging period.
- [ ] Proprietary or uncommon hardware can be provided if RevenueCat requests
  it.

### Next Gen replacement path

This group replaces the ordinary store, test-access, and paid-developer-account
requirements for an eligible student project.

- [ ] The entrant is an active student and uses a qualifying academic email on
  Devpost.
- [ ] The repository is public, complete, functional, and includes all source,
  assets, and setup instructions.
- [ ] A visible open-source license appears at the top level and in the
  repository's **About** area when supported.
- [ ] The demo shows meaningful progress and the working core.
- [ ] RevenueCat purchase or Ads usage is visible in the code and demo.

### Freeze and verification

This group protects the final entry after submission closes.

- [ ] The project and every field are reviewed before September 30 at 11:45
  p.m. PDT.
- [ ] No substantive Devpost changes are expected after the deadline.
- [ ] A final install, entitlement, restore, promo-code, deep-link, offline,
  permission-denied, and error-state test is complete.
- [ ] Evidence snapshots retain dates and provenance.

## Complete award matrix

The CSV matrix contains the exact name, family, purpose, category gate,
technical dependency, submission evidence, ordered criteria, tie implication,
observable proof, unique effort, coexistence rule, confidence, and source for
all 21 awards. All rows inherit the global checklist above.

The most strategy-changing tie-break facts are:

- Grand Prize ties start with Early and Effective Release after the revenue
  shortlist, not with Growth-by-numbers.
- HAMM ties start with clarity, integration, realism, and scalability before
  monetization novelty.
- Keep Them Coming Back ties start with stable implementation before user value
  and creativity.
- Growth Loop ties start with audience and hypothesis clarity before SDK depth
  or the lesson.
- Funnel Vision and Idea to Income explicitly put the quantitative trajectory
  first.
- Best App for Galaxy uses the standard applicable criteria for 80% of the
  score and Galaxy optimization for 20%.

## Independent 2024–2025 findings

The independent corpus contains all 39 placed projects: nine in 2024 and 30 in
2025. Thirteen first-place projects received deeper dossiers. Thirteen
non-winning projects were selected as plausible controls by year, platform,
mechanism, or sponsor eligibility. Their actual entered categories are usually
not public, so the controls constrain claims but do not prove causation.

The evidence supports five recurring mechanisms:

1. The award criterion is embodied in a working product behavior.
2. The first session creates a credible preview of long-term value.
3. Feature scope converges on one proof moment.
4. Dated evidence connects an action to a result and next decision.
5. The submission makes the criterion easy to score without installation.

The controls reject several shortcuts:

- Mood Dial and FoxyFocus show that native APIs, motion, and polish existed
  outside the Design placements.
- Memory Hammer shows that OneSignal depth and early user metrics existed
  outside the OneSignal placements.
- Restia, Kittysplit, and Ask2Color show that ambitious dual-platform KMP work
  existed outside the KMP placements.
- LockedIn shows that a founder story and social mission do not replace a
  bounded impact mechanism and outcome evidence.
- AI appears across winners and non-winners and is not a general advantage.

## Comparison with the supplied prior report

The supplied report's main thesis is confirmed: a strong project aligns the
problem, signature mechanism, monetization or sponsor integration, criterion,
and demo story. The independent sources also confirm its 39-project corpus,
most first-place interpretations, friction-reduction patterns, submission
guidance, and warning against award-first bolt-ons.

The comparison produces the following corrections and refinements:

1. **Correct the 2025 Grand Prize rubric.** The prior report says the 2025
   Grand Prize emphasized innovation, execution, feasibility, and integration.
   The controlling 2025 rules list Early and Effective Release first and
   Growth-by-numbers second. The later winner recap conflicts with the rules.
2. **Add metric provenance to ReadHim.** The 5.2 million Instagram views, 2.3
   million influencer followers, `$1,100` MRR, and Devpost's six-million-view
   claim are different measurements.
3. **Date Gurwi's snapshots.** The official recap's 13,000 users differs from
   the October 3 Devpost update's 17,696 users and related revenue data. Both
   can be valid at different observation times.
4. **Narrow the native-technology claim.** Native leverage appears in controls;
   it becomes persuasive when it creates an award-relevant visible outcome.
5. **Narrow the sponsor-depth claim.** Memory Hammer documented greater
   OneSignal surface area than the winner Cooked This. A clear user-value loop
   is more defensible than “deeper integration wins.”
6. **Narrow the KMP claim.** Restia and Kittysplit demonstrate that difficult
   engineering and community write-ups were not unique to placed projects.
   Cross-platform product coherence remains the stronger transfer.
7. **Upgrade the survivorship-bias section.** Plausible controls now exist, but
   entered-category opacity means the report still cannot claim causal winner
   differentiators.

The dated addendum at the end of the prior report points to the independent
artifacts and records these changes without rewriting its original analysis.

## Evidence and uncertainty ledger

This ledger distinguishes what the sources establish from what remains an
analyst interpretation.

| Claim | Status | Provenance | Confidence |
| --- | --- | --- | --- |
| The current event has 21 award categories in the supplied three-family layout. | Observed | Rules, Devpost, category screenshots | High |
| The supplied rules and live Devpost rules materially match on category gates and ordered criteria. | Observed | Local rules and live scrape | High |
| Release and `#BuildInPublic` start language conflict across official pages. | Observed | Rules, overview, and judging guide | High |
| Revenue determines only the Grand Prize shortlist, not the automatic winner. | Observed | 2026 rules | High |
| Historical first-place projects usually made the criterion visible through a product mechanism. | Inferred from observed examples | Official announcements and Devpost dossiers | Medium-high |
| Coherent sponsor use matters more than integration breadth. | Inferred | Cooked This and Memory Hammer comparison | Medium; category-entry status unknown |
| Cross-platform polish matters more than technical complexity. | Inferred | Momental and KMP controls | Medium; category-entry status unknown |
| Historical builder metrics are accurate. | Unknown | Builder or organizer reports without audit | Medium at best |
| A particular historical mechanism caused a win. | Unknown | Judge scores and entered control categories are unavailable | Low |

## Contradictions and missing evidence

The following gaps can affect category selection or later product design.

- RevenueCat has not resolved the two `#BuildInPublic` start times.
- The detailed current prize list and summary marketing totals disagree.
- The builder confirms that there is no numeric limit on non-Influencer award
  entries. The one-Influencer limit remains binding.
- Public Devpost pages do not consistently expose the categories non-winners
  entered.
- Historical metrics are reported, not audited.
- Visual review cannot prove accessibility, reduced motion, performance,
  restore purchases, permission recovery, or edge-state reliability.
- Sponsor, RevenueCat, judge, or affiliate employment status remains unstated.

## Recommendation

Confirm builder eligibility and resources before narrowing. Remove any award
whose hard dependency cannot be completed without weakening the core product.
Then choose one likely primary family and at most two natural secondary non-
Influencer families for the next research stage. The decision is not an app
idea; it selects where to research users and problems.

Treat Grand Prize and `#BuildInPublic` as evidence programs that begin on launch
day, not features added near submission. Choose a sponsored award only when its
required platform or SDK supports the same user and core loop. If the builder
has not already committed to two stores, Galaxy hardware, Replit, Noise,
OneSignal, Layers, or a Stripe web funnel, count the dependency as a material
scope choice.

## Builder intake

Answer only the questions that change eligibility, feasibility, or product
strategy. Short answers are sufficient.

1. Who is on the team, what can each person build or design, and who owns
   release, marketing, and evidence capture?
2. How many hours per person are available each week through September 30?
3. What cash budget can cover developer accounts, services, models, content,
   ads, testing devices, and store review setbacks?
4. Which Apple, Google Play, and Samsung developer accounts are active now?
5. Is any entrant an active student with a qualifying academic email?
6. Does any entrant work for RevenueCat, a category sponsor, a judge, or an
   affiliate that could create a conflict?
7. Where do the entrants live, and can the app be distributed and tested in the
   United States?
8. What code, designs, datasets, content, licenses, devices, or unreleased
   prototypes already exist?
9. Is the preference native Apple, native Android, Kotlin Multiplatform,
   Flutter, React Native, Replit, or open?
10. What backend, AI inference, ongoing content, moderation, and support burden
    is acceptable?
11. Which domain experts or reachable audiences can participate in interviews,
    beta tests, or distribution?
12. Is the team willing to publish work and feedback consistently during the
    conservative `#BuildInPublic` window?
13. Which medical, mental-health, nutrition, legal, financial, child, or other
    sensitive domains are acceptable or excluded?
14. Which award families are already preferred or rejected, and why?

## Decision gate

Confirm the builder intake, remove ineligible awards, and choose one of these
paths for the next run. No app concept will be selected at this gate.

1. **Open exploration:** Research current users and competitors across all
   feasible families, then rank territories.
2. **Focused exploration:** Choose three to five award families from the list
   below for current user, workaround, competitor, pricing, community, platform,
   and build-risk research.

The family choices are Grand Prize/growth, `#BuildInPublic`, Design, Peace
Prize, HAMM, Best Game, Catvertising, Next Gen, one Influencer Award, Ship
Kotlin Everywhere, Most Viral App, Best App for Galaxy, Idea to Income, Keep
Them Coming Back, Growth Loop, Funnel Vision, or Conflict of Interest when
eligible.

## Next steps

Return the builder-intake answers and either “open exploration” or three to five
selected families. The next run will research current pain, workarounds,
competitors, pricing, reachable communities, platform context, and build risk.
It will not jump to a final idea.
