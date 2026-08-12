# Submission-production checklist

This checklist combines the official Shipaton intake requirements with the
selected award proof. Recheck the live rules before final submission because
the organizer reserves the right to change dates and process.

## Eligibility and live-product proof

- [ ] Treat August 1, 2026 as the project and first-public-release start for
  planning, per the builder's instruction.
- [ ] Publish the working Android app to at least one eligible store by
  September 30, 2026 at 11:45 p.m. PDT.
- [ ] Confirm the first public release occurred within the allowed window.
- [ ] Confirm the public listing installs from the United States.
- [ ] Keep the project free of charge and unrestricted for Sponsor,
  Administrator, and Judges through October 13, 2026 at 12:00 p.m. PDT.
- [ ] Verify the submitted package name, store URL, and RevenueCat project and
  SDK evidence against the final signed build.
- [ ] Make a real RevenueCat-powered purchase or use RevenueCat Ads. Restart
  Thread uses the approved purchase path.
- [ ] Run clean install, first value, allowance boundary, purchase, restore,
  cancellation, grace, expiry, deletion, and offline fallback on the store
  build.
- [ ] Archive store acceptance, version, signing, test account, and parity
  evidence without secrets.

## Judge access to Pro

The approved M1 launch has no public trial, while the rules require either a
free trial or a promo code that lets judges test all premium features.

- [ ] Ask the organizer whether an in-app judge code that grants a time-limited
  RevenueCat `pro` entitlement satisfies the promo-code requirement.
- [ ] If accepted, implement a Settings field for the event-bound code. Send the
  anonymous RevenueCat App User ID and code to the backend; validate and rate
  limit there; keep the RevenueCat secret API key server-side; grant `pro`
  through RevenueCat; refresh `CustomerInfo`; and show the expiry.
- [ ] Make the code idempotent, time-limited through the judging period, and
  isolated from billing. Do not hardcode a shared RevenueCat App User ID.
- [ ] Put the code and exact redemption steps in private testing instructions,
  not the public video or screenshots.
- [ ] Test redemption, repeated redemption, wrong code, offline response,
  entitlement refresh, expiry, and ordinary store purchase coexistence.
- [ ] If the organizer rejects this interpretation, configure an acceptable
  store-native free-access route and update M1 honestly before submission. Do
  not assume a RevenueCat granted entitlement is legally identical to a store
  promo code merely because it unlocks the same entitlement.

RevenueCat's official documentation supports immediate, time-limited granted
entitlements through the dashboard or secret server API. That proves the
technical mechanism, not Devpost's acceptance of it as the required promo code.

## Devpost entry

- [ ] Complete every required submission field.
- [ ] Provide an English text description of the project.
- [ ] Provide English narration, captions, transcript, testing instructions,
  and translations for any non-English material.
- [ ] Add the live store URL for the submitted build.
- [ ] Add the exact package name used by the store build.
- [ ] Add clear testing instructions, including first value, Pro access,
  restore, offline fallback, accessibility settings, and any generic quick
  entry limitation.
- [ ] Name the primary RevenueCat Design Award and only the secondary awards
  whose proof gates passed.
- [ ] Answer every entered category-specific question. A blank category answer
  can prevent category assignment during intake.
- [ ] Link sources for every numerical or comparative claim.
- [ ] Verify all links in a signed-out browser and from a US-accessible network.
- [ ] Save a final PDF or screenshot archive of every submitted field and the
  submission confirmation.

## Demo video

- [ ] Export the primary demo at 1:58 and verify it remains less than two
  minutes after upload.
- [ ] Show the app functioning on its target Galaxy or Android device.
- [ ] Establish the user and interruption pain in the opening seconds.
- [ ] Show entry, capture, local save, grounded draft, Direct Trace-back
  Connector, edit or confirmation, and Start without hiding a workflow.
- [ ] Show the RevenueCat value boundary and working entitlement naturally.
- [ ] Show Design criterion 1 before using time on secondary proof.
- [ ] Show Galaxy and OneSignal only if their live proof gates pass.
- [ ] Use only archived metrics with sample size, date, build, and source.
- [ ] Add accurate captions and a transcript.
- [ ] Publish publicly on YouTube or Vimeo and verify signed-out playback.
- [ ] Use only original or licensed music, fonts, footage, illustrations, and
  sound. Keep the license and attribution record.
- [ ] Obtain permission for any third-party trademark or copyrighted material
  shown beyond nominative, unavoidable device or store context.

## Icon, screenshots, and store assets

- [ ] Provide the required 1024 x 1024 app icon.
- [ ] Provide at least one 1179 x 2556 screenshot without a device frame.
- [ ] Export a coherent sequence: promise, capture and local save, grounded
  action and evidence, and proven platform or paid value.
- [ ] Keep screenshots free of private participant content, device frames,
  unsupported results, unproven locked behavior, and unreadable fine print.
- [ ] Check contrast, scalable type, color-independent meaning, and localization
  resilience in the captured screens.
- [ ] Match store description, privacy disclosures, in-app purchases, support
  URL, privacy URL, icon, and screenshots to the accepted build.
- [ ] Prepare Galaxy-specific metadata and assets only from verified Galaxy
  behavior; do not duplicate Play copy when it hides the adaptive value.

## RevenueCat Design entry

- [ ] Describe the unique design elements: the large state dot, dotted context
  line, arrow-forward mark, tactile controls, and Direct Trace-back Connector.
- [ ] Identify the exact screens and demo timestamps where judges can see each
  element.
- [ ] Explain how local-save feedback, evidence, edit, Start, haptics, and motion
  support the recovery job.
- [ ] Include a reduced-motion equivalent and accessibility proof rather than
  treating animation as universally beneficial.
- [ ] Lead with innovative interaction and provenance because Innovative ideas
  is the first Design criterion and therefore tie-break critical.

## Conditional Galaxy entry

- [ ] Publish a live US Galaxy Store URL during the event.
- [ ] Meet Samsung content and seller requirements.
- [ ] Prove the Galaxy distribution flavor, product mapping, purchase, failure,
  restore, and entitlement state on required hardware.
- [ ] Record fold, unfold, rotation, multi-window, large-text, process-death,
  and focus-order continuity.
- [ ] Explain the device optimization and polished store metadata and assets.
- [ ] Do not claim Galaxy exclusivity; it is optional and conflicts with the
  approved parallel Play path.
- [ ] Ask the organizer to clarify the unpublished “standard applicable” 80%
  criteria; keep the ambiguity in the evidence matrix if no answer arrives.

## Conditional OneSignal entry

- [ ] Ship a live app with the working OneSignal integration.
- [ ] Create and deploy the one user-requested reminder campaign.
- [ ] Provide the OneSignal App ID in the required submission field.
- [ ] Prove permission timing, schedule, state check, cancellation, confirmed
  receipt or delivery diagnostics, exact-thread deep link, and stale-link safety.
- [ ] Archive the app-owned requested-reminder-to-verified-start outcome.
- [ ] Describe why one bounded reminder is valuable and resourceful; do not add
  an unrelated multi-step Journey solely for award depth.
- [ ] Drop the award if only an API response, send, delivery, or click is proven.

## Repository and license

The official public-repository and open-source-license requirement applies to
Next Gen entries. Restart Thread is not currently entered for Next Gen.

- [ ] Do not mark a public repository as a universal Shipaton requirement.
- [ ] If the builder voluntarily publishes code, remove secrets, participant
  data, licensed private assets, test credentials, and internal endpoints, then
  add an appropriate license and functional setup instructions.
- [ ] If the award set changes to Next Gen, treat a complete public repository,
  assets, instructions, and open-source license as required before entry.

## Final independent pass

- [ ] Have a fresh reviewer compare the live store build, first 1:58, all
  screenshots, Devpost prose, category answers, evidence matrix, and rules.
- [ ] Confirm every claim is observed, described, measured, inferred, or unknown
  in the internal ledger.
- [ ] Remove simulated features, unsourced numbers, stale prices, missing links,
  and any secondary award without its required evidence.
- [ ] Submit by the September 28 owner target so September 29–30 remain for
  blocking correction, not new feature work.
