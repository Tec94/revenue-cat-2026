# Restart Thread RevenueCat implementation

RevenueCat is wired into the Android-first Kotlin Multiplatform architecture.
Google Play and future iOS builds share the KMP subscription path. Galaxy uses
RevenueCat's native Samsung adapter because its store configuration is
platform-specific.

This file describes the implemented contract and the live dashboard state
observed on August 12, 2026. Owner actions are kept in `MANUAL_SETUP.md`.

## Product contract

The app and every store must use these stable identifiers:

- entitlement: `pro`;
- Offering: `default`;
- monthly package: `$rc_monthly`, mapped to product `monthly`;
- annual package: `$rc_annual`, mapped to product `yearly`.

**RestartThread Pro** is a display name, not an entitlement identifier. Prices
and localized terms come from RevenueCat and the store rather than app copy.

The approved M1 boundary is value-first. Local capture, deterministic recovery,
and owned records remain free. Pro funds sustained cloud transcription and
grounded AI recovery. The paywall appears only after the verified restart value
moment, remains dismissible, includes restore, and makes no unlimited-AI or
launch-trial claim.

## Implemented source path

- `android/shared/build.gradle.kts` adds RevenueCat KMP core, result, and UI
  3.4.0.
- `android/app/build.gradle.kts` separates Test Store, Play, and Galaxy public
  keys by build type and flavor.
- `android/shared/src/commonMain/.../billing/RevenueCatSubscriptions.kt`
  configures the SDK, fetches CustomerInfo and the current Offering, checks
  `pro`, and maintains subscription UI state.
- `android/shared/src/commonMain/.../ui/RestartThreadApp.kt` presents the KMP
  Paywall and Customer Center.
- `android/app/src/play/.../billing` initializes the shared path for Play.
- `android/app/src/galaxy/.../billing` implements the native Galaxy equivalent.
- `android/shared/src/iosMain/.../MainViewController.kt` accepts the future
  Apple public SDK key from the Swift host.

Debug builds enable RevenueCat debug logging. Purchase and restore success
callbacks immediately accept returned CustomerInfo and dismiss the paywall.
Customer Center dismissal refreshes state. A missing key, unavailable Offering,
or billing failure never blocks local recovery.

The launch slice uses RevenueCat's anonymous App User ID. Do not introduce app
accounts until login, logout, aliasing, deletion, and cross-platform identity
behavior are designed together.

## Key handling

Debug Play builds select `REVENUECAT_TEST_API_KEY`, with compatibility for the
existing Test Store key currently stored under `REVENUECAT_PLAY_API_KEY`.
Release Play builds reject a `test_` value. Real stores use public app SDK keys:

```properties
REVENUECAT_TEST_API_KEY=test_...
REVENUECAT_PLAY_API_KEY=goog_...
REVENUECAT_GALAXY_API_KEY=galx_...
```

Keep `android/local.properties` ignored to prevent app and environment mixups.
Public SDK keys are not server secrets, but RevenueCat secret API keys, Stripe
secret keys, Google service-account keys, and Samsung seller credentials must
never be placed in the client or repository.

## Live dashboard audit

The authenticated RevenueCat project currently has:

- Test Store enabled for anybody in the sandbox;
- current Offering `default`;
- monthly and annual standard packages mapped correctly;
- Test Store products `monthly` and `yearly`, with no trial;
- both products attached to the existing entitlement;
- a default Customer Center configuration;
- Stripe connected through RevenueCat Billing;
- no recorded sandbox transactions.

The corrected entitlement identifier `pro` exists and has both products
attached. The published **Restart Thread Pro** components-based Paywall is
attached to Offering `default`. The older literal `RestartThread Pro`
entitlement remains in the dashboard for now, but the app does not check it.
It can be retired after the first Test Store transaction proves `pro`.

The Test Store currently displays $9.99 monthly and $79.99 yearly. Those values
are suitable for technical sandbox proof but do not replace the approved launch
hypotheses of $4.99 monthly and $39.99 yearly.

RevenueCat Billing has no web products. Stripe connectivity therefore does not
yet create a usable web checkout or a mobile entitlement redemption path.

## Paywall specification

The published Paywall uses RevenueCat's compact red template and the locked
Restart Thread language:

- title: **Keep recovery moving**;
- feature rows: cloud transcription, grounded recovery, thread ownership, and
  the free local core;
- package order: annual and monthly, without an unsupported savings claim;
- annual badge: **YEARLY PLAN**, without a discount claim;
- actions: **Continue with Pro**, close, Restore Purchases, Terms, and Privacy;
- exclusions: countdowns, fake urgency, unlimited-AI claims, and a trial until
  one is deliberately configured and validated.

The app, rather than the dashboard template, controls when the paywall appears.
It is exposed only from the completed recovery state.

## Verification

The repository proof is:

```powershell
cd android
.\gradlew.bat :shared:testAndroidHostTest :app:assemblePlayDebug
.\gradlew.bat :app:assembleGalaxyDebug
```

Verify the published configuration on `playDebug`:

1. Offering `default` renders both packages and the published template.
2. Close returns to the completed recovery without data loss.
3. Cancellation and failure leave the free experience usable.
4. A Test Store purchase activates `pro` and returns to the app.
5. Relaunch preserves SDK-reported Pro state.
6. Restore returns the same entitlement.
7. Customer Center opens for Pro and refreshes state on dismissal.
8. The RevenueCat sandbox customer record shows the transaction and `pro`.

That proof does not validate Google Play Billing or Samsung Checkout. Real Play
testing needs an uploaded signed AAB and license tester. Galaxy needs its seller
catalog, RevenueCat Galaxy app, public key, signed build, and physical device.

## Official references

- [Kotlin Multiplatform installation](https://www.revenuecat.com/docs/getting-started/installation/kotlin-multiplatform)
- [Displaying Paywalls](https://www.revenuecat.com/docs/tools/paywalls/displaying-paywalls)
- [Customer Center](https://www.revenuecat.com/docs/tools/customer-center)
- [Customer information](https://www.revenuecat.com/docs/customers/customer-info)
- [Entitlements](https://www.revenuecat.com/docs/getting-started/entitlements)
- [Galaxy setup](https://www.revenuecat.com/docs/platform-resources/galaxy-platform-resources/galaxy-setup-guide)
