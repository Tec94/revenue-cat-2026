# Restart Thread RevenueCat contract

## Stable identifiers

Use the same identifiers across RevenueCat, each store, and every app host.

- entitlement: `pro`;
- Offering: `default`;
- monthly package `$rc_monthly` → product `monthly`;
- annual package `$rc_annual` → product `yearly`.

**Restart Thread Pro** is display copy, not an entitlement identifier. The
store and RevenueCat supply localized price and billing terms.

## Implemented behavior

Play uses RevenueCat KMP 3.4.0. iOS and macOS use RevenueCat's native Apple SDK
5.82.0 and RevenueCatUI. Galaxy uses native RevenueCat Android 10.16.1 because
Samsung store setup is platform-specific. Every path:

- load CustomerInfo and Offering `default`;
- gate Pro on the active `pro` entitlement;
- present the dashboard Paywall only from Settings, after onboarding value;
- present the platform subscription-management surface for a Pro customer;
- restore purchases and refresh entitlement state;
- keep all local recovery usable when billing is unavailable.

Anonymous RevenueCat identity is the default. After Auth0 login, the stable
Auth0 `sub` is passed to RevenueCat `logIn`; logout is called only when the SDK
is non-anonymous. Local threads are not tied to either identity and are never
deleted on account switching.

## Public key injection

Use ignored `android/local.properties`:

```properties
REVENUECAT_TEST_API_KEY=test_...
REVENUECAT_PLAY_API_KEY=goog_...
REVENUECAT_GALAXY_API_KEY=galx_...
```

Never put RevenueCat secret API keys, Stripe secrets, Google service accounts,
or Samsung seller credentials in the app.

For iOS and macOS, copy `apple/Config/Secrets.xcconfig.example` to the ignored
`apple/Config/Secrets.xcconfig`, and set `REVENUECAT_API_KEY` to the public
Apple SDK key. The Apple app requires current monthly and annual packages
before it offers the Paywall. Both platforms use entitlement `pro` and restore
purchases. iOS opens Customer Center through RevenueCatUI. RevenueCat 5.82.0
does not expose Customer Center on macOS, so the Mac app opens Apple's
subscription-management surface for billing and cancellation.

Upload an App Store Connect In-App Purchase key to the RevenueCat Apple app
before you test transactions. Purchases SDK 5 requires this dashboard
credential to record StoreKit 2 transactions. Keep the private `.p8` key in
App Store Connect and RevenueCat; don't add it to this repository or an app
configuration file.

## Required proof

On `playDebug`, prove the published Paywall renders monthly and yearly, dismiss
loses no local state, purchase activates `pro`, relaunch retains it, restore
works, and Customer Center refreshes state. Repeat while authenticated and
confirm RevenueCat uses the Auth0 `sub`.

Real Play proof requires an uploaded signed AAB and license tester. Galaxy
proof requires its catalog, RevenueCat Galaxy app, signed build, and a physical
Samsung device. Apple proof requires App Store Connect products, an In-App
Purchase key configured in RevenueCat, a signed app, and sandbox accounts on
iOS and macOS. Verify Customer Center on iOS and Apple's subscription manager
on macOS. Current dashboard assumptions and remaining owner work are in
`MANUAL_SETUP.md`.
