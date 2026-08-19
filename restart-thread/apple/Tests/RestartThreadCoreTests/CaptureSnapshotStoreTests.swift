import Foundation
import RestartThreadCore
import XCTest

final class CaptureSnapshotStoreTests: XCTestCase {
    func testSnapshotRoundTripAndClear() throws {
        let suiteName = "RestartThreadCoreTests.\(UUID().uuidString)"
        let defaults = try XCTUnwrap(UserDefaults(suiteName: suiteName))
        defer { defaults.removePersistentDomain(forName: suiteName) }
        let store = UserDefaultsCaptureSnapshotStore(defaults: defaults)
        let snapshot = CaptureSnapshot(
            route: .review,
            input: "Words that must survive relaunch",
            threadID: "thread-1",
            evidence: "Saved evidence",
            action: "Resume from here",
            isAIGenerated: false
        )

        store.saveSnapshot(snapshot)

        XCTAssertEqual(store.loadSnapshot(), snapshot)
        store.saveSnapshot(nil)
        XCTAssertNil(store.loadSnapshot())
    }
}
