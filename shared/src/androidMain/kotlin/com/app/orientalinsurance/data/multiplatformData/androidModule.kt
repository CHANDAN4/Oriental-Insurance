package com.app.orientalinsurance.data.multiplatformData

import android.content.Context
import com.app.orientalinsurance.data.multiplateformData.SettingsManager
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.dsl.module

val androidModule = module {

    single<Settings> {
        SharedPreferencesSettings(
            get<Context>().getSharedPreferences(
                "app_pref",
                Context.MODE_PRIVATE
            )
        )
    }

    single {
        SettingsManager(get())
    }
}