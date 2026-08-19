import RestartThreadCore
import SwiftUI
import WidgetKit

private struct RestartThreadWidgetEntry: TimelineEntry {
    let date: Date
    let current: RecoveryThread?
}

private struct RestartThreadTimelineProvider: TimelineProvider {
    func placeholder(in context: Context) -> RestartThreadWidgetEntry {
        RestartThreadWidgetEntry(
            date: Date(),
            current: RecoveryThread(
                id: "preview",
                createdAtEpochMs: 0,
                sourceKind: .text,
                capturedText: "I stopped while comparing the two plans.",
                proposedAction: "Open the pricing sheet and confirm the cancellation fee."
            )
        )
    }

    func getSnapshot(in context: Context, completion: @escaping (RestartThreadWidgetEntry) -> Void) {
        completion(entry())
    }

    func getTimeline(in context: Context, completion: @escaping (Timeline<RestartThreadWidgetEntry>) -> Void) {
        completion(Timeline(entries: [entry()], policy: .never))
    }

    private func entry() -> RestartThreadWidgetEntry {
        RestartThreadWidgetEntry(
            date: Date(),
            current: Self.loadVault()?.listThreads().first { $0.status == .active }
        )
    }

    private static func loadVault() -> EncryptedThreadVault? {
        let appGroup = Bundle.main.object(forInfoDictionaryKey: "APP_GROUP_IDENTIFIER") as? String
            ?? "group.com.restartthread.app"
        let keychainGroup = Bundle.main.object(forInfoDictionaryKey: "KEYCHAIN_ACCESS_GROUP") as? String
        return try? EncryptedThreadVault(
            appGroupIdentifier: appGroup,
            keychainAccessGroup: keychainGroup
        )
    }
}

private struct RestartThreadWidgetView: View {
    @Environment(\.widgetFamily) private var family
    let entry: RestartThreadWidgetEntry

    var body: some View {
        VStack(alignment: .leading, spacing: 10) {
            HStack(spacing: 8) {
                Image(systemName: "arrow.forward.circle.fill")
                    .font(.title2)
                Text("Restart Thread").font(.headline)
            }
            if let current = entry.current {
                Text(current.proposedAction)
                    .font(.headline)
                    .lineLimit(family == .systemSmall ? 3 : 2)
                if family != .systemSmall {
                    Text(current.capturedText)
                        .font(.caption)
                        .foregroundStyle(.secondary)
                        .lineLimit(2)
                }
                Spacer(minLength: 0)
                HStack {
                    Link("Return", destination: routeURL("thread", id: current.id))
                    if family != .systemSmall {
                        Link("Update", destination: routeURL("update", id: current.id))
                    }
                }
                .font(.caption.weight(.semibold))
            } else {
                Text("No active thread").font(.headline)
                Spacer(minLength: 0)
                Link("Leave one", destination: routeURL("capture"))
                    .font(.caption.weight(.semibold))
            }
        }
        .restartWidgetBackground()
    }

    private func routeURL(_ route: String, id: String? = nil) -> URL {
        var components = URLComponents()
        components.scheme = "restartthread"
        components.host = route
        if let id { components.queryItems = [URLQueryItem(name: "id", value: id)] }
        return components.url!
    }
}

private extension View {
    @ViewBuilder
    func restartWidgetBackground() -> some View {
        if #available(iOS 17.0, macOS 14.0, *) {
            containerBackground(for: .widget) {
                Color(red: 250 / 255, green: 250 / 255, blue: 247 / 255)
            }
        } else {
            background(Color(red: 250 / 255, green: 250 / 255, blue: 247 / 255))
        }
    }
}

private struct RestartThreadWidget: Widget {
    let kind = "RestartThreadWidget"

    var body: some WidgetConfiguration {
        StaticConfiguration(kind: kind, provider: RestartThreadTimelineProvider()) { entry in
            RestartThreadWidgetView(entry: entry)
        }
        .configurationDisplayName("Restart Thread")
        .description("Return to the current thread or leave a new stopping point.")
        .supportedFamilies([.systemSmall, .systemMedium, .systemLarge])
    }
}

@main
struct RestartThreadWidgetBundle: WidgetBundle {
    var body: some Widget {
        RestartThreadWidget()
    }
}
