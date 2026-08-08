package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.repository

import com.app.orientalinsurance.data.network.ApiService
import com.app.orientalinsurance.data.network.ApiState
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


    fun basicDetails(requestLogin: RequestLogin): Flow<ApiState<ResponseBasicDetails>> = flow {

        emit(ApiState.Loading)

        try {

            //val encrypted = Utility().callEncryption(request)
            val response = apiService.basicDetails(requestLogin)
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


    fun travelQuote(requestLogin: RequestLogin, id: String?): Flow<ApiState<ResponseTravelQuote>> =
        flow {

            emit(ApiState.Loading)

            try {

                //val encrypted = Utility().callEncryption(request)
                val response = apiService.travelQuote(requestLogin, id)
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


    fun branchOffice(requestLogin: RequestLogin): Flow<ApiState<ResponseChooseOffice>> = flow {

        emit(ApiState.Loading)

        try {

            //val encrypted = Utility().callEncryption(request)
            val response = apiService.branchOffice(requestLogin)
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


    fun create(requestLogin: RequestLogin, id: String?): Flow<ApiState<ResponseCreateFlight>> =
        flow {

            emit(ApiState.Loading)

            try {

                //val encrypted = Utility().callEncryption(request)
                val response = apiService.create(requestLogin, id)
                emit(ApiState.Success(response))

            } catch (e: Exception) {
                emit(ApiState.Error(e.message ?: "Unknown Error"))
            }

        }


    fun saveData(requestLogin: RequestLogin, id: String?): Flow<ApiState<ResponseSaveData>> = flow {

        emit(ApiState.Loading)

        try {

            //val encrypted = Utility().callEncryption(request)
            val response = apiService.saveData(requestLogin, id)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }


    fun additionalDetails(requestLogin: RequestLogin, id: String?): Flow<ApiState<ResponseAdditionalDetails>> = flow {

        emit(ApiState.Loading)

        try {

            //val encrypted = Utility().callEncryption(request)
            val response = apiService.additionalDetails(requestLogin, id)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }


}



