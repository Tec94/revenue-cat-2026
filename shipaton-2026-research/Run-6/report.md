# Run 6 — concept red team and proof plan

Run 6 eliminates C05 BriefBack, C12 Coverage Gap, and C18 Pattern Without
Pressure. It retains four concepts only as pivots, not validated products. The
recommended gate choice is **Restart Thread**, a C13+C14 combination that
preserves interrupted context and turns it into one feasible restart. C15 should
remain an optional trusted-person experiment until it proves incremental value.

This is a recommendation, not a concept decision.

## Executive summary

The adversarial scan materially changes the Run 5 ranking.

- **C05 BriefBack is an exact duplicate at the job-and-loop level.** VocalJet
  already sends a no-account voice link to clients and returns a transcript,
  brief, scope risks, action items, and reply-ready text.
- **C04 ScopeSignal is much closer to existing products than previously
  known.** ClarAccord already turns calls and WhatsApp messages into structured
  scope receipts with no-account OTP sign-off. ThreadRecap already converts
  chats into source-linked scope, payment, approval, and deadline evidence.
- **C12 Coverage Gap is already available for free in larger caregiver tools.**
  ianacare and Lotsa Helping Hands already publish specific requests and accept
  volunteer commitments. Push delivery can be delayed or missed, so a
  notification cannot be treated as coverage.
- **C18 Pattern Without Pressure remains a health tracker even when made
  smaller.** Bearable, Guava, Daylio, and Visible already offer quick logging,
  trends, and correlations—often for free. The smaller scope retains health
  policy, privacy, breach, and false-causality risk without creating enough new
  product value.
- **C07 WholeJob still addresses a strong problem, but the market is closer
  than Run 5 showed.** FairPlay already counts mental load with chore cards and
  Do/Think/Plan points. The defensible pivot is not “gamified chores”; it is
  cooperative completion of a full responsibility lifecycle. The cute house
  must reward closing the whole loop, never task volume or partner rankings.
- **C13, C14, and C15 can combine only asymmetrically.** C13 and C14 form one
  coherent loop: save the thread, return, and choose one feasible start. C15 is
  an optional escalation from that same state. Making social support part of
  the MVP adds two-person activation, availability, UGC moderation, blocking,
  and privacy work before its incremental value is known.
- **C21 Project Thread is technically safe but commercially weak.** Pieces,
  Copilot Spaces, Copilot Memory, and ordinary project notes already preserve
  context. A manual learner checkpoint may work, but it must beat those
  workarounds by reducing measured resumption time.

No concept receives an unconditional pass because no primary interviews,
prototype observations, payment choices, or behavioral pilots have been run.
The detailed prospective tests are in
[`validation-plans.md`](./validation-plans.md).

## Scope and method

The selected set contains seven hypotheses because C13, C14, and C15 are tested
as one conditional combination:

| Hypothesis | Run 6 scope |
|---|---|
| C04 ScopeSignal | Source-linked scope delta with sender verification and client correction or confirmation |
| C05 BriefBack | No-account client voice intake to structured brief |
| C07 WholeJob House | Full-responsibility ownership plus a cooperative virtual house |
| C12 Coverage Gap | Minimum-necessary care request with accept, decline, and visible fallback |
| R1 Restart Thread | C13+C14 core; C15 trusted-person start tested separately |
| C18 Pattern Without Pressure | Minimal activity and after-effect log with non-causal associations |
| C21 Project Thread | Artifact-linked project checkpoint for interrupted learners |

Exa supplied discovery variations and full-text extraction for every material
known URL. Firecrawl was used once when Exa could not extract the initially
discovered FTC page. Firecrawl confirmed that URL was a 404; Exa then found and
fetched the corrected official URL ending in `-0`. No browser, video, screenshot,
or vision fallback was required.

The research compared the proposed job, core loop, recipient behavior,
packaging, price, technical dependencies, and store-policy burden—not merely
feature lists. Current competitor pages establish product availability and
positioning; they do not establish independent efficacy, revenue, retention, or
market prevalence.

## Red-team result

Scores use 1 to 5, where 5 is more favorable. They are analyst judgments, not
measured product outcomes. Demand and differentiation receive 20% each;
technical feasibility and policy/operational safety receive 15% each;
monetization, deadline feasibility, and award fit receive 10% each.

| Rank | Concept | Score | Result | Confidence | Main reason |
|---:|---|---:|---|---|---|
| 1 | R1 Restart Thread | 3.93 | Pivot | Medium-high | C13+C14 has a coherent, low-risk wedge; C15 adds unproven social burden |
| 2 | C07 WholeJob House | 3.68 | Pivot | Medium-high | Strong pain, but two-sided adoption and close mental-load competitors remain |
| 3 | C21 Project Thread | 3.50 | Pivot | Medium | Safe and buildable, but broad, infrequent, and hard to monetize |
| 4 | C04 ScopeSignal | 3.25 | Pivot | High | Exact competitors force a very narrow correction-first wedge |
| 5 | C05 BriefBack | 2.75 | Kill | High | VocalJet is the proposed job and loop |
| 6 | C12 Coverage Gap | 2.70 | Kill | High | Free substitutes, notification limits, privacy burden, and weak paid fit |
| 7 | C18 Pattern Without Pressure | 2.70 | Kill | High | Mature free substitutes plus health-policy and interpretation risk |

The complete inputs and falsification thresholds appear in
[`red-team-scorecard.csv`](./red-team-scorecard.csv).

### Hardest proof and deadline condition

Each concept has one proof that dominates the rest of the build. The concept is
not credible by September 30 unless that proof is visible before production
scope expands.

| Concept | Hardest proof | What must be true to ship credibly |
|---|---|---|
| C04 | A real client corrects or confirms a sourced delta | One narrow freelancer segment rejects the close substitutes for the same reason; critical fields are human verified; no live-call recording or legal-effect claim |
| C05 | A distinct job remains after VocalJet | New primary evidence identifies a different persona and workflow; otherwise no build begins |
| C07 | Both partners adopt without one administering the other | The less-engaged partner claims full responsibilities voluntarily; the house rewards lifecycle closure rather than task count; sync and departure states are reliable |
| C12 | Accepted coverage remains safe when every push is missed | A visible accept, decline, expiry, and fallback state works independently of notifications; a free incumbent does not already solve the narrow job |
| R1 | Breadcrumbs are created and shorten real resumption | Local capture survives process death; users restart from at least half of real breadcrumbs; C15 is not on the critical path |
| C18 | Restraint creates product value beyond free trackers | A co-designed segment chooses the smaller model for a non-feature reason and qualified health/privacy review approves the claims and data flow |
| C21 | A checkpoint beats a normal note | The target returns at least monthly and measured resumption time falls by 30% without automatic desktop capture |

## C04 — ScopeSignal

### What the evidence supports

The problem is recurring and commercially legible. Freelancers and agencies
need to turn informal client communication into an agreed change. Product
pricing also suggests that vendors believe businesses will pay: ClarAccord
lists five free receipts and a $29 monthly plan, while ThreadRecap lists usage
packs and a $15 monthly plan. These are observed offers, not evidence of paid
conversion or retention.

The technical cost is not the main risk. At the observed OpenAI price,
transcribing a 10-minute completed recording with GPT-Transcribe would cost
about $0.045 before storage, text extraction, support, retries, and payment
fees. A low-cost model can make the transformation economically plausible.
Accuracy, consent, and client action are the real constraints.

### Strongest failure case

[ClarAccord](https://claraccord.com/) already performs the central loop: take a
voice, WhatsApp, or Zoom conversation, extract scope and commercial terms, and
obtain no-account OTP client sign-off. It also markets PDF and audit-trail
outputs. [ThreadRecap](https://www.threadrecap.com/en/whatsapp-evidence-freelancer-client)
already provides source-linked, chronological post-hoc evidence.

This removes “AI turns conversation into confirmable scope” as a differentiator.
The only remaining wedge is narrower: show exactly what changed from an already
accepted baseline, preserve the source excerpt, and make client correction as
important as confirmation. Even that wedge may be a feature that the existing
products can add quickly.

### Data, AI, policy, and operations

- Do not record live calls in the MVP. Accept user-provided text or a
  permission-cleared recorded message. Recording-consent law varies and is not
  resolved by this report.
- Preserve source links for every material amount, date, deliverable, and
  exclusion. Model output remains a draft.
- A user must explicitly verify the delta before sending it. A client correction
  becomes the authoritative state.
- Provide deletion for source and derived data, a privacy policy, Data Safety
  and App Privacy disclosures, encrypted transit, and explicit retention.
- Avoid “binding,” “admissible,” “UETA compliant,” or dispute-outcome claims
  without qualified legal review.
- Instrument critical-field correction rate, client completion, latency,
  deletion, model cost, and unconfirmed expiry.

### Monetization and award fit

HAMM remains a natural primary award only if the product can show that the paid
record prevents or recovers real billable value. Design and Growth Loop remain
coherent secondaries because client correction is the same core behavior and
the recipient link is the acquisition loop. The award combination cannot rescue
the weak differentiation.

A subscription is defensible only if a freelancer sends changes repeatedly.
Per-confirmed-delta pricing may align better with intermittent use. Google and
Apple require subscriptions to provide continuing value, so “one protected
project” should be a one-time purchase or usage event, not a disguised monthly
benefit.

### Pre-mortem

The product ships, but clients ignore unfamiliar links or feel they are being
asked to sign a surprise contract. The AI misreads a negation, deadline, or
amount. Freelancers correct every output, making email faster. ClarAccord adds a
source-delta view. A privacy incident exposes client messages. The product wins
neither trust nor differentiation despite low model cost.

### Top assumptions

1. A meaningful subgroup needs correction-first deltas rather than a normal
   recap or signed receipt.
2. Clients will open, correct, and confirm without an account.
3. Material-field precision can reach 90% with human verification.
4. Value is experienced before a dispute, not only after one.
5. A $9 monthly or $1 per-delta offer is more attractive than email.

### Recommendation

**Pivot, with a hard kill threshold.** Run a maximum one-week proof sprint. Kill
the concept unless three of five qualified freelancers reject the close
substitutes for the same source-linked correction need and at least 40% of 20
real client links are correctly confirmed within 24 hours.

Confidence: **high** that the original C04 is not differentiated; **medium-low**
that the narrower pivot survives.

## C05 — BriefBack

### What the evidence supports

Clients sometimes explain complex work more effectively by voice than by a long
form, and no-account intake reduces recipient friction. The proposed
transcription cost is low enough for a free allowance or usage pricing.

### Strongest failure case

[VocalJet](https://vocaljet.com/) describes C05 almost word for word: a
no-account client voice link for consultants, agencies, freelancers, and
studios; transcript; summary; structured brief; scope risks; action items; and
reply-ready follow-up. It explicitly positions itself against forms, calls, and
email.

Changing the prompts, interface, color, or model does not create a new product
thesis. C05 also does not resolve confirmation: a generated brief can remain an
unverified interpretation of what the client meant.

### Pre-mortem

The team spends the remaining schedule reproducing an existing product. Clients
record rambling notes, the brief omits constraints, and the freelancer still
conducts a follow-up call. Free forms and ordinary voice messages remain good
enough. The paywall arrives before unique value.

### Top assumptions

1. A distinct persona rejects VocalJet for a job not identified in Run 5.
2. Clients prefer recording over typing or scheduling.
3. Generated structure reduces follow-up rather than creating correction work.
4. The recipient loop produces acquisition rather than abandonment.

### Recommendation

**Kill.** Reopen only after new audience evidence reveals a materially different
job or workflow. A feature or brand variation is insufficient.

Confidence: **high**.

## C07 — WholeJob House

### What the evidence supports

The pain is strong. Daminger's 70-interview study separates cognitive household
labor into anticipating needs, identifying options, deciding, and monitoring.
The USC Fair Play report found disproportionate planning burdens in a sample of
more than 500 primarily maternal participants. It also found that only 26% of
invited participants completed the entire intervention, which is direct warning
evidence for adoption and burden.

The market proves interest in gamified household coordination. Tody, Nipto, and
Sweepy use mascots, points, leaderboards, streaks, rewards, and family sync.
Tody lists premium from $9.99 per year. This demonstrates available products and
pricing, not a causal product effect or strong willingness to pay.

### Strongest failure case

[FairPlay](https://fairplaycouple.app/) is closer than generic chore apps. It
turns chores and mental load into two-person cards, counts Do/Think/Plan work,
shows a live partner balance, and prompts a weekly check-in. It lists $49.99 per
year and $6.99 per week.

The deeper failure is behavioral: an app cannot create a willing partner. MIT
Technology Review's reported interviews show how a coordination tool can add
administration to the already-overloaded person. A cute virtual house may hide
the same failure behind charm. If bricks are earned by completed tasks, users
can split work into microtasks, optimize points, and argue about measurement
while anticipation and monitoring remain invisible.

### Defensible pivot

The virtual house can improve the concept only under a strict rule:

> The house grows when a partner closes an agreed responsibility from
> anticipation through monitoring, not when either partner logs more chores.

The house is shared, cooperative, and finite. It has no individual score,
leaderboard, loss aversion, punishment, or streak reset. A partner cannot assign
another person work; each person claims an outcome. The product shows whether a
responsibility is unowned, owned, blocked, or complete. It does not judge the
quality of a relationship.

Shareability should borrow mechanisms, not appearances:

- Wordle demonstrates a compact, abstract result that can be shared after
  value is delivered.
- Spotify Wrapped demonstrates a finite personalized recap with explicit share
  cards.
- Strava demonstrates why sharing needs default and per-item privacy controls
  and why even redacted artifacts can leak context.

The default share card should say only that the shared house grew, perhaps with
a weekly room or object. It must omit task names, partner scores, locations,
children, health data, and household addresses. Sharing remains private by
default and uses the system share sheet.

### Technical, policy, and operational shape

- The hardest proof is two-sided voluntary adoption, not animation.
- Shared state requires conflict resolution, household departure, deletion,
  ownership transfer, and notification-disabled behavior.
- Free-form partner content can be UGC. Keeping the MVP to predefined states,
  user-owned responsibility names, and no chat reduces but does not erase the
  need for terms, reporting, blocking, and support analysis.
- OneSignal can be a coherent secondary only when a message opens an accepted
  responsibility or a requested check-in. The core must work when delivery is
  delayed or permissions are denied.
- Reduced motion, screen-reader labels, non-color state cues, large text, and
  no shame language are launch requirements.

### Monetization and award fit

Peace remains the primary award because the mechanism aims to redistribute
invisible responsibility. Design is coherent because the cooperative house is
the feedback system, not a decorative category feature. OneSignal is coherent
only if invitation and status-return messaging is useful and measured.

A household entitlement is more coherent than two subscriptions. A $14.99
yearly or $24.99 lifetime hypothesis is more plausible than charging for each
partner. Decorative houses alone do not establish recurring subscription value.

### Pre-mortem

One partner sets up every responsibility and sends every reminder. The other
opens the app only to avoid conflict. Users optimize bricks by logging small
chores. The weekly recap becomes evidence in an argument. The public card leaks
private household information. Sync conflicts assign the same responsibility
twice. The house is memorable, but the product reinforces the status quo.

### Top assumptions

1. Both partners agree that lifecycle ownership describes their problem.
2. The less-engaged partner will claim work without being assigned.
3. A cooperative house motivates without scorekeeping.
4. Two minutes of setup is enough to define an outcome and “done.”
5. At least some households will pay for shared history and private recaps.

### Recommendation

**Pivot.** Advance only as WholeJob House: no points, leaderboard, task-volume
reward, public-by-default share, or partner performance score. Kill if both
partners in fewer than three of five households voluntarily use it, or if the
initially overloaded partner creates more than 60% of responsibilities and
reminders.

Confidence: **medium-high** for the problem; **medium-low** for the product
mechanism.

## C12 — Coverage Gap

### What the evidence supports

Caregivers need concrete help rather than vague offers. The product job is real:
post a meal, ride, appointment, visit, or shift and obtain a visible commitment.

### Strongest failure case

[ianacare](https://ianacare.com/caregivers/) already coordinates appointments,
meals, rides, care shifts, communication, delegation, and team support. Its
Caregiver Organizer is free. [Lotsa Helping Hands](https://lotsahelpinghands.com/how-it-works)
already lets a care team post specific requests, obtain volunteer commitments,
send reminders, and add multiple coordinators for free.

The proposed “coverage” language creates an additional safety problem. Firebase
states that normal-priority background delivery may be delayed and that Apple
platforms do not guarantee background notification delivery. FCM is not
designed for life-critical uses. The app therefore cannot infer help from a sent
notification. It needs explicit accepted, declined, expired, and fallback
states, and the requester still needs a non-app escalation path.

### Data, policy, and operations

A bounded logistical request can avoid diagnosis and treatment, but caregiving
context can still reveal health, location, schedule, family, and vulnerability.
One-to-one and group content implicates privacy, UGC safeguards, account
recovery, member removal, abuse reporting, blocking, data deletion, and support.
The app must function with notifications off and must never describe an
unacknowledged request as covered.

### Monetization and award fit

Peace and OneSignal are natural at the mechanism level, but the product value is
already free elsewhere. ianacare's employer and health-plan model also suggests
that professional navigation and institutional distribution—not a small
consumer coordination feature—may be the paid layer. That route is too large for
the remaining schedule.

### Pre-mortem

Caregivers re-enter the same requests that already exist in a free app. Helpers
do not install another tool. A late notification creates false reassurance. The
requester becomes the coordinator again. Sensitive details appear in a lock
screen notification. Support and recovery consume the solo builder.

### Top assumptions

1. A precise coverage-certainty failure remains after ianacare and Lotsa.
2. Helpers accept without installing or learning a new app.
3. The flow is safe when every push message is missed.
4. Consumer caregivers will pay for the narrow coordination layer.

### Recommendation

**Kill.** Reopen only with evidence from a tightly defined caregiver segment
showing an unsolved coverage-certainty failure and a safe fallback independent
of push delivery.

Confidence: **high**.

## R1 — Restart Thread, combining C13, C14, and C15

### Combination decision

C13 and C14 should combine. They serve the same person, moment, and outcome:

1. A task or project loses momentum.
2. The user preserves or reconstructs the current state.
3. The product surfaces one feasible next action.
4. The user starts without rebuilding a whole plan.

C15 can attach to that state, but it is not coequal. The user may invite a
trusted person to start the exact action together. If unavailable, the core must
still work. Stranger matching, public profiles, chat, video, and open-ended
social feeds are excluded.

This creates one product thesis rather than three stacked tools: **preserve the
thread, recover one start, and optionally ask a known person to witness that
start.**

### What the evidence supports

The interruption mechanism is credible. Altmann and Trafton's laboratory study
found that resumption lag was about twice the interval between uninterrupted
actions and that cues available before interruption improved later resumption
under some conditions. This supports a cue mechanism, not the efficacy of this
mobile concept.

The ADHD evidence supports the problem but remains preliminary. A 2026 preprint
reports 22 interviews and a 20-person concept speed-date in which task
management was relational and emotional. A separate 2026 roadmap identifies
task initiation, accountability, structure, motivation, and emotion regulation
as reported body-doubling motives while emphasizing limited empirical efficacy
research.

### Strongest failure case

The start and body-doubling market is crowded. Focusmate has scheduled matched
video sessions and reports more than 12 million sessions. One current Just Start
product combines AI micro-steps, an adaptive timer, an AI body double, a focus
garden, XP, streaks, widgets, and subscription or lifetime pricing. A separate
same-name App Store product offers task breakdown, body doubling, a next-step
widget, and forgiving streaks.

This kills “gentle ADHD start app,” “AI microsteps,” “body doubling,” “focus
garden,” and “forgiving streaks” as differentiators. The surviving wedge is
context restoration: what state was I in, which artifact matters, what remains
unresolved, and what is the smallest truthful restart?

The core also fails if users do not leave a breadcrumb. Many interruptions are
unplanned, and a capture ritual can become another obligation. The product must
allow both pre-interruption capture and post-return reconstruction.

### C15 social-layer risk

Social support has plausible value but multiplies operational scope:

- Two people must be available at the same time.
- A recipient may feel pressured by a task invitation.
- One-to-one content may require reporting, blocking, terms, moderation, and
  support under store UGC policies.
- Notifications may be delayed or denied.
- An unanswered invitation can intensify shame at the worst moment.

The cheapest safe test is a system share sheet with predetermined language and
accept, decline, and mute states. No account, chat, stranger discovery, or
public content is necessary. The social test advances only if it materially
improves the restart behavior.

### Technical and platform shape

The C13+C14 core can be local-first and deterministic. It needs a share target,
quick capture, home-screen widget, deep links, process-death recovery, offline
durability, a stale-breadcrumb state, and accessible motion and feedback. No AI
or backend is required for the launch proof.

Android and Galaxy leverage is natural when the capture and return loop improves
through share targets, widgets, resizable windows, multi-window, foldable
continuity, and notification deep links. Galaxy remains a secondary award,
conditional on physical Samsung testing, a polished Galaxy Store listing, and a
working RevenueCat purchase path. A decorative Samsung-only feature is rejected.

### Monetization and award fit

Design is the primary award: the differentiator is an interaction that turns a
fragmented state into one low-load restart. Galaxy is a coherent secondary when
adaptive and quick-entry behavior improves the same loop. OneSignal is coherent
only if a return cue deep-links to the correct breadcrumb and improves measured
restart without fatigue.

The free value should include local capture and a small number of active
threads. Paid value could include unlimited history, cross-device sync, custom
return cues, and private export. A lifetime purchase may fit better than a
subscription until continuing server or cross-device value exists.

### Pre-mortem

Users install the app but forget to leave breadcrumbs. The three reset questions
feel like another planner. A reminder arrives at a bad time and is ignored. The
trusted person is unavailable, making the user feel worse. The product drifts
into AI planning and duplicates Just Start. Widget and process-death bugs lose
the one record users needed to trust.

### Top assumptions

1. The target problem is loss of task state, not merely lack of motivation.
2. Users can create a useful breadcrumb in 30 seconds or less.
3. A breadcrumb reduces measured time to the first meaningful action.
4. Return cues help without becoming notification noise.
5. Known-person support is optional and incrementally useful.

### Recommendation

**Pivot and recommend at the gate.** Advance the C13+C14 core as Restart Thread.
Defer C15 from the MVP. Test it only through the bounded system-share prototype.
Kill the social layer if fewer than three of five target users request it or
fewer than 60% of recipient trials accept within 15 minutes. Kill the core if
fewer than 50% of 20 real breadcrumbs produce a first action within two minutes
of return.

Confidence: **medium-high** that C13+C14 is coherent and buildable; **medium**
that users will create breadcrumbs; **low** that C15 belongs in launch scope.

## C18 — Pattern Without Pressure

### What the evidence supports

People with variable capacity want to understand what activities precede
better or worse after-effects without being told what they “should” be able to
do. A paired activity and after-effect log is technically simple and can avoid
diagnosis or treatment claims.

### Strongest failure case

The value is already commoditized. Bearable offers customizable health tracking,
correlations, reports, and experiments. Guava offers free tracking, records,
device and portal sync, trends, and correlations; it correctly warns that
correlation is not causation. Daylio offers two-tap activity and mood logging,
correlations, goals, achievements, and shareable yearly views. Visible combines
a wearable with pacing, alerts, activity impact, and symptom trends.

“Smaller and calmer” is a design treatment, not automatically a product gap.
C18 retains the hard parts: logging burden, self-observation effects, sparse
data, confounding, false causal interpretation, health privacy, sensitive data,
and subscription resistance. It removes the richer integrations and reports
that users can already obtain free.

### Policy and operational burden

Google's health policy requires a health declaration, privacy policy, data
minimization, and non-misleading functionality. The FTC's amended Health Breach
Notification Rule expressly reaches many non-HIPAA consumer health apps that
can draw identifiable health information from multiple sources. Unauthorized
disclosure can trigger notification obligations. HIPAA is not a general safe
harbor for a direct-to-consumer app.

A local-only, single-source MVP could reduce exposure, but a RevenueCat product
still needs store disclosures, deletion design, secure backups if offered, and
careful claims. Connecting wearables or cloud sync materially increases the
legal and operational analysis.

### Monetization and award fit

Design and Peace are coherent in theory, but the paid boundary is weak. Rich
free alternatives already provide trends and correlations. Charging for history
or insights may place the paywall between a chronically ill user and their own
data. Ads are rejected in this sensitive context.

### Pre-mortem

Users stop logging after three days. Sparse associations look meaningful and
change behavior inappropriately. The disclaimers are technically present but
the visual design implies causality. A sync or analytics SDK creates a health
privacy obligation the solo builder cannot support. The app is praised for calm
design but not used or purchased.

### Top assumptions

1. A specific segment wants less data rather than better interpretation.
2. Paired logging produces enough observations to be useful.
3. Users understand associations without causal inference.
4. A paid boundary exists despite strong free competitors.
5. A solo builder can support sensitive data responsibly after the event.

### Recommendation

**Kill.** Reopen only after segment co-design identifies a missing product value
rather than a missing feature, and a qualified health/privacy review approves
the claims, data model, and controls.

Confidence: **high**.

## C21 — Project Thread

### What the evidence supports

Context loss after interruption is real, and project artifacts can act as cues.
The core can be local-first, deterministic, accessible, and technically modest.
It also fits the Next Gen requirement for a clear, useful, inspectable student
project.

### Strongest failure case

Existing tools preserve much more context. Pieces Long-Term Memory automatically
captures clipboard, screen, audio, and application activity and makes it
searchable. GitHub Copilot Spaces stores repositories, issues, notes, images,
and files as persistent project context. Copilot Memory stores cited repository
facts and preferences. Obsidian and ordinary notes already support a manual
“state / next / blocker” template.

C21's lighter manual checkpoint could be safer and more understandable, but the
target “long-horizon learners” is broad. Returns may be too infrequent to create
retention or subscription value. A mobile app also cannot automatically capture
desktop state without permissions and architecture that would erase its scope
advantage.

### Defensible pivot

Target one artifact-heavy learning project and one return card:

- linked artifact;
- current state;
- unresolved question;
- first restart action.

Do not add a knowledge graph, AI summary, curriculum, spaced repetition, or
automatic desktop capture. The product survives only if it reduces measured
resumption time more than a normal note.

### Monetization and award fit

Next Gen remains the primary award because clarity, visible core functionality,
technical choices, and presentation are stronger than the commercial thesis.
Design and OneSignal remain coherent only when the checkpoint interaction and
return deep link serve the same loop. A $19.99 lifetime unlock is more plausible
than a subscription until recurring cross-device value is measured.

### Pre-mortem

Users save checkpoints only during the study. The project gap is monthly, so the
app has no habit. A note template works as well. External files move and links
break. Users ask for automatic desktop capture, sync, AI search, and knowledge
graphs, turning the five-week app into Pieces. No acquisition channel emerges.

### Top assumptions

1. Learners resume often enough to form a measurable problem.
2. Reconstruction consumes more than 15 minutes.
3. A four-field checkpoint beats a normal note.
4. Users remember to create checkpoints without study prompts.
5. A lifetime or cross-device paid boundary exists.

### Recommendation

**Pivot, but hold behind Restart Thread and WholeJob House.** Kill or merge the
mechanism unless four of five learners return at least monthly, median
reconstruction exceeds 15 minutes, and the prototype reduces resumption time by
30%.

Confidence: **medium**.

## Cross-concept platform and policy findings

### Notifications are cues, not guarantees

FCM attempts high-priority delivery and may delay normal-priority background
messages. Apple background delivery is not guaranteed. Every concept must show
the authoritative state in the app and remain useful with notifications denied.
This is especially important for caregiver coverage and social start requests.

### One-to-one content is not operationally free

Google Play's UGC policy requires reasonable ongoing moderation and reporting,
and one-to-one interactions require blocking. Apple's UGC rules likewise
require safeguards against abuse. “Only invited partners” reduces the risk but
does not automatically remove the obligation. Predefined invitations, no chat,
system sharing, mute, block, report, and account removal keep the first version
bounded.

### Accessibility, child safety, and IP stay inside launch scope

The selected audiences are adults. None of the concepts should enter a Kids or
Families category, solicit child accounts, or use children as a growth channel.
If a household or caregiver product later permits a minor to participate, that
is a new policy and privacy decision rather than a settings toggle.

Every surviving prototype must support screen-reader labels, non-color state
cues, large text, visible focus, reduced motion, plain-language errors, and a
complete notification-denied path. These are part of the tested core flow.

Product data and inspiration do not create a license to redistribute content.
C04 may process only permission-cleared client material. C21 links to a user's
artifact but should not republish copyrighted course or project content. C07
must use original or properly licensed house art, sound, iconography, and motion.
Wordle, Wrapped, and Strava inform abstract mechanisms only; their brands,
layouts, copy, icons, maps, and visual trade dress are not design assets.

### Health data remains sensitive outside HIPAA

Direct-to-consumer health apps are often not HIPAA covered, but the FTC Act,
Health Breach Notification Rule, state law, Apple review rules, and Google Play
health and user-data policies may still apply. “Not medical advice” does not
replace reasonable security, accurate claims, minimization, disclosure, and
breach response.

### Subscriptions need recurring product value

Apple requires ongoing subscription value, and Google requires sustained or
recurring value. Intermittent project recovery or a one-time household setup may
fit a lifetime purchase better than a subscription. Sync, shared history,
continually improving services, and ongoing content can support recurring value
only when they are part of the product—not paywall decoration.

### The deadline rewards fewer touchpoints

As of August 10, 2026, roughly seven weeks remain before September 30. The
lower-risk architecture is local-first Android, one core state machine, bounded
RevenueCat entitlements, analytics for the value event, and only the native
bridges required by the selected loop. iOS/iPadOS follows after the Android core
is stable. A compatible Apple-silicon Mac build remains secondary and is not a
native macOS promise.

## Validation sequence and budget

The four pivot candidates have explicit interview, prototype, message,
technical, pricing, and behavior tests in
[`validation-plans.md`](./validation-plans.md). The recommended sequence is:

1. Spend three days on Restart Thread interviews and a clickable prototype.
2. If it clears the problem and task thresholds, run its Android durability
   spike and seven-day behavioral pilot.
3. In parallel with participant scheduling—but not product implementation—run
   WholeJob House paired interviews.
4. Run C04 only if five qualified freelancers are already reachable. Stop after
   the substitute comparison if the narrow need does not emerge.
5. Run C21 only if recruiting reveals a distinct long-horizon learner segment
   that is not simply the Restart Thread audience.

Use existing credits and free tiers for prototypes and landing pages. Model cost
is not a reason to choose C04; a source-linked accuracy test is. Do not buy
content, data, health expertise, or moderation capacity before a concept clears
its earlier kill thresholds.

## Evidence and uncertainty ledger

The full 47-record ledger appears in
[`source-ledger.csv`](./source-ledger.csv). Material claims retain source date,
tier, current status, claim type, confidence, and fallback notes.

| Area | Evidence status | Confidence | Uncertainty |
|---|---|---|---|
| C04 substitute density | Direct current product and pricing pages | High | Paid adoption, retention, legal effect, and the size of the correction-first niche |
| C05 duplication | Direct current VocalJet product page | High | Whether a different persona has an unresearched job |
| C07 problem mechanism | Qualitative research, intervention report, reported interviews, current competitors | High for pain; medium-low for app effect | Voluntary two-person adoption, conflict effects, and willingness to pay |
| C12 substitute and delivery risk | Direct competitor pages and official messaging docs | High | Whether a narrow coverage-certainty case remains |
| Restart Thread mechanism | Laboratory interruption study, recent ADHD preprints, current competitors | Medium | Real breadcrumb capture compliance and behavioral benefit |
| C18 substitute and policy burden | Current product pages and primary platform/federal policy | High | Whether a co-designed niche values restraint enough to switch or pay |
| C21 context tools | Official current product documentation and interruption research | Medium-high for alternatives | Segment frequency, acquisition, and measured superiority to notes |
| AI unit cost | Current official pricing and transcription documentation | High for observed price | Accuracy, retries, total infrastructure cost, and future price changes |
| Store policy | Current official Apple and Google policy pages | High | Review interpretation for a specific final implementation |

## Contradictions and missing evidence

- No target-user interview, usability observation, payment choice, landing-page
  test, or behavioral pilot has been performed for any selected concept.
- Two separate products use the “Just Start” or “JustStart” name. Their sellers,
  features, and prices differ. They are treated as two competitors, not one
  verified product identity.
- Competitor prices show offers, not revenue, conversion, or willingness to pay.
- ClarAccord's binding, UETA, security, and loss-savings claims are vendor claims
  and are not accepted as legal or measured facts.
- The Fair Play intervention report has partnership context and substantial
  attrition; completion associations do not prove that a mobile app causes
  relationship or health improvements.
- Focusmate session counts, Daylio users, Tody users, Visible members, and
  product-reported outcomes are vendor metrics with incomplete provenance.
- Recent ADHD studies are preprints. They support design questions, not product
  efficacy or medical claims.
- The interruption-cue experiment supports a mechanism in a laboratory task;
  it does not establish a mobile-product effect or an ADHD-specific effect.
- Google and Apple policy interpretation depends on the final data flow,
  audience, permissions, and social features. This report is not legal advice.
- The builder has not confirmed a physical Galaxy device, Samsung Seller
  account, or active Apple and Google developer accounts.
- The Capacitor-to-Galaxy RevenueCat purchase path remains a required technical
  spike inherited from Run 5.
- No selected concept has demonstrated a natural paid boundary through observed
  purchase behavior.

## Recommendation

Select the **Restart Thread pivot** for the next proof sprint, with these fixed
boundaries:

- C13+C14 is the product: preserve context, recover one feasible start.
- C15 is not part of the MVP. Test one known-person, no-account invitation only
  after the core prototype.
- No AI planner, stranger matching, chat, video, streak punishment, clinical
  claim, or general task manager.
- Android is first. The core is local-first and works offline with notifications
  denied.
- Design is the primary award. Galaxy and OneSignal are conditional secondaries
  only when their work improves and measures the same restart loop.

WholeJob House is the best alternative if the user prefers a relational product
and can recruit both partners in five households immediately. It has more
distinctive visual potential, but also a materially harder two-person adoption
proof and a closer mental-load competitor than Run 5 indicated.

## Decision gate

Choose one option. Run 7 must not begin until this gate is resolved.

- **Option A — select the recommended pivot:** Restart Thread, with C13+C14 in
  the MVP and C15 tested separately.
- **Option B — pivot the household concept:** WholeJob House, with cooperative
  full-lifecycle progress, no scores or leaderboards, and private-by-default
  recap cards.
- **Option C — return to Run 5:** reject the surviving set and generate a new
  concept portfolio from the accepted problem evidence.

C04 and C21 remain available as one-week proof sprints, but neither is
recommended over Options A or B. C05, C12, and C18 are rejected for the reasons
above.

## Updated research state

```yaml
RESEARCH_STATE:
  completed_run: 6
  rules_version_observed: "Live Devpost rules and official award inventory carried forward through August 10, 2026. Treat August 1, 2026 as the official planning and release start. Galaxy optimization supplies 20% of the otherwise applicable standard score."
  builder_constraints:
    team_and_skills: "Solo developer who can own development and marketing; AI-assisted implementation is acceptable."
    available_hours: "No fixed weekly cap. Use realistic task estimates including debugging, store review, testing, and rework."
    budget: "Prefer free tiers, hackathon credits, and existing subscriptions."
    eligible_platforms: "Android first on Windows; iOS and iPadOS second through MacinCloud; compatible Apple-silicon Mac build only after testing."
    developer_accounts: "One planned Apple Developer account and one planned Google Play account; activation not confirmed. Samsung Seller account and physical Galaxy hardware not confirmed."
    student_status: "Eligible student with a qualifying academic email."
    sponsor_employee_status: "No sponsor employment or conflict reported."
    geography_and_store_access: "United States; app may be distributed in the United States."
    backend_and_ai_tolerance: "Open to backend and AI, but prefer fewer architectural touchpoints. Available providers include CockroachDB, MongoDB, QwenCloud, OpenRouter, OpenAI, and Ollama cloud models."
    regulated_or_sensitive_domains_to_avoid: "No categorical exclusion. Medical requires compliance; legal and financial require stronger security, performance, review, and claims discipline."
  selected_primary_award:
  allowed_secondary_awards: []
  shortlisted_award_families:
    - "Growth and monetization"
    - "Design and native craft"
    - "Build in public and distribution"
    - "Impact, trust, and accessibility"
    - "Cross-platform, retention, and game execution"
  selected_opportunity_territories:
    - "T2 capture-to-usable-artifact workflows for solo work"
    - "T3 small-group utility with recipient-side value"
    - "T4 adaptive cross-device field workflows"
    - "T5 respectful return loops for intermittent goals"
  selected_problems:
    - "T2-S1 independent property inspectors"
    - "T2-S2 solo client-service professionals"
    - "T3-S1 dual-income households"
    - "T3-S2 distributed family caregivers"
    - "T5-S1 adults with ADHD or time blindness"
    - "T5-S2 adults managing chronic illness and variable capacity"
    - "T5-S3 long-horizon learners after interruption"
  selected_platform_hypothesis: "H2A Android-first shared core: bounded native Android bridges, iOS/iPadOS second, and compatible Apple-silicon Mac execution; no native Mac promise."
  run_6_concepts_tested:
    - "C04 ScopeSignal"
    - "C05 BriefBack"
    - "C07 WholeJob House"
    - "C12 Coverage Gap"
    - "R1 Restart Thread combining C13+C14 with C15 tested separately"
    - "C18 Pattern Without Pressure"
    - "C21 Project Thread"
  surviving_pivots:
    - "R1 Restart Thread: C13+C14 core; C15 deferred from MVP"
    - "C07 WholeJob House: cooperative lifecycle ownership; no individual scoring"
    - "C21 Project Thread: one artifact-linked learner checkpoint; must beat notes"
    - "C04 ScopeSignal: narrow correction-first scope delta; one-week proof only"
  killed_concepts:
    - "C05 BriefBack: VocalJet is an exact job-and-loop substitute."
    - "C12 Coverage Gap: free close substitutes, notification limits, privacy burden, and weak paid fit."
    - "C18 Pattern Without Pressure: mature free substitutes plus health-policy and interpretation risk."
  recommended_concept_at_gate: "R1 Restart Thread"
  selected_concept:
  selected_ux_direction:
  selected_visual_direction:
  rejected_directions:
    - "Generic AI transcription, meeting-note, or voice-to-writing app."
    - "C05 BriefBack without a newly evidenced persona and job distinct from VocalJet."
    - "C12 Coverage Gap without a safe no-notification fallback and a gap not addressed by ianacare or Lotsa Helping Hands."
    - "C18 Pattern Without Pressure without co-designed product value and qualified health/privacy review."
    - "Treating competitor pricing or vendor metrics as measured willingness to pay, retention, efficacy, or prevalence."
    - "Live-call recording or legal-effect claims in the C04 MVP."
    - "Chore points, individual leaderboards, partner performance scores, streak punishment, or task-volume rewards in C07."
    - "Public-by-default household share cards or cards containing tasks, scores, locations, children, health details, or addresses."
    - "Stranger matching, chat, video, public profiles, or an open social feed in C15."
    - "Treating a sent notification as accepted caregiver coverage."
    - "AI planning, automatic desktop surveillance, or a general knowledge graph in Restart Thread or C21."
    - "Subscriptions without sustained or recurring product value."
    - "Health correlations presented as causes, diagnoses, treatment advice, or safe activity thresholds."
  accepted_evidence:
    - "Run 6 source ledger contains 47 records spanning official platform policy, federal health privacy guidance, technical documentation, research, current competitors, prices, and shareable-loop precedents."
    - "ClarAccord is a near-exact current substitute for the original ScopeSignal loop."
    - "VocalJet is an exact current substitute for BriefBack."
    - "FairPlay, Tody, Nipto, and Sweepy substantially cover gamified household and mental-load coordination."
    - "ianacare and Lotsa Helping Hands already provide free caregiver requests and volunteer commitments."
    - "FCM and APNs delivery cannot be treated as guaranteed coverage."
    - "Two distinct Just Start products and Focusmate materially crowd generic start, body-doubling, garden, streak, timer, and micro-step concepts."
    - "The C13+C14 context-restoration loop remains more differentiated than generic starting support."
    - "Bearable, Guava, Daylio, and Visible substantially cover low-friction health logging, patterns, and correlations."
    - "Pieces and GitHub already provide rich project-context and memory alternatives."
    - "Wordle, Spotify Wrapped, and Strava support an inferred share-design pattern: compact artifact, finite recap, explicit sharing, and privacy controls."
    - "OpenAI's observed batch transcription price makes model cost manageable for bounded audio, but does not establish accuracy, latency, privacy compliance, or product differentiation."
    - "No concept passed unconditionally because primary behavioral and payment evidence is absent."
  unresolved_questions:
    - "Which Run 6 gate option will the builder select?"
    - "Will five reachable target users complete interviews and prototype tests within the next week?"
    - "Will at least half of real Restart Thread breadcrumbs lead to a first action within two minutes?"
    - "Will users create breadcrumbs without study reminders?"
    - "Does the C15 known-person invitation improve restart behavior enough to justify moderation and two-person activation?"
    - "Will both partners in at least three of five households voluntarily use WholeJob House without the overloaded partner administering it?"
    - "Can C04 identify a correction-first niche that rejects ClarAccord and ThreadRecap for the same unmet reason?"
    - "Can C21 reduce measured learner resumption time by at least 30% compared with ordinary notes?"
    - "Is a physical Galaxy device and Samsung Seller account available?"
    - "Does the selected stack support a complete RevenueCat Galaxy purchase flow?"
    - "When will the planned Apple and Google developer accounts be active?"
  next_decision: "Choose Option A Restart Thread, Option B WholeJob House, or Option C return to Run 5."
```
