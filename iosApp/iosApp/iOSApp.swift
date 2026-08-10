import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
       KoinKt.initKoinForIOS()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
