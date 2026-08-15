package com.app.orientalinsurance.ui.login.models

import kotlinx.serialization.Serializable

@Serializable
data class CustomerOtpResponse(
    val emailTransactionId: String,
    val mobileTransactionId: String ,
    val emailId: String,
    val mobileNum: String
)