# Restart Thread setup status

This is the authoritative owner checklist. It records external account,
console, device, signing, policy, and legal work that cannot be completed from
the repository. Do not paste credentials into this file.

Status was verified on August 12, 2026.

## Ready now

The repository can build the Android Test Store application now:

- Kotlin Multiplatform owns the product core and selected Compose UI.
- `playDebug` uses the configured RevenueCat Test Store public key.
- RevenueCat Paywall, Customer Center, purchase, restore, entitlement refresh,
  dismissal, and failure paths are implemented.
- `playDebug` and the shared Android host tests pass.
- `galaxyDebug` has a separate native RevenueCat Galaxy adapter.
- Cloudflare development and production Workers and D1 databases are deployed.
  Remote recovery remains disabled, so local recovery is the source of truth.

The live RevenueCat project already contains:

- a Test Store app;
- current Offering `default`;
- `$rc_monthly` mapped to Test Store product `monthly`;
- `$rc_annual` mapped to Test Store product `yearly`;
- entitlement `pro`, with both products attached;
- the published **Restart Thread Pro** Paywall attached to `default`;
- a default Customer Center configuration;
- RevenueCat Billing connected to the Stripe account.

No sandbox transaction has been recorded yet. The Test Store prices currently
shown are $9.99 monthly and $79.99 yearly. They are synthetic test prices, not
the approved launch hypotheses of $4.99 monthly and $39.99 yearly.

## Before the first local Android launch

Only a runnable Android target is missing. In Android Studio, do either of the
following:

1. Open Device Manager, install a supported Android system image, and create an
   emulator; or
2. connect an Android phone with USB debugging enabled and authorize this PC.

Then open `android` in Android Studio and run the `playDebug` variant. The same
build can be installed from PowerShell after `adb devices` shows the target:

```powershell
cd android
.\gradlew.bat installPlayDebug
```

Google Play Console verification is not required for this first launch or for
RevenueCat Test Store purchases.

## First Test Store subscription test

The RevenueCat dashboard is ready for its first end-to-end sandbox proof. The
published value-first Paywall contains no trial, scarcity, unlimited-use, or
unsupported savings claim. It retains a close control, Restore Purchases,
Terms, and Privacy. The app exposes it only after the verified restart state.

Run this sandbox proof:

1. Complete a recovery and open **Explore Restart Thread Pro**.
2. Confirm monthly and annual packages render from Offering `default`.
3. Close the paywall and confirm the recovery remains available.
4. Purchase either Test Store package and confirm the app returns to recovery.
5. Confirm `pro` is active in the RevenueCat customer record.
6. Relaunch and confirm Pro remains active.
7. Open Customer Center and test restore.
8. Repeat purchase cancellation and simulated failure paths.

## Before real Google Play billing

Your Google Play developer account exists and is still being verified. After
verification:

1. Create the app with application ID `com.restartthread.app` and enable Play
   App Signing.
2. Create `monthly` and `yearly` subscriptions and their base plans. Start with
   the approved price hypotheses and no launch trial; validate prices before
   production.
3. Add the Play app and service credential to RevenueCat, then map both store
   products to `pro` and Offering `default`.
4. Put the public `goog_...` SDK key in ignored `android/local.properties` as
   `REVENUECAT_PLAY_API_KEY`. Never place service-account credentials in the
   app.
5. Create a signed AAB, upload it to a Play testing track, add license testers,
   and satisfy the testing requirements shown in your Play Console account.
6. Prove purchase, pending purchase, restore, grace period, cancellation,
   expiry, offline cache, reinstall, and account switching.

## Before Galaxy billing

1. Create and verify the Samsung Seller Portal account.
2. Create the Galaxy app and its `monthly` and `yearly` subscriptions.
3. Add a RevenueCat Galaxy app, map both products to `pro`, and give RevenueCat
   the required server-side seller credential.
4. Put only the public `galx_...` key in ignored
   `android/local.properties` as `REVENUECAT_GALAXY_API_KEY`.
5. Test the signed Galaxy build on a physical Galaxy device. An emulator or a
   Play purchase does not prove Samsung Checkout.

## RevenueCat Billing and Stripe

Stripe is connected inside RevenueCat Billing as the web payment gateway. No
web products are configured, so web checkout is not part of the local Android
test or launch slice. Before enabling it, create the web products, define how a
web purchase maps to `pro`, and prove the account or redemption path that lets
the app find the same customer. Keep Stripe and RevenueCat secret keys on the
server; the mobile app must never contain them.

## Cloudflare, iOS, and release work

Cloudflare is provisioned but intentionally feature-gated. Before enabling
remote recovery, review processor terms and the privacy policy, confirm the D1
location decision, and pass the audio CPU, grounding, negation, abuse, and
fallback tests documented in `backend/README.md`.

The iOS host still requires MacinCloud, Xcode project creation, Apple Developer
enrollment, signing, native recording and protected storage, an `appl_...`
RevenueCat public key, and simulator plus physical-device proof. Follow
`iosApp/README.md`.

Before any public store submission, also complete the privacy policy, support
and deletion/export instructions, accessibility checks, formative usability
study, app icon, screenshots, descriptions, tester instructions, and signed
release builds.
