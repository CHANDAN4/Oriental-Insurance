package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views.Form60FatherDetailScreen
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views.Form60LocationDetailScreen
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views.Form60PersonalDetailScreen
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views.Form60TransactionDetailScreen
import com.app.orientalinsurance.ui.font.mulishFontFamily

@Composable
fun Form60Screen(
    flightViewModel: FlightViewModel,
    onComplete: () -> Unit
) {

    val form60NavController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Form 60 Details",
                        fontFamily = mulishFontFamily(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            onComplete()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = Color.Black
                        )
                    }
                }
            )
        }
    ) { innerPadding ->


        NavHost(
            navController = form60NavController,
            startDestination = Form60Screen.Form60Personal.rout,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Form60Screen.Form60Personal.rout) {
                Form60PersonalDetailScreen(
                    flightViewModel,
                    form60NavController
                )
            }

            composable(Form60Screen.Form60Father.rout) {
                Form60FatherDetailScreen(
                    flightViewModel,
                    form60NavController
                )
            }

            composable(Form60Screen.Form60Location.rout) {
                Form60LocationDetailScreen(
                    flightViewModel,
                    form60NavController
                )
            }

            composable(Form60Screen.Form60Transaction.rout) {
                Form60TransactionDetailScreen(
                    flightViewModel,
                    form60NavController,
                    onComplete={
                        onComplete()
                    }
                )
            }

        }
    }
}


sealed class Form60Screen(val rout:String){

    object Form60Personal: Form60Screen("Form60Personal")
    object Form60Father: Form60Screen("Form60Father")
    object Form60Location: Form60Screen("Form60Location")
    object Form60Transaction: Form60Screen("Form60Transaction")

}