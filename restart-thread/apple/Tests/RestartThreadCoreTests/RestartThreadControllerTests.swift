import RestartThreadCore
import XCTest

final class RestartThreadControllerTests: XCTestCase {
    @MainActor
    func testFreshInstallShowsWelcomeAndExampleLeavesNoRecord() {
        let platform = FakePlatform()
        let controller = RestartThreadController(platform: platform)

        XCTAssertEqual(controller.state.route, .welcome)
        controller.tryExample()
        XCTAssertTrue(controller.state.isExample)
        controller.confirmStart()

        XCTAssertEqual(controller.state.route, .accountOffer)
        XCTAssertTrue(platform.threads.isEmpty)
        XCTAssertEqual(platform.saveCalls, 0)
        XCTAssertFalse(platform.onboardingComplete)
    }

    @MainActor
    func testPrivacyDetailsReturnToWelcomeDuringOnboarding() {
        let controller = RestartThreadController(platform: FakePlatform())

        controller.showDataPrivacy()
        controller.goBack()

        XCTAssertEqual(controller.state.route, .welcome)
        XCTAssertFalse(controller.state.onboardingComplete)
    }

    @MainActor
    func testRealStartBecomesCurrentThreadOnNow() {
        let platform = FakePlatform()
        let controller = RestartThreadController(platform: platform)

        controller.leaveFirstThread()
        controller.setInput("I stopped while comparing two plans.")
        controller.saveText()
        controller.confirmStart()
        controller.finishStarted()
        controller.completeAccountStep()

        XCTAssertEqual(controller.state.route, .now)
        XCTAssertEqual(controller.state.currentThread?.status, .active)
        XCTAssertTrue(platform.onboardingComplete)
    }

    @MainActor
    func testStartingAnotherThreadRequiresExplicitCurrentChoice() {
        let platform = FakePlatform(onboardingComplete: true)
        let controller = RestartThreadController(platform: platform)
        controller.startNewThread()
        controller.setInput("First stopping point")
        controller.saveText()
        controller.confirmStart()
        controller.finishStarted()

        controller.startNewThread()
        XCTAssertTrue(controller.state.showSwitchCurrent)
        XCTAssertEqual(platform.threads.values.filter { $0.status == .active }.count, 1)

        controller.resolveCurrentThread(.archive)
        XCTAssertEqual(controller.state.route, .capture)
        XCTAssertEqual(platform.threads.values.filter { $0.status == .active }.count, 0)
        XCTAssertEqual(platform.threads.values.filter { $0.status == .archived }.count, 1)
    }

    @MainActor
    func testEditingArchivedThreadRequiresExplicitCurrentChoice() {
        let platform = FakePlatform(onboardingComplete: true)
        let current = platform.makeThread(id: "current", status: .active)
        let archived = platform.makeThread(id: "archived", status: .archived)
        let controller = RestartThreadController(platform: platform)

        controller.openThread(id: archived.id)
        controller.editSelectedThread()

        XCTAssertTrue(controller.state.showSwitchCurrent)
        XCTAssertEqual(controller.state.route, .threadDetail)
        XCTAssertEqual(platform.threads.values.filter { $0.status == .active }.count, 1)

        controller.resolveCurrentThread(.archive)
        XCTAssertEqual(controller.state.route, .capture)
        XCTAssertEqual(controller.state.threadID, archived.id)
        XCTAssertEqual(platform.threads[current.id]?.status, .archived)

        controller.setInput("Updated archived stopping point")
        controller.saveText()
        XCTAssertEqual(platform.threads.values.filter { $0.status == .active }.count, 1)
        XCTAssertEqual(platform.threads[archived.id]?.status, .active)
    }

    @MainActor
    func testDeletedThreadRestoresWithoutReplacingCurrent() {
        let platform = FakePlatform(onboardingComplete: true)
        let current = platform.makeThread(id: "current", status: .active)
        let archived = platform.makeThread(id: "archived", status: .archived)
        let controller = RestartThreadController(platform: platform)

        controller.openThread(id: archived.id)
        controller.deleteSelectedThread()
        XCTAssertEqual(platform.threads[archived.id]?.status, .deleted)

        controller.showRecentlyDeleted()
        controller.restoreThread(id: archived.id)
        XCTAssertEqual(platform.threads[archived.id]?.status, .archived)
        XCTAssertEqual(platform.threads[current.id]?.status, .active)
    }

    @MainActor
    func testReturnToThreadReopensSavedReview() {
        let platform = FakePlatform(onboardingComplete: true)
        let current = platform.makeThread(id: "current", status: .active)
        let controller = RestartThreadController(platform: platform)

        controller.openThread(id: current.id)
        controller.returnToSelectedThread()

        XCTAssertEqual(controller.state.route, .review)
        XCTAssertEqual(controller.state.input, current.capturedText)
        XCTAssertEqual(controller.state.action, current.proposedAction)
    }

    @MainActor
    func testWidgetUpdateTargetsExactThreadAndRejectsStaleRecord() {
        let platform = FakePlatform(onboardingComplete: true)
        let current = platform.makeThread(id: "current", status: .active)
        let archived = platform.makeThread(id: "archived", status: .archived)
        let controller = RestartThreadController(platform: platform)

        controller.handleDeepLink(route: "update", threadID: current.id)
        XCTAssertEqual(controller.state.route, .capture)
        XCTAssertEqual(controller.state.threadID, current.id)

        controller.handleDeepLink(route: "update", threadID: archived.id)
        XCTAssertEqual(controller.state.route, .now)
        XCTAssertEqual(controller.state.message, "That widget thread is no longer current.")
    }

    @MainActor
    func testUnfinishedCaptureRestores() {
        let controller = RestartThreadController(
            platform: FakePlatform(),
            restoredCapture: CaptureSnapshot(
                route: .capture,
                input: "Unsaved words",
                threadID: nil,
                evidence: "",
                action: "",
                isAIGenerated: false
            )
        )

        XCTAssertEqual(controller.state.route, .capture)
        XCTAssertEqual(controller.state.input, "Unsaved words")
    }

    @MainActor
    func testDeletingAllLocalDataUsesRecoverableDeletion() {
        let platform = FakePlatform(onboardingComplete: true)
        platform.makeThread(id: "current", status: .active)
        platform.makeThread(id: "history", status: .completed)
        let controller = RestartThreadController(platform: platform)

        controller.deleteAllLocalThreads()

        XCTAssertTrue(platform.threads.values.allSatisfy { $0.status == .deleted })
        XCTAssertEqual(controller.state.route, .now)
    }

    @MainActor
    func testClosingStopsAnActiveRecording() {
        let platform = FakePlatform()
        let controller = RestartThreadController(platform: platform)
        controller.startRecording()

        controller.close()

        XCTAssertFalse(controller.state.isRecording)
        XCTAssertEqual(platform.cancelCalls, 1)
    }
}

@MainActor
private final class FakePlatform: RestartThreadPlatform {
    var onboardingComplete: Bool
    var threads: [String: RecoveryThread] = [:]
    var saveCalls = 0
    var cancelCalls = 0
    private var now: Int64 = 1_000
    private var nextID = 1

    init(onboardingComplete: Bool = false) {
        self.onboardingComplete = onboardingComplete
    }

    func hasCompletedOnboarding() -> Bool { onboardingComplete }
    func setOnboardingCompleted(_ completed: Bool) { onboardingComplete = completed }
    func newThreadID() -> String { defer { nextID += 1 }; return "thread-\(nextID)" }
    func currentTimeMillis() -> Int64 { defer { now += 1 }; return now }
    func saveThread(_ thread: RecoveryThread) -> Bool {
        saveCalls += 1
        threads[thread.id] = thread
        return true
    }
    func loadThread(id: String) -> RecoveryThread? { threads[id] }
    func listThreads() -> [RecoveryThread] { threads.values.sorted { $0.updatedAtEpochMs > $1.updatedAtEpochMs } }
    func permanentlyDeleteThread(id: String) -> Bool { threads.removeValue(forKey: id) != nil }
    func exportThread(_ thread: RecoveryThread) -> Bool { true }
    func startRecording() -> Bool { true }
    func stopAndSaveVoice(thread: RecoveryThread) -> Bool { saveThread(thread) }
    func cancelRecording() { cancelCalls += 1 }
    func confirmHaptic() {}

    @discardableResult
    func makeThread(id: String, status: ThreadStatus) -> RecoveryThread {
        let thread = RecoveryThread(
            id: id,
            createdAtEpochMs: now,
            updatedAtEpochMs: currentTimeMillis(),
            sourceKind: .text,
            capturedText: "\(id) captured",
            proposedAction: "\(id) action",
            status: status
        )
        threads[id] = thread
        return thread
    }
}
