package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class RequestBasicDetails(
    val age: String? = "OverseasDetails",
    val category: String? = "",
    val coverAmount: String? = "",
    val dateOfBirth: String? = "",
    val endDate: String? = "",
    val familyDetails: List<String> = emptyList(),
    val flightFrom: String? = "",
    val flightTo: String? = "",
    val gender: String? = "",
    val id: String? = "",
    val noOfPersons: Int? = 1,
    val planType: String? = "",
    val policyType: String? = "",
    val product: String? = "",
    val proposalId: String? = "",
    val proposalMainResponse: String? = null,
    val proposalNumber: String? = "",
    val startDate: String? = "",
    val sumInsured: String? = null,
    val tabNumber: String? = "",
    val travelMode: String? = "",
    val tripDuration: String? = "",
    val tripDurationInput: Int? = 0,
    val tripType: String? = "",
    val visitingSchengenCountries: String? = null
)