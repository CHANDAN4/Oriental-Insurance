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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.dashboard.navigations.Dashboards
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestBasicDetails
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.ui.login.models.RequestLogin
import com.app.orientalinsurance.ui.login.views.VerifyOtpBottomSheetFP
import kotlin.collections.emptyList

@Composable
fun PolicyDetailsScreen(flightViewModel: FlightViewModel, navController: NavHostController) {

    val response by flightViewModel.responseBasicDetails.collectAsState()
    var flightFrom by remember { mutableStateOf(flightViewModel.flightFrom ?: "") }
    var flightTo by remember { mutableStateOf(flightViewModel.flightTo ?: "") }
    var isClick by remember { mutableStateOf(false) }
    val isEnable by remember(flightFrom, flightTo) {
        derivedStateOf {
            flightFrom.isNotBlank() && flightTo.isNotBlank()
        }
    }



    when (val result = response) {

        is ApiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize().padding(top = 250.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                CircularProgressIndicator()
            }
        }

        is ApiState.Success -> {
            flightViewModel.id = result.data.id
            flightViewModel.flightFrom = flightFrom
            flightViewModel.flightTo = flightTo
            navController.navigate(Dashboards.CoverAmount.route)
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
                        Text(
                            modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
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

        Column(modifier = Modifier.fillMaxSize().background(Color(0xFFF2F2FF)).padding(padding)) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
                text = "Policy Details",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                color = Color.Black,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(50.dp))

            OutlinedTextField(
                value = flightFrom,
                onValueChange = { flightFrom = it },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),

                // Hint
                placeholder = {
                    Text(
                        buildAnnotatedString {
                            append("Flight From ")
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
                            append("Flight From ")
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
                value = flightTo,
                onValueChange = { flightTo = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                // Hint
                placeholder = {
                    Text(
                        buildAnnotatedString {
                            append("Flight To ")
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
                            append("Flight To ")
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
                    var requestBasicDetails = RequestBasicDetails(
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

                    //val req= RequestLogin("U2FsdGVkX19XiLiJRipSmKmKT9vWjF1O3+U+an/PF56AnECWYL/w2+cQybsBb7Lo7Sy7ypEqA8pC0zbSBcyag7BTQFjzvMv+O5AKvemS5QGjRkBbtnded9NdMYGXwlA/MglE31HitpV4l+q+DqjxL3IKJU/VdWREYVm8/Bfvivz5mC2jx8I6lvfgt8BVMQDBOwWex9R55Vu+nJRmHCJ2EDllbzrmvA5pyAvW/nVtkxiIwOPqCSZ5eFBsmYsGPmKoBJ/52BoqjSNHThUOhPHaLp4MrKLkQk9tq+bivq4GKvCgN3ZAtfIkF7Wl23mYJumetGyUcirDEJu6FKNcAk68J4n8L3Fifm/O6ClZhjVqTMGzc2wmng32RCPki0LPPiCNYA2j1ZRz+MJT/7IiwSiWtWvCNYzz/wJFp+p6nXeCtzTEIFeyLFLUI0QzqvZtHgw/2A5I6kVLzD37C2iOZGoPoa6sFKByzwL6Xz4X5c51SamUgjQ6zH7JzwQ6CSEqo9eiZ0GcactX0aqOl5V3AE+piaVUxcqLRJD8O870217zdCp4GElL9N/oV6LrydsGERPza1bYY37198ufQ8Ftx4wu7CMrbzrHb9B2vDFCLWuV5EEdCjyiGjDwJjP2HUd6SkVOgQemsSFqA5oQNuEdpdJSiQ==")
                    flightViewModel.basicDetails(requestBasicDetails)

                },
                shape = RoundedCornerShape(15)
            ) {
                Text(
                    "Continue",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                )
            }

        }

    }

}

