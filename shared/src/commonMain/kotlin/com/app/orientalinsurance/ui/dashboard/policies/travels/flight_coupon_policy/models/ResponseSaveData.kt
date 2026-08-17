package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSaveData(
    @SerialName("addressOfPhysician")
    val addressOfPhysician: String?=null,
    @SerialName("age")
    val age: String?=null,
    @SerialName("ageInMonths")
    val ageInMonths: String?=null,
    @SerialName("ageInYears")
    val ageInYears: String?=null,
    @SerialName("airlinesCompany")
    val airlinesCompany: String?=null,
    @SerialName("basicPremium")
    val basicPremium: Double? = null,
    @SerialName("branchAddress")
    val branchAddress: String? = null,
    @SerialName("branchEmail")
    val branchEmail: String? = null,
    @SerialName("branchOffice")
    val branchOffice: String? = null,
    @SerialName("direct")
    val direct: Boolean? = null,
    @SerialName("branchCode")
    val branchCode: String?=null,
    @SerialName("branchOfficeId")
    val branchOfficeId: String?=null,
    @SerialName("branchState")
    val branchState: String?=null,
    @SerialName("category")
    val category: String?=null,
    @SerialName("city")
    val city: String?=null,
    @SerialName("countryOfVisit")
    val countryOfVisit: String?=null,
    @SerialName("createdBy")
    val createdBy: String?=null,
    @SerialName("createdDate")
    val createdDate: String?=null,
    @SerialName("createdFor")
    val createdFor: String?=null,
    @SerialName("dateOfBirth")
    val dateOfBirth: String?=null,
    @SerialName("dateOfMedicalReport")
    val dateOfMedicalReport: String?=null,
    @SerialName("dateOfTravel")
    val dateOfTravel: String,
    @SerialName("desCityCode")
    val desCityCode: String?=null,
    @SerialName("desStateCode")
    val desStateCode: String?=null,
    @SerialName("destinationCity")
    val destinationCity: String?=null,
    @SerialName("destinationState")
    val destinationState: String?=null,
    @SerialName("digitalDiscount")
    val digitalDiscount: String?=null,
    @SerialName("disabled")
    val disabled: String?=null,
    @SerialName("discount")
    val discount: String?=null,
    @SerialName("endDate")
    val endDate: String?=null,
    @SerialName("familyDetails")
    val familyDetails: String?=null,
    @SerialName("finalPremium")
    val finalPremium: Double?=null,
    @SerialName("flightFrom")
    val flightFrom: String?=null,
    @SerialName("flightNo")
    val flightNo: String?=null,
    @SerialName("flightTo")
    val flightTo: String,
    @SerialName("gender")
    val gender: String?=null,
    @SerialName("gst")
    val gst: Double?=null,
    @SerialName("handicappedStatus")
    val handicappedStatus: String?=null,
    @SerialName("id")
    val id: String,
    @SerialName("identificationNo")
    val identificationNo: String?=null,
    @SerialName("identityProof")
    val identityProof: String?=null,
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
    @SerialName("memberFlag")
    val memberFlag: Boolean,
    @SerialName("members")
    val members: String?=null,
    @SerialName("minimumPremiumApportionment")
    val minimumPremiumApportionment: Double,
    @SerialName("modeOfTravel")
    val modeOfTravel: String?=null,
    @SerialName("nationality")
    val nationality: String?=null,
    @SerialName("noOfDays")
    val noOfDays: Int,
    @SerialName("noOfPersons")
    val noOfPersons: Int,
    @SerialName("ompSrNo")
    val ompSrNo: String?=null,
    @SerialName("originCity")
    val originCity: String?=null,
    @SerialName("originCityCode")
    val originCityCode: String?=null,
    @SerialName("originState")
    val originState: String?=null,
    @SerialName("originStateCode")
    val originStateCode: String?=null,
    @SerialName("paymentStatus")
    val paymentStatus: String?=null,
    @SerialName("physicalDisabilityEx")
    val physicalDisabilityEx: String?=null,
    @SerialName("physicianName")
    val physicianName: String?=null,
    @SerialName("planCategory")
    val planCategory: String?=null,
    @SerialName("planType")
    val planType: String?=null,
    @SerialName("policyEndDate")
    val policyEndDate: String?=null,
    @SerialName("policyType")
    val policyType: String,
    @SerialName("portalDiscount")
    val portalDiscount: String?=null,
    @SerialName("premiumWithOutGst")
    val premiumWithOutGst: Double,
    @SerialName("product")
    val product: String,
    @SerialName("proposalId")
    val proposalId: Int,
    @SerialName("proposalMainResponse")
    val proposalMainResponse: String?=null,
    @SerialName("proposalNumber")
    val proposalNumber: String?=null,
    @SerialName("proposerName")
    val proposerName: String?=null,
    @SerialName("proposerOccupation")
    val proposerOccupation: String?=null,
    @SerialName("proposerPassportNo")
    val proposerPassportNo: String?=null,
    @SerialName("proposerPedStatus")
    val proposerPedStatus: String?=null,
    @SerialName("proposerWinterSports")
    val proposerWinterSports: String?=null,
    @SerialName("purposeOfVisit")
    val purposeOfVisit: String?=null,
    @SerialName("relationshipWithProposer")
    val relationshipWithProposer: String?=null,
    @SerialName("role")
    val role: String?=null,
    @SerialName("s3Url")
    val s3Url: String?=null,
    @SerialName("sourceCode")
    val sourceCode: String?=null,
    @SerialName("sourceType")
    val sourceType: String?=null,
    @SerialName("spDetailsResponse")
    val spDetailsResponse: String?=null,
    @SerialName("stampDuty")
    val stampDuty: String?=null,
    @SerialName("stamppDuty")
    val stamppDuty: String,
    @SerialName("startDate")
    val startDate: String?=null,
    @SerialName("state")
    val state: String?=null,
    @SerialName("sumInsured")
    val sumInsured: Double,
    @SerialName("totalBasicPremium")
    val totalBasicPremium: Double,
    @SerialName("totalFinalPremium")
    val totalFinalPremium: Double,
    @SerialName("totalSumInsured")
    val totalSumInsured: Double,
    @SerialName("totalUwDiscount")
    val totalUwDiscount: Double,
    @SerialName("transactionId")
    val transactionId: String?=null,
    @SerialName("tripDuration")
    val tripDuration: String?=null,
    @SerialName("tripType")
    val tripType: String?=null,
    @SerialName("uwDiscount")
    val uwDiscount: Double,
    @SerialName("visitingSchengenCountries")
    val visitingSchengenCountries: String?=null,
    @SerialName("wheelChair")
    val wheelChair: String?=null
)