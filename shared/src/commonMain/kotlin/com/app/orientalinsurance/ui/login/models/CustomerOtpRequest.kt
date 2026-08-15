package com.app.orientalinsurance.ui.login.models

import kotlinx.serialization.Serializable

@Serializable
data class CustomerOtpRequest(
    val emailId: String,
    val mobileNumber: String
)