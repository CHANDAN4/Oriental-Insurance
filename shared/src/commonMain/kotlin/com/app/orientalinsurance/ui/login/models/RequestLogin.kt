package com.app.orientalinsurance.ui.login.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestLogin(
    @SerialName("payload")
    val payload: String
)