# Run 2 batch 2: design and native craft

This batch analyzes Flowmino, Dayloop, and PitchLab. All three won the
RevenueCat Design Award, which used the same two formal criteria in 2024 and
2025: innovative ideas and aesthetics. Each winner is paired with a same-year
iOS control that also demonstrates native technology or high visual craft.

## Flowmino

**Historical award:** 2024 RevenueCat Design, first place.

**Matched control:** FoxyFocus, a 2024 iOS focus and study timer built with
SwiftUI, Core Data, CloudKit, ambient audio, Lottie, Live Activities, app
blocking, insights, and achievements. Both target attention protection and use
motion, blocking, and native iOS behavior. FoxyFocus is a strong control for
the claim that animation, mascots, app blocking, or feature polish alone
distinguished Flowmino.

### 1. Track interpretation

The original rubric asked whether the app introduced innovative technology or
design and whether it was delightful through art, animation, and gesture-based
interaction. Flowmino treated those dimensions as one system. It joined a
spatial day planner to a deliberate transition into app blocking, then used
motion, haptics, and time feedback to make the state change understandable.

The app emphasized one integrated job and cut other features. It ignored
calendar sync, multi-device reach, analytics, and some accessibility work at
submission. FoxyFocus covered more familiar focus-app features and a stronger
gamification layer, but the evidence does not show the same planner-to-blocker
causal sequence.

### 2. Product thesis

| Element | Flowmino | FoxyFocus control |
|---|---|---|
| Audience | People who procrastinate and have not adopted a planning system | Students and workers who already understand focus timers |
| Trigger | A day needs planning or a time block is about to begin | A study or work session is starting |
| Pain | Time blocking feels tedious and app blockers feel cluttered | Focus is hard to sustain and timers feel sterile |
| Workaround | Separate calendar or planner plus Screen Time or blocker | Pomodoro timer, ambient playlist, and manual self-control |
| Job | Plan what matters, commit to the present block, and protect attention | Complete focus cycles with motivation and feedback |
| Promise | Make time for important work, remove distraction, and see the day | Focus with a friendly companion and understand progress |
| Wedge | Planner and blocker become one continuous interaction | Fox mascot, achievements, soundscapes, and insights |
| Founder insight | Two self-described procrastinators found existing planners tedious and blockers cluttered | A Pomodoro tool could feel less stressful through a companion |

### 3. Core loop

Flowmino begins with a blank or partially planned day. The user adds blocks,
drags them into order, changes duration with a handle, and zooms to see the
whole day. At a block's start, **Tap to enter flow** creates the commitment
moment. Selected distracting apps become blocked, elapsed and remaining time
are visible, and ending flow returns the user to the day. The finished block
and progress through the schedule provide feedback and repeat motivation.

FoxyFocus begins with selecting a timer and ambient sound, then runs focus and
break cycles, updates achievements and insights, and returns through a mascot
and rewards. Its loop is proven and familiar, but planning remains outside the
core experience.

### 4. Journey

Flowmino's acquisition promise is two products in one without the usual
clutter. First launch must teach time-block manipulation, Screen Time selection,
and the difference between planning and flow. Permission timing is critical:
the Screen Time picker should follow a clear explanation and a user-initiated
blocking action. The video demonstrates day preview, full planner, drag,
duration resize, zoom, entering flow, blocked apps, temporary unblocking, and
ending the session.

First value can be a visually organized day; deeper value requires completing
a protected block. Repeat use is daily. The paywall, purchase, restore,
cancellation, empty day, overlapping block, interrupted session, picker crash,
and authorization-revoked paths are not fully visible. The builder described
softening the unstable Activity Picker through UX error handling.

FoxyFocus has an easier first launch because Pomodoro is known. It introduces
more settings, sounds, achievements, and insights, which increase choice before
focus.

### 5. UI and interaction

Flowmino's architecture centers on one vertical timeline. A compact preview
sits at the bottom of the current activity screen; tapping expands the planner.
Blocks can be dragged and resized, and a zoom control reveals the full day. A
single large button changes the system into a flow state.

**Predicted attention map, not analytics:** First fixation is likely the current
activity and the **Tap to enter flow** action. In the planner, the scan follows
the chronological column, then duration handles and the zoom icon. The primary
actions are add, drag, resize, and enter flow; secondary actions are zoom,
temporary unblock, and end. Bottom placement supports thumb reach. Dragging and
resizing are visible in the demo but may need handles or onboarding for
discoverability. Attention conflict is low because the interface suppresses
secondary controls during flow.

FoxyFocus uses a sheet-like sound selector with large icon tiles, a volume
slider, and orange selection. It is clear and native-looking, but a long grid
of sounds and multiple focus extras create higher decision density.

### 6. Visual system

Flowmino uses a nearly monochrome white, black, and gray system with a black
icon and fine gray line work. The visual restraint lets shape, motion, and
state carry meaning. Large negative space and thin typography create calm, but
very light gray labels may reduce contrast. The app icon uses three rising
white bars on black, which remains distinct at small size. Motion and haptics
are described as functional feedback: entering flow feels like a transition,
not a decorative page change.

FoxyFocus uses warmer orange accents, rounded cards, playful illustrations,
and a mascot. Its visual identity is friendlier and more expressive. This
comparison prevents calling minimalism or animation a winner-only trait.

### 7. UX quality

The planner can provide value in minutes, but blocking requires authorization
and deliberate setup. Combining the jobs reduces app switching and can lower
cognitive load. Risks include fragile Screen Time APIs, accidental schedule
changes through gestures, and blocked-app recovery. The submission explicitly
acknowledges error handling around picker crashes. Accessibility, reduced
motion, VoiceOver, keyboard alternatives to drag, and color contrast were not
demonstrated.

FoxyFocus has more visible motivational options and ambient sound controls,
but the accumulation of timer, blocker, sounds, achievements, live activities,
and insights can work against the stated focus goal.

### 8. Monetization

Flowmino integrated RevenueCat, but the reviewed contemporaneous evidence does
not reveal price, trial, free limits, paywall timing, or package differences.
A defensible boundary would preserve basic planning and charge for advanced
blocking, analytics, or cross-device behavior, but that is an analyst
hypothesis rather than observed history. FoxyFocus's monetization is similarly
under-documented. Neither product supplies strong evidence that payment itself
improved the design.

### 9. Growth and retention

Flowmino's acquisition hook is the merger of planning and attention protection.
Daily planning, active blocks, and visible time use create utility retention.
Calendar integration was highly requested but absent. The team reported UX
research and building in public without a product-use metric. FoxyFocus had a
more conventional Pomodoro acquisition surface and a stronger reward loop, but
also no quantified retention.

### 10. Technical and operational shape

Flowmino used SwiftUI, SwiftData, Screen Time frameworks, and RevenueCat. Most
state can remain local, but Screen Time entitlements, picker stability, OS
changes, background timing, and live-activity behavior increase release risk.
The planned iCloud and calendar integrations would add sync and conflict
handling.

FoxyFocus used Core Data, CloudKit, AVAudioPlayer, Lottie, app blocking, and
Live Activities. It has more feature dependencies; Flowmino's smaller scope is
more exposed to one unstable platform API.

### 11. Submission craft

The demo uses two builders and follows the product's causal order: problem,
plan, manipulate time, commit, block, temporarily unblock, and finish. That arc
makes the design judge-observable. The Devpost text adds the research and API
recovery story. The extracted still image is an abstract feature diagram and is
less persuasive than the working video.

FoxyFocus's Devpost shows more feature screenshots and a mascot, but the story
is a list of capabilities rather than one transformation. Both submissions are
visually polished.

### 12. Rubric mapping

Scores are analyst estimates, not judges' actual scores.

| Criterion | Flowmino evidence | Counterevidence | Score | Control score | Confidence |
|---|---|---|---:|---:|---|
| Innovative ideas | Timeline planning directly triggers native app blocking; drag, resize, zoom, and flow transition form one system | Time blocking and app blocking already existed separately | 4 | 3 | High |
| Aesthetics | Restrained hierarchy, meaningful motion, haptics, and low decision density | Contrast, reduced-motion, and accessibility evidence incomplete | 5 | 4 | Medium-high |

### What the evidence supports

Flowmino's strongest design evidence is coherence: the interaction, animation,
haptic feedback, native capability, and error recovery all reinforce the same
transition from intention to protected work.

### What remains unknown

Pricing, conversion, long-term planning behavior, Screen Time reliability,
calendar conflict handling, accessibility, reduced motion, and retention remain
unknown.

### What may transfer to 2026

Use native capability only when it closes the core loop, and show the state
change directly in the demo. The control shows that more polish and more
features do not automatically create a more coherent experience.

## Dayloop

**Historical award:** 2025 RevenueCat Design, first place.

**Matched control:** Mood Dial for Apple Music, a 2025 native iOS and iPadOS app
using MusicKit, HealthKit, State of Mind, SwiftUI animation, CloudKit, and
RevenueCat. Both center the product on a distinctive direct-manipulation object
and native Apple frameworks. Mood Dial is a strong control for novelty and
visual ambition.

### 1. Track interpretation

Dayloop treated the Design Award as removal of product delay. A timelapse app
normally asks users to return for days before anything compelling exists.
Photo import and automatic face alignment let a new user experience the result
in the first session. Ghost Photo, a time scrubber, local processing, and export
then extend that value.

The submission emphasized the working artifact and technical compromises. It
did not choose one narrow audience, disclose event-period adoption, or show all
accessibility and failure states. Mood Dial also used a memorable object and
native data, so a dial or novel gesture by itself is not a winner-only trait.

### 2. Product thesis

| Element | Dayloop | Mood Dial control |
|---|---|---|
| Audience | People documenting faces, bodies, pregnancy, skin, plants, or other visual change | Apple Music listeners who want music matched to the moment |
| Trigger | Existing progress photos or a desire to start a visual record | A need for energy, focus, calm, or emotional fit |
| Pain | Repeated framing and editing make timelapses tedious; value arrives late | Searching playlists creates choice overload |
| Workaround | Camera roll, manual alignment, video editor, or specialist app | Search Apple Music, reuse playlists, or skip repeatedly |
| Job | Turn scattered images into a smooth progress story | Start a fitting personalized stream with little thought |
| Promise | Create a satisfying everyday timelapse without editing skill | Spin a mood and press play |
| Wedge | Import plus Vision-based auto-alignment creates immediate magic | A tactile dial translates mood and context into music |
| Founder insight | A mole-tracking utility generalized into body and selfie progress | Existing music discovery did not reflect shifting emotional needs |

### 3. Core loop

Dayloop's trigger is an existing photo set or a scheduled capture. The user
imports images, chooses or aligns the subject, scrubs through time, captures a
new frame with Ghost Photo, and exports a video. The aligned transformation is
the value moment. Daily reminders and new visual change create repeat use; the
export is the share object and likely monetization point.

Mood Dial's loop is rotate to a mood, press play, listen, adjust, and return
when context changes. Custom dials expand ownership. It delivers value faster
but depends on recommendation quality and Apple Music access.

### 4. Journey

Dayloop's store and social acquisition can be niche-specific even though the
product is broad. First launch must explain photo privacy and request Photos or
camera access. A strong first-value path is import existing images, detect a
face, review alignment, and scrub the result before asking for a daily habit.
The demo is music-only, so the visual sequence must carry onboarding and
interaction meaning.

Repeat use is capture, compare, and eventually export. The reviewed export
screen shows playback speed, direction, date display, watermark removal, and a
large export action. Recovery must address missing faces, multiple people,
wrong orientation, memory pressure, denied permissions, export failure, and
deleted source photos. The builder described several technical failures but
not every UI state.

Mood Dial's first launch has more data and service permissions: Apple Music,
HealthKit, State of Mind, and possibly network. That increases setup before its
otherwise simple dial.

### 5. UI and interaction

Dayloop's architecture revolves around projects, an image timeline, a playful
scrubber, camera overlay, alignment, and export. The export screen is a dark
modal with a large preview, labeled options, native switches, and one dominant
blue action.

**Predicted attention map, not analytics:** In creation, first fixation is the
face or transforming subject, then the scrubber. In export, the preview comes
first, followed by playback speed and the **Export** button. The primary actions
are import or capture, scrub, and export; secondary actions are alignment and
output options. The main button is thumb-reachable. Scrubbing and Ghost Photo
are conceptually discoverable through movement but may require demonstration.
Settings are restrained until export.

Mood Dial's large central wheel is immediately focal. Its scan path moves
around mood labels, then to the playback card. The wheel is memorable, but the
iPad evidence shows low-contrast labels and a large amount of space. Health-
driven recommendations are not visible in the primary screen.

### 6. Visual system

Dayloop uses a dark, near-black canvas, white text, bright blue primary actions,
orange for selected option values and date overlay, and green for native on
states. Large media remains dominant. Typography is system-like and readable.
The design resembles a focused creative tool rather than a social template app.
The submitted screenshot uses strong negative space and a single device.

Mood Dial uses a context-colored red gradient, a large shaded wheel, muted
white labels, and circular playback controls. The design is distinctive, but
some secondary labels have weak contrast. Both products use one physical
metaphor; Dayloop's metaphor maps directly to the output artifact.

### 7. UX quality

Dayloop's import feature reduces time to first value to a builder-described
under one minute. Local-only photo handling supports privacy. Cognitive load is
staged: import or capture first, output controls later. Image processing creates
loading and error risk; progress indicators, cancellation, and memory recovery
are not visible. Mole tracking was founder inspiration, but the product must
avoid implying diagnosis or medical monitoring accuracy.

Mood Dial can be one-spin simple after permissions. Health and State of Mind
data increase sensitivity, while music mismatch creates a lower-consequence but
frequent trust failure. Both need strong denied-permission paths.

### 8. Monetization

Dayloop used RevenueCat subscriptions. The export screenshot visibly includes
**Remove watermark**, which is a plausible paid boundary, but the exact gating,
price, trial, and paywall timing are not recovered. Charging at export aligns
payment with a completed artifact if free users can first preview value.

Mood Dial exposes an in-app-purchase screen in its submission, but price and
package content were not extracted. Apple Music subscription dependence can
complicate the user's perception of paying twice.

### 9. Growth and retention

Dayloop's output is inherently shareable, while reminders support the capture
habit. The builder planned niche-specific short-form content, custom product
pages, regional pricing, and UGC only after the event. No event-period metric
is disclosed. Mood Dial has daily context changes and custom-dial sharing as
possible retention and growth loops, but social features were still roadmap.

### 10. Technical and operational shape

Dayloop used Swift, SwiftUI, some UIKit, SwiftData, Vision, AVFoundation,
Core Image, concurrency, camera, and local storage. Cost can remain low because
photos stay on device. Performance, orientation, coordinate conversion, memory,
and export reliability are the primary risks.

Mood Dial used SwiftUI, MusicKit, HealthKit, State of Mind, Core Data,
CloudKit, and a small backend. It rebuilt after a late July pivot. Its ongoing
risks include MusicKit search limits, recommendation quality, privacy, service
availability, and entitlement complexity.

### 11. Submission craft

Dayloop's music-only demo is a design reel rather than a narrated case. The
Devpost story supplies the missing logic: founder evolution, market review,
technical compromises, copy changes, and the import feature that solved delayed
value. Screenshot sequencing shows direct product screens rather than abstract
marketing claims. Proof is strongest for visible craft and weakest for usage.

Mood Dial's submission is longer and deeply explains the pivot and technology.
Its visual evidence is ambitious on both iPhone and iPad. Dayloop communicates
its finished transformation more economically.

### 12. Rubric mapping

| Criterion | Dayloop evidence | Counterevidence | Score | Control score | Confidence |
|---|---|---|---:|---:|---|
| Innovative ideas | Import, auto face alignment, Ghost Photo, and temporal scrubbing remove delayed value | Individual mechanisms have precedents in photo and timelapse tools | 5 | 5 | High |
| Aesthetics | Media-first hierarchy, restrained controls, satisfying temporal interaction, and coherent export | Accessibility, contrast, and error-state coverage incomplete | 5 | 4 | Medium-high |

### What the evidence supports

Dayloop's central design achievement was not only visual polish. It changed the
activation model so a new user could experience the finished transformation in
the first session.

### What remains unknown

User counts, completion and export rates, exact subscription packaging,
watermark behavior, reminder retention, accessibility, multi-face accuracy, and
long-term media reliability remain unknown.

### What may transfer to 2026

If a product's natural payoff is delayed, build an honest preview or import path
that creates first-session value. The control shows that a memorable control
surface and native API breadth are not sufficient differentiators by
themselves.

## PitchLab

**Historical award:** 2025 RevenueCat Design, third place.

**Matched control:** Challengrs, a 2025 native iOS fitness game using SwiftUI,
UIKit, CoreML, Supabase, OneSignal, and RevenueCat. Both apply computer vision
to physical activity, translate model output into action, and need users to
trust automated classification. PitchLab targets professional measurement;
Challengrs targets accountability and game fairness.

### 1. Track interpretation

PitchLab interpreted design innovation as making specialized measurement
available through a device already in a player's pocket. Its interface then
translated real-time computer vision into familiar bullpen review, video,
tracer, charts, and lists. The product emphasized technical novelty, founder
authority, and professional utility more than decorative aesthetics.

The submission ignored detailed price, paywall, calibration, device support,
failure recovery, and independent validation. Challengrs also used a custom
CoreML model and a polished native interface. The more defensible difference is
the novelty and consequence of PitchLab's measurement, not the mere use of ML.

### 2. Product thesis

| Element | PitchLab | Challengrs control |
|---|---|---|
| Audience | Pitchers, coaches, facilities, colleges, and professional teams | Friend groups running fitness challenges |
| Trigger | A bullpen or training throw | A scheduled workout and challenge check-in |
| Pain | Radar systems cost thousands and require dedicated hardware | Group chats and notes make scoring slow, messy, and easy to cheat |
| Workaround | Trackman, Rapsodo, radar guns, manual video, or no data | Photo posts plus a human scorekeeper |
| Job | Get immediate velocity, movement, spin, and location feedback | Prove activity, update points, and remain competitive |
| Promise | Professional-grade pitch analysis using one iPhone camera | Make fitness a fair, motivating game |
| Wedge | Single-camera full-flight reconstruction in real time | CoreML photo verification plus catch-up mechanics |
| Founder insight | Ten years as a professional pitcher showed the career value and access gap | The founder personally operated recurring group challenges |

### 3. Core loop

PitchLab starts when a pitcher positions the phone and throws. The app detects
the pitch, tracks ball flight, returns near-instant metrics, and later lets the
user replay with a tracer, swipe to charts, inspect a list, edit, or export.
Immediate feedback is the value moment. Training creates repeated sessions;
videos and metrics can be shared with coaches. Subscription access occurs
around professional analytics or storage.

Challengrs starts with a challenge and workout. A user captures proof, CoreML
accepts or rejects it, points and streaks update, and the leaderboard changes.
Friends and bonus days create repeat pressure. Its core loop is socially richer
but the model verifies a broad category rather than measuring physics.

### 4. Journey

PitchLab can acquire through baseball facilities, athlete networks, search, and
demonstration content. First launch must explain camera placement, field setup,
device capability, and safety. It then needs camera permission and possibly an
account or cloud choice. First value requires a successful detected throw and
credible result.

The video demonstrates real-time capture, automatic detection, replay, tracer,
chart swipes, and list view. Recovery paths include missed detection, wrong
pitch classification, poor lighting, occlusion, unsupported camera position,
thermal throttling, model confidence, calibration, and offline or upload
failure. These are not fully visible. Challengrs must recover from false proof
rejection and adversarial cheating, a useful comparison for trust design.

### 5. UI and interaction

PitchLab uses a live capture view, post-session summary, video player, tracer,
chart pages, and a dense pitch list. The list shows velocity, induced vertical
break, horizontal break, active spin, spin axis, time, and pitch-type badges.

**Predicted attention map, not analytics:** During capture, fixation should stay
on status and the latest result. In review, the largest velocity value receives
first attention, followed by pitch number and color-coded type. Horizontal
swipes reveal charts and lists, which the narrated demo makes discoverable but
static screens may not. Primary actions are start session, throw, and review;
secondary actions are star, compare, share, delete, edit, and export. Dense
metrics increase expert efficiency but raise novice cognitive load.

Challengrs' visual evidence uses black, gray, bright green, yellow achievement
icons, a heatmap, and stat cards. It has a clearer motivational hierarchy and a
lower-density outcome surface.

### 6. Visual system

PitchLab uses black as the analysis canvas, white high-contrast metrics, red for
delete and store emphasis, blue for standard actions, yellow or teal pitch-type
badges, and compact system typography. The aesthetic resembles a professional
sports instrument. Information density is deliberate, but small labels and
color-dependent pitch tags need accessibility testing.

Challengrs uses a gaming-fitness dark theme, neon green emphasis, large
motivation copy, and modular cards. It is more emotionally branded; PitchLab is
more instrument-like and domain-native.

### 7. UX quality

Time to first value depends on setup and model success. Once calibrated, near-
instant feedback is a strong value moment. Trust requires confidence,
comparison conditions, device model, calibration, and editability. The
submission gives average errors but not sample size, hardware mix, test design,
or independent replication. Safety matters if athletes change training based
on incorrect readings.

Challengrs explicitly considered rest-day limits, sensitive content, database
security, and catch-up fairness. Its model can still reject legitimate workouts
or be gamed. Both products need a respectful correction path rather than
presenting ML output as unquestionable.

### 8. Monetization

PitchLab used RevenueCat subscriptions, Firebase, cloud storage, and Stripe, but
the reviewed submission does not disclose free value, price, trial, package,
or paywall placement. The expensive hardware alternative gives a credible
reference price, but that does not prove willingness to pay for a phone-based
measurement.

Challengrs also used subscriptions without disclosing its package. Its social
and verification infrastructure creates ongoing cost, but the paid boundary is
not judge-visible.

### 9. Growth and retention

PitchLab reported 300+ beta testers, 200+ monthly active users, an athlete video
with about 20,000 Instagram views, and use by several colleges, facilities, and
MLB teams. These are builder-reported. Training history, coach dashboards,
affiliate facilities, and team expansion support retention and distribution.

Challengrs had an inherent friend invite and leaderboard loop but disclosed no
adoption metric. It planned global leaderboards and further interaction. The
comparison supports founder insight and a strong loop as similarities, while
PitchLab has more visible adoption and domain-channel leverage.

### 10. Technical and operational shape

PitchLab combined a custom deep-learning tracker, single-camera 3D physics,
CoreML at up to 60 fps, high-bitrate video, SwiftUI, Firebase, PostHog,
RevenueCat, Stripe, and cloud storage. Costs include video, model development,
support, data labeling, device testing, thermal performance, and accuracy
validation. The product was developed over nearly two years; the event-period
artifact was the qualifying first store release, not a two-month invention.

Challengrs used a broader full-stack social system with Supabase, OneSignal,
CoreML, and complex scoring rules. It is operationally complex in moderation
and multiplayer consistency, even though its inference task is simpler.

### 11. Submission craft

PitchLab's Devpost opens with four concrete visual surfaces: playback, capture,
charts, and list. Its founder story creates authority and explains the $20,000
alternative. The demo shows an actual throw and near-instant feedback before
review features. Metrics and accuracy claims are visible, but validation is
compressed and partly compared against a separate external equipment study.

Challengrs tells a detailed workaround and fairness story and shows a polished
progress surface. It lacks PitchLab's adoption and validation claims. Both make
the technology observable rather than treating AI as a label.

### 12. Rubric mapping

| Criterion | PitchLab evidence | Counterevidence | Score | Control score | Confidence |
|---|---|---|---:|---:|---|
| Innovative ideas | Real-time single-camera tracking, 3D reconstruction, and professional metrics on-device | Accuracy study is builder-run and the product predates the event development window | 5 | 4 | High for mechanism; medium for accuracy |
| Aesthetics | Domain-native capture, tracer, charts, dense list, and clear metric hierarchy | Expert density, accessibility, calibration, and error states are under-shown | 4 | 4 | Medium-high |

### What the evidence supports

PitchLab combined unusually ambitious on-device computation with a review
experience that maps to an established professional workflow. Founder expertise
and early institutional use made the interface claims more credible.

### What remains unknown

Independent accuracy, sample construction, device coverage, price, conversion,
paywall, calibration, offline behavior, privacy, injury risk, thermal limits,
and whether every cited organization used the event-period version remain
unknown.

### What may transfer to 2026

Technical novelty transfers when the demo connects it to a user's real decision
and exposes a credible result. The control shows that CoreML and polished stats
are not differentiators without validation and a distinctive job.

## Batch evidence and uncertainty ledger

| Source | Date | Tier | Timing | Use | Confidence |
|---|---|---|---|---|---|
| [2024 rules](https://revenuecat-ship-a-ton.devpost.com/rules) | 2024 event | A | Contemporaneous | Flowmino rubric | High |
| [2025 rules](https://revenuecat-shipaton-2025.devpost.com/rules) | 2025 event | A | Contemporaneous | Dayloop and PitchLab rubric | High |
| [Flowmino Devpost](https://devpost.com/software/flowmino) and [demo](https://www.youtube.com/watch?v=UxS9razsRlw) | 2024 event | B | Contemporaneous | Journey, interaction, stack, trade-offs | High |
| [Dayloop Devpost](https://devpost.com/software/dayloop-everyday-timelapse) and [demo](https://www.youtube.com/watch?v=vGQ2Mi9RiFc) | 2025 event | B | Contemporaneous | Product, visible craft, first-value claim | High for description; medium for timing claim |
| [PitchLab Devpost](https://devpost.com/software/pitchlab) and [demo](https://www.youtube.com/watch?v=gZITndtsZbo) | 2025 event | B | Contemporaneous | Product, metrics, adoption, visual workflow | Medium-high |
| [FoxyFocus control](https://devpost.com/software/foxyfocus-focus-study-timer) | 2024 event | B | Contemporaneous | Same-platform focus and design control | High for description; low for outcomes |
| [Mood Dial control](https://devpost.com/software/mood-dial-for-apple-music) | 2025 event | B | Contemporaneous | Same-platform interaction and native-API control | High for description; low for outcomes |
| [Challengrs control](https://devpost.com/software/challengrs) | 2025 event | B | Contemporaneous | Same-platform CoreML and physical-activity control | High for description; low for outcomes |
| Devpost screenshot assets extracted with Firecrawl and inspected with vision | Observed August 9, 2026 | B | Contemporaneous submission media | Visual systems and predicted attention | Medium-high |
| [Tread Athletics equipment comparison](https://www.youtube.com/watch?v=SUtdthPSUdI) | April 25, 2023 | C | Pre-event, external | Context for alternative hardware | Medium; not direct PitchLab validation |

## Batch contradictions and missing evidence

PitchLab describes nearly two years of product development even though the
event required a qualifying first store release during the window; it must be
treated as an event-period release, not a two-month build. Its comparison with
Rapsodo combines a builder test dataset with a separate third-party equipment
study. Dayloop's sub-minute value claim is builder-described, and its public
video transcript contains only music. Flowmino's paywall and accessibility
state remain unrecovered. All three controls are visibly polished, so aesthetics
alone cannot be called a winner differentiator.

## Batch recommendation

Carry forward, without synthesizing yet, the candidate observations of
first-session value, interaction-to-job coherence, visible error recovery, and
domain-valid proof. Test each against later batches and matched controls before
calling it a cross-corpus pattern.

## Next steps

Continue with Batch 3: Meshing, Gurwi, Echo Reminder, and Tomo Japan. Do not
select patterns until all five batches are complete.
