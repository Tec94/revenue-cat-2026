import Combine
import Foundation

@MainActor
public final class RestartThreadController: ObservableObject {
    @Published public private(set) var state: MainUIState {
        didSet { persistCaptureIfNeeded() }
    }

    private let platform: RestartThreadPlatform
    private let snapshotStore: CaptureSnapshotPersisting?
    private var pendingEditThreadID: String?

    public init(
        platform: RestartThreadPlatform,
        restoredCapture: CaptureSnapshot? = nil,
        snapshotStore: CaptureSnapshotPersisting? = nil
    ) {
        self.platform = platform
        self.snapshotStore = snapshotStore
        let completed = platform.hasCompletedOnboarding()
        let restored = restoredCapture ?? snapshotStore?.loadSnapshot()
        if let restored, restored.route == .capture || restored.route == .review {
            state = MainUIState(
                route: restored.route,
                onboardingComplete: completed,
                input: restored.input,
                threadID: restored.threadID,
                evidence: restored.evidence,
                action: restored.action,
                message: "Your unfinished thread was restored.",
                isAIGenerated: restored.isAIGenerated
            )
        } else {
            state = MainUIState(
                route: completed ? .now : .welcome,
                onboardingComplete: completed
            )
        }
        if completed { refreshThreads() }
    }

    public func leaveFirstThread() { openCapture() }

    public func tryExample() {
        state.route = .exampleReview
        state.input = Self.exampleCapture
        state.action = Self.exampleAction
        state.evidence = Self.exampleEvidence
        state.threadID = nil
        state.isExample = true
        state.isAIGenerated = false
        state.captureProgress = .idle
        state.message = nil
    }

    public func showAccountOffer() {
        state.route = .accountOffer
        state.isExample = false
        state.message = nil
    }

    public func completeAccountStep() {
        platform.setOnboardingCompleted(true)
        state.onboardingComplete = true
        goNow()
    }

    public func goNow() {
        pendingEditThreadID = nil
        state.route = .now
        state.input = ""
        state.threadID = nil
        state.evidence = ""
        state.action = ""
        state.selectedThread = nil
        state.isExample = false
        state.isAIGenerated = false
        state.isRecording = false
        state.captureProgress = .idle
        state.showSwitchCurrent = false
        state.message = nil
        refreshThreads()
    }

    public func goBack() {
        switch state.route {
        case .dataPrivacy:
            state.route = state.onboardingComplete ? .settings : .welcome
            state.message = nil
        case .recentlyDeleted, .threadDetail:
            showAllThreads()
        case .allThreads, .settings, .capture, .review, .started:
            goNow()
        case .bootstrap, .welcome, .exampleReview, .accountOffer, .now:
            break
        }
    }

    public func startNewThread() {
        pendingEditThreadID = nil
        refreshThreads()
        if state.currentThread != nil {
            state.showSwitchCurrent = true
        } else {
            openCapture()
        }
    }

    public func resolveCurrentThread(_ choice: SwitchCurrentChoice) {
        guard var current = state.currentThread else { return }
        current.status = choice == .complete ? .completed : .archived
        current.updatedAtEpochMs = platform.currentTimeMillis()
        guard platform.saveThread(current) else {
            state.message = "Couldn't update the current thread. Nothing was replaced."
            return
        }
        state.showSwitchCurrent = false
        if let pendingEditThreadID {
            self.pendingEditThreadID = nil
            openThreadEdit(id: pendingEditThreadID)
        } else {
            openCapture()
        }
    }

    public func dismissCurrentSwitch() {
        pendingEditThreadID = nil
        state.showSwitchCurrent = false
    }

    public func leaveNewStoppingPoint() {
        guard let current = currentThread() else { return }
        state.route = .capture
        state.threadID = current.id
        state.input = current.capturedText
        state.evidence = ""
        state.action = current.proposedAction
        state.message = "Update the point you want to return to."
        state.isExample = false
        state.isAIGenerated = false
        state.captureProgress = .idle
    }

    public func setInput(_ value: String) {
        state.input = value
        state.captureProgress = .idle
        state.message = nil
    }

    public func saveText() {
        let captured = state.input.trimmingCharacters(in: .whitespacesAndNewlines)
        guard let draft = DeterministicRecovery.fromText(captured) else {
            state.captureProgress = .failed
            state.message = "Add a few words first."
            return
        }

        state.captureProgress = .saving
        let existing = state.threadID.flatMap { platform.loadThread(id: $0) }
        let id = existing?.id ?? platform.newThreadID()
        let now = platform.currentTimeMillis()
        let thread = RecoveryThread(
            id: id,
            createdAtEpochMs: existing?.createdAtEpochMs ?? now,
            updatedAtEpochMs: now,
            sourceKind: .text,
            capturedText: captured,
            proposedAction: draft.startHere,
            startedAtEpochMs: existing?.startedAtEpochMs,
            status: .active
        )
        if platform.saveThread(thread) {
            state.route = .review
            state.threadID = id
            state.evidence = draft.evidence
            state.action = draft.startHere
            state.isAIGenerated = draft.isGenerated
            state.captureProgress = .saved
            state.message = "Saved on this device."
        } else {
            state.captureProgress = .failed
            state.message = "Couldn't save. Your words are still here—try again."
        }
    }

    public func startRecording() {
        if platform.startRecording() {
            state.isRecording = true
            state.captureProgress = .idle
            state.message = nil
        } else {
            state.captureProgress = .failed
            state.message = "Couldn't start recording. You can type instead."
        }
    }

    public func reportMicrophoneDenied() {
        state.isRecording = false
        state.captureProgress = .failed
        state.message = "Microphone access wasn't allowed. Text capture is still fully available."
    }

    public func stopAndSaveRecording() {
        let existing = state.threadID.flatMap { platform.loadThread(id: $0) }
        let id = existing?.id ?? platform.newThreadID()
        let now = platform.currentTimeMillis()
        let draft = DeterministicRecovery.fromSavedVoice()
        state.captureProgress = .saving
        let thread = RecoveryThread(
            id: id,
            createdAtEpochMs: existing?.createdAtEpochMs ?? now,
            updatedAtEpochMs: now,
            sourceKind: .voice,
            capturedText: draft.evidence,
            proposedAction: draft.startHere,
            startedAtEpochMs: existing?.startedAtEpochMs,
            status: .active
        )
        if platform.stopAndSaveVoice(thread: thread) {
            state.route = .review
            state.threadID = id
            state.evidence = draft.evidence
            state.action = draft.startHere
            state.isRecording = false
            state.isAIGenerated = draft.isGenerated
            state.captureProgress = .voiceOnly
            state.message = "Voice note encrypted and saved on this device."
        } else {
            state.isRecording = false
            state.captureProgress = .failed
            state.message = "Couldn't save the recording. Try again or type instead."
        }
    }

    public func setAction(_ value: String) {
        state.action = value
        state.message = nil
    }

    public func confirmStart() {
        let action = state.action.trimmingCharacters(in: .whitespacesAndNewlines)
        guard !action.isEmpty else {
            state.message = "Choose a first step before starting."
            return
        }
        if state.isExample {
            platform.confirmHaptic()
            state.route = .accountOffer
            state.input = ""
            state.action = ""
            state.evidence = ""
            state.isExample = false
            state.message = nil
            return
        }
        guard let id = state.threadID, var stored = platform.loadThread(id: id) else {
            state.message = "The saved thread couldn't be reopened."
            return
        }
        let now = platform.currentTimeMillis()
        stored.proposedAction = action
        stored.startedAtEpochMs = now
        stored.updatedAtEpochMs = now
        stored.status = .active
        stored.deletedFromStatus = nil
        if platform.saveThread(stored) {
            platform.confirmHaptic()
            state.route = .started
            state.action = action
            state.message = "Restart marked as started."
        } else {
            state.message = "Couldn't mark this start. Try again."
        }
    }

    public func finishStarted() {
        state.onboardingComplete ? goNow() : showAccountOffer()
    }

    public func markCurrentComplete() { updateCurrentStatus(.completed) }
    public func archiveCurrent() { updateCurrentStatus(.archived) }

    public func showAllThreads() {
        refreshThreads()
        state.route = .allThreads
    }

    public func showRecentlyDeleted() {
        refreshThreads()
        state.route = .recentlyDeleted
    }

    public func showSettings() {
        state.route = .settings
        state.message = nil
    }

    public func showDataPrivacy() {
        state.route = .dataPrivacy
        state.message = nil
    }

    public func setSearchQuery(_ query: String) { state.searchQuery = query }

    public func setMessage(_ message: String?) { state.message = message }

    public func openThread(id: String) {
        guard let thread = platform.loadThread(id: id) else { return }
        state.route = .threadDetail
        state.selectedThread = thread
        state.message = nil
    }

    public func returnToSelectedThread() {
        guard let selected = state.selectedThread else { return }
        state.route = .review
        state.threadID = selected.id
        state.input = selected.capturedText
        state.action = selected.proposedAction
        state.evidence = selected.capturedText
        state.isExample = false
        state.isAIGenerated = false
        state.captureProgress = .saved
        state.message = nil
    }

    public func editSelectedThread() {
        guard let selected = state.selectedThread else { return }
        if let current = currentThread(), current.id != selected.id {
            pendingEditThreadID = selected.id
            state.currentThread = current
            state.showSwitchCurrent = true
            state.message = nil
            return
        }
        openThreadEdit(id: selected.id)
    }

    private func openThreadEdit(id: String) {
        guard let selected = platform.loadThread(id: id) else {
            state.message = "The saved thread couldn't be reopened."
            return
        }
        state.selectedThread = selected
        state.route = .capture
        state.threadID = selected.id
        state.input = selected.capturedText
        state.action = selected.proposedAction
        state.evidence = ""
        state.captureProgress = .idle
        state.message = nil
    }

    public func completeSelectedThread() { updateSelectedStatus(.completed) }
    public func archiveSelectedThread() { updateSelectedStatus(.archived) }

    public func deleteSelectedThread() {
        guard var selected = state.selectedThread else { return }
        selected.deletedFromStatus = selected.status
        selected.status = .deleted
        selected.updatedAtEpochMs = platform.currentTimeMillis()
        if platform.saveThread(selected) { showAllThreads() }
    }

    public func restoreThread(id: String) {
        guard var thread = platform.loadThread(id: id) else { return }
        let desiredStatus = thread.deletedFromStatus ?? .archived
        thread.status = desiredStatus == .active && currentThread() != nil ? .archived : desiredStatus
        thread.deletedFromStatus = nil
        thread.updatedAtEpochMs = platform.currentTimeMillis()
        _ = platform.saveThread(thread)
        refreshThreads()
    }

    public func permanentlyDeleteThread(id: String) {
        _ = platform.permanentlyDeleteThread(id: id)
        refreshThreads()
    }

    public func exportSelectedThread() {
        guard let selected = state.selectedThread else { return }
        state.message = platform.exportThread(selected) ? nil : "Couldn't open the export sheet."
    }

    public func deleteAllLocalThreads() {
        let now = platform.currentTimeMillis()
        for var thread in platform.listThreads() where thread.status != .deleted {
            thread.deletedFromStatus = thread.status
            thread.status = .deleted
            thread.updatedAtEpochMs = now
            _ = platform.saveThread(thread)
        }
        goNow()
    }

    public func handleDeepLink(route: String?, threadID: String?) {
        switch route {
        case "capture": startNewThread()
        case "update": threadID.map(openThreadUpdate) ?? goNow()
        case "thread": threadID.map { openThread(id: $0) } ?? goNow()
        default: goNow()
        }
    }

    public func close() {
        platform.cancelRecording()
        state.isRecording = false
    }

    private func openCapture() {
        pendingEditThreadID = nil
        state.route = .capture
        state.input = ""
        state.threadID = nil
        state.evidence = ""
        state.action = ""
        state.isExample = false
        state.isAIGenerated = false
        state.isRecording = false
        state.captureProgress = .idle
        state.showSwitchCurrent = false
        state.message = nil
    }

    private func openThreadUpdate(_ id: String) {
        guard let thread = platform.loadThread(id: id), thread.status == .active else {
            goNow()
            state.message = "That widget thread is no longer current."
            return
        }
        state.route = .capture
        state.threadID = thread.id
        state.input = thread.capturedText
        state.evidence = ""
        state.action = thread.proposedAction
        state.isExample = false
        state.isAIGenerated = false
        state.isRecording = false
        state.captureProgress = .idle
        state.showSwitchCurrent = false
        state.message = "Update the point you want to return to."
    }

    private func updateCurrentStatus(_ status: ThreadStatus) {
        guard var current = currentThread() else { return }
        current.status = status
        current.updatedAtEpochMs = platform.currentTimeMillis()
        if platform.saveThread(current) {
            state.onboardingComplete ? goNow() : showAccountOffer()
        }
    }

    private func updateSelectedStatus(_ status: ThreadStatus) {
        guard var selected = state.selectedThread else { return }
        selected.status = status
        selected.updatedAtEpochMs = platform.currentTimeMillis()
        if platform.saveThread(selected) { showAllThreads() }
    }

    private func currentThread() -> RecoveryThread? {
        platform.listThreads().first { $0.status == .active }
    }

    private func refreshThreads() {
        let threads = platform.listThreads()
        let active = threads.filter { $0.status == .active }
        let current = active.first
        for var extra in active.dropFirst() {
            extra.status = .archived
            extra.updatedAtEpochMs = platform.currentTimeMillis()
            _ = platform.saveThread(extra)
        }
        state.threads = active.count > 1 ? platform.listThreads() : threads
        state.currentThread = current
        if let selectedID = state.selectedThread?.id {
            state.selectedThread = platform.loadThread(id: selectedID)
        }
    }

    private func persistCaptureIfNeeded() {
        guard state.route == .capture || state.route == .review, !state.isExample else {
            snapshotStore?.saveSnapshot(nil)
            return
        }
        snapshotStore?.saveSnapshot(
            CaptureSnapshot(
                route: state.route,
                input: state.input,
                threadID: state.threadID,
                evidence: state.evidence,
                action: state.action,
                isAIGenerated: state.isAIGenerated
            )
        )
    }

    private static let exampleCapture =
        "I compared the two plans. The annual option looks cheaper after month eight, " +
        "but I still need to check the cancellation fee."
    private static let exampleAction = "Open the pricing sheet and confirm the cancellation fee."
    private static let exampleEvidence = "I still need to check the cancellation fee."
}
