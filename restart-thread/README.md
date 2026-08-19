# Restart Thread

Restart Thread is a local-first recovery app for Android, iOS, and macOS. A user
records or types where they stopped, checks one proposed next action, and
returns to that thread without losing context.

Android uses Kotlin Multiplatform with selectively shared Compose UI. The Apple
port uses a native Swift 6 package shared by SwiftUI apps for iOS and macOS.
Each host owns Auth0 Universal Login, microphone and recording, encrypted
storage, launcher assets, widget behavior, deep links, and store billing.
Cloudflare is the account and optional remote-processing boundary; thread text
and audio remain on the device.

## What is implemented

The supported hosts now cover the complete local recovery loop and their
platform-native integrations.

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
- native iOS and macOS apps with the same 13 routes, one-current-thread rule,
  encrypted Keychain-backed vault, voice capture, and exact deep links;
- a shared WidgetKit extension, macOS Settings scene and commands, native share
  and save surfaces, Apple app icons, and accessible adaptive layouts;
- Auth0.swift Universal Login and RevenueCat Paywall, restore, entitlement, and
  identity handoff on both Apple platforms, with Customer Center on iOS and
  Apple subscription management on macOS;
- Cloudflare Auth0 JWT verification, account allowance status, and cloud-account
  deletion without receiving thread content.

## Repository map

Use these directories to find each platform boundary and its supporting
contracts.

- `android/shared` — thread domain, route coordinator, shared Compose UI, and
  RevenueCat KMP behavior.
- `android/app` — Android host, Auth0, encrypted vault, recording, launcher,
  widget, deep links, haptics, Play, and Galaxy adapters.
- `apple` — shared Swift domain and platform services, native iOS and macOS app
  targets, WidgetKit extension, tests, XcodeGen project spec, and assets.
- `iosApp` — archived Kotlin Multiplatform iOS host experiment; use `apple` for
  supported Apple builds.
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

On macOS, generate and verify the Apple port:

```bash
cd apple
xcodegen generate --spec project.yml
swift test
xcodebuild -project RestartThread.xcodeproj -scheme "RestartThread iOS" \
  -destination "generic/platform=iOS Simulator" CODE_SIGNING_ALLOWED=NO build
xcodebuild -project RestartThread.xcodeproj -scheme "RestartThread macOS" \
  -destination "platform=macOS" CODE_SIGNING_ALLOWED=NO build
```

See `apple/README.md` and `MANUAL_SETUP.md` before attempting Auth0, a real
purchase, Cloudflare account deletion, a device test, or a store submission.
Never commit `android/local.properties`, `apple/Config/Secrets.xcconfig`,
`backend/.env`, signing files, or server secrets.
