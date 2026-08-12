package com.app.orientalinsurance.ui.login.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestCustomerCheckEmailMobile(
    @SerialName("emailId")
    val emailId: String,

    @SerialName("mobileNumber")
    val mobileNumber: String
)