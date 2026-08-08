package com.app.orientalinsurance.ui.login.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSignUp(
    @SerialName("message")
    val message: String,
    @SerialName("status")
    val status: Boolean
)