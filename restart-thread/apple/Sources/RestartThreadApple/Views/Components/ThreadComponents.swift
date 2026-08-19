import RestartThreadCore
import SwiftUI

struct ThreadListCard: View {
    let threads: [RecoveryThread]
    let onOpen: (String) -> Void

    var body: some View {
        VStack(spacing: 0) {
            ForEach(Array(threads.enumerated()), id: \.element.id) { index, thread in
                Button { onOpen(thread.id) } label: {
                    HStack(spacing: 14) {
                        Circle().fill(.tint).frame(width: 10, height: 10)
                        VStack(alignment: .leading, spacing: 5) {
                            Text(thread.proposedAction)
                                .font(.body.weight(.semibold))
                                .foregroundStyle(.primary)
                                .lineLimit(2)
                            Text(thread.capturedText)
                                .font(.subheadline)
                                .foregroundStyle(.secondary)
                                .lineLimit(2)
                        }
                        .frame(maxWidth: .infinity, alignment: .leading)
                        Image(systemName: "chevron.right")
                            .foregroundStyle(.secondary)
                            .accessibilityHidden(true)
                    }
                    .padding(.horizontal, 18)
                    .padding(.vertical, 16)
                    .contentShape(Rectangle())
                }
                .buttonStyle(.plain)
                .contextMenu {
                    Button("Open thread") { onOpen(thread.id) }
                }
                if index != threads.count - 1 { Divider().padding(.horizontal, 18) }
            }
        }
        .background(.background, in: RoundedRectangle(cornerRadius: 18, style: .continuous))
    }
}

struct SettingsCard<Content: View>: View {
    let title: String
    var summary: String?
    var badge: String?
    let content: Content

    init(
        title: String,
        summary: String? = nil,
        badge: String? = nil,
        @ViewBuilder content: () -> Content
    ) {
        self.title = title
        self.summary = summary
        self.badge = badge
        self.content = content()
    }

    var body: some View {
        VStack(alignment: .leading, spacing: 16) {
            HStack(alignment: .top) {
                VStack(alignment: .leading, spacing: 5) {
                    Text(title).font(.title3.weight(.semibold)).accessibilityAddTraits(.isHeader)
                    if let summary { Text(summary).foregroundStyle(.secondary) }
                }
                Spacer()
                if let badge { StatusPill(text: badge) }
            }
            content
        }
        .frame(maxWidth: .infinity, alignment: .leading)
        .padding(20)
        .background(.background, in: RoundedRectangle(cornerRadius: 20, style: .continuous))
    }
}

struct SettingsActionRow: View {
    let title: String
    var supporting: String?
    var destructive = false
    let action: () -> Void

    init(
        title: String,
        supporting: String? = nil,
        destructive: Bool = false,
        action: @escaping () -> Void
    ) {
        self.title = title
        self.supporting = supporting
        self.destructive = destructive
        self.action = action
    }

    var body: some View {
        Button(action: action) {
            HStack(spacing: 12) {
                VStack(alignment: .leading, spacing: 3) {
                    Text(title)
                        .font(.body.weight(.semibold))
                        .foregroundStyle(destructive ? Color.red : Color.primary)
                    if let supporting {
                        Text(supporting).font(.subheadline).foregroundStyle(.secondary)
                    }
                }
                .frame(maxWidth: .infinity, alignment: .leading)
                Image(systemName: "chevron.right")
                    .foregroundStyle(destructive ? Color.red : Color.secondary)
                    .accessibilityHidden(true)
            }
            .padding(.horizontal, 16)
            .padding(.vertical, 13)
            .frame(minHeight: 56)
            .background(.quaternary, in: RoundedRectangle(cornerRadius: 12, style: .continuous))
        }
        .buttonStyle(.plain)
    }
}
