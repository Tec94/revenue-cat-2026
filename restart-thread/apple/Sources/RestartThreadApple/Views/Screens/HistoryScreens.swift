import RestartThreadCore
import SwiftUI

struct AllThreadsScreen: View {
    @ObservedObject var controller: RestartThreadController

    var body: some View {
        VStack(alignment: .leading, spacing: 24) {
            PageIntro(
                eyebrow: "Local history",
                title: "All threads",
                bodyText: "Search the words you saved or the first step you chose."
            )
            TextField(
                "Words or first step",
                text: Binding(get: { controller.state.searchQuery }, set: controller.setSearchQuery)
            )
            .textFieldStyle(.roundedBorder)
            .accessibilityLabel("Search threads")

            if visibleThreads.isEmpty {
                EmptyStateCard(
                    title: query.isEmpty ? "No saved threads" : "No matching threads",
                    bodyText: query.isEmpty
                        ? "Threads appear here after you save a stopping point."
                        : "Try a different word from your stopping point or first step."
                )
            } else {
                ForEach(ThreadStatus.allCases.filter { $0 != .deleted }, id: \.self) { status in
                    let section = visibleThreads.filter { $0.status == status }
                    if !section.isEmpty {
                        VStack(alignment: .leading, spacing: 12) {
                            Text(status.displayName)
                                .font(.title3.weight(.semibold))
                                .accessibilityAddTraits(.isHeader)
                            ThreadListCard(threads: section, onOpen: controller.openThread)
                        }
                    }
                }
            }
            SettingsActionRow(
                title: "Recently deleted",
                supporting: "Restore a thread or remove it permanently.",
                action: controller.showRecentlyDeleted
            )
        }
    }

    private var query: String {
        controller.state.searchQuery.trimmingCharacters(in: .whitespacesAndNewlines)
    }

    private var visibleThreads: [RecoveryThread] {
        controller.state.threads.filter { thread in
            thread.status != .deleted && (
                query.isEmpty ||
                    thread.capturedText.localizedCaseInsensitiveContains(query) ||
                    thread.proposedAction.localizedCaseInsensitiveContains(query)
            )
        }
    }
}

struct ThreadDetailScreen: View {
    @ObservedObject var controller: RestartThreadController

    var body: some View {
        if let thread = controller.state.selectedThread {
            VStack(alignment: .leading, spacing: 24) {
                StatusPill(text: thread.status.displayName)
                PageIntro(
                    eyebrow: "Saved thread",
                    title: "Thread detail",
                    bodyText: "Review the saved context and the step you chose."
                )
                #if os(macOS)
                HStack(alignment: .top, spacing: 24) {
                    EvidenceCard(label: "You said", text: thread.capturedText)
                    FocusCard(label: "Start here", text: thread.proposedAction)
                }
                #else
                EvidenceCard(label: "You said", text: thread.capturedText)
                FocusCard(label: "Start here", text: thread.proposedAction)
                #endif
                SettingsCard(title: "Thread actions") {
                    SettingsActionRow(
                        title: "Edit stopping point",
                        supporting: "Change the saved context and first step.",
                        action: controller.editSelectedThread
                    )
                    if thread.status == .active {
                        SettingsActionRow(
                            title: "Return to thread",
                            supporting: "Open the saved first step.",
                            action: controller.returnToSelectedThread
                        )
                        SettingsActionRow(
                            title: "Mark complete",
                            supporting: "Move this thread out of Now.",
                            action: controller.completeSelectedThread
                        )
                    }
                    SettingsActionRow(
                        title: "Archive thread",
                        supporting: "Keep it in history without making it current.",
                        action: controller.archiveSelectedThread
                    )
                    SettingsActionRow(
                        title: "Export thread",
                        supporting: "Share a readable copy from this device.",
                        action: controller.exportSelectedThread
                    )
                    SettingsActionRow(
                        title: "Delete thread",
                        supporting: "Move it to Recently deleted.",
                        destructive: true,
                        action: controller.deleteSelectedThread
                    )
                }
            }
        } else {
            EmptyStateCard(
                title: "Thread unavailable",
                bodyText: "Return to your local history and choose another thread."
            )
        }
    }
}

struct RecentlyDeletedScreen: View {
    @ObservedObject var controller: RestartThreadController

    var body: some View {
        VStack(alignment: .leading, spacing: 24) {
            PageIntro(
                eyebrow: "Local recovery",
                title: "Recently deleted",
                bodyText: "Deleted threads remain here until you restore or permanently delete them."
            )
            if deleted.isEmpty {
                EmptyStateCard(
                    title: "Nothing is deleted",
                    bodyText: "Threads that you delete will appear here."
                )
            } else {
                ForEach(deleted) { thread in
                    ContentCard {
                        Text(thread.proposedAction).font(.body.weight(.semibold))
                        Text(thread.capturedText).foregroundStyle(.secondary).lineLimit(3)
                        SecondaryActionButton(title: "Restore thread") {
                            controller.restoreThread(id: thread.id)
                        }
                        TertiaryActionButton(title: "Delete permanently", destructive: true) {
                            controller.permanentlyDeleteThread(id: thread.id)
                        }
                    }
                }
            }
        }
    }

    private var deleted: [RecoveryThread] {
        controller.state.threads.filter { $0.status == .deleted }
    }
}

struct DataPrivacyScreen: View {
    @ObservedObject var controller: RestartThreadController

    var body: some View {
        VStack(alignment: .leading, spacing: 24) {
            PageIntro(
                eyebrow: "Privacy by default",
                title: "Your thread stays with you.",
                bodyText: "Restart Thread saves text and voice in an encrypted vault on this device before any optional processing."
            )
            EvidenceCard(
                label: "Guided example",
                text: "The example is disposable. It is not saved, sent, or added to your history."
            )
            EvidenceCard(
                label: "Accounts",
                text: "Signing in links Pro and cloud allowance. It does not turn on thread sync, and the backend does not receive thread text or audio."
            )
            EvidenceCard(
                label: "Your choices",
                text: "Use text without microphone access, export individual threads, delete local threads, or delete the separate cloud account."
            )
            SecondaryActionButton(title: "Go back", action: controller.goBack)
        }
    }
}
