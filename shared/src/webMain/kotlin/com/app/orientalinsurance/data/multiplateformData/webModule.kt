package com.app.orientalinsurance.data.multiplateformData

import com.app.orientalinsurance.data.multiplateformData.SettingsManager
import com.russhwolf.settings.Settings
import com.russhwolf.settings.StorageSettings
import kotlinx.browser.window
import org.koin.dsl.module

val webModule = module {

    single<Settings> {
        StorageSettings(window.localStorage)
    }

    single {
        SettingsManager(get())
    }
}