# Run 7 revision — instant voice capture and AI-drafted recovery

This revision makes **instant voice capture** the preferred entry to Restart
Thread and lets AI draft a recovery plan from the user's own words. It
supersedes the original Run 7 flow comparison wherever the two conflict.

The recommended flow is now **A — Instant Voice Thread**: start recording from
a locked-system surface when the device supports it, save the audio locally
before processing, produce a grounded AI draft asynchronously, and ask the user
to confirm only the first action when they return.

The product no longer requires someone who is already interrupted to fill out
two text fields. Text, Share, and manual reset remain equivalent alternatives.

## Direct answer on lock-screen feasibility

A lock-screen voice entry is feasible as a **conditional platform enhancement**,
not a universal guarantee.

- **Android 16+ AOSP:** App widgets can be eligible for the keyguard. Current
  Android guidance says a widget-launched activity normally requires
  authentication unless the activity uses `showWhenLocked`. Widget interaction
  is also an explicit exception that can start a microphone foreground service
  with while-in-use access, provided microphone permission was already granted.
  OEMs still control whether and how the lock-screen widget host appears.
- **Samsung Galaxy:** Samsung's own Voice Recorder can start directly from a
  lock-screen widget, which proves the experience is possible on Galaxy. Samsung
  also supports lock-screen widgets, the Now Bar for supported active apps, and
  configurable Side-button shortcuts. Official material does not guarantee that
  an arbitrary third-party widget can start Restart Thread's recorder without
  authentication on every model and One UI version. This needs a physical-device
  spike before it becomes a store promise.
- **iOS/iPadOS 18+:** A Lock Screen **control**, not a passive accessory widget,
  is the right primitive. Apple documents ControlWidget actions in the Lock
  Screen and Action button, plus `AudioRecordingIntent` for starting or stopping
  recording and showing the system recording indicator. Current developer
  reports show unresolved execution and audio-session failures in some locked
  iOS 26 scenarios, so the API is promising but not yet proven for this app.
- **Universal fallback:** Home-screen widget, share target/extension, app
  shortcut, notification action, and the in-app microphone remain mandatory.
  The app cannot make lock-screen capture a prerequisite for the core job.

The detailed platform matrix is in
[locked-surface-feasibility.csv](./locked-surface-feasibility.csv).

## Revised experience promise

The new promise is:

> Say where you are. Get a small recovery draft when you're ready.

The message avoids claiming that AI knows the correct plan. The user can speak
messily, stop immediately, and leave. The audio note is already useful even if
transcription, AI, the network, or a locked-device integration fails.

The core loop becomes:

```text
Tap or press → speak → stop → local save
                               ↓
                    transcribe when possible
                               ↓
                    draft grounded recovery
                               ↓
              review one first action → start
```

Success is still the user's first meaningful action. Recording, transcription,
AI completion, notification delivery, and opening the draft are intermediate
events.

## One-time setup without a first-use dead end

Locked capture works only after a short setup while the device is unlocked.
The setup follows a real value demonstration rather than appearing at first
launch.

1. Let the user record and replay a five-second sample in the app.
2. Explain microphone handling before the system prompt: **Restart Thread uses
   your microphone only after you start a voice thread. It saves the recording
   locally first.**
3. Request microphone permission. If denied, preserve text, Share, and manual
   reset paths.
4. Explain AI processing as a separate choice: **Use AI recovery drafts** or
   **Keep voice notes local**. If cloud processing is used, name what leaves the
   device, the processor, retention, and deletion behavior before consent.
5. Offer **Add quick capture** with device-specific instructions for Lock
   Screen, Action button, Side button, or home screen. Skip is always available.
6. Run a setup check that confirms start, visible recording indicator, stop,
   local save, and private lock-screen status on that device.

The lock-screen control never becomes the place where the app first explains
microphone or cloud processing. If setup is incomplete, the locked action asks
the user to unlock and opens the exact setup step.

## Voice capture interaction

The locked experience contains one task and no private content.

### Idle

- Control name: **Record a thread**.
- Icon: microphone with a distinct app mark.
- No thread title, task, transcript, source, or AI state appears while locked.
- A screen reader announces **Record a thread, button** or the platform-native
  equivalent.

### Recording

- One deliberate activation starts recording. A second activation stops it.
- A short haptic and visible system microphone indicator confirm start. Sound is
  optional and off by default.
- Show elapsed time and **Stop recording**. Do not rely on a waveform; it is
  inaccessible and does not prove that useful audio is being captured.
- Limit the launch prototype to 60 seconds. Warn at 50 seconds through text,
  haptic, and screen-reader status without interrupting speech.
- Phone call, another recorder, microphone revocation, or system termination
  stops safely and preserves every committed audio segment.

### Saved and processing

- Stop commits the audio locally before any upload or animation.
- Locked status is generic: **Voice thread saved** and then **Drafting recovery**
  or **Draft ready**. The transcript and plan remain hidden.
- If the network or AI fails: **Voice saved. Open after unlocking to try the
  draft again.**
- If the phone has not been unlocked since reboot or protected storage is
  unavailable, require authentication rather than storing sensitive audio in a
  less-protected location.

## AI draft contract

AI converts the voice note into a draft that remains visibly tied to the user's
words. It does not autonomously create tasks, schedule reminders, contact other
people, or choose a high-stakes priority.

### Inputs

The smallest AI request contains:

- transcript segments with stable IDs and timestamps;
- an optional source link or shared artifact label;
- prior thread state when the user intentionally appends to a thread;
- user-selected language;
- no analytics identifiers, advertising identifiers, contacts, or unrelated
  thread history.

Raw audio is sent to a remote service only when the user enabled remote
transcription. The planning model receives the transcript, not raw audio, unless
a selected provider requires a single combined audio workflow and the user was
explicitly told.

### Structured output

The model must return a bounded structure:

```json
{
  "where_you_are": {
    "text": "",
    "evidence_segment_ids": [],
    "confidence": "high | medium | low"
  },
  "start_here": {
    "text": "",
    "evidence_segment_ids": [],
    "confidence": "high | medium | low"
  },
  "next_steps": [
    {
      "text": "",
      "evidence_segment_ids": [],
      "confidence": "high | medium | low"
    }
  ],
  "questions": [],
  "assumptions": []
}
```

The output contains one `start_here` action and no more than four total steps.
The first action uses an observable verb and aims to be possible in about two
minutes. Every factual plan item points to transcript evidence. Unsupported
content appears in `assumptions` or is omitted.

### Draft rules

- Do not add a deadline, person, amount, commitment, or priority that the user
  did not state.
- Do not convert emotion into a diagnosis or treatment recommendation.
- Do not make medical, legal, financial, crisis, or safety decisions. Preserve
  the note and ask the user to review the relevant source or qualified person.
- Prefer one clarifying question over an invented step, but never block access
  to the voice note or transcript.
- Preserve negation and uncertainty. **I don't need to email Sam** must never
  become **Email Sam**.
- Show **AI draft—check before using** until the user confirms or edits the first
  action.
- Regeneration creates a new visible revision. It never silently overwrites an
  accepted plan.

### Review interaction

The unlocked draft screen contains:

1. **You said** — a two-line summary with **View transcript**.
2. **Start here** — one prominent editable action.
3. **Then** — up to three collapsed steps.
4. **Needs your answer** — no more than two nonblocking questions.

Primary action: **Use this first step**. Secondary actions: **Edit draft** and
**Save voice only**. The user doesn't need to approve every later step before
starting. Confirming the first step marks the plan active; it doesn't certify
the whole draft as correct.

## Processing and fallback architecture options

The interaction remains stable while the technical path changes.

### Option 1 — Cloud transcription and cloud plan

This provides the most consistent output and fastest implementation with the
builder's existing API access. The app encrypts upload, minimizes request
fields, uses a backend relay so provider keys aren't shipped in the app, and
records provider, retention, deletion, latency, and cost. It has the highest
privacy and operational burden.

### Option 2 — On-device transcription and cloud plan

Android can check for an on-device `SpeechRecognizer`; Apple can require
on-device Speech recognition when the selected language and device support it.
Only the transcript reaches the plan model. Availability and accuracy vary, and
Android warns that its general recognizer may stream to remote services unless
the on-device implementation is explicitly selected.

### Option 3 — Local voice note and deterministic recovery

When the network, on-device recognizer, AI service, consent, quota, or budget is
unavailable, the user still receives a saved voice note, manual transcript edit,
and the original deterministic reset questions. This is the mandatory baseline,
not a degraded error page.

The launch spike can begin with Option 1 for speed only if disclosure,
encryption, deletion, provider terms, and server-side key protection are ready.
The product must always retain Option 3.

## Revised flow A — Instant Voice Thread

This is the recommendation.

**Goal:** express a messy state immediately, leave, then return to one grounded
first action.

**Entry points:** Lock Screen widget/control where proven, Action or Side
button where proven, home widget, app shortcut, Share, or in-app microphone.

**Flow:**

1. Activate **Record a thread**.
2. Speak for up to 60 seconds and activate **Stop recording**.
3. The app saves audio locally and lets the user leave immediately.
4. Transcription and recovery drafting run asynchronously when allowed.
5. A private generic status says **Draft ready**.
6. After authentication, the user sees **You said**, one **Start here** action,
   and up to three later steps.
7. The user edits or selects **Use this first step**.
8. The source opens when one exists; otherwise the app records **I started** only
   after explicit confirmation.

**Memorable moment:** a messy voice note resolves into one traceable, editable
start action without exposing private content on the lock screen.

**Main risk:** the quick surface varies by platform and an AI plan can sound more
certain than its evidence. Locked capture and AI grounding need separate kill
tests.

## Revised flow B — Context plus voice handoff

This option maximizes accuracy when the interruption happens inside another app.

**Goal:** preserve the exact source and add a spoken state with minimal typing.

**Entry points:** Android Sharesheet, iOS share extension, file/link share,
browser shortcut, or in-app source picker.

**Flow:**

1. Share a source to Restart Thread.
2. The capture sheet shows the source and immediately offers **Speak the state**.
3. The user records, stops, and leaves; source and audio save locally together.
4. AI drafts a recovery plan grounded in both transcript segments and source
   metadata or user-selected excerpts.
5. Return opens the source-linked draft and one first action.

**Memorable moment:** the draft can explain which part came from the user's
voice and which part points back to the source.

**Main risk:** sharing plus recording adds a step and source ingestion creates
format, permission, privacy, and prompt-injection work. The first version should
use source title/link and user-selected text, not unrestricted document upload.

## Revised flow C — Voice rescue after the break

This option removes all pre-interruption behavior.

**Goal:** speak what remains after context has already been lost and get a
best-effort recovery draft.

**Entry points:** the same locked and unlocked voice surfaces as Flow A.

**Flow:**

1. Activate **Recover a thread** after noticing the restart failure.
2. Speak what the user remembers, what still matters, and what feels blocked.
3. AI drafts a state hypothesis, one first action, and explicit questions.
4. The user confirms or corrects the state before using the first action.

**Memorable moment:** disorganized recall becomes a small draft without forcing
the user through a form.

**Main risk:** the model lacks the source and may produce a generic micro-plan.
This is closest to crowded AI starting assistants and has the weakest
differentiation.

## Revised comparison

The scorecard uses a fixed 1–5 analyst scale. It is not user evidence or a judge
score.

| Criterion | Weight | A Instant voice | B Context + voice | C Voice rescue |
|---|---:|---:|---:|---:|
| Capture/start friction | 20% | 5 | 3 | 5 |
| Context fidelity | 20% | 4 | 5 | 2 |
| AI grounding and user trust | 15% | 4 | 5 | 2 |
| Locked-surface feasibility | 15% | 3 | 2 | 3 |
| Works when offline or AI fails | 10% | 5 | 5 | 5 |
| Solo-builder feasibility | 10% | 3 | 3 | 4 |
| Android/Galaxy leverage | 5% | 5 | 5 | 4 |
| Judge-observable proof | 5% | 5 | 5 | 4 |
| **Weighted total** | **100%** | **4.15** | **3.95** | **3.45** |

Choose A as the default prototype. Include B as a second entry to the same data
model, not a separate product. Preserve C as the no-breadcrumb rescue state.
This combination shares one user, one thread model, one AI draft contract, and
one outcome. It doesn't create feature sprawl.

## New falsification thresholds

The voice and AI revision advances only if both the quick capture and the draft
are credible.

- Four of five target users start recording from the prepared quick surface in
  five seconds or less without help.
- Four of five stop and obtain a durable local save without unlocking again on
  a device where no-unlock capture is claimed.
- All 50 forced process terminations preserve every stopped recording.
- At least 90% of 30 factual draft statements are supported by a cited
  transcript segment; any reversed negation is a critical failure.
- Four of five users identify the draft as AI-generated and editable.
- Four of five can correct the first action and start within 60 seconds of
  opening a ready draft.
- At least half of 20 genuine voice threads lead to a first meaningful action
  within two minutes of opening the draft.
- Locked surfaces expose no transcript, thread name, source, plan, or private
  notification text in the default configuration.
- Microphone denial, AI refusal, network failure, quota exhaustion, and provider
  timeout all end in a usable saved voice note or text path.

Kill the no-unlock promise on a platform if it can't survive its physical-device
matrix. Pivot the AI plan to `summary plus one suggested start` if plan grounding
falls below the threshold. Kill AI as a core differentiator if users spend more
time correcting it than writing one next step themselves.

The decision choices are recorded once in the main Run 7 report.
