package com.app.orientalinsurance.data.network

import com.app.orientalinsurance.data.multiplateformData.SettingsManager
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.CertificatePinner
import java.util.concurrent.TimeUnit


actual fun createHttpClient(settingsManager: SettingsManager) = HttpClient(OkHttp) {

    engine {
        config {

            connectTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)

            val certificatePinner = CertificatePinner.Builder()
                .add(
                    "api.orientalinsurance.org.in",
                    "sha256/DxH4tt40L+eduF6szpY6TONlxhZhBd+pJ9wbHlQ2fuw="
                )
                .build()

            certificatePinner(certificatePinner)
        }
    }

    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
                encodeDefaults = true
            }
        )
    }

    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.BODY
    }

    defaultRequest {
        url(ApiRoute.BASE_URL)
        contentType(ContentType.Application.Json)
        header(HttpHeaders.Accept, "application/json")
        header("Accept-Language", "en-US")
        header("X-SOURCE", "ANDROID")
        header(
            "Authorization",
            "Bearer ${settingsManager.getToken()}"
        )
    }

}

