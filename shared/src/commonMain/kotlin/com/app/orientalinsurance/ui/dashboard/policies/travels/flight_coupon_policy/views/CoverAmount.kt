package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.dashboard.navigations.Dashboards
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestProposalQuote
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.ui.login.views.OTPTextFieldFP
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoverAmountScreen(flightViewModel: FlightViewModel, navController: NavHostController) {

    val response by flightViewModel.responseTravelQuote.collectAsState()
    var coverAmt by remember { mutableStateOf(flightViewModel.coverAmt ?: "") }
    var isClick by remember { mutableStateOf(false) }
    val isEnable by remember(coverAmt) {
        derivedStateOf {
            coverAmt.isNotBlank()
        }
    }
    var policySummary by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()



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
                                            policySummary = true
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

            }
        ) { padding ->

            Column(
                modifier = Modifier.fillMaxSize().background(Color(0xFFF2F2FF)).padding(padding)
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
                    text = "Add Cover Amount",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left,
                    color = Color.Black,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(50.dp))

                OutlinedTextField(
                    value = coverAmt,
                    onValueChange = { coverAmt = it },

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),

                    // Hint
                    placeholder = {
                        Text(
                            buildAnnotatedString {
                                append("Cover Amount ")
                                withStyle(
                                    style = SpanStyle(color = Color.Red)
                                ) {
                                    append("*")
                                }
                            },
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal
                        )
                    },

                    // Floating label
                    label = {
                        Text(
                            buildAnnotatedString {
                                append("Cover Amount ")
                                withStyle(
                                    style = SpanStyle(color = Color.Red)
                                ) {
                                    append("*")
                                }
                            },
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal
                        )
                    },

                    singleLine = true,

                    shape = RoundedCornerShape(12.dp),

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),

                    keyboardActions = KeyboardActions(
                        onDone = {
                            // Handle Done
                        }
                    ),

                    colors = OutlinedTextFieldDefaults.colors(

                        // Background
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color(0xFFF5F5F5),

                        // Border
                        focusedBorderColor = Color(0xFFC85100),
                        unfocusedBorderColor = Color.Gray,

                        // Cursor
                        cursorColor = Color(0xFFC85100),

                        // Text
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,

                        // Label
                        focusedLabelColor = Color(0xFFC85100),
                        unfocusedLabelColor = Color.Gray,

                        // Placeholder
                        focusedPlaceholderColor = Color.LightGray,
                        unfocusedPlaceholderColor = Color.LightGray
                    )
                )
                if (coverAmt.isNotEmpty()) {
                    if (coverAmt.toInt() < 100000) {
                        Text(
                            text = "Cover amount must be between ₹100000 to ₹2500000",
                            color = MaterialTheme.colorScheme.error,
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(start = 20.dp, top = 4.dp)
                        )
                    } else if (coverAmt.toInt() > 2500000) {
                        Text(
                            text = "Cover amount must be between ₹100000 to ₹2500000",
                            color = MaterialTheme.colorScheme.error,
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(start = 20.dp, top = 4.dp)
                        )
                    }
                }

                if (coverAmt.isEmpty() && isClick) {
                    Text(
                        text = "Cover amount must be between ₹100000 to ₹2500000",
                        color = MaterialTheme.colorScheme.error,
                        fontFamily = mulishFontFamily(),
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 20.dp, top = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(50.dp))

                Button(
                    enabled = isEnable,
                    modifier = Modifier.fillMaxWidth().height(50.dp)
                        .padding(start = 20.dp, end = 20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFC85100), // Background color
                        contentColor = Color.White          // Text color
                    ),
                    onClick = {
                        isClick = true
                        flightViewModel.coverAmt = coverAmt
                        val req = RequestProposalQuote(coverAmt.toInt())
                        flightViewModel.travelQuote(req, flightViewModel.id)

                    },
                    shape = RoundedCornerShape(15)
                ) {
                    Text(
                        "Continue",
                        fontFamily = mulishFontFamily(),
                        fontWeight = FontWeight.Bold
                    )
                }

            }

        }

        if (policySummary) {
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
                PolicySummaryCover(flightViewModel)
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

    }


    when (val result = response) {
        is ApiState.Success -> {
            LaunchedEffect(result) {
                println("Quote Response :${result.data}")
                flightViewModel.totalAmt = "" + result.data.finalPremium
                flightViewModel.basicPreAmt = "" + result.data.basicPremium
                flightViewModel.minPreAmt = "" + result.data.minimumPremiumApportionment
                flightViewModel.gst = "" + result.data.gst
                navController.navigate(Dashboards.ChooseOfficeScreen.route)
            }
        }

        is ApiState.Error -> {

            // Show error
            // Snackbar/Dialog recommended
        }

        is ApiState.Empty -> {

        }

        is ApiState.Loading -> {

        }
    }



}


@Composable
fun PolicySummaryCover(flightViewModel: FlightViewModel) {

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
