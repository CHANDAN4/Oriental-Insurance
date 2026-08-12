package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models

import kotlinx.serialization.Serializable

@Serializable
data class RequestProposalCreate(
    val branchAddress: String,
    val branchEmail: String,
    val branchOffice: String,
    val branchOfficeId: String,
    val branchState: String,
    val officeCity: String,
    val saveProposalFlag: Boolean
)