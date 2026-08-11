
package com.app.orientalinsurance.koin

import com.app.orientalinsurance.data.multiplateformData.iosModule

fun initKoinForIOS() {

    initKoin(
        platformModules = listOf(
            iosModule
        )
    )
}
