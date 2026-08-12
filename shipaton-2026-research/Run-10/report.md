# Run 10 — platform, architecture, and ship scope

Observed and analyzed August 11, 2026. This run uses August 1 as the accepted
official start and stops at the Run 10 decision gate.

## Executive summary

Build Restart Thread as a **native Kotlin and Jetpack Compose Android app**.
Ship one shared Android codebase through Google Play and, conditionally, Galaxy
Store product flavors. Do not build iOS, macOS, Kotlin Multiplatform, React
Native, or Capacitor before the September 30 deadline.

This is not a general preference for native development. It is the smallest
credible path for this product and award:

- the differentiating work is Android recording, foreground-service, widget,
  keyguard, adaptive, fold, multi-window, purchase, and accessibility behavior;
- RevenueCat officially supports Galaxy in its native Android SDK and React
  Native, while its Android documentation says support for other hybrid SDKs
  is still coming;
- the primary award is RevenueCat Design, not a cross-platform award;
- Android is the builder's local test and deployment environment;
- a second platform would add proof obligations without strengthening the
  selected core loop or primary award before the deadline.

Use the device as the source of truth for every thread. Save and encrypt voice
or text locally before any upload. A thin Supabase Edge Function can proxy one
AI provider and own only quota, event, webhook, feature-flag, and reminder
metadata. No account is required before value. RevenueCat uses its anonymous
user until a future account feature has evidence.

The release must be credible without a universal lock-screen recording promise,
Galaxy approval, OneSignal, referrals, or AI availability. In-app voice, text,
Share, encrypted local history, deterministic recovery, grounded draft with
human confirmation, RevenueCat purchase and restore, accessibility, and a live
store listing form the vertical slice.

The largest risk is store eligibility, not code. A new personal Google Play
account requires at least 12 continuously opted-in closed testers for 14 days
before production-access application. Galaxy requires a Samsung account,
commercial seller status, Seller Portal app registration, and a physical Galaxy
test purchase. Start both paths now. The recommended first production-store
submission target is **Galaxy Store on September 8, 2026**, with Google Play
submission as soon as production access exists and September 11 as the planning
target, not a promised approval date.

## Contract and controlling decisions

The contract for this run is to select the smallest credible technical plan
that can ship the chosen product and demonstrate the RevenueCat Design Award by
September 30. It must also preserve honest conditional evidence for Galaxy and
OneSignal without allowing either secondary award to become a hidden MVP.

The plan carries forward:

- **Product:** R1 Restart Thread, C13 Reset Button plus C14 Breadcrumb;
- **Core flow:** Instant Voice Thread, local save before asynchronous AI;
- **Visual system:** H2 Forward Thread;
- **Signature:** I2-V1 Direct Trace-back Connector;
- **Monetization:** M1 value-first Pro with one `pro` entitlement;
- **Primary metric:** A1 verified Start within two minutes of first draft open;
- **Primary retention:** R1 second distinct verified restart within seven days;
- **Primary award:** RevenueCat Design;
- **Conditional secondaries:** Best App for Galaxy and Keep Them Coming Back.

The [official rules](https://revenuecat-shipaton-2026.devpost.com/rules)
require a working eligible-platform app, a first public release during the
submission period, a fully published eligible-store listing by the deadline,
and at least one RevenueCat-powered purchase or RevenueCat Ads path. The
[judging guide](https://www.shipaton.com/blog/how-we-judge-shipaton) says intake
checks the store link, package or bundle ID, required fields, video, icon, and
screenshots. Prescreeners are required to watch only the first two minutes, so
judge-observable proof is part of the ship scope rather than post-build
marketing.

## Platform and framework decision

The full comparison is in
[architecture-options.csv](./architecture-options.csv).

### Recommended: native Kotlin and Compose

Use Kotlin, Jetpack Compose, Material 3 Adaptive, WindowManager, Room,
Android Keystore, and small platform adapters. Build Play and Galaxy flavors
from one Gradle project.

RevenueCat's current
[Android installation guide](https://www.revenuecat.com/docs/getting-started/installation/android)
shows Android SDK 10.15.1, Google Play support in `purchases`, and Galaxy support
from Android SDK 10.7.0 through `purchases-store-galaxy` and
`GalaxyConfiguration`. It also says Galaxy test purchases require a physical
Galaxy signed into a Samsung account. Exa supplied the full page; a forced-live
Firecrawl extraction independently returned the same details.

The platform choice also aligns with current Android behavior:

- [Material 3 Adaptive](https://developer.android.com/develop/adaptive-apps/guides/get-started-with-adaptive-apps)
  supports window-size-driven panes;
- [WindowManager](https://developer.android.com/develop/adaptive-apps/guides/foldables/make-your-app-fold-aware)
  exposes folds and hinge bounds;
- [multi-window](https://developer.android.com/develop/adaptive-apps/guides/support-multi-window-mode)
  is standard behavior and Android 16 further limits fixed-orientation and
  fixed-resizability assumptions on large screens;
- a user action on a widget can qualify for a background foreground-service
  start, but Android 14+ microphone while-in-use rules still make keyguard and
  OEM behavior a physical proof gate, not a universal promise.

Target API 36 from the first commit. Google requires new apps and updates to
target Android 16, API 36, starting August 31, 2026.

### Rejected now: React Native

RevenueCat officially supports Galaxy in React Native 10.3.0+, so it is a real
alternative rather than a straw man. It loses here because the product's
hardest and most judge-visible surfaces still need Android-native modules:
foreground microphone work, atomic capture recovery, widgets, possible locked
entry, fold posture, multi-window state, store flavors, and physical purchase
testing. A JavaScript runtime plus several native modules adds handoff points
without buying meaningful iOS proof before the deadline.

### Rejected now: Capacitor

Capacitor would reuse web UI and matches the builder's earlier preference for
few architectural touchpoints only if the core stayed inside standard web and
plugin surfaces. It does not. The current RevenueCat
[Capacitor guide](https://www.revenuecat.com/docs/getting-started/installation/capacitor)
documents App Store and Google Play setup, while RevenueCat's Android guide
says support for hybrid SDKs other than React Native is coming. Shipping a
custom Galaxy billing bridge plus native recording, widget, fold, and locked-
entry plugins would create more touchpoints, not fewer.

### Deferred: Kotlin or Compose Multiplatform

RevenueCat's
[Kotlin Multiplatform guide](https://www.revenuecat.com/docs/getting-started/installation/kotlin-multiplatform)
documents Google Play and iOS App Store support, common-source dependencies,
and generated native iOS bindings. It does not document Galaxy in that wrapper.
KMP becomes plausible after the Android product is proven, especially for a
shared domain or network layer. Before September 30 it would introduce an iOS
toolchain and platform adapters without satisfying any selected hard rule.

### Rejected as primary: SwiftUI

SwiftUI is credible for a later iPhone and iPad client. It is not credible as
the current primary because it moves the build away from the locally testable
platform, eliminates the natural Galaxy path, and still requires a separate
Android app later. iOS and the compatible Apple-silicon Mac path are deferred,
not abandoned.

## Architecture and data ownership

The detailed diagram, domain model, ownership rules, purchase lifecycle,
privacy plan, performance evidence, and test strategy are in
[system-blueprint.md](./system-blueprint.md).

The architectural rule is intentionally simple:

```text
input -> encrypted local save -> optional cloud work -> validated draft
-> human edit or confirmation -> verified Start
```

Use one activity and package boundaries for UI, domain, local data, remote data,
billing, platform integration, and telemetry. Do not create a module or service
per noun. An explicit application container is enough; a dependency-injection
framework, message queue, multi-provider router, and public Supabase data layer
are outside the contract.

The device owns all content: raw capture, transcript, draft, evidence links,
actions, edits, and history. Room owns non-content state and opaque identifiers;
encrypted app-private files own content. Android Keystore supplies a non-
exportable key for AES-256-GCM. Protected content is excluded from Auto Backup
because a restored ciphertext without its device key is not a recovery feature.
The user gets explicit export and deletion instead.

The thin backend owns only:

- install-scoped quota and abuse metadata;
- feature flags and the remotely configured free allowance;
- privacy-safe Run 9 events;
- RevenueCat webhook idempotency and lifecycle metadata;
- optional OneSignal message IDs;
- provider request status, latency, cost units, and allowlisted errors.

It does not persist raw audio, transcript, draft, actions, or evidence text.
OpenAI's current
[data-control documentation](https://platform.openai.com/docs/guides/your-data)
says API content is not used for model training unless the customer opts in,
but default abuse-monitoring logs can contain customer content for up to 30
days. The cloud-consent and privacy-policy copy must disclose the actually
selected provider and retention. “We do not store it in our database” is not a
complete retention claim.

## Authentication and recovery

Do not require an account before first value. When no custom app user ID is
provided, RevenueCat generates an anonymous ID. This supports the single-
device, subscription-only vertical slice. Restore remains an explicit user
action because RevenueCat notes that the operating system can display an
account prompt.

The recovery backend uses a resettable install-scoped credential, server-side
quota, and a remote cloud kill switch. It is not a person-level account and it
does not promise recovery after uninstall. A mandatory account, cross-device
sync, referral identity, and two-person features are post-submission.

## RevenueCat plan

Implement the approved M1 model with:

- one `pro` entitlement;
- one `default` Offering;
- monthly and annual packages;
- separate Play and Galaxy products mapped to those packages;
- a remotely configurable free cloud allowance, with seven drafts per rolling
  30 days retained only as the unvalidated Run 9 hypothesis;
- a dismissible paywall after first verified value;
- a blocking paywall only before a new cloud request beyond the allowance;
- explicit purchase, pending, cancel, failure, restore, grace, and expired
  states;
- an authorized, idempotent webhook with no thread content.

Expiry removes only new paid cloud work. It never hides local capture,
deterministic recovery, existing threads, export, deletion, accessibility, or
privacy controls.

## Backend, sync, offline, notifications, analytics, and flags

Use Supabase Edge Functions and Postgres as the only custom backend. Keep model,
OneSignal REST, Galaxy service, RevenueCat webhook, and Supabase secret keys on
the server. Supabase warns that its secret and legacy service-role keys bypass
row-level security and must never ship in a browser or app.

Offline behavior is a first-class core state: capture, save, browse, edit,
delete, export, and deterministic recovery work without the network. A cloud
request is retryable and idempotent. A returned draft is discarded if a newer
thread version exists.

OneSignal remains evidence-enhancing. Ask after verified value and only when the
user chooses a useful one-time reminder. Schedule from the backend, store the
message ID, cancel on every suppressing state, and make stale deep links safe.
Do not ship generic re-engagement notifications merely to enter the secondary
award.

Implement the Run 9 event taxonomy through the existing backend rather than
adding an analytics platform. The smallest dashboard contains A1, A2, R1, the
split R2 union, R3, R4, cloud outcomes, purchase lifecycle, and Android quality
signals. No content or persistent hardware ID enters an event.

## Privacy and store-review shape

Request microphone permission only when voice is chosen. Show recording state
and use the foreground service only for the active capture. Request no contacts,
location, health, calendar, broad storage, or background-listening permission.

Google's Data Safety declaration must reflect voice recordings and third-party
SDK behavior. Samsung's current distribution policy requires an in-app privacy
policy and Seller Portal URL for apps that access or transmit user data, plus
data types, purposes, third parties, retention, deletion, and user rights.

Position Restart Thread as a general interruption-recovery utility. Do not use
ADHD, therapeutic, diagnostic, or safe-functioning claims without the expert and
compliance work that previous runs found missing. Review notes should explain:

- why microphone access is requested;
- that local save occurs before optional cloud processing;
- how the reviewer can reach free value, purchase, restore, delete, and export;
- which content leaves the device and for how long the processor may retain it;
- that locked-surface content is generic and any no-unlock behavior is limited
  to physically proven devices.

## Performance and failure fallbacks

Use accepted product gates and official Android thresholds; do not invent an AI
latency target before measuring the spike.

- prepared capture: four of five target users begin within five seconds;
- accepted capture bound: 60 seconds;
- A1: verified Start within two minutes of first draft open;
- invariant: local save before upload;
- Android excessive launch thresholds: cold 5 seconds, warm 2 seconds, hot
  1.5 seconds;
- render work: under the display's frame deadline; no frozen frame above
  700 ms;
- Android vitals overall bad-behavior thresholds: user-perceived crash below
  1.09% and ANR below 0.47%;
- cloud proof: at least 90% of factual draft statements cite supporting
  segments and no reversed negations in the validation set;
- Supabase free function: 150-second wall-clock and idle-response ceiling.

Every cloud error returns to an intact saved thread and deterministic recovery.
Every connector animation has a static reduced-motion form. Every store or
entitlement failure leaves owned content available.

## Verification plan

The minimum test evidence includes:

- unit tests for state transitions, schema bounds, evidence citations, stale
  results, deterministic recovery, quota, entitlements, reminders, encryption,
  deletion, and redaction;
- integration tests for recorder interruption and process death, Edge Function
  retries, RevenueCat purchase and restore, webhook duplicates, export, delete,
  OneSignal race handling, and offline recovery;
- Compose UI tests for the critical path, empty, loading, partial, error,
  success, grace, expiry, and restore states;
- TalkBack, 200% text, dark and increased-contrast-ready themes, reduced motion,
  color independence, one-handed reach, and switch or keyboard traversal where
  applicable;
- compact, medium, expanded, multi-window, rotation, fold, and hinge tests;
- signed Play internal and closed builds, physical Galaxy purchase and locked-
  entry tests, clean reviewer install, and production artifact-to-demo parity.

For minimal observability, use redacted structured release logs, Supabase
function logs, RevenueCat customer and webhook views, Android vitals for Play,
and opt-in Firebase Crashlytics across both flavors. Do not add Firebase
Analytics, breadcrumb actions, user IDs, or content keys. Disable automatic
Crashlytics collection until the user enables diagnostics, and retain an opt-in
local diagnostic export. Do not add another observability vendor before these
sources show a real gap.

## Vertical slice and cut line

The traceable backlog is in
[vertical-slice-backlog.csv](./vertical-slice-backlog.csv). Every must-ship row
maps to user value, a hard rule, or RevenueCat Design evidence.

### Must ship

The irreducible product is:

1. Kotlin/Compose API-36 Android app with Play and Galaxy-capable flavors.
2. No-account text, Share, and in-app 60-second voice entry.
3. Encrypted durable local save before network work.
4. Offline deterministic recovery.
5. Explicit optional cloud consent and one thin provider path.
6. Grounded, bounded draft with Direct Trace-back evidence.
7. Human edit or confirmation and verified Start.
8. History, read, edit, delete, export, and complete failure states.
9. M1 RevenueCat purchase, restore, grace, expiry, webhook, and allowance.
10. Privacy-safe metrics, privacy policy, Data Safety, store and Devpost assets.
11. Forward Thread visual craft, accessibility, adaptive layout, performance,
    diagnostics, and a judge-observable demo.

### Evidence-enhancing, never hidden MVP

App shortcut, Glance widget, a physically proven locked Galaxy path, Galaxy
purchase and listing, useful fold posture, one OneSignal reminder, G1–G3, and
motion or haptic refinement stay in this bucket. Each has an explicit dependency
and cut rule.

### Post-submission

Native SwiftUI iPhone and iPad, Mac compatibility evaluation, account linking,
encrypted sync, referrals, on-device transcription, biometric lock, richer
large-screen work, and additional AI providers remain available after the
Android release.

### Cut

Before the deadline, do not build iOS or Mac, Kotlin Everywhere, a Capacitor
Galaxy bridge, C15 partner features, referral rewards, cross-device sync,
mandatory accounts, ads, consumables, lifetime purchase, launch trial,
continuous listening, autonomous AI, health claims, raw server content storage,
or a second analytics or backend platform.

## Critical path and submission buffer

The complete dated plan is in
[critical-path.md](./critical-path.md).

The key dates are:

- **Aug 11:** confirm Google account type; apply for Samsung Seller Portal and
  commercial status; secure physical Galaxy access;
- **Aug 12:** Kotlin/Compose API-36 project and both flavors build;
- **Aug 13–18:** complete the three technical spikes;
- **Aug 19:** start the Google closed test with at least 12 continuously opted-
  in testers if the new-personal-account rule applies;
- **Sep 3:** apply for Google production access only after verifying 14 complete
  continuous days;
- **Sep 8:** recommended first production-store submission to Galaxy;
- **Sep 11:** planning target for Google production submission if access exists;
- **Sep 18:** at least one store in review or accepted; otherwise stop all
  evidence-enhancing work;
- **Sep 20:** product and dependency freeze except blocking review or data-loss
  fixes;
- **Sep 22:** Devpost intake dry run;
- **Sep 24:** target accepted public listing and judge install;
- **Sep 28:** final Devpost submission, leaving correction time before Sep 30.

Google says production-access review usually takes seven days or less, but it
can require more testing. This plan does not treat that description as a
guarantee. Samsung review and commercial-seller timing are also external.

## First three technical spikes

1. **Durable capture and locked-entry truth.** Test app shortcut, home widget,
   notification or Samsung host, microphone service, stop, atomic save,
   interruption, process death, and locked privacy on physical devices. The
   pass result is a supported entry promise; failure falls back to unlock into
   a prepared recorder.
2. **Two-store purchase truth.** Build Play and Galaxy flavors and physically
   test Offering fetch, purchase, failure, restore, expiry or grace, and
   production-mode configuration. Failure removes Galaxy, not the core app.
3. **Grounded cloud recovery truth.** Send a bounded 60-second sample through
   Supabase to one provider; measure latency and cost; validate citations,
   negation, idempotency, redaction, and timeout fallback. Failure ships saved
   voice plus deterministic recovery, not a misleading AI feature.

## Risk register

The complete register is in [risk-register.csv](./risk-register.csv). The
highest-impact findings are:

- no confirmed active store accounts or Samsung commercial seller status;
- the Google 12-tester, 14-day gate may apply;
- Galaxy purchase proof requires physical hardware;
- locked-surface third-party audio is OEM- and state-dependent;
- local encryption and backup semantics can create unrecoverable content if
  presented as cloud recovery;
- provider retention, hallucination, timeouts, and anonymous abuse can break
  the trust contract;
- conditional awards can consume the solo schedule unless their cut rules are
  enforced.

The owner is the solo builder for every mitigation. Google and Samsung decide
their reviews, but external ownership does not remove the builder's duty to
apply early, supply correct evidence, and execute the fallback.

## Operational cost and manual work

The early architecture can stay within current generous tiers, subject to live
account terms:

- RevenueCat Pro is currently free through US$2,500 monthly tracked revenue;
- Supabase Free currently provides two active projects, 500 MB database, 5 GB
  egress, and 50,000 monthly active users;
- OneSignal's free path supports the single conditional mobile reminder;
- Firebase currently lists Crashlytics as no-cost; this plan uses it without
  Firebase Analytics and only after diagnostics opt-in;
- the current OpenAI price for bounded transcription is low, but the cloud
  spike—not the price page—must determine cost per successful draft including
  generation, retry, and support.

Manual operation is limited to store review, crash and provider monitoring,
purchase exceptions, support, delete requests, secret rotation, cost review,
and privacy-policy updates. The app has no public content, chat, or social graph,
so it does not create a content-moderation queue.

## Evidence and uncertainty ledger

The complete ledger is in [source-ledger.csv](./source-ledger.csv). Material
claims are summarized here.

| Claim | Status | Confidence | Limitation |
|---|---|---|---|
| Shipaton requires a first public eligible-store app and RevenueCat purchase path by Sep 30 | Observed in official rules | High | Rules can change; recheck before final submission |
| Native RevenueCat Android supports Play and Galaxy; Capacitor and KMP pages do not document Galaxy | Observed in current official docs | High | SDK support can change; pinned versions still need builds |
| Native Kotlin is the smallest credible path | Inferred from product surfaces, builder constraints, and current SDK support | Medium-high | A skilled React Native builder could price the boundary differently |
| New personal Google accounts require 12 testers for 14 continuous days | Observed in official Play help | High | Applicability depends on account type and creation date, still unknown |
| Galaxy distribution requires commercial seller setup and physical purchase proof | Observed in Samsung and RevenueCat docs | High | Builder account and hardware access are unconfirmed |
| Universal no-unlock recording is not a safe promise | Inferred from Android permission rules and OEM-dependent widget hosts | High | Physical-device matrix may support a narrower claim |
| Device-owned encrypted content plus metadata-only server minimizes exposure | Analyst architecture supported by Android security docs | Medium-high | Implementation and provider processing still need audit |
| Supabase free Edge Functions can host the bounded synchronous path | Described by official limits and inferred | Medium | Real provider latency and cold starts remain unmeasured |
| The dated plan can yield an accepted store release before Sep 30 | Inferred | Medium-low | Store access and review are external and no code exists yet |
| The app will meet activation, grounding, retention, payment, or willingness-to-pay thresholds | Unknown | Low | Requires the specified tests and real-user evidence |

## Contradictions and missing evidence

- The earlier H2A hypothesis favored a Capacitor-style shared application.
  Current RevenueCat Galaxy documentation and the selected native surfaces make
  that hypothesis weaker. Run 10 recommends superseding it only if the builder
  approves this gate.
- Android documents that a widget interaction can exempt a background
  foreground-service start, but Android 14+ imposes separate while-in-use
  microphone constraints. A widget tap is not proof that all target Galaxy
  keyguard states can record without unlock.
- The user's current Google developer-account type and creation date are
  unknown. The 12-tester gate is conditional until checked.
- No Samsung account, commercial seller status, service account, physical
  Galaxy access, store product, or test purchase has been confirmed.
- No Apple or Google account has been confirmed active. The roadmap cannot
  promise a review outcome.
- Supabase's 150-second free limit is documented, but real cold-start,
  transcription, generation, and upload behavior is unmeasured.
- The model provider is proposed as OpenAI for the first spike, not locked. Its
  default retention needs explicit disclosure and may be unacceptable to some
  target users.
- Seven cloud drafts per 30 days and the proposed prices remain experiments,
  not architecture constants.
- The system has not been tested against target users, TalkBack, large text,
  physical folds, process death, locked privacy, AI grounding, store review, or
  real subscription lifecycle.
- Firecrawl was used only as a live cross-check for three dynamic/current
  prerequisites. Exa remained the primary discovery and full-text extraction
  system. No browser or vision fallback was needed in Run 10.

## Recommendation

Approve the native Kotlin/Compose Android plan, the must-ship vertical slice,
the cut list, and a September 8 Galaxy first-submission target with Google Play
running in parallel.

The recommendation preserves what makes Restart Thread credible: a fast,
private, recoverable loop whose local truth survives network and AI failure.
It also produces strong RevenueCat Design evidence through the Direct Trace-
back Connector, state clarity, accessibility, and purchase lifecycle. It does
not spend the remaining window proving framework portability that the rubric
does not request.

Galaxy remains conditional. If commercial seller status, physical device, or
RevenueCat purchase proof fails its dated spike, ship the same coherent Play
app and remove the Samsung award claim. If cloud grounding fails, ship the same
coherent local recovery app and do not present an AI draft as proven.

## Decision gate — complete

The builder selected **Option A** on August 11, 2026. The approved package is
native Kotlin and Compose, Android-only before September 30, the listed vertical
slice and cut list, Galaxy first production submission on September 8, and
Google Play in parallel when production access exists.

The alternatives below are preserved as decision history.

- **Option A — approve the recommended package.** Native Kotlin/Compose,
  Android-only before September 30, the listed must-ship vertical slice and cut
  list, Galaxy first production submission on September 8, and Google Play in
  parallel as soon as production access exists. **Recommended.**
- **Option B — approve the architecture and scope, but make Google Play the
  first production target.** Keep Galaxy as evidence-enhancing and drop it if
  seller or purchase proof is not ready; use September 11 as the conditional
  Play planning target after production access.
- **Option C — revise the package.** Specify the platform, must-ship item, cut
  item, or first-submission date to change. Adding iOS before the deadline also
  requires naming which current must-ship proof will be removed.

## Updated research state

```yaml
RESEARCH_STATE:
  completed_run: 10
  selected_concept: "R1 Restart Thread: C13 Reset Button plus C14 Breadcrumb; C15 remains outside the MVP."
  selected_ux_direction: "A Instant Voice Thread with local-first save, grounded AI draft, conditional locked surfaces, text and Share equivalents, and deterministic fallback."
  selected_visual_direction: "H2 Forward Thread"
  selected_signature_interaction: "I2-V1 Direct Trace-back Connector"
  selected_monetization: "M1 Value-first Pro"
  selected_primary_award: "RevenueCat Design Award"
  conditional_secondary_awards:
    - "Best App for Galaxy"
    - "Keep Them Coming Back Award"
  run_10_recommended_platform: "Native Kotlin and Jetpack Compose Android app targeting API 36; one Gradle project with Play and conditional Galaxy product flavors."
  run_10_recommended_backend: "Device-owned encrypted content; thin Supabase Edge Function and Postgres metadata backend; one AI provider; no direct client secrets or server content persistence."
  run_10_authentication: "No account before value; RevenueCat anonymous user and resettable install-scoped recovery credential; explicit restore; accounts and sync deferred."
  run_10_first_store_target: "Galaxy Store production submission on 2026-09-08; Google Play production planning target 2026-09-11 only if production access exists."
  run_10_gate_status: "Approved by builder on August 11, 2026"
  must_ship_summary:
    - "No-account text Share and in-app voice entry"
    - "Encrypted durable local save before network work"
    - "Offline deterministic recovery"
    - "Optional bounded cloud transcription and grounded draft"
    - "Direct Trace-back evidence and human confirmation before Start"
    - "Local history read edit delete and export"
    - "M1 RevenueCat purchase restore grace expiry and webhook"
    - "Forward Thread accessibility adaptive layout and judge-observable proof"
    - "Accurate privacy Data Safety store and Devpost artifacts"
  evidence_enhancing_summary:
    - "App shortcut and Glance widget"
    - "Physically proven locked Galaxy entry"
    - "Galaxy purchase listing fold and multi-window proof"
    - "One user-requested OneSignal reminder"
    - "G1 G2 G3 and restrained motion or haptics"
  cut_before_submission:
    - "iOS iPadOS macOS Kotlin Multiplatform React Native and Capacitor"
    - "Accounts cross-device sync referrals and C15 partner features"
    - "Ads consumables lifetime purchase and launch trial"
    - "Continuous listening autonomous AI and health claims"
    - "Raw server content multi-provider routing and extra operations platforms"
  first_three_technical_spikes:
    - "Physical durable capture and locked-entry truth"
    - "Play and physical-Galaxy RevenueCat purchase truth"
    - "Supabase to one-provider grounded cloud recovery truth"
  accepted_evidence:
    - "Official Shipaton rules require first public eligible-store release and RevenueCat-powered purchase by the deadline."
    - "RevenueCat currently documents Galaxy support for native Android and React Native; other hybrid support is coming."
    - "Google Play requires API 36 for new app submissions starting 2026-08-31."
    - "New personal Play accounts require at least 12 continuously opted-in closed testers for 14 days before production-access application."
    - "Samsung requires commercial seller setup and physical Galaxy purchase testing."
    - "Android official guidance supports adaptive Compose layouts Keystore encryption Data Safety declarations and documented vitals thresholds."
    - "OpenAI documents default API abuse-monitoring retention up to 30 days unless an approved control applies."
    - "Exa was the primary discovery and full-text extraction system; Firecrawl live-cross-checked RevenueCat Android Google testing and Samsung seller prerequisites."
  rejected_directions:
    - "Capacitor before the deadline because current RevenueCat docs do not document Galaxy support and the differentiating surfaces require native bridges."
    - "React Native before the deadline because the product's hardest surfaces still cross into native Android modules."
    - "Kotlin or Compose Multiplatform before the deadline because no selected award requires an iOS build and the RevenueCat KMP page does not document Galaxy."
    - "SwiftUI as the primary because it abandons the selected Android-first and Galaxy path."
    - "A universal no-unlock recording promise before physical proof."
    - "Mandatory account server-owned content cross-device sync referral identity multi-provider routing or a second analytics platform in the vertical slice."
  unresolved_questions:
    - "Is the Google developer account active and subject to the new-personal-account testing rule?"
    - "Can Samsung commercial seller status and physical Galaxy access be secured immediately?"
    - "Which physical locked-entry behavior survives the first spike without privacy leakage?"
    - "Can both RevenueCat store flavors pass purchase restore failure grace and expiry tests?"
    - "Does the bounded cloud path meet grounding privacy reliability and cost evidence?"
    - "Can the must-ship slice reach an accepted public store listing with submission buffer?"
  next_decision: "Run 10 gate complete; proceed to Run 11 validation and judge-visible evidence."
```
