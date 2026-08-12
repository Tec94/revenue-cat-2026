# Restart Thread — Forward Thread design system

**Direction:** H2 — Forward Thread  
**Signature interaction:** I2-V1 — Direct Trace-back Connector  
**Status:** Visual direction locked; final logo candidate and exact display
typeface remain unresolved.  
**Reference:** [`design/reference/forward-thread-prototype.png`](./design/reference/forward-thread-prototype.png)

This document translates the supplied static prototype into an implementation-
ready semantic system. It reconciles the image with the accepted Run 8 visual
specification and Run 12 handoff. It does not claim that inferred pixels,
motion, haptics, or sound were measured from the image.

## Evidence labels

- **Observed:** directly visible or printed in the supplied board.
- **Specified:** already locked in the accepted research reports.
- **Reconstructed:** a practical implementation starting value inferred from
  the composition; tune it against rendered devices without changing its role.
- **Conditional:** must pass accessibility, platform, policy, or physical-
  device testing before it becomes a product claim.

## 1. Visual theme and atmosphere

Forward Thread is **editorial, calm, high-contrast, and physically decisive**.
The design treats interrupted context as something recoverable—not as failure.
The emotional principle is **continuity without shame**: preserve the user's
thread, show the evidence, and support one chosen move forward.

The visual grammar combines:

- warm paper and dense ink for clarity and trust;
- one editorial red for user-controlled action, focus, and trace;
- a dominant dot representing the user's present state;
- interrupted dots representing context that was paused but not lost;
- a forward arrow representing one action chosen by the user;
- strong serif display typography with quiet system-sans controls;
- mostly flat editorial surfaces; and
- tactile depth reserved for the one primary action.

This is not a wellness gradient, task-board game, AI assistant, emergency app,
or productivity streak system. Avoid neon, glass, sparkles, celebration loops,
diagnostic imagery, microphones as the primary logo, confetti, badges, and
shame-based progress language.

## 2. Logo system

### Symbol meaning

| Element | Meaning | Rule |
|---|---|---|
| Interrupted dots | Context preserved across interruption | Keep subordinate to the present-state dot |
| Large dot | “Where I am now” | Always the strongest mass and likely first fixation |
| Open boundary | An interrupted thought with room to continue | Do not close it into a refresh or completion loop |
| Forward arrow/notch | One user-confirmed next action | Do not detach it so far that it becomes a generic media-play icon |

The logo communicates the product thesis, not the capture method. It must not
encode ADHD, therapy, urgency, diagnosis, AI magic, recording, or gamification.

### Extracted SVGs

| Asset | Role | Status |
|---|---|---|
| [`mark-01-open-thread.svg`](./design/assets/logos/mark-01-open-thread.svg) | Most complete context → present → forward story | Primary large-format candidate; not formally selected |
| [`mark-02-corner-thread.svg`](./design/assets/logos/mark-02-corner-thread.svg) | Quieter boundary with balanced mass | App-icon candidate |
| [`mark-03-split-boundary.svg`](./design/assets/logos/mark-03-split-boundary.svg) | Bold editorial boundary | Store-art candidate; highest crop/focus ambiguity |
| [`mark-04-compact-forward.svg`](./design/assets/logos/mark-04-compact-forward.svg) | Minimal context → present → forward sequence | Small-size and generic locked-surface candidate |
| [`wordmark-stacked-editable.svg`](./design/assets/logos/wordmark-stacked-editable.svg) | Two-line editorial wordmark | Typeface category observed; exact font unknown |
| [`lockup-horizontal-editable.svg`](./design/assets/logos/lockup-horizontal-editable.svg) | Derived symbol/wordmark lockup | Editable, not outlined production art |

Use one color per mark. Default to Ink on Paper, Paper on Ink, or the semantic
action color when the mark represents an active state. Do not shade, bevel, or
animate the logo itself. The tactile treatment belongs to controls.

Before choosing the permanent icon, test the candidates in monochrome, Android
themed icons, the required store icon, launcher rendering, and the generic
locked surface. Also run similarity checks because open boundaries can resemble
crop/focus marks and detached arrows can resemble media controls.

## 3. Color palette and roles

The board prints the light palette directly; the accepted A4 specification
defines the matching dark roles.

| Semantic role | Light | Dark | Use |
|---|---|---|---|
| Surface | Paper `#FAFAF7` | Dark Surface `#0D0D0D` | App, board, and locked-surface ground |
| Text primary | Ink `#111111` | Warm paper text `#F7F7F2` | Headlines, transcript, action |
| Text secondary | Gray `#545454` | Muted paper `#BDBDB5` | Metadata, labels, waveform |
| Action/focus | Action Red `#A91D3A` | Dark Accent `#FF8298` | Primary action, evidence trace, focus |
| On action | White `#FFFFFF` | Deep red ink `#3A0612` | Filled-action content |

Source sRGB WCAG 2.2 checks from Run 8:

| Pair | Light ratio | Dark ratio |
|---|---:|---:|
| Primary text / surface | 18.06:1 | 18.09:1 |
| Secondary text / surface | 7.24:1 | 10.28:1 |
| Action / surface | 6.87:1 | 8.24:1 |
| On-action text / action | 7.18:1 | 7.33:1 |

These checks cover source colors, not every rendered state. Recheck after
Material/HCT conversion, opacity, disabled treatment, platform dimming,
translucency, dynamic color, or device color management. Increased-contrast
tokens are required but were not numerically defined by the prototype; derive
them from the rendered pair rather than inventing a blind inversion.

### Color semantics

- Red means **user-controlled action, focus, selection, or trace**.
- Give one peer action the filled red treatment in each decision context.
- Red does not silently mean error. Errors require an error icon and explicit
  label, and should use their own semantic token after validation.
- Status never depends on hue alone; pair it with text, shape, or iconography.
- Android dynamic color is optional only after semantic meaning and contrast
  survive remapping. It does not replace brand red by default.

## 4. Typography

The prototype shows a high-contrast editorial serif for `Restart Thread` and a
neutral system sans for controls and evidence. The exact serif file is unknown.
Use the platform serif or verified licensed display face until font license,
file size, weights, language coverage, and scaling are proven. Do not infer an
exact font name from a generated raster.

| Role | Android starting style | Behavior |
|---|---|---|
| Display/store promise | 40/44 sp, bold serif or bold system | Short, balanced lines only |
| Screen title | 28/34 sp, bold serif or semibold system | Editorial opening; may use system sans on urgent paths |
| First action | 24/31 sp, semibold system sans | Strongest in-app action statement |
| Deck/summary | 17/24 sp, medium system sans | One sentence under a heading |
| Body/transcript | 16/25 sp, regular system sans | Natural wrapping; selectable evidence |
| Label/source | 13/18 sp, semibold system sans | Source, time, state; tabular when numeric |
| Timer | 34/40 sp, medium system sans | Tabular numerals; stable width |

Use Roboto or the active Android system sans. Apply the serif sparingly to the
brand, screen openings, store scenes, and share artifacts; it must never slow
the capture or evidence scan path.

Typography behavior:

- Headings wrap deliberately; evidence and transcript wrap naturally.
- Keep recovery-plan measure near 45–68 characters when space permits.
- Do not truncate the first action or evidence without an expansion path.
- Use tabular numerals for recording time and other changing values.
- Test 200% text, Android font scaling, RTL, mixed-direction transcripts, CJK,
  and label expansion. The evidence connector must reflow with content.
- Preserve a system-sans fallback for any script unsupported by the display
  serif; never synthesize unreadable decorative glyphs.

## 5. Geometry, layout, and depth

### Foundation

- Use a 4 dp typographic baseline and 8 dp component rhythm.
- Use 20–24 dp phone margins and a narrower reading column on large screens.
- Use square to 8 dp corners for editorial evidence surfaces.
- Separate sections with whitespace and rules instead of nested cards.
- Keep **Start here** above the fold and place evidence immediately after it or
  in the adjacent pane.
- Use no glass, background blur, or decorative glow.
- Keep secondary surfaces nearly flat. Depth is a scarce emphasis token.

### Primary tactile action

The **Start here** button is the only deliberately raised object. Its visual
metaphor is a quiet physical key: clearly pressable, substantial, and calm—not
a toy, prize, or skeuomorphic control panel.

#### Anatomy

| Layer | Specification | Evidence |
|---|---|---|
| Container | Full available action width, minimum 48 dp target | Platform requirement/specification |
| Face | Semantic action fill; subtle light-to-base tonal shading | Observed |
| Top edge | One restrained highlight line | Observed/reconstructed |
| Contact edge | Crisp darker-red underlay below the face | Observed |
| Ambient depth | Soft dark halo behind the contact edge | Observed |
| Shape | Broad rectangle with approximately 12 dp corners | Reconstructed starting value |
| Leading node | High-contrast circular present-state marker | Observed |
| Label | Semibold sans, vertically centered | Observed/specification |
| Trailing affordance | Simple forward chevron | Observed |

Starting reconstruction values are recorded in
[`design/tokens/design-tokens.json`](./design/tokens/design-tokens.json): a 56 dp visual
height, 7 dp resting contact edge, 5 dp downward press travel, and 2 dp pressed
edge. These are not pixel measurements from source code. Tune them on target
hardware while preserving the relationship: **the face moves toward the base
and the contact shadow collapses**.

#### States

**Rest**

- Face sits above its dark-red contact edge.
- Keep the gradient tonal, not glossy; no specular hotspot or glass reflection.
- The white/dark on-action content remains the highest local contrast.
- Use an ambient shadow only to separate the raised object from the dark app
  surface; do not float unrelated cards.

**Press down**

- Begin feedback immediately within the 80–120 ms press family.
- Translate the face down and collapse most of the contact edge.
- Slightly reduce the top highlight and ambient shadow.
- Keep scale effectively stable; avoid a bouncy or gummy deformation.
- Android ripple remains clipped inside the face and must not erase the dot,
  label, or chevron.

**Release/activate**

- Restore elevation if the gesture cancels or leaves the target.
- On accepted activation, finish the short visual press before or with the
  state transition; never delay the action until decorative motion finishes.
- Confirmation belongs to the committed state, not merely pointer-down.

**Disabled/unavailable**

- Do not present a convincingly raised red key that cannot act.
- Remove strong elevation, use a neutral surface, retain readable explanation,
  and expose the disabled state programmatically.

### Secondary controls

`Why this?` is an outlined, low-height evidence control: dark/transparent
surface, thin action-red border, short label, and little or no elevation. It
must not compete with **Start here**. Evidence panels are dark editorial cards
with a thin neutral rule and source text; selected source text gains a red
outline/underline plus a `Source` label.

## 6. I2-V1 Direct Trace-back Connector

The signature interaction makes AI provenance visible without turning the
screen into a graph.

### State sequence

1. **Initial:** a large node anchors **Start here**. A short dotted segment
   visually associates the voice note and action. The source excerpt remains
   collapsed.
2. **Request:** the user taps **Why this?**. The control enters a clear selected
   state; nothing triggers automatically.
3. **Reveal:** one direct dotted path extends from the action to one highlighted
   source phrase. The source panel opens and identifies itself as `Source`.
4. **Review:** the user can inspect, edit, or return. Evidence remains the
   user's unchanged words; assumptions must be separately labeled.
5. **Reduced motion:** show the final static connector and source immediately,
   or use a short opacity crossfade. Do not draw or travel along the path.

### Visual rules

- Use a single route, not branches, particles, networks, or animated model
  reasoning.
- The route is dotted in the same semantic red as action/focus.
- Keep the path subordinate to action and evidence text.
- Move the connector around content; never draw through readable text.
- The source label, container, and text highlight carry the meaning even if the
  connector cannot render at large text or in assistive layouts.
- Source and action remain linked by stable IDs in implementation; the path is
  a presentation of that relationship, not the relationship itself.

## 7. Lock-screen continuity

The locked-surface design is a privacy-safe relative of the in-app system, not
a pixel-identical phone screen.

- Use Dark Surface, a thin neutral capsule outline, the compact mark, generic
  `Recording` status, tabular timer, and a familiar stop control.
- Use the large dot/mark as continuity, not a transcript preview.
- Never show transcript, source, task, proposed action, or project identity
  while locked by default.
- Recording start, stop, local save, and unlock fallback must follow platform
  behavior and physical-device proof. The prototype does not prove universal
  no-unlock recording.
- The stop control uses action color and a clear stop glyph; color alone is not
  the state cue.

## 8. Motion

Motion explains cause, continuity, and readiness. It never fills AI latency or
turns recovery into spectacle.

| Family | Timing | Use |
|---|---:|---|
| Press | 80–120 ms | Button face travel, contact-shadow collapse |
| Local state | 160–220 ms | Saved, selected, source-panel state |
| Short spatial | 220–280 ms | Direct connector or nearby layout continuity |

- Use ease-out for entrance and ease-in for exit.
- The tactile button and Trace-back reveal use no decorative spring.
- Animate one focal element at a time.
- Start from the current rendered state and accept interruption.
- Local durable save completes before any ready reveal.
- Reduced motion removes path drawing, scaling, and travel while preserving the
  final relationship and programmatic announcement.

## 9. Haptics and sound

A static image cannot contain sound or haptics. The following sensory language
comes from the accepted Run 8 system and the hybrid of A4 editorial restraint
with A3 tactile depth.

### Tactile feel

- The button should feel like a restrained physical key: firm travel, crisp
  bottoming-out, no wobble, bounce, elastic overshoot, or reward-like snap.
- Use a platform confirmation haptic only after the activation is accepted.
- A durable-save success cue may occur only after encrypted local commit.
- Every tactile cue remains optional and has visual plus programmatic feedback.

### Sound character

- Default is quiet.
- If user testing supports a save cue, use one dry **soft page tap** with a hint
  of the A3 wooden-click material—short, warm, and without reverb or a loop.
- Do not attach a sound to routine press-down, scrolling, source comparison, AI
  token arrival, or connector drawing.
- Never play a custom sound or continuous haptic while the microphone is
  active. Start cues must finish before capture and physical tests must rule out
  microphone artifacts.
- Respect silent mode, Do Not Disturb, system volume/output routing, and an
  in-app sensory preference. Do not interrupt audio from another app.

No audio file is extracted because the source is a static image and the prior
specification defines a character, not an approved recording.

## 10. Platform adaptation

### Android and Galaxy

- Build the interface with Material behavior—ripple, predictive back, system
  microphone indicators, scalable type, and TalkBack—inside the editorial
  visual layer.
- Keep controls in reachable lower zones without moving evidence away from its
  action.
- Preserve state across resize, multi-window, fold, posture, and process death.
- On a fold, source and action may become adjacent readable columns; never draw
  the trace through a hinge.
- Use the same semantic tokens for Play and Galaxy. Samsung-specific adaptation
  changes layout and platform behavior, not brand meaning.

### Later Apple/Mac adaptation

- Use semantic colors, native text selection, Dynamic Type, familiar sheets,
  and system haptics.
- Keep editorial two-column behavior on wide Mac windows rather than stretching
  a phone layout.
- Treat Lock Screen and Always-On presentation as platform-controlled relatives.

## 11. Accessibility contract

- Preserve 48 dp minimum Android touch targets.
- Keep text in `sp`; pass Android font scaling and 200% text review.
- Supply TalkBack names, roles, states, and live announcements for save, reveal,
  and confirmed Start.
- Use logical focus order: title → evidence summary → primary action → Why this?
  → revealed source → edit/confirm controls.
- Pair every color state with text, shape, icon, or border treatment.
- Keep focus visible against both paper and dark surfaces.
- Do not make gesture, motion, haptic, or sound the only route or cue.
- Keep transcript/evidence selectable and expandable.
- Recalculate contrast in light, dark, increased contrast, dimmed locked state,
  and every composited/elevated state.
- Under reduced motion, use the static connector and instant/crossfade states.

## 12. Implementation and QA checklist

Before a component becomes the system reference:

- [ ] Map raw values through semantic tokens instead of scattering hex colors.
- [ ] Render the primary button at rest, press, cancel, activation, loading,
      disabled, dark, light, increased contrast, and large text.
- [ ] Verify the face visibly moves and contact edge collapses without layout
      movement or a delayed action.
- [ ] Confirm no custom sound or haptic contaminates recording.
- [ ] Confirm local save before success haptic, sound, or ready state.
- [ ] Reflow Trace-back at compact, expanded, fold, RTL, mixed-direction, and
      200% text states.
- [ ] Verify TalkBack exposes the evidence relation without relying on the path.
- [ ] Verify the generic locked state on each claimed physical device.
- [ ] Test every logo candidate in monochrome and required store/launcher
      contexts before selecting permanent artwork.
- [ ] Outline and license the final wordmark font before immutable export.

## 13. Known uncertainties

- The exact serif family and font metrics are unknown.
- Logo cell 01 is not a recorded final selection; all four remain candidates.
- Button pixel dimensions, gradient stops, and shadow blur are reconstructed
  because the image has no source layout or style metadata.
- The optional page-tap/wood-click sound is a character direction, not an audio
  asset or validated preference.
- Increased-contrast palette values still require platform derivation and
  measurement.
- Physical Galaxy lock-screen recording, haptics, audio contamination, fold
  continuity, and store presentation remain unproven.
