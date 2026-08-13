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
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.dashboard.navigations.Dashboards
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestSaveDate
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.ui.login.models.RequestLogin
import com.app.orientalinsurance.utils.ShowDatePicker
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightDetailsScreen(flightViewModel: FlightViewModel, navController: NavHostController) {

    val responseSaveData by flightViewModel.responseSaveData.collectAsState()
    var flightNo by remember { mutableStateOf(flightViewModel.flightNo?:"") }
    var airLineComp by remember { mutableStateOf(flightViewModel.airlineCom?:"") }
    var selectedDateOfTravel by remember { mutableStateOf(flightViewModel.flightSelDate?:"") }
    var isClick by remember { mutableStateOf(false) }
    val isEnable by remember(flightNo, airLineComp, selectedDateOfTravel) {
        derivedStateOf {
            flightNo.isNotBlank() && airLineComp.isNotBlank() && selectedDateOfTravel.isNotEmpty()
        }
    }
    var showPicker by remember {
        mutableStateOf(false)
    }

    var policySummary by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    var primumBreakup by remember { mutableStateOf(false) }
    val sheetStatePA = rememberModalBottomSheetState()
    val scopePA = rememberCoroutineScope()

    when (val result = responseSaveData) {

        is ApiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize().padding(top = 250.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                CircularProgressIndicator()
            }
        }

        is ApiState.Success -> {
            //flightViewModel.branchOffice=chooseCity
            flightViewModel.flightNo=flightNo
            flightViewModel.airlineCom=airLineComp
            flightViewModel.flightSelDate=selectedDateOfTravel
            navController.navigate(Dashboards.ProposerDetailsScreen.route)
        }

        is ApiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = result.message,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Normal,
                )
            }
        }

        is ApiState.Empty -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Data Not Found",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Normal,
                )
            }
        }

    }

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
                            navController.navigate(Dashboards.ProposerDetailsScreen.route)
                            val req=RequestSaveDate(selectedDateOfTravel)
                            //val req= RequestLogin("U2FsdGVkX1/UkwQ87EWihuPCvvLthWyMsW7cu0L9ug5mGdm2fhHoMFAU+h4NdNdqFLR0C/Ht4giuV2oqFgQ5gstyVC/+RxErrjTKykWvZlw=")
                            flightViewModel.saveData(req,flightViewModel.id)
                        },
                        modifier = Modifier
                            .width(150.dp)
                            .height(50.dp),
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
                text = "Flight Details",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                color = Color.Black,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(50.dp))

            OutlinedTextField(
                value = flightNo,
                onValueChange = { flightNo = it },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),

                // Hint
                placeholder = {
                    Text(
                        buildAnnotatedString {
                            append("Flight No ")
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
                            append("Flight No ")
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
                    keyboardType = KeyboardType.Email,
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
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = airLineComp,
                onValueChange = { airLineComp = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                // Hint
                placeholder = {
                    Text(
                        buildAnnotatedString {
                            append("Airlines Company ")
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
                            append("Airlines Company  ")
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
                    keyboardType = KeyboardType.Text,
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
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = selectedDateOfTravel,
                readOnly = true,
                onValueChange = {
                    //selectedDateOfTravel = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                // Hint
                placeholder = {
                    Text(
                        buildAnnotatedString {
                            append("Date Of Travel ")
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
                            append("Select Date Of Travel  ")
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
                trailingIcon = {
                    IconButton(
                        onClick = {
                            showPicker = true
                            // Open DatePicker here
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Calendar",
                            tint = Color.Gray
                        )
                    }
                },

                singleLine = true,

                shape = RoundedCornerShape(12.dp),

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
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

            ShowDatePicker(
                show = showPicker,
                onDismiss = {
                    showPicker = false
                },
                onDateSelected = {
                    selectedDateOfTravel = it
                }
            )

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
            PolicySummaryFlightDetails(flightViewModel)
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
            PremiumSummaryFlightDetails(flightViewModel)
        }

    }

}


@Composable
fun PremiumSummaryFlightDetails(flightViewModel: FlightViewModel) {

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
                text = "${flightViewModel.basicPreAmt}",
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
                text = "${flightViewModel.minPreAmt}",
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
                text = "${flightViewModel.gst}",
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
                text = "${flightViewModel.totalAmt}",
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
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
@Composable
fun PolicySummaryFlightDetails(flightViewModel: FlightViewModel) {

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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                modifier = Modifier.weight(1f),
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
                text = "${flightViewModel.flightFrom}",
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
                text = "${flightViewModel.flightFrom}",
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
                text = "${flightViewModel.coverAmt}",
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
                text = "${flightViewModel.branchOffice}",
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
                text = "Choose Office",
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
                text = "Noida,Sector 58 ,Block 20 F",
                color = Color.Gray,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.SemiBold,
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }


}

