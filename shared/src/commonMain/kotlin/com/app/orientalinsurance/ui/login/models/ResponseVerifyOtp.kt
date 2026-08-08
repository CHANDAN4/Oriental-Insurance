package com.app.orientalinsurance.ui.login.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseVerifyOtp(
    @SerialName("communicationConsent")
    val communicationConsent: Boolean?=null,
    @SerialName("customerNumber")
    val customerNumber: String?=null,
    @SerialName("emailId")
    val emailId: String?=null,
    @SerialName("firstName")
    val firstName: String?=null,
    @SerialName("ipAddress")
    val ipAddress: String?=null,
    @SerialName("lastLoggedInDateTime")
    val lastLoggedInDateTime: String?=null,
    @SerialName("lastName")
    val lastName: String?=null,
    @SerialName("loggedInTime")
    val loggedInTime: String?=null,
    @SerialName("mobileNumber")
    val mobileNumber: String?=null,
    @SerialName("noOfAttemptsLeft")
    val noOfAttemptsLeft: String?=null,
    @SerialName("parentUserName")
    val parentUserName: String?=null,
    @SerialName("roleDescription")
    val roleDescription: String?=null,
    @SerialName("roles")
    val roles: String?=null,
    @SerialName("sessionId")
    val sessionId: String?=null,
    @SerialName("spUserName")
    val spUserName: String?=null,
    @SerialName("token")
    val token: String?=null,
    @SerialName("userName")
    val userName: String?=null
)