import Foundation

public enum SourceKind: String, Codable, CaseIterable, Sendable {
    case text = "TEXT"
    case voice = "VOICE"
}

public enum ThreadStatus: String, Codable, CaseIterable, Sendable {
    case active = "ACTIVE"
    case completed = "COMPLETED"
    case archived = "ARCHIVED"
    case deleted = "DELETED"

    public var displayName: String {
        switch self {
        case .active: "Current"
        case .completed: "Completed"
        case .archived: "Archived"
        case .deleted: "Deleted"
        }
    }
}

public struct RecoveryThread: Codable, Equatable, Identifiable, Sendable {
    public let id: String
    public let createdAtEpochMs: Int64
    public var updatedAtEpochMs: Int64
    public var sourceKind: SourceKind
    public var capturedText: String
    public var proposedAction: String
    public var startedAtEpochMs: Int64?
    public var status: ThreadStatus
    public var deletedFromStatus: ThreadStatus?

    public init(
        id: String,
        createdAtEpochMs: Int64,
        updatedAtEpochMs: Int64? = nil,
        sourceKind: SourceKind,
        capturedText: String,
        proposedAction: String,
        startedAtEpochMs: Int64? = nil,
        status: ThreadStatus = .active,
        deletedFromStatus: ThreadStatus? = nil
    ) {
        self.id = id
        self.createdAtEpochMs = createdAtEpochMs
        self.updatedAtEpochMs = updatedAtEpochMs ?? createdAtEpochMs
        self.sourceKind = sourceKind
        self.capturedText = capturedText
        self.proposedAction = proposedAction
        self.startedAtEpochMs = startedAtEpochMs
        self.status = status
        self.deletedFromStatus = deletedFromStatus
    }
}

public struct RecoveryDraft: Equatable, Sendable {
    public let startHere: String
    public let evidence: String
    public let isGenerated: Bool
}
