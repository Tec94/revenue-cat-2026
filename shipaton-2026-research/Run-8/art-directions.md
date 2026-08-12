# Restart Thread art-direction specifications

This artifact defines five coherent ways Restart Thread can look, move, sound,
and feel without changing the selected Instant Voice Thread flow. Each direction
uses original brand primitives and extracts only transferable principles from
the references in [source-ledger.csv](./source-ledger.csv).

## How to read the specifications

Color values are prototype source tokens. The OKLCH value is the design-authoring
reference, and the hex value is its sRGB implementation sample. Android Material
HCT roles, Apple semantic asset variants, Galaxy widgets, increased-contrast
variants, and composited states require a new rendered-pair check.

The type sizes are starting specifications, not user-behavior thresholds.
Android values use `sp`; Apple implementations use the corresponding Dynamic
Type text style and preserve the relative hierarchy. Every direction allows
larger text, RTL, mixed-direction transcripts, and language-specific fallbacks.

The motion ranges are shared prototypes:

- press response: 80–120 ms;
- local state change: 160–220 ms;
- short spatial transition: 220–280 ms;
- direct-manipulation settle: critically damped, with a response near 280 ms and
  no decorative overshoot.

Reduced motion replaces spatial travel, scale, or path drawing with a static
state change or short opacity crossfade. No interaction waits for animation to
finish.

## A1 — Quiet Instrument

Quiet Instrument treats Restart Thread like a trusted pocket tool rather than a
coach, game, or wellness companion. It supports the emotion **“I can recover
without being judged or stimulated.”** Its visual restraint gives the user's
words and the first action priority.

### Reference principles

The direction combines Apple Voice Memos' one-control capture principle, Tiimo's
flexible restart language, Headspace's predictable low-pressure choice, and
Flowmino's historical use of restraint to let state and motion carry meaning.
It does not copy their palettes, controls, illustrations, or layouts.

### Semantic color system

Warm near-neutral surfaces reduce glare while green-blue action colors avoid a
clinical or alarm-like mood. Green never means success by itself; the success
state also uses a check icon and explicit label.

| Role | Light | Dark | Use |
|---|---|---|---|
| Surface | `oklch(0.970 0.007 88.6)` / `#F7F5F0` | `oklch(0.198 0.010 173.0)` / `#111715` | App background |
| Text primary | `oklch(0.234 0.013 170.4)` / `#18201D` | `oklch(0.967 0.004 157.2)` / `#F2F5F3` | Transcript, action, titles |
| Text secondary | `oklch(0.457 0.020 167.7)` / `#4D5B55` | `oklch(0.802 0.013 164.7)` / `#B7C1BC` | Metadata and reassurance |
| Action and focus | `oklch(0.487 0.085 180.7)` / `#0B6F62` | `oklch(0.790 0.102 181.0)` / `#66D0BE` | Record, confirm, focus perimeter |
| On action | `oklch(1.000 0.000 89.9)` / `#FFFFFF` | `oklch(0.273 0.044 182.9)` / `#062E29` | Action labels and symbols |

The light primary text, secondary text, action, and on-action pairs calculate to
15.26:1, 6.55:1, 5.56:1, and 6.06:1. Their dark equivalents calculate to
16.53:1, 9.82:1, 9.79:1, and 7.92:1. The complete checks are in
[color-contrast.csv](./color-contrast.csv).

Color-blind resilience comes from shape and language. Capture is a filled circle
plus **Recording**; saved is a check in a rounded square plus **Voice thread
saved**; AI work is a small progress mark plus **Drafting recovery**; ready is a
document mark plus **Draft ready**.

### Typography

Quiet Instrument uses the platform system family throughout. Slightly generous
body leading and medium-weight action labels create calm without fragile light
type.

| Role | Android starting style | Apple starting style | Behavior |
|---|---|---|---|
| Display | 32/38, medium | Large Title | Used only for empty-state or store promise |
| Screen title | 24/30, medium | Title 2 | One line when possible; wraps without truncation |
| First action | 20/28, medium | Title 3, semibold | Highest content priority |
| Body and transcript | 16/24, regular | Body | Selectable, 45–68 character measure when space permits |
| Label | 14/20, medium | Subheadline | Natural case; no all-caps utility labels |
| Caption and evidence ID | 12/16, regular | Footnote | Never the only presentation of evidence |
| Timer | 32/38, medium, tabular | Title 1, monospaced digits | Stable elapsed-value width |

The direction uses one family, two common weights, and no display font. It is
the safest option for localization and app size.

### Shape, spacing, density, and surfaces

The shape language is softly mechanical: rounded rectangles with 16–20 dp
corners, circular recording controls, and straight dividers. It avoids bubbles,
clouds, characters, and organic blobs that could imply therapy or emotion
classification.

- Use an 8 dp macro rhythm and 4 dp internal alignment.
- Give the critical in-app screen 20 dp phone margins; use platform insets and
  the Galaxy 24 dp edge-safe adaptation where required.
- Keep capture sparse: status, elapsed time, stop, and cancel or discard access.
- Keep the draft medium-density: **You said**, **Start here**, later steps, and
  rationale on demand.
- Use tonal surfaces rather than blur for core content. Elevation is reserved
  for a modal edit or destructive confirmation.
- Use a quiet 1 px or platform-equivalent divider only when spacing can't show
  the relationship.

### Iconography, illustration, and data display

Icons use the active platform's filled or rounded system family. Custom icons
cover only the thread mark and evidence citation. Illustration is limited to
empty-state line art with no people, brains, clocks with faces, or diagnostic
symbols.

The recording signal uses amplitude bars only as a microphone-activity cue. It
doesn't encode mood, confidence, urgency, or transcript quality. Confidence uses
plain language and an info disclosure, not a colored meter.

### App icon and store screenshots

The app icon is an open bracket surrounding a single offset dot. The gap means
“a thread can be resumed,” while the dot means “start here.” It must remain
legible in monochrome, themed Android icons, small Galaxy contexts, and Apple
dark or tinted treatments.

The store sequence begins with one calm promise, then shows capture, durable
save, grounded draft, and user confirmation. Warm negative space and a single
green-blue action make the core state obvious. No private transcript appears in
a locked-screen marketing scene.

### I1 — Signal Settle

While recording, short amplitude bars respond to the microphone. After the user
stops and the file commits locally, the bars settle into one horizontal rule
beneath **Voice thread saved**. When the draft becomes ready, that same rule
appears beneath **Start here**, establishing continuity without pretending the
audio literally became an action.

- Start feedback is immediate; recording motion begins only after the microphone
  state is active.
- Stop freezes the signal before local save feedback.
- The settle runs once as a 180–220 ms transform-and-opacity transition.
- AI readiness is a separate 180–220 ms reveal after the saved state.
- Reduced motion shows a static signal, saved rule, and first-action rule.
- TalkBack and VoiceOver announce the state label, not the decorative signal.

### Motion, haptics, and sound

Motion uses ease-out opacity and short vertical changes. It avoids parallax,
looping breathing, elastic bounce, or full-screen shifts. Pressed controls use a
subtle scale within 0.98–1.00 and retain platform ripple or highlight.

Use a platform selection or impact cue only after verifying that it doesn't
enter the recording. Durable save may use a short success haptic after the audio
file is closed. First-action confirmation may use the same causal family at a
slightly stronger system-defined level. Haptics are optional.

Custom sound is off by default. If enabled, durable save uses a brief, low-
brightness wood or paper-like tick after recording stops. AI-ready produces no
sound unless the user explicitly requested a system notification. Silent and Do
Not Disturb behavior remains authoritative.

### Platform adaptation

Android uses Material surfaces and controls, visible ripple, predictive back,
and the static brand palette. A dynamic-color option can remap the action role
only after contrast and meaning survive. Galaxy uses a large **Start here**
focus block in the lower interaction area, with context above. Unfolded devices
show transcript and action in separate panes without stretching either column.

iOS uses system text styles, semantic colors, familiar recording controls, and
materials only for floating chrome. The Lock Screen uses the bracket-dot mark
and generic state. Mac uses a compact sidebar and detail layout with no oversized
record button when pointer input is primary.

### Accessibility and implementation risks

Quiet Instrument has the lowest accessibility risk, but its muted palette must
not become low contrast after transparency or dynamic color. The subtle signal
may be missed if it is too thin, so required graphical lines meet 3:1 and state
labels remain present.

Implementation is straightforward with system components and vector shapes.
The main risk is brand genericness: without exact spacing, typography, and state
craft, it can look like a default notes app. Its calm language also risks being
mistaken for a wellness product, so copy remains functional and nonclinical.

### RevenueCat Design evidence

The innovative idea is modest: the same restrained signal clarifies capture,
save, and readiness. Aesthetics depend on restraint, exact hierarchy, and both
appearances. Delight is a sense of relief, not a reward effect. Gesture quality
comes from familiar tap and edit controls. Feedback is strong because local save
and AI readiness are visibly separate. The demo can show I1, failure recovery,
large text, and a Galaxy two-pane layout without requiring narration.

## A2 — Thread & Trace

Thread & Trace makes provenance the product's visual identity. It supports the
emotion **“I understand where this first step came from, and I remain in
control.”** The motif is a thin route with distinct state nodes, never a ribbon,
timeline planner, or decorative tangle.

### Reference principles

The direction extracts Spotify Wrapped's idea that one graphic principle can
unify many touchpoints, Strava's user-controlled sharing, Monument Valley's
meaningful manipulation, and Dayloop's historical focus on making the value
moment visible. It explicitly rejects Spotify's ribbon, symbols, gradients,
campaign energy, type, and layouts.

### Semantic color system

Cool violet gives the evidence grammar a distinctive but serious tone. Accent
color marks actions and connectors; node shape and labels carry their meanings.

| Role | Light | Dark | Use |
|---|---|---|---|
| Surface | `oklch(0.977 0.012 296.4)` / `#F8F6FF` | `oklch(0.194 0.030 292.5)` / `#151221` | App background |
| Text primary | `oklch(0.239 0.047 295.5)` / `#211A33` | `oklch(0.968 0.018 300.1)` / `#F6F2FF` | User words and action |
| Text secondary | `oklch(0.457 0.042 301.2)` / `#5B526B` | `oklch(0.785 0.036 301.9)` / `#BDB4CD` | Metadata and questions |
| Action, evidence, focus | `oklch(0.476 0.191 286.3)` / `#5A3FC0` | `oklch(0.775 0.126 293.0)` / `#B9A6FF` | Primary action, connector, focus |
| On action | `oklch(1.000 0.000 89.9)` / `#FFFFFF` | `oklch(0.223 0.079 287.9)` / `#1B123D` | Action labels and symbols |

The light pairs calculate to 15.57:1, 6.85:1, 6.75:1, and 7.22:1. The dark
pairs calculate to 16.72:1, 9.27:1, 8.74:1, and 8.30:1. Evidence nodes use
distinct shapes: circle for captured statement, diamond for explicit assumption,
open square for question, and filled rounded square for confirmed action.

### Typography

Thread & Trace uses system type, with stronger title-action contrast and small
source labels that remain readable. It never uses monospaced body copy to make
AI feel technical.

| Role | Android starting style | Apple starting style | Behavior |
|---|---|---|---|
| Display | 36/40, semibold | Large Title, bold | Store promise and first-run empty state only |
| Screen title | 24/30, semibold | Title 2 | Aligns to the first route node |
| First action | 22/30, semibold | Title 2, semibold | Dominant content and editable |
| Body and transcript | 16/24, regular | Body | Evidence phrases remain selectable |
| Evidence label | 13/18, medium | Footnote, semibold | Includes “From your voice note” or “Assumption” |
| Utility label | 14/20, medium | Subheadline | Specific verbs such as “Show evidence” |
| Timer | 32/38, medium, tabular | Title 1, monospaced digits | Stable capture status |

Source-node labels may use slightly positive tracking at caption size, but body
copy remains naturally tracked. The connector never substitutes for a heading
or accessible relationship.

### Shape, spacing, density, and surfaces

The visual grammar uses one thin route, compact nodes, 12–16 dp corners, and
nearly flat surfaces. The line connects related states; it never wanders behind
unrelated content.

- Use an 8 dp macro rhythm, 4 dp evidence alignment, and 20 dp phone margins.
- Give every node at least a 24 dp visual field inside a 48 dp Android or
  comfortable Apple hit target when interactive.
- Keep one visible route per screen. Multiple competing connectors create a
  diagram, not an interface.
- Use surface containers for **You said** and **Start here**; later steps stay
  visually subordinate.
- Use elevation only when transcript evidence overlays the draft. Prefer a
  two-pane relationship on large screens.
- Keep the connector behind text and stop it before the hinge or crease.

### Iconography, illustration, and data display

The custom icon set contains five primitives: open thread, captured node,
question node, assumption node, and confirmed node. All other controls use
Material Symbols or SF Symbols. Nodes have text equivalents and accessible
names.

There is no character art. Optional store imagery uses abstract cropped lines
and nodes derived from the actual evidence relationship. Confidence is shown as
text such as **High confidence** with a disclosure explaining the basis; line
thickness and color don't encode confidence.

### App icon and store screenshots

The app icon is a broken route joined by one centered node. The negative space
is large enough to survive monochrome and small-size rendering. It does not use
a ribbon, loop, or multiple embedded symbols.

The store story uses the route as a reading guide through the actual value
chain: **Capture before the thought disappears**, **Saved before AI begins**,
**See the step and its evidence**, and **Edit before you act**. Galaxy assets
show the same route spanning list and detail panes without crossing the fold.

### I2 — Trace-back Reveal

The ready draft places a visible **Why this?** control beneath **Start here**.
Activating it reveals a short connector from the action card to one or more
quoted transcript segments. On a phone, the route appears within the draft and
the evidence expands directly below. On a large screen, the connector aligns
the action in the detail pane with highlighted evidence in the transcript pane.

- The control is a normal button with an accessible expanded or collapsed state.
- The route draws once over 220–260 ms while evidence fades in.
- If evidence is offscreen, the interface scrolls only after user activation,
  preserves focus, and offers **Back to first action**.
- Selecting a node highlights its transcript phrase and exposes **Correct
  transcript** or **Edit first action**.
- Assumptions use a diamond and explicit **Assumption** label. Questions use an
  open square and explicit question text.
- Reduced motion shows the connector and evidence instantly or with a short
  crossfade. Screen readers announce the evidence relationship and move focus
  only when the user requested expansion.
- Press-and-hold may preview a source on supported touch platforms, but tap and
  keyboard activation remain complete equivalents.

### Motion, haptics, and sound

Node transitions use opacity, stroke reveal, and small position changes. The
route never loops. A new state appears at the end nearest its cause, so spatial
direction remains consistent. Back or collapse reverses the same path.

Use a short selection haptic when the user intentionally moves between evidence
nodes, and a system confirmation haptic only when they confirm the first action.
Don't haptically tick during line drawing or transcript scrolling. Verify every
cue against microphone and Android hardware behavior.

Sound is absent during capture, trace reveal, and AI work. Optional durable-save
feedback uses one quiet click after the audio session closes. A notification
may announce **Draft ready** through system channels when the user opted in.

### Platform adaptation

Android uses Material containers, ripple, predictive back, and a route rendered
as a lightweight vector or Canvas layer behind semantic content. Avoid an
animation library when a small native or WebView vector implementation can meet
the behavior. Dynamic color can tint secondary containers, but action and
evidence roles must remain distinct.

Galaxy compact mode keeps the route vertical and one-handed. Fold and tablet
mode place transcript on the first pane and draft on the second; a route segment
ends at each pane edge rather than crossing the physical hinge. Flex mode keeps
evidence above and confirmation below only if the posture API and physical test
prove it improves the same task.

iOS uses semantic colors, system text, and standard disclosure behavior. The
Lock Screen shows only the broken-route mark and generic state, never evidence.
Mac uses list-detail layout, keyboard traversal between nodes, and visible focus
perimeters.

### Accessibility and implementation risks

The main accessibility risk is treating the route as the relationship. The DOM,
Compose semantics, or native accessibility tree must state which transcript
segments support each action. Nodes, labels, and source order remain meaningful
when the line is absent.

Large text can force evidence far from its action. The implementation must
switch from side-by-side to stacked content before connectors collide or cross
text. Color-vision simulation isn't enough; test grayscale, increased contrast,
forced color where applicable, and screen-reader navigation.

The main implementation risk is path geometry across a Capacitor WebView,
native widget, and adaptive layouts. Treat continuity as a repeated brand
grammar rather than attempting one literal cross-surface morph. The signature
can ship with simple local coordinates and no server or animation dependency.

### RevenueCat Design evidence

The innovative idea is the interaction between a grounded AI action and its
user-authored evidence. Aesthetics come from a coherent node, route, surface,
and type system. Delight is the moment uncertainty becomes inspectable. Gesture
quality is ordinary and reliable rather than showy. Feedback is explicit across
capture, save, AI, evidence, edit, and confirmation. The demo can show the full
causal chain, reduced motion, large text, and Galaxy adaptation in motion.

## A3 — Tactile Relay

Tactile Relay frames recovery as a small handoff from “what I was holding” to
“what I can do now.” It supports the emotion **“This is manageable, and I can
physically take the next step.”** The direction borrows the legibility of
physical objects without adding scores, collections, construction, or a game
economy.

### Reference principles

The direction extracts Monument Valley's principle that touch can reveal the
meaning of a visual model, Llama Life's focus on one active item, and Flowmino's
historical alignment of gesture, haptic, and state. It does not copy geometry,
characters, confetti, timer layouts, or planning surfaces.

### Semantic color system

Warm clay and cream make the tiles feel tactile without becoming a cartoon.
Shape, position, and labels distinguish captured, proposed, and confirmed states.

| Role | Light | Dark | Use |
|---|---|---|---|
| Surface | `oklch(0.982 0.015 77.1)` / `#FFF8EE` | `oklch(0.204 0.013 67.0)` / `#1B1611` | App background |
| Text primary | `oklch(0.255 0.021 66.6)` / `#2A2118` | `oklch(0.973 0.020 70.0)` / `#FFF4E8` | Task and transcript text |
| Text secondary | `oklch(0.457 0.030 65.0)` / `#635446` | `oklch(0.801 0.030 69.1)` / `#CBBBAA` | Metadata and reassurance |
| Action and focus | `oklch(0.491 0.130 44.9)` / `#9A4313` | `oklch(0.827 0.114 56.8)` / `#FFB37B` | Active dock, confirm, focus |
| On action | `oklch(1.000 0.000 89.9)` / `#FFFFFF` | `oklch(0.247 0.046 51.2)` / `#321A0B` | Filled tile labels |

The light pairs calculate to 14.98:1, 6.90:1, 6.25:1, and 6.59:1. The dark
pairs calculate to 16.55:1, 9.60:1, 10.25:1, and 9.30:1. Proposed tiles use a
dashed leading edge and **Draft** label; confirmed tiles use a solid leading
edge and **Your first action** label.

### Typography

Tactile Relay uses a friendly system sans with slightly larger labels and strong
verb-first action text. It avoids playful display type that would make a serious
interruption feel juvenile.

| Role | Android starting style | Apple starting style | Behavior |
|---|---|---|---|
| Display | 34/40, bold | Large Title, bold | Store and empty-state promise |
| Screen title | 24/30, semibold | Title 2 | Compact and direct |
| First-action tile | 20/26, semibold | Title 3, semibold | Begins with a verb when the user approves it |
| Body and transcript | 17/25, regular | Body | Slightly larger than dense productivity UI |
| Tile metadata | 14/20, medium | Subheadline | Wraps below the action; never overlays it |
| Caption | 12/16, regular | Footnote | Source and status labels |
| Timer | 32/38, bold, tabular | Title 1, monospaced digits | Stable capture value |

The first-action tile has no fixed height. It expands for large text, language
growth, and multiple lines without pushing its confirm control offscreen.

### Shape, spacing, density, and surfaces

The direction uses 18 dp rounded tiles, 2–4 dp visual offsets, and one active
dock. Shadows are short, opaque, and structural rather than blurry. A tile looks
movable only when moving it serves the flow.

- Use an 8 dp grid and 16–20 dp phone margins, plus Galaxy edge-safe margins.
- Stack only the first action and the visible later-step preview in the critical
  viewport; the rest remains behind **See later steps**.
- Use one elevated tile at a time. Competing raised cards would create a kanban
  board and violate the product boundary.
- Keep **You said** flat and **Start here** tactile so the intended handoff is
  legible.
- Use a bottom active dock inside thumb reach, with clear text and a tap target
  independent of the visual tile edge.

### Iconography, illustration, and data display

Custom icons are interlocking tile corners, a source notch, and a confirmed
check. All other symbols come from the platform. Empty states may use two
abstract offset pieces; no house, pet, collectible, badge, coin, or streak art
appears.

Changing values use tabular numerals. Progress is a labeled state, not a filling
block that implies AI percentage accuracy.

### App icon and store screenshots

The icon uses two offset rounded pieces joined at one corner. In monochrome, the
negative-space seam remains visible. It must not resemble a toy-block brand or
construction game.

Store screenshots show a handoff sequence: verbal state, saved note, one draft
tile, and the user placing or tapping that tile into the active dock. A second
scene shows tap-only and large-text equivalents so the gesture doesn't appear
mandatory.

### I3 — First Tile Snap

The AI draft presents **Start here** as one proposed tile. The user can tap
**Make this my first action** or drag the tile into an active dock. The tile
tracks the finger one-to-one, respects the grab offset, and returns to its
source if the user cancels. A successful placement changes the tile label from
**Draft** to **Your first action**.

- Tap is the default and complete interaction.
- Drag begins only after a movement threshold and never competes with vertical
  scrolling without clear intent arbitration.
- The tile carries release velocity into a critically damped settle; it doesn't
  bounce like a reward.
- The dock previews its target state and announces **Drop to make this your first
  action**.
- A selection haptic occurs at target acquisition and a confirmation haptic only
  after the state commits.
- Undo restores the draft and focus without losing edits.
- Reduced motion uses the tap path and a static before-and-after state.
- Switch Access, keyboard, TalkBack, and VoiceOver expose explicit move or
  confirm actions.

### Motion, haptics, and sound

Tiles respond on press with subtle depth and scale within 0.98–1.00. Drag motion
is direct and interruptible. Non-drag transitions use short fades and vertical
placement changes. Only the active tile moves prominently.

Use Android action-oriented haptics or Apple system feedback. Don't implement a
custom rich pattern until capability and fallback behavior are known. The drag
is fully usable with haptics disabled.

Sound remains off during recording and tile motion. An optional soft wooden
click may accompany successful placement after user testing, but it must respect
silent mode and have simultaneous visual and haptic-independent confirmation.

### Platform adaptation

Android uses Material cards, ripple, drag semantics, predictive back, and a
bottom action region. Galaxy Fold uses transcript and proposed action in two
panes, but the user doesn't drag across the hinge. Flex mode can place the draft
above and the action dock below when physically validated.

iOS uses standard drag previews only if they don't delay the tap path. The Lock
Screen never displays a private tile. iPadOS and Mac can support pointer drag,
hover, keyboard move, and undo, but the desktop layout remains a recovery view,
not a board.

### Accessibility and implementation risks

The tile must not imply that drag is required. Focus order follows the reading
order, not visual elevation. Drop targets meet contrast and target-size rules,
and the state change is announced.

Gesture arbitration, scroll conflicts, velocity handoff, accessibility actions,
and fold behavior create the highest implementation burden among the directions.
The visual metaphor can also invite feature sprawl into categories, queues,
points, or collectibles. Those additions are rejected.

### RevenueCat Design evidence

Innovation is a tactile confirmation of the user-controlled AI boundary.
Aesthetics come from consistent material, depth, and action hierarchy. Delight
is a precise snap rather than confetti. Gesture quality is highly observable but
must include cancel, undo, tap, keyboard, and screen-reader equivalents.
Feedback aligns visual target, system haptic, and committed state. The demo can
show direct manipulation and accessibility, but it may spend too much of the
two-minute limit explaining a secondary gesture.

## A4 — Editorial Relay

Editorial Relay treats recovery as an act of careful reduction: a messy spoken
state becomes a concise, attributed first decision. It supports the emotion
**“The noise has been edited into something I can read and trust.”** The
direction is bold in static presentation and restrained in interaction.

### Reference principles

The direction extracts Spotify Wrapped's alignment of art direction with story,
Strava's per-scene share control, and PitchLab's historical use of an
instrument-like hierarchy for dense information. It does not copy Wrapped's
layouts, gradients, imagery, annual recap, or data-story format.

### Semantic color system

High-contrast ink and paper surfaces use a deep red accent for decisive action.
Red never means error unless paired with the error icon and label; the action
role is semantically named and stays consistent.

| Role | Light | Dark | Use |
|---|---|---|---|
| Surface | `oklch(0.984 0.004 106.5)` / `#FAFAF7` | `oklch(0.159 0.000 89.9)` / `#0D0D0D` | Paper or ink background |
| Text primary | `oklch(0.178 0.000 89.9)` / `#111111` | `oklch(0.975 0.007 106.5)` / `#F7F7F2` | Headlines, transcript, action |
| Text secondary | `oklch(0.446 0.000 89.9)` / `#545454` | `oklch(0.796 0.011 106.6)` / `#BDBDB5` | Captions and metadata |
| Action and focus | `oklch(0.480 0.173 16.3)` / `#A91D3A` | `oklch(0.753 0.153 10.3)` / `#FF8298` | Primary action, edit mark, focus |
| On action | `oklch(1.000 0.000 89.9)` / `#FFFFFF` | `oklch(0.231 0.080 13.1)` / `#3A0612` | Filled action labels |

The light pairs calculate to 18.06:1, 7.24:1, 6.87:1, and 7.18:1. The dark
pairs calculate to 18.09:1, 10.28:1, 8.24:1, and 7.33:1. Quote, assumption,
question, and confirmed-action states use typographic labels and line styles in
addition to color.

### Typography

Editorial Relay is the only direction that may use a serif display face. Android
and Apple system sans remain the body and control family. A serif is packaged
only after license, file size, weight, Dynamic Type, and target-language coverage
are verified; otherwise use the platform serif or system sans.

| Role | Android starting style | Apple starting style | Behavior |
|---|---|---|---|
| Display | 40/44, serif or bold system | Large Title, serif or bold system | Store promise and share artifact only |
| Screen title | 28/34, serif or semibold system | Title 1 | Editorial section opening |
| First action | 24/31, semibold sans | Title 2, semibold | Strongest in-app headline |
| Body and transcript | 16/25, regular sans | Body | Comfortable reading and selection |
| Deck or summary | 17/24, medium sans | Callout | One sentence under a heading |
| Label and folio | 13/18, semibold, tabular where numeric | Footnote | Source, time, and state |
| Timer | 34/40, medium, tabular | Title 1, monospaced digits | Stable capture value |

Headings use balanced wrapping; transcript and rationale use natural wrapping.
No essential text is baked into a store image or decorative composition.

### Shape, spacing, density, and surfaces

The direction uses square to 8 dp corners, strong rules, wide margins, and a
clear baseline. It has the least card-based appearance.

- Use a 4 dp typographic baseline and 8 dp component rhythm.
- Use 20–24 dp phone margins and a narrower readable text column on large
  screens.
- Separate sections with space and rules, not nested cards.
- Keep the first action above the fold and place evidence immediately after it
  or in the adjacent pane.
- Use no blur and minimal shadow. Modals use system surfaces and a clear scrim.
- Preserve ample bottom space around the primary action for one-handed access.

### Iconography, illustration, and data display

Icons are crisp, low-detail system symbols. Custom marks include an open quote,
an edit caret, and a forward cut mark. Photography is absent from the app and
optional only in marketing when it doesn't imply a specific diagnosis or user.

Data visualization is editorial: quoted evidence, source labels, and structured
assumptions. It doesn't use charts or sentiment scores. Share artifacts redact
private content by default and preview exactly what will leave the app.

### App icon and store screenshots

The icon combines an open quote shape with a forward notch, with no letters or
words. It must remain distinct from reading, news, quotation, and transcription
apps at small size.

Store screenshots use strong headlines and cropped app states. Each scene has
one claim and one visible proof. A share card may show a user-approved generic
recovery statement, but never exports transcript or project data by default.

### I4 — The Cut

The ready draft first shows the concise action and its attributed source. Tapping
**Compare with what I said** switches in place to the relevant transcript
segments with preserved source labels. The return action is **Back to first
action**. The transition resembles an editorial cut, not words being erased.

- Content crossfades in place over 180–220 ms with stable container height when
  possible.
- The user's original transcript remains available and unchanged.
- Assumptions are inserted as visibly labeled editorial notes, never blended
  into quoted text.
- Edit opens the first action inline with the source still visible.
- Reduced motion switches instantly while moving focus to the requested view.
- Screen readers receive explicit view names and state changes; the visual cut
  isn't the only cue.

### Motion, haptics, and sound

Motion uses crisp crossfades, mask reveals for nonessential store or demo
moments, and no spring. Text doesn't fly, scatter, or reassemble. Editing
feedback uses the system caret and selection behavior.

Use a crisp system selection haptic for switching source and draft only after
testing; it may be unnecessary. Confirming the first action can use a standard
success cue. There is no custom sound during capture, comparison, or editing.
An optional save sound resembles a soft page tap, not a typewriter loop.

### Platform adaptation

Android uses Material controls and ripple inside an editorial content layer.
Galaxy viewing and interaction areas map naturally: headline and source context
above, comparison and confirm controls below. Fold layouts show source on the
left and action on the right with independent readable columns.

iOS uses native text selection, sheets, semantic colors, and system typography
unless the display face passes all tests. Mac benefits most from the editorial
two-column layout, keyboard comparison shortcut, and pointer selection. Locked
surfaces use only the quote-notch mark and generic state.

### Accessibility and implementation risks

The main accessibility risks are display-font coverage, overlarge headings,
horizontal density, and ambiguous red semantics. Use system body text, preserve
headings under large text, pair the action color with shape and label, and
provide a non-red error system distinct by icon and message.

The implementation is moderate. Crossfade and type hierarchy are simple, but a
custom font adds size, license, rendering, and localization work. The art
direction can also make the app feel like a summarizer or writing tool rather
than an interruption-recovery utility.

### RevenueCat Design evidence

Innovation is the attributed editorial comparison between AI draft and user
source. Aesthetics are the direction's strength: disciplined type, spacing,
rules, and store composition. Delight is the clarity of the cut. Gesture quality
is conventional. Feedback remains strong if source and draft states are clearly
named. Animation is intentionally restrained, which can read as taste but offers
less motion evidence than A2 or A3.

## A5 — Night Beacon

Night Beacon gives the user one reliable point of orientation during an
interruption. It supports the emotion **“Even in a fragmented or low-light
moment, I can capture this and find it again.”** The direction is dark-first but
not dark-only.

### Reference principles

The direction extracts Apple Live Activities' glanceability and privacy,
Samsung One UI's dark focus blocks and reachable interaction areas, Voice
Memos' visible recording state, and Tiimo's glanceable widget principle. It does
not copy Dynamic Island, Samsung system UI, Voice Memos' red control, or Tiimo's
widget composition.

### Semantic color system

Deep blue-black surfaces reduce OLED bloom, while cyan provides a cool signal.
The light appearance remains fully designed and isn't a reversed afterthought.

| Role | Light | Dark | Use |
|---|---|---|---|
| Surface | `oklch(0.973 0.010 212.5)` / `#EFF8FA` | `oklch(0.186 0.023 227.3)` / `#07151B` | App and widget background |
| Text primary | `oklch(0.226 0.028 219.8)` / `#0B1F25` | `oklch(0.982 0.012 223.5)` / `#F1FBFF` | State and action text |
| Text secondary | `oklch(0.473 0.030 218.4)` / `#496067` | `oklch(0.818 0.024 224.9)` / `#B4C7CF` | Metadata and reassurance |
| Action, signal, focus | `oklch(0.485 0.083 204.9)` / `#006C75` | `oklch(0.838 0.106 199.1)` / `#6ADFE4` | Record, ready marker, focus |
| On action | `oklch(1.000 0.000 89.9)` / `#FFFFFF` | `oklch(0.269 0.044 207.2)` / `#032C31` | Filled action labels |

The light pairs calculate to 15.75:1, 6.18:1, 5.73:1, and 6.17:1. The dark
pairs calculate to 17.65:1, 10.61:1, 11.74:1, and 9.43:1. A ring plus state
label distinguishes recording, a filled dot plus check distinguishes saved, and
an open beacon plus document mark distinguishes ready.

### Typography

Night Beacon uses a compact, high-legibility system sans with heavier small
text for Lock Screen and Always-On contexts. It never uses thin glowing type.

| Role | Android starting style | Apple starting style | Behavior |
|---|---|---|---|
| Display | 32/38, bold | Large Title, bold | Store promise only |
| Screen title | 24/30, semibold | Title 2 | Compact and high contrast |
| First action | 22/30, semibold | Title 2, semibold | Clear against dark surface |
| Body and transcript | 17/25, regular | Body | No low-opacity body text |
| Locked state | 15/20, semibold | Headline | Generic, glanceable, and private |
| Caption | 13/18, medium | Footnote, medium | Sparse use in dark appearance |
| Timer | 36/42, medium, tabular | Large Title, monospaced digits | Dominant recording value |

The locked state never truncates the essential status. If a localization doesn't
fit, use the shorter approved generic label and keep the full accessible name.

### Shape, spacing, density, and surfaces

The shape system uses circles for active capture, 16 dp rounded focus blocks,
and clean rectangular evidence panels. Glows are avoided in core UI; a crisp
high-contrast ring works better across OLED, dimming, and reduced transparency.

- Use an 8 dp grid and 16–20 dp phone margins, with Galaxy edge-safe adaptation.
- Keep the locked surface to mark, state, timer where allowed, stop, and privacy-
  safe confirmation.
- Use one bright signal per view. Secondary controls remain neutral.
- Use tonal separation, not blur, for the draft. Lock Screen materials remain
  platform-controlled.
- Avoid full-screen black-white flashes when changing appearance or readiness.

### Iconography, illustration, and data display

The custom beacon consists of a ring with one open notch and a centered dot.
System icons handle microphone, stop, close, edit, and evidence. No stars,
radar sweeps, emergency symbols, or mental-health imagery appear.

The ring indicates active state only with a label and system microphone
indicator. It doesn't encode recording quality, urgency, or emotional intensity.

### App icon and store screenshots

The app icon is the open beacon ring with a centered dot. It must avoid looking
like a location service, emergency alert, podcast, or voice assistant. The
monochrome Android icon uses notch geometry, not glow.

Store screenshots contrast a privacy-safe locked capture with the illuminated
ready marker inside the app, then show the grounded first action. Dark screenshots
are paired with a light-appearance scene and an increased-contrast proof so the
brand isn't presented as dark-only.

### I5 — Beacon Handoff

The locked capture surface displays a static open ring around the record control.
During recording, the ring closes and the text changes to **Recording**. After
stop and durable save, the ring becomes a filled dot with **Voice thread saved**.
When the user opens the ready draft, the same dot anchors **Start here**.

- The ring changes once per state; it doesn't continuously sweep or breathe.
- Record and stop use familiar controls and text, not ring gesture recognition.
- Local save completes before the ready marker appears.
- The marker's location adapts across locked, phone, fold, and desktop surfaces;
  it doesn't attempt a literal cross-app morph.
- Reduced motion uses immediate geometry and label changes.
- The accessible name includes state; decorative ring segments are hidden from
  accessibility services.

### Motion, haptics, and sound

Motion uses a 160–220 ms ring closure and dot transition, with no perpetual glow
or radial sweep. A ready draft may use one 180–220 ms opacity reveal. Appearance
changes avoid abrupt full-screen luminance shifts.

A short start haptic is permitted only if it finishes before recording and
physical tests show no microphone artifact. Durable save can use a discrete
system success cue after the file closes. Locked controls honor the platform's
system behavior and user settings.

There is no custom sound during recording. Optional save and error cues use the
system audio category, respect silent mode, and never stop audio from another
app unnecessarily. **Draft ready** uses the notification channel the user chose.

### Platform adaptation

Android uses a dark-capable Material theme, system microphone indicators,
ripple, and glanceable widget states. Galaxy uses One UI dark focus blocks,
interaction controls in the reachable lower area, and fold continuity. Always-
On and lock behavior must be tested on each claimed device.

iOS uses semantic dark and light colors, Lock Screen system materials, Dynamic
Type, and generic Live Activity content. Always-On dimming can change color and
contrast, so the ring and labels require device checks. Mac uses the same beacon
as a compact status mark, not an oversized central control.

### Accessibility and implementation risks

The highest risks are luminance fatigue, OLED bloom, low-light over-saturation,
peripheral pulsing, and meaning hidden in the ring. The static state labels and
no-loop rule mitigate these risks. Test in bright light, low light, grayscale,
increased contrast, reduced motion, reduced transparency, and Always-On dimming.

The implementation is moderate, but platform locked surfaces can constrain
color and animation. The product must treat those surfaces as branded relatives,
not pixel-identical canvases. A dark-first marketing identity may also imply a
night or sleep product that Restart Thread isn't.

### RevenueCat Design evidence

Innovation is cross-surface state continuity under privacy constraints.
Aesthetics are strongest in dark mode and require equally polished light and
contrast variants. Delight is recognizing the same state marker after unlock.
Gesture quality is familiar and low risk. Feedback is highly glanceable.
Animation is purposeful but intentionally brief; the demo must prove privacy,
state separation, and hardware behavior instead of showing a simulated glow.

## Coherence rules for cross-pairing

The decision gate permits one direction and one signature interaction, including
a cross-pair. A cross-pair remains coherent only when it preserves the direction's
emotional goal and doesn't import a second visual grammar.

- I1 can work with A1 or A5 because both use signal-to-ready continuity.
- I2 can work with A1, A2, or A4 because each can present source attribution
  without a second loop.
- I3 belongs with A3. Moving tiles into A1, A2, A4, or A5 changes their spatial
  language and invites task-board scope.
- I4 can work with A2 or A4 if the evidence relationship remains explicit.
- I5 belongs with A5 or a very restrained A1. It conflicts with A4's typographic
  identity and A3's object model.

The recommendation remains **A2 + I2**. The comparison prototype is **A1 + I1**.
