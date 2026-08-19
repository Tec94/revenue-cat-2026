import AVFoundation
import Foundation
import RestartThreadCore

@MainActor
public final class AppleVoiceRecorder: NSObject, AVAudioRecorderDelegate {
    private var recorder: AVAudioRecorder?
    private var outputURL: URL?

    public override init() {
        super.init()
    }

    public var permissionState: MicrophonePermissionState {
        #if os(iOS)
        AVAudioSession.sharedInstance().recordPermission == .granted ? .granted : .notGranted
        #else
        AVCaptureDevice.authorizationStatus(for: .audio) == .authorized ? .granted : .notGranted
        #endif
    }

    public func requestPermission() async -> Bool {
        #if os(iOS)
        let session = AVAudioSession.sharedInstance()
        switch session.recordPermission {
        case .granted:
            return true
        case .denied:
            return false
        case .undetermined:
            return await withCheckedContinuation { continuation in
                session.requestRecordPermission { continuation.resume(returning: $0) }
            }
        @unknown default:
            return false
        }
        #else
        switch AVCaptureDevice.authorizationStatus(for: .audio) {
        case .authorized:
            return true
        case .notDetermined:
            return await AVCaptureDevice.requestAccess(for: .audio)
        case .denied, .restricted:
            return false
        @unknown default:
            return false
        }
        #endif
    }

    public func start() throws {
        guard recorder == nil else { return }
        #if os(iOS)
        let session = AVAudioSession.sharedInstance()
        try session.setCategory(.playAndRecord, mode: .spokenAudio, options: [.defaultToSpeaker])
        try session.setActive(true)
        #endif

        let url = FileManager.default.temporaryDirectory
            .appendingPathComponent("restart-thread-\(UUID().uuidString).m4a")
        let settings: [String: Any] = [
            AVFormatIDKey: Int(kAudioFormatMPEG4AAC),
            AVSampleRateKey: 44_100,
            AVNumberOfChannelsKey: 1,
            AVEncoderBitRateKey: 64_000,
        ]
        let next = try AVAudioRecorder(url: url, settings: settings)
        next.delegate = self
        guard next.prepareToRecord(), next.record(forDuration: 60) else {
            try? FileManager.default.removeItem(at: url)
            throw RecordingError.couldNotStart
        }
        recorder = next
        outputURL = url
    }

    public func stop() throws -> Data {
        guard let recorder, let outputURL else { throw RecordingError.notRecording }
        recorder.stop()
        self.recorder = nil
        self.outputURL = nil
        defer {
            try? FileManager.default.removeItem(at: outputURL)
            #if os(iOS)
            try? AVAudioSession.sharedInstance().setActive(false, options: .notifyOthersOnDeactivation)
            #endif
        }
        return try Data(contentsOf: outputURL)
    }

    public func cancel() {
        recorder?.stop()
        recorder = nil
        if let outputURL { try? FileManager.default.removeItem(at: outputURL) }
        outputURL = nil
        #if os(iOS)
        try? AVAudioSession.sharedInstance().setActive(false, options: .notifyOthersOnDeactivation)
        #endif
    }

    public enum RecordingError: Error {
        case couldNotStart
        case notRecording
    }
}
