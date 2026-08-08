package com.app.orientalinsurance.ui.login.views


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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.ui.login.models.RequestLogin
import com.app.orientalinsurance.ui.login.models.ResponseLogin
import com.app.orientalinsurance.ui.login.navigation.Login
import com.app.orientalinsurance.ui.login.viewModel.LoginViewModel
import com.app.orientalinsurance.utils.SetStatusBarColor


@Composable
fun LoginWithUID(loginViewModel: LoginViewModel, navController: NavController){


    var userName by remember { mutableStateOf("") }
    var pwd by remember { mutableStateOf("") }
    var isClick by remember { mutableStateOf(false) }

    val response by loginViewModel.responseLogin.collectAsState()
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

    if(userName.isNotEmpty()&&pwd.isNotEmpty() &&isClick){
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
                loginViewModel.settingsManager.saveEmail(result.data.emailId!!)
                loginViewModel.settingsManager.saveMobileNo(result.data.mobileNumber)
                navController.navigate(Login.Dashboard.route) {
                    popUpTo(Login.LoginWithUID.route) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }

            is ApiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = result.message)
                }
            }

            is ApiState.Empty -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No Data Found")
                }
            }


        }
    }

    Column(modifier = Modifier.fillMaxSize().verticalScroll( rememberScrollState())) {

        Column {
            TopAppBar(
                modifier = Modifier.fillMaxWidth().background(Color(0xFFF5F5F5)),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(start = 15.dp),
                        text = "Login",
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
            modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
            text = "For a more personalized experience, login",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Left,
            color = Color.Gray,
            fontSize = 13.sp
        )
        Text(
            modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
            text = "Note : Click here to view important guidelines before proceeding",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            color = Color.Gray,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(100.dp))
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },

            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),

            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("User Name ")
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
                        append("User Name ")
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

        if(userName.isEmpty() && isClick){
            Text(
                text = "Please enter user name",
                color = MaterialTheme.colorScheme.error,
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = 20.dp, top = 4.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = pwd,
            onValueChange = { pwd = it },
            visualTransformation = PasswordVisualTransformation(),

            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Password ")
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
                        append("Password ")
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
                keyboardType = KeyboardType.Password,
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
        if(pwd.isEmpty() && isClick){
            Text(
                text = "Please enter password",
                color = MaterialTheme.colorScheme.error,
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = 20.dp, top = 4.dp)
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
                if(userName.isNotEmpty() && pwd.isNotEmpty()){
                    val requestLogin= RequestLogin("U2FsdGVkX1/020ollVffpCMXhKWDFAPJZKgWsA2kL6Vg1gO+wEl+Eij51umt5DSqRkIAs3u+Uu9oDHMr3QvOcluVu5GPRLsl4It4xAxnpEfvPtdDiTtGxUATMHsTcXUs")
                    loginViewModel.toLogin(requestLogin)
                }
                
            },
            shape = RoundedCornerShape(15)
        ) {
            Text("Login",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(end = 25.dp),
            horizontalArrangement = Arrangement.End
        ) {

            Text(
                modifier = Modifier.wrapContentWidth().clickable{
                    navController.navigate(Login.ForgotPassword.route)
                },
                text = "Forgot Password",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Right,
                color = Color.Blue,
                fontSize = 13.sp
            )
        }

        Spacer(modifier = Modifier.height(80.dp))
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
        Spacer(modifier = Modifier.height(80.dp))

    }

}

@Composable
fun ToLoginScreen(x0: ResponseLogin, x1: NavController) {
    TODO("Not yet implemented")
}



