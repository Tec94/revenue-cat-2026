export interface TextRecoveryInput {
	mode: "text";
	text: string;
	locale?: string;
}

export interface AudioRecoveryInput {
	mode: "audio";
	audioBase64: string;
	durationMs: number;
	mediaType: "audio/mp4" | "audio/mpeg" | "audio/ogg" | "audio/wav" | "audio/webm";
	locale?: string;
}

export type RecoveryInput = TextRecoveryInput | AudioRecoveryInput;

export interface TranscriptSegment {
	id: string;
	text: string;
}

export interface RecoveryDraft {
	transcript: string;
	segments: TranscriptSegment[];
	startHere: string;
	later: string[];
	evidenceIds: string[];
	assumptions: string[];
	questions: string[];
	confidence: "low" | "medium" | "high";
	model: string;
	generated: true;
}

interface ModelDraft {
	startHere: string;
	later?: string[];
	evidenceIds: string[];
	assumptions?: string[];
	questions?: string[];
	confidence?: "low" | "medium" | "high";
}

// The text bound is derived from the accepted 60-second capture contract. Four
// thousand characters is intentionally above a fast one-minute transcript and
// leaves room for pasted context without turning this endpoint into document AI.
export const MAX_TEXT_CHARACTERS = 4_000;

// The Android recorder will use 64 kbit/s AAC and stop at 60 seconds. Its raw
// payload is about 480 KB; this Base64 cap includes encoding and container
// overhead with margin. Change both client and server together after measuring.
export const MAX_AUDIO_BASE64_CHARACTERS = 1_500_000;

export function parseTextRecoveryInput(value: unknown): TextRecoveryInput {
	if (!isRecord(value) || value.mode !== "text" || typeof value.text !== "string") {
		throw new Error("invalid_text_recovery_input");
	}
	const text = value.text.trim();
	if (!text || text.length > MAX_TEXT_CHARACTERS) {
		throw new Error("text_outside_capture_boundary");
	}
	return {
		mode: "text",
		text,
		locale: optionalString(value.locale),
	};
}

export function parseAudioRecoveryInput(value: unknown): AudioRecoveryInput {
	if (
		!isRecord(value) ||
		value.mode !== "audio" ||
		typeof value.audioBase64 !== "string" ||
		typeof value.durationMs !== "number" ||
		typeof value.mediaType !== "string"
	) {
		throw new Error("invalid_audio_recovery_input");
	}
	if (
		value.durationMs <= 0 ||
		value.durationMs > 60_000 ||
		value.audioBase64.length === 0 ||
		value.audioBase64.length > MAX_AUDIO_BASE64_CHARACTERS
	) {
		throw new Error("audio_outside_capture_boundary");
	}
	const mediaTypes = [
		"audio/mp4",
		"audio/mpeg",
		"audio/ogg",
		"audio/wav",
		"audio/webm",
	] as const;
	if (!mediaTypes.includes(value.mediaType as (typeof mediaTypes)[number])) {
		throw new Error("unsupported_audio_type");
	}
	if (!/^[A-Za-z0-9+/]*={0,2}$/.test(value.audioBase64)) {
		throw new Error("invalid_audio_encoding");
	}
	return {
		mode: "audio",
		audioBase64: value.audioBase64,
		durationMs: value.durationMs,
		mediaType: value.mediaType as AudioRecoveryInput["mediaType"],
		locale: optionalString(value.locale),
	};
}

export async function createRecoveryDraft(
	input: RecoveryInput,
	mode: "workers-ai" | "deterministic" | "disabled",
	ai: Ai,
): Promise<RecoveryDraft> {
	if (mode === "disabled") throw new Error("CloudRecoveryDisabled");

	const transcript =
		input.mode === "text" ? input.text : await transcribeAudio(input, ai);
	const segments = segmentTranscript(transcript);
	if (segments.length === 0) throw new Error("EmptyTranscript");

	if (mode === "deterministic") {
		return deterministicDraft(transcript, segments);
	}

	const model = "@cf/meta/llama-3.2-3b-instruct";
	const prompt = buildGroundedPrompt(segments);
	const result = (await ai.run(model, {
		messages: [
			{
				role: "system",
				content:
					"Return only valid JSON. Preserve negation and uncertainty. Do not diagnose, treat, contact, schedule, or act for the user.",
			},
			{ role: "user", content: prompt },
		],
		max_tokens: 500,
		response_format: { type: "json_object" },
	})) as { response?: string };

	if (!result.response) throw new Error("EmptyModelResponse");
	const parsed = parseModelDraft(result.response);
	validateGrounding(parsed, segments);

	return {
		transcript,
		segments,
		startHere: parsed.startHere.trim(),
		later: (parsed.later ?? []).map((step) => step.trim()).filter(Boolean).slice(0, 3),
		evidenceIds: parsed.evidenceIds,
		assumptions: (parsed.assumptions ?? []).map((item) => item.trim()).filter(Boolean),
		questions: (parsed.questions ?? []).map((item) => item.trim()).filter(Boolean),
		confidence: parsed.confidence ?? "low",
		model,
		generated: true,
	};
}

export function segmentTranscript(text: string): TranscriptSegment[] {
	return text
		.split(/(?<=[.!?])\s+|\n+/)
		.map((part) => part.trim())
		.filter(Boolean)
		.map((part, index) => ({ id: `s${index + 1}`, text: part }));
}

export function validateGrounding(
	draft: ModelDraft,
	segments: TranscriptSegment[],
): void {
	if (!draft.startHere?.trim()) throw new Error("MissingStartHere");
	if (!Array.isArray(draft.evidenceIds) || draft.evidenceIds.length === 0) {
		throw new Error("MissingEvidence");
	}
	const validIds = new Set(segments.map((segment) => segment.id));
	if (draft.evidenceIds.some((id) => !validIds.has(id))) {
		throw new Error("UnsupportedEvidenceId");
	}
	if (draft.later && draft.later.length > 3) throw new Error("TooManyLaterSteps");
}

async function transcribeAudio(input: AudioRecoveryInput, ai: Ai): Promise<string> {
	const result = (await ai.run("@cf/openai/whisper-large-v3-turbo", {
		audio: input.audioBase64,
		task: "transcribe",
		language: input.locale?.split("-")[0],
		vad_filter: true,
		condition_on_previous_text: false,
	})) as { text?: string };
	if (!result.text?.trim()) throw new Error("EmptyTranscription");
	return result.text.trim();
}

function deterministicDraft(
	transcript: string,
	segments: TranscriptSegment[],
): RecoveryDraft {
	const first = segments[0];
	const excerpt = first.text.length > 120 ? `${first.text.slice(0, 117)}…` : first.text;
	return {
		transcript,
		segments,
		startHere: `Review this saved state and choose the smallest continuation: ${excerpt}`,
		later: [],
		evidenceIds: [first.id],
		assumptions: ["Development-only deterministic draft; not a production AI result."],
		questions: [],
		confidence: "low",
		model: "deterministic-development-adapter",
		generated: true,
	};
}

function buildGroundedPrompt(segments: TranscriptSegment[]): string {
	const source = segments.map((segment) => `[${segment.id}] ${segment.text}`).join("\n");
	return `Draft one small, reversible first action using only the source below.

Return this JSON shape:
{"startHere":"string","later":["up to three strings"],"evidenceIds":["s1"],"assumptions":[],"questions":[],"confidence":"low|medium|high"}

Rules:
- Cite at least one source segment ID for the first action.
- Do not invent priority, deadlines, people, files, amounts, or intent.
- Preserve words such as not, never, avoid, do not, and uncertainty.
- If the source cannot support an action, ask one short question and propose only reviewing the saved state.
- Keep the first action concrete, reversible, and under the user's control.

SOURCE
${source}`;
}

function parseModelDraft(value: string): ModelDraft {
	const normalized = value.trim().replace(/^```(?:json)?\s*/i, "").replace(/\s*```$/, "");
	const parsed: unknown = JSON.parse(normalized);
	if (!isRecord(parsed)) throw new Error("InvalidModelSchema");
	if (
		typeof parsed.startHere !== "string" ||
		!Array.isArray(parsed.evidenceIds) ||
		!parsed.evidenceIds.every((item) => typeof item === "string") ||
		(parsed.later !== undefined &&
			(!Array.isArray(parsed.later) ||
				!parsed.later.every((item) => typeof item === "string"))) ||
		(parsed.assumptions !== undefined &&
			(!Array.isArray(parsed.assumptions) ||
				!parsed.assumptions.every((item) => typeof item === "string"))) ||
		(parsed.questions !== undefined &&
			(!Array.isArray(parsed.questions) ||
				!parsed.questions.every((item) => typeof item === "string")))
	) {
		throw new Error("InvalidModelSchema");
	}
	return parsed as unknown as ModelDraft;
}

function isRecord(value: unknown): value is Record<string, unknown> {
	return typeof value === "object" && value !== null && !Array.isArray(value);
}

function optionalString(value: unknown): string | undefined {
	return typeof value === "string" && value.trim() ? value.trim() : undefined;
}
