package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class RequestProposalAdditionalDetails(
    var age: JsonElement? = null,
    var agentBrokerType: JsonElement? = null,
    var airlinesCompany: String,
    var countryOfVisit: String,
    var dateOfBirth: String,
    var dateOfTravel: String?,
    var desCityCode: String,
    var desStateCode: String,
    var destinationCity: String,
    var destinationState: String,
    var disabled: String,
    var endDate: String,
    var flightNo: String,
    var gender: String,
    var identificationNo: String,
    var identityProof: String,
    var memberDetails: List<JsonElement> = emptyList(),
    var memberDetailsFlag: JsonElement? = null,
    var members: List<JsonElement> = emptyList(),
    var nationality: String,
    var originCity: String,
    var originCityCode: String,
    var originState: String,
    var originStateCode: String,
    var physicalDisabilityEx: JsonElement? = null,
    var proposalMainResponse: JsonElement? = null,
    var proposerOccupation: String,
    var proposerPassportNo: String,
    var proposerPedStatus: String,
    var proposerWinterSports: String,
    var purposeOfVisit: String,
    var sourceType: JsonElement? = null,
    var startDate: String,
    var visitingSchengenCountries: JsonElement? = null,
    var wheelChair: String
)