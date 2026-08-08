package com.app.orientalinsurance.ui.login.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.orientalinsurance.data.multiplateformData.SettingsManager
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.login.models.RequestLogin
import com.app.orientalinsurance.ui.login.models.ResponseForgotPassword
import com.app.orientalinsurance.ui.login.models.ResponseLogin
import com.app.orientalinsurance.ui.login.models.ResponseSignUp
import com.app.orientalinsurance.ui.login.models.ResponseVerifyOtp
import com.app.orientalinsurance.ui.login.repository.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class LoginViewModel(val repository: LoginRepository,val settingsManager: SettingsManager) : ViewModel() {


    private val responseLogin_ = MutableStateFlow<ApiState<ResponseLogin>>(ApiState.Loading)

    val responseLogin : StateFlow<ApiState<ResponseLogin>> = responseLogin_


    fun toLogin(requestLogin: RequestLogin) {

        viewModelScope.launch {
            repository?.toLogin(requestLogin)
                ?.catch { e ->
                    println("ERROR: ${e.message}")
                }
                ?.collect {
                    responseLogin_.value = it
                    settingsManager.saveIsLogin(true)

                }
        }

    }


    private val responseSignUp_ = MutableStateFlow<ApiState<ResponseSignUp>>(ApiState.Loading)

    val responseSignUp : StateFlow<ApiState<ResponseSignUp>> = responseSignUp_


    fun toSignup(requestLogin: RequestLogin) {

        viewModelScope.launch {
            repository?.toSignup(requestLogin)
                ?.catch { e ->
                    println("ERROR: ${e.message}")
                }
                ?.collect {
                    responseSignUp_.value = it
                }
        }

    }



    private val responseForgotPassword_ = MutableStateFlow<ApiState<ResponseForgotPassword>>(ApiState.Loading)

    val responseForgotPassword : StateFlow<ApiState<ResponseForgotPassword>> = responseForgotPassword_


    fun toForgotPassword(requestLogin: RequestLogin) {

        viewModelScope.launch {
            repository?.toForgotPassword(requestLogin)
                ?.catch { e ->
                    println("ERROR: ${e.message}")
                }
                ?.collect {
                    responseForgotPassword_.value = it
                }
        }

    }



    private val responseVerifyOtp_ = MutableStateFlow<ApiState<ResponseVerifyOtp>>(ApiState.Loading)

    val responseVerifyOtp : StateFlow<ApiState<ResponseVerifyOtp>> = responseVerifyOtp_


    fun toVerifyOtp(requestLogin: RequestLogin) {

        viewModelScope.launch {
            repository?.toVerifyOtp(requestLogin)
                ?.catch { e ->
                    println("ERROR: ${e.message}")
                }
                ?.collect {
                    responseVerifyOtp_.value = it
                }

        }

    }



}