package com.app.orientalinsurance

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = "ios"//UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()