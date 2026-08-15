package com.app.orientalinsurance.ui.login.models

import kotlinx.serialization.Serializable

@Serializable
data class InnerErrorModel(
    val `field`: String,
    val invalidValue: String,
    val message: String
)