# Restart Thread

Restart Thread is an Android-first, local-first recovery app. A user records or
types where they stopped, checks one proposed next action, and returns to that
thread without losing context.

The current implementation uses Kotlin Multiplatform with selectively shared
Compose UI. Android owns Auth0 Universal Login, microphone and recording,
encrypted storage, launcher assets, app-widget behavior, intents, and
store-specific billing. Cloudflare is the selected account and optional remote
processing boundary; thread text and audio remain on the device.

## What is implemented

- value-first onboarding with a disposable interactive example;
- optional Auth0 account offer after the first demonstrated value;
- Now, capture, review, verified Start, history, detail, search, archive,
  completion, export, deletion, restore, and Recently Deleted screens;
- one-current-thread enforcement with an explicit switch decision;
- encrypted vault migration from the existing v1 record to lifecycle-aware v2;
- Play and Galaxy RevenueCat paths for entitlement `pro`, Paywall, Customer
  Center, restore, and Auth0 identity handoff;
- adaptive, round, and themed launcher art from the canonical SVG mark;
- a responsive Jetpack Glance home widget with exact Return, Update, and Leave
  routes;
- Cloudflare Auth0 JWT verification, account allowance status, and cloud-account
  deletion without receiving thread content.

## Repository map

- `android/shared` — thread domain, route coordinator, shared Compose UI, and
  RevenueCat KMP behavior.
- `android/app` — Android host, Auth0, encrypted vault, recording, launcher,
  widget, deep links, haptics, Play, and Galaxy adapters.
- `backend` — Cloudflare Worker, D1 migrations, Auth0 API boundary, and optional
  Workers AI recovery path.
- `design` and `DESIGN.md` — canonical brand assets and Forward Thread system.
- `MANUAL_SETUP.md` — owner-only console, credential, device, and store work.
- `KMP_ARCHITECTURE.md` and `REVENUECAT_SETUP.md` — implementation contracts.

## Verification

Use Android Studio's bundled JDK when the system JDK causes Windows ZIP-file
locks.

```powershell
cd backend
cmd /c npm run check

cd ..\android
$env:JAVA_HOME = "C:\Program Files\Android\Android Studio\jbr"
.\gradlew.bat :shared:testAndroidHostTest :app:assemblePlayDebug
.\gradlew.bat :app:assembleGalaxyDebug
```

See `MANUAL_SETUP.md` before attempting Auth0, a real purchase, Cloudflare
account deletion, a physical Galaxy test, or a store submission. Never commit
`android/local.properties`, `backend/.env`, signing files, or server secrets.
