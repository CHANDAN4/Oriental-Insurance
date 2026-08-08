package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.orientalinsurance.ui.dashboard.home.viewmodel.HomeViewModel
import com.app.orientalinsurance.ui.dashboard.navigations.Dashboards
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.ui.login.models.RequestLogin

@Composable
fun RightWayScreen(flightViewModel : FlightViewModel, navController: NavHostController) {

    var email by remember { mutableStateOf(flightViewModel.settingsManager.getEmail() ?: "abc@gmail.com")}
    var mobileNo by remember { mutableStateOf(flightViewModel.settingsManager.getMobileNo() ?:"9534567878" )}
    var isClick by remember { mutableStateOf(false)}
    var checked by remember { mutableStateOf(true) }

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
                text = "Your right way to buy the right Flight Coupon Policy",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                color = Color.Black,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(50.dp))

            OutlinedTextField(
                value = ""+email,
                onValueChange = {  },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),

                // Hint
                placeholder = {
                    Text("Email Address",
                        fontFamily = mulishFontFamily(),
                        fontWeight = FontWeight.Normal,
                    )
                },

                // Floating label
                label = {
                    Text("Email Address",
                        fontFamily = mulishFontFamily(),
                        fontWeight = FontWeight.Normal,
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
                value = ""+mobileNo,
                onValueChange = { mobileNo = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                // Hint
                placeholder = {
                    Text("Mobile Number",
                        fontFamily = mulishFontFamily(),
                        fontWeight = FontWeight.Normal,
                    )
                },

                // Floating label
                label = {
                    Text("Mobile Number",
                        fontFamily = mulishFontFamily(),
                        fontWeight = FontWeight.Normal,
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


            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.padding(start = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    }
                )

                Text(
                    text = "Get updates on WhatsApp",
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Normal

                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Button(
                modifier = Modifier.fillMaxWidth().height(50.dp).padding(start = 20.dp, end = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC85100), // Background color
                    contentColor = Color.White          // Text color
                ),
                onClick = {
                    isClick=true
                    navController.navigate(Dashboards.FlightDetails.route)

                },
                shape = RoundedCornerShape(15)
            ) {
                Text("Get Quote",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.padding(start = 20.dp, end = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Get updates on WhatsApp",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Normal

                )
                Text(
                    text = "T&Cs",
                    fontSize = 16.sp,
                    color = Color(0xFFC85100),
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold

                )
            }

        }

    }

}

