import SwiftUI
import shared
import OrientalInsurance

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
