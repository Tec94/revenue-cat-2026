#!/usr/bin/env python3
"""Verify that the native Apple port covers the Android product contract."""

from __future__ import annotations

import re
import sys
from pathlib import Path


APPLE_ROOT = Path(__file__).resolve().parents[1]
PROJECT_ROOT = APPLE_ROOT.parent
ANDROID_SHARED = PROJECT_ROOT / "android" / "shared" / "src" / "commonMain" / "kotlin"


def read(path: Path) -> str:
    try:
        return path.read_text(encoding="utf-8")
    except OSError as error:
        raise AssertionError(f"could not read {path}: {error}") from error


def enum_body(text: str, declaration: str) -> str:
    match = re.search(rf"{re.escape(declaration)}[^{{]*\{{(?P<body>.*?)\}}", text, re.DOTALL)
    if not match:
        raise AssertionError(f"missing enum declaration: {declaration}")
    return match.group("body")


def kotlin_enum(text: str, name: str) -> set[str]:
    body = enum_body(text, f"enum class {name}")
    return {
        match.group(1).replace("_", "").lower()
        for match in re.finditer(r"^\s*([A-Z][A-Z0-9_]*)\s*,?\s*$", body, re.MULTILINE)
    }


def swift_enum(text: str, name: str) -> set[str]:
    body = enum_body(text, f"enum {name}")
    return {
        match.group(1).lower()
        for match in re.finditer(r"^\s*case\s+([A-Za-z][A-Za-z0-9]*)", body, re.MULTILINE)
    }


def assert_equal(label: str, android: set[str], apple: set[str]) -> None:
    missing = sorted(android - apple)
    extra = sorted(apple - android)
    if missing or extra:
        raise AssertionError(f"{label} mismatch; missing={missing}, extra={extra}")
    print(f"verified {label}: {len(android)} symbols")


def kotlin_actions(text: str) -> set[str]:
    start = text.find("data class RestartThreadUiActions(")
    if start < 0:
        raise AssertionError("missing RestartThreadUiActions declaration")
    block = text[start:]
    end = re.search(r"^\)\s*$", block, re.MULTILINE)
    if not end:
        raise AssertionError("unterminated RestartThreadUiActions declaration")
    return set(re.findall(r"^\s*val\s+([A-Za-z][A-Za-z0-9]*):", block[: end.end()], re.MULTILINE))


def swift_public_methods(*texts: str) -> set[str]:
    return {
        method
        for text in texts
        for method in re.findall(r"^\s*public\s+func\s+([A-Za-z][A-Za-z0-9]*)", text, re.MULTILINE)
    }


def assert_contains(label: str, text: str, required: dict[str, str]) -> None:
    missing = sorted(name for name, token in required.items() if token not in text)
    if missing:
        raise AssertionError(f"{label} is missing: {missing}")
    print(f"verified {label}: {len(required)} requirements")


def string_argument(text: str, method: str) -> str:
    match = re.search(rf"\.{re.escape(method)}\(\s*\"([^\"]+)\"", text, re.DOTALL)
    if not match:
        raise AssertionError(f"missing string argument for {method}")
    return match.group(1)


def platform_slice(text: str, platform: str) -> str:
    """Return source active for one Apple OS for the simple os(...) guards used here."""
    output: list[str] = []
    stack: list[tuple[bool, bool, bool]] = []
    active = True

    for line in text.splitlines():
        stripped = line.strip()
        condition = re.fullmatch(r"#if os\((iOS|macOS)\)", stripped)
        alternate = re.fullmatch(r"#elseif os\((iOS|macOS)\)", stripped)
        if condition:
            matches = condition.group(1) == platform
            stack.append((active, matches, active and matches))
            active = active and matches
        elif alternate:
            if not stack:
                raise AssertionError("unmatched #elseif in Apple source")
            parent_active, branch_taken, _ = stack[-1]
            matches = not branch_taken and alternate.group(1) == platform
            stack[-1] = (parent_active, branch_taken or matches, parent_active and matches)
            active = parent_active and matches
        elif stripped == "#else":
            if not stack:
                raise AssertionError("unmatched #else in Apple source")
            parent_active, branch_taken, _ = stack[-1]
            matches = not branch_taken
            stack[-1] = (parent_active, True, parent_active and matches)
            active = parent_active and matches
        elif stripped == "#endif":
            if not stack:
                raise AssertionError("unmatched #endif in Apple source")
            parent_active, _, _ = stack.pop()
            active = parent_active
        elif active:
            output.append(line)

    if stack:
        raise AssertionError("unterminated platform guard in Apple source")
    return "\n".join(output)


def verify_platform_boundaries() -> None:
    shared_paths = sorted(
        [
            *APPLE_ROOT.glob("Sources/**/*.swift"),
            *APPLE_ROOT.glob("Widget/**/*.swift"),
        ]
    )
    target_paths = {
        "iOS": [*shared_paths, *sorted(APPLE_ROOT.glob("Apps/iOS/**/*.swift"))],
        "macOS": [*shared_paths, *sorted(APPLE_ROOT.glob("Apps/macOS/**/*.swift"))],
    }
    forbidden = {
        "iOS": {
            "AppKit": "import AppKit",
            "NSApplication": "NSApp",
            "NSWorkspace": "NSWorkspace",
            "NSSavePanel": "NSSavePanel",
            "macOS haptics": "NSHapticFeedbackManager",
            "macOS microphone authorization": "AVCaptureDevice",
        },
        "macOS": {
            "UIKit": "import UIKit",
            "UIApplication": "UIApplication",
            "UIViewController": "UIViewController",
            "UIActivityViewController": "UIActivityViewController",
            "UINavigationController": "UINavigationController",
            "UITabBarController": "UITabBarController",
            "UIWindowScene": "UIWindowScene",
            "iOS haptics": "UINotificationFeedbackGenerator",
            "iOS audio session": "AVAudioSession",
            "iOS Customer Center": "CustomerCenterView",
            "iOS file protection": "FileProtectionType",
        },
    }

    for platform, paths in target_paths.items():
        active_source = "\n".join(platform_slice(read(path), platform) for path in paths)
        leaks = sorted(
            name for name, token in forbidden[platform].items() if token in active_source
        )
        if leaks:
            raise AssertionError(f"{platform} target contains foreign platform APIs: {leaks}")
        print(
            f"verified {platform} framework boundaries: "
            f"{len(forbidden[platform])} foreign APIs excluded"
        )


def verify() -> None:
    android_controller = read(
        ANDROID_SHARED
        / "com"
        / "restartthread"
        / "shared"
        / "presentation"
        / "RestartThreadController.kt"
    )
    android_models = read(
        ANDROID_SHARED / "com" / "restartthread" / "shared" / "domain" / "RecoveryThread.kt"
    )
    android_actions = read(
        ANDROID_SHARED
        / "com"
        / "restartthread"
        / "shared"
        / "ui"
        / "RestartThreadUiActions.kt"
    )
    android_widget = read(
        PROJECT_ROOT
        / "android"
        / "app"
        / "src"
        / "main"
        / "kotlin"
        / "com"
        / "restartthread"
        / "app"
        / "widget"
        / "RestartThreadWidget.kt"
    )
    android_auth = read(
        PROJECT_ROOT
        / "android"
        / "app"
        / "src"
        / "main"
        / "kotlin"
        / "com"
        / "restartthread"
        / "app"
        / "auth"
        / "AndroidAuthGateway.kt"
    )
    android_platform = read(
        PROJECT_ROOT
        / "android"
        / "app"
        / "src"
        / "main"
        / "kotlin"
        / "com"
        / "restartthread"
        / "app"
        / "platform"
        / "AndroidRestartThreadPlatform.kt"
    )
    android_voice = read(
        PROJECT_ROOT
        / "android"
        / "app"
        / "src"
        / "main"
        / "kotlin"
        / "com"
        / "restartthread"
        / "app"
        / "platform"
        / "VoiceRecorder.kt"
    )
    swift_state = read(APPLE_ROOT / "Sources" / "RestartThreadCore" / "Models" / "AppState.swift")
    swift_models = read(
        APPLE_ROOT / "Sources" / "RestartThreadCore" / "Models" / "RecoveryThread.swift"
    )
    swift_controller = read(
        APPLE_ROOT
        / "Sources"
        / "RestartThreadCore"
        / "Controller"
        / "RestartThreadController.swift"
    )
    swift_app_model = read(
        APPLE_ROOT
        / "Sources"
        / "RestartThreadApple"
        / "Stores"
        / "RestartThreadAppModel.swift"
    )
    swift_root = read(
        APPLE_ROOT
        / "Sources"
        / "RestartThreadApple"
        / "Views"
        / "RestartThreadRootView.swift"
    )
    swift_settings = read(
        APPLE_ROOT
        / "Sources"
        / "RestartThreadApple"
        / "Views"
        / "Screens"
        / "SettingsScreen.swift"
    )
    swift_widget = read(APPLE_ROOT / "Widget" / "RestartThreadWidget.swift")
    swift_auth = read(
        APPLE_ROOT / "Sources" / "RestartThreadApple" / "Services" / "AuthSession.swift"
    )
    swift_subscriptions = read(
        APPLE_ROOT
        / "Sources"
        / "RestartThreadApple"
        / "Services"
        / "SubscriptionService.swift"
    )
    swift_voice = read(
        APPLE_ROOT
        / "Sources"
        / "RestartThreadApple"
        / "Services"
        / "AppleVoiceRecorder.swift"
    )
    swift_platform = read(
        APPLE_ROOT
        / "Sources"
        / "RestartThreadApple"
        / "Services"
        / "AppleRestartThreadPlatform.swift"
    )
    swift_vault = read(
        APPLE_ROOT
        / "Sources"
        / "RestartThreadCore"
        / "Stores"
        / "EncryptedThreadVault.swift"
    )
    project_spec = read(APPLE_ROOT / "project.yml")
    package_spec = read(APPLE_ROOT / "Package.swift")
    ios_config = read(APPLE_ROOT / "Config" / "iOS.xcconfig")
    macos_config = read(APPLE_ROOT / "Config" / "macOS.xcconfig")
    secrets_example = read(APPLE_ROOT / "Config" / "Secrets.xcconfig.example")

    enum_sources = {
        "AppRoute": (android_controller, swift_state),
        "CaptureProgress": (android_controller, swift_state),
        "SourceKind": (android_models, swift_models),
        "ThreadStatus": (android_models, swift_models),
    }
    for name, (android_text, swift_text) in enum_sources.items():
        assert_equal(name, kotlin_enum(android_text, name), swift_enum(swift_text, name))

    routes = swift_enum(swift_state, "AppRoute")
    rendered_routes = {
        match.lower()
        for match in re.findall(r"case\s+\.([A-Za-z][A-Za-z0-9]*)\s*:", swift_root)
    }
    missing_screens = sorted(routes - rendered_routes)
    if missing_screens:
        raise AssertionError(f"Apple route switch is missing screens: {missing_screens}")
    print(f"verified Apple route rendering: {len(routes)} routes")

    actions = kotlin_actions(android_actions)
    methods = swift_public_methods(swift_controller, swift_app_model)
    platform_action_map = {
        "voice": "voiceTapped",
        "requestWidgetPin": "showWidgetInstructions",
        "showSettings": "openSettings",
        "openPrivacyPolicy": "openExternal",
        "openTerms": "openExternal",
        "openSupport": "openExternal",
    }
    missing_actions = sorted(
        action for action in actions if platform_action_map.get(action, action) not in methods
    )
    if missing_actions:
        raise AssertionError(f"Apple action surface is missing: {missing_actions}")
    print(f"verified Apple action surface: {len(actions)} actions")

    wiring_text = "\n".join(
        read(path)
        for path in sorted(
            [*APPLE_ROOT.glob("Sources/RestartThreadApple/Views/**/*.swift"), *APPLE_ROOT.glob("Apps/**/*.swift")]
        )
    )
    missing_wiring = sorted(
        action
        for action in actions
        if not re.search(
            rf"\b{re.escape(platform_action_map.get(action, action))}\b",
            wiring_text,
        )
    )
    if missing_wiring:
        raise AssertionError(f"Apple UI does not wire actions: {missing_wiring}")
    print(f"verified Apple UI action wiring: {len(actions)} actions")

    android_widget_routes = set(re.findall(r'activityAction\("([a-z]+)"', android_widget))
    apple_widget_routes = set(re.findall(r'routeURL\("([a-z]+)"', swift_widget))
    controller_widget_routes = set(
        re.findall(r'case\s+"([a-z]+)"\s*:', swift_controller)
    )
    assert_equal("widget routes", android_widget_routes, apple_widget_routes)
    missing_handlers = sorted(apple_widget_routes - controller_widget_routes)
    if missing_handlers:
        raise AssertionError(f"Apple widget routes have no controller handler: {missing_handlers}")
    print(f"verified Apple widget route handling: {len(apple_widget_routes)} routes")

    required_links = {
        "privacy": "https://restartthread.app/privacy",
        "terms": "https://restartthread.app/terms",
        "support": "https://restartthread.app/support",
    }
    missing_links = sorted(label for label, url in required_links.items() if url not in swift_settings)
    if missing_links:
        raise AssertionError(f"Apple settings is missing external links: {missing_links}")
    print(f"verified Apple external settings links: {len(required_links)} links")

    android_scopes = set(string_argument(android_auth, "withScope").split())
    apple_scopes = set(string_argument(swift_auth, "scope").split())
    assert_equal("Auth0 scopes", android_scopes, apple_scopes)

    assert_contains(
        "Apple Auth0 account boundary",
        swift_auth,
        {
            "secure credentials": "CredentialsManager(",
            "HTTPS Universal Login": ".useHTTPS()",
            "stable account identity": "profile.sub",
            "authenticated account deletion": 'request.httpMethod = "DELETE"',
            "bearer authorization": 'forHTTPHeaderField: "Authorization"',
            "invalid-session clearing": "try? credentialsManager.clear()",
        },
    )
    assert_contains(
        "Apple RevenueCat behavior",
        swift_subscriptions + swift_root + swift_settings + swift_app_model,
        {
            "pro entitlement": 'proEntitlement = "pro"',
            "monthly package": "current?.monthly != nil",
            "annual package": "current?.annual != nil",
            "identity login": ".logIn(",
            "anonymous logout": ".logOut()",
            "purchase restoration": ".restorePurchases()",
            "paywall": "PaywallView()",
            "customer center": "CustomerCenterView()",
            "macOS subscription management": "https://apps.apple.com/account/subscriptions",
            "signed-out identity handoff": "hasResolvedAuth",
        },
    )
    customer_center_guard = re.compile(
        r"#if os\(iOS\)\s+CustomerCenterView\(\)\s+#else\s+EmptyView\(\)\s+#endif"
    )
    missing_customer_center_guards = [
        label
        for label, text in {
            "root subscription sheet": swift_root,
            "settings subscription sheet": swift_settings,
        }.items()
        if not customer_center_guard.search(text)
    ]
    if missing_customer_center_guards:
        raise AssertionError(
            "RevenueCat CustomerCenterView must be excluded from macOS: "
            f"{missing_customer_center_guards}"
        )
    print("verified iOS-only RevenueCat Customer Center guards: 2 surfaces")
    assert_contains(
        "Apple encrypted local-data boundary",
        swift_vault + swift_platform,
        {
            "AES-GCM encryption": "AES.GCM.seal",
            "AES-GCM decryption": "AES.GCM.open",
            "Keychain key": "SecItemCopyMatching",
            "App Group vault": "containerURL(",
            "backup exclusion": "isExcludedFromBackup = true",
            "encrypted voice": "try vault.saveVoice",
            "encrypted thread": "try vault.saveThread",
            "widget refresh": "WidgetCenter.shared.reloadAllTimelines()",
        },
    )

    android_duration = re.search(r"MAX_DURATION_MS\s*=\s*([\d_]+)", android_voice)
    apple_duration = re.search(r"record\(forDuration:\s*([\d_]+)\)", swift_voice)
    if not android_duration or not apple_duration:
        raise AssertionError("could not derive voice recording duration")
    android_seconds = int(android_duration.group(1).replace("_", "")) // 1_000
    apple_seconds = int(apple_duration.group(1).replace("_", ""))
    if android_seconds != apple_seconds:
        raise AssertionError(
            f"voice duration mismatch; Android={android_seconds}s Apple={apple_seconds}s"
        )
    print(f"verified voice recording duration: {apple_seconds} seconds")

    onboarding_key = re.search(r'getBoolean\("([^\"]+)"', android_platform)
    if not onboarding_key or onboarding_key.group(1) not in swift_platform:
        raise AssertionError("Apple onboarding persistence key differs from Android")
    print("verified onboarding persistence key")

    assert_contains(
        "Apple lifecycle and presentation behavior",
        swift_root + swift_settings + swift_app_model,
        {
            "foreground refresh": "model.resume()",
            "recording cancellation": "controller.close()",
            "permission refresh": "voiceRecorder.permissionState",
            "subscription refresh": "subscriptions.refresh()",
            "macOS-local billing sheet": "localSubscriptionSurface",
        },
    )
    verify_platform_boundaries()
    assert_contains(
        "Apple native targets",
        project_spec + package_spec,
        {
            "iOS app": "RestartThread iOS:",
            "macOS app": "RestartThread macOS:",
            "iOS widget": "RestartThread Widget iOS:",
            "macOS widget": "RestartThread Widget macOS:",
            "shared Swift domain": 'name: "RestartThreadCore"',
            "Auth0 dependency": 'exact: "3.0.2"',
            "RevenueCat dependency": 'exact: "5.82.0"',
            "privacy manifest": "PrivacyInfo.xcprivacy",
        },
    )
    assert_contains(
        "per-platform Auth0 client configuration",
        ios_config + macos_config + secrets_example,
        {
            "iOS client": "AUTH0_IOS_CLIENT_ID",
            "macOS client": "AUTH0_MACOS_CLIENT_ID",
            "iOS mapping": "AUTH0_CLIENT_ID = $(AUTH0_IOS_CLIENT_ID)",
            "macOS mapping": "AUTH0_CLIENT_ID = $(AUTH0_MACOS_CLIENT_ID)",
        },
    )


if __name__ == "__main__":
    try:
        verify()
    except AssertionError as error:
        print(f"port parity verification failed: {error}", file=sys.stderr)
        raise SystemExit(1) from error
