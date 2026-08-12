package com.app.orientalinsurance.ui.login.views


import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.ui.login.models.RequestCustomerCheckEmailMobile
import com.app.orientalinsurance.ui.login.models.RequestLogin
import com.app.orientalinsurance.ui.login.navigation.Login
import com.app.orientalinsurance.ui.login.viewModel.LoginViewModel
import com.app.orientalinsurance.utils.SetStatusBarColor
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(loginViewModel: LoginViewModel, navController: NavController){

    val response by loginViewModel.responseSignUp.collectAsState()
    var selectedGender by remember { mutableStateOf("Customer Account") }
    var email by remember { mutableStateOf("") }
    var mobileNo by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var pwd by remember { mutableStateOf("") }
    var confirmPwd by remember { mutableStateOf("") }
    var userId by remember { mutableStateOf("") }
    var isClick by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    var otp by remember { mutableStateOf("") }

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

    if(email.isNotEmpty() && mobileNo.isNotEmpty() && firstName.isNotEmpty()&&lastName.isNotEmpty()&&pwd.isNotEmpty()&&confirmPwd.isNotEmpty()&&isClick){
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

                ModalBottomSheet(
                    onDismissRequest = { },
                    sheetState = sheetState,
                    shape = RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp
                    )
                ) {
                    VerifyOtpBottomSheet(
                        phoneNumber = "+91 98765 43210",
                        otp = otp,
                        onOtpChange = { otp = it },
                        onVerify = {
                            navController.navigateUp()
                        },
                        onResend = {

                        }
                    )
                }

            }

            is ApiState.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                     Text(text = result.message,
                         fontFamily = mulishFontFamily(),
                         fontWeight = FontWeight.Normal,
                         )
                }
            }

            is ApiState.Empty -> {

            }


        }
    }

    Column(modifier = Modifier.fillMaxWidth().verticalScroll( rememberScrollState())) {

        Column {
            TopAppBar(
                modifier = Modifier.fillMaxWidth().background(Color(0xFFF5F5F5)),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(start = 15.dp),
                        text = "Sign Up",
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
            text = "Let's Get Started",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Left,
            color = Color.Black,
            fontSize = 20.sp
        )
        Text(
            modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
            text = "Register to create your account and start exploring the right insurance for you",
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


        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.wrapContentWidth().padding(start = 15.dp, end = 15.dp),
            text = "Select Account Type",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Right,
            color = Color.Black,
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GenderItem(
                    text = "Customer Account",
                    selected = selectedGender == "Customer Account",
                    onClick = { selectedGender = "Customer Account" }
                )
            }

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                GenderItem(
                    text = "Partner Account",
                    selected = selectedGender == "Partner Account",
                    onClick = { selectedGender = "Partner Account" }
                )
            }
        }

        if(selectedGender=="Customer Account"){
            Spacer(modifier = Modifier.height(50.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),  // Hint
                placeholder = {
                    Text(
                        buildAnnotatedString {
                            append("User ID ")
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
                            append("User ID ")
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
            if(email.isEmpty() && isClick){
                Text(
                    text = "Please enter email",
                    color = MaterialTheme.colorScheme.error,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 20.dp, top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = mobileNo,
                onValueChange = { mobileNo = it },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp), // Hint
                placeholder = {
                    Text(
                        buildAnnotatedString {
                            append("Mobile No ")
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
                            append("Mobile No ")
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
            if(mobileNo.isEmpty() && isClick){
                Text(
                    text = "Please enter mobile no",
                    color = MaterialTheme.colorScheme.error,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 20.dp, top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                placeholder = {
                    Text(
                        buildAnnotatedString {
                            append("First Name ")
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
                            append("First Name ")
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
            if(firstName.isEmpty() && isClick){
                Text(
                    text = "Please enter First Name",
                    color = MaterialTheme.colorScheme.error,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 20.dp, top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),  // Hint
                placeholder = {
                    Text(
                        buildAnnotatedString {
                            append("Last Name ")
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
                            append("Last Name ")
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
            if(lastName.isEmpty() && isClick){
                Text(
                    text = "Please enter last name",
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
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = confirmPwd,
                onValueChange = { confirmPwd = it },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                // Hint
                placeholder = {
                    Text(
                        buildAnnotatedString {
                            append("Confirm Password ")
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
                            append("Confirm Password ")
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
            if(confirmPwd.isEmpty() && isClick){
                Text(
                    text = "Please enter confirm password",
                    color = MaterialTheme.colorScheme.error,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 20.dp, top = 4.dp)
                )
            }
            if(pwd!=confirmPwd && isClick){
                Text(
                    text = "Please enter correct password",
                    color = MaterialTheme.colorScheme.error,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 20.dp, top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
        }else{
            Spacer(modifier = Modifier.height(50.dp))
            OutlinedTextField(
                value = userId,
                onValueChange = { userId = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),  // Hint
                placeholder = {
                    Text(
                        buildAnnotatedString {
                            append("User ID ")
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
                            append("User ID ")
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
            if(userId.isNotEmpty() && isClick){
                Text(
                    text = "Please enter user-ID",
                    color = MaterialTheme.colorScheme.error,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 20.dp, top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
        }

        Button(
            modifier = Modifier.fillMaxWidth().height(50.dp).padding(start = 20.dp, end = 20 .dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC85100), // Background color
                contentColor = Color.White          // Text color
            ),
            onClick = {
                isClick=true
                if(email.isNotEmpty() && mobileNo.isNotEmpty()&&firstName.isNotEmpty()&&lastName.isNotEmpty()&&pwd.isNotEmpty()&&confirmPwd.isNotEmpty()){
                    val req= RequestCustomerCheckEmailMobile(emailId = email, mobileNumber = mobileNo)
                    //val requestLogin= RequestLogin("U2FsdGVkX18LvV9MWIocXcKNUAJAhpzhaHrMpnhguM1sGkPk2c4cycJhlLhBjljcofHHkFvkuvDymi60V494zoIoL/gwtQ5yPt2NSduSFVxg/2euZcgP8r2hmaxVkvAv")
                    loginViewModel.toSignup(req)
                }
            },
            shape = RoundedCornerShape(15)
        ) {
            Text("Sign Up",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                )
        }


        Spacer(modifier = Modifier.height(50.dp))
        Row( modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier.wrapContentWidth(),
                text = "Already have an account ?",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Right,
                color = Color.Gray,
                fontSize = 13.sp
            )
            Text(
                modifier = Modifier.wrapContentWidth().clickable{
                    navController.navigate(Login.Login1.route)
                },
                text = "Login",
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
fun GenderItem(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = if (selected) Color(0xFFC85100) else Color.Gray,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {

        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFFC85100),
                unselectedColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.width(2.dp))

        Text(
            text = text,
            color = if (selected) Color(0xFFC85100) else Color.Black,
            fontSize = 14.sp,
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

    }
}



@Composable
fun VerifyOtpBottomSheet(
    phoneNumber: String,
    otp: String,
    onOtpChange: (String) -> Unit,
    onVerify: () -> Unit,
    onResend: () -> Unit,
    modifier: Modifier = Modifier
) {

    var timeLeft by rememberSaveable { mutableIntStateOf(30) }
    var isResendEnabled by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (timeLeft > 0) {
            delay(1000)
            timeLeft--
        }
        isResendEnabled = true
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .width(48.dp)
                .height(5.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Verify OTP",
            style = MaterialTheme.typography.headlineSmall,
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "We've sent a 4-digit verification code to",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray
        )

        Text(
            text = phoneNumber,
            style = MaterialTheme.typography.titleMedium,
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.SemiBold,
        )

        Spacer(modifier = Modifier.height(28.dp))

        OTPTextField(
            otp = otp,
            onOtpChange = onOtpChange
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = if (isResendEnabled)
                "You can resend OTP"
            else
                "Resend OTP in ${timeLeft}s",
            color = Color(0xFFC85100),
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.Normal,
        )


        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onVerify,
            enabled = otp.length == 4,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text("Verify",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Composable
fun OTPTextField(
    otp: String,
    onOtpChange: (String) -> Unit
) {

    BasicTextField(
        value = otp,
        onValueChange = {
            if (it.length <= 4 && it.all(Char::isDigit))
                onOtpChange(it)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword
        ),
        decorationBox = {

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                repeat(4) { index ->

                    val value = otp.getOrNull(index)?.toString() ?: ""

                    Box(
                        modifier = Modifier
                            .size(60.dp)
                            .border(
                                1.dp,
                                if (value.isEmpty())
                                    Color.LightGray
                                else
                                    MaterialTheme.colorScheme.primary,
                                RoundedCornerShape(12.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {

                        Text(
                            text = value,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    )
}
