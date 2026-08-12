# Run 9 — Monetization, retention, and growth system

Run 9 designs a value-first business and return system for Restart Thread. It
recommends a freemium monthly or annual subscription in which local capture,
deterministic recovery, and access to the user's own threads remain free. The
subscription pays for sustained cloud transcription and grounded AI recovery,
not for safety, data access, or a manufactured streak.

This is a recommendation, not the builder's selection. Run 9 ends at the four-
part decision gate and does not advance to Run 10.

## Executive summary

- **Recommended model: M1 — Value-first Pro.** Free users can capture unlimited
  local threads, use text and Share entry, run deterministic recovery, inspect
  and export their own records, and sample cloud recovery. Pro adds sustained
  cloud transcription and grounded AI recovery for ordinary personal use.
- **Price hypothesis:** US$4.99 monthly or US$39.99 annually. This is a testable
  launch hypothesis, not a willingness-to-pay finding. It sits below the
  observed monthly median; the annual anchor matches current Llama Life and
  Composed offers but is below the broader audited annual median.
- **No launch trial.** A replenishing free AI allowance supplies real product
  evidence without enrolling a user in automatic renewal. A longer annual trial
  may be tested later only after recurrence and cancellation behavior exist.
- **Paywall after value.** Show a dismissible offer after the first verified
  restart, then enforce the free AI boundary only when the user requests cloud
  work beyond the allowance. Never interrupt recording, durable save, transcript
  review, or an already-created first action.
- **One RevenueCat entitlement:** `pro`, unlocked by monthly and annual packages
  in the current Offering. Existing threads, exports, and deterministic recovery
  do not depend on it.
- **Recommended activation metric:** the share of first opened recovery drafts
  that reach a user-confirmed or edited first action and **Start** within two
  minutes. The time window carries forward an accepted Run 6/7 validation
  threshold; it is not a new industry benchmark.
- **Recommended retention metric:** the share of activated users who start a
  second distinct recovery thread within seven days. It measures repeated value,
  not an app open, notification click, or daily streak.
- **OneSignal path:** one user-requested, deep-linked recovery reminder. Ask for
  permission only after first value and an explicit reminder choice. Suppress it
  after start, completion, deletion, opt-out, or replacement by a newer thread.
- **Galaxy path:** ship a Galaxy-specific billing flavor, validate purchases on
  a physical Galaxy device, demonstrate fold or multi-window continuity only
  when it improves the same recovery loop, and polish the Galaxy Store listing.
  RevenueCat currently documents Galaxy support for native Android and React
  Native, not Capacitor. That makes the billing spike a stack gate.
- **First growth experiments:** compare two acquisition promises, publish a
  physical-Galaxy proof clip, and test a private-by-default sanitized Restart
  Card. Their response and lesson fields remain blank until real evidence exists.

The structured artifacts are:

- [competitor-pricing.csv](./competitor-pricing.csv)
- [monetization-options.csv](./monetization-options.csv)
- [event-taxonomy.csv](./event-taxonomy.csv)
- [growth-experiments.md](./growth-experiments.md)
- [build-in-public-log.csv](./build-in-public-log.csv)
- [source-ledger.csv](./source-ledger.csv)

## Fixed product and award boundary

The monetization system inherits the selected product and flow without adding a
second persona or loop.

> Save a voice thread locally, transcribe and draft asynchronously, show one
> editable first action with transcript evidence, and require the user to
> confirm or correct it before starting.

The following remain non-negotiable:

- Voice is optional. Text, Share, and deterministic reset remain equivalent
  ways to recover.
- Local save precedes cloud work. A failed purchase or expired entitlement
  cannot remove or corrupt a saved thread.
- Locked surfaces stay generic and private.
- AI does not autonomously schedule, contact people, or activate an action.
- No ads appear in interruption, ADHD, recovery, or private-content moments.
- No streak, pet, point economy, shame copy, or task-volume reward is added for
  retention.
- The primary award remains RevenueCat Design. Best App for Galaxy and Keep Them
  Coming Back remain conditional secondaries because they serve the same user,
  recovery loop, and observable evidence.

## Method and evidence discipline

Exa was the primary discovery and extraction system. It searched current
first-party competitor pages, US App Store listings, RevenueCat documentation
and benchmarks, OneSignal documentation and pricing, Samsung IAP and Galaxy
Store documentation, Google Play policy, Apple review guidance, and OpenAI API
pricing. Exa then fetched every material URL used in the recommendation.

Firecrawl was a documented fallback for dynamic pages. It successfully rendered
the current US Coral App Store listing and Structured's support article, which
confirmed Exa's extracted price and packaging facts. Its forced-live fetch of
the AiDD App Store URL returned a 404 while Exa's index still returned a current
listing. AiDD is therefore retained as an indexed observation with lower current
confidence and is not used as a decisive price anchor. No browser or vision
fallback was needed.

Current product pages show what sellers offer. They do not establish conversion,
retention, efficacy, or willingness to pay. Aggregate subscription evidence
comes separately from RevenueCat's 2026 dataset of more than 115,000 apps and
US$16 billion in revenue; it still does not predict Restart Thread's outcome.

The source ledger uses **A** for official contest, platform, policy, benchmark,
or selected prior-run material; **C** for current first-party product, support,
pricing, or store material; and **D** for analyst calculation or inference. Each
row records date, current or historical timing, claim status, confidence, and a
limitation or fallback.

The installed UX research skill kept metrics tied to user behavior and decisions
rather than vanity counts. The Docs Writer skill shaped the artifacts into a
direct, source-linked specification. Neither skill supplies user evidence.

## Current market and packaging audit

The audit observed the United States and US dollars on August 11, 2026 unless a
row explicitly says that the product uses localized store pricing. Complete row
data and URLs are in [competitor-pricing.csv](./competitor-pricing.csv).

| Product | Current free boundary | Current paid packaging | Trial or offer | What this establishes |
|---|---|---|---|---|
| Structured | Almost every base feature; no ads or data sale | US$6.99 monthly, US$29.99 annual, US$99.99 lifetime | Not stated on fetched page | A planner can keep broad utility free and sell AI, recurring behavior, and customization |
| Todoist | Beginner plan and limited voice-to-task sessions | US$7 monthly or US$60 annual | Seven-day Pro trial | A mature tool meters AI while leaving core task capture free |
| Llama Life | Trial entry rather than a durable free plan | US$6 monthly or US$39 annual | Seven days, no card on web | Narrow one-task focus supports a mid-single-digit monthly price |
| Tiimo | Basic planner, limited AI chats, one profile | Monthly and annual Pro; US App Store lists multiple unlabeled regional SKUs | Annual only, seven days | Cross-device and AI value are recurring, but unlabeled App Store rows do not establish one exact price |
| Unstuck | Three task breakdowns per week | US$9 monthly | Seven days | A close AI breakdown product sells repeated generation, but its vendor metrics are not audited outcomes |
| Coral | Five voice commands daily plus full task and note management | US$4.99 monthly or US$47.99 annual | Seven days | A voice-first app can place unlimited cloud work above a free recurring allowance |
| WhisperAct | Seven syncs, seven recent memos, offline capture, and limited re-analysis | US$2.99 monthly or promotional US$24.99 annual | Free tier; annual offer is explicitly temporary | Privacy, offline fallback, and a meaningful free tier can coexist with cloud limits |
| Finch | Core self-care, goals, reflection, social vibes, and events | US$9.99 monthly or US$69.99 annual | Not established | Paid customization can preserve the core loop, but this is less analogous to cloud AI cost |
| Focusmate | Three sessions per week | US$12 monthly or US$8 per month billed annually | Free plan, no card | A recurring allowance can reveal value before unlimited access |

Across these products, the common current practice is a usable free boundary plus
a monthly and annual subscription. Seven-day trials are common, but common is not
equivalent to effective. RevenueCat's aggregate 2026 data reports that hard
paywalls have higher day-35 conversion than freemium, while year-one retention is
nearly identical. It also reports that trials lasting 17–32 days have higher
median trial-to-paid conversion than trials of four days or fewer. Both are
correlations across a selected subscription-app dataset. They do not override
Restart Thread's privacy, intermittent frequency, or first-value requirements.

The strategic implication is narrower: expose the offer in the first value
session, but do not block the first meaningful recovery. The user must understand
what Pro pays for before deciding.

## Three monetization options

The complete comparison is in
[monetization-options.csv](./monetization-options.csv). Prices and allowances are
hypotheses for testing, not declared optimums.

### M1 — Value-first Pro subscription — recommended

**Free value**

- Unlimited local voice and text capture within the fixed per-thread recording
  boundary.
- Durable save, playback, user-supplied text, Share entry, and deterministic
  three-question recovery.
- Inspection, correction, export, and deletion of every owned thread.
- Generic lock-surface entry and status when technically proven.
- A replenishing sample of cloud recovery drafts. Configure it remotely rather
  than hardcoding it. The launch hypothesis is **seven drafts in a rolling 30
  days**, derived from WhisperAct's observed seven-per-month re-analysis boundary
  and bounded against the higher-frequency Unstuck, Todoist, and Coral offers.
  Validate it before presenting it as fair.

**Paid value**

- Sustained cloud transcription and grounded AI recovery for ordinary personal
  use, with abuse protection rather than a prominent task counter.
- Faster or higher-quality processing only if measured and honestly delivered.
- Future encrypted cross-device continuity may join Pro after it exists; it is
  not promised in the hackathon paywall.

**Packaging and price hypothesis**

- Monthly: **US$4.99**.
- Annual: **US$39.99**, billed as one annual charge and shown more prominently
  than its monthly equivalent, as Google Play policy requires.
- No launch trial or lifetime product.
- Store-localized prices and taxes replace hardcoded display strings.

The price is deliberately a hypothesis. Across the eight audited products with
an exact current US monthly price, the median is approximately US$7. The exact
stable annual prices are more dispersed; US$39.99 matches Llama Life and
Composed but is below the median of the broader annual set. Restart Thread is
narrower than a full planner and lacks validated willingness to pay, which
supports testing below the monthly median rather than claiming premium pricing.

**Price validation plan**

1. In the five target-user interviews already required by Run 6, show the
   completed first-value prototype before price. Ask what recurring value they
   believe is being sold, which plan they would choose, and what makes them
   decline. Treat stated intent as qualitative evidence, not payment.
2. On a consented beta paywall, test the launch anchor against a market-anchor
   variant of **US$6.99 monthly / US$49.99 annual**. The comparison values are
   grounded in current Structured monthly and adjacent annual offers, not a
   claim of optimal pricing. Map separate store products into RevenueCat
   Offerings instead of changing labels without changing the actual charge.
3. Compare paywall-to-purchase, package choice, refund and cancellation,
   verified restart, D7 second recovery, first monthly renewal, provider cost,
   and net revenue per activated user. Do not select a price from click-through
   alone or declare a winner before the uncertainty is decision-useful.
4. Keep trial duration out of the price test. If a trial is later approved, test
   it separately so price and trial do not confound each other.

**Paywall choreography**

1. Do not show a paywall before the first durable thread or first verified
   restart.
2. After the first verified start, show a dismissible success endcap with one
   line explaining the free and Pro boundary. The primary action remains the
   user's recovery action, not purchase.
3. When a free user requests cloud work beyond the available allowance, show the
   full paywall before upload. Offer deterministic recovery and text editing as
   visible free alternatives.
4. After purchase, return to the same saved thread and resume the pending cloud
   request. Do not dump the user on a dashboard.
5. Never show the paywall while recording, before durable save, over evidence
   inspection, or while the user is confirming the first action.

**RevenueCat configuration**

- Project entitlement: `pro`.
- Offering: `default`, fetched as the current Offering rather than hardcoded.
- Packages: `$rc_monthly` and `$rc_annual`.
- Google Play: one subscription product with monthly and annual base plans, or
  equivalent store configuration mapped into the two packages.
- App Store and Galaxy Store: store-specific monthly and annual products mapped
  to the equivalent packages.
- One entitlement check controls cloud-Pro access. Local data access does not
  branch on entitlement state.
- Attach placement context to the post-value and allowance-boundary paywalls so
  conversion can be compared without inventing separate products.

**Purchase and entitlement states**

| State | User experience | Access rule |
|---|---|---|
| Offer loaded | Localized price, billing period, auto-renewal, free boundary, dismiss, terms, privacy, restore | Free product remains usable |
| Offer unavailable | Inline retry and deterministic recovery; no blank modal | No local feature is blocked |
| Purchase pending | Preserve the saved thread and show store-owned pending status | Don't grant Pro early |
| Purchase success | Confirm once, update the present-state dot, and resume the pending recovery request | Grant when `pro` is active |
| Purchase cancelled | Return without shame or repeated prompt | Free access unchanged |
| Restore | User-triggered **Restore purchases** in paywall and Settings | Re-read `pro`; never invoke an OS sign-in prompt automatically |
| Cancelled but active | Show the paid-through date and **Manage subscription** | Pro remains active until expiry |
| Billing issue or grace | Keep Pro active while the store reports active entitlement; show one non-blocking management link | Do not interrupt the current recovery |
| Expired | Explain what changed, keep all owned threads readable and exportable, restore the free allowance, and offer manage or resubscribe | Only recurring Pro cloud value closes |
| Resubscribed | Restore `pro` and continue from the same thread | No data migration or re-onboarding |

Google Play requires clear recurring value, full billing terms, a visible dismiss
path when free access exists, and an easy online cancellation route. RevenueCat
recommends a user-triggered restore control. Store-configured grace periods keep
entitlements active while payment recovery is attempted. Galaxy adds a mandatory
24-hour silent grace period and optional seller-defined extensions. The exact
seller-defined duration remains an operational choice based on cash exposure and
support readiness; the app must not hardcode a duration it cannot verify.

**Fairness and dark-pattern audit**

- Pass: real first value before the offer; visible free alternative; actual
  annual charge is prominent; no preselected consent; no false countdown; no
  disguised close control; no shame language.
- Pass: owned data, export, deterministic recovery, accessibility, and privacy
  controls remain free.
- Pass: cancellation, restore, billing issue, and expiry paths are reachable
  from Settings and the paywall.
- Open: seven free AI drafts may be too low or too high for an intermittent
  problem. Remote configuration and cohort evidence must decide.
- Reject: feature wording such as “unlimited AI” until ordinary-use policy,
  rate limits, and provider cost are proven.

**Primary-award evidence**

The paywall uses the selected Forward Thread grammar to explain the boundary:
the large dot marks current free value, the dotted trace shows recurring cloud
work, and the forward arrow leads to Pro. This is not decoration. The demo can
show a successful first recovery, a clear offer, localized purchase, entitlement
feedback, restore, and a respectful expired state without leaving the thread.

### M2 — First-success subscription with a long annual trial

M2 keeps the first verified restart free, then requires a subscription or long
annual trial for further AI recovery. It would test an annual trial inside the
17–32-day range associated with higher aggregate conversion in RevenueCat's 2026
data.

Its advantage is a clearer paid funnel and more time than a seven-day trial for
an intermittent problem. Its failures are more important: automatic renewal can
feel coercive after a vulnerable recovery moment; users may not encounter a
second interruption during the trial; Android requires explicit trial-end
communication; and local proof is too thin before validation. M2 is a **pivot**
only if M1 produces meaningful repeated use but unsustainably low conversion.

### M3 — Lifetime local unlock plus consumable recovery packs

M3 sells a non-consumable local-Pro unlock and consumable packs for cloud
recoveries. Payment is tied to discrete use and avoids recurring billing.

The model creates the wrong interaction at the wrong time: a user can run out of
credits while already interrupted. It also adds balance accounting, pack
selection, refund support, cross-device identity, and restore risk. RevenueCat
documents that consumables and non-renewing purchases require custom App User
IDs for reliable recovery; Google Billing Client 8 cannot restore consumed one-
time purchases for anonymous users. M3 is **rejected for MVP**.

## Unit-cost exposure and abuse controls

OpenAI's observed standard price on August 11 is US$0.0045 per minute for
asynchronous GPT Transcribe. GPT-5.6 Luna is US$0.20 per million input tokens and
US$1.20 per million output tokens. Under an explicitly illustrative 60-second
thread with 600 text-input tokens and 250 output tokens, transcription plus Luna
generation is approximately US$0.00492 before storage, networking, retries,
moderation, taxes, and provider minimums. One hundred such successful drafts
would be about US$0.49 in model charges under those assumptions.

This calculation proves only that bounded inference can be inexpensive. It does
not establish quality, latency, retries, fraud, or margin. Instrument actual
provider usage per successful verified restart.

Required controls are:

- Keep the accepted 60-second per-thread recording boundary until latency,
  quality, and cost tests justify a change.
- Save locally before upload and retry from the durable object.
- Keep provider keys on the server.
- Enforce request, audio-duration, and payload-size limits at the backend.
- Detect scripted generation and shared-account abuse without reading content
  for marketing.
- Do not charge an allowance unit for provider failure, cancelled upload, or a
  draft the user never receives.
- Track transcription cost, generation cost, retry cost, and successful verified
  starts separately.

RevenueCat itself is free up to US$2,500 in monthly tracked revenue and then
charges 1% of tracked revenue on the current Pro plan. OneSignal's current free
plan includes unlimited mobile push and one active in-app message. Its Create
Message API can schedule a message to a specific user, and the Cancel Message API
can stop it before send. That is sufficient for the bounded sponsor path below;
the app must enforce its own suppression because OneSignal's platform-wide
frequency capping is not on the free plan.

## Retention system

Restart Thread is an intermittent utility. Retention means returning when a real
thread is lost and recovering action again. It does not mean opening every day.

### Return loops

1. **Same-thread completion:** after the user confirms a first action, the app
   preserves the thread, source evidence, and current state. The user can return
   directly to that action without reprocessing audio.
2. **User-requested reminder:** the user may choose one reminder for the
   confirmed action. It deep-links to that exact thread and suppresses itself
   after start, completion, deletion, replacement, or opt-out.
3. **Next interruption:** the lock, widget, Share, text, or in-app entry creates
   another durable thread without setup. The product earns D7 return by being
   reliable, not by sending a generic daily prompt.
4. **Private history:** a lightweight list of saved, active, and completed
   threads makes prior context recoverable. There is no completion score or
   productivity ranking.

### Activation, time-to-value, and return definitions

| Metric | Definition | Product hypothesis | Decision unlocked |
|---|---|---|---|
| Durable-capture rate | First capture attempts that reach `thread_local_saved` | The entry surface is reliable enough to trust | If low, fix capture and recovery before AI or growth |
| Draft-ready rate | Locally saved threads that reach `recovery_draft_ready` | The cloud path returns usable output | If low, fix provider, queue, and retry behavior |
| **A1 — First verified restart in two minutes** | First opened drafts where the user edits or confirms one action and taps **Start** within 120 seconds | One grounded action reduces recovery work | Selected primary activation metric; if low, revise draft and confirmation before paywall |
| **A2 — End-to-end verified restart** | Share of `recovery_intent_started` events that reach `verified_restart_started`, plus the observed `seconds_since_intent` distribution for successful starts | The full journey is reliable and lower-friction than the workaround | Selected activation diagnostic; locate loss before draft open and identify whether entry, AI wait, or review dominates delay |
| **R3 — D1 meaningful return** | Activated users who transition the same thread to another verified start or completion, or start a distinct verified recovery, within 24 hours | Saved context helps after near-term interruption | Selected continuity diagnostic; do not optimize with more pushes by default |
| **R1 — D7 second verified restart** | Activated users who start a second distinct thread within seven days | The problem recurs often enough for habit-independent paid value | Selected primary retention metric; if low, reassess frequency and subscription fit |
| **R2 — D7 meaningful return** | Activated users who meet R1 or make a later verified start or completion on the activation thread within seven days | The product may support meaningful continuity even when no second interruption occurs | Retained as a derived coverage metric; separate same-thread and distinct-thread components before making a decision |
| **R4 — D30 second verified restart** | Activated users who start a second distinct thread within 30 days | Intermittent interruptions may recur outside D7 | Selected long-window diagnostic; compare with R1 before changing the subscription hypothesis |
| Paywall-to-purchase | Paywall viewers who activate `pro`, split by placement and package | The paid boundary is understood and proportional | Compare offer, price, and placement after value is proven |
| Trial start | `trial_started` divided by eligible offer views | A trial helps only if later introduced | Not applicable to M1 launch; retain for a controlled M2 test |
| First-renewal retention | Monthly subscribers active after the first renewal opportunity | Recurring value persists beyond acquisition | If low, improve value or change model before win-back messaging |
| Paid cancellation and refund | Paid users who cancel or refund, with optional reason | The promise matches delivered value | Fix mismatch; do not use coercive save flows |
| Share-to-activation | Sanitized Restart Card recipients who install and reach verified restart | A private, finite proof artifact can distribute value | Build sharing only if recipient activation appears |
| Net revenue per activated user | Net store proceeds divided by activated users | Monetization covers recurring service cost | Compare with model and support cost before scaling acquisition |

No numeric business target is manufactured before a baseline. The two-minute
activation condition is retained because earlier accepted validation work
already made it a falsification threshold. A1 is the primary activation metric;
A2 prevents A1 from hiding losses before a draft opens. R1 is the primary
retention metric; R3 and R4 expose near-term continuity and intermittent
recurrence. R2 remains queryable as their D7 union, so same-thread progress on
days 2 through 7 is not abandoned. These observation windows are not claims
about ideal product frequency.

### Event taxonomy and smallest useful dashboard

The full taxonomy is in [event-taxonomy.csv](./event-taxonomy.csv). Events never
include raw audio, transcript text, drafted actions, contacts, health content, or
free-form user text.

The smallest useful dashboard has four decision panels:

1. **Value funnel:** recovery intent → local save → draft ready and opened →
   action confirmed or edited → verified start. Split by voice, text, Share,
   locked entry, platform, and app version.
2. **Return cohorts:** R1 D7 distinct restart, R3 D1 meaningful return, and R4
   D30 distinct restart among activated users. Derive R2 D7 meaningful return as
   the union of R1 and later verified progress on the activation thread, while
   displaying its same-thread and distinct-thread components separately. Split
   notification-exposed users from users who return without a message; do not
   treat the split as causal without randomization.
3. **Monetization:** paywall view by placement → checkout start → purchase →
   active entitlement → cancellation, refund, billing issue, expiry, and first
   renewal. Include package, store, country, currency, and localized price.
4. **Reliability and cost:** AI success, correction, cited-evidence coverage,
   reversed-negation errors, latency, retries, provider cost per successful
   draft, OneSignal permission funnel, deep-link success, and Galaxy billing
   success.

Every panel answers a product decision. Installs, notification sends, raw app
opens, audience size, and total generated drafts remain context, not success.

## Conditional OneSignal sponsor path

Keep Them Coming Back remains a coherent secondary award only if the message
restores the same confirmed action and produces measurable start value.

**Audience:** activated users who explicitly select **Remind me once** for a
confirmed action.

**Permission choreography:** after the first verified restart, explain the exact
benefit in-app: “Restart Thread can remind you once about this action.” Request
the Android or iOS system permission only after the user chooses that function.
Do not request permission at install or after local save alone. OneSignal's
official guidance similarly favors a soft prompt after a value moment.

**One useful scheduled campaign:** after the user selects **Remind me once**, the
backend schedules **Your first step is still here** through OneSignal's Create
Message API and stores the returned message ID. The notification contains no
transcript or action and deep-links to the same private thread.

The backend calls OneSignal's Cancel Message API when the action starts,
completes, is replaced, or is deleted, or when the user disables the reminder or
notifications. It also checks state immediately before send. Cancellation may
not stop a message already in delivery, so the deep-link handler must resolve a
stale reminder into a neutral state rather than exposing or resurrecting deleted
content. The free plan does not provide global frequency capping, so application
state is the controlling suppression mechanism.

**Signals:** permission soft-prompt view, soft-prompt choice, system outcome,
campaign eligibility, scheduled message ID, cancellation result, send, confirmed
delivery when available, open, deep-link resolution, action confirmation, and
verified start. A schedule, send, or open is not the award outcome. The
observable outcome is a verified start on the intended thread.

**Next decision:** if messages open but do not produce starts, repair the target,
copy, or deep link. Do not raise frequency. If users decline after understanding
the value, keep reminders optional and improve in-app continuity.

## Conditional Galaxy sponsor path

Best App for Galaxy remains coherent because Android is the lead platform and
Galaxy optimization can improve the same capture-to-recovery loop.

**Device-specific experience**

- Prove generic lock-surface capture or the universal widget fallback on a
  physical Galaxy device before putting it in store text.
- Preserve an active recording and pending draft across fold, unfold, rotation,
  process recreation, and multi-window changes.
- On a large unfolded display, show transcript evidence and the editable first
  action side by side only when reading order and large text remain correct.
- In multi-window, let the user reference the interrupted source beside Restart
  Thread without changing the core loop.
- Treat Flex mode as optional. It is not an award feature unless the same action
  becomes materially easier.

**Galaxy Store and billing quality**

- Obtain a Samsung account, Seller Portal registration, and commercial seller
  status early. Samsung says approval can take several days and some financial
  verification can take up to ten business days.
- Use a Galaxy-specific distribution flavor and consider Samsung's recommended
  unique package name to prevent one store's build from overwriting another.
- Configure Galaxy monthly and annual products, activate them, map them into the
  same RevenueCat `pro` entitlement and Offering, and validate the service
  account integration.
- Make a successful test purchase, cancellation, failed purchase, grace or
  billing-issue state, restore or resubscription path, and expiry transition on
  a physical Galaxy device. RevenueCat states that Galaxy test purchases do not
  work in emulators.
- Produce Galaxy-native listing copy and assets that show the proven lock,
  fold, or multi-window value. Disclose in-app purchases accurately.

**Architecture consequence**

RevenueCat currently documents Galaxy support in Android SDK 10.7.0+ and React
Native 10.3.0+. Its Android installation page says support for other hybrid SDKs
is coming. The current Capacitor SDK page covers StoreKit and Google Play but not
Galaxy. Therefore:

- A pure Capacitor billing implementation does not satisfy the Galaxy purchase
  proof today.
- A native Android bridge would add a custom billing and lifecycle boundary.
- React Native or native Kotlin lowers Galaxy billing uncertainty but changes
  the shared-code decision.

Run 9 does not select the stack. It records a required technical spike before
Capacitor can remain the default.

**Store and product metrics:** Galaxy listing acquisition when available,
paywall view, checkout, purchase success, entitlement activation, restore,
billing issue, and verified restart; plus fold and multi-window usage only as
diagnostic context. Do not equate device-feature use with user value.

## Growth plan

The first three experiments are designed in
[growth-experiments.md](./growth-experiments.md). They are also pre-registered in
[build-in-public-log.csv](./build-in-public-log.csv) with response, product
change, and lesson left unfilled.

### G1 — Acquisition-promise comparison

Compare two honest messages with the same H2 visual system and landing-page CTA:

- A: **Pick up where interruption broke your thread.**
- B: **Say what happened. Get one first step you can verify.**

Tag traffic by message. Measure qualified landing visits, waitlist completion,
and whether the visitor selects a matching interruption scenario. Choose the
promise that attracts the intended user and still matches the prototype; do not
choose by impression count.

### G2 — Physical-Galaxy proof clip

Publish one short, captioned, uncut proof from a physical Galaxy device: generic
entry, durable save, ready draft, evidence trace, and verified start. If lock-
surface capture is not proven, show the universal widget fallback and state the
limitation. Link to the same waitlist with a Galaxy tag.

Measure qualified visits, waitlist completions, questions about the actual
recovery job, and technical objections. The experiment decides whether Galaxy
proof strengthens acquisition and award clarity, not whether to add more
Samsung-only features.

### G3 — Sanitized Restart Card

Prototype an explicit share sheet after a verified start. The default card
contains only **I found my next step**, the Forward Thread mark, and an optional
generic interruption category selected by the user. It contains no transcript,
action, source, time, streak, health label, contact, or location. The preview is
editable and sharing is off by default.

Measure share completion, recipient landing visits, and recipient verified
starts. If sharing occurs without recipient activation, do not build a referral
economy. If users hesitate because the moment feels private, remove the feature.

### Conditional two-sided referral reward — test after G3, not in the MVP

A two-sided referral reward fits the product only if G3 first shows that a
sanitized Restart Card produces recipient verified starts without privacy
discomfort. The reward must extend M1 rather than create a second monetization
system:

- Grant temporary access to the existing RevenueCat `pro` entitlement. Do not
  expose a spendable credit balance or meter recovery actions.
- Qualify the recipient only after a server-observed first verified restart:
  they confirm or edit the first action and tap **Start**. An install, link open,
  share, store rating, or review does not qualify either user for a reward.
- Surface the invite after verified value or from a user-opened sharing area.
  Do not show it during capture, drafting, recovery, or payment failure.
- Keep the card and link generic. Do not include a thread identifier, transcript,
  action, health label, contact, or inviter-selected recipient data. Do not ask
  for address-book access.
- Require server-side identity, signed referral attribution, self-referral
  rejection, idempotent grants, and an audit record before awarding either side.
  Derive any abuse limit from measured fraud and cost; do not invent a cap.

RevenueCat currently supports time-limited granted entitlements through its
dashboard and secret server API. They take effect immediately, expire
automatically, do not change billing, and do not stack on top of store
subscriptions. That makes the free-user path feasible but leaves an unresolved
fairness and implementation problem for active subscribers. Apple and Google
also prohibit manipulating discovery, installs, ratings, or reviews. Rewarding
a verified in-app value event instead of an install reduces this risk but does
not guarantee store approval.

Do not select a reward duration yet. Derive it from observed first-to-second
restart intervals, cost per verified restart, abuse behavior, and an explicit
owner choice. The D7 measurement window is not evidence that a seven-day reward
is fair or effective.

## Evidence and uncertainty ledger

The full claim-level ledger is in [source-ledger.csv](./source-ledger.csv).

| Material claim | Status | Confidence | Limitation |
|---|---|---|---|
| Adjacent products commonly use a usable free boundary plus monthly and annual Pro | Observed in current first-party pages | High for listed products | Practice does not prove effectiveness |
| US$4.99 monthly and US$39.99 annual are credible test anchors | Calculated from observed adjacent prices and product scope | Medium | No Restart Thread willingness-to-pay evidence exists |
| A hard paywall converts more installs by D35 in RevenueCat's 2026 dataset | Measured aggregate benchmark | High for dataset | Selected RevenueCat apps; correlation does not dictate this product |
| Longer trials correlate with higher trial-to-paid conversion | Measured aggregate benchmark | High for dataset | Product mix and selection effects remain |
| RevenueCat supports one entitlement, Offerings, restore, and store grace states | Observed official documentation | High | Exact SDK and store behavior still needs implementation tests |
| RevenueCat Galaxy billing supports native Android and React Native, not current Capacitor | Observed official RevenueCat and Samsung documentation | High as of observation | Support could change after August 11 |
| OneSignal can schedule and cancel one targeted reminder while the free plan supplies mobile push | Observed official pricing and API documentation | High | Delivery and cancellation races need device tests; backend suppression remains required |
| Bounded transcription and generation can cost below one cent in the illustrative case | Calculated from current official API prices | Medium | Token count, retries, storage, quality, and provider choice are assumptions |
| First verified restart predicts subscription conversion or D7 return | Unknown | None | Requires shipped behavioral evidence |
| A sanitized share card creates distribution without privacy discomfort | Inferred hypothesis | Low | Requires explicit prototype and recipient testing |
| RevenueCat can grant temporary `pro` access without a store purchase | Observed official documentation | High | The grant is immediate and does not stack with an active store subscription |
| A two-sided referral reward will improve qualified growth | Unknown | None | G3 must first prove recipient verified starts; no reward test exists |

## Contradictions and missing evidence

- RevenueCat's aggregate data favors hard paywalls for early conversion, while
  the selected UX contract forbids a paywall before first value. The
  recommendation exposes a dismissible offer after first value and accepts that
  trust and user access may trade off against maximum D35 conversion.
- Seven-day trials are common among audited competitors, but RevenueCat's
  aggregate data associates 17–32-day trials with higher conversion. Restart
  Thread has no recurrence baseline, so Run 9 recommends no launch trial rather
  than copying either duration.
- AiDD's Exa-indexed App Store page showed US$4.99 monthly and US$49.99 annual,
  but Firecrawl's forced-live request returned 404. The row is not used to set
  the recommendation.
- Tiimo's US App Store page contains many unlabeled in-app purchase rows. The
  exact active monthly and annual price cannot be assigned from those rows.
- RevenueCat's pricing page describes the Pro plan as free through US$2,500 MTR,
  while Customer Center documentation says the feature is available on Pro and
  Enterprise. These are compatible if the free-start tier is the Pro plan, but
  the account dashboard must confirm access before implementation.
- No competitor discloses trustworthy conversion, paid retention, marginal AI
  cost, or causal effectiveness for its current package.
- No Restart Thread interviews, pricing survey, fake-door test, purchase, refund,
  renewal, or churn data exists.
- The seven-draft free allowance is an anchored hypothesis, not a fairness
  finding. It must remain remotely configurable and be tested.
- No Samsung Seller account, commercial seller status, store products, physical
  purchase test, or Galaxy-compatible selected stack exists yet.
- No OneSignal permission, delivery, deep-link, or verified-start funnel has
  been run. A scheduled API response does not guarantee timely device delivery,
  and cancellation can race an in-progress send.
- A temporary RevenueCat grant works cleanly for an eligible free user, but it
  does not stack with an active store subscription. A fair paid-subscriber
  reward would require a separately reviewed store extension or a deferred
  reward ledger; neither belongs in the MVP.
- Apple prohibits manipulation of App Store discovery and referrals, and Google
  prohibits manipulated ratings, reviews, and install counts. A reward based on
  a verified in-app restart is lower risk than an install reward, but only store
  review can resolve the policy interpretation.
- The physical lock-surface, fold, AI grounding, accessibility, and model-quality
  gates from Runs 6–8 remain unresolved.

## Recommendation

Approve **M1 — Value-first Pro**, **first verified restart within two minutes**,
**D7 second verified restart**, and experiments **G1–G3**.

This combination is the strongest fit because it makes payment proportional to
recurring cloud value, preserves the recovery job when payment fails, produces
an observable RevenueCat lifecycle, avoids ads and coercive trials, measures a
real action rather than attention, and keeps both conditional sponsor paths on
the same audience and core loop.

The recommendation does not claim that US$4.99/US$39.99, seven free drafts, a
subscription, or either secondary award is validated. The purpose of the event
taxonomy and experiments is to make those assumptions falsifiable before scale.

## Decision gate

**Decision update — August 11, 2026:** the builder approved M1, experiments
G1–G3, A1 and A2 for activation, and R1, R3, and R4 for retention. To preserve
one decision metric per gate, A1 is primary and A2 is diagnostic; R1 is primary,
while R3 and R4 are diagnostics. R2 remains a derived coverage metric rather
than a competing target. The two-sided referral reward remains a conditional
post-G3 experiment, not an approved MVP feature or a fourth launch experiment.

The Run 9 gate is complete. Do not begin Run 10 until the builder supplies or
requests that run.

## Updated research state

```yaml
RESEARCH_STATE:
  completed_run: 9
  selected_concept: "R1 Restart Thread: C13 Reset Button plus C14 Breadcrumb; C15 remains outside the MVP."
  selected_ux_direction: "A Instant Voice Thread with local-first save, grounded AI draft, conditional locked surfaces, Context plus Voice alternate entry, and Voice Rescue fallback."
  selected_visual_direction: "H2 Forward Thread: A4-dominant editorial system with the large present-state dot, dotted context thread, forward arrow, tactile primary action, and corrected single-state locked widget."
  selected_signature_interaction: "I2-V1 Direct Trace-back Connector."
  primary_award: "RevenueCat Design Award"
  conditional_secondary_awards:
    - "Best App for Galaxy"
    - "Keep Them Coming Back Award"
  monetization_options_at_gate:
    - "M1 Value-first Pro subscription — recommended"
    - "M2 First-success subscription with a long annual trial — pivot only"
    - "M3 Lifetime local unlock plus consumable recovery packs — reject for MVP"
  recommended_monetization: "M1 Value-first Pro: free local and deterministic recovery, remotely configurable cloud sample, US$4.99 monthly or US$39.99 annual test anchor, and no launch trial."
  selected_monetization: "M1 Value-first Pro approved by builder on August 11, 2026."
  recommended_activation_metric: "First opened recovery draft reaches a user-confirmed or edited first action and Start within two minutes."
  recommended_retention_metric: "Activated user starts a second distinct verified recovery thread within seven days."
  selected_activation_metrics:
    primary: "A1 first verified restart within two minutes of opening the first draft."
    diagnostic: "A2 end-to-end verified-start rate plus observed time from recovery intent to verified Start."
  selected_retention_metrics:
    primary: "R1 D7 second distinct verified restart."
    diagnostics:
      - "R3 D1 meaningful return through verified same-thread progress or another verified action."
      - "R4 D30 second distinct verified restart."
    derived_coverage: "R2 D7 meaningful return, calculated as R1 or later verified start or completion on the activation thread; report the two components separately."
  recommended_growth_experiments:
    - "G1 acquisition-promise comparison"
    - "G2 physical-Galaxy proof clip"
    - "G3 sanitized Restart Card"
  selected_growth_experiments:
    - "G1 acquisition-promise comparison — approved by builder"
    - "G2 physical-Galaxy proof clip — approved by builder"
    - "G3 sanitized Restart Card — approved by builder"
  conditional_referral_direction: "After G3 proves privacy-safe recipient verified starts, test a two-sided temporary pro entitlement awarded for the recipient's first verified restart, not for an install, rating, review, link open, or share. Duration and paid-subscriber treatment remain unresolved."
  accepted_evidence:
    - "Current adjacent pricing audit covers nine products observed in the United States on August 11, 2026."
    - "Competitor practice is separated from aggregate subscription evidence and does not establish Restart Thread willingness to pay."
    - "RevenueCat's 2026 aggregate dataset reports higher D35 conversion for hard paywalls and higher median trial-to-paid conversion for 17–32-day trials."
    - "RevenueCat officially documents one-entitlement Offerings, user-triggered restore, grace-state behavior, and current Galaxy support for native Android and React Native."
    - "Samsung officially documents Seller Portal, commercial seller, physical-device purchase, subscription, grace, cancellation, and store-distribution requirements."
    - "OneSignal's current free plan supplies unlimited mobile push and one active in-app permission message; its API supports targeted scheduling and cancellation."
    - "OpenAI's current API prices make bounded transcription and lightweight generation inexpensive in an illustrative case but do not prove quality or margin."
    - "Exa was primary discovery and extraction; Firecrawl cross-checked two dynamic pages and recorded one live 404 contradiction."
    - "RevenueCat granted entitlements can supply temporary pro access without changing billing, but they apply immediately and do not stack on active store subscriptions."
    - "Apple and Google prohibit manipulation of store discovery, installs, ratings, and reviews; a referral reward must not depend on those actions."
  rejected_directions:
    - "Ads in private recovery moments."
    - "Hard paywall before durable capture and verified first value."
    - "Holding owned threads, export, deterministic recovery, accessibility, or privacy controls behind Pro."
    - "Consumable recovery credits in the MVP."
    - "Streaks, points, pets, shame copy, notification volume, or app opens as retention."
    - "OneSignal permission on first launch or a message without user-requested value."
    - "A Galaxy billing claim from Capacitor without a native bridge or supported stack and physical purchase proof."
    - "A public-by-default share card or any card containing transcript, action, source, health, contact, time, or location data."
  unresolved_questions:
    - "Will users pay US$4.99 monthly or US$39.99 annually after repeated verified restarts?"
    - "Is seven cloud recovery drafts per rolling 30 days a fair and useful free boundary?"
    - "Does a subscription remain credible if encrypted cross-device continuity is not in the first release?"
    - "Will activated users create a second distinct verified recovery within seven days without generic reminders?"
    - "Does the post-value paywall preserve trust while producing enough purchase intent?"
    - "Can OneSignal deep links produce verified starts without notification fatigue?"
    - "Will a sanitized Restart Card produce recipient activation without privacy discomfort?"
    - "If G3 succeeds, will a two-sided temporary pro reward add recipient verified starts without privacy discomfort, abuse, or store-policy rejection?"
    - "How can an active subscriber receive equivalent referral value when a RevenueCat promotional entitlement does not stack with the store subscription?"
    - "Will the builder select native Android, React Native, or a proven native bridge for Galaxy billing?"
    - "Can the Galaxy purchase and lifecycle path be proven on a physical device before submission?"
    - "Do the unresolved lock-surface, AI grounding, accessibility, and performance gates pass?"
  next_decision: "Run 9 gate complete; await the builder's Run 10 prompt or explicit request to continue."
```
