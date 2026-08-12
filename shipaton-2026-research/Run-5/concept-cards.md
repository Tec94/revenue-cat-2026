# Run 5 concept cards

These 21 concept cards turn the seven selected problem statements into bounded
products. Each card has one primary award, no more than two secondary awards,
and an explicit launch boundary. Names are placeholders, not brand decisions.

## Platform hypothesis used by every card

The working platform hypothesis is Android-first shared code. A Capacitor-style
web application shell is the default, with small native Android bridges only for
capabilities that directly improve the core loop. The Android release targets
phone, tablet, foldable, multi-window, and Galaxy Store quality. The iOS and
iPadOS build follows after the Android core is stable.

The initial Mac path is the compatible iPad or iPhone build distributed to and
tested on Apple-silicon Macs. Capacitor does not officially support macOS or Mac
Catalyst, so a dedicated Mac target is not part of the launch promise. This
decision prevents a third unsupported platform branch while preserving a real
secondary Mac distribution path.

Galaxy billing also requires an early technical spike. RevenueCat documents a
native Android Galaxy module and a React Native add-on, while its current Android
guide says support for other hybrid SDKs is still coming. A Capacitor release
added a Galaxy store type but no equivalent installation guide. Any concept that
lists the Galaxy award therefore depends on either confirmed Capacitor support,
a small native Capacitor billing bridge, or a stack change before production.

## T2-S1: Independent property inspectors

This family complements existing inspection suites. It does not replace report
templates, scheduling, customer relationship management, payment collection,
or licensed inspector judgment.

### C01: TraceTag

TraceTag is the model-assisted capture concept for the inspector family.

- **Promise:** Capture a defect once and turn its photos, spoken location, and
  notes into a verified, report-ready evidence bundle.
- **Target and trigger:** A solo property inspector finds a defect while moving
  through a property and cannot stop to navigate a deep report tree.
- **Job story:** When I document a defect in the field, I want the media and
  context to stay together, so I can finish a defensible report without
  reconstructing the inspection that evening.
- **Workaround and difference:** Inspectors take many photos, dictate notes,
  mark locations manually, and reconcile them later. TraceTag proposes a
  location and defect bundle but always exposes the source and asks the
  inspector to confirm it.
- **Core loop and memorable moment:** Capture photo and voice, receive a
  source-linked suggestion, correct or approve it, and export it. The memorable
  moment is watching a loose photo become a complete evidence card in one
  confirmation gesture.
- **Smallest launch and non-goals:** Launch camera and audio capture, local
  queue, location vocabulary, confidence display, correction, gallery, and PDF
  or structured export. Do not diagnose defects, estimate repairs, generate a
  complete report, schedule work, or bill clients.
- **Platform fit:** Android gets camera and share integration, offline durability,
  a foldable two-pane confirmation view, and DeX review. iOS gets the same core
  later. Apple-silicon Mac supports desk review through the iPad build.
- **RevenueCat boundary:** Free includes one sample inspection and manual
  export. Paid unlocks recurring inspections, custom vocabularies, reusable
  export mappings, and encrypted multi-device backup. Payment follows a
  successful evidence export.
- **Retention and distribution:** Every inspection creates repeat use. Recruit
  through inspector associations, professional forums, local inspector groups,
  and direct workflow demonstrations.
- **Dependencies:** Camera, microphone, local database, offline queue, speech
  recognition, optional vision or language inference, PDF or JSON export, and
  crash-safe media storage.
- **Main risk:** A wrong inferred location or description can create liability.
  Keep every suggestion editable, retain provenance, avoid defect diagnosis,
  and never overwrite inspector-authored language silently.
- **Evidence and missing proof:** Current inspector sources support photo
  placement, repeated location entry, and report-turnaround pain. Missing proof
  includes five inspector interviews, real report-format samples, field-noise
  tests, and willingness to use a companion app.
- **Awards:** Primary: RevenueCat Design Award. Secondary: Best App for Galaxy
  and HAMM Award.
- **Why the awards cohere:** The same evidence-card interaction demonstrates
  design; the same adaptive capture and review surfaces demonstrate Galaxy
  optimization; the same per-inspection value supports a professional paid
  tier.
- **Rejected bolt-ons:** Repair-cost estimates, contractor referrals, generic
  chat, an inspector marketplace, and Samsung features that do not shorten the
  capture-to-verification loop.

### C02: FieldBoard

FieldBoard is the non-AI, Galaxy-native capture and triage concept.

- **Promise:** Shoot freely during an inspection, then sort the evidence into a
  report outline on a fast, two-pane field board.
- **Target and trigger:** A solo inspector in weather, a crawlspace, or another
  interruption-sensitive setting needs to capture first and organize shortly
  afterward.
- **Job story:** When stopping to file each photo would break my concentration,
  I want to capture a batch and triage it quickly, so the report stays organized
  without slowing the inspection.
- **Workaround and difference:** Existing suites often require navigation at
  capture time or substantial desktop cleanup. FieldBoard separates rapid
  capture from a bounded drag, group, and verify session.
- **Core loop and memorable moment:** Capture to an inbox, open the board,
  drag photo groups into room or system columns, add one note, and export. The
  memorable moment is clearing a large inbox through fluid batch gestures.
- **Smallest launch and non-goals:** Launch a crash-safe photo inbox, batch
  selection, room and system columns, drag and drop, keyboard shortcuts, undo,
  and export. Do not add generative defect text, scheduling, payments, or team
  collaboration.
- **Platform fit:** The core interaction becomes materially better on Galaxy
  Fold, tablet, multi-window, stylus, and DeX. Phone remains a capture surface.
  iPad and Apple-silicon Mac later become review surfaces.
- **RevenueCat boundary:** Free includes one active board and standard export.
  Paid adds reusable structures, unlimited boards, high-resolution archives,
  and suite-specific mappings.
- **Retention and distribution:** Each inspection repeats the loop. Side-by-side
  time trials and short field videos make the acquisition claim observable.
- **Dependencies:** Camera, filesystem, local database, drag and drop, adaptive
  layout, export mapping, and optional cloud backup.
- **Main risk:** Media loss or state loss during resizing would destroy trust.
  Test process death, storage exhaustion, rotation, fold and unfold, and export
  recovery before adding polish.
- **Evidence and missing proof:** Inspector testimony supports batch capture and
  reduced tapping. Missing proof is whether a separate board beats incumbent
  gallery features enough to justify switching.
- **Awards:** Primary: Best App for Galaxy. Secondary: RevenueCat Design Award
  and HAMM Award.
- **Why the awards cohere:** The two-pane board is both the Galaxy optimization
  and the distinctive interaction. Paid reusable boards monetize the same
  professional time saving.
- **Rejected bolt-ons:** AI classification added only for novelty, unrelated
  device sensors, a full report editor, and Galaxy exclusivity before demand is
  established.

### C03: ReportProof

ReportProof moves the inspector wedge to a pre-delivery quality-control moment.

- **Promise:** Check a draft inspection report against its source media before
  delivery and expose missing, ambiguous, or unsupported evidence links.
- **Target and trigger:** A solo inspector has finished a report draft and wants
  a final quality-control pass before sending it to a client.
- **Job story:** When I am about to deliver a report, I want to see which claims
  lack clear source evidence, so I can correct gaps before they become client
  confusion or liability.
- **Workaround and difference:** Inspectors reread reports and search media
  manually. ReportProof links each flagged statement to the exact text and
  available photo without rewriting the inspector's judgment.
- **Core loop and memorable moment:** Import report and media, review a short
  evidence-gap queue, resolve or dismiss each item, and export a completion
  record. The memorable moment is a report-wide confidence view that opens the
  exact source with one action.
- **Smallest launch and non-goals:** Support one PDF or HTML format, media import,
  missing-location and missing-photo rules, citations, dismiss reasons, and an
  audit export. Do not assess code compliance, defect severity, repair cost, or
  legal sufficiency.
- **Platform fit:** Android supports import from existing report and photo apps;
  tablet and DeX support side-by-side review. iPad and Mac desk review follow.
- **RevenueCat boundary:** Free includes one sample audit. Paid uses report
  credits or a professional subscription for recurring checks and custom rules.
- **Retention and distribution:** The pre-delivery checkpoint repeats for every
  report. Distribution depends on inspector communities and integration guides.
- **Dependencies:** PDF or HTML parser, optical character recognition when
  needed, local media matching, rules engine, optional cited language inference,
  and encrypted storage.
- **Main risk:** Users can mistake a software check for legal or professional
  assurance. Label it as a completeness aid, preserve source context, and never
  issue a compliance score.
- **Evidence and missing proof:** Report liability and formatting variation are
  supported; demand for a separate preflight product and reliable cross-suite
  parsing remain unknown.
- **Awards:** Primary: HAMM Award. Secondary: RevenueCat Design Award.
- **Why the awards cohere:** Report credits or a professional plan map directly
  to a paid quality-control event, while the cited gap-resolution interface is
  the design evidence.
- **Rejected bolt-ons:** Legal guarantees, repair estimates, insurer workflows,
  and an unrelated consumer report explainer.

## T2-S2: Solo client-service professionals

This family converts informal client communication into confirmable work
records. It does not claim that silence creates a contract or replace legal
advice, invoicing, or project-management systems.

### C04: ScopeSignal

ScopeSignal focuses on a change that appears after work has already been scoped.

- **Promise:** Turn client voice notes and messages into cited scope changes that
  both sides can confirm before the extra work begins.
- **Target and trigger:** A freelancer or consultant receives a voice note,
  message thread, or call recap containing new requirements.
- **Job story:** When a client changes the work in an informal channel, I want a
  source-linked change card, so I can confirm cost, time, and responsibility
  without arguing from memory later.
- **Workaround and difference:** Users replay audio, transcribe it, update a
  document, and send a recap manually. ScopeSignal extracts only candidate
  changes, cites the exact source, and creates a correction-first confirmation
  link.
- **Core loop and memorable moment:** Share audio or text, verify extracted
  changes, add impact, send the link, and receive confirmed or corrected status.
  The memorable moment is the client turning a disputed-looking message stream
  into a mutually corrected change record.
- **Smallest launch and non-goals:** Launch Android share import, audio
  transcription, source excerpts, change fields, manual impact entry, signed
  web confirmation, reminders, and PDF export. Do not provide legal conclusions,
  automatic pricing, invoicing, or full project management.
- **Platform fit:** Android's share target makes capture immediate; iOS gets a
  share extension later. Tablet and Apple-silicon Mac support review and export.
- **RevenueCat boundary:** Free includes one client and limited change cards.
  Paid unlocks active projects, branded confirmation pages, history, exports,
  and optional transcription credits. The client never pays to correct a record.
- **Retention and distribution:** Each confirmation link creates recipient-side
  exposure. Freelancer communities, template partners, and public before-and-
  after examples support acquisition.
- **Dependencies:** Share intent, file import, speech recognition, language model
  with cited spans, signed web links, email or push, event analytics, and secure
  deletion.
- **Main risk:** Incorrect extraction or coercive confirmation language can harm
  trust. Require sender review, show sources, support explicit correction, and
  avoid claims about legal enforceability.
- **Evidence and missing proof:** Current discussions support voice-note review
  burden and written recap workarounds. Missing proof includes dispute frequency,
  client willingness to open links, and the acceptable confirmation tone.
- **Awards:** Primary: HAMM Award. Secondary: RevenueCat Design Award and The
  Growth Loop Award.
- **Why the awards cohere:** The confirmed change is the paid outcome, the cited
  correction flow is the design evidence, and the recipient link is the natural
  acquisition and experiment surface.
- **Rejected bolt-ons:** Contract generation, legal scoring, payment processing,
  a general meeting bot, and AI prose styles unrelated to scope confirmation.

### C05: BriefBack

BriefBack prevents ambiguity at intake through a no-install client surface.

- **Promise:** Let a client speak an informal brief and immediately correct the
  structured version before the freelancer accepts the job.
- **Target and trigger:** A solo professional starts a project with a client who
  prefers voice communication or struggles to write a formal brief.
- **Job story:** When my client explains a job in their easiest format, I want
  both of us to see the same structured brief, so I can begin with fewer hidden
  assumptions.
- **Workaround and difference:** Freelancers send forms that clients avoid or
  translate voice notes themselves. BriefBack uses a no-install capture page and
  makes the client's correction—not AI output—the authoritative value moment.
- **Core loop and memorable moment:** Client opens link, records or types, sees
  deliverables, constraints, examples, dates, and unknowns, corrects them, and
  submits. The freelancer accepts or asks one focused question.
- **Smallest launch and non-goals:** Launch secure link creation, voice and text
  capture, cited structuring, client correction, freelancer acceptance, expiry,
  and export. Do not create proposals, contracts, estimates, or a marketplace.
- **Platform fit:** Android creates and shares links quickly; the client uses the
  web. iOS and iPad follow for the freelancer; Mac supports desk review through
  the compatible iPad build.
- **RevenueCat boundary:** Free includes a small number of active briefs. Paid
  includes custom templates, branding, history, reusable questions, and larger
  media limits. Recipients remain free.
- **Retention and distribution:** Every client link is a product demonstration.
  Template sharing and freelancer-community examples can create organic reach.
- **Dependencies:** Web capture, media upload, transcription, cited extraction,
  secure link access, expiration, and export.
- **Main risk:** Client recordings can contain confidential material. Minimize
  retention, disclose processing before capture, support deletion, and prohibit
  hidden recording.
- **Evidence and missing proof:** Informal voice briefs and recap workarounds are
  observed. Missing evidence includes client completion, accessibility needs,
  and whether users prefer a forward-capture link over chat import.
- **Awards:** Primary: RevenueCat Design Award. Secondary: HAMM Award and The
  Growth Loop Award.
- **Why the awards cohere:** The same no-install correction interaction drives
  design, paid professional value, and recipient-led distribution.
- **Rejected bolt-ons:** Client relationship management, a proposal builder,
  generic forms, and an unrelated social feed.

### C06: Decision Ledger

Decision Ledger preserves how a client decision changes over time.

- **Promise:** Preserve decisions, open questions, owners, and revisions from
  scattered client communication in one source-linked ledger.
- **Target and trigger:** A consultant or small agency lead needs to recover what
  was decided across messages, notes, and calls.
- **Job story:** When a project decision changes over time, I want a traceable
  record of each version, so I can act on the current agreement without losing
  why it changed.
- **Workaround and difference:** Users copy summaries into project tools. This
  concept emphasizes provenance and revision diff rather than another polished
  meeting summary.
- **Core loop and memorable moment:** Share a source, confirm a decision card,
  update it when new evidence arrives, and view the before-and-after diff. The
  memorable moment is answering “when did this change?” in one tap.
- **Smallest launch and non-goals:** Launch text and audio import, cited decision
  cards, owner and date, superseded status, manual correction, search, and PDF
  export. Do not manage tasks, invoices, calendars, or all meeting notes.
- **Platform fit:** Android share capture is primary. Tablets, iPad, and
  Apple-silicon Mac support search and diff review.
- **RevenueCat boundary:** Free includes one project. Paid adds multiple active
  projects, extended history, export templates, and encrypted backup.
- **Retention and distribution:** Ongoing projects repeat the loop. Acquisition
  comes from consultants, client-operations communities, and decision-log
  templates.
- **Dependencies:** Share import, transcription, cited extraction, local search,
  diff model, and secure export.
- **Main risk:** A ledger can appear authoritative despite missing sources.
  Display coverage gaps, never hide corrections, and distinguish proposed,
  confirmed, and superseded records.
- **Evidence and missing proof:** Scattered decisions and manual recap are
  supported. Demand beyond existing project tools and the minimum viable import
  set remain unknown.
- **Awards:** Primary: HAMM Award. Secondary: RevenueCat Design Award.
- **Why the awards cohere:** A professional subscription pays for durable,
  source-linked decision history; the revision interaction supplies the design
  evidence.
- **Rejected bolt-ons:** Automated legal claims, task-board parity, email-client
  replacement, and generative status reports without citations.

## T3-S1: Dual-income households

This family treats household work as anticipation, choice, execution, and
monitoring. It must not make the already overloaded partner administer the app
or use points to disguise unequal ownership.

### C07: WholeJob

WholeJob makes end-to-end responsibility, rather than chores, the product unit.

- **Promise:** Let partners own complete household responsibilities instead of
  receiving isolated chores from a household manager.
- **Target and trigger:** A dual-income household repeatedly discovers that one
  partner remembers, plans, assigns, and checks work that both partners perform.
- **Job story:** When our household has a recurring responsibility, I want one
  visible owner for the whole outcome, so planning and monitoring do not fall
  back to the same person.
- **Workaround and difference:** Shared lists expose tasks but not cognitive
  ownership. WholeJob models anticipation, options, decision, execution, and
  monitoring as one responsibility lifecycle.
- **Core loop and memorable moment:** Create or adopt a responsibility, define
  “done,” receive its next anticipation cue, act, and close the loop. The
  memorable moment is a responsibility map that shows ownership without a
  competitive score.
- **Smallest launch and non-goals:** Launch a small responsibility library,
  two-person invite, lifecycle states, rotation, quiet cues, handoff, and a
  private reflection. Do not add chat, shopping, finance, meal planning, or a
  complete calendar.
- **Platform fit:** Android widgets and deep links reduce administration;
  foldable and tablet layouts show the household map and detail together. iOS
  follows; Mac is a review surface, not a separate workflow.
- **RevenueCat boundary:** Free includes one household and a bounded set of
  responsibilities. Paid adds custom cycles, history, calendar bridges, and
  additional household members. Paywall only after both partners complete a
  shared loop.
- **Retention and distribution:** Recurring responsibilities drive retention;
  partner invitation drives distribution. Acquisition must recruit both roles,
  not only the person already carrying the mental load.
- **Dependencies:** Authentication, household invite, local notifications,
  optional push, deep links, sync, and consent-safe analytics.
- **Main risk:** The product can intensify surveillance, conflict, or gendered
  management. Avoid leaderboards, private performance scores, unilateral task
  assignment, and normative claims about fairness.
- **Evidence and missing proof:** Research supports cognitive-labor stages and
  delegation failure. Missing proof is whether both partners voluntarily adopt
  the ownership model and how they define fairness.
- **Awards:** Primary: RevenueCat Peace Prize. Secondary: RevenueCat Design
  Award and Keep Them Coming Back Award.
- **Why the awards cohere:** The responsibility lifecycle is the impact
  mechanism and distinctive design; respectful anticipation cues are the core
  return behavior.
- **Rejected bolt-ons:** Points, public couple comparisons, relationship advice,
  generic calendars, and notifications sent mainly to shame a partner.

### C08: Claim the Outcome

Claim the Outcome transfers planning authority through a low-friction card.

- **Promise:** Turn upcoming household needs into claimable outcomes that a
  partner can plan without being assigned every step.
- **Target and trigger:** A household need appears, but the usual organizer does
  not want to research, divide, and monitor it again.
- **Job story:** When something needs attention at home, I want my partner to
  claim the outcome and propose a plan, so I am not delegating invisible steps.
- **Workaround and difference:** Chat messages and chore apps assign actions.
  This concept transfers the outcome and requires the claimant to choose the
  approach and next checkpoint.
- **Core loop and memorable moment:** Create a neutral outcome card, partner
  claims it, proposes plan and checkpoint, both clarify, and the owner closes it.
  The memorable moment is ownership becoming visible without a task list.
- **Smallest launch and non-goals:** Launch outcome cards, no-install claim link,
  plan and checkpoint fields, clarification, status, and history. Do not include
  chat, calendars, points, expenses, or household analytics.
- **Platform fit:** Android deep links and notifications keep recipient friction
  low; responsive shared code supports iOS and web recipients later.
- **RevenueCat boundary:** Free includes one household and a small active-card
  limit. Paid adds recurring outcome templates, history, and multiple groups.
- **Retention and distribution:** Recipient links create exposure, while repeat
  household needs create retention. Growth testing can measure claim completion,
  not invitation volume alone.
- **Dependencies:** Signed links, optional accounts, push, deep links, sync, and
  correction history.
- **Main risk:** A card can still feel like an order. Test neutral language,
  refusal and renegotiation paths, shared authorship, and notification limits.
- **Evidence and missing proof:** Research supports the distinction between
  ownership and help. Missing proof is whether outcome cards reduce or merely
  digitize conflict.
- **Awards:** Primary: RevenueCat Design Award. Secondary: RevenueCat Peace
  Prize and The Growth Loop Award.
- **Why the awards cohere:** The claim-and-plan interaction is both the design
  and impact mechanism, and its recipient link is the measurable growth loop.
- **Rejected bolt-ons:** Competitive scoring, automatic fairness judgments,
  family social networking, and a general household dashboard.

### C09: Weekly Handoff

Weekly Handoff reduces the product to a mutual planning ritual.

- **Promise:** Give two partners a five-minute ritual for choosing who owns the
  coming week's household outcomes.
- **Target and trigger:** A dual-income household starts a new week with changing
  schedules, commitments, and unspoken assumptions.
- **Job story:** When our week changes, I want a short mutual handoff, so we can
  agree on ownership before needs become emergencies.
- **Workaround and difference:** Couples talk informally or one partner creates
  the plan. Weekly Handoff limits itself to a mutual decision ritual with equal
  acceptance and a frozen summary.
- **Core loop and memorable moment:** Each partner privately nominates concerns,
  both reveal the overlap, trade ownership, accept the map, and receive only the
  cues they chose. The memorable moment is the private-to-shared reveal.
- **Smallest launch and non-goals:** Launch two-person invite, private input,
  merge, ownership negotiation, acceptance, a weekly summary, and one reminder.
  Do not add task execution, chat, shopping, finance, or performance scoring.
- **Platform fit:** Android widgets open the ritual and show accepted ownership;
  iOS follows. Large-screen layouts support side-by-side negotiation but are not
  required for first value.
- **RevenueCat boundary:** Free includes the weekly ritual and recent history.
  Paid adds reusable responsibility sets, calendar preview, longer history, and
  custom cadence.
- **Retention and distribution:** Weekly recurrence drives use; the product
  requires two-person activation. Recruit couples together for testing.
- **Dependencies:** Authentication, private drafts, merge logic, sync, push, and
  careful notification timing.
- **Main risk:** The ritual may expose conflict without helping resolution.
  Provide pause, disagree, defer, and edit paths; never adjudicate fairness.
- **Evidence and missing proof:** The ownership model is research-supported, but
  willingness to schedule a ritual and pay for it is unknown.
- **Awards:** Primary: RevenueCat Peace Prize. Secondary: RevenueCat Design
  Award and Keep Them Coming Back Award.
- **Why the awards cohere:** The mutual ritual is the proposed impact and design;
  one consented weekly cue is the return mechanism.
- **Rejected bolt-ons:** Couples therapy, AI arbitration, daily streaks, public
  sharing, and a full household organizer.

## T3-S2: Distributed family caregivers

This family stays separate from household coordination. Caregiving involves
least-privilege access, sensitive context, higher urgency, and role changes. The
launch scope coordinates logistics and handoffs, not medical treatment.

### C10: Care Relay

Care Relay focuses on a safe, acknowledged change-of-person handoff.

- **Promise:** Give the next caregiver a concise, acknowledged handoff without
  exposing an entire family dashboard.
- **Target and trigger:** A family caregiver finishes a visit or shift and needs
  another trusted person to continue logistical support.
- **Job story:** When I hand off care, I want the next person to see what changed,
  what matters now, and what they accepted, so the family does not repeat
  briefings or miss an action.
- **Workaround and difference:** Families use group chat, calls, and broad shared
  apps. Care Relay creates a time-bounded capsule with explicit recipients,
  acknowledgment, and minimum necessary detail.
- **Core loop and memorable moment:** Create update, choose recipients and
  detail level, assign or offer the next action, recipient acknowledges, and the
  sender sees coverage. The memorable moment is a calm handoff state instead of
  an unread-message stream.
- **Smallest launch and non-goals:** Launch invite, text and photo update,
  role-based visibility, action, acknowledgment, expiry, correction, and audit
  history. Do not store diagnoses, medication records, clinical measurements,
  emergency advice, or provider messaging.
- **Platform fit:** Android capture, notifications, and deep links support field
  handoff; tablet and iPad support overview. Apple-silicon Mac is useful for a
  coordinator but not required.
- **RevenueCat boundary:** Free includes one care circle and core handoffs. Paid
  adds more participants, longer history, export, and advanced role templates.
  Never paywall acknowledgment or urgent correction.
- **Retention and distribution:** Handoffs repeat around visits and tasks;
  trusted invitations drive distribution. Recruit through caregiver groups and
  nonprofit partners only with consent-safe messaging.
- **Dependencies:** Strong authentication, encryption, role policy, audit log,
  signed deep links, push, secure media, deletion, and account recovery.
- **Main risk:** Privacy leakage, ambiguous urgency, and mistaken reliance are
  substantial. Use least privilege, explicit non-emergency language, revocation,
  and visible receipt states.
- **Evidence and missing proof:** Distributed-care coordination and permission
  concerns are supported. Missing proof includes exact minimum data, family role
  models, legal review, and caregiver willingness to maintain another app.
- **Awards:** Primary: RevenueCat Peace Prize. Secondary: RevenueCat Design
  Award and Keep Them Coming Back Award.
- **Why the awards cohere:** Safer handoff is the impact mechanism; role-aware
  capsules are the design; acknowledged, respectful messages are the return loop.
- **Rejected bolt-ons:** Medical advice, medication dosing, emergency triage,
  health-record integration, and open caregiver matching.

### C11: Need-to-Know

Need-to-Know makes least-privilege family communication the core interaction.

- **Promise:** Write one family update and safely reveal only the detail each
  helper needs to act.
- **Target and trigger:** A primary family coordinator must update relatives,
  neighbors, and helpers who have different responsibilities and trust levels.
- **Job story:** When several people need different parts of an update, I want to
  route the minimum useful detail, so help is coordinated without oversharing.
- **Workaround and difference:** Group chat exposes the same message to everyone
  or forces repeated rewriting. Need-to-Know previews each recipient's view and
  blocks hidden inheritance of private attachments.
- **Core loop and memorable moment:** Draft update, tag logistical facts and
  private context, preview recipient views, send, and audit acknowledgments. The
  memorable moment is swiping through “what each person will see” before send.
- **Smallest launch and non-goals:** Launch role templates, field-level
  visibility, preview, recipient link, acknowledgment, revocation, and audit.
  Do not add medical records, automatic sensitivity classification, or clinical
  recommendations.
- **Platform fit:** Large and foldable Android screens support draft and recipient
  preview side by side. Shared code serves iOS; Mac compatibility helps a family
  coordinator review longer updates.
- **RevenueCat boundary:** Free includes one circle and basic roles. Paid adds
  custom roles, longer audit history, exports, and more circles. Privacy controls
  remain free.
- **Retention and distribution:** Updates and acknowledgments repeat; recipients
  can later become coordinators. Distribution must never expose care context in
  marketing or notification previews.
- **Dependencies:** Encryption, field-level authorization, secure links, push,
  audit history, redacted notification text, and recovery.
- **Main risk:** Permission design is difficult and one wrong default can expose
  sensitive information. No inferred access rules; default to less access and
  test revocation thoroughly.
- **Evidence and missing proof:** Existing caregiver-product reviews support
  oversharing concerns. Missing evidence includes a validated role taxonomy and
  legal or security review.
- **Awards:** Primary: RevenueCat Design Award. Secondary: RevenueCat Peace
  Prize and Keep Them Coming Back Award.
- **Why the awards cohere:** Least-privilege preview is the distinctive
  interaction and safety mechanism; acknowledgment messages use the same data
  and recipient behavior.
- **Rejected bolt-ons:** AI deciding who can see data, medical summaries,
  provider portals, public updates, and location surveillance.

### C12: Coverage Gap

Coverage Gap isolates the narrower problem of an unclaimed logistical need.

- **Promise:** Reveal an uncovered care visit, errand, or check-in and let a
  trusted helper claim it without exposing unrelated information.
- **Target and trigger:** A distributed family has a time-sensitive logistical
  need but no confirmed person covering it.
- **Job story:** When a support need is unclaimed, I want the right trusted people
  to see and accept only that need, so coverage becomes explicit before the gap
  turns urgent.
- **Workaround and difference:** Families ask in group chat and manually track
  replies. Coverage Gap uses a bounded request, capability filters, first-class
  decline, and an escalation state.
- **Core loop and memorable moment:** Create minimal request, select eligible
  helpers, send, accept or decline, confirm handoff, and close. The memorable
  moment is the gap visibly changing from uncovered to acknowledged coverage.
- **Smallest launch and non-goals:** Launch trusted circle, request, time window,
  location granularity, accept or decline, reminders, escalation contact, and
  completion. Do not store health records, dispatch strangers, or provide
  emergency services.
- **Platform fit:** Android notifications and deep links reduce response time;
  shared code supports iOS recipients. Mac has no core advantage.
- **RevenueCat boundary:** Free includes one circle and core requests. Paid adds
  multiple circles, repeating coverage templates, longer history, and export.
  Accepting or declining remains free.
- **Retention and distribution:** Each request repeats the coordination loop;
  trusted invitations distribute the product within a family.
- **Dependencies:** Authentication, contact invitation, push, deep links,
  minimal location, escalation logic, audit log, and secure deletion.
- **Main risk:** A missed or delayed alert could be mistaken for guaranteed
  coverage. Show delivery and acknowledgment separately, support phone fallback,
  and state that the app is not an emergency service.
- **Evidence and missing proof:** Caregiver coordination pain is supported, but
  the frequency of uncovered logistical windows and willingness to pay need
  primary interviews.
- **Awards:** Primary: RevenueCat Peace Prize. Secondary: Keep Them Coming Back
  Award.
- **Why the awards cohere:** The same safe, acknowledged request is the impact
  mechanism and the valuable messaging experience; no separate loop is added.
- **Rejected bolt-ons:** Medical alerts, volunteer marketplaces, continuous
  location tracking, gamified caregiving, and caregiver performance scores.

## T5-S1: Adults with ADHD or time blindness

This family supports return to action without claiming to diagnose or treat
ADHD. The core moment is resumption after distraction or plan failure, not
building a denser planner, punitive streak, or therapy product.

### C13: Reset Button

Reset Button is the smallest direct response to a plan that has failed.

- **Promise:** After a plan falls apart, get one feasible next action and start
  it without rebuilding the whole day.
- **Target and trigger:** An adult with ADHD or time blindness notices that they
  are stuck, late, distracted, or avoiding a now-unrealistic plan.
- **Job story:** When I have fallen off plan, I want one nonjudgmental next step
  that fits the time and energy I have, so I can restart instead of reorganizing
  everything.
- **Workaround and difference:** Users rewrite lists, ignore overdue reminders,
  or wait for urgency. Reset Button asks only for available time, current
  capacity, and what cannot be missed, then uses deterministic rules to select
  one user-authored action.
- **Core loop and memorable moment:** Tap **Reset**, answer three low-load
  questions, accept or swap one action, start a short focus block, and record the
  outcome. The memorable moment is the cluttered plan collapsing into one calm
  card without deleting anything.
- **Smallest launch and non-goals:** Launch task capture, three-question reset,
  rule-based action selection, swap, timer, completion or stop, and a recovery
  history. Do not add calendars, projects, coaching content, diagnosis, therapy,
  social feeds, or generative life planning.
- **Platform fit:** Android gets a home-screen widget, quick action, deep links,
  haptics, and restrained notifications. iOS gets widgets later. Mac is a
  compatible access point but not a primary context.
- **RevenueCat boundary:** Free keeps task capture and the core reset available.
  Paid adds custom reset recipes, context groups, cross-device sync, and private
  pattern summaries. Never paywall the immediate recovery action.
- **Retention and distribution:** Value repeats after derailment, but messaging
  must avoid manufacturing failure. Recruit through ADHD communities, student
  groups, and creator demonstrations with explicit nonclinical framing.
- **Dependencies:** Local database, widgets, notifications, timer, optional sync,
  accessibility testing, and outcome instrumentation. AI is not required.
- **Main risk:** The app can create shame, dependence, or unsafe prioritization.
  Let users define protected commitments, make every suggestion reversible, and
  avoid health or crisis decisions.
- **Evidence and missing proof:** Research supports initiation difficulty,
  planning anxiety, and emotional regulation needs. Missing proof includes the
  three minimum inputs, repeat benefit after novelty, and which language feels
  supportive rather than patronizing.
- **Awards:** Primary: RevenueCat Design Award. Secondary: RevenueCat Peace
  Prize and Keep Them Coming Back Award.
- **Why the awards cohere:** The one-card collapse is the design and benefit;
  an optional, context-aware return message brings the user back to that same
  recovery action.
- **Rejected bolt-ons:** An AI therapist, general calendar replacement, streaks,
  public productivity scores, and notifications optimized only for opens.

### C14: Breadcrumb

Breadcrumb preserves task context before the resumption problem grows.

- **Promise:** Leave one tiny context breadcrumb when you pause, then resume from
  the exact next physical step when attention returns.
- **Target and trigger:** An adult with ADHD or interruption sensitivity must
  stop a task and expects that reconstructing context will be difficult later.
- **Job story:** When I am interrupted or switch tasks, I want to preserve where
  I was and what I meant to do next, so returning does not require a fresh start.
- **Workaround and difference:** Users leave tabs open, message themselves, or
  rely on memory. Breadcrumb captures last state, next physical action, and one
  relevant artifact in under 20 seconds.
- **Core loop and memorable moment:** Trigger a quick action, capture a sentence
  or voice note and optional screenshot, pause, then reopen directly into the
  next step. The memorable moment is the app reconstructing a compact “you were
  here” card with no backlog.
- **Smallest launch and non-goals:** Launch Android share target and quick tile,
  text or voice breadcrumb, one attachment, snooze or context cue, resume view,
  completion, and deletion. Do not add projects, calendars, meeting notes,
  automatic screen recording, or continuous activity monitoring.
- **Platform fit:** Android share surfaces, widgets, notifications, and foldable
  continuity are central. A foldable can show the source artifact and next step
  together. iOS gets a share extension later; Mac compatibility supports
  artifact review.
- **RevenueCat boundary:** Free includes a small active breadcrumb set and local
  use. Paid adds unlimited history, multiple context spaces, encrypted sync, and
  custom return cues. Core resume remains free.
- **Retention and distribution:** Every interruption can repeat the loop without
  demanding daily use. Demonstrations are visually clear and communities can
  share personal interruption workflows without exposing private content.
- **Dependencies:** Share intent, quick settings tile or shortcut, microphone,
  attachments, local encryption, widget, deep link, and optional sync. AI is not
  required.
- **Main risk:** Captured screenshots or audio can contain confidential data.
  Default to local storage, show attachment previews, support rapid deletion,
  and never capture in the background.
- **Evidence and missing proof:** Interruption research supports resumption lag,
  and ADHD research supports working-memory and switching difficulty. Missing
  proof is whether users remember to leave a breadcrumb and which trigger makes
  capture automatic enough without surveillance.
- **Awards:** Primary: RevenueCat Design Award. Secondary: Best App for Galaxy
  and Keep Them Coming Back Award.
- **Why the awards cohere:** The capture-to-resume interaction is the design;
  foldable continuity and Android quick surfaces improve it directly; the
  return cue opens the exact breadcrumb rather than a generic home screen.
- **Rejected bolt-ons:** Passive screen monitoring, a full task manager,
  generative coaching, public sharing, and Samsung features without context-
  recovery value.

### C15: Start Together

Start Together tests bounded social scaffolding with known contacts only.

- **Promise:** Ask one trusted person to silently start a difficult task with you
  for ten minutes, without joining a public productivity network.
- **Target and trigger:** An adult with ADHD knows the next action but cannot
  cross the initiation threshold alone.
- **Job story:** When I am frozen before a task, I want a trusted person to join
  a bounded start, so social presence helps me begin without requiring coaching
  or explanation.
- **Workaround and difference:** Users call friends, join body-doubling rooms, or
  send accountability messages. Start Together limits the commitment to a
  direct contact, a named start action, and a short silent session.
- **Core loop and memorable moment:** Choose action and duration, send private
  invite, recipient accepts or declines, both see the same start pulse, and each
  closes privately. The memorable moment is the synchronized start, not a chat.
- **Smallest launch and non-goals:** Launch trusted contacts, signed invite,
  accept or decline, synchronized timer, quiet status, completion, blocking, and
  abuse reporting. Do not add stranger matching, video, public rooms, feeds,
  rankings, or coaching.
- **Platform fit:** Android deep links, notifications, and haptics make acceptance
  fast; shared code supports iOS recipients. Mac has little core advantage.
- **RevenueCat boundary:** Free includes direct-contact starts. Paid adds small
  private circles, recurring availability windows, and personal summaries.
  Recipients never pay to accept.
- **Retention and distribution:** Each invite exposes the product to a trusted
  recipient. Retention depends on successful starts, not notification volume.
- **Dependencies:** Contact invitation without uploading the address book,
  signed links, synchronized timer, push, blocking, reporting, and moderation
  support.
- **Main risk:** Social pressure, harassment, and sensitive task disclosure.
  Make decline effortless, minimize notification text, restrict launch to known
  contacts, and include blocking from day one.
- **Evidence and missing proof:** Qualitative ADHD research supports social
  scaffolds. Missing proof includes invitation acceptance, burden on supporters,
  and whether ten minutes is the right commitment.
- **Awards:** Primary: RevenueCat Peace Prize. Secondary: Keep Them Coming Back
  Award and The Growth Loop Award.
- **Why the awards cohere:** The trusted co-start is the benefit, message, and
  recipient loop. No unrelated audience or content system is needed.
- **Rejected bolt-ons:** Stranger matching, livestreams, chat, leaderboards,
  public streaks, and influencer identity.

## T5-S2: Adults managing chronic illness and variable capacity

This family helps users make conservative, user-defined trade-offs. It does not
diagnose conditions, prescribe activity, infer a safe exertion threshold, or
promise that digital pacing improves clinical outcomes.

### C16: Capacity Compass

Capacity Compass provides a user-authored daily trade-off surface.

- **Promise:** Build today's feasible plan from current capacity, essential work,
  meaningful activity, and protected recovery without marking a reduced day as
  failure.
- **Target and trigger:** An adult with variable capacity begins a day that does
  not match yesterday's plan or baseline.
- **Job story:** When my available energy changes, I want to choose what deserves
  it today, so I can protect necessities, meaning, and recovery without forcing
  an unrealistic schedule.
- **Workaround and difference:** Users use paper, calendars, symptom logs, and
  energy metaphors. Capacity Compass asks for a self-defined capacity band and
  turns existing commitments into a three-part trade-off, without claiming to
  calculate medical limits.
- **Core loop and memorable moment:** Check capacity, choose one essential, one
  meaningful option, and recovery space, then adjust during the day. The
  memorable moment is a plan shrinking gracefully while preserving what the
  user values.
- **Smallest launch and non-goals:** Launch capacity check-in, task effort labels,
  essential and meaningful priorities, recovery blocks, replan, completion or
  defer, and private history. Do not add symptom diagnosis, wearable thresholds,
  treatment advice, social comparison, or provider dashboards.
- **Platform fit:** Android widget and quiet replan notification reduce effort;
  adaptive layouts support tablet planning. iOS follows; Apple-silicon Mac can
  review plans but is secondary.
- **RevenueCat boundary:** Free includes the daily capacity plan and replan.
  Paid adds custom capacity language, calendar bridge, encrypted sync, longer
  pattern views, and export. Never paywall the reduced-day path.
- **Retention and distribution:** Capacity variability creates repeat need, but
  the app must permit quiet days. Recruit through patient communities and
  disability organizations with expert and community review.
- **Dependencies:** Local database, optional calendar read access, widget,
  restrained notifications, accessibility support, encryption, and export. AI
  is not required.
- **Main risk:** Users can interpret a plan as medical pacing guidance. Make all
  capacity judgments user-authored, avoid biometrics at launch, and state the
  self-management boundary clearly.
- **Evidence and missing proof:** Research supports variable capacity, priority
  trade-offs, and alert overload; a digital pacing trial did not outperform
  usual care. Missing proof includes benefit for the chosen condition mix,
  acceptable input burden, and expert-reviewed language.
- **Awards:** Primary: RevenueCat Peace Prize. Secondary: RevenueCat Design
  Award and Keep Them Coming Back Award.
- **Why the awards cohere:** Respectful replan is the impact and design; optional
  messages support that exact self-authored plan rather than demanding activity.
- **Rejected bolt-ons:** A readiness score, automatic safe limits, health-device
  diagnosis, clinician replacement, and engagement streaks.

### C17: Recovery Reserve

Recovery Reserve protects one meaningful event and its surrounding rest.

- **Promise:** Protect recovery around one meaningful event before the rest of
  the calendar consumes the user's available capacity.
- **Target and trigger:** A person with variable capacity wants to preserve a
  social, medical, family, or personal event that may require preparation and
  recovery.
- **Job story:** When an event matters to me, I want to reserve preparation and
  recovery around it, so routine obligations do not silently make it impossible.
- **Workaround and difference:** Users manually block calendars or cancel late.
  Recovery Reserve treats rest as a first-class, private commitment and exposes
  schedule conflicts without prescribing a medical dose.
- **Core loop and memorable moment:** Choose meaningful event, add user-defined
  preparation and recovery buffers, resolve conflicts, receive a gentle check,
  and reflect afterward. The memorable moment is seeing protected recovery
  space appear around what matters.
- **Smallest launch and non-goals:** Launch manual event, user-defined buffers,
  conflict view, edit, quiet reminder, after-event note, and calendar export.
  Do not calculate exertion, import health records, recommend exercise, or
  automatically cancel commitments.
- **Platform fit:** Android calendar intent, widget, and notifications make the
  plan visible; iOS calendar support follows. Tablet and Mac add review space
  but do not change the core.
- **RevenueCat boundary:** Free includes a limited number of active event plans.
  Paid adds recurring event templates, calendar sync, longer reflection history,
  and household sharing under explicit consent.
- **Retention and distribution:** Events recur irregularly. Distribution can
  come through condition communities, occupational therapists, and accessibility
  advocates after review.
- **Dependencies:** Calendar integration, local database, notification controls,
  encryption, export, and accessible time controls.
- **Main risk:** The buffer can appear medically recommended or increase anxiety.
  Keep durations user-defined, support uncertainty, and avoid success or failure
  judgments.
- **Evidence and missing proof:** Pacing studies support preemptive rest and
  meaningful trade-offs. Missing proof includes whether event-centered planning
  is frequent enough for retention and which users find it supportive.
- **Awards:** Primary: RevenueCat Peace Prize. Secondary: RevenueCat Design
  Award and Keep Them Coming Back Award.
- **Why the awards cohere:** Protected recovery is the impact and visual design;
  reminders are only useful when tied to the user's chosen event and buffer.
- **Rejected bolt-ons:** Wearable thresholds, medical alerts, provider messaging,
  automatic cancellation, and a generic calendar replacement.

### C18: Pattern Without Pressure

Pattern Without Pressure tests transparent reflection over a longer time frame.

- **Promise:** Record tiny activity and after-effect notes to reveal personal
  associations without turning life into a medical dashboard.
- **Target and trigger:** An adult with fluctuating symptoms wants to remember
  what preceded a difficult or manageable period but cannot sustain detailed
  tracking.
- **Job story:** When my capacity changes after an activity, I want a lightweight
  record of what happened, so I can discuss possible patterns without trusting
  memory or collecting excessive data.
- **Workaround and difference:** Users keep symptom diaries, spreadsheets, or
  wearable dashboards. This concept limits each entry to activity, self-rated
  effort, and later after-effect, then presents associations with uncertainty.
- **Core loop and memorable moment:** Log activity in seconds, receive one
  optional later check-in, view a source-linked pattern card, and annotate it.
  The memorable moment is opening a pattern and seeing the exact entries behind
  it instead of an unexplained score.
- **Smallest launch and non-goals:** Launch local activity entry, optional
  after-effect prompt, tags, timeline, transparent counts, export, and deletion.
  Do not diagnose, predict crashes, recommend treatment, import continuous
  biometrics, or notify caregivers.
- **Platform fit:** Android quick capture and quiet notifications reduce burden;
  iOS follows. Tablet and Mac support pattern review and export.
- **RevenueCat boundary:** Free includes core logging and recent patterns. Paid
  adds longer history, custom tags, encrypted sync, and clinician-readable
  export. Data export and deletion remain free.
- **Retention and distribution:** Value accumulates slowly, which raises dropout
  risk. Distribution requires trusted patient communities and expert review,
  not performance marketing claims.
- **Dependencies:** Local encrypted database, scheduled check-in, simple
  transparent statistics, export, deletion, and accessibility support. AI is not
  required.
- **Main risk:** False causal inference, fixation, and data burden. Use
  “associated with,” show sample counts, suppress weak patterns, and let users
  disable analysis or reminders.
- **Evidence and missing proof:** Research supports ongoing adjustment and warns
  about data overload. Missing proof includes sustainable logging frequency and
  whether the resulting associations change a useful decision.
- **Awards:** Primary: RevenueCat Design Award. Secondary: RevenueCat Peace
  Prize.
- **Why the awards cohere:** Transparent, source-linked patterns are the design
  and the proposed benefit; no extra award-specific loop is required.
- **Rejected bolt-ons:** Risk predictions, medical recommendations, competitive
  tracking, public symptom sharing, and a generic health dashboard.

## T5-S3: Long-horizon learners after interruption

This family treats prior learning as recoverable history. It avoids content-
heavy course production, streak punishment, and game economies that optimize
daily opens instead of meaningful progress.

### C19: Reentry Map

Reentry Map uses retained knowledge to choose a return point.

- **Promise:** After a long learning break, find what you still know and receive
  one evidence-based next lesson instead of restarting everything.
- **Target and trigger:** A self-directed learner returns to a course, deck, or
  structured subject after weeks or months away.
- **Job story:** When I return after a gap, I want a short check of retained
  knowledge and missing prerequisites, so I can resume at the right place
  without wasting prior progress.
- **Workaround and difference:** Learners restart, guess where to resume, or face
  a large overdue queue. Reentry Map uses a small diagnostic tied to the user's
  own outline or source material and preserves the evidence behind the route.
- **Core loop and memorable moment:** Import or outline the learning path,
  complete a five-minute return check, review retained and uncertain nodes, and
  start one recommended lesson. The memorable moment is the old progress map
  relighting around what remains known.
- **Smallest launch and non-goals:** Launch one text or PDF outline import,
  user-confirmed topic map, short diagnostic, retained or uncertain states, one
  next lesson, and checkpoint. Do not host courses, generate unverified subject
  matter, grade credentials, or build a social network.
- **Platform fit:** Android supports file share and short mobile checks; tablet,
  iPad, and Apple-silicon Mac support map and source review.
- **RevenueCat boundary:** Free includes one learning map and return check. Paid
  adds multiple maps, larger sources, encrypted sync, and longitudinal return
  history. The first reentry result arrives before the paywall.
- **Retention and distribution:** Use is episodic around gaps. Distribution can
  come from learning communities, course creators, and shareable blank recovery
  templates without exposing scores.
- **Dependencies:** File parsing, source-linked question generation or manual
  questions, scoring logic, local storage, and optional sync. If a model creates
  questions, every answer must link to supplied source material.
- **Main risk:** Poor questions can misplace a learner or invent facts. Limit the
  domain, preserve citations, let users mark the map wrong, and avoid credential
  claims.
- **Evidence and missing proof:** Learner threads support backlog dread and
  uncertainty about reset versus resume. Missing proof includes cross-domain
  diagnostic quality and willingness to import learning material.
- **Awards:** Primary: RevenueCat Design Award. Secondary: Next Gen Award and
  Keep Them Coming Back Award.
- **Why the awards cohere:** The retained-knowledge map is the design and student
  technical evidence; a return cue opens the next verified lesson.
- **Rejected bolt-ons:** A course library, AI tutor chat, certificates, public
  leaderboards, and streak protection unrelated to learning state.

### C20: Backlog Tamer

Backlog Tamer targets the visible and technically bounded review-backlog case.

- **Promise:** Turn an overwhelming review backlog into a bounded recovery ramp
  without deleting useful learning history.
- **Target and trigger:** A spaced-repetition learner returns to hundreds or
  thousands of overdue items and avoids opening the deck.
- **Job story:** When my review backlog feels impossible, I want a manageable
  daily recovery slice that preserves what I still know, so I can resume without
  a destructive reset.
- **Workaround and difference:** Users reset decks, alter due dates, create
  filtered decks, or endure the entire queue. Backlog Tamer proposes a reversible
  ramp, shows why items are prioritized, and never edits the source deck without
  preview and backup.
- **Core loop and memorable moment:** Import deck summary or select a manual
  backlog, choose a sustainable session size, review the prioritized slice, and
  watch the recovery forecast update. The memorable moment is the intimidating
  overdue count becoming today's bounded session.
- **Smallest launch and non-goals:** Launch read-only Anki package or CSV import,
  local backup, retrievability or interval-based priority, daily cap, preview,
  session export, and progress. Do not build a flashcard editor, course library,
  synchronization service, or universal learning algorithm.
- **Platform fit:** Android handles file imports and portable sessions; tablet,
  iPad, and Apple-silicon Mac support deck review. No Samsung-only behavior is
  needed.
- **RevenueCat boundary:** Free includes one deck and a basic recovery ramp.
  Paid adds multiple decks, strategy comparison, encrypted sync, and longer
  forecasts. Backup and safe export remain free.
- **Retention and distribution:** Recovery sessions repeat until the backlog is
  controlled. Anki and language-learning communities are reachable, but
  integration rules and community trust matter.
- **Dependencies:** Safe deck parser, local backup, transparent priority
  algorithm, export, test fixtures, and compatibility maintenance. AI is not
  required.
- **Main risk:** A bad import or write-back can damage years of learning data.
  Launch read-only, create verified backups, make every plan reversible, and
  publish the algorithm.
- **Evidence and missing proof:** Anki sources directly support backlog dread,
  bounded daily loads, and preserving history. Missing proof includes demand
  outside Anki and whether a companion is better than documented filtered-deck
  methods.
- **Awards:** Primary: RevenueCat Design Award. Secondary: Next Gen Award.
- **Why the awards cohere:** A transparent recovery ramp is the design and the
  student-build technical story; the public repository can expose safe parsing
  and prioritization for review.
- **Rejected bolt-ons:** New flashcard content, a social league, streaks, an AI
  tutor, and direct deck mutation in the launch version.

### C21: Project Thread

Project Thread preserves context for learning through long-running projects.

- **Promise:** Leave a restartable trail of artifacts, sources, decisions, and
  the next question whenever a long learning project pauses.
- **Target and trigger:** A learner builds skill through a coding, research,
  writing, design, or maker project that may pause for days or months.
- **Job story:** When I stop a learning project, I want future me to know what
  worked, what remains uncertain, and what to try next, so returning produces an
  action instead of archaeology.
- **Workaround and difference:** Learners leave tabs, notes, commits, and files
  scattered across tools. Project Thread creates one checkpoint around an
  artifact and next question rather than becoming a general notes app.
- **Core loop and memorable moment:** Share an artifact or link, record what
  changed and the next question, pause, then reopen into a compact resumption
  view and create the next artifact. The memorable moment is a timeline that
  highlights decisions and questions, not elapsed inactivity.
- **Smallest launch and non-goals:** Launch project, artifact or link share,
  checkpoint fields, next question, resume card, search, and export. Do not add
  generic document editing, course content, task management, collaboration, or
  AI-generated lessons.
- **Platform fit:** Android share capture and foldable two-pane artifact review
  are useful; iOS share support follows. Apple-silicon Mac compatibility is
  especially useful for source and artifact review.
- **RevenueCat boundary:** Free includes one active project and local history.
  Paid adds multiple projects, encrypted sync, larger attachments, and export
  formats. The core checkpoint and resume loop remains free.
- **Retention and distribution:** Each work session can end with a checkpoint,
  but the product tolerates long silence. Build-in-public learners can share an
  empty template or redacted checkpoint, not private project content.
- **Dependencies:** Share intent, file and link metadata, local search,
  attachments, encryption, sync, and export. AI is not required.
- **Main risk:** The concept can become another notes application. Enforce the
  checkpoint schema and test whether it reduces resumption time after a real
  multi-day gap.
- **Evidence and missing proof:** Learning-return evidence supports preserving
  progress rather than resetting. Missing proof is specific to project-based
  learners and requires diary studies across an actual interruption.
- **Awards:** Primary: Next Gen Award. Secondary: RevenueCat Design Award and
  Keep Them Coming Back Award.
- **Why the awards cohere:** The public student build can expose the checkpoint
  data model; the resumption interaction is the design; a contextual return cue
  opens the exact project thread.
- **Rejected bolt-ons:** A knowledge-base clone, collaboration suite, AI tutor,
  public portfolio network, and daily streak.

## Combination rule

Only one concept pair is pre-approved for possible combination: C13 Reset
Button and C14 Breadcrumb. They serve the same user and the same interruption-
to-resumption loop. A combined concept can capture the next step before or
during interruption and use the same card during reset. Even this combination
must defer calendars, projects, and social features.

No other pair is approved for combination at this gate. T3-S1 and T3-S2 share
coordination mechanics but not the same persona, privacy model, urgency, or
safety burden. T2-S1 and T2-S2 both create usable artifacts, but one handles
licensed field evidence and the other handles client agreement. Combining those
families would create separate core loops and feature sprawl.
