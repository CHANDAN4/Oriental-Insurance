package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable


data class Content(
    @SerialName("address")
    val address: String,
    @SerialName("branchGstNumber")
    val branchGstNumber: String,
    @SerialName("branchPhoneNumber")
    val branchPhoneNumber: String,
    @SerialName("Code")
    val code: String,
    @SerialName("Description")
    val description: String,
    @SerialName("officeCity")
    val officeCity: String,
    @SerialName("officeEmail")
    val officeEmail: String,
    @SerialName("stateCode")
    val stateCode: String
)