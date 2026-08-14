package com.app.orientalinsurance.data.cripto

//import platform.CommonCrypto.*

import io.ktor.util.encodeBase64
import kotlinx.cinterop.*
import platform.CoreCrypto.CCCrypt
import platform.CoreCrypto.CC_MD5
import platform.CoreCrypto.CC_MD5_DIGEST_LENGTH
import platform.CoreCrypto.kCCAlgorithmAES
import platform.CoreCrypto.kCCEncrypt
import platform.CoreCrypto.kCCSuccess
import platform.Security.*

actual object CryptoAES {

    private const val KEY_SIZE = 32       // AES-256 = 32 bytes
    private const val IV_SIZE = 16        // AES block size = 16 bytes
    private const val SALT_SIZE = 8

    private const val AES_BLOCK_SIZE = 16

    private const val APPEND = "Salted__"

    actual fun encrypt(
        password: String,
        plainText: String
    ): String {

        val salt = generateSalt(SALT_SIZE)

        val key = ByteArray(KEY_SIZE)
        val iv = ByteArray(IV_SIZE)

        evpKDF(
            password = password.encodeToByteArray(),
            salt = salt,
            key = key,
            iv = iv
        )

        val encrypted = aesEncrypt(
            plainText.encodeToByteArray(),
            key,
            iv
        )

        val result = ByteArray(
            APPEND.encodeToByteArray().size +
                    salt.size +
                    encrypted.size
        )

        var offset = 0

        val header = APPEND.encodeToByteArray()

        header.copyInto(
            destination = result,
            destinationOffset = offset
        )

        offset += header.size

        salt.copyInto(
            destination = result,
            destinationOffset = offset
        )

        offset += salt.size

        encrypted.copyInto(
            destination = result,
            destinationOffset = offset
        )

        return result.encodeBase64()
    }


    @OptIn(ExperimentalForeignApi::class)
    private fun generateSalt(size: Int): ByteArray {

        val salt = ByteArray(size)

        salt.usePinned { pinned ->
 
            val result = SecRandomCopyBytes(
                kSecRandomDefault,
                size.toULong(),
                pinned.addressOf(0)
            )

            check(result == 0)
        }

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

            val data = previous + password + salt

            val digest = md5(data)

            previous = digest

            val copyLength = minOf(
                digest.size,
                requiredLength - generated
            )

            digest.copyInto(
                destination = derived,
                destinationOffset = generated,
                startIndex = 0,
                endIndex = copyLength
            )

            generated += copyLength
        }

        derived.copyInto(
            destination = key,
            destinationOffset = 0,
            startIndex = 0,
            endIndex = key.size
        )

        derived.copyInto(
            destination = iv,
            destinationOffset = 0,
            startIndex = key.size,
            endIndex = key.size + iv.size
        )
    }

    @Suppress("DEPRECATION")
    @OptIn(ExperimentalForeignApi::class)
    private fun md5(data: ByteArray): ByteArray {
        val digest = ByteArray(CC_MD5_DIGEST_LENGTH.toInt())

        data.usePinned { input ->
            digest.usePinned { output ->
                CC_MD5(
                    input.addressOf(0),
                    data.size.toULong(),
                    output.addressOf(0)
                )
            }
        }

        return digest
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun aesEncrypt(
        data: ByteArray,
        key: ByteArray,
        iv: ByteArray
    ): ByteArray {

        // PKCS7 padding
        val paddingSize =
            AES_BLOCK_SIZE - (data.size % AES_BLOCK_SIZE)

        val padded = ByteArray(
            data.size + paddingSize
        )

        data.copyInto(padded)

        for (i in data.size until padded.size) {
            padded[i] = paddingSize.toByte()
        }

        val output = ByteArray(
            padded.size + AES_BLOCK_SIZE
        )

        var numBytesEncrypted = 0u

        val status = padded.usePinned { inputPinned ->
            key.usePinned { keyPinned ->
                iv.usePinned { ivPinned ->
                    output.usePinned { outputPinned ->

                        CCCrypt(
                            kCCEncrypt,
                            kCCAlgorithmAES,
                            0u, // CBC + PKCS7 handled manually
                            keyPinned.addressOf(0),
                            key.size.toULong(),
                            ivPinned.addressOf(0),
                            inputPinned.addressOf(0),
                            padded.size.toULong(),
                            outputPinned.addressOf(0),
                            output.size.toULong(),
                            cValues = null,
                            dataOutMoved = TODO()
                        )
                    }
                }
            }
        }

        check(status == kCCSuccess) {
            "AES encryption failed. Status: $status"
        }

        // This approach needs correct output-length handling.
        // Better implementation is below.
        return output.copyOf(padded.size)
    }

    actual fun decrypt(password: String, cipherText: String): String {
        TODO("Not yet implemented")
    }
}