import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        KoinInitializer().initialize()
        //InitKoinForIOSKt.initKoinForIOS()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}