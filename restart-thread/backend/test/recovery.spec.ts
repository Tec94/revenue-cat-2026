import { describe, expect, it } from "vitest";
import {
	MAX_AUDIO_BASE64_CHARACTERS,
	MAX_TEXT_CHARACTERS,
	parseAudioRecoveryInput,
	parseTextRecoveryInput,
	segmentTranscript,
	validateGrounding,
} from "../src/recovery";

describe("recovery contract", () => {
	it("accepts bounded text and assigns stable evidence IDs", () => {
		const input = parseTextRecoveryInput({
			mode: "text",
			text: "The draft is open. Do not send it before checking the total.",
		});
		const segments = segmentTranscript(input.text);

		expect(segments).toEqual([
			{ id: "s1", text: "The draft is open." },
			{ id: "s2", text: "Do not send it before checking the total." },
		]);
	});

	it("rejects text beyond the capture boundary", () => {
		expect(() =>
			parseTextRecoveryInput({ mode: "text", text: "x".repeat(MAX_TEXT_CHARACTERS + 1) }),
		).toThrow("text_outside_capture_boundary");
	});

	it("accepts app-recorded audio metadata at the 60-second boundary", () => {
		const result = parseAudioRecoveryInput({
			mode: "audio",
			audioBase64: "YXVkaW8=",
			durationMs: 60_000,
			mediaType: "audio/mp4",
		});

		expect(result.durationMs).toBe(60_000);
	});

	it("rejects oversized audio before invoking a model", () => {
		expect(() =>
			parseAudioRecoveryInput({
				mode: "audio",
				audioBase64: "A".repeat(MAX_AUDIO_BASE64_CHARACTERS + 1),
				durationMs: 60_000,
				mediaType: "audio/mp4",
			}),
		).toThrow("audio_outside_capture_boundary");
	});

	it("rejects a model citation that is absent from the transcript", () => {
		const segments = segmentTranscript("Do not send the draft.");

		expect(() =>
			validateGrounding(
				{ startHere: "Review the draft.", evidenceIds: ["s2"] },
				segments,
			),
		).toThrow("UnsupportedEvidenceId");
	});
});
