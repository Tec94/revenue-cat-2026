# Restart Thread usability-test plan

This plan now tests the recommended **Instant Voice Thread** hypothesis without
fabricating outcomes. Context + Voice is an alternate entry, and Voice Rescue
is the fallback. The controlling flow details are in
[voice-ai-revision.md](./voice-ai-revision.md). A successful prototype session
is necessary but not sufficient to validate locked capture, AI grounding, or
spontaneous real-world use.

## Research questions

1. Can the target user explain the product as context recovery rather than a
   general task manager, timer, or ADHD treatment?
2. Can the user start a prepared voice capture in five seconds or less, stop it,
   and trust the local save?
3. Does a short messy voice note contain enough evidence for later recovery?
4. Can the user identify what the AI inferred, inspect transcript evidence,
   correct the first action, and start within 60 seconds of opening the draft?
5. Can the user recover when transcription, AI, the network, the microphone,
   the Lock Screen host, or the source is unavailable?
6. Does just-in-time cue permission remain understandable and optional?
7. Can the user dismiss, buy, restore, cancel, or recover an expired
   entitlement without believing personal data is at risk?
8. Do large text, screen readers, switch access, speech differences, keyboard
   control, reduced motion, and one-handed use preserve an equivalent text or
   voice path?
9. Does AI reduce recovery effort after corrections, or would writing one next
   step have been faster?

## Participants

Recruit five US adults who self-identify as having ADHD, time blindness,
interruption sensitivity, or recurring trouble restarting work. A diagnosis is
not required and the study invitation must not promise treatment. Each
participant must have experienced at least two unfinished personal, study, or
work tasks in the previous month.

Aim for variation in work/study context and Android familiarity. Include:

- at least three people who use Android as a primary phone;
- at least one Samsung Galaxy user if available;
- at least two people who use large text, TalkBack, Voice Access, Switch Access,
  reduced motion, or another relevant accommodation, or who can run an
  additional accessibility-condition pass after the main task;
- no more than two participants recruited from the same community or creator
  audience.

Record recruitment source. Do not combine broad productivity traffic and
ADHD-community traffic in one rate.

## Prototype and setup

Use a functional Android voice spike for microphone and locked-state tasks plus
a clickable prototype for the rest. A visual simulation cannot validate
no-unlock microphone behavior. The prototype includes realistic back behavior,
voice/text choice, source chips, local save, transcription and AI states,
transcript evidence, widget/control simulation, notification rationale, error
states, and purchase states.

Prepare a realistic task with multiple artifacts. Example: compare two
subscription plans using a browser page and a small pricing sheet, decide which
looks cheaper, and verify one cancellation term. Interrupt the participant
after the comparison decision but before the verification action.

The distractor should last three to five minutes and require attention but not
special expertise. Do not let the participant keep the prototype visible.

Capture screen recording, test audio, timestamps, taps, wrong turns, assistance,
the final voice/text thread, AI output, corrections, and evidence coverage with
consent. Use scripted nonprivate task content in the prototype round. Store and
delete research recordings under a separate consent and retention plan.

## Session structure

Target 60 to 75 minutes per participant. If locked-device engineering tests are
run separately from moderated UX sessions, keep participant time near 60
minutes.

### 1. Recent-incident interview — 8 minutes

Ask about the most recent real interruption:

- What were you doing immediately before it?
- What did you need to reconstruct later?
- What did you leave behind: tabs, notes, screenshots, messages, or nothing?
- What was the first meaningful action when you returned?
- What made an existing task list, note, or timer insufficient?

Do not describe Restart Thread before this section. Record frequency, existing
workaround, approximate resumption time, and language the participant uses.

### 2. Store and first-launch comprehension — 5 minutes

Show the proposed first three store screenshots for no more than ten seconds,
then hide them.

Ask:

- What do you think the app does?
- When would you use it?
- What would you expect after tapping the first button?

Then show S01. Ask the participant to begin however they prefer.

Success threshold: four of five describe speaking or typing an interruption
state and later checking one drafted first action. They must call the output a
draft or suggestion, not a plan the app knows is correct. If two or more
describe a normal to-do list, autonomous AI planner, or treatment app, revise
the promise before styling.

### 3. Voice capture under interruption — 10 minutes

The participant starts the multi-artifact task. Interrupt them at the scripted
point: “You need to stop now and switch to something else. Use this phone if
there is anything you want future you to have.”

For the first pass, provide the prepared quick surface on an unlocked phone so
the interaction rather than device setup is measured. For a participant/device
assigned to the functional lock-screen spike, lock the phone first. Do not tell
the participant which control to use. End the capture timer when the audio is
durably committed, not when AI begins.

Observe:

- whether **Record a thread** is recognized;
- time from the instruction to audible recording;
- whether the participant understands the visible/system recording indicator;
- whether one second activation is understood as stop;
- what evidence the voice note contains: state, decision, source, blocker, and
  intended next move;
- whether the participant expects the locked screen to reveal private content;
- whether **Type instead** and Share remain discoverable;
- local-save comprehension before transcription or AI completes;
- expressions of burden or uncertainty.

Success thresholds:

- four of five start a prepared recording without help in five seconds or less;
- four of five stop and obtain a durable local save without help;
- all functional locked-device trials stay locked where no-unlock capture is
  claimed;
- median capture-effort rating is 2 or lower on a 5-point scale;
- four of five voice notes contain enough evidence for the same participant to
  recognize the prior state later.

If the voice note lacks repeatable information, test one optional prompt:
**Say where you stopped and what future you needs next.** Do not add multiple
questions to the locked flow without evidence.

### 4. AI draft, distractor, and return — 12 minutes

Generate a predetermined draft through the same structured contract. Seed each
session with one controlled uncertainty; across the set include a missing fact,
a low-confidence transcript segment, an unsupported assumption, a harmless
extra step, and a negation. Never expose participants to an unsafe reversed
instruction. Run the distractor, then present a generic **Draft ready** status.
Say only: “Return to the earlier task when you are ready.”

Observe:

- which content receives attention first;
- whether the participant notices **AI draft—check before using**;
- whether **You said**, the source, and **Start here** are distinguished;
- whether the participant opens **Why this?** or the transcript when uncertain;
- whether low confidence, questions, and assumptions are understood;
- whether the participant edits or blindly accepts the seeded issue;
- wrong thread, dashboard, or collection visits;
- time to correct or confirm the first action and begin;
- whether **Use this first step** is understood as confirmation of one action,
  not approval of every later step.

Success thresholds:

- four of five identify the output as AI-generated and editable;
- four of five detect or question their seeded uncertainty using the visible
  evidence path;
- four of five correct or confirm the first action and begin within 60 seconds;
- no participant believes the app scheduled, contacted, or chose a high-stakes
  priority automatically.

Separately grade 30 factual statements from test drafts. At least 90% must be
supported by cited transcript segments, and any reversed negation is a critical
failure. The behavioral pilot retains the harder two-minute event metric across
genuine real-world interruptions.

### 5. Recovery tasks — 10 minutes

Run five short, order-balanced conditions.

1. **Microphone denied:** ask the participant to capture without changing
   permission.
2. **Offline after stop:** save the audio, then fail transcription and AI.
3. **Transcript uncertainty:** mark one segment low confidence and ask the
   participant to continue.
4. **Stale drafted step:** reveal that the suggested action no longer applies.
5. **Missing source:** make the source unavailable while retaining audio,
   transcript, and draft evidence.

Observe text-path discoverability, voice-only durability, transcript correction,
AI uncertainty comprehension, preservation of revisions, deterministic reset,
and recovery from source failure.

Success thresholds:

- four of five use text, Share, transcript edit, or deterministic reset without
  facilitator direction when the voice/AI path is unavailable;
- four of five produce or correct a concrete verb-led next action;
- all five understand that the original state is preserved;
- no more than one participant believes the app selected the priority or
  provided clinical advice.

If two or more consider three reset screens burdensome, test a two-screen
variant that combines `what still matters` and `what changed`, but keep the
user-authored next action separate.

### 6. Voice permission and processing consent — 7 minutes

Show the voice example, microphone disclosure, system permission, and separate
local-versus-cloud processing choice. Alternate microphone and cloud decisions
so every decline path is observed.

Ask the participant:

- what is saved before AI begins;
- what data leaves the device under the selected choice;
- whether raw audio or transcript reaches the planning model;
- how to delete the audio, transcript, and AI draft;
- how to record or type after declining one or both choices.

Success threshold: all five distinguish microphone permission from AI/cloud
consent, all five understand that local save precedes processing, four of five
locate deletion, and all five continue through an equivalent usable path after
denial.

### 7. Notification-denied path — 5 minutes

After a participant chooses a return cue, show the soft explanation. Alternate
the OS result between denied and dismissed.

Ask the participant to continue using the product without permission, then to
locate how they would enable cues later.

Success threshold: all five understand that the thread is still saved and
available; four of five can name the widget or Now as a no-notification return
path; four of five find the later Settings route without help.

### 8. Purchase and entitlement recovery — 7 minutes

Trigger the fourth-active-thread boundary with a draft already entered. Give
each participant one scenario:

- dismiss and continue free;
- purchase canceled;
- restore a prior purchase;
- billing grace/retry;
- expired entitlement.

Observe price/term comprehension, free exit visibility, draft preservation,
restore discoverability, and beliefs about existing data.

Success thresholds:

- all five understand that existing threads remain readable;
- all five preserve or recover the draft;
- four of five find **Keep using free** or close without help;
- four of five find **Restore purchases** when asked;
- no participant believes cancellation deletes threads or ends access before
  the paid-through date.

### 9. Accessibility-condition pass — 8 to 12 minutes

At minimum, rerun locked/unlocked voice capture, stop, local save, transcript
evidence, and draft confirmation at 200% text, with reduced motion, and in a
narrow split-screen window. With participants who use assistive technology or
have speech differences, use their normal configuration and test the equivalent
text path. Otherwise perform a separate expert/engineering pass with TalkBack,
VoiceOver, keyboard, Switch Access, microphone denied, and recognition error
after the sessions.

Success threshold: no clipped required text, horizontal reading pan, obscured
Save action, unreachable control, unlabeled icon, focus trap, or reordered
meaning on the critical path. Any such defect is a launch blocker, not a
preference finding.

## Post-task questions

Ask after observable tasks, not before them:

- What felt like work that the app added?
- What information was missing when you returned?
- Where would speaking feel natural, unsafe, embarrassing, or inaccessible?
- Which sentence in the AI draft came from you, and which part did the app
  infer?
- What did you correct, and would typing one first step have been faster?
- What voice, transcript, or plan data would you want deleted first?
- What would make a return cue helpful versus annoying?
- What should never appear in notification text?
- What did you expect the paid plan to protect or unlock?
- Would a trusted person help in this exact restart moment? When would that feel
  worse? This question informs the separate C15 test and does not add it to MVP.

## Measures

| Measure | Definition | Pass | Pivot | Fail/stop condition |
|---|---|---:|---:|---:|
| Promise comprehension | Participants who describe voice/text state capture and an editable AI first action | 4/5 | 3/5 | 2/5 or fewer |
| Voice start | Prepared capture begins unassisted in ≤5 s | 4/5 | 3/5 with one repeated fixable issue | 2/5 or fewer |
| Durable voice save | Stopped audio survives before AI | 5/5 | 4/5 with immediate fix | Any lost committed audio |
| Capture effort | Median self-rating, 1 easy–5 heavy | ≤2 | 3 | ≥4 |
| AI identity comprehension | Draft is recognized as generated and editable | 4/5 | 3/5 | 2/5 or fewer |
| Evidence grounding | Factual draft statements supported by cited transcript segment | ≥90%, zero reversed negation | 75–89%, zero critical error | <75% or any reversed negation |
| Resume correctness | Corrected or confirmed first action starts in ≤60 s | 4/5 | 3/5 with one repeated fixable issue | 2/5 or fewer |
| Reset completion | Concrete user-authored next action | 4/5 | 3/5 | 2/5 or fewer |
| Permission understanding | Microphone and AI consent are distinct; core remains usable after either denial | 5/5 | 4/5 | 3/5 or fewer |
| Locked privacy | No task, transcript, source, or plan exposed by default | 5/5 devices/states | One nonprivate labeling issue | Any private content exposure |
| Data-safety comprehension | Existing threads survive paywall/cancel/expiry | 5/5 | 4/5 | 3/5 or fewer |
| Critical-path accessibility | Blocker defects | 0 | 1 minor with immediate fix | Any task-blocking defect |
| Single Ease Question | Median after capture and return, 1 hard–7 easy | ≥6 | 5 | ≤4 |

Do not average the measures into one score. A fast capture cannot compensate for
lost data, inaccessible controls, deceptive purchase understanding, or a wrong
source.

## Behavioral pilot after prototype pass

The prototype does not validate spontaneous adoption. Over seven days, collect
at least 20 genuine voice-or-text interruption-and-return events across five
participants. Do not remind participants to create individual threads.

Primary metric:

> Proportion of saved voice or text threads reopened and followed by the
> participant's first meaningful action within two minutes of opening the draft
> or deterministic recovery.

- Pass: at least 50%.
- Pivot: 25% to 49%, with a repeated, bounded capture or return failure.
- Kill: below 25%, or participants create threads only because the study
  prompts them.

Secondary measures are spontaneous voice/text capture rate, locked versus
unlocked entry, time to start recording, transcript correction, AI first-action
correction time, draft discard, source-open success, cue-open-to-start rate,
cost, latency, and notification annoyance. No private audio, transcript, task,
source, or plan content belongs in analytics.

## Analysis and decisions

For each participant, reconstruct the critical path from observed behavior:

`entry → recording/text → durable local save → transcription → AI or
deterministic draft → evidence review → first-action confirmation → source
handoff → meaningful action → update/close`.

Code every issue by stage, severity, frequency, confidence, and proposed
smallest change. Separate:

- observed behavior;
- participant explanation;
- facilitator interpretation;
- unresolved cause.

Do not convert a compliment into demand evidence. Do not implement a requested
feature unless it solves a repeated observed failure without adding a new
persona or core loop.
