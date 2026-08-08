package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pageable(
    @SerialName("offset")
    val offset: Int,
    @SerialName("pageNumber")
    val pageNumber: Int,
    @SerialName("pageSize")
    val pageSize: Int,
    @SerialName("paged")
    val paged: Boolean,
    @SerialName("sort")
    val sort: SortX,
    @SerialName("unpaged")
    val unpaged: Boolean
)