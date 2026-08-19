import RestartThreadApple
import SwiftUI

@main
struct RestartThreadIOSApp: App {
    @StateObject private var model = RestartThreadAppModel()

    var body: some Scene {
        WindowGroup {
            RestartThreadRootView(model: model)
        }
    }
}
