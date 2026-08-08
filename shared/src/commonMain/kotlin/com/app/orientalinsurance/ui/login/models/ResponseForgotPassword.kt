package com.app.orientalinsurance.ui.login.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseForgotPassword(
    @SerialName("communicationConsent")
    val communicationConsent: Boolean,
    @SerialName("mobileNumOrEmailId")
    val mobileNumOrEmailId: String,
    @SerialName("transactionId")
    val transactionId: String
)