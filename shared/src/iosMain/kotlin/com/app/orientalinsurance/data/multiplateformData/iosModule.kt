
package com.app.orientalinsurance.data.multiplateformData

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import org.koin.dsl.module

val iosModule = module {

    single<Settings> {
        NSUserDefaultsSettings.Factory().create("app_pref")
    }

    single {
        SettingsManager(get())
    }
}