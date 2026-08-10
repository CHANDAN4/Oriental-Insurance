import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        initKoinForIOS()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}