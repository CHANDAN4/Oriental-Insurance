import SwiftUI
import shared

@main
struct iOSApp: App {

    init() {
        KoinKt.initKoin(platformModules: [IosModuleKt.iosModule])
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}