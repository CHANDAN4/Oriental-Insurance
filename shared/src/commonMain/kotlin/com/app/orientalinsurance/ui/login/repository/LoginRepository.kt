package com.app.orientalinsurance.ui.login.repository
import com.app.orientalinsurance.data.network.ApiService
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.login.models.RequestLogin
import com.app.orientalinsurance.ui.login.models.ResponseForgotPassword
import com.app.orientalinsurance.ui.login.models.ResponseLogin
import com.app.orientalinsurance.ui.login.models.ResponseSignUp
import com.app.orientalinsurance.ui.login.models.ResponseVerifyOtp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class LoginRepository (
    private val apiService: ApiService
) {


    fun toLogin(requestLogin: RequestLogin) :  Flow<ApiState<ResponseLogin>> = flow {

        emit(ApiState.Loading)

        try {

            //val encrypted = Utility().callEncryption(request)
            val response = apiService.toLogin(requestLogin)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }



    fun toSignup(requestLogin: RequestLogin) :  Flow<ApiState<ResponseSignUp>> = flow {

        emit(ApiState.Loading)

        try {

            //val encrypted = Utility().callEncryption(request)
            val response = apiService.toSignup(requestLogin)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }



    fun toForgotPassword(requestLogin: RequestLogin) :  Flow<ApiState<ResponseForgotPassword>> = flow {

        emit(ApiState.Loading)

        try {

            //val encrypted = Utility().callEncryption(request)
            val response = apiService.toForgotPassword(requestLogin)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }


    fun toVerifyOtp(requestLogin: RequestLogin) :  Flow<ApiState<ResponseVerifyOtp>> = flow {

        emit(ApiState.Loading)

        try {

            //val encrypted = Utility().callEncryption(request)
            val response = apiService.toVerifyOtp(requestLogin)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }





}