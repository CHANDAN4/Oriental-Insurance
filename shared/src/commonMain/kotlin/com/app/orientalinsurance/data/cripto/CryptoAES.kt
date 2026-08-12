package com.app.orientalinsurance.data.cripto

expect object CryptoAES {

    fun encrypt(
        password: String,
        plainText: String
    ): String

    fun decrypt(
        password: String,
        cipherText: String
    ): String
}