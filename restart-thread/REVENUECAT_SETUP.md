# Restart Thread RevenueCat contract

## Stable identifiers

- entitlement: `pro`;
- Offering: `default`;
- monthly package `$rc_monthly` → product `monthly`;
- annual package `$rc_annual` → product `yearly`.

**Restart Thread Pro** is display copy, not an entitlement identifier. The
store and RevenueCat supply localized price and billing terms.

## Implemented behavior

Play and future iOS use RevenueCat KMP 3.4.0. Galaxy uses native RevenueCat
Android 10.16.1 because Samsung store setup is platform-specific. Both paths:

- load CustomerInfo and Offering `default`;
- gate Pro on the active `pro` entitlement;
- present the dashboard Paywall only from Settings, after onboarding value;
- present Customer Center for a Pro customer;
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

## Required proof

On `playDebug`, prove the published Paywall renders monthly and yearly, dismiss
loses no local state, purchase activates `pro`, relaunch retains it, restore
works, and Customer Center refreshes state. Repeat while authenticated and
confirm RevenueCat uses the Auth0 `sub`.

Real Play proof requires an uploaded signed AAB and license tester. Galaxy
proof requires its catalog, RevenueCat Galaxy app, signed build, and a physical
Samsung device. Current dashboard assumptions and remaining owner work are in
`MANUAL_SETUP.md`.
