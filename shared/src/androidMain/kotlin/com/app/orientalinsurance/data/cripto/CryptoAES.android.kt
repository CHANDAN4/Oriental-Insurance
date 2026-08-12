package com.app.orientalinsurance.data.cripto

import android.util.Base64
import java.security.MessageDigest
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

actual object CryptoAES {

    private const val KEY_SIZE = 256
    private const val IV_SIZE = 128
    private const val HASH_CIPHER = "AES/CBC/PKCS5Padding"
    private const val AES = "AES"
    private const val APPEND = "Salted__"

    actual fun encrypt(
        password: String,
        plainText: String
    ): String {

        val saltBytes = generateSalt(8)

        val key = ByteArray(KEY_SIZE / 8)
        val iv = ByteArray(IV_SIZE / 8)

        evpKDF(
            password.toByteArray(Charsets.UTF_8),
            saltBytes,
            key,
            iv
        )

        val keySpec = SecretKeySpec(key, AES)

        val cipher = Cipher.getInstance(HASH_CIPHER)

        cipher.init(
            Cipher.ENCRYPT_MODE,
            keySpec,
            IvParameterSpec(iv)
        )

        val cipherText = cipher.doFinal(
            plainText.toByteArray(Charsets.UTF_8)
        )

        val saltHeader = APPEND.toByteArray(Charsets.UTF_8)

        val result = ByteArray(
            saltHeader.size +
                    saltBytes.size +
                    cipherText.size
        )

        System.arraycopy(
            saltHeader,
            0,
            result,
            0,
            saltHeader.size
        )

        System.arraycopy(
            saltBytes,
            0,
            result,
            saltHeader.size,
            saltBytes.size
        )

        System.arraycopy(
            cipherText,
            0,
            result,
            saltHeader.size + saltBytes.size,
            cipherText.size
        )

        return Base64.encodeToString(
            result,
            Base64.NO_WRAP
        )
    }

    private fun generateSalt(size: Int): ByteArray {
        val salt = ByteArray(size)
        SecureRandom().nextBytes(salt)
        return salt
    }

    private fun evpKDF(
        password: ByteArray,
        salt: ByteArray,
        key: ByteArray,
        iv: ByteArray
    ) {

        val requiredLength = key.size + iv.size

        val derived = ByteArray(requiredLength)

        var generated = 0
        var previous = ByteArray(0)

        while (generated < requiredLength) {

            val digest = MessageDigest.getInstance("MD5")

            digest.update(previous)
            digest.update(password)
            digest.update(salt)

            previous = digest.digest()

            val copyLength = minOf(
                previous.size,
                requiredLength - generated
            )

            System.arraycopy(
                previous,
                0,
                derived,
                generated,
                copyLength
            )

            generated += copyLength
        }

        System.arraycopy(
            derived,
            0,
            key,
            0,
            key.size
        )

        System.arraycopy(
            derived,
            key.size,
            iv,
            0,
            iv.size
        )
    }

    actual fun decrypt(
        password: String,
        cipherText: String
    ): String {
        TODO("Implement decrypt")
    }
}