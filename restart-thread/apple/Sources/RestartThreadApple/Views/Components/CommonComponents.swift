import RestartThreadCore
import SwiftUI

struct PageIntro: View {
    let eyebrow: String
    let title: String
    var bodyText: String?
    var display = false

    var body: some View {
        VStack(alignment: .leading, spacing: 10) {
            Eyebrow(eyebrow)
            Text(title)
                .font(display ? .system(size: 42, weight: .bold, design: .serif) : .system(size: 34, weight: .bold, design: .serif))
                .accessibilityAddTraits(.isHeader)
                .fixedSize(horizontal: false, vertical: true)
            if let bodyText {
                Text(bodyText)
                    .font(.title3)
                    .foregroundStyle(.secondary)
                    .fixedSize(horizontal: false, vertical: true)
            }
        }
    }
}

struct Eyebrow: View {
    let text: String
    init(_ text: String) { self.text = text }

    var body: some View {
        Text(text.uppercased())
            .font(.caption.weight(.bold))
            .tracking(0.5)
            .foregroundStyle(.tint)
    }
}

struct ContentCard<Content: View>: View {
    let content: Content

    init(@ViewBuilder content: () -> Content) {
        self.content = content()
    }

    var body: some View {
        VStack(alignment: .leading, spacing: 16) { content }
            .frame(maxWidth: .infinity, alignment: .leading)
            .padding(20)
            .background(.background, in: RoundedRectangle(cornerRadius: 18, style: .continuous))
    }
}

struct FocusCard: View {
    let label: String
    let text: String

    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Eyebrow(label)
            Text(text).font(.title3.weight(.semibold)).textSelection(.enabled)
        }
        .frame(maxWidth: .infinity, alignment: .leading)
        .padding(20)
        .background(.quaternary, in: RoundedRectangle(cornerRadius: 18, style: .continuous))
    }
}

struct EvidenceCard: View {
    let label: String
    let text: String

    var body: some View {
        ContentCard {
            Eyebrow(label)
            Text(text).font(.body).textSelection(.enabled)
        }
    }
}

struct PrivacyNote: View {
    let text: String
    init(_ text: String) { self.text = text }

    var body: some View {
        HStack(alignment: .firstTextBaseline, spacing: 12) {
            Circle().fill(.tint).frame(width: 9, height: 9)
            Text(text).foregroundStyle(.secondary)
        }
        .frame(maxWidth: .infinity, alignment: .leading)
        .padding(14)
        .background(.quaternary, in: RoundedRectangle(cornerRadius: 14, style: .continuous))
    }
}

struct StatusBanner: View {
    let text: String
    var body: some View {
        Text(text)
            .frame(maxWidth: .infinity, alignment: .leading)
            .padding(16)
            .background(.quaternary, in: RoundedRectangle(cornerRadius: 14, style: .continuous))
            .accessibilityAddTraits(.updatesFrequently)
    }
}

struct StatusPill: View {
    let text: String
    var body: some View {
        Text(text.uppercased())
            .font(.caption.weight(.bold))
            .tracking(0.4)
            .foregroundStyle(.tint)
            .padding(.horizontal, 12)
            .padding(.vertical, 7)
            .background(.quaternary, in: Capsule())
    }
}

struct PrimaryActionButton: View {
    @Environment(\.colorScheme) private var colorScheme
    let title: String
    var ink = false
    let action: () -> Void

    var body: some View {
        Button(action: action) {
            HStack {
                Circle().fill(foreground).frame(width: 18, height: 18)
                Text(title).fontWeight(.semibold).frame(maxWidth: .infinity)
                Image(systemName: "arrow.right")
                    .font(.body.weight(.semibold))
                    .accessibilityHidden(true)
            }
            .padding(.horizontal, 18)
            .frame(minHeight: 58)
            .foregroundStyle(foreground)
        }
        .buttonStyle(TactileButtonStyle(ink: ink))
        .accessibilityHint("Activates \(title)")
    }

    private var foreground: Color {
        !ink && colorScheme == .dark ? RestartThreadTheme.darkAccentForeground : .white
    }
}

private struct TactileButtonStyle: ButtonStyle {
    @Environment(\.colorScheme) private var colorScheme
    @Environment(\.accessibilityReduceMotion) private var reduceMotion
    let ink: Bool

    func makeBody(configuration: Configuration) -> some View {
        let face = ink ? RestartThreadTheme.ink : (colorScheme == .dark ? RestartThreadTheme.darkAccent : RestartThreadTheme.action)
        let edge = ink
            ? Color.black
            : (colorScheme == .dark ? RestartThreadTheme.darkAccentEdge : RestartThreadTheme.actionEdge)
        configuration.label
            .background(face, in: RoundedRectangle(cornerRadius: 14, style: .continuous))
            .background {
                RoundedRectangle(cornerRadius: 14, style: .continuous)
                    .fill(edge)
                    .offset(y: configuration.isPressed ? 2 : 6)
            }
            .offset(y: configuration.isPressed ? 4 : 0)
            .padding(.bottom, 7)
            .animation(reduceMotion ? nil : .easeOut(duration: 0.1), value: configuration.isPressed)
    }
}

struct SecondaryActionButton: View {
    let title: String
    let action: () -> Void

    var body: some View {
        Button(action: action) {
            Text(title)
                .font(.body.weight(.semibold))
                .frame(maxWidth: .infinity, minHeight: 44)
        }
        .buttonStyle(.bordered)
        .controlSize(.large)
    }
}

struct TertiaryActionButton: View {
    let title: String
    var destructive = false
    let action: () -> Void

    var body: some View {
        Button(role: destructive ? .destructive : nil, action: action) {
            Text(title)
                .font(.body.weight(.semibold))
                .foregroundStyle(destructive ? Color.red : Color.accentColor)
                .frame(maxWidth: .infinity, minHeight: 44)
                .contentShape(Rectangle())
        }
        .buttonStyle(.plain)
    }
}

struct EmptyStateCard: View {
    let title: String
    let bodyText: String
    var actionTitle: String?
    var action: (() -> Void)?

    init(
        title: String,
        bodyText: String,
        actionTitle: String? = nil,
        action: (() -> Void)? = nil
    ) {
        self.title = title
        self.bodyText = bodyText
        self.actionTitle = actionTitle
        self.action = action
    }

    var body: some View {
        ContentCard {
            Text(title).font(.title3.weight(.semibold))
            Text(bodyText).foregroundStyle(.secondary)
            if let actionTitle, let action {
                PrimaryActionButton(title: actionTitle, action: action)
            }
        }
    }
}

struct DottedTrace: View {
    var body: some View {
        HStack(spacing: 8) {
            ForEach(0..<5, id: \.self) { index in
                Circle().fill(.tint).frame(width: index == 2 ? 8 : 5, height: index == 2 ? 8 : 5)
            }
        }
        .frame(maxWidth: .infinity)
        .accessibilityElement(children: .ignore)
        .accessibilityLabel("The first step traces back to the saved source words")
    }
}

struct CaptureProgressView: View {
    let progress: CaptureProgress

    var body: some View {
        if let label {
            PrivacyNote(label)
        }
    }

    private var label: String? {
        switch progress {
        case .idle: nil
        case .saving: "Saving locally…"
        case .saved: "Saved locally"
        case .transcribing: "Transcribing voice note…"
        case .drafting: "Drafting a first step…"
        case .partialSuccess: "Saved locally. Part of the draft needs attention."
        case .voiceOnly: "Voice note saved locally. Transcription is not available yet."
        case .failed: "Not saved yet"
        }
    }
}

struct BrandHeader: View {
    let showBack: Bool
    let showSettings: Bool
    let onBack: () -> Void
    let onSettings: () -> Void

    var body: some View {
        ZStack {
            BrandMark()
                .frame(width: 38, height: 38)
                .offset(x: -1)
                .accessibilityHidden(true)
            HStack {
                if showBack {
                    Button(action: onBack) { Image(systemName: "arrow.left") }
                        .buttonStyle(HeaderIconButtonStyle())
                        .accessibilityLabel("Go back")
                }
                Spacer()
                if showSettings {
                    Button(action: onSettings) { Image(systemName: "gearshape") }
                        .buttonStyle(HeaderIconButtonStyle())
                        .accessibilityLabel("Settings")
                }
            }
        }
        .frame(height: 56)
    }
}

private struct HeaderIconButtonStyle: ButtonStyle {
    func makeBody(configuration: Configuration) -> some View {
        configuration.label
            .font(.system(size: 22, weight: .semibold))
            .frame(width: 48, height: 48)
            .background(.quaternary, in: Circle())
            .opacity(configuration.isPressed ? 0.7 : 1)
    }
}
