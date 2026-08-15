package com.app.orientalinsurance.ui.login.models

import kotlinx.serialization.Serializable

@Serializable
data class RequestResetPassword(
    val newPassword: String,
    val confirmPassword: String,
    val transactionId: String
)