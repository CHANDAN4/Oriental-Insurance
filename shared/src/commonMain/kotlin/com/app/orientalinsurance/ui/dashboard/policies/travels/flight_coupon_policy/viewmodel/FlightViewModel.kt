package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.orientalinsurance.data.multiplateformData.SettingsManager
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
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.repository.FlightRepository
import com.app.orientalinsurance.ui.login.models.RequestLogin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class FlightViewModel(val repo: FlightRepository, val settingsManager: SettingsManager) : ViewModel() {


    var flightFrom: String?=null
    var flightTo: String?=null
    var coverAmt: String?=null
    var branchOffice: String?=null
    var branchOfficeId: String? = ""
    var officeCity: String? = ""
    var policyTermSelectedDate: String? = null
    var policyTermEndDate: String? = ""
    var branchEmail: String? = ""
    var branchState: String? = null
    var branchAddress: String? = null
    var saveProposalFlag: Boolean? = null
    var branchName: String? = ""
    var branchCode_: String? = ""

    var totalAmt: String?=null
    var basicPreAmt: String?=null
    var minPreAmt: String?=null
    var gst: String?=null
    var flightNo: String?=null
    var airlineCom: String?=null
    var flightSelDate: String?=null
    var disabilityStatus: String?=null
    var whileChairStatus: String?=null

    private val responseBasicDetails_ = MutableStateFlow<ApiState<ResponseBasicDetails>>(ApiState.Loading)

    val responseBasicDetails: StateFlow<ApiState<ResponseBasicDetails>> = responseBasicDetails_


    fun basicDetails(requestLogin: RequestBasicDetails) {

        viewModelScope.launch {
            repo?.basicDetails(requestLogin)
                ?.catch { e ->
                    println("ERROR: ${e.message}")
                }
                ?.collect {
                    responseBasicDetails_.value = it
                }
        }

    }


    var id: String?=null
    private val responseTravelQuote_ = MutableStateFlow<ApiState<ResponseTravelQuote>>(ApiState.Loading)
    val responseTravelQuote: StateFlow<ApiState<ResponseTravelQuote>> = responseTravelQuote_
    fun travelQuote(requestLogin: RequestProposalQuote, id: String?) {

        viewModelScope.launch {
            repo?.travelQuote(requestLogin,id)
                ?.catch { e ->
                    println("ERROR: ${e.message}")
                }
                ?.collect {
                    responseTravelQuote_.value = it
                }
        }

    }


    private val responseChooseOffice_ = MutableStateFlow<ApiState<ResponseChooseOffice>>(ApiState.Loading)

    val responseChooseOffice: StateFlow<ApiState<ResponseChooseOffice>> = responseChooseOffice_


    fun chooseOffice(requestLogin: RequestBranchOffice) {

        viewModelScope.launch {
            repo?.branchOffice(requestLogin)
                ?.catch { e ->
                    println("ERROR: ${e.message}")
                }
                ?.collect {
                    responseChooseOffice_.value = it
                }
        }

    }


    private val responseCreateFlight_ = MutableStateFlow<ApiState<ResponseCreateFlight>>(ApiState.Loading)

    val responseCreateFlight: StateFlow<ApiState<ResponseCreateFlight>> = responseCreateFlight_


    fun create(requestLogin: RequestProposalCreate, id: String?) {

        viewModelScope.launch {
            repo?.create(requestLogin,id)
                ?.catch { e ->
                    println("ERROR: ${e.message}")
                }
                ?.collect {
                    responseCreateFlight_.value = it
                }
        }

    }



    private val responseSaveData_ = MutableStateFlow<ApiState<ResponseSaveData>>(ApiState.Loading)

    val responseSaveData: StateFlow<ApiState<ResponseSaveData>> = responseSaveData_


    fun saveData(requestLogin: RequestSaveDate, id: String?) {

        viewModelScope.launch {
            repo?.saveData(requestLogin,id)
                ?.catch { e ->
                    println("ERROR: ${e.message}")
                }
                ?.collect {
                    responseSaveData_.value = it
                }
        }

    }



    private val responseAdditionalDetails_ = MutableStateFlow<ApiState<ResponseAdditionalDetails>>(ApiState.Loading)

    val responseAdditionalDetails: StateFlow<ApiState<ResponseAdditionalDetails>> = responseAdditionalDetails_


    fun additionalDetails(requestLogin: RequestProposalAdditionalDetails, id: String?) {

        viewModelScope.launch {
            repo?.additionalDetails(requestLogin,id)
                ?.catch { e ->
                    println("ERROR: ${e.message}")
                }
                ?.collect {
                    responseAdditionalDetails_.value = it
                }
        }

    }



}