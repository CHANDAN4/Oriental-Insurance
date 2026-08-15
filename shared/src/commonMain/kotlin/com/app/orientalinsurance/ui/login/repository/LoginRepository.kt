package com.app.orientalinsurance.ui.login.repository
import com.app.orientalinsurance.data.cripto.EncryptionUtil
import com.app.orientalinsurance.data.network.ApiService
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.login.models.CustomerOtpRequest
import com.app.orientalinsurance.ui.login.models.CustomerOtpResponse
import com.app.orientalinsurance.ui.login.models.RequestCustomerCheckEmailMobile
import com.app.orientalinsurance.ui.login.models.RequestForgetPassword
import com.app.orientalinsurance.ui.login.models.RequestLoginWithUserIdRequestModel
import com.app.orientalinsurance.ui.login.models.RequestLogin
import com.app.orientalinsurance.ui.login.models.RequestPhoneNumberVerificationOtp
import com.app.orientalinsurance.ui.login.models.RequestResetPassword
import com.app.orientalinsurance.ui.login.models.RequestVerifyOTP
import com.app.orientalinsurance.ui.login.models.RequestVerifySignupOtp
import com.app.orientalinsurance.ui.login.models.ResponseForgotPassword
import com.app.orientalinsurance.ui.login.models.ResponseLogin
import com.app.orientalinsurance.ui.login.models.ResponseResetPassword
import com.app.orientalinsurance.ui.login.models.ResponseSignUp
import com.app.orientalinsurance.ui.login.models.ResponseVerifyOtp
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class LoginRepository (
    private val apiService: ApiService
) {


    fun toLogin(requestLogin: RequestLoginWithUserIdRequestModel) :  Flow<ApiState<ResponseLogin>> = flow {

        emit(ApiState.Loading)

        try {
            val encryptedRequest = EncryptionUtil.callEncryption(requestLogin)
            val encrypted = RequestLogin(encryptedRequest)
            println("Api Encription"+encrypted)
            val response = apiService.toLogin(encrypted)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }



    fun toSignup(reqSignup: RequestCustomerCheckEmailMobile) :  Flow<ApiState<ResponseSignUp>> = flow {

        emit(ApiState.Loading)

        try {

            val encrypted = RequestLogin(EncryptionUtil.callEncryption(reqSignup))
            val response = apiService.toSignup(encrypted)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }


    fun customerSignupOtp(reqSignup: CustomerOtpRequest) :  Flow<ApiState<CustomerOtpResponse>> = flow {

        emit(ApiState.Loading)

        try {

            val encrypted = RequestLogin(EncryptionUtil.callEncryption(reqSignup))
            val response = apiService.customerSignupOtp(encrypted)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }

    fun customerSignupOtpVerify(reqSignup: RequestVerifySignupOtp) :  Flow<ApiState<Unit>> = flow {

        emit(ApiState.Loading)

        try {

            val encrypted = RequestLogin(EncryptionUtil.callEncryption(reqSignup))
            val response = apiService.customerSignupOtpVerify(encrypted)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }


    fun toForgotPassword(req: RequestForgetPassword) :  Flow<ApiState<ResponseForgotPassword>> = flow {

        emit(ApiState.Loading)

        try {

            val encrypted = RequestLogin(EncryptionUtil.callEncryption(req))
            val response = apiService.toForgotPassword(encrypted)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }


    fun toVerifyOtp(req: RequestVerifyOTP) :  Flow<ApiState<ResponseVerifyOtp>> = flow {

        emit(ApiState.Loading)

        try {

            val encrypted = RequestLogin(EncryptionUtil.callEncryption(req))
            val response = apiService.toVerifyOtp(encrypted)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }


    fun resetPassword(req: RequestResetPassword) :  Flow<ApiState<ResponseResetPassword>> = flow {

        emit(ApiState.Loading)

        try {

            val encrypted = RequestLogin(EncryptionUtil.callEncryption(req))
            val response = apiService.resetPassword(encrypted)
            emit(ApiState.Success(response))

        } catch (e: Exception) {
            emit(ApiState.Error(e.message ?: "Unknown Error"))
        }

    }





}