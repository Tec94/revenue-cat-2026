# Run 3 pattern codebook

This codebook freezes the Run 3 tests before synthesis. It covers all 39
officially placed 2024–2025 projects and the 16 unique matched controls from
Run 2. The unit of analysis is a project, not a source, screenshot, update, or
claim. A project therefore contributes at most one instance to each pattern.

## Scope and comparison limits

The winner corpus is complete for placed projects in the two official winner
announcements. The control set is purposive rather than exhaustive: each
control is a same-year public submission selected in Run 2 for platform,
problem, mechanism, or likely award-family similarity. Public Devpost pages do
not consistently expose the awards a non-winner entered, so control-family
labels remain analytical matches rather than confirmed head-to-head entries.

The recurrence matrix separates strength of evidence from absence:

- `2` means strong support from an observed artifact, a traceable
  contemporaneous builder account, or a dated metric with provenance.
- `1` means partial support, a weaker builder description, or a pattern that
  appears but is incomplete.
- `0` means the available evidence actively contradicts the pattern, or the
  pattern is absent despite enough evidence to assess it.
- `U` means the public evidence is insufficient to test the pattern.

Frequencies treat `1` and `2` as present. Strong-support rates use only `2`.
Unknowns are excluded from the assessed denominator and are always reported.
No analyst code is presented as a judge score.

## User-selected tests

The user selected Option A from Run 2 and added P05, producing nine tests.
Each definition below fixes the positive threshold and likely
counterevidence.

- **P01 — Coherent primary loop.** A recurring trigger leads to one dominant
  action, a visible value moment, and a plausible repeat trigger. Several
  equally weighted loops or a feature inventory without a dominant path is
  counterevidence.
- **P02 — Short time to first value.** A new user can reach the promised result
  in one short session without extensive setup, data accumulation, or a paid
  gate. Long onboarding, mandatory account creation, or value that requires
  days of history is counterevidence.
- **P03 — Shipped differentiating mechanism.** The event build visibly ships a
  mechanism a judge can distinguish from category convention. A promise that
  depends on a roadmap item, generic AI wrapper, or cosmetic theme alone does
  not qualify strongly.
- **P04 — Feedback-to-result chain.** Evidence links feedback or an observed
  problem to a product decision, shipped change, and an observed result. A
  public changelog without the decision or result is partial support, not a
  complete chain.
- **P05 — Information restraint.** The main journey suppresses nonessential
  decisions and keeps hierarchy legible. Dense dashboards, broad home-screen
  choice, or unrelated feature families are counterevidence.
- **P06 — Judge-observable proof.** The submission makes the promise, working
  flow, award fit, or result visible within the description, images, and first
  two minutes of video. Claims that require private access or inference are
  weak support.
- **P07 — Monetization follows delivered value.** The paywall, credits, ads, or
  purchase boundary follows a demonstrated value moment or meters an expensive
  value-producing action. A forced pre-value paywall, ambiguous packaging, or
  ads that disrupt the core job are counterevidence.
- **P10 — Proportional trust, safety, and recovery.** Safeguards match the
  product's stakes, including privacy boundaries, truthful limitations,
  permission timing, and recoverable failure states. High-stakes claims without
  corresponding controls are counterevidence.
- **P11 — Experiment runway.** Release or meaningful external testing happens
  early enough to support a measurement-and-change cycle before judging. A
  deadline-day listing or private prototype without a completed learning loop
  is counterevidence.

## Prompt-mandated supplementary tests

Run 3 explicitly requires eight additional checks. They are coded separately
so adding them does not rewrite the user's selected hypotheses after seeing
the evidence.

- **S01 — Ten-second value proposition.** The target, triggering problem, and
  concrete value are understandable in one sentence or the opening demo beat.
- **S02 — Personal founder insight.** A specific lived, professional, or
  repeatedly observed experience shaped the problem choice or product wedge.
- **S03 — Narrow first version.** The initial shipped scope serves one segment
  and one central job, even if later expansion is described.
- **S04 — Platform-native leverage.** The product uses a platform capability
  in the value path, not merely as implementation plumbing. Examples include
  HealthKit, widgets, camera/audio hardware, Pencil, Watch, foldables, or
  adaptive windows.
- **S05 — Measurable traction.** A dated, attributable outcome reports use,
  revenue, retention, behavior change, reach, or conversion. Download-free
  adjectives such as “great reception” are not strong support.
- **S06 — Built-in distribution loop.** Product use naturally creates an
  invite, shareable artifact, recipient benefit, public link, multiplayer
  requirement, or user-generated supply. Marketing activity alone is partial
  at most.
- **S07 — Distinctive visual or motion signature.** Event-period evidence shows
  a recognizable visual, spatial, animation, or interaction language that is
  integral to the experience.
- **S08 — Affirmative accessibility or trust evidence.** Event-period evidence
  shows concrete inclusive, privacy, safety, transparency, or recovery
  behavior. A general claim that the product is accessible or private is
  partial support.

## Classification rules

The synthesis uses transparent thresholds as guardrails, followed by a
qualitative review of mechanisms, award criteria, evidence quality, and
counterexamples.

- A **candidate winner differentiator** should appear at least 15 percentage
  points more often among winners than controls, recur in both years and more
  than one family, and have no major evidence-quality imbalance.
- A **common good-app practice** has a winner-control gap under 10 percentage
  points, appears as often or more often in controls, or has no credible link
  beyond general product quality.
- An **award-specific pattern** is concentrated in a family whose historical
  wording directly rewards it and should not be generalized to other awards.
- A **high-confidence transferable pattern** requires direct alignment with
  exact 2026 criteria, strong or repeated evidence, a plausible observable
  mechanism, and no decisive counterexample. Transferability does not by
  itself mean historical differentiation.
- Confidence is reduced when more than 25% of projects are `U`, the control
  match is especially uncertain, timing is current rather than
  contemporaneous, or the proposed mechanism depends on unobserved judge
  reasoning.

## Source handling

The matrix uses the official rules and winner announcements as source tier A;
contemporaneous Devpost submissions, videos, store assets, repositories, and
builder posts as tier B; current listings, interviews, and press as tier C;
and analyst inference as tier D. Current interfaces are not treated as the
interfaces judges saw. Builder metrics remain described or measured-with-
provenance, not independently audited.

Exa supplied primary discovery and full-text extraction for the corpus. Prior
Run 2 Firecrawl and vision fallbacks remain valid for the event-period visual
evidence already recorded in the dossiers. No new browser, Firecrawl, or vision
fallback was required for Run 3 because this run codes recurrence rather than
reconstructing additional screens.
