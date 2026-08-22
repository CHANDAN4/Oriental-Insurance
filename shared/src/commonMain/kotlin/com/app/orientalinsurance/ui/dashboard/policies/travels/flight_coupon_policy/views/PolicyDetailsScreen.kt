package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.dashboard.navigations.Dashboards
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestBasicDetails
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import com.app.orientalinsurance.ui.font.mulishFontFamily

@Composable
fun PolicyDetailsScreen(
    flightViewModel: FlightViewModel,
    navController: NavHostController
) {

    val response by flightViewModel.responseBasicDetails.collectAsState()

    var flightFrom by remember {
        mutableStateOf(flightViewModel.flightFrom ?: "")
    }

    var flightTo by remember {
        mutableStateOf(flightViewModel.flightTo ?: "")
    }

    val isEnable by remember(flightFrom, flightTo) {
        derivedStateOf {
            flightFrom.isNotBlank() && flightTo.isNotBlank()
        }
    }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // ===================================
        // YOUR COMPLETE SCREEN
        // ===================================

        Scaffold(

            topBar = {
                Surface(
                    shadowElevation = 8.dp,
                    color = Color(0xFFF2F2FF)
                ) {

                    TopAppBar(
                        title = {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp),
                                text = "Flight Coupon Policy",
                                textAlign = TextAlign.Left,
                                fontFamily = mulishFontFamily(),
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.Black,
                                fontSize = 18.sp
                            )
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
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF2F2FF))
                    .padding(padding)
            ) {

                Spacer(
                    modifier = Modifier.height(30.dp)
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 15.dp,
                            end = 15.dp
                        ),
                    text = "Policy Details",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 18.sp
                )

                Spacer(
                    modifier = Modifier.height(50.dp)
                )

                // Flight From
                OutlinedTextField(
                    value = flightFrom,
                    onValueChange = {
                        flightFrom = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 20.dp,
                            end = 20.dp
                        ),
                    label = {
                        Text("Flight From")
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
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

                Spacer(
                    modifier = Modifier.height(15.dp)
                )

                // Flight To
                OutlinedTextField(
                    value = flightTo,
                    onValueChange = {
                        flightTo = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 20.dp,
                            end = 20.dp
                        ),
                    label = {
                        Text("Flight To")
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
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

                Spacer(
                    modifier = Modifier.height(50.dp)
                )

                Button(
                    enabled = isEnable,

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(
                            start = 20.dp,
                            end = 20.dp
                        ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFC85100),
                        contentColor = Color.White
                    ),

                    onClick = {

                        val requestBasicDetails =
                            RequestBasicDetails(
                                "",
                                "",
                                "",
                                "",
                                "",
                                emptyList(),
                                flightFrom,
                                flightTo,
                                "",
                                "",
                                1,
                                "",
                                "FLIGHT",
                                "",
                                "",
                                null,
                                "",
                                "",
                                null,
                                "OverseasDetails",
                                "",
                                "30",
                                3,
                                "",
                                null
                            )

                        flightViewModel.basicDetails(
                            requestBasicDetails
                        )
                    },

                    shape = RoundedCornerShape(15.dp)

                ) {

                    Text(
                        text = "Continue",
                        fontFamily = mulishFontFamily(),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }


        // ===================================
        // LOADING OVERLAY
        // ===================================

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


    // ===================================
    // API RESULT
    // ===================================

    when (val result = response) {

        is ApiState.Success -> {

            LaunchedEffect(result) {

                flightViewModel.id = result.data.id
                flightViewModel.flightFrom = flightFrom
                flightViewModel.flightTo = flightTo

                navController.navigate(
                    Dashboards.CoverAmount.route
                )
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