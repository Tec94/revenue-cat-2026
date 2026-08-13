# Restart Thread manual setup

This is the owner checklist for external state that cannot be completed from
the repository. Status reflects repository verification on August 13, 2026.
Do not paste credentials into tracked files or chat.

## Ready in the repository

- Fresh installs open the value-first Welcome screen, not Capture.
- The example is in-memory only and calls no storage, network, permission,
  Auth0, RevenueCat, or content analytics path.
- Local text, voice, thread lifecycle, Now, history, deletion/restore, process
  state restoration, adaptive icons, and the Glance widget are implemented.
- Auth0 Universal Login, encrypted credential storage, RevenueCat identity
  handoff, and Cloudflare access-token verification are implemented but remain
  disabled when public Auth0 configuration is blank.
- Play and Galaxy debug APKs assemble. Shared lifecycle tests and backend tests
  pass.
- RevenueCat Test Store Offering `default`, packages, Paywall, Customer Center,
  and entitlement `pro` were already configured in the prior dashboard audit.

## 1. Configure local Android public values

Copy `android/local.properties.example` to ignored
`android/local.properties`. Preserve the existing RevenueCat test key. Add the
Android SDK path and, after the Auth0 and Cloudflare steps below, the public
Auth0 values and Worker origin.

No Auth0 client secret, RevenueCat secret key, Stripe secret, Google service
credential, Samsung seller credential, or Cloudflare secret belongs in this
file.

## 2. Create the Auth0 Native application

In Auth0:

1. Create a **Native** application for `com.restartthread.app`.
2. Create an API with the identifier used as `AUTH0_AUDIENCE` and add scopes
   `account:read`, `account:delete`, and `recovery:create`.
3. Enable Universal Login's Identifier First profile, Google, and passwordless
   email OTP.
4. Add these HTTPS URLs, replacing the tenant domain:

   ```text
   https://YOUR_DOMAIN/android/com.restartthread.app/callback
   ```

   Use it in both Allowed Callback URLs and Allowed Logout URLs.
5. Register package `com.restartthread.app` and every debug/release SHA-256
   signing-certificate fingerprint under the application's device settings.
6. Put the Auth0 domain, public Native client ID, and API audience in ignored
   `android/local.properties`.

Obtain the debug fingerprint after an APK exists:

```powershell
keytool -printcert -jarfile android\app\build\outputs\apk\play\debug\app-play-debug.apk
```

Auth0 cancellation, missing browser, network failure, invalid identity, and
expired credentials fall back to optional local use. Test each state on a
device with a modern browser.

## 3. Configure Cloudflare account identity

Edit the non-secret values in `backend/wrangler.jsonc` for both development
and production:

- `AUTH0_ISSUER_BASE_URL=https://YOUR_DOMAIN/`
- `AUTH0_AUDIENCE` equal to the Auth0 API identifier.

Create a separate Auth0 Machine-to-Machine application authorized only for the
Management API `delete:users` permission. Store its client ID and
secret as Worker secrets, not mobile values:

```powershell
cd backend
cmd /c npx wrangler secret put AUTH0_MANAGEMENT_CLIENT_ID
cmd /c npx wrangler secret put AUTH0_MANAGEMENT_CLIENT_SECRET
cmd /c npm run d1:migrate:dev
cmd /c npm run d1:migrate:production
cmd /c npm run deploy
cmd /c npm run deploy:production
```

Set `BACKEND_BASE_URL` in Android to the chosen deployed Worker origin. Then
prove allowance lookup and deletion with a real Auth0 access token. Account
deletion must remove Auth0/D1 account data while leaving local threads intact.

## 4. Run locally

Create or connect an Android target. Use a Google APIs emulator image with a
modern browser for Auth0; use a physical Galaxy device for Samsung checkout
and OEM behavior.

Open `android` in Android Studio, select `playDebug`, and run the `app`
configuration. Or use:

```powershell
cd android
$env:JAVA_HOME = "C:\Program Files\Android\Android Studio\jbr"
.\gradlew.bat installPlayDebug
```

Verify before feature work continues:

1. Fresh install opens Welcome and both value paths complete.
2. Denying microphone leaves text capture fully usable.
3. A real Start appears on Now and in the home widget.
4. Return and Update widget actions open the exact current record.
5. App, round, and themed launcher icons render without stale launcher cache.
6. Auth0 login changes RevenueCat to the Auth0 `sub`; logout returns to an
   anonymous RevenueCat identity without deleting local threads.
7. RevenueCat Test Store purchase, restore, relaunch, and Customer Center keep
   entitlement `pro` consistent.

## 5. Store accounts and billing

Google Play account verification and app creation are still required for real
Play billing. Create `monthly` and `yearly`, connect Play credentials to
RevenueCat, upload a signed AAB to a testing track, and add license testers.

Samsung Seller Portal, the Galaxy app/catalog, RevenueCat Galaxy app/key, and a
physical Galaxy purchase remain required. A Play purchase or emulator does not
prove Samsung Checkout.

Stripe is connected through RevenueCat Billing, but usable web checkout still
needs web products and the same Auth0/RevenueCat identity proof. Keep all
Stripe secrets server-side.

## 6. Release gates

Before public release, replace the placeholder privacy, terms, and support
URLs in `MainActivity.kt`; publish those pages; test account deletion; finish
Play/Galaxy data-safety forms; verify accessibility at large text and with
TalkBack; test fold, landscape, multi-window, reduced motion, and physical
Galaxy widget behavior; create signing assets and store listings; and complete
the planned usability study. Lock-screen recording remains excluded until
physical-device behavior is proven.
