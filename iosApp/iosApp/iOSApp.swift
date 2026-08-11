import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
       InitKoinForIOSKt.initKoinForIOS()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
