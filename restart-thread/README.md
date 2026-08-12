# Restart Thread

Restart Thread is an Android-first, local-first recovery app built with Kotlin
Multiplatform. The first slice commits a user's text or voice state to
protected device storage before it offers any next action or optional cloud
processing.

## Projects

- `DESIGN.md` — canonical Forward Thread visual, component, motion, tactile,
  sound, accessibility, and platform specification.
- `android/shared/` — Kotlin Multiplatform domain logic, presentation state,
  selected Compose UI, and RevenueCat subscription UI for Play and iOS.
- `android/app/` — native Android host, permissions, recording, encrypted
  vault, Play/Galaxy flavors, and the native Galaxy RevenueCat adapter and UI.
- `iosApp/` — SwiftUI host integration notes and a bridge template for the
  shared Compose experience. Xcode project creation remains a Mac step.
- `backend/` — the selected Cloudflare Worker, D1 operational metadata, and
  Workers AI adapter. Remote recovery is feature-gated and user content is not
  persisted.
- `design/` — semantic tokens, reconstructed SVG logo candidates, and the
  locked prototype reference.
- `MANUAL_SETUP.md` — authoritative current status and remaining owner-only
  account, console, device, signing, policy, and legal work.
- `KMP_ARCHITECTURE.md` — shared/native ownership rules and migration map.
- `REVENUECAT_SETUP.md` — concise subscription contract, live dashboard audit,
  paywall specification, and verification procedure.

Cloudflare is the selected remote backend, not a fallback provider. Its use in
the current app flow is optional because Restart Thread must work locally and
save before any remote request. Development and production Workers and D1
databases are provisioned, while both cloud-recovery controls remain off.

## Local verification

```powershell
cd backend
cmd /c npm run check

cd ..\android
.\gradlew.bat :shared:testAndroidHostTest :app:assemblePlayDebug
.\gradlew.bat :app:assembleGalaxyDebug
```

Do not add secrets to tracked files. The Play debug APK builds and the Test
Store catalog, entitlement `pro`, and published Paywall for Offering `default`
are ready. The remaining local proof is an end-to-end Test Store purchase and
restore on an emulator or device. Real Play billing, Galaxy billing, and cloud
recovery remain inactive until their external account and proof gates are
complete.
