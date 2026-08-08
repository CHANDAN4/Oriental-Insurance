package com.app.orientalinsurance

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.app.orientalinsurance.data.multiplateformData.webModule
import com.app.orientalinsurance.koin.appModule
import org.koin.core.context.startKoin


@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    startKoin {
        modules(
            appModule,
            webModule
        )
    }

    ComposeViewport {
        App()
    }

}