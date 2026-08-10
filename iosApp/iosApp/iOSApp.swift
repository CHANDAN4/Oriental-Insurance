import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        initKoinForIOSKt.initKoinForIOS()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
