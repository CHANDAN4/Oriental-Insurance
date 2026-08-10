package com.app.orientalinsurance.koin

import com.app.orientalinsurance.data.multiplateformData.iosModule
@file:JvmName("InitKoinForIOS")
fun initKoinForIOS() {

    initKoin(
        platformModules = listOf(
            iosModule
        )
    )
}
