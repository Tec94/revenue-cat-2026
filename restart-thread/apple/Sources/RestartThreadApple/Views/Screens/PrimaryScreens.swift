import RestartThreadCore
import SwiftUI

struct BootstrapScreen: View {
    var body: some View {
        VStack(spacing: 18) {
            BrandMark().frame(width: 112, height: 112)
            Text("Restart Thread").font(.system(size: 34, weight: .bold, design: .serif))
        }
        .frame(maxWidth: .infinity)
        .padding(.top, 104)
    }
}

struct WelcomeScreen: View {
    @ObservedObject var controller: RestartThreadController

    var body: some View {
        VStack(alignment: .leading, spacing: 24) {
            BrandMark().frame(width: 118, height: 118).frame(maxWidth: .infinity)
            PageIntro(
                eyebrow: "A clear place to restart",
                title: "Say where you are. Start again from one clear step.",
                bodyText: "Leave a thread in your own words. It stays on this device and gives you one place to begin.",
                display: true
            )
            PrivacyNote("No account or microphone permission is needed to begin.")
            VStack(spacing: 12) {
                PrimaryActionButton(title: "Leave my first thread", action: controller.leaveFirstThread)
                SecondaryActionButton(title: "Try the 20-second example", action: controller.tryExample)
                TertiaryActionButton(title: "Sign in", action: controller.showAccountOffer)
                TertiaryActionButton(title: "How your data stays local", action: controller.showDataPrivacy)
            }
        }
        .padding(.top, 28)
    }
}

struct CaptureScreen: View {
    @ObservedObject var model: RestartThreadAppModel
    @ObservedObject private var controller: RestartThreadController

    init(model: RestartThreadAppModel) {
        self.model = model
        controller = model.controller
    }

    var body: some View {
        VStack(alignment: .leading, spacing: 24) {
            PageIntro(
                eyebrow: "Leave a thread",
                title: "Where were you?",
                bodyText: "Say or type what is true right now. Your words save on this device before anything else happens."
            )
            ContentCard {
                Text("Current state").font(.headline)
                TextEditor(text: Binding(get: { controller.state.input }, set: controller.setInput))
                    .font(.body)
                    .frame(minHeight: 132)
                    .padding(8)
                    .background(.quaternary, in: RoundedRectangle(cornerRadius: 10))
                    .accessibilityLabel("Current state")
                    .accessibilityHint("Describe where you stopped or what is blocking you")
                CaptureProgressView(progress: controller.state.captureProgress)
            }
            VStack(spacing: 12) {
                PrimaryActionButton(title: "Save and find a first step", ink: true, action: controller.saveText)
                SecondaryActionButton(
                    title: controller.state.isRecording ? "Stop and save voice note" : "Record a voice note"
                ) { model.voiceTapped() }
            }
            Text("Voice and text are equal routes. Microphone access is requested only after you choose voice.")
                .foregroundStyle(.secondary)
        }
        .alert("Record where you left off", isPresented: $model.showMicrophoneRationale) {
            Button("Continue") { Task { await model.requestVoicePermission() } }
            Button("Use text", role: .cancel, action: model.continueWithText)
        } message: {
            Text(
                "Restart Thread needs microphone access only while you record this voice note. " +
                    "The recording is encrypted on this device, and you can always type instead."
            )
        }
    }
}

struct ReviewScreen: View {
    @ObservedObject var controller: RestartThreadController
    @Environment(\.accessibilityReduceMotion) private var reduceMotion
    let isExample: Bool
    @State private var whyVisible = false

    var body: some View {
        VStack(alignment: .leading, spacing: 24) {
            if isExample { StatusPill(text: "20-second example") }
            PageIntro(
                eyebrow: isExample ? "Try the core loop" : "Your first step",
                title: "Start here",
                bodyText: isExample
                    ? "This example is temporary. Change the first step or start it as written."
                    : "Keep the step small and specific. You can change the draft before anything starts."
            )
            CaptureProgressView(progress: controller.state.captureProgress)
            EvidenceCard(
                label: "You said",
                text: controller.state.input.isEmpty ? controller.state.evidence : controller.state.input
            )
            DottedTrace()
            ContentCard {
                Text("Editable first step").font(.headline)
                TextEditor(text: Binding(get: { controller.state.action }, set: controller.setAction))
                    .font(.title3.weight(.semibold))
                    .frame(minHeight: 96)
                    .padding(8)
                    .background(.quaternary, in: RoundedRectangle(cornerRadius: 10))
                    .accessibilityLabel("Editable first step")
                Text(controller.state.isAIGenerated ? "AI draft. You decide what to keep and when to start." : "You decide what to keep and when to start.")
                    .font(.footnote)
                    .foregroundStyle(.secondary)
            }
            VStack(spacing: 12) {
                PrimaryActionButton(title: "Start this step", action: controller.confirmStart)
                SecondaryActionButton(title: whyVisible ? "Hide source" : "Why this step?") {
                    withAnimation(reduceMotion ? nil : .easeOut(duration: 0.2)) {
                        whyVisible.toggle()
                    }
                }
                if !isExample {
                    TertiaryActionButton(title: "Save and return later", action: controller.goNow)
                }
            }
            if whyVisible {
                DottedTrace()
                EvidenceCard(label: "Source words", text: controller.state.evidence)
                    .transition(.opacity)
            }
            if isExample {
                Text("The example is discarded after you start. It never enters your history.")
                    .foregroundStyle(.secondary)
            }
        }
    }
}

struct StartedScreen: View {
    @ObservedObject var controller: RestartThreadController

    var body: some View {
        VStack(alignment: .leading, spacing: 24) {
            StatusPill(text: "Restart started")
            PageIntro(
                eyebrow: "Progress you can verify",
                title: "You moved it forward.",
                bodyText: "This restart is tied to the step you chose—not just an app open."
            )
            FocusCard(label: "Started step", text: controller.state.action)
            VStack(spacing: 12) {
                PrimaryActionButton(title: "Back to Now", ink: true, action: controller.finishStarted)
                SecondaryActionButton(title: "Leave a new stopping point", action: controller.leaveNewStoppingPoint)
                TertiaryActionButton(title: "Mark thread complete", action: controller.markCurrentComplete)
                TertiaryActionButton(title: "Archive thread", action: controller.archiveCurrent)
            }
        }
    }
}

struct AccountOfferScreen: View {
    @ObservedObject var model: RestartThreadAppModel
    @ObservedObject private var controller: RestartThreadController
    @ObservedObject private var auth: AuthSession

    init(model: RestartThreadAppModel) {
        self.model = model
        controller = model.controller
        auth = model.auth
    }

    var body: some View {
        VStack(alignment: .leading, spacing: 24) {
            PageIntro(
                eyebrow: "Optional account",
                title: "Keep Pro and cloud access with you.",
                bodyText: "An account links Pro, cloud allowance, web purchases, and future referrals. Thread text and audio remain on this device."
            )
            ContentCard {
                BenefitLine("Use the same Pro entitlement after sign-in.")
                BenefitLine("Keep local threads separate from account data.")
                BenefitLine("Continue without an account at any time.")
            }
            if auth.state.isAuthenticated {
                FocusCard(label: "Signed in", text: auth.state.displayName ?? "Your account is connected.")
                PrimaryActionButton(title: "Continue to Now", action: controller.completeAccountStep)
            } else {
                VStack(spacing: 12) {
                    PrimaryActionButton(
                        title: auth.state.isLoading ? "Opening secure sign-in…" : "Create or sign in",
                        action: model.signIn
                    )
                    SecondaryActionButton(title: "Continue without an account", action: controller.completeAccountStep)
                }
            }
            if !auth.state.isConfigured {
                PrivacyNote("Sign-in is not configured yet. Local use is available now.")
            }
            if let message = auth.state.message { Text(message).foregroundStyle(.secondary) }
        }
    }
}

private struct BenefitLine: View {
    let text: String
    init(_ text: String) { self.text = text }
    var body: some View {
        HStack(alignment: .firstTextBaseline, spacing: 12) {
            Circle().fill(.tint).frame(width: 8, height: 8)
            Text(text)
        }
    }
}

struct NowScreen: View {
    @ObservedObject var controller: RestartThreadController
    let openSettings: () -> Void

    var body: some View {
        VStack(alignment: .leading, spacing: 24) {
            PageIntro(
                eyebrow: "Your current place",
                title: "Now",
                bodyText: "Return to one thread or leave a clear stopping point for later."
            )
            #if os(macOS)
            HStack(alignment: .top, spacing: 24) {
                currentSection.frame(maxWidth: .infinity, alignment: .top)
                recentSection.frame(maxWidth: .infinity, alignment: .top)
            }
            #else
            currentSection
            recentSection
            #endif
            VStack(spacing: 12) {
                SecondaryActionButton(title: "View all threads", action: controller.showAllThreads)
                TertiaryActionButton(title: "Open settings", action: openSettings)
            }
        }
    }

    @ViewBuilder private var currentSection: some View {
        if let current = controller.state.currentThread {
            VStack(spacing: 12) {
                ReturnCard(thread: current) { controller.openThread(id: current.id) }
                SecondaryActionButton(title: "Update stopping point", action: controller.leaveNewStoppingPoint)
            }
        } else {
            EmptyStateCard(
                title: "Nothing is waiting here",
                bodyText: "Leave where you are so one clear step is ready when you return.",
                actionTitle: "Leave a thread",
                action: controller.startNewThread
            )
        }
    }

    @ViewBuilder private var recentSection: some View {
        let currentID = controller.state.currentThread?.id
        let recents = controller.state.threads
            .filter { $0.status != .deleted && $0.id != currentID }
            .prefix(3)
        if !recents.isEmpty {
            VStack(alignment: .leading, spacing: 12) {
                Text("Recent threads").font(.title3.weight(.semibold)).accessibilityAddTraits(.isHeader)
                ThreadListCard(threads: Array(recents), onOpen: controller.openThread)
            }
        }
    }
}

private struct ReturnCard: View {
    let thread: RecoveryThread
    let onOpen: () -> Void

    var body: some View {
        VStack(alignment: .leading, spacing: 16) {
            Eyebrow("Return to thread")
            Text(thread.capturedText).foregroundStyle(.secondary).textSelection(.enabled)
            Divider()
            Text(thread.proposedAction).font(.title3.weight(.semibold))
            Button("Return to thread", action: onOpen)
                .buttonStyle(.borderedProminent)
                .controlSize(.large)
                .frame(maxWidth: .infinity)
        }
        .padding(22)
        .foregroundStyle(.primary)
        .background(.regularMaterial, in: RoundedRectangle(cornerRadius: 22, style: .continuous))
    }
}
