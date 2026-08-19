import RestartThreadCore
import XCTest

final class DeterministicRecoveryTests: XCTestCase {
    func testFallbackPreservesExactSourceAndDoesNotClaimAIGeneration() throws {
        let source = "Do not email the client yet. Check the figures first."

        let result = try XCTUnwrap(DeterministicRecovery.fromText(source))

        XCTAssertEqual(result.evidence, source)
        XCTAssertEqual(result.startHere, DeterministicRecovery.safeFirstAction)
        XCTAssertFalse(result.isGenerated)
    }

    func testBlankCaptureCannotCreateRecovery() {
        XCTAssertNil(DeterministicRecovery.fromText("   "))
    }
}
