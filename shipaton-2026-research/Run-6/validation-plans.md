# Run 6 validation plans

These tests are designed to falsify the four pivot candidates before production
work begins. Restart Thread has the best information-to-cost ratio. WholeJob
House is the strongest alternative, but it requires both partners to adopt.
ScopeSignal and Project Thread should run only as short proof sprints because
their substitute risk is already high.

No result below has been run. Every target is a prospective threshold, not a
reported outcome.

## Test-order rule

Run the tests in the following order and stop when a kill threshold is met.

1. Conduct the five interviews.
2. Test the clickable prototype with the same target segment.
3. Run the technical spike before adding production architecture.
4. Ask the pricing question only after the participant experiences the value.
5. Run the message test and small behavioral pilot.

An interview cannot validate behavior. A stated willingness to pay cannot
validate a purchase. A landing-page email cannot validate retention.

## R1 — Restart Thread

Restart Thread combines C13 and C14: preserve the state of an interrupted task,
return to that state later, and choose one feasible restart. C15 remains a
separate, optional trusted-person test. The launch concept does not include
stranger matching, chat, video, or AI task generation.

### Five interviews

Recruit five adults who self-identify as having ADHD, time blindness, or a
recurring difficulty restarting interrupted tasks. Do not recruit through a
medical-treatment claim. Each participant must have experienced at least two
unfinished personal, study, or work projects in the previous month.

Ask for the most recent interruption rather than opinions about the concept:

- What were you doing immediately before the interruption?
- What information had to be reconstructed when you returned?
- What did you leave behind: an open tab, note, message, screenshot, or nothing?
- How long did it take to perform the first meaningful action after returning?
- What made an existing planner, timer, or note fail in that moment?
- When would another person's presence help, and when would it create pressure?

Pass the problem interview if at least four of five participants describe two or
more restart failures per week, at least three lose task state despite a current
workaround, and at least three rank context recovery above a generic timer or
AI-generated task list. Kill the standalone concept if two or fewer have a
recurring restart problem.

### Clickable-prototype task set

Give each participant a realistic multi-artifact task. Interrupt them after a
decision has been made but before the next action. Test these flows:

1. Capture a breadcrumb containing the current state, the next physical action,
   and one linked artifact.
2. Close the prototype and complete an unrelated distractor task.
3. Reopen from a widget or notification.
4. Confirm or revise the saved next action.
5. Start the action without navigating through a project dashboard.
6. Recover from an empty breadcrumb, a missing artifact, and a stale next step.

Pass if four of five create a usable breadcrumb without help in 30 seconds or
less, four of five reach the correct artifact and first action within 60 seconds
of return, and the median capture-effort rating is 2 or lower on a 5-point
scale. Pivot the fields if users consistently omit the information they later
need. Kill if fewer than three can resume correctly.

### Landing-page or message test

Test two concrete promises with the same Android-first product demonstration:

- A: “Pick up an interrupted task without reconstructing everything.”
- B: “When a plan collapses, recover the thread and start one feasible step.”

Use a qualified audience source and record the source separately. Do not mix a
broad productivity audience with ADHD communities in one denominator. After at
least 100 qualified visits per message, continue only if one message produces a
waitlist conversion of at least 12% and at least five interview bookings. Treat
fewer than 100 visits as inconclusive rather than negative.

### Technical spike

Build only the Android share target, local breadcrumb store, home-screen widget,
deep link, and process-death recovery. Test two physical Android devices, one
resizable window, TalkBack, 200% font size, offline mode, and 50 forced process
terminations.

Pass if all 50 committed breadcrumbs survive, the local save acknowledgment is
under 500 milliseconds at the 95th percentile, the widget opens the correct
breadcrumb in under two seconds, and no core action requires network access.
Galaxy eligibility remains conditional on a physical Samsung test, foldable or
multi-window adaptation, and the separate RevenueCat Galaxy purchase spike.

### Pricing question

Ask only after the prototype task. Present the same product with these options:

- free: three active threads and local capture;
- $2.99 monthly or $24.99 yearly: unlimited threads, cross-device history, and
  configurable return cues;
- $29 lifetime: local-first unlimited use without sync.

Require a choice and the reason for it. Do not ask “would you pay?” in the
abstract. Continue subscription research only if at least two of five choose a
paid recurring option. Prefer a lifetime purchase if recurring value is not
clear; both Apple and Google require subscriptions to provide ongoing value.

### Behavioral success metric

Over seven days, collect at least 20 genuine interruption-and-return events
across the five participants. The primary metric is the proportion of saved
breadcrumbs that are reopened and followed by a first meaningful action within
two minutes.

- Pass: at least 50%.
- Pivot: 25% to 49%, with a clear, repeated failure that a smaller capture
  field or better return surface can address.
- Kill: below 25%, or participants create breadcrumbs only because the study
  reminds them.

### Separate C15 social-layer test

Use a system share sheet and a predetermined invitation. The recipient sees the
exact start action and can accept, decline, or mute the sender without creating
an account. There is no chat or public discovery.

Advance the layer only if at least three of five target users say they would use
known-person support at least monthly and at least 60% of ten recipient trials
accept the start within 15 minutes. Any need for stranger matching, open text,
or synchronous availability returns the layer to a later safety and moderation
review. Failure does not kill the C13+C14 core.

## C07 — WholeJob House

WholeJob House lets two partners claim a complete household responsibility.
The virtual house grows only when the responsibility reaches the agreed outcome
through anticipation, choice, execution, and monitoring. It never awards more
points for splitting one job into smaller tasks.

### Five household interviews

Recruit five cohabiting dual-income households. When possible, interview each
partner separately before a joint debrief so one partner does not define the
problem for both.

Reconstruct one recent responsibility such as groceries, pet care, a bill, or
an appointment. Ask who noticed it, explored options, decided, executed,
checked completion, reminded the other person, and repaired failure.

Pass if at least four households show a repeated anticipation or monitoring
imbalance and both partners in at least three households voluntarily want a
shared tool. Kill if the less-engaged partner sees the product as the other
partner's tracker or if the already-overloaded partner would have to set it up.

### Clickable-prototype task set

Test the following loop with both partners:

1. Agree on the outcome and the “done means” condition.
2. One partner claims the complete responsibility.
3. The owner records one decision or dependency without creating a checklist.
4. The owner closes the outcome and confirms monitoring or follow-up.
5. Both partners see one cooperative house change.
6. Generate a private weekly recap and an abstract share card.

Pass if both partners in four of five households understand the difference
between owning an outcome and completing a chore, setup takes two minutes or
less, and no more than one participant describes the house as a scorekeeping or
parenting device. Kill if the virtual reward causes partners to create trivial
tasks, compare scores, or hide work.

### Landing-page or message test

Compare these promises:

- A: “Share the whole responsibility, not another chore list.”
- B: “Build a home together every time one of you closes the whole loop.”

The page must show the lifecycle model and the cooperative house; otherwise the
test measures attraction to generic household gamification. After 100 qualified
household visits per message, continue if the page converts at least 10% to a
two-person waitlist and at least five households schedule interviews.

### Technical spike

Build invitation, shared responsibility state, offline edits, deterministic
merge rules, the house-state reducer, one animation, notification deep links,
and export of an abstract share card. Simulate conflicting offline edits and a
partner leaving the household.

Pass if 100 scripted edit conflicts lose no accepted ownership or completion
event, every notification opens the correct responsibility state, the core loop
works with notifications disabled, and the house animation remains smooth on a
midrange Android device with reduced-motion mode available.

### Pricing question

After the paired prototype, present a household entitlement rather than two
individual subscriptions:

- free: five active responsibilities and one house theme;
- $1.99 monthly or $14.99 yearly per household: unlimited responsibilities,
  history, additional houses, and private recap exports;
- $24.99 lifetime household purchase.

Continue a recurring plan only if at least two of five households choose it and
can name recurring value other than decorative assets. Otherwise use a one-time
purchase or a narrow free launch.

### Behavioral success metric

Run a seven-day paired pilot. The primary metric is the share of lifecycle
events initiated by the partner who previously did less anticipation and
monitoring, without an in-app or out-of-app reminder from the other partner.

- Pass: that partner initiates at least two real lifecycle events in at least
  three of five households, and the overloaded partner creates no more than 60%
  of all entries.
- Pivot: mutual use occurs but the lifecycle language is misunderstood.
- Kill: one partner becomes the system administrator or the product increases
  reminder and conflict behavior.

The share card stays private by default. Borrow Wordle's compact abstraction,
Wrapped's finite recap, and Strava's user-controlled redaction—not their public
comparison mechanics. Never include task names, partner scores, locations,
children, health details, or household addresses in the default card.

## C04 — ScopeSignal pivot proof

ScopeSignal should not proceed as a general scope receipt. The only remaining
wedge is a correction-first delta for a narrow freelancer category: show the
source excerpt, show exactly what changed from the accepted baseline, and let
the client correct the delta before confirmation. Do not record live calls or
make legal-effect claims in the test.

### Five interviews

Recruit five freelancers in one discipline who manage at least three active
clients and had a disputed or unpaid scope change in the last 90 days. Show the
ClarAccord and ThreadRecap workflows before asking what remains missing.

Pass only if at least four report losing two or more billable hours per month to
unconfirmed changes and at least three reject the substitutes for the same
source-linked, correction-first need. Kill if objections are cosmetic, price
only, or solved by a normal follow-up email.

### Clickable-prototype task set

The freelancer imports a message or voice note, verifies a three-field delta,
and sends it. The client opens without an account, checks the source excerpt,
corrects one deliberately wrong field, and confirms the corrected version.

Pass if four of five freelancers finish in 60 seconds, four of five client-side
participants finish in 45 seconds, all participants can find the source, and
fewer than 20% of material fields require correction in clean samples. Kill if
the client interprets the flow as a contract ambush or refuses the link.

### Landing-page or message test

Use one narrow audience and one concrete claim: “Confirm only what changed,
with the client's correction attached to the source.” Continue after 100
qualified visits only if at least 15% join the waitlist and at least five offer
a real anonymized sample.

### Technical spike

Test 20 permission-cleared text and recorded-message samples containing names,
amounts, dates, negation, and domain vocabulary. Preserve sentence-level source
links. Human confirmation is authoritative.

Pass if material-field precision reaches 90%, no invented amount or deadline
can be confirmed without an explicit warning, deletion removes source and
derived data, and a 10-minute recording costs less than $0.10 in model usage.
The verified draft should return in 15 seconds or less at the 95th percentile.
On timeout, outage, or low confidence, the flow must preserve the source and
offer a manual delta form rather than block the user or silently retry. Current
OpenAI pricing makes the cost target plausible; it does not establish accuracy,
latency, or privacy compliance.

### Pricing question

After the client-side test, force a choice between $9 monthly, $1 per confirmed
delta, or continuing with email. Continue only if three of five freelancers
choose a paid option and describe value before a dispute occurs.

### Behavioral success metric

Send 20 genuine, permission-cleared scope deltas. Pass if at least 40% are
correctly confirmed or corrected within 24 hours. Kill below 20%; the core loop
does not work if clients do not act.

## C21 — Project Thread pivot proof

Project Thread should target long-horizon learners returning to one artifact-
heavy project, not all knowledge work. It stores an artifact, the current state,
the unresolved question, and the first restart action. It does not automatically
capture the desktop or become a general notes app.

### Five interviews

Recruit five learners who have resumed a course, thesis, certification,
language project, or portfolio after a gap in the last 90 days. Ask them to
reconstruct the last return from actual artifacts.

Pass only if four of five return at least monthly, the median reconstruction
time exceeds 15 minutes, and four prefer an artifact-plus-question checkpoint
over a generic note. Otherwise merge the mechanism into Restart Thread or kill
the standalone audience.

### Clickable-prototype task set

Participants save a checkpoint from a browser or document share action, then
return after a distractor task and again after 72 hours. They must locate the
artifact, explain the unresolved question, and start the next action.

Pass if four of five create the checkpoint in 45 seconds, four resume in two
minutes, and the median measured resumption time is at least 30% lower than
their normal baseline. Kill if participants need a project hierarchy, knowledge
graph, or automatic capture to make the card useful.

### Landing-page or message test

Test “Resume the project without rereading everything” against “Save the exact
question your future self must answer.” Continue after 100 qualified learner
visits per variant only if one converts at least 10% and yields five interviews
with real dormant projects.

### Technical spike

Build Android share intake for a URL, file, selected text, and screenshot; local
checkpoint search; offline durability; a return deep link; and export. Pass if
all supported artifacts remain resolvable after 50 process terminations and the
app gives an explicit recovery state when an external file has moved.

### Pricing question

Present free three-project use, a $19.99 lifetime unlock, and a $2.99 monthly
cross-device tier. Continue only if two of five select a paid option after the
prototype and can name recurring cross-device value. A one-time purchase is the
default hypothesis because project return may be intermittent.

### Behavioral success metric

Across at least 20 real returns, compare checkpoint-assisted resumption time
with the participant's own unassisted baseline. Pass at a 30% median reduction.
Kill or merge below 15% or if checkpoints are not created without study prompts.

## Killed concepts and reopening conditions

C05 BriefBack, C12 Coverage Gap, and C18 Pattern Without Pressure receive no
build validation plan in this run. They can reopen only with materially new
evidence:

- C05 requires a different job or persona that VocalJet does not already serve.
- C12 requires a documented coverage-certainty failure that free caregiver
  coordinators cannot address and a safe no-notification fallback.
- C18 requires segment co-design showing a missing product value—not merely a
  smaller feature set—and a qualified health/privacy review.
