# Run 8 — Visual system, motion, haptics, and sound

Run 8 defines five distinct visual and sensory directions for Restart Thread's
selected **Instant Voice Thread** flow. The recommended direction is **A2 —
Thread & Trace**, paired with **I2 — Trace-back Reveal**: a user can open the AI
draft's rationale and follow a restrained visual connector from the proposed
first action to the exact transcript evidence that supports it. This makes the
product's grounded-AI boundary visible instead of relying on decoration.

The original recommendation was not a selection. In the follow-up visual pass,
the builder selected the first A2 Trace-back storyboard variation, now recorded
as **I2-V1 — Direct Trace-back Connector**, and then locked **H2 — Forward
Thread** as the visual prototype. Run 8's visual and interaction gate is
complete.

## Executive summary

This run treats visual design as a way to clarify the recovery loop, establish
trust, and make state transitions judge-observable. It does not use a distinctive
palette or animation as a substitute for validated user value.

- **A1 — Quiet Instrument** uses warm neutral surfaces, low-arousal motion, and
  system typography to make recovery feel calm and competent.
- **A2 — Thread & Trace** uses a restrained route-and-node motif to show where a
  thought was captured, what AI inferred, and which evidence supports the first
  action. It is the recommendation because its visual signature explains the
  product's most defensible behavior.
- **A3 — Tactile Relay** turns the handoff into a small set of physical-feeling
  tiles. It offers the strongest direct manipulation, but it risks becoming a
  gamified task manager.
- **A4 — Editorial Relay** uses bold type, disciplined cropping, and a quiet
  print-like hierarchy. It offers the strongest store presentation, but its
  signature is less native to a low-friction capture moment.
- **A5 — Night Beacon** is a dark-first, glanceable direction for locked and
  interrupted contexts. It is highly recognizable, but a dark-only identity
  would conflict with the required light, dark, and increased-contrast variants.
- All five prototype palettes pass the calculated WCAG 2.2 AA checks recorded
  in [color-contrast.csv](./color-contrast.csv). These are source-color checks,
  not rendered-device certification; every converted Material, Apple, widget,
  Always-On, and increased-contrast variant still needs measurement.
- The shared sensory rule is **quiet by default**. No custom sound or continuous
  haptic runs while the microphone is active. Start, stop, durable save, AI
  readiness, and confirmed first action remain visually understandable without
  sound or vibration.
- Android uses Material components, ripple, predictive back, 48 dp touch targets,
  and a brand theme that can optionally adapt to dynamic color. Galaxy adds One
  UI reach zones, 24 dp safe margins near curved edges, fold continuity,
  multi-pane recovery, and Flex mode only when the same workflow benefits.
- iOS and iPadOS use system text styles, semantic colors, familiar sheets and
  controls, Dynamic Type, and privacy-safe Lock Screen content. The secondary
  Mac path keeps the same brand but adds pointer, keyboard, and resizable-window
  behavior instead of pretending that a phone layout is a desktop design.
- Historical analysis remains a warning: every winner and control in the tested
  corpus had some visual or motion signature. Strong craft was more common among
  winners, but distinct appearance alone was not a winner differentiator. The
  submission must show cause, state, feedback, and recovery.

The complete art-direction specifications are in
[art-directions.md](./art-directions.md). The primary-award comparison is in
[direction-audit.csv](./direction-audit.csv), the calculated color pairs are in
[color-contrast.csv](./color-contrast.csv), and the evidence trail is in
[source-ledger.csv](./source-ledger.csv). Generated comparison boards for all
five directions are indexed in
[visual-previews/README.md](./visual-previews/README.md); they are hypotheses,
not final screens or platform proof.

## Fixed product and flow boundary

The builder selected Run 7 Option A on August 11, 2026. Run 8 therefore assumes
the following controlling experience and does not reopen the flow decision.

> Record a thread → commit audio locally → transcribe and draft asynchronously →
> show “You said,” one editable “Start here” action, at most three later steps,
> questions, assumptions, confidence, and transcript evidence → require the user
> to edit or confirm the first action before it becomes active.

The visual system must preserve these boundaries:

- **Locked surfaces stay generic.** They may show **Record a thread**,
  **Recording**, **Voice thread saved**, **Drafting recovery**, or **Draft ready**.
  They don't show the transcript, source, task, or plan by default.
- **Local save and AI are separate states.** A successful capture never appears
  to depend on transcription or generation.
- **Voice is optional.** Text, Share, and deterministic reset remain equivalent
  entry and recovery paths.
- **The product is not a planner.** It restores one thread and starts one
  feasible action. It doesn't add projects, points, streaks, pets, autonomous
  scheduling, or an expanding task economy.
- **The primary award is RevenueCat Design.** Best App for Galaxy and Keep Them
  Coming Back remain conditional secondary awards. They do not justify a new
  persona, loop, or decorative feature.

## Method and research discipline

Exa was the primary discovery and content-extraction system. It searched query
variations for Android Material theming and motion, Samsung One UI and foldable
behavior, Apple color, typography, feedback, motion, haptics, audio, and Lock
Screen presentation, WCAG 2.2 contrast and motion guidance, and adjacent and
unrelated product references. Exa then fetched every material URL used here.

Firecrawl was used as a recorded visual fallback because Exa's extracted text
cannot establish rendered palette, type, density, or imagery. Firecrawl returned
structured branding extractions for Tiimo, Llama Life, Monument Valley, and a
Spotify Wrapped article. It also captured a Tiimo mobile viewport, but returned
the image only as a remote signed URL that this research surface could not
visually inspect. Firecrawl's branding output is automated inference, so no
direction copies its detected colors, fonts, buttons, layout, or trade dress.
Material claims rely on official page text, official platform guidance, prior
event-period Shipaton evidence, and the independently calculated prototype
palettes. No browser or manual screenshot analysis was used.

The source classes used in [source-ledger.csv](./source-ledger.csv) are:

- **A:** official Shipaton material, historical event evidence, platform
  guidance, or an accessibility standard;
- **C:** current first-party product, support, or brand material;
- **D:** analyst synthesis or calculation.

## Installed-skill influence

The installed design skills materially changed the work, but they are design
heuristics rather than user research or judge data.

- **UX Designer** kept the visual directions subordinate to the selected user
  flow, required error and accessibility states, and rejected art that added a
  second core loop.
- **Better Colors** produced semantic role tokens, light and dark variants,
  OKLCH authoring values, one-meaning-per-color rules, and calculated contrast
  checks instead of aesthetic-only swatches.
- **Better Typography** favored system families, a small role-based scale,
  tabular changing values, controlled line measure, localization resilience,
  and readable body weights.
- **Better Accessibility** required non-color state cues, target-size and focus
  behavior, screen-reader announcements, reduced motion, scalable text, and
  equivalent non-gesture paths.
- **Apple Design** reinforced immediate feedback, causal and synchronized
  sensory cues, interruptible state transitions, quiet haptics, system
  materials, and platform adaptation rather than cross-platform imitation.
- **12 Principles of Animation** supplied consistent, brief timing families,
  purposeful easing, one focal animation at a time, and restrained physical
  deformation. Its under-300 ms rule is used as a prototype motion constraint,
  not a behavioral success threshold.
- **Docs Writer** shaped the report into a direct, evidence-linked specification
  with explicit requirements, recommendations, and unknowns.

## Reference principles

The references contribute principles, not layouts or brand assets. Current
product pages describe present-day experiences and do not establish measured
effectiveness, retention, conversion, or preference.

| Reference | Relationship | Transferable principle | Explicit non-copy boundary |
|---|---|---|---|
| Tiimo | Adjacent visual planner and spoken AI planning | Make time or sequence visible, support flexible restart, and keep widgets glanceable | Don't reuse its puffy logo, palette, icon library, schedule layout, or broad planner scope |
| Llama Life | Adjacent one-task productivity tool | Focus attention on one active item and celebrate completion without enlarging the plan | Don't copy its llama identity, emoji treatment, confetti, timer layout, or timeboxing product loop |
| Apple Voice Memos | Adjacent voice capture | One obvious record control, a visible microphone state, waveform detail on demand, and durable stop/save behavior | Don't clone its waveform, red record trade dress, list layout, or editing controls |
| Headspace Unwind Your Mind | Adjacent emotional-quality reference | Let the user choose a low-pressure route from their current state; calm comes from predictable choices | Don't borrow its characters, orange identity, meditation language, or health claims |
| Spotify Wrapped | Unrelated storytelling system | One adaptable graphic principle can unify app, store, demo, and share surfaces while supporting varied content | Don't use Spotify's ribbon, gradients, symbols, type, annual-recap format, or maximal campaign energy |
| Strava Year in Sport | Unrelated personalized recap | Keep private content private by default and let the user choose the exact scene or summary they share | Don't reuse activity maps, orange branding, sports statistics, or recap composition |
| Monument Valley | Unrelated direct-manipulation game | A memorable interaction is strongest when manipulating the visual model reveals the product's meaning | Don't use impossible geometry, isometric architecture, pastel world art, characters, or puzzle mechanics |
| Flowmino, Dayloop, and PitchLab | Historical RevenueCat Design winners | Integrate interaction, aesthetics, feedback, and first value; don't submit isolated polish | Don't infer judge reasoning or reproduce any winner's spatial planner, timelapse, or instrument interface |

## Cross-direction design contract

Every direction uses the same semantic and behavioral foundation so the gate
selects expression, not five different products.

### Color and surfaces

Color serves action, state, and hierarchy. Decorative color never carries task
status or AI confidence by itself.

- Define semantic roles for `surface`, `surface-container`, `text-primary`,
  `text-secondary`, `action-primary`, `on-action`, `evidence`, `focus`,
  `success`, `warning`, and `error`.
- Keep `action-primary` exclusive to the active recovery action. Don't reuse it
  for decorative lines, unlocked premium features, or passive illustrations.
- Pair every status color with text, shape, or iconography. AI evidence uses a
  quote mark or source-node shape in addition to hue.
- Supply light, dark, and increased-contrast variants. Android dynamic color is
  an optional adaptation after all semantic pairs are remeasured; it doesn't
  silently replace brand colors in the first prototype.
- Treat the values in [color-contrast.csv](./color-contrast.csv) as sRGB source
  prototypes. Recalculate contrast after HCT generation, Apple asset-catalog
  adaptation, opacity, blur, disabled-state treatment, Always-On dimming, or
  device color-management changes.

### Typography

Typography makes the user's words and the proposed action feel primary. Brand
expression never makes transcript evidence harder to read.

- Use Roboto or the active Android system family on Android and SF system text
  styles on Apple platforms. A display face is permitted only in A4 headings,
  with system body text and verified language coverage.
- Use display, title, body, label, caption, and timer or changing-value roles.
  Timers, elapsed recording values, and changing confidence values use tabular
  numerals.
- Keep body text at the platform's readable default, use regular or medium
  weights, and preserve hierarchy at larger text settings.
- Keep recovery-plan measure near 45–68 characters when space permits. Let
  headings balance and body text wrap naturally; don't truncate the first
  action or transcript evidence without an expansion path.
- Test 200% text enlargement, Android font scaling, iOS Dynamic Type, RTL,
  mixed-direction transcript content, CJK, and at least 40% label expansion.
  The expansion figure is a prototype stress case, not a claim about every
  language.

### Motion

Motion explains cause, continuity, and readiness. It doesn't fill AI latency or
turn routine capture into a spectacle.

- Show press feedback immediately. Use prototype families of 80–120 ms for
  press feedback, 160–220 ms for local state changes, and 220–280 ms for short
  spatial transitions. These ranges come from the installed animation rules and
  Apple and Material brevity guidance; hardware testing can refine them.
- Use ease-out for entrance, ease-in for exit, and a critically damped spring
  only for direct manipulation. Continuous progress may be linear; spatial
  movement isn't.
- Animate one focal element at a time. Local save completes before the AI-ready
  reveal begins.
- Start from the current rendered state, accept interruption, and never block a
  tap until an animation finishes.
- Under reduced motion, replace line drawing, path travel, scaling, and spring
  movement with a static connector, instant state change, or short opacity
  crossfade. Meaning remains identical.

### Haptics and sound

Sensory feedback is causal, synchronized, optional, and safe around recording.

- Prefer platform action-oriented haptics. If hardware would produce a buzzy
  fallback, use no custom haptic.
- Don't vibrate continuously while recording. Verify on each device that any
  start cue finishes before microphone capture and that any stop or save cue
  doesn't contaminate audio or disrupt the sensor.
- Reserve a short cue for a discrete event: capture started, durable save,
  first-action confirmation, or an error requiring attention. Routine scrolling,
  transcript playback, and AI token arrival remain silent and non-haptic.
- Don't play a custom sound while the microphone is active. Respect silent,
  Do Not Disturb, system volume, output routing, and the user's in-app sensory
  preferences.
- Every sound or haptic has a simultaneous visual and programmatic equivalent.
  A ready or error state cannot depend on hearing or touch.

## Direction comparison

The five directions are intentionally distinct in mood, spatial language,
brand behavior, and signature interaction while preserving the same flow.

| ID | Direction | Emotional job | Signature interaction | Strongest award evidence | Main risk |
|---|---|---|---|---|---|
| A1 / I1 | Quiet Instrument / Signal Settle | Reduce arousal and restore agency | A restrained capture signal settles into the underlined first action | Restraint, hierarchy, state clarity, accessible calm | Can look generic or overly wellness-coded |
| A2 / I2 | Thread & Trace / Trace-back Reveal | Replace uncertainty with understandable continuity | **Why this?** reveals a connector from action to supporting transcript segments | Innovative grounded-AI interaction, feedback, demo clarity | Connector complexity across layouts and large text |
| A3 / I3 | Tactile Relay / First Tile Snap | Make the handoff feel physical and achievable | Tap or drag the first-action tile into an active dock | Direct manipulation, gesture, haptic alignment | Can become gamification or a task board |
| A4 / I4 | Editorial Relay / The Cut | Turn verbal clutter into a crisp decision | Source and draft switch in place; evidence remains visibly attributed | Typography, store screenshots, confident composition | Display type, density, and motion can overpower urgency |
| A5 / I5 | Night Beacon / Beacon Handoff | Provide a reliable point of orientation during interruption | A generic recording beacon becomes the same readiness marker in-app | Lock-screen continuity, glanceability, dark-mode craft | Continuous glow, OLED bloom, and dark-only branding risk |

The detailed specifications and platform adaptations are in
[art-directions.md](./art-directions.md).

## RevenueCat Design Award audit

The official category judges innovative ideas before aesthetics and asks for
specific screens, flows, interactions, animations, and design rationale in a
demo that shows the app in motion. The scores in
[direction-audit.csv](./direction-audit.csv) are analyst assessments, not judge
scores or user findings.

### Innovation

A2 has the strongest innovation case because Trace-back Reveal makes AI
provenance an interaction. The user can inspect why the app drafted a first
action, reach the exact transcript evidence, and correct the action without
entering a separate explanation screen. A1, A3, A4, and A5 are coherent, but
their signatures are more familiar state, tile, editorial, or status patterns.

### Aesthetics

A2 and A4 have the strongest brand systems. A2 can connect icon, capture,
evidence, draft, store screenshots, and the demo with one restrained node-and-
route grammar. A4 can produce the strongest static compositions. A1 is safest
for readability, A3 is friendliest, and A5 is most recognizable in dark contexts.
None can claim aesthetic quality until rendered screens are reviewed on devices.

### Delight

Delight comes from understanding and control, not confetti. A2's moment is the
instant the proposed action becomes explainable. A1's is the quiet resolution
from capture to clarity. A3's is a tactile snap. A4's is an editorial before-and-
after. A5's is continuity between the locked capture marker and the ready draft.

### Gesture quality

A3 offers the most visible direct manipulation, but the drag is optional because
every action needs a tap and accessibility-action equivalent. A2 uses an ordinary
tap on **Why this?** and an optional press-and-hold preview; its strength is
causal mapping, not gesture novelty. A1, A4, and A5 rely on familiar controls and
therefore carry less gesture risk.

### Feedback

All directions must visibly distinguish recording, durable local save, AI work,
draft ready, user confirmation, and recovery from failure. A2 maps these states
to separate nodes without suggesting that AI created or saved the recording.
This is the strongest feedback story. A5 is strongest at glanceable status, and
A1 is strongest at minimizing attention conflict.

### Animation

A2's line reveal is brief, interruptible, and informative. A1's settling signal
is quieter. A3's physical snap must retain velocity and respect reduced motion.
A4's typographic changes must avoid content reflow that resembles deletion.
A5's beacon cannot pulse indefinitely; use system recording state and a static
reduced-motion marker.

### Observable submission proof

The demo must show behavior, not a narrated mood board. For the recommended A2
direction, the evidence sequence is:

1. Start from a proven locked control or the universal widget fallback without
   exposing private content.
2. Record, stop, and show **Voice thread saved** before any AI state.
3. Open the ready draft and show **You said** plus **Start here**.
4. Activate **Why this?** and reveal the exact transcript citations connected to
   the proposed action.
5. Edit or confirm the first action and show the feedback state.
6. Show one failure path where the local note survives AI or network failure.
7. Show reduced motion, scalable text, TalkBack or VoiceOver labeling, and the
   same state without sound or haptics.
8. If Best App for Galaxy remains entered, show physical Galaxy evidence for
   cover-to-main continuity, multi-window or fold layout, and the Galaxy Store
   listing. Don't use a simulated fold animation as device proof.

## Galaxy and cross-platform adaptation

The brand stays recognizable through color roles, node geometry, icon language,
and feedback order. Navigation, typography, controls, and window behavior adapt
to each platform.

### Android and Galaxy

Android is the primary implementation target. Use Material components and
semantics, Android ripple, predictive back, 48 dp touch targets, `sp` text,
system insets, and light, dark, and contrast-aware themes. Keep brand source
colors as the controlled default during the hackathon; prototype dynamic color
as an optional adaptation only after every semantic pair and evidence connector
still passes contrast and retains meaning.

For Galaxy, place frequently used controls in the lower interaction area and
keep noninteractive context in the upper viewing area. Use One UI focus blocks
sparingly for **Start here**, maintain at least 24 dp safe side margins near edge
and curved displays, preserve thread and edit state across fold changes, and use
two panes only when the second pane prevents context loss. A suitable unfolded
layout shows the thread list or transcript evidence on the first pane and the
recovery draft on the second. In Flex mode, evidence can remain above the crease
and confirmation controls below it; don't put primary controls on the crease.

The Galaxy optimization score remains 20% of the otherwise applicable standard
criteria. Visual adaptation supports that score only when the app is tested on
real Samsung devices and the Galaxy Store listing is polished.

### iOS, iPadOS, and Mac

iOS and iPadOS use system text styles, semantic asset colors, SF Symbols where
appropriate, familiar sheets, VoiceOver, Dynamic Type, and a 44 pt comfortable
touch target. Lock Screen and Live Activity surfaces use generic content and
system materials. The app doesn't hard-code a visual style that breaks against
wallpapers, Always-On dimming, increased contrast, or system tint.

The planned Mac path remains a compatible iPhone or iPad app unless a later
stack decision changes it. In a Mac window, present list and detail side by side
when width permits, preserve keyboard focus, support standard shortcuts and
pointer states, and avoid oversized phone controls floating in empty space.

## Color verification summary

The calculated palette file contains four tested pairs for every direction and
appearance: primary text on surface, secondary text on surface, action or focus
color against surface, and on-action text against the action fill.

- All normal-text pairs exceed 4.5:1.
- All action, focus, and meaningful graphical pairs exceed 3:1 against their
  documented adjacent surface.
- Every state also requires a label, icon, node shape, or structural cue; passing
  contrast doesn't make color-only information acceptable.
- The tests use the standard sRGB relative-luminance calculation and unrounded
  source values. The displayed ratios are rounded for reporting after the pass
  decision.
- Disabled states, overlays, transparency, gradients, images, system tint,
  dynamic color, increased contrast, and actual focus indicators remain
  untested. These are implementation checks, not reasons to reject a direction
  now.

## Evidence and uncertainty ledger

The complete ledger is in [source-ledger.csv](./source-ledger.csv). The most
important evidence states are summarized here.

| Claim | Status | Confidence | Limitation |
|---|---|---|---|
| The 2026 Design Award prioritizes innovative ideas, interface craft, interaction, and animation | Observed in current official category material | High | It doesn't disclose private judge weighting beyond the published criterion order |
| A visual signature alone does not distinguish historical winners | Measured in the prior coded corpus | Medium-high | Historical evidence quality and category composition vary |
| Platform color, type, motion, haptics, and accessibility guidance support the shared foundation | Observed in current official platform material | High | Implementation still needs target-version and device tests |
| Tiimo, Llama Life, Voice Memos, Headspace, Spotify, Strava, and Monument Valley provide transferable principles | Described or observed in first-party material | Medium | Product pages don't prove user preference or effectiveness |
| A2 will feel clearer, more trustworthy, or more delightful than the other directions | Inferred | Low | Requires comparative prototype testing |
| The proposed palette source pairs pass their documented contrast checks | Calculated | High for the listed hex pairs | Rendered variants and compositing aren't tested |
| Firecrawl's structured branding extraction accurately represents each current page | Inferred by the tool | Low-medium | Automated extraction and an unviewable remote screenshot cannot replace visual inspection |

## Contradictions and missing evidence

The run found no fatal visual dependency, but several uncertainties prevent a
final style decision from being presented as validated.

- Current product pages can inspire principles, but their presentation is not
  contemporaneous Shipaton evidence and doesn't measure user outcomes.
- Spotify's 2021 identity used a dynamic thread. Restart Thread must not use a
  ribbon, embedded symbols, Spotify color behavior, or Wrapped composition. A2
  uses a thin evidence route whose function is provenance, not a brand ribbon.
- Platform guidance favors both system adaptation and brand expression. Dynamic
  color can strengthen Android fit but weaken a fixed evidence-color grammar.
  The recommended compromise—brand default plus optional adaptation—still needs
  testing.
- A waveform is familiar for voice capture, but it may imply signal accuracy or
  demand attention. No direction treats waveform shape as transcript confidence,
  emotion, or AI certainty.
- Haptic behavior varies widely across Android hardware. Custom rich effects are
  not a submission promise until support and fallbacks are tested.
- No visual comparison has been tested with target users, people using large
  text, color-vision-deficiency simulation, TalkBack, VoiceOver, Switch Access,
  reduced motion, or real locked contexts.
- No app icon or store screenshot has been rendered at the required contest
  sizes. Concepts in the art-direction file are briefs, not production assets.
- The locked capture, Galaxy fold behavior, and iOS control behavior retain the
  independent physical-device proof gates from Run 7.

## Recommendation

Choose **A2 — Thread & Trace** with **I2 — Trace-back Reveal** for the first
high-fidelity prototype.

The reasons are specific to the product and rubric:

1. It turns the grounded-AI contract into visible product behavior. A judge and
   a user can see why the first action exists and where it came from.
2. It separates local capture, transcription, AI drafting, and user confirmation
   without adding screens or a second loop.
3. Its node-and-route language can unify the app icon, capture status, evidence,
   draft, Galaxy layout, store screenshots, and demo while remaining restrained.
4. It supports an accessible static form. The connector can become a persistent
   line and source labels under reduced motion, and **Why this?** remains a
   normal button.
5. It creates stronger observable evidence for innovative interaction than a
   purely calm, dark, editorial, or gamified art direction.

Prototype A1 — Quiet Instrument as the comparison condition. If A2's connectors
increase confusion, reading time, or implementation risk, A1 preserves the
selected flow with the least visual overhead.

## Decision gate

**Complete.** The builder selected **H2 — Forward Thread** with **I2-V1 — Direct
Trace-back Connector**. This selection fixes the visual prototype for later
runs but doesn't authorize implementation or change the unresolved Run 7
technical and behavioral proof requirements.

## Updated research state

The following block records Run 7 Option A as selected and advances only the
visual decision.

```yaml
RESEARCH_STATE:
  completed_run: 8
  selected_concept: "R1 Restart Thread: C13 Reset Button plus C14 Breadcrumb; C15 remains outside the MVP."
  selected_ux_direction: "A Instant Voice Thread with local-first save, grounded AI draft, conditional locked surfaces, Context plus Voice alternate entry, and Voice Rescue fallback."
  primary_award: "RevenueCat Design Award"
  conditional_secondary_awards:
    - "Best App for Galaxy"
    - "Keep Them Coming Back Award"
  visual_directions_at_gate:
    - "A1 Quiet Instrument"
    - "A2 Thread & Trace — recommended"
    - "A3 Tactile Relay"
    - "A4 Editorial Relay"
    - "A5 Night Beacon"
  signature_interactions_at_gate:
    - "I1 Signal Settle"
    - "I2 Trace-back Reveal — recommended"
    - "I3 First Tile Snap"
    - "I4 The Cut"
    - "I5 Beacon Handoff"
  selected_visual_direction: "H2 Forward Thread: A4-dominant editorial system with the large present-state dot, dotted context thread, forward arrow, tactile primary action, and corrected single-state locked widget."
  selected_signature_interaction: "I2-V1 Direct Trace-back Connector: the first A2 preview variation."
  hybrid_visual_directions_at_gate:
    - "H1 Anchor Forward — A2-dominant violet system; recommended baseline"
    - "H2 Forward Thread — A4-dominant editorial system; selected by builder"
  rejected_directions:
    - "Copying adjacent-product layouts, trade dress, illustration, icons, or brand assets."
    - "Using Spotify's ribbon, Wrapped composition, gradients, embedded symbols, or campaign energy as Restart Thread's thread motif."
    - "Using waveform shape to represent emotion, transcript confidence, or AI certainty."
    - "Dark-only styling without light and increased-contrast variants."
    - "Decorative motion, perpetual pulsing, confetti, streaks, points, pets, or task-economy gamification."
    - "Sound or continuous haptics while recording."
    - "Gesture-only controls or color-only evidence and status."
    - "A simulated Galaxy fold or lock-screen animation presented as physical-device proof."
  accepted_evidence:
    - "Builder selected Run 7 Option A on August 11, 2026."
    - "Official 2026 RevenueCat Design Award material prioritizes innovative ideas, aesthetics, interaction craft, and motion shown in the demo."
    - "Prior historical corpus shows that visual-signature presence alone does not distinguish winners; strong integrated craft is more informative."
    - "Current Android, Samsung, Apple, and WCAG guidance supports semantic color, scalable type, purposeful optional motion, multimodal feedback, and platform adaptation."
    - "Exa was the primary discovery and full-text extraction system for Run 8."
    - "Firecrawl supplied automated branding extraction as a documented visual fallback; no material claim relies on the inaccessible screenshot or automated trade-dress inference."
    - "All listed source-color pairs in Run 8 pass their documented WCAG 2.2 contrast checks."
  unresolved_questions:
    - "Which Run 8 art direction and signature interaction will the builder select?"
    - "Does Trace-back Reveal improve provenance comprehension without increasing time to first action?"
    - "Can the selected direction survive 200% text, TalkBack or VoiceOver, reduced motion, color-vision-deficiency simulation, and one-handed use?"
    - "Do the converted Material, Apple, Galaxy widget, Always-On, and increased-contrast palettes preserve the calculated source contrast?"
    - "Can the signature interaction maintain smooth performance in the selected shared-code stack and native locked surfaces?"
    - "Can each claimed device start, indicate, stop, and durably save while locked without exposing private content?"
    - "Will at least 90% of factual AI draft statements cite supporting transcript segments with zero reversed negations?"
    - "Will target users create threads and begin meaningful actions without study reminders?"
  next_decision: "Run 9 gate after research: approve one monetization model, one activation metric, one retention metric, and the first three growth experiments."
```
