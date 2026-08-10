package com.app.orientalinsurance.application

import android.app.Application
import com.app.orientalinsurance.data.multiplatformData.androidModule
import com.app.orientalinsurance.koin.appModule
import com.app.orientalinsurance.koin.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application(){

    override fun onCreate() {
        super.onCreate()

        initKoin(listOf(androidModule))
        /*startKoin {
            androidContext(this@App)
            modules(appModule,androidModule)

        }*/

    }

}