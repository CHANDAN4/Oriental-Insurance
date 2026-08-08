package com.app.orientalinsurance.ui.login.views


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.ui.login.navigation.Login
import com.app.orientalinsurance.ui.login.viewModel.LoginViewModel
import com.app.orientalinsurance.utils.SetStatusBarColor
import org.jetbrains.compose.resources.painterResource
import orientalinsurance.shared.generated.resources.Res
import orientalinsurance.shared.generated.resources.facebook
import orientalinsurance.shared.generated.resources.google
import orientalinsurance.shared.generated.resources.twitter


@Composable
fun LoginScreen(loginViewModel: LoginViewModel, navController: NavController){


    val lifecycleOwner = LocalLifecycleOwner.current

    SetStatusBarColor(
        color = Color(0xFF005BAC),
        darkIcons = false
    )
    DisposableEffect(lifecycleOwner) {


        val observer = LifecycleEventObserver { _, event ->

            when (event) {

                Lifecycle.Event.ON_CREATE -> {
                    //Log.d("TAG", "ON_CREATE")
                }

                Lifecycle.Event.ON_START -> {
                    //Log.d("TAG", "ON_START")
                }

                Lifecycle.Event.ON_RESUME -> {
                    //Log.d("TAG", "ON_RESUME")
                }

                Lifecycle.Event.ON_PAUSE -> {
                    //Log.d("TAG", "ON_PAUSE")
                }

                Lifecycle.Event.ON_STOP -> {
                    //Log.d("TAG", "ON_STOP")
                }

                Lifecycle.Event.ON_DESTROY -> {
                    //Log.d("TAG", "ON_DESTROY")
                }

                else -> {

                }
            }//End when

        }//End Observer

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }

    }


    Column(modifier = Modifier.fillMaxSize().verticalScroll( rememberScrollState())) {

        Column {
            TopAppBar(
                modifier = Modifier.fillMaxWidth().background(Color(0xFFF5F5F5)),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(start = 15.dp),
                        text = "",
                        fontFamily = mulishFontFamily(),
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Left,
                        color = Color.Black,
                        fontSize = 22.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.fillMaxWidth().padding(start = 15.dp),
            text = "Login to your OICL account",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Left,
            color = Color.Black,
            fontSize = 20.sp
        )
        Text(
            modifier = Modifier.fillMaxWidth().padding(start = 15.dp),
            text = "For a more personalized experience,login",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Left,
            color = Color.Gray,
            fontSize = 13.sp
        )
        Spacer(modifier = Modifier.height(150.dp))

        Button(
            modifier = Modifier.fillMaxWidth().height(50.dp).padding(start = 25.dp, end = 25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC85100), // Background color
                contentColor = Color.White          // Text color
            ),
            onClick = {
                navController.navigateUp()
            },
            shape = RoundedCornerShape(15)
        ) {
            Text("Continue with Mobile/Email",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            modifier = Modifier.fillMaxWidth().height(50.dp).padding(start = 25.dp, end = 25.dp),
            border = BorderStroke(
                width = 1.dp,
                color = Color(0xFFC85100)
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFFFFF), // Background color
                contentColor = Color(0xFFC85100)          // Text color
            ),
            onClick = {
                navController.navigate(Login.LoginWithUID.route)
            },
            shape = RoundedCornerShape(15)
        ) {
            Text("Continue with User-ID",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                )
        }

        Spacer(modifier = Modifier.height(100.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(Res.drawable.google),
                contentDescription = "Gmail",
                modifier = Modifier.size(40.dp)
            )

            Image(
                painter = painterResource(Res.drawable.facebook),
                contentDescription = "Facebook",
                modifier = Modifier.size(40.dp)
            )

            Image(
                painter = painterResource(Res.drawable.twitter),
                contentDescription = "Twitter",
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(modifier = Modifier.height(50.dp))
        Row( modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier.wrapContentWidth(),
                text = "Don't you have an account ?",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Right,
                color = Color.Gray,
                fontSize = 13.sp
            )
            Text(
                modifier = Modifier.wrapContentWidth().clickable{
                    navController.navigate(Login.SignupScreen.route)
                },
                text = "Sign-Up",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Left,
                color = Color.Blue,
                fontSize = 14.sp
            )
        }


    }

}



