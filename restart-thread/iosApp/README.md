# iOS host scaffold

The portable product core and selected Compose screen already live in
`../android/shared`. This directory records the thin native host that must be
created in Xcode on macOS. It is intentionally not a generated Xcode project:
signing team, bundle identifier, supported devices, and local Xcode settings
require owner confirmation on the Mac.

## Create the host on MacinCloud

1. Install or select a current Xcode and Java 17 for the repository's Gradle
   build. Confirm the machine architecture with `uname -m`.
2. Open `restart-thread/android` once in Android Studio or IntelliJ with Kotlin
   Multiplatform support and let Gradle sync.
3. In Xcode, create an iOS App named **Restart Thread** inside this `iosApp`
   directory with SwiftUI and the final bundle identifier.
4. Set the deployment target to iOS 15. RevenueCat KMP Paywalls and Customer
   Center require iOS 15 even though its core SDK supports older versions.
5. Add a Run Script build phase before **Compile Sources**:

   ```sh
   cd "$SRCROOT/../android"
   ./gradlew :shared:embedAndSignAppleFrameworkForXcode
   ```

6. Set **User Script Sandboxing** to `No` for the iOS target so Xcode can run
   the Gradle framework task.
7. Copy `Secrets.xcconfig.example` to ignored `Secrets.xcconfig`, replace the
   placeholder with the iOS public RevenueCat app SDK key, and select that file
   as the target's base configuration. Add this Info.plist entry:

   ```text
   REVENUECAT_API_KEY = $(REVENUECAT_API_KEY)
   ```

   The app SDK key is public, but the ignored file prevents accidental app and
   environment mixups. Never put a RevenueCat secret key in the app.
8. Add `NSMicrophoneUsageDescription` with reviewed user-facing copy. Add
   `CADisableMinimumFrameDurationOnPhone` as a Boolean `YES` for Compose
   rendering on high-refresh iPhones.
9. Add the contents of `Templates/RestartThreadComposeView.swift.template` to
   the SwiftUI target after implementing `NativeRestartThreadPlatform`.

RevenueCat KMP 3.4.0 is already linked through the shared static framework. Do
not add a second RevenueCat package through Swift Package Manager or CocoaPods.

On Apple silicon, prove the shared target with:

```sh
cd ../android
./gradlew :shared:compileKotlinIosSimulatorArm64
```

On an Intel Mac, use `:shared:compileKotlinIosX64`. A physical iPhone build uses
the `iosArm64` target through the Xcode integration task.

## Native implementation contract

Create a Swift `NSObject` conforming to the generated
`RestartThreadPlatform` protocol. It must provide:

- UUID generation and epoch-millisecond time;
- protected local save and load for `RecoveryThread`;
- native microphone permission and AVFoundation recording;
- stop-and-save behavior that commits the voice file and thread together;
- cancellation that releases the recorder and removes temporary audio.

Use iOS Data Protection and a Keychain-managed secret for local content. Keep
widget, lock-screen, haptic, notification, and direct StoreKit behavior in the
Swift host. RevenueCat customer state, Paywall, and Customer Center UI remain
in the shared module; the Swift host only injects the Apple public app SDK key.

The template uses constructor injection so previews or tests can supply a
platform implementation without putting OS services into the shared module.

## What does not change

- Cloudflare Worker, D1, Workers AI, secrets, and deployment steps are
  unchanged.
- Google Play uses the shared RevenueCat KMP path. Galaxy remains configured
  through the native Android RevenueCat adapter.
- Apple Developer enrollment, signing, App Store Connect, privacy declarations,
  and physical-device permission testing are still manual owner work.
