package com.app.orientalinsurance.ui.login.models

import kotlinx.serialization.Serializable

@Serializable
data class RequestVerifySignupOtp(
    val emailOtp: String,
    val emailTransactionId: String,
    val mobileOtp: String,
    val mobileTransactionId: String
)