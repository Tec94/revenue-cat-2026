import SwiftUI

enum RestartThreadTheme {
    static let paper = Color(red: 250 / 255, green: 250 / 255, blue: 247 / 255)
    static let ink = Color(red: 17 / 255, green: 17 / 255, blue: 17 / 255)
    static let gray = Color(red: 84 / 255, green: 84 / 255, blue: 84 / 255)
    static let action = Color(red: 169 / 255, green: 29 / 255, blue: 58 / 255)
    static let actionEdge = Color(red: 111 / 255, green: 14 / 255, blue: 38 / 255)
    static let darkPaper = Color(red: 13 / 255, green: 13 / 255, blue: 13 / 255)
    static let darkSurface = Color(red: 24 / 255, green: 24 / 255, blue: 24 / 255)
    static let darkAccent = Color(red: 1, green: 130 / 255, blue: 152 / 255)
    static let darkAccentForeground = Color(red: 58 / 255, green: 0, blue: 16 / 255)
    static let darkAccentEdge = Color(red: 122 / 255, green: 18 / 255, blue: 48 / 255)
}

struct RestartThreadBackground: ViewModifier {
    @Environment(\.colorScheme) private var colorScheme

    func body(content: Content) -> some View {
        content
            .foregroundStyle(colorScheme == .dark ? Color.white : RestartThreadTheme.ink)
            .background(colorScheme == .dark ? RestartThreadTheme.darkPaper : RestartThreadTheme.paper)
            .tint(colorScheme == .dark ? RestartThreadTheme.darkAccent : RestartThreadTheme.action)
    }
}

extension View {
    func restartThreadBackground() -> some View { modifier(RestartThreadBackground()) }
}
