package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.dashboard.navigations.Dashboards
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestProposalAdditionalDetails
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import com.app.orientalinsurance.ui.font.mulishFontFamily
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProposerDetailsScreen(flightViewModel: FlightViewModel, navController: NavHostController) {

    val response by flightViewModel.responseAdditionalDetails.collectAsState()

    var selectedDisabilityStatus by remember { mutableStateOf( "") }
    var confirmDisabilityStatus by remember { mutableStateOf("") }

    var selectedConfinedWheelChair by remember { mutableStateOf( "") }
    var confinedWheelChair by remember { mutableStateOf("") }
    var disabilityStatus by remember { mutableStateOf("") }
    var selectedConfinedStatus by remember { mutableStateOf( "") }
    var disabilityConfined by remember { mutableStateOf("") }

    var isClick by remember { mutableStateOf(false)}
    val isEnable by remember(selectedDisabilityStatus, selectedConfinedWheelChair) {
        derivedStateOf {
            selectedDisabilityStatus.isNotBlank() && selectedConfinedWheelChair.isNotBlank()
        }
    }
    var policySummary by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()

    var primumBreakup by remember { mutableStateOf(false) }
    val sheetStatePA = rememberModalBottomSheetState()
    val scopePA = rememberCoroutineScope()

    when (val result = response) {

        is ApiState.Loading -> {

        }

        is ApiState.Success -> {
            navController.navigate(Dashboards.PersonalDetails.route)
        }

        is ApiState.Error -> {

        }

        is ApiState.Empty -> {

        }

    }


    Box(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            topBar = {
                Surface(
                    shadowElevation = 8.dp,
                    color = Color(0xFFF2F2FF)
                ) {
                    TopAppBar(
                        title = {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
                                    text = "Flight Coupon Policy",
                                    textAlign = TextAlign.Left,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.Black,
                                    fontSize = 18.sp
                                )
                                Text(
                                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp)
                                        .clickable {
                                            policySummary=true
                                        },
                                    text = "Policy Summary",
                                    textAlign = TextAlign.Left,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 14.sp,
                                    color = Color(0xFFC85100)
                                )
                            }
                        },
                        navigationIcon = {

                            IconButton(
                                onClick = {
                                    navController.navigateUp()
                                }
                            ) {
                                Icon(
                                    Icons.Default.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }

                        }
                    )
                }

            },
            bottomBar = {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp
                    ),
                    shadowElevation = 10.dp,
                    color = Color.White
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth().padding(
                            horizontal = 15.dp,
                            vertical = 15.dp
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(
                            modifier = Modifier.weight(1f).clickable{
                                primumBreakup=true
                            }
                        ) {

                            Text(
                                text = "₹ ${flightViewModel.totalAmt}",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(Modifier.height(4.dp))

                            Text(
                                text = "View Premium Breakup",
                                color = Color(0xFFC46A09),
                                textDecoration = TextDecoration.Underline,
                                fontSize = 15.sp
                            )
                        }

                        Button(
                            onClick = {
                                flightViewModel.disabilityStatus=selectedDisabilityStatus
                                flightViewModel.whileChairStatus=selectedConfinedStatus
                                val req=RequestProposalAdditionalDetails(
                                    age = null,
                                    agentBrokerType = null,
                                    airlinesCompany = flightViewModel?.airlineCom!!,
                                    countryOfVisit = "",
                                    dateOfBirth = "",
                                    dateOfTravel = flightViewModel.dateOfTravel,
                                    desCityCode = "",
                                    desStateCode = "",
                                    destinationCity = "",
                                    destinationState = "",
                                    disabled = disabilityStatus,
                                    endDate = "",
                                    flightNo = flightViewModel.flightNo!!,
                                    gender = "",
                                    identificationNo = "",
                                    identityProof = "",
                                    memberDetails = emptyList(),
                                    memberDetailsFlag = null,
                                    members = emptyList(),
                                    nationality = "INDIAN",
                                    originCity = "",
                                    originCityCode = "",
                                    originState = "",
                                    originStateCode = "",
                                    physicalDisabilityEx = null,
                                    proposalMainResponse = null,
                                    proposerOccupation = "",
                                    proposerPassportNo = "",
                                    proposerPedStatus = "",
                                    proposerWinterSports = "",
                                    purposeOfVisit = "",
                                    sourceType = null,
                                    startDate = "",
                                    visitingSchengenCountries = null,
                                    wheelChair = selectedConfinedStatus
                                )
                                flightViewModel.additionalDetails(req,flightViewModel.id)
                            },
                            modifier = Modifier.width(150.dp).height(50.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFC85A00)
                            )
                        ) {

                            Text(
                                "Continue",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontFamily = mulishFontFamily(),
                                fontWeight = FontWeight.Bold
                            )

                        }
                    }
                }
            }
        ) { padding ->

            Column(modifier = Modifier.fillMaxSize().background(Color(0xFFF2F2FF)).padding(padding)) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
                    text = "Proposer's Details",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left,
                    color = Color.Black,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(50.dp))

                Column(modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp)) {
                    Text("Disability Status ? *",modifier = Modifier.padding(start = 10.dp), style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth().align(Alignment.Start)
                    ) {
                        listOf("Yes", "No").forEach { option ->
                            OutlinedButton(
                                onClick = {
                                    selectedDisabilityStatus = option
                                    if (selectedDisabilityStatus == "Yes") {
                                        disabilityStatus = "Yes"
                                    } else {
                                        disabilityStatus = "No"
                                    }

                                },
                                shape = RoundedCornerShape(10.dp), // Rounded shape
                                border = BorderStroke(1.dp,
                                    if (selectedDisabilityStatus == option) Color(0xFF005BAC) else Color(0xFFD9D9D9)
                                ),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    contentColor = if (selectedDisabilityStatus == option) Color.Blue.copy(alpha = 0.1f) else Color.White
                                ),
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Text(
                                    option,
                                    color = if (selectedDisabilityStatus == option) Color.Blue else Color.Black,
                                    modifier = Modifier.width(110.dp).padding(top = 7.dp, bottom = 7.dp),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                    }

                }
                Spacer(modifier = Modifier.height(15.dp))
                Column(modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp)) {
                    Text("Confined to wheelchair ? *",modifier = Modifier.padding(start = 10.dp), style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth().align(Alignment.Start)
                    ) {
                        listOf("Yes", "No").forEach { option ->
                            OutlinedButton(
                                onClick = {
                                    selectedConfinedStatus = option
                                    if (selectedConfinedStatus == "Yes") {
                                        disabilityConfined = "Yes"
                                    } else {
                                        disabilityConfined = "No"
                                    }

                                },
                                shape = RoundedCornerShape(10.dp), // Rounded shape
                                border = BorderStroke(1.dp,
                                    if (selectedConfinedStatus == option) Color(0xFF005BAC) else Color(0xFFD9D9D9)
                                ),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    contentColor = if (selectedConfinedStatus == option) Color.Blue.copy(alpha = 0.1f) else Color.White
                                ),
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Text(
                                    option,
                                    color = if (selectedConfinedStatus == option) Color.Blue else Color.Black,
                                    modifier = Modifier.width(110.dp).padding(top = 7.dp, bottom = 7.dp),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                    }

                }


            }

        }

        if (response is ApiState.Loading) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color.Black.copy(alpha = 0.3f)
                    ),
                contentAlignment = Alignment.Center
            ) {

                CircularProgressIndicator()
            }
        }

        if(policySummary){
            ModalBottomSheet(
                onDismissRequest = {
                    scope.launch {
                        sheetState.hide()
                        policySummary = false
                    }
                },
                sheetState = sheetState,
                shape = RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp
                )
            ) {
                PolicySummaryProposerDetails(flightViewModel)
            }

        }

        if (primumBreakup) {
            ModalBottomSheet(
                onDismissRequest = {
                    scopePA.launch {
                        sheetStatePA.hide()
                        primumBreakup = false
                    }
                },
                sheetState = sheetStatePA,
                shape = RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp
                )
            ) {
                PremiumSummaryProposalDetails(flightViewModel)
            }

        }

    }


}



@Composable
fun PolicySummaryProposerDetails(flightViewModel: FlightViewModel) {

    Column(
        modifier = Modifier.fillMaxWidth().navigationBarsPadding().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Policy Summary",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            thickness = 1.dp,
            color = Color(0xFFE0E0E0)
        )
        Spacer(modifier = Modifier.height(8.dp))
        flightViewModel.flightFrom?.let {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    modifier = Modifier.weight(.5f),
                    text = "Flight From",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    text = ":",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = it,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        flightViewModel.flightTo?.let {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    modifier = Modifier.weight(.5f),
                    text = "Flight To",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    text = ":",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = it,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Plan Summary",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            thickness = 1.dp,
            color = Color(0xFFE0E0E0)
        )
        Spacer(modifier = Modifier.height(8.dp))
        flightViewModel.coverAmt?.let {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    modifier = Modifier.weight(.5f),
                    text = "Cover Amount",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    text = ":",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = it,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Additional Details",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            thickness = 1.dp,
            color = Color(0xFFE0E0E0)
        )
        Spacer(modifier = Modifier.height(8.dp))
        flightViewModel.branchOffice?.let {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    modifier = Modifier.weight(.5f),
                    text = "Branch Address",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    text = ":",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = it,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        flightViewModel.flightNo?.let {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    modifier = Modifier.weight(.5f),
                    text = "Flight No",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    text = ":",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = it,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        flightViewModel.airlineCom?.let {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    modifier = Modifier.weight(.5f),
                    text = "Airline",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    text = ":",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = it,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        flightViewModel.policyTermSelectedDate?.let {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    modifier = Modifier.weight(.5f),
                    text = "Date Of Travel",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    text = ":",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = it,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        flightViewModel.disabilityStatus?.let {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    modifier = Modifier.weight(.5f),
                    text = "Disability Status",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    text = ":",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = it,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        flightViewModel.whileChairStatus?.let {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    modifier = Modifier.weight(.5f),
                    text = "Confined to Wheelchair",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    text = ":",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = it,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }

}

@Composable
fun PremiumSummaryProposalDetails(flightViewModel: FlightViewModel) {

    Column(
        modifier = Modifier.fillMaxWidth().navigationBarsPadding().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Premium Breakup",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            textAlign = TextAlign.Left
        )

        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            thickness = 1.dp,
            color = Color(0xFFE0E0E0)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                modifier = Modifier.weight(1f),
                text = "Basic Premium",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                text = ":",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                modifier = Modifier.weight(1f),
                text = "₹${flightViewModel.basicPreAmt}",
                color = Color.Gray,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.SemiBold,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                modifier = Modifier.weight(1f),
                text = "Minimum Premium Apportionment",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                text = ":",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                modifier = Modifier.weight(1f),
                text = "₹${flightViewModel.minPreAmt}",
                color = Color.Gray,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.SemiBold,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                modifier = Modifier.weight(1f),
                text = "GST",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                text = ":",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                modifier = Modifier.weight(1f),
                text = "₹${flightViewModel.gst}",
                color = Color.Gray,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.SemiBold,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                modifier = Modifier.weight(1f),
                text = "Total Amount",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                text = ":",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                modifier = Modifier.weight(1f),
                text = "₹${flightViewModel.totalAmt}",
                color = Color.Gray,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.SemiBold,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            OutlinedButton(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(end = 5.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    Color.White,
                    contentColor = Color.Black
                ),
                onClick = {


                }) {
                Icon(
                    imageVector = Icons.Filled.Download,
                    tint = Color.Gray,
                    contentDescription = "Download"
                )
                Text(
                    textAlign = TextAlign.Left,
                    text = " Download Quote",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray,
                )
            }

            OutlinedButton(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(end = 5.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    Color.White,
                    contentColor = Color.Black
                ),
                onClick = {

                }) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    tint = Color.Gray,
                    contentDescription = "  Share"
                )
                Text(
                    textAlign = TextAlign.Left,
                    text = "  Share Quote",
                    fontFamily = mulishFontFamily(),
                    fontSize = 14.sp,
                    color = Color.Gray,
                )
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
