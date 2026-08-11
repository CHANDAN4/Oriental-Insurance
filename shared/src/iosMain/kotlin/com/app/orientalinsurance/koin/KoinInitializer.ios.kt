package com.app.orientalinsurance.koin

import com.app.orientalinsurance.data.multiplateformData.iosModule

actual class KoinInitializer {
    actual fun initialize() {
        initKoin(
            platformModules = listOf(iosModule)
        )
    }
}