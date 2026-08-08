// commonMain
package com.app.orientalinsurance.koin

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(
    platformModules: List<Module> = emptyList()
) {

    startKoin {
        modules(appModule + platformModules)
    }
}