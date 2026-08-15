package com.app.orientalinsurance.ui.login.models

import kotlinx.serialization.Serializable

@Serializable
data class ResponseResetPassword(
    var errorCode: String?="",
    val errorId: String?="",
    val errors: List<InnerErrorModel>?= emptyList(),
    val message: String?="",
    val status: String?="",
)