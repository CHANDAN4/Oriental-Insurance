package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseBasicDetails(
    @SerialName("airlinesCompany")
    val airlinesCompany: String?=null,
    @SerialName("basicPremium")
    val basicPremium: Double,
    @SerialName("branchAddress")
    val branchAddress: String?=null,
    @SerialName("branchCode")
    val branchCode: String?=null,
    @SerialName("branchEmail")
    val branchEmail: String?=null,
    @SerialName("branchOffice")
    val branchOffice: String?=null,
    @SerialName("branchOfficeId")
    val branchOfficeId: String?=null,
    @SerialName("branchState")
    val branchState: String?=null,
    @SerialName("category")
    val category: String,
    @SerialName("city")
    val city: String?=null,
    @SerialName("createdBy")
    val createdBy: String,
    @SerialName("createdDate")
    val createdDate: String,
    @SerialName("createdFor")
    val createdFor: String?=null,
    @SerialName("dateOfTravel")
    val dateOfTravel: String?=null,
    @SerialName("direct")
    val direct: Boolean,
    @SerialName("disabled")
    val disabled: String?=null,
    @SerialName("finalPremium")
    val finalPremium: Double,
    @SerialName("flightFrom")
    val flightFrom: String,
    @SerialName("flightNo")
    val flightNo: String?=null,
    @SerialName("flightTo")
    val flightTo: String,
    @SerialName("gst")
    val gst: Double,
    @SerialName("id")
    val id: String,
    @SerialName("intermediary")
    val intermediary: Boolean,
    @SerialName("intermediaryId")
    val intermediaryId: String?=null,
    @SerialName("intermediaryName")
    val intermediaryName: String?=null,
    @SerialName("kycFlag")
    val kycFlag: Boolean,
    @SerialName("lastUpdatedBy")
    val lastUpdatedBy: String?=null,
    @SerialName("lastUpdatedDate")
    val lastUpdatedDate: String?=null,
    @SerialName("minimumPremiumApportionment")
    val minimumPremiumApportionment: Double,
    @SerialName("paymentStatus")
    val paymentStatus: String?=null,
    @SerialName("policyEndDate")
    val policyEndDate: String?=null,
    @SerialName("policyType")
    val policyType: String,
    @SerialName("product")
    val product: String,
    @SerialName("proposalId")
    val proposalId: Int,
    @SerialName("proposalNumber")
    val proposalNumber: String?=null,
    @SerialName("role")
    val role: String,
    @SerialName("sourceCode")
    val sourceCode: String?=null,
    @SerialName("sourceType")
    val sourceType: String?=null,
    @SerialName("stampDuty")
    val stampDuty: String?=null,
    @SerialName("state")
    val state: String?=null,
    @SerialName("sumInsured")
    val sumInsured: Double,
    @SerialName("transactionId")
    val transactionId: String?=null,
    @SerialName("uwDiscount")
    val uwDiscount: Double,
    @SerialName("wheelChair")
    val wheelChair: String?=null
)