# Run 4 report: audience and problem landscape

Run 4 finds four credible problem territories, but none supports a generic app.
The strongest opportunities are narrower: a defensible capture-to-report job
for independent inspectors, a lapse-recovery job for adults with ADHD or time
blindness, shared cognitive ownership in households, and transparent offline
recovery for small field teams. The first two remain strongest across all five
weighting models. This run does not generate product concepts or select an
award.

## Executive summary

The research covers the user-selected four-territory override: T2, T3, T4,
and T5. It reviews 12 precise audience segments, 24 current competitors or
substitutes, direct user discussions and store reviews, current pricing and
product pages, official platform guidance, and peer-reviewed evidence for
safety-sensitive claims.

- **T2 has the strongest commercial problem.** Independent property
  inspectors repeatedly separate field observation from later report writing,
  use hundreds of photos as memory aids, and pay $109 per month for a mature
  vertical suite. The gap is not a replacement inspector platform. It is the
  narrow, defensible association of evidence, location, defect, and report
  language with visible uncertainty and recovery.
- **T5 has the strongest solo-builder consumer problem.** Current ADHD users
  describe novelty decay, rigid schedules, and ignored notifications. Leading
  apps already prove demand for gentle framing and visual planning, but the
  recurring unresolved job is choosing and restarting the next useful action
  after disruption.
- **T3 has strong pain but weak automatic monetization.** Cognitive household
  labor is a measured burden, yet apps often make the overloaded partner the
  system administrator. A household app cannot create partner buy-in by adding
  more tasks, points, or reminders.
- **T4 has the clearest native-platform advantage and the highest technical
  risk.** Current field reviews and support threads describe sync failure,
  opaque state, media upload problems, platform disparity, and battery costs.
  Solving this credibly requires offline-first data ownership, conflict and
  retry semantics, media durability, and extensive device testing.
- **Award fit remains only 3% of the base score.** Galaxy, Kotlin, Design,
  OneSignal, Layers, Peace, and HAMM relevance can strengthen an already useful
  product, but none rescues weak user value.
- **Recommended gate outcome:** carry T2-S1 and T5-S1 into concept generation
  under an Android-first adaptive platform hypothesis. They rank first and
  second in the base model and remain in the top three under every sensitivity
  model.

## Scope, method, and artifacts

The analysis treats the user's addition of T5 as an explicit expansion from
three to four territories. It avoids market-size estimates and does not infer
prevalence from individual reviews or posts. Current evidence is dated through
August 9, 2026.

The structured artifacts are:

- the [source and uncertainty ledger](./source-ledger.csv), with 61
  source records;
- the [24-product competitor audit](./competitor-audit.csv), with six
  competitors or substitutes per territory; and
- the [12-problem weighted scorecard](./opportunity-scorecard.csv),
  including four sensitivity models.

Exa supplied discovery and full-text extraction. Exa could not extract one
important Reddit thread, so a web-text fallback recovered it. Exa also failed
on BAND, Nipto's review-only endpoint, and Structured's pricing path. First-
party App Store or product pages supplied equivalent Nipto and Structured
evidence; BAND was replaced by the better-evidenced WhatsApp-plus-calendar
substitute. No screenshot or vision fallback was required.

## T2: capture-to-usable-artifact workflows

T2 is not one market. The common mechanism is a loss of meaning between raw
capture and a consequential artifact. Competitors already transcribe,
summarize, rewrite, and export. The defensible gap is a specific artifact whose
recipient can verify it and whose creator can trace it back to source evidence.

### Audience segments

Three segments show distinct stakes and payment behavior. Frequency refers to
the workflow within the segment, not estimated population prevalence.

| Segment | Trigger and job to be done | Frequency, severity, and stakes | Workaround and switching cost | Payment and unmet value |
|---|---|---|---|---|
| **T2-S1 Independent property inspectors** | During and after every inspection, associate defects, locations, photos, voice or shorthand, and required narrative into a defensible client report | Per paid job; high time cost and liability; urgency is same-day or next-day delivery | Hundreds of photos, hand signals in photos, point-and-shoot camera, desktop reporting, customized templates, voice dictation; high switching cost from templates and business records | Mature users pay Spectora $109 monthly or $1,090 yearly; unmet value is faster evidence association and recoverable field capture without replacing the full business suite |
| **T2-S2 Solo client-service professionals** | When clients send calls, chats, and rambling voice messages, turn them into decisions, scope, actions, open questions, and written confirmation | Episodic but repeated across active clients; moderate-to-high rework and relationship stakes; urgent before work starts | Replay and type, require email, upload to transcription, paste into an LLM, send recap for confirmation; switching cost is low because the workaround uses existing tools | Otter, Granola, Voicenotes, and AudioPen establish $8–$17 monthly willingness to pay; unmet value is confirmation and provenance, not another summary |
| **T2-S3 Research-intensive students and qualitative researchers** | During literature review or analysis, turn scattered PDFs, photos, handwritten notes, quotations, and memos into a traceable synthesis | Weekly or daily during research phases; severity rises near writing deadlines; citation error has academic stakes | Zotero or Mendeley plus Obsidian, Notion, Word, spreadsheets, and manual templates; high data-migration cost once a corpus grows | Student willingness to add another subscription appears weak; unmet value is reliable claim-to-source traceability, but current evidence is thin |

The general note-taking user wants capture and recall. These segments need an
artifact that can withstand external scrutiny. That difference raises the
importance of local save, original-audio access, stable timestamps, editable
AI output, explicit uncertainty, and a review state before anything is shared.

### Direct user evidence and workarounds

Current professional forums show a stable inspection workaround: focus on the
property, use photos as memory, and write at a desktop later. One inspector
reported an eight-hour early job; experienced respondents described 300 photos,
one to three hours of later report writing, hundreds of hours spent customizing
templates, and mobile software that can slow the onsite sequence. These are
observed workflows, not a measured industry average.
[InterNACHI efficiency discussion](https://forum.nachi.org/t/efficient-home-inspections/240686),
[software discussion](https://forum.nachi.org/t/clean-looking-user-friendly-inspection-software/242208).

A current r/freelance thread describes three-to-four-minute client voice clips,
roughly doubled review effort, and a repeated workaround: transcribe, organize,
send the structured record back, and wait for confirmation. Some respondents
would charge the transcription as admin time; others note that voice can be an
accessibility or mobility preference for the client. This is one thread and is
used for mechanism discovery, not prevalence.
[r/freelance discussion](https://www.reddit.com/r/freelance/comments/1uqoptb/how_do_you_handle_clients_who_prefer_sending_long/).

### Competitor and substitute audit

The six audited products cover generic meeting capture, voice-to-writing, and
vertical inspection suites. The full journey, pricing, retention, and review
evidence is in the competitor CSV.

| Product | Current promise and price | Review-supported strength | Review-supported weakness | Market-gap implication |
|---|---|---|---|---|
| Otter | Transcript, summary, search, and collaboration; free, then $16.99 monthly or $8.33 monthly billed annually | Mature capture, export, and meeting archive | Mobile recordings reported missing; free plan has multiple limits | Reliability and artifact-specific confirmation matter more than another transcript |
| Granola | Bot-free meeting notes; free, then $14 monthly | Highly praised note structure and low-friction meetings | Meaning can be changed; raw-note editing, Watch, car, and mobile issues | Human review and source trace must be visible |
| Voicenotes | Voice memory and AI outputs; free, then $9 monthly | Broad platforms, integrations, and searchable history | Long recordings lost, field recording stopped, exports and organization inconsistent | Local durability and recovery are core product value |
| AudioPen | Voice to polished text; $33/3 months, $99/year, or $159/2 years | Immediate voice-to-writing value and simple pricing | Notes and audio feel disconnected; rewritten text can obscure source nuance | Verified transformation is more valuable than another style |
| Spectora | Inspector operating system; $109 monthly | Deep vertical workflow and strong review satisfaction | Template setup, fees, client clutter, and trust concerns | Complement a narrow job; do not clone the suite |
| SafetyCulture | Inspection and operations platform; free, then $24/seat monthly billed annually | Flexible forms, media, tasks, and reports | Crashes, media/sync failure, feature breadth, and support complaints | A narrow local-first workflow may outperform breadth |

### Trust, reachability, platform, and dependencies

Independent inspectors are reachable through InterNACHI forums, state
associations, YouTube training channels, local inspector groups, and software
communities. Solo consultants are reachable through r/freelance, LinkedIn,
professional Slack groups, and creator/agency communities. Research students
are reachable through departments, labs, Zotero and Obsidian communities, and
the builder's qualifying student network.

The strongest native value for inspectors is camera and media durability,
offline local storage, speech capture, geotagging, file export, side-by-side
reference on tablets or foldables, and desktop review. Dependencies include
speech-to-text, document generation, local database migration, media storage,
and a domain glossary. Recording other people requires explicit consent and
clear retention controls. AI-generated professional language must remain a
draft with original evidence available.

## T3: small-group utility with recipient-side value

T3 succeeds only when the invited person gains value with little setup. The
main failure is not missing reminders. It is that one motivated person still
anticipates the work, configures the system, assigns tasks, follows up, and
interprets the results.

### Audience segments

The three segments vary sharply in stakes, willingness to pay, and operational
burden.

| Segment | Trigger and job to be done | Frequency, severity, and stakes | Workaround and switching cost | Payment and unmet value |
|---|---|---|---|---|
| **T3-S1 Dual-income households** | Anticipate, choose, execute, and monitor chores, appointments, shopping, and family administration without one person carrying the cognitive load | Daily; high chronic emotional and relationship stakes; individual tasks may be low urgency | Shared calendar, texts, whiteboard, paper list, Cozi, Tody, or Nipto; switching fails if the less-engaged partner will not adopt | Cozi is $39–$79 per family yearly, Tody and Nipto are inexpensive; willingness exists but is price-sensitive; unmet value is shared ownership, not delegation |
| **T3-S2 Distributed family caregivers** | Coordinate updates, appointments, medications, documents, visits, and tasks across siblings or helpers while limiting access to sensitive data | Daily or event-driven; high urgency and safety stakes; emotional load is severe | Group text, calls, spreadsheets, portal screenshots, paper binder, shared calendar, or Caring Village; switching cost is high once medical history accumulates | Caring Village lists $14.99–$24.99 monthly and $149.99–$249.99 yearly tiers; unmet value is understandable least-privilege sharing and dependable handoff |
| **T3-S3 Volunteer club and sports organizers** | Gather attendance, schedule changes, payments, and volunteer commitments without manually reconciling a noisy group chat | Weekly and seasonal; missed changes create moderate operational and social cost | WhatsApp, email, Sheets, Venmo, Google Calendar, Spond, or BAND; existing group identity creates high switching inertia | Spond's core is free and strong; willingness to pay is low unless payments or club administration create clear savings |

A peer-reviewed self-report study of 322 mothers of young children found that
cognitive household labor was more unequally distributed than physical labor
and was associated with stress, burnout, mental health, and relationship
functioning. The sample is narrow and does not establish demand for an app, but
it supports the severity of planning and monitoring work.
[Cognitive household labor study](https://pmc.ncbi.nlm.nih.gov/articles/PMC11761833/).

### Product-value gap

Chore apps can reduce memory load, but they can also add a new layer of work to
the person already managing the home. Interview evidence describes Cozi failing
when one partner still had to assign everything; Nipto helped one gaming-
oriented couple make contribution visible. The mechanism appears conditional
on mutual buy-in and interaction style, not on the number of task features.
[MIT Technology Review](https://www.technologyreview.com/2022/05/10/1051954/chore-apps/).

For recipient-side utility, structured social support can matter. In one
10-week intervention with 54 African American women, participants who posted at
least weekly in a private group recorded more steps and activity minutes. The
intervention also included in-person sessions and structured group goals, so it
does not prove a standalone social app causes the outcome.
[JMIR mixed-methods study](https://mhealth.jmir.org/2025/1/e68006).

### Competitor and substitute audit

Current products already cover calendars, chores, sports groups, caregiving,
and zero-friction chat. A new product must beat an incumbent on adoption, not
just feature count.

| Product | Current promise and price | Strength | Weakness | Market-gap implication |
|---|---|---|---|---|
| Cozi | Shared family calendar and lists; free, $39 Gold, $79 Max yearly | Simple, cross-platform, established family history | Visibility does not transfer planning ownership | Reciprocal contribution must be easier than delegation |
| Tody | Need-based cleaning; free with listed Solo/Duo/Family purchases | Flexible recurrence and reduced mental-load reviews | Setup remains work; cleaning-only | Preserve the restrained loop; do not expand into a household super-app |
| Nipto | Chore points and weekly rewards; $1.99 monthly or $12.99 yearly | Clear group value and low price | Notification/sync bugs, setup burden, and competition risk | Solve durable participation after novelty |
| Spond | Events, RSVP, payments, and groups; core is free | Invitees can respond without installing; strong adoption | Recurrence limitations; generic club clone has little room | No-install recipient value is the bar |
| Caring Village | Family care coordination; $14.99–$24.99 monthly tiers | High-severity shared record | Sensitive data and role visibility; medical operational burden | Least privilege and safe handoff are product value |
| WhatsApp + calendar | Existing chat plus separate scheduling and payment tools; usually free | Universal reach and no new account | One-host events, missing past events for new members, fragmented ownership | Remove organizer reconciliation without forcing migration |

### Trust, reachability, platform, and dependencies

Households are reachable through parenting, household labor, ADHD, budgeting,
and local community groups. Caregivers are reachable through AgingCare, Mayo
Clinic Connect, disease-specific organizations, senior centers, and hospital
caregiver programs, but recruitment and claims require more care. Club
organizers are reachable through local leagues, Spond and TeamSnap communities,
school parent groups, and hobby associations.

Shared products need invite links, guest or no-install response, explicit
ownership, notification preferences, conflict resolution, role changes,
offboarding, export, and deletion. Caregiving adds health data, document access,
medication accuracy, audit history, and potential moderation or expert-content
dependencies. Household and club versions have lower store risk, but child
accounts, payments, and interpersonal coercion still require controls.

## T4: adaptive cross-device field workflows

T4 has strong, repeated evidence that the field state itself is fragile. The
user is outdoors, moving, gloved, offline, using camera and location, switching
apps, draining a battery, and trusting that a submission will survive. A
feature-complete form builder that loses or obscures state has failed the job.

### Audience segments

Three segments share the environment but differ in buying process and domain
complexity.

| Segment | Trigger and job to be done | Frequency, severity, and stakes | Workaround and switching cost | Payment and unmet value |
|---|---|---|---|---|
| **T4-S1 Small field inspection and asset teams** | Capture structured evidence, photos, location, and notes through dead zones, then sync and produce a usable record without losing data | Every field job; high productivity and liability stakes; sync is urgent before device loss or reassignment | Paper plus photos, generic forms, ArcGIS, Fulcrum, SafetyCulture, or vertical suites; switching cost includes templates and system integration | Current products range from free to $24–$55 per seat monthly and five-user minimums; strong WTP but demanding reliability |
| **T4-S2 Environmental and academic field teams** | Collect map, form, media, and sensor observations offline, preserve provenance, and move data into analysis without enterprise GIS administration | Campaign-based or seasonal; high data-replacement cost; some sites are physically inaccessible later | Paper, REDCap, Survey123, Field Maps, Fulcrum, spreadsheets, handheld GPS, and manual export | Grants or institutions can pay, but small teams and students are price-sensitive; unmet value is self-serve field-to-review continuity |
| **T4-S3 Construction foremen and specialty subcontractors** | Carry current plans, measurements, tasks, photos, and punch evidence across phone and tablet on a jobsite | Daily; downtime and incorrect measurement can be expensive; coordination is urgent | Printed plans, photos, texts, Fieldwire, Procore, SafetyCulture, and trade-specific systems; switching requires whole-team adoption | High WTP but mature incumbents, sales-led deployment, and broad project dependencies make differentiation weak |

Current Esri community threads report offline edits failing with invalid JSON,
logs that do not expose the offending data, repeated login, indefinite spinners,
and forced restarts. App Store reviews report update-related map failure,
battery drain, doubled inspection time, and unrecoverable points. These reports
do not prove a general failure rate, but they identify the cost and recovery
states a credible product must handle.
[Esri sync thread](https://community.esri.com/t5/arcgis-field-maps-questions/unable-to-sync-offline-edits/td-p/1695575),
[Field Maps reviews](https://apps.apple.com/us/app/arcgis-field-maps/id1515671684?platform=iphone&see-all=reviews).

Peer-reviewed deployments show that offline electronic capture can work, but
usability must be tested with the actual field population. One REDCap test
reported a System Usability Scale score of 74; a 93-participant South Sudan
deployment reported 60.91 and described upload and operational challenges.
Neither study validates a commercial opportunity in the United States.
[REDCap usability study](https://pmc.ncbi.nlm.nih.gov/articles/PMC8600440/),
[field deployment study](https://link.springer.com/article/10.1186/s12936-024-05092-w).

### Competitor and substitute audit

The market is mature and enterprise-heavy. Its recurring weakness is not lack
of forms; it is reliable operation under field constraints.

| Product | Current price signal | Strength | Weakness | Market-gap implication |
|---|---|---|---|---|
| ArcGIS Field Maps | ArcGIS user-type license | Authoritative GIS, offline maps, tasks, and integrations | Setup complexity, opaque sync, low store rating, and update risk | Target a narrow non-GIS job with transparent local state |
| Fulcrum | From observed $43/user/month annual view; five-user minimum | Rich offline forms, GIS, media, logic, and automation | Android parity, map, lag, offline, and long-sync complaints | Small-team Android-first reliability may be a wedge |
| SafetyCulture | Free, then $24/seat/month billed annually | Strong form/report workflow and generous trial | Crashes, failed media, repeated sync prompts, and feature density | Local durability must precede analytics and AI |
| TrueContext | Starts $400/month billed annually | Guided enterprise workflows and compliance | Sales-led cost and deployment | Self-serve narrow workflows are underserved |
| GoCanvas | $29–$49/user/month, three-user minimum | Clear forms, reports, dispatch, and integrations | Generic form setup and annual team commitment | Improve a decision workflow, not paper digitization alone |
| Fieldwire | Free tier, then $39–$89/user/month billed annually | Strong construction plans and tasks | Platform parity and measurement-calibration risk | A generic construction clone is not defensible |

### Native platform advantage and build risk

The native opportunity is real: camera previews across postures, side-by-side
reference and capture, multi-window, drag and drop, app continuity, keyboard
and mouse in DeX, location, barcode or OCR, offline maps, haptics, background
upload, and persistent visible sync state. Android and Samsung both publish
explicit foldable, large-screen, and DeX guidance.
[Android foldable quality](https://developer.android.com/docs/quality-guidelines/adaptive-app-quality/experiences/foldables),
[Samsung large screens](https://developer.samsung.com/foldables-and-largescreens),
[Samsung DeX](https://developer.samsung.com/samsung-dex/modify-optimizing.html).

This is also the highest-risk territory for Capacitor. A WebView can support a
form UI, but durable media capture, background work, database migration,
process death, conflict resolution, large files, camera lifecycle, and adaptive
window testing create native-plugin and device-specific touchpoints. A narrow
Android-native implementation reduces uncertainty. A full offline media-sync
platform is not a realistic first version for one developer without severe
scope control.

## T5: respectful return loops for intermittent goals

T5 is not “a nicer habit tracker.” The recurring job happens after the plan
breaks: choose what still matters, resize the commitment, preserve honest
history, and restart without converting a missed day into identity failure.

### Audience segments

The three segments need different definitions of progress. All health-related
claims must remain nonclinical unless supported by expert review and compliant
operations.

| Segment | Trigger and job to be done | Frequency, severity, and stakes | Workaround and switching cost | Payment and unmet value |
|---|---|---|---|---|
| **T5-S1 Adults with ADHD or time blindness** | After distraction, delay, hyperfocus, or a missed plan, identify a feasible next action and restart without rebuilding the whole schedule | Daily and episodic; high frustration and self-efficacy stakes; urgency is in the moment | Paper planner, Google Calendar, alarms, notes, Finch, Tiimo, Structured, Habitica; many tools are abandoned after novelty | Tiimo lists multiple Pro SKUs, Structured $2.99–$6.99 monthly and $29.99 yearly, Finch optional Plus; willingness is moderate but competition is strong |
| **T5-S2 Adults with chronic illness and variable capacity** | Plan against current energy, protect essential commitments, count rest, and revise expectations without rewriting history as failure | Daily variability and flare events; high physical and emotional stakes; urgency is capacity-dependent | Spoon budgeting, Excel or Google Calendar, paper lists, timers, Finch, and emerging energy planners; setup can itself consume capacity | Direct WTP evidence is weak; unmet value is capacity-aware planning and compassionate history rather than medical advice |
| **T5-S3 Long-horizon learners returning after interruption** | Resume meaningful practice at the correct level after a break and see competence progress instead of preserving a streak through trivial activity | Daily to weekly; moderate emotional stakes; urgency is low but dropout risk compounds | Duolingo streak freezes, short lessons, alternate apps, tutors, courses, paper study plan | Consumers pay for learning apps, but content, pedagogy, and localization create a prohibitive solo-team dependency |

A small ADHD forum thread describes novelty wearing off after roughly two
months, apps becoming restrictive or oppressive, fallback to calendar and
notes, and a desire for human accountability. It is mechanism evidence only.
[Mental Health Forum](https://www.mentalhealthforum.net/forum/threads/do-you-use-habit-apps-for-your-adhd-why-and-why-not.689991/).

People discussing chronic illness describe budgeting daily “spoons,” scheduling
rest, DIY Excel and Google Calendar systems, over-commitment, and the planning
system itself consuming energy. This supports variable-capacity design but not
clinical efficacy or market prevalence.
[Mayo Clinic Connect discussion](https://connect.mayoclinic.org/discussion/how-do-you-plan-your-day-and-conserve-energy-are-you-a-spoonie/?pg=13).

A qualitative HCI study of Duolingo forum data and 15 interviews identifies
gamification misuse when game mechanics displace learning. A separate 550-day
user describes completing a 42-second lesson to preserve the streak while
perceived learning declined. These sources support the mechanism, not a claim
that all learners experience it.
[Gamification misuse study](https://arxiv.org/pdf/2203.16175.pdf),
[long-term user account](https://www.androidauthority.com/reasons-give-up-duolingo-streak-3543009/).

### Competitor and substitute audit

Current products already demonstrate strong demand for emotional safety,
visual structure, native integrations, and gameful motivation. The remaining
gap is the quality of recovery after deviation.

| Product | Current price signal | Strength | Weakness | Market-gap implication |
|---|---|---|---|---|
| Finch | Free plus varied Finch Plus SKUs | Gentle small steps, pet attachment, community, and useful free tier | Content operation and novelty plateau; completion can become currency collection | Focus on restart quality, not another reward inventory |
| Tiimo | Free plus Pro, seven-day annual trial | Neurodivergent focus, visual plan, widgets, Watch, and cross-device support | Rigid schedules, notification fit, sync, Watch, and bug disruption | Design for plan failure as a normal state |
| Structured | Free; $2.99–$6.99 monthly, $29.99 annual, $99.99 lifetime listed | Restrained timeline, replan, and strong accessibility declaration | Pro boundary and daily time-block assumptions | Capacity-aware replanning is distinct from visual time blocking |
| Habitica | Free; group $9/month + $3/member | Memorable social accountability and customization | Content fatigue, punishment, bugs, and economy displacement | Do not turn recovery into another content treadmill |
| Streaks | $5.99 one-time, Apple platforms | Low cost, native Health/Watch/widgets, and simplicity | Consecutive-day framing, sync reversal, and Apple-only reach | Preserve progress through changed cadence |
| Duolingo | Freemium substitute | Exceptional content, onboarding, and return mechanics | Streak can substitute for competence; content burden is enormous | Avoid content-heavy learning as a solo-build direction |

### Trust, reachability, platform, and dependencies

ADHD users are reachable through ADHD forums, neurodivergent creator
communities, campus disability groups, productivity communities, and app-
specific forums. Chronic-illness users are reachable through Mayo Clinic
Connect, disease-specific communities, disability groups, and “spoonie”
communities, but recruiting must avoid therapeutic promises. Learners are easy
to reach through language and skill communities, but a credible learning
product requires domain content and pedagogy.

Native capabilities include widgets, Live Activities, notifications, Focus
Modes, Health data when genuinely relevant, Watch or wearable glanceability,
haptics, accessibility APIs, and offline local-first history. Permission timing
must follow demonstrated value. Private reflections and health-related data
need minimal collection, clear deletion, export, and no manipulative notification
copy. Crisis or diagnostic claims are out of scope without qualified experts.

## Cross-territory market gaps

The repeated gaps are mechanisms, not blank feature cells. They can guide later
concept generation without prescribing a product now.

| Gap | Evidence across territories | What would falsify it |
|---|---|---|
| **State must be trustworthy before AI is useful** | Lost recordings in Otter/Voicenotes, sync and media failures in field apps, task state reversing in Streaks | Users accept occasional loss because output value is much higher, or the failures disappear in observed tests |
| **The artifact needs a verifier** | Client scope requires confirmation; inspection reports need source evidence; field sync needs review; AI notes can change meaning | Users consistently share outputs without review and report no consequential corrections |
| **Recipient-side value determines group adoption** | Spond no-app responses, caregiver updates, family calendar value, WhatsApp's incumbent reach | Invited users adopt a new app even when only the organizer benefits |
| **Recovery quality matters more than streak preservation** | ADHD novelty decay, chronic-capacity workarounds, Finch no-shame praise, Duolingo engagement-learning conflict | Longitudinal users prefer loss pressure and show better target outcomes from it |
| **Enterprise breadth leaves a self-serve gap but raises reliability expectations** | T4 products are expensive, minimum-seat, and complex; users still report field failures | Small teams are unwilling to pay for a narrow tool or require enterprise integrations from day one |

## Opportunity scorecard

The scorecard uses 1 to 5, where 5 is favorable. For operational burden and
ethical/store risk, the dimensions are expressed positively as operational
lightness and ethical/store safety. A problem with pain strength or evidence
quality of 2 or less is capped and cannot be recommended. No current row
triggered the cap.

### Base weighting

User value, evidence, and buildability dominate the base model. Award fit is
deliberately too small to rescue weak demand.

| Dimension | Weight | Meaning of 5 |
|---|---:|---|
| Pain strength | 15% | Frequent, severe, urgent, or consequential pain |
| Segment focus | 8% | Precisely reachable user and triggering situation |
| Evidence quality | 12% | Multiple direct, current, or research-supported sources |
| Reachability | 10% | Accessible communities and practical recruiting channels |
| Willingness to pay | 10% | Existing spend or clear economic value |
| Differentiation | 10% | Missing product value rather than a minor feature |
| Native-platform advantage | 8% | Device capability materially improves the job |
| Buildability | 12% | Narrow version is realistic for the solo AI-assisted team |
| Operational lightness | 7% | Low content, support, moderation, and service burden |
| Ethical and store safety | 5% | Low claims, privacy, security, and review risk |
| Natural award fit | 3% | One coherent primary-award route without bolt-ons |

### Ranked results and sensitivity

Five models test whether the ranking depends on the chosen priorities. Full raw
scores are in the scorecard CSV.

| Rank | Problem | Base | User value | Solo builder | Commercial | Platform |
|---:|---|---:|---:|---:|---:|---:|
| 1 | T2-S1 Independent property inspectors | 83.4 | 84.2 | 79.2 | 85.2 | 85.2 |
| 2 | T5-S1 Adults with ADHD or time blindness | 81.6 | 83.4 | 81.8 | 81.8 | 81.0 |
| 3 | T3-S1 Dual-income households | 79.2 | 82.8 | 80.2 | 78.8 | 76.0 |
| 4 | T4-S1 Small field inspection teams | 78.6 | 81.0 | 71.6 | 80.6 | 81.8 |
| 5 | T5-S2 Chronic illness and variable capacity | 77.8 | 79.4 | 76.8 | 76.6 | 79.0 |
| 6 | T2-S2 Solo client-service professionals | 77.4 | 78.0 | 78.4 | 79.2 | 75.0 |
| 7 | T3-S2 Distributed family caregivers | 71.4 | 73.6 | 68.0 | 73.2 | 71.0 |
| 8 | T4-S3 Construction foremen and subcontractors | 70.6 | 74.4 | 63.6 | 72.0 | 74.0 |
| 9 | T4-S2 Environmental field research teams | 69.2 | 70.8 | 64.0 | 69.2 | 74.2 |
| 10 | T3-S3 Volunteer club organizers | 68.2 | 70.6 | 69.8 | 67.2 | 67.8 |
| 11 | T2-S3 Research-intensive students | 67.6 | 69.8 | 67.4 | 68.4 | 66.6 |
| 12 | T5-S3 Long-horizon learners after interruption | 67.2 | 71.8 | 62.6 | 70.6 | 66.2 |

T2-S1 ranks first in four models and third under the solo-builder model. T5-S1
ranks first under solo-builder and second everywhere else. T3-S1 is consistently
third except in the commercial and platform models. T4-S1 rises when native
advantage or commercial value is emphasized and falls when solo buildability
dominates. This stability supports a two-problem shortlist but does not prove a
market.

### Buildability reality check

These estimates assume AI-assisted development, debugging, testing, store work,
and rework. They describe narrow validation builds, not full competitor parity.

| Problem | Narrow validation build | Main scope trap |
|---|---|---|
| T2-S1 inspector evidence workflow | 9–13 weeks | Becoming a complete report, CRM, payments, template, and compliance suite |
| T5-S1 ADHD restart workflow | 7–10 weeks | Becoming a general planner, therapy product, content library, or social network |
| T3-S1 household ownership workflow | 8–12 weeks | Recreating calendar, chat, chores, shopping, and finance in one app |
| T4-S1 offline field workflow | 14–20 weeks | General form builder, map platform, media sync engine, and enterprise integrations |
| T5-S2 capacity-aware workflow | 8–12 weeks | Medical claims, symptom management, or clinical advice |
| T2-S2 confirmable client record | 6–9 weeks | Generic transcription and meeting-note competition |

## Platform hypotheses

The gate selects a hypothesis, not a permanent stack. Each hypothesis changes
which problems are economical to explore.

### H1 — Android-first adaptive

Use a native Android application designed for phone, tablet, foldable,
multi-window, and later DeX, with local-first storage and current Samsung Remote
Test Lab coverage. This is the strongest fit for T2-S1 and T4-S1 and remains
viable for T5-S1. It matches the builder's local Windows/Android test access and
creates real Galaxy evidence. It delays iOS reach and makes future shared-code
expansion a later decision.

### H2 — Dual-store shared-code mobile

Use a mobile-first shared-code application, with Capacitor as the leading
hypothesis and only necessary native modules for notifications, widgets, share,
camera, and local storage. This best fits T2-S2, T3-S1, and a restrained T5-S1.
It maximizes reachable testers but weakens differentiated Galaxy behavior and
requires an early spike for notification, background, and local-database
reliability.

### H3 — Apple-first universal

Use iPhone and iPad first, with Mac or Watch only when the selected job requires
continuity or glanceable action. This fits T5-S1 and some T2 knowledge workflows
because Apple exposes strong widgets, Live Activities, Watch, Health, and
accessibility patterns. It is operationally weaker for this builder because
testing and deployment depend on remote Mac access, and it provides no Galaxy
award path.

## Evidence and uncertainty ledger

The complete ledger records titles, URLs, dates, tier, current status, claim
type, confidence, and fallbacks. The main evidence classes are summarized here.

| Evidence class | Coverage | What it supports | Main uncertainty |
|---|---|---|---|
| Direct current user language | Reddit fallback, professional forums, app reviews, mental-health and patient forums, GitHub discussions | Triggers, workarounds, failure states, switching friction, and emotional language | Visible posts and store reviews are selected samples, not prevalence estimates |
| Official competitor pages and pricing | 24 audited products or substitutes | Current promise, feature boundary, onboarding description, price, platforms, and retention mechanisms | Vendor outcome claims are described, not independently measured |
| Peer-reviewed research | Household cognitive labor, shared activity, mHealth retention, offline field capture, gamification misuse, autistic routines, feature overload | Safety-sensitive mechanisms, usability conditions, and limits of gamification or reminders | Populations and interventions do not directly estimate this product's market |
| Official platform guidance | Android, Samsung foldables, DeX, and Galaxy Store | Test requirements, native opportunities, and store workload | Platform capability is not user demand |
| Analyst scoring and build estimates | 12 frozen rows and five weight models | Structured comparison and sensitivity | Scores are judgments, not measured conversion or development velocity |

Material claims remain labeled as observed, described, measured with provenance,
inferred, or unknown in the source ledger. Current prices are snapshots and must
be rechecked before concept economics or purchase decisions.

## Contradictions and missing evidence

The following gaps prevent a product or award decision at this stage.

- No primary interviews or observed usability tests have been conducted with
  the 12 segments. Public evidence can nominate problems but cannot validate a
  founder's exact wedge.
- The recovered Reddit thread is current and directly relevant but very small.
  It supports a workaround mechanism, not freelancer prevalence.
- App Store and Google Play pages expose selected reviews rather than a
  reproducible complete sample. Ratings and visible reviews can change.
- Competitor onboarding and time-to-value were not tested hands-on. They are
  described from current pages and analyst-estimated from required steps.
- Several App Store pages contain legacy or duplicate purchase SKUs. Tody,
  Finch, Tiimo, and Structured price periods cannot be inferred when the store
  does not label them.
- Fulcrum's pricing layout shows different monthly and annual figures in an
  ambiguous order. The audit records the observed range rather than inventing a
  definitive price.
- Field failures may be version-, device-, map-, form-, or configuration-
  specific. They prove necessary recovery states, not the failure rate of each
  platform.
- The household cognitive-labor study uses a specific sample of mothers with
  young children and cannot represent every household structure.
- Caregiving and chronic-illness segments have high emotional stakes but add
  security, privacy, claims, and expert-review work. Award fit does not offset
  that burden.
- Samsung's foldable and DeX documentation proves technical opportunity, not
  demand among independent inspectors. That demand must be tested.
- No broad market-size estimate, conversion benchmark, or willingness-to-pay
  survey was used. Existing competitor payment is a signal, not proof that a
  new product will be purchased.

## Recommendation

Advance **T2-S1 independent property inspectors** and **T5-S1 adults with ADHD
or time blindness** under **H1 Android-first adaptive**.

T2-S1 has the best combination of severe repeated pain, a precise reachable
community, existing professional spend, a visually demonstrable capture-to-
artifact job, and genuine camera/offline/large-screen advantage. Concept work
must stay complementary to Spectora and other full suites.

T5-S1 offers the strongest solo-builder balance: high pain and reachability,
moderate technical burden, lower ongoing content needs than a game or course,
and a clear ethical differentiator around restart. Concept work must avoid
diagnosis, therapy, coercive streaks, and a general-purpose planner.

H1 is recommended because it lets both problems share a current platform
hypothesis while giving T2-S1 real adaptive and Galaxy evidence. It also uses
the builder's local Android test environment. If T2-S1 is rejected, H2 becomes
the better default for T3-S1 plus T5-S1.

## Decision gate

Choose two problem statements and one platform hypothesis. You may reject all
territories if none is strong enough.

- **Option A — Recommended balanced pair:** T2-S1 independent property
  inspectors + T5-S1 adults with ADHD/time blindness; H1 Android-first
  adaptive.
- **Option B — Lower technical risk:** T2-S2 solo client-service professionals
  + T3-S1 dual-income households; H2 dual-store shared code.
- **Option C — Native field concentration:** T2-S1 independent property
  inspectors + T4-S1 small field inspection teams; H1 Android-first adaptive.
- **Option D — Respectful routine concentration:** T5-S1 adults with ADHD/time
  blindness + T5-S2 adults with variable capacity; H2 dual-store shared code.
- **Custom or reject all:** choose any two of T2-S1 through T5-S3 and H1–H3,
  request one evidence-derived replacement, or reject the full landscape.

No concept or primary award is selected by this gate.

## Next steps

After the gate, Run 5 can generate multiple concepts for only the two selected
problems. Each concept must keep one audience, one core loop, one primary award,
a working end-to-end prototype path, explicit trade-offs, and a falsifiable
first test. Stack selection can remain provisional until the preferred concept
reveals its native and offline requirements.

## Updated research state

This block carries the accepted scope, evidence, rejected directions, and next
decision into the following run.

```yaml
RESEARCH_STATE:
  completed_run: 4
  rules_version_observed: "2026 official rules rechecked August 9, 2026; user-directed August 1 start; Galaxy is 80% standard applicable criteria plus 20% Galaxy optimization"
  builder_constraints:
    team_and_skills: "Solo developer; owns development and marketing; AI-assisted implementation; no code or designs yet"
    available_hours: "No fixed cap; estimates include debugging, testing, store work, and rework"
    budget: "Prefer free tiers, credits, existing subscriptions, and few architectural touchpoints"
    eligible_platforms: "Android locally; iOS, iPadOS, and macOS through MacinCloud; US distribution"
    developer_accounts: "One planned Apple Developer account and one planned Google Play account; Samsung Seller account not confirmed"
    student_status: "Qualifying student email available"
    sponsor_employee_status: "No disclosed sponsor conflict"
    geography_and_store_access: "United States"
    backend_and_ai_tolerance: "Open, but prefers a small service surface; existing CockroachDB, MongoDB, OpenRouter, OpenAI, QwenCloud, and Ollama options"
    regulated_or_sensitive_domains_to_avoid: "No categorical exclusion; medical requires compliance and expert boundaries; legal and financial require stronger security and scrutiny"
  selected_primary_award:
  allowed_secondary_awards: []
  shortlisted_award_families: []
  selected_opportunity_territories:
    - "T2 capture-to-usable-artifact workflows for solo work"
    - "T3 small-group utility with recipient-side value"
    - "T4 adaptive cross-device field workflows"
    - "T5 respectful return loops for intermittent goals"
  researched_problem_statements:
    - "T2-S1 independent property inspectors"
    - "T2-S2 solo client-service professionals"
    - "T2-S3 research-intensive students and qualitative researchers"
    - "T3-S1 dual-income households"
    - "T3-S2 distributed family caregivers"
    - "T3-S3 volunteer club and youth-sports organizers"
    - "T4-S1 small field inspection and asset teams"
    - "T4-S2 environmental and academic field teams"
    - "T4-S3 construction foremen and specialty subcontractors"
    - "T5-S1 adults with ADHD or time blindness"
    - "T5-S2 adults managing chronic illness and variable capacity"
    - "T5-S3 long-horizon learners after interruption"
  recommended_problem_shortlist:
    - "T2-S1 independent property inspectors"
    - "T5-S1 adults with ADHD or time blindness"
  selected_problems: []
  platform_hypotheses:
    - "H1 Android-first adaptive"
    - "H2 dual-store shared-code mobile"
    - "H3 Apple-first universal"
  selected_platform_hypothesis:
  shortlisted_concepts: []
  selected_concept:
  selected_ux_direction:
  selected_visual_direction:
  rejected_directions:
    - "Generic AI transcription, meeting-note, or voice-to-writing app"
    - "Replacing a full home-inspector operating system in the first version"
    - "Household task app that makes the overloaded partner administer everyone else"
    - "Generic sports or club organizer competing with free Spond and existing group chat"
    - "Enterprise field-form or GIS suite clone"
    - "Offline or field promise without local durability, visible sync state, and recovery"
    - "Streak mechanic that optimizes return without meaningful target progress"
    - "Content-heavy learning platform or game economy for a solo first version"
    - "Clinical, diagnostic, or therapeutic claims without qualified experts and compliance"
    - "Letting high award fit rescue pain or evidence scores of 2 or below"
    - "Generating concepts before this problem and platform gate"
  accepted_evidence:
    - "61-source current evidence ledger with URLs, dates, tiers, claim status, confidence, and fallbacks"
    - "24-product competitor and substitute audit, six per territory"
    - "Direct current app reviews, professional forums, community discussions, and observable workarounds"
    - "Peer-reviewed evidence for household cognitive labor, shared support, mobile retention, offline field usability, neurodivergent routines, and gamification risks"
    - "Official Android, Samsung foldable, DeX, and Galaxy Store guidance"
    - "Twelve-problem scorecard with fixed base weights, cap rule, and four sensitivity models"
    - "T2-S1 and T5-S1 remain top-three under every sensitivity model"
  unresolved_questions:
    - "Which two problem statements advance to concept generation?"
    - "Which of H1-H3 is the preferred platform hypothesis?"
    - "Will five to eight reachable target users agree to discovery interviews and prototype tests?"
    - "Can T2-S1 remain complementary to existing inspector suites?"
    - "Can T5-S1 demonstrate value without clinical claims or a general planner scope?"
    - "Is a Samsung Seller account feasible if H1 and Galaxy remain attractive?"
  next_decision: "Choose Option A-D, a custom pair plus H1-H3, or reject all territories"
```
