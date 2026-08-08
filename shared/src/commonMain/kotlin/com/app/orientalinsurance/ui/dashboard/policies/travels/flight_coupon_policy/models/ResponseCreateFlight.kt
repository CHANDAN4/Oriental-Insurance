package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseCreateFlight(
    @SerialName("addressOfTheCompany")
    val addressOfTheCompany: String?=null,
    @SerialName("agentBrokerAddress")
    val agentBrokerAddress: String?=null,
    @SerialName("agentBrokerCode")
    val agentBrokerCode: String?=null,
    @SerialName("agentBrokerEmail")
    val agentBrokerEmail: String?=null,
    @SerialName("agentBrokerMobileNumber")
    val agentBrokerMobileNumber: String?=null,
    @SerialName("agentBrokerName")
    val agentBrokerName: String?=null,
    @SerialName("agentBrokerRole")
    val agentBrokerRole: String?=null,
    @SerialName("agentBrokerType")
    val agentBrokerType: String?=null,
    @SerialName("agentBrokerUser")
    val agentBrokerUser: String?=null,
    @SerialName("agentTelFaxEmail")
    val agentTelFaxEmail: String,
    @SerialName("approvalComments")
    val approvalComments: String?=null,
    @SerialName("approvalDate")
    val approvalDate: String?=null,
    @SerialName("approvalName")
    val approvalName: String?=null,
    @SerialName("approvalStatus")
    val approvalStatus: String,
    @SerialName("approveRejectStatus")
    val approveRejectStatus: String,
    @SerialName("bandhanBankFlag")
    val bandhanBankFlag: Boolean,
    @SerialName("bankId")
    val bankId: String?=null,
    @SerialName("branchAddress")
    val branchAddress: String,
    @SerialName("branchEmail")
    val branchEmail: String,
    @SerialName("branchGstNumber")
    val branchGstNumber: String,
    @SerialName("branchOffice")
    val branchOffice: String,
    @SerialName("branchOfficeId")
    val branchOfficeId: String,
    @SerialName("branchPhoneNumber")
    val branchPhoneNumber: String?=null,
    @SerialName("branchState")
    val branchState: String,
    @SerialName("businessType")
    val businessType: String?=null,
    @SerialName("category")
    val category: String,
    @SerialName("cgst")
    val cgst: Double,
    @SerialName("channelType")
    val channelType: String,
    @SerialName("city")
    val city: String?=null,
    @SerialName("cityId")
    val cityId: String?=null,
    @SerialName("classCode")
    val classCode: String?=null,
    @SerialName("createdBy")
    val createdBy: String,
    @SerialName("createdDate")
    val createdDate: String,
    @SerialName("createdFor")
    val createdFor: String?=null,
    @SerialName("currentAddress")
    val currentAddress: String?=null,
    @SerialName("currentCity")
    val currentCity: String?=null,
    @SerialName("currentCityId")
    val currentCityId: String?=null,
    @SerialName("currentPinCode")
    val currentPinCode: String?=null,
    @SerialName("currentState")
    val currentState: String?=null,
    @SerialName("currentStateId")
    val currentStateId: String?=null,
    @SerialName("custMailingAddress")
    val custMailingAddress: String?=null,
    @SerialName("custOffEmail")
    val custOffEmail: String?=null,
    @SerialName("custOffMobNumber")
    val custOffMobNumber: String?=null,
    @SerialName("customerAddress")
    val customerAddress: String?=null,
    @SerialName("customerCode")
    val customerCode: String?=null,
    @SerialName("customerNumber")
    val customerNumber: String,
    @SerialName("declarationFlag")
    val declarationFlag: Boolean,
    @SerialName("devOffCode")
    val devOffCode: String?=null,
    @SerialName("devOffName")
    val devOffName: String?=null,
    @SerialName("directIntermediary")
    val directIntermediary: String?=null,
    @SerialName("dob")
    val dob: String?=null,
    @SerialName("email")
    val email: String,
    @SerialName("employeeTelFaxEmail")
    val employeeTelFaxEmail: String,
    @SerialName("externalId")
    val externalId: String,
    @SerialName("form60FileName")
    val form60FileName: String?=null,
    @SerialName("form60GetUrl")
    val form60GetUrl: String?=null,
    @SerialName("fullName")
    val fullName: String?=null,
    @SerialName("gender")
    val gender: String?=null,
    @SerialName("gst")
    val gst: String?=null,
    @SerialName("gstNumber")
    val gstNumber: String?=null,
    @SerialName("hasEmail")
    val hasEmail: Boolean,
    @SerialName("hasMobile")
    val hasMobile: Boolean,
    @SerialName("hypothecationType")
    val hypothecationType: String?=null,
    @SerialName("id")
    val id: String,
    @SerialName("imtList")
    val imtList: String?=null,
    @SerialName("inspectionDateTime")
    val inspectionDateTime: String?=null,
    @SerialName("inspectionSuccessFlag")
    val inspectionSuccessFlag: String?=null,
    @SerialName("insuredCode")
    val insuredCode: String?=null,
    @SerialName("kycFlag")
    val kycFlag: Boolean,
    @SerialName("lastUpdatedBy")
    val lastUpdatedBy: String,
    @SerialName("lastUpdatedDate")
    val lastUpdatedDate: String,
    @SerialName("leadId")
    val leadId: String?=null,
    @SerialName("makerAccountNo")
    val makerAccountNo: String?=null,
    @SerialName("makerBankName")
    val makerBankName: String?=null,
    @SerialName("makerChecker")
    val makerChecker: Boolean,
    @SerialName("makerCheckerDescription")
    val makerCheckerDescription: String?=null,
    @SerialName("makerIfscCode")
    val makerIfscCode: String?=null,
    @SerialName("mobileNumber")
    val mobileNumber: String?=null,
    @SerialName("nameOfAccountHolder")
    val nameOfAccountHolder: String?=null,
    @SerialName("nameOftheCompany")
    val nameOftheCompany: String?=null,
    @SerialName("nomineeAccountNo")
    val nomineeAccountNo: String?=null,
    @SerialName("nomineeBankName")
    val nomineeBankName: String?=null,
    @SerialName("nomineeCurrentAddress")
    val nomineeCurrentAddress: String?=null,
    @SerialName("nomineeDob")
    val nomineeDob: String?=null,
    @SerialName("nomineeEmailId")
    val nomineeEmailId: String?=null,
    @SerialName("nomineeGender")
    val nomineeGender: String?=null,
    @SerialName("nomineeIfscCode")
    val nomineeIfscCode: String?=null,
    @SerialName("nomineeMobileNo")
    val nomineeMobileNo: String?=null,
    @SerialName("nomineeName")
    val nomineeName: String?=null,
    @SerialName("nomineePermanentAddress")
    val nomineePermanentAddress: String?=null,
    @SerialName("nomineeRelation")
    val nomineeRelation: String?=null,
    @SerialName("nomineeSamePermanentFlag")
    val nomineeSamePermanentFlag: Boolean,
    @SerialName("nomineeShare")
    val nomineeShare: String?=null,
    @SerialName("officeCity")
    val officeCity: String,
    @SerialName("officeEmail")
    val officeEmail: String,
    @SerialName("officeFax")
    val officeFax: String,
    @SerialName("officeTel")
    val officeTel: String,
    @SerialName("officeTelFaxEmail")
    val officeTelFaxEmail: String,
    @SerialName("otherStateFlag")
    val otherStateFlag: Boolean,
    @SerialName("panCard")
    val panCard: String,
    @SerialName("panCardFlag")
    val panCardFlag: Boolean,
    @SerialName("panCardHolderOrExemption")
    val panCardHolderOrExemption: String,
    @SerialName("panNumber")
    val panNumber: String?=null,
    @SerialName("parentId")
    val parentId: String,
    @SerialName("paymentMode")
    val paymentMode: String?=null,
    @SerialName("paymentStatus")
    val paymentStatus: String,
    @SerialName("permanentAddress")
    val permanentAddress: String?=null,
    @SerialName("pinCode")
    val pinCode: String?=null,
    @SerialName("planSelected")
    val planSelected: String?=null,
    @SerialName("policyCategory")
    val policyCategory: String,
    @SerialName("policyEndDate")
    val policyEndDate: String,
    @SerialName("policyNumber")
    val policyNumber: String?=null,
    @SerialName("policyStartDate")
    val policyStartDate: String,
    @SerialName("policyType")
    val policyType: String,
    @SerialName("premium")
    val premium: String,
    @SerialName("previousPolicyNumber")
    val previousPolicyNumber: String?=null,
    @SerialName("product")
    val product: String,
    @SerialName("productCode")
    val productCode: String,
    @SerialName("proposalApprovalStatus")
    val proposalApprovalStatus: String?=null,
    @SerialName("proposalId")
    val proposalId: Int,
    @SerialName("proposalNoOut")
    val proposalNoOut: String,
    @SerialName("proposalNumber")
    val proposalNumber: String,
    @SerialName("regionalOfficeAddress")
    val regionalOfficeAddress: String,
    @SerialName("role")
    val role: String,
    @SerialName("samePermanentFlag")
    val samePermanentFlag: Boolean,
    @SerialName("saveProposalFlag")
    val saveProposalFlag: Boolean,
    @SerialName("sentForApprovalDate")
    val sentForApprovalDate: String?=null,
    @SerialName("sgst")
    val sgst: Double,
    @SerialName("source")
    val source: String,
    @SerialName("sourceCode")
    val sourceCode: String?=null,
    @SerialName("sourceType")
    val sourceType: String?=null,
    @SerialName("spCode")
    val spCode: String,
    @SerialName("spEmail")
    val spEmail: String,
    @SerialName("spMobileNumber")
    val spMobileNumber: String,
    @SerialName("spName")
    val spName: String,
    @SerialName("state")
    val state: String?=null,
    @SerialName("stateId")
    val stateId: String?=null,
    @SerialName("status")
    val status: String,
    @SerialName("syncMessage")
    val syncMessage: String?=null,
    @SerialName("syncPayload")
    val syncPayload: String?=null,
    @SerialName("syncStatus")
    val syncStatus: String?=null,
    @SerialName("typeOfCommercialVehicle")
    val typeOfCommercialVehicle: String?=null,
    @SerialName("ucino")
    val ucino: String,
    @SerialName("userType")
    val userType: String,
    @SerialName("utFlag")
    val utFlag: Boolean,
    @SerialName("uwDiscountMaxPercentage")
    val uwDiscountMaxPercentage: String?=null,
    @SerialName("vehicleGvw")
    val vehicleGvw: String?=null,
    @SerialName("vehicleNumber")
    val vehicleNumber: String?=null
)