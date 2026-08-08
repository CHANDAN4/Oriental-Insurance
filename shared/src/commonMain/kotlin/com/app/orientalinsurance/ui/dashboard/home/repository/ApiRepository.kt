package com.app.orientalinsurance.ui.dashboard.home.repository

import com.app.orientalinsurance.data.network.ApiService
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.login.models.RequestLogin
import com.app.orientalinsurance.ui.login.models.ResponseLogin
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ApiRepository(
    private val apiService: ApiService
) {


    fun getProducts(requestLogin: RequestLogin) :  Flow<ApiState<ResponseLogin>> = flow {

        emit(ApiState.Loading)

        try {

            //val encrypted = Utility().callEncryption(request)
            val response = apiService.toLogin(requestLogin)
            if(response!=null) {
                //insertModeOfTransit(response)
                emit(ApiState.Success(response))
            } else {
                emit(ApiState.Empty)
            }

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }




}