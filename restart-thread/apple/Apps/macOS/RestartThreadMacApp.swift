import AppKit
import RestartThreadApple
import SwiftUI

@main
struct RestartThreadMacApp: App {
    @NSApplicationDelegateAdaptor(AppDelegate.self) private var appDelegate
    @StateObject private var model = RestartThreadAppModel()

    var body: some Scene {
        WindowGroup("Restart Thread") {
            RestartThreadRootView(model: model)
                .frame(minWidth: 760, minHeight: 680)
        }
        .commands {
            CommandGroup(replacing: .newItem) {
                Button("Leave New Thread") { model.controller.startNewThread() }
                    .keyboardShortcut("n", modifiers: .command)
            }
            CommandMenu("Thread") {
                Button("Show Now") { model.controller.goNow() }
                    .keyboardShortcut("1", modifiers: .command)
                Button("Show All Threads") { model.controller.showAllThreads() }
                    .keyboardShortcut("t", modifiers: [.command, .shift])
            }
        }

        Settings {
            RestartThreadSettingsView(model: model)
        }
    }
}

final class AppDelegate: NSObject, NSApplicationDelegate {
    func applicationDidFinishLaunching(_ notification: Notification) {
        NSApp.setActivationPolicy(.regular)
        NSApp.activate(ignoringOtherApps: true)
    }
}
