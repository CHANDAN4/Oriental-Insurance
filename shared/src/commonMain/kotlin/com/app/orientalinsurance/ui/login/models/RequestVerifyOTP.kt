package com.app.orientalinsurance.ui.login.models

import kotlinx.serialization.Serializable

@Serializable
data class RequestVerifyOTP(
    val otp: String,
    val transactionId: String
)