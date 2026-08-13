package com.app.orientalinsurance.koin
 

import com.app.orientalinsurance.data.multiplateformData.SettingsManager
import com.app.orientalinsurance.data.network.createHttpClient
import com.app.orientalinsurance.data.network.ApiService
import com.app.orientalinsurance.ui.dashboard.home.repository.ApiRepository
import com.app.orientalinsurance.ui.dashboard.home.viewmodel.HomeViewModel
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.repository.FlightRepository
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import com.app.orientalinsurance.ui.login.repository.LoginRepository
import com.app.orientalinsurance.ui.login.viewModel.LoginViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { createHttpClient(get()) }

    single { ApiService(get()) }

    single { LoginRepository(get()) }

    single { ApiRepository(get()) }

    single { FlightRepository(get()) }

    single { SettingsManager(get()) }

    factory { LoginViewModel(get(),get()) }

    factory { HomeViewModel(get(),get()) }

    factory { FlightViewModel(get(),get()) }

}