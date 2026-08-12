# Five-participant formative study protocol

This protocol tests whether Restart Thread is understandable, fast, recoverable,
and trustworthy for its target segment. It does not test medical efficacy and
must not recruit or brief participants as patients.

## Participants

Recruit five US adults who self-identify with ADHD, time blindness,
interruption sensitivity, or recurring trouble restarting work. A diagnosis is
not required. Each participant must recall at least two unfinished personal,
study, or work tasks in the previous month.

Preserve the Run 7 variation goals: at least three primary Android users, one
Galaxy user when available, and two participants who normally use a relevant
accessibility setting or can complete an additional accessibility-condition
pass. Record the recruitment source and do not merge rates from broad
productivity traffic with ADHD-community recruitment.

## Research setup and consent

Use a functional Android build for recording, local durability, locked-entry,
purchase, restore, and adaptive-layout claims. A clickable prototype may cover
unfinished visual states, but its results cannot validate hardware or billing.

Use scripted, nonprivate task content. Obtain separate consent for session
audio, screen recording, and interaction logging. A participant may decline
any recording and continue with facilitator notes. State the retention and
deletion date before the session and keep research recordings outside product
analytics.

Prepare a multi-artifact task. The participant compares two subscription plans,
chooses the apparently cheaper option, and must still verify one cancellation
condition. Interrupt after the comparison but before verification. Use an
attention-demanding three-to-five-minute distractor and remove the prototype
from view.

## Session script

The accepted Run 7 session length is 60–75 minutes. Keep the moderator neutral:
do not name the correct control, sell the product, or rescue a participant until
the task's unassisted observation has ended.

### 1. Recent incident

Before showing the product, ask:

- What were you doing immediately before your most recent hard-to-resume
  interruption?
- What did you need to reconstruct later?
- What did you leave behind: tabs, notes, screenshots, messages, or nothing?
- What was the first meaningful action when you returned?
- What made the current workaround insufficient?

Record the stated frequency, workaround, approximate restart time, and the
participant's own language. Treat these as described evidence, not measured
prevalence.

### 2. Store-promise first action

Show the first three proposed store screenshots for ten seconds, then hide them.
Ask what the app does, when they would use it, and what they expect after the
first control.

Show the entry screen without instruction. Record the first control, time to
first action, wrong controls, hesitation, confidence from 1 to 5, and the reason
for the choice.

Pass when four of five describe capturing an interruption state by voice or
text and later checking one drafted first action. If two or more describe a
general task manager, autonomous planner, or treatment app, revise the promise
before visual polish.

### 3. Interruption capture

Interrupt the participant at the scripted point: “You need to stop now and
switch to something else. Use this phone if there is anything you want future
you to have.” Do not point to a widget or recorder.

For the general interaction pass, use the prepared quick surface on an unlocked
phone. On assigned physical-device passes, start from the actual locked state.
Time recording start from the instruction and time completion at durable local
commit, not cloud processing.

Observe recognition of **Record a thread**, recording feedback, stop behavior,
state/decision/source/blocker/next-move evidence, locked-surface privacy
expectation, text and Share alternatives, and comprehension that local save
precedes AI.

Record success, time, wrong action, error, hesitation, assistance, confidence,
capture-effort rating, and comprehension. Use the accepted voice-start,
durability, effort, and privacy thresholds in the validation plan.

### 4. Draft, evidence, and Start

Generate a predetermined draft through the production-shaped structured
contract. Across the five sessions, seed one missing fact, one low-confidence
segment, one unsupported assumption, one harmless extra step, and one negation.
Never expose a participant to a harmful reversed instruction.

After the distractor, show only the generic **Draft ready** state. Say: “Return
to the earlier task when you are ready.” Record the first control, scan sequence
as inferred from observable actions and think-aloud only, time to evidence, edit
or confirmation, Start time, errors, assistance, confidence, and comprehension.

Observe whether the participant distinguishes **You said**, **Start here**, and
AI inference; notices **AI draft—check before using**; opens **Why this?** when
uncertain; corrects the seeded issue; and understands that Start confirms one
action rather than every later suggestion.

Separately grade 30 factual statements from the five test drafts. At least 90%
must be supported by cited transcript segments, and any reversed negation is a
critical failure.

### 5. Recovery paths

Order-balance these conditions:

1. microphone denied;
2. offline after stop;
3. low-confidence transcript segment;
4. stale drafted action; and
5. missing original source.

Ask the participant to continue without changing the failed dependency. Record
whether text, Share, transcript edit, saved voice, or deterministic recovery is
found; whether the original state remains understandable; and whether the user
creates a concrete verb-led action.

### 6. Permissions and cloud consent

Show the in-app microphone explanation, system permission, and separate
local-versus-cloud processing choice. Alternate declines so every participant
uses an equivalent path after at least one denial.

Ask what is saved before AI, what leaves the device, what reaches the model,
how each artifact can be deleted, and how capture continues after declining.
Use the accepted all-five permission-comprehension threshold.

### 7. Optional reminder

Only after a verified restart, let the participant request one reminder. Show
the soft explanation and alternate denied and dismissed system outcomes. Ask
them to continue, find the saved thread without notifications, and locate the
later Settings route.

Record reminder-request comprehension, first action, permission result,
fallback success, deep-link expectation, and what notification text they think
will be visible. No participant should expect transcript or action text on the
notification.

### 8. Paywall, purchase, and restore

Use a state in which the participant has already received verified value and a
later cloud request reaches the configured free allowance. Keep their saved
thread visible and offer monthly and annual Pro, a clear free exit, and a
deterministic recovery option.

Give each participant one primary state while allowing all to inspect restore:

- dismiss and continue free;
- purchase cancelled;
- prior purchase restored;
- billing grace or retry; or
- expired entitlement.

Record price and term comprehension, first action, free-exit visibility, draft
preservation, restore discoverability, confidence, and beliefs about owned data.
Existing threads, local capture, deterministic recovery, deletion, and export
must remain available in every state.

### 9. Accessibility-condition pass

Rerun entry, capture, stop, local save, evidence, edit, Start, paywall exit, and
restore with 200% text, reduced motion, and narrow multi-window. Use TalkBack,
Switch Access or Voice Access, keyboard where applicable, magnification,
one-handed use, and color-correction or high-contrast settings across the study
and engineering pass.

Record names, roles, states, focus and traversal order, live announcements,
touch target access, clipping, horizontal reading pan, focus traps, and whether
the static Direct Trace-back Connector preserves meaning. Any task-blocking
defect is a release blocker.

## Task record

Create one record per participant and task with:

- participant and recruitment-source pseudonym;
- build, device, OS, posture, window state, and accessibility settings;
- task and starting state;
- first control and time to first action;
- completion and total time;
- wrong actions, errors, backtracks, hesitation, and assistance;
- confidence, comprehension response, capture effort, and SEQ;
- observed behavior, participant explanation, facilitator inference, and open
  cause as separate fields; and
- issue severity and the smallest proposed change.

Do not put audio, transcript, source, action text, diagnosis, contact data, or
payment data in the task record.

## Post-task questions

Ask after behavior has been observed:

- What felt like work that the app added?
- What information was missing when you returned?
- Where would speaking feel natural, unsafe, embarrassing, or inaccessible?
- Which part of the draft came from you, and which part did the app infer?
- What did you correct, and would typing one first step have been faster?
- What data would you delete first?
- What would make one reminder helpful versus annoying?
- What should never appear in notification text?
- What did you expect Pro to unlock?

Avoid “Would you use this?” and “Would you pay?” as evidence. Pricing evidence
comes from observed paywall behavior, actual transactions, and optional neutral
follow-up about the value the participant expected.

## Analysis and proof package

Reconstruct each path as:

`entry → capture → local save → transcription → draft or deterministic
recovery → evidence → confirm/edit → Start → source handoff → return →
purchase or reminder when applicable`.

Produce a measure table, issue log, first-action map, annotated path comparison,
grounding fixture results, accessibility defects, and release decisions. Label
behavior as observed, statements as described, telemetry as measured, and
facilitator conclusions as inferred.
