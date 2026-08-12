package com.app.orientalinsurance.ui.login.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestLoginWithUserIdRequestModel(

    @SerialName("userName")
    val userName: String,

    @SerialName("password")
    val password: String

    // @SerialName("payload")
    // val payload: String? = null
)