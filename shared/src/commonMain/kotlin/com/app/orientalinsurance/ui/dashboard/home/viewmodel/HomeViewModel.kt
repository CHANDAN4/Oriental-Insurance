package com.app.orientalinsurance.ui.dashboard.home.viewmodel

import androidx.lifecycle.ViewModel
import com.app.orientalinsurance.data.multiplateformData.SettingsManager
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.dashboard.home.repository.ApiRepository
import com.app.orientalinsurance.ui.login.models.ResponseLogin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(val repo: ApiRepository,val settingsManager: SettingsManager) : ViewModel() {


    private val responseProducts_ = MutableStateFlow<ApiState<ResponseLogin>>(ApiState.Loading)

    val responseProducts: StateFlow<ApiState<ResponseLogin>> = responseProducts_


    /*fun getProductsList() {

        viewModelScope.launch {
            repo?.getProducts()
                ?.catch { e ->
                    println("ERROR: ${e.message}")
                }
                ?.collect {
                    responseProducts_.value = it
                }
        }

    }*/



}