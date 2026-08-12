package com.app.orientalinsurance.data.cripto

import kotlinx.serialization.json.Json

object EncryptionUtil {

    //Use of val encryptedRequest = EncryptionUtil.callEncryption(loginRequest)

    @PublishedApi
    internal val json = Json {
        ignoreUnknownKeys = true
    }


    inline fun <reified T> callEncryption(
        requestData: T
    ): String {

        val jsonString = json.encodeToString(requestData)

        return CryptoAES.encrypt(
            CryptoConstants.KEY,
            jsonString
        )
    }
}