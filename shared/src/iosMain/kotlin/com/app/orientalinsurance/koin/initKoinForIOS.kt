
package com.app.orientalinsurance.koin

import com.app.orientalinsurance.data.multiplateformData.iosModule
@OptIn(ExperimentalObjCName::class)
@ObjCName("initKoinForIOS")
fun initKoinForIOS() {

    initKoin(
        platformModules = listOf(
            iosModule
        )
    )
}
