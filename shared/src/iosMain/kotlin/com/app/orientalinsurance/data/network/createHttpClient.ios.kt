package com.app.orientalinsurance.data.network

import com.app.orientalinsurance.data.multiplateformData.SettingsManager
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
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

actual fun createHttpClient(settingsManager: SettingsManager) = HttpClient(Darwin) {

    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true
                isLenient = true
                explicitNulls = false
            }
        )
    }

    install(Logging) {
        logger = Logger.DEFAULT
        level = LogLevel.ALL
    }

    defaultRequest {
        url("https://y4132nnj76.execute-api.ap-south-1.amazonaws.com/pre-prod/api/v1/")
        contentType(ContentType.Application.Json)
        header(HttpHeaders.Accept, "application/json")
        header("Accept-Language", "en-US")
        header("X-SOURCE", "IOS")
        header(
            "Authorization",
            "Bearer ${settingsManager.getToken()}"
        )
    }


}
