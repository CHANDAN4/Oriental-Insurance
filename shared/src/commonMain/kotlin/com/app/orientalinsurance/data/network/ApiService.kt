package com.app.orientalinsurance.data.network

import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.ResponseAdditionalDetails
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.ResponseBasicDetails
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.ResponseChooseOffice
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.ResponseCreateFlight
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.ResponseSaveData
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.ResponseTravelQuote
import com.app.orientalinsurance.ui.login.models.RequestLogin
import com.app.orientalinsurance.ui.login.models.ResponseForgotPassword
import com.app.orientalinsurance.ui.login.models.ResponseLogin
import com.app.orientalinsurance.ui.login.models.ResponseSignUp
import com.app.orientalinsurance.ui.login.models.ResponseVerifyOtp
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class ApiService( private val client: HttpClient) {


    suspend fun toLogin(request: RequestLogin): ResponseLogin {

        return client.post(ApiRoute.LOGIN) {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()

    }

    suspend fun toSignup(request: RequestLogin): ResponseSignUp {

        return client.post(ApiRoute.SIGN_UP) {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()

    }


    suspend fun toForgotPassword(request: RequestLogin): ResponseForgotPassword {

        return client.post(ApiRoute.FORGOT_PASSWORD) {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()

    }


    suspend fun toVerifyOtp(request: RequestLogin): ResponseVerifyOtp {

        return client.post(ApiRoute.VERIFY_OTP) {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()

    }

    suspend fun basicDetails(request: RequestLogin): ResponseBasicDetails {

        return client.put(ApiRoute.BASIC_DETAILS) {
            contentType(ContentType.Application.Json)
            header("product", "FLIGHT")
            setBody(request)
        }.body()

    }

    suspend fun travelQuote(request: RequestLogin, id: String?): ResponseTravelQuote {

        return client.patch(ApiRoute.TRAVEL_QUOTE+"/$id") {
            contentType(ContentType.Application.Json)
            header("product", "FLIGHT")
            setBody(request)
        }.body()

    }

    suspend fun branchOffice(request: RequestLogin): ResponseChooseOffice {

        return client.post(ApiRoute.BRANCH_OFFICE) {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()

    }

    suspend fun create(request: RequestLogin, id: String?): ResponseCreateFlight {

        return client.patch(ApiRoute.CREATE_FLIGHT+"/$id") {
            contentType(ContentType.Application.Json)
            header("product", "FLIGHT")
            setBody(request)
        }.body()

    }


    suspend fun saveData(request: RequestLogin, id: String?): ResponseSaveData {

        return client.patch(ApiRoute.SAVE_DATA+"/$id") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()

    }

    suspend fun additionalDetails(request: RequestLogin, id: String?): ResponseAdditionalDetails {

        return client.patch(ApiRoute.ADDITIONAL_DETAILS+"/$id") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()

    }



}