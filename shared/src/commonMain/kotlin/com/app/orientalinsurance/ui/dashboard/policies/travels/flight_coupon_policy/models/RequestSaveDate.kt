package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models

import kotlinx.serialization.Serializable

@Serializable
data class RequestSaveDate(
    val dateOfTravel: String
)