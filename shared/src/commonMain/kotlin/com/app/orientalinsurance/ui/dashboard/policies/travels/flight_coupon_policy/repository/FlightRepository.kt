package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.repository

import com.app.orientalinsurance.data.cripto.EncryptionUtil
import com.app.orientalinsurance.data.network.ApiService
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestBasicDetails
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestBranchOffice
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestProposalAdditionalDetails
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestProposalCreate
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestProposalQuote
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestSaveDate
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.ResponseAdditionalDetails
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.ResponseBasicDetails
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.ResponseChooseOffice
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.ResponseCreateFlight
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.ResponseSaveData
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.ResponseTravelQuote
import com.app.orientalinsurance.ui.login.models.RequestLogin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FlightRepository(private val apiService: ApiService) {


    fun basicDetails(req: RequestBasicDetails): Flow<ApiState<ResponseBasicDetails>> = flow {

        emit(ApiState.Loading)

        try {

            val encrypted = RequestLogin(EncryptionUtil.callEncryption(req))
            val response = apiService.basicDetails(encrypted)
            if (response != null) {
                //insertModeOfTransit(response)
                emit(ApiState.Success(response))
            } else {
                emit(ApiState.Empty)
            }

        } catch (e: Exception) {
            println("BasicDetailsError : ${e.message}")
            emit(ApiState.Error(e.message ?: "Unknown Error"))

        }

    }


    fun travelQuote(req: RequestProposalQuote, id: String?): Flow<ApiState<ResponseTravelQuote>> = flow {

            emit(ApiState.Loading)

            try {

                val encrypted = RequestLogin(EncryptionUtil.callEncryption(req))
                val response = apiService.travelQuote(encrypted, id)
                if (response != null) {
                    //insertModeOfTransit(response)
                    emit(ApiState.Success(response))
                } else {
                    emit(ApiState.Empty)
                }

            } catch (e: Exception) {
                print("Error : "+e.message)
                emit(ApiState.Error(e.message ?: "Unknown Error"))
            }

        }


    fun branchOffice(req: RequestBranchOffice): Flow<ApiState<ResponseChooseOffice>> = flow {

        emit(ApiState.Loading)

        try {

            val encrypted = RequestLogin(EncryptionUtil.callEncryption(req))
            val response = apiService.branchOffice(encrypted)
            if (response != null) {
                //insertModeOfTransit(response)
                emit(ApiState.Success(response))
            } else {
                emit(ApiState.Empty)
            }

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }


    fun create(req: RequestProposalCreate, id: String?): Flow<ApiState<ResponseCreateFlight>> =
        flow {

            emit(ApiState.Loading)

            try {

                val encrypted = RequestLogin(EncryptionUtil.callEncryption(req))
                val response = apiService.create(encrypted, id)
                emit(ApiState.Success(response))

            } catch (e: Exception) {
                emit(ApiState.Error(e.message ?: "Unknown Error"))
            }

        }


    fun saveData(req: RequestSaveDate, id: String?): Flow<ApiState<ResponseSaveData>> = flow {

        emit(ApiState.Loading)

        try {

            val encrypted = RequestLogin(EncryptionUtil.callEncryption(req))
            val response = apiService.saveData(encrypted, id)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }


    fun additionalDetails(request: RequestProposalAdditionalDetails, id: String?): Flow<ApiState<ResponseAdditionalDetails>> = flow {

        emit(ApiState.Loading)

        try {

            val encrypted = RequestLogin(EncryptionUtil.callEncryption(request))
            val response = apiService.additionalDetails(encrypted, id)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }


}



