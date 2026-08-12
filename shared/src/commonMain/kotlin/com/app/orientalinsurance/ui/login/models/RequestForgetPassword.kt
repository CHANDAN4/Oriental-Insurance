package com.app.orientalinsurance.ui.login.models

import kotlinx.serialization.Serializable

@Serializable
data class RequestForgetPassword(
    val userName: String
)