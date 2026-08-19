# Restart Thread for iOS and macOS

The Apple port provides native SwiftUI apps for iOS and macOS, backed by one
Swift 6 package and a shared WidgetKit extension. It preserves the Android
product behavior while using Apple-native storage, authentication, billing,
recording, window, menu, export, and accessibility surfaces.

## Requirements

You need macOS with Xcode 16.4, Swift 6, and XcodeGen 2.46.0 or later. The app
targets iOS 15 or later and macOS 12 or later. A paid Apple Developer account is
required for app groups, shared Keychain access, and Auth0 Universal Links.

## Configure public app values

The checked-in defaults keep local use available while Auth0 and RevenueCat are
unconfigured. Add only public client values to the ignored configuration file.

1. Copy `Config/Secrets.xcconfig.example` to
   `Config/Secrets.xcconfig`.
2. Set the shared Auth0 domain and API audience.
3. Set separate public Auth0 Native client IDs for iOS and macOS.
4. Set the deployed Cloudflare Worker origin.
5. Set the public RevenueCat Apple SDK key.

Never add an Auth0 client secret, RevenueCat secret key, App Store Connect key,
or backend credential to an app configuration file.

## Generate and open the project

XcodeGen creates disposable project metadata from `project.yml`; the generated
project is intentionally ignored.

```bash
cd apple
cp Config/Secrets.xcconfig.example Config/Secrets.xcconfig
xcodegen generate --spec project.yml
chmod +x script/build_and_run.sh
open RestartThread.xcodeproj
```

In Xcode, select your development team for both apps and both widget targets.
Register `group.com.restartthread.app` as an App Group, and keep the app and
widget Keychain groups aligned with `KEYCHAIN_ACCESS_GROUP`.

## Configure Auth0 callbacks

Create separate Auth0 Native applications for the two Apple bundle IDs. Add
both the HTTPS and custom-scheme form to **Allowed Callback URLs** and
**Allowed Logout URLs**.

For iOS bundle `com.restartthread.app`, use:

```text
https://YOUR_DOMAIN/ios/com.restartthread.app/callback
com.restartthread.app://YOUR_DOMAIN/ios/com.restartthread.app/callback
```

For macOS bundle `com.restartthread.app.mac`, use:

```text
https://YOUR_DOMAIN/macos/com.restartthread.app.mac/callback
com.restartthread.app.mac://YOUR_DOMAIN/macos/com.restartthread.app.mac/callback
```

For each Auth0 application, configure the Apple Team ID and matching bundle ID
under **Advanced Settings > Device Settings**. The generated entitlements add
`webcredentials:YOUR_DOMAIN`. Auth0 uses Universal Links on supported systems
and the registered bundle-ID scheme on older systems.

## Build and test

Run the package tests first, then compile both app and widget graphs without
code signing:

```bash
python3 script/verify_port_parity.py
python3 script/verify_apple_assets.py
bash -n script/build_and_run.sh
swift test
xcodebuild -project RestartThread.xcodeproj -scheme "RestartThread iOS" \
  -destination "generic/platform=iOS Simulator" CODE_SIGNING_ALLOWED=NO build
xcodebuild -project RestartThread.xcodeproj -scheme "RestartThread macOS" \
  -destination "platform=macOS" CODE_SIGNING_ALLOWED=NO build
```

To build and launch the macOS app from Codex or a terminal, run:

```bash
./script/build_and_run.sh
```

## Verify signed behavior

Unsigned compilation doesn't prove Apple capabilities. With signed builds,
verify these paths on the intended devices:

1. Complete onboarding through both the real and disposable example paths.
2. Deny microphone access, and confirm text capture stays fully usable.
3. Save text and voice, relaunch, and confirm encrypted local restoration.
4. Open Return, Update, and Leave routes from the widget.
5. Sign in and out on both platforms, and confirm local threads remain intact.
6. Purchase and restore `pro`, then open Customer Center on iOS and Apple
   subscription management on macOS.
7. Delete the cloud account, and confirm local threads remain intact.
8. Exercise macOS commands, Settings, export, window resizing, and VoiceOver.
9. Exercise iPhone and iPad layout, Dynamic Type, VoiceOver, and appearance
   changes.

## Next steps

Complete the owner-controlled signing, dashboard, sandbox-purchase, device, and
store-submission work in `../MANUAL_SETUP.md`.
