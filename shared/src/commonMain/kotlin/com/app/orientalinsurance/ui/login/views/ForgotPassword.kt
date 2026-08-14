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
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.ui.login.models.RequestForgetPassword
import com.app.orientalinsurance.ui.login.models.RequestLogin
import com.app.orientalinsurance.ui.login.models.RequestVerifyOTP
import com.app.orientalinsurance.ui.login.navigation.Login
import com.app.orientalinsurance.ui.login.viewModel.LoginViewModel
import com.app.orientalinsurance.utils.SetStatusBarColor
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPassword(loginViewModel: LoginViewModel, navController: NavController){

    val response by loginViewModel.responseForgotPassword.collectAsState()
    val responseVerifyOtp by loginViewModel.responseVerifyOtp.collectAsState()
    var userName by remember { mutableStateOf("") }
    var mobileNo by remember { mutableStateOf("") }
    var isClick by remember { mutableStateOf(false) }
    var otp by remember { mutableStateOf("") }
    val sheetState = rememberModalBottomSheetState()
    val lifecycleOwner = LocalLifecycleOwner.current
    var showPasswordDialog by remember { mutableStateOf(false) }

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

    if(userName.isNotEmpty()&& isClick || mobileNo.isNotEmpty() &&isClick){
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
                    VerifyOtpBottomSheetFP(
                        userName,
                        loginViewModel =loginViewModel ,
                        phoneNumber = result.data.mobileNumOrEmailId,
                        otp = otp,
                        onOtpChange = { otp = it },
                        onVerify = {
                            navController.navigateUp()
                            val req= RequestVerifyOTP(otp,result.data.transactionId)
                            loginViewModel.toVerifyOtp(req)
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

    when (val result = responseVerifyOtp) {

        is ApiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize().padding(top = 250.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                CircularProgressIndicator()
            }
        }

        is ApiState.Success -> {
            showPasswordDialog=true
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

    Column(modifier = Modifier.fillMaxSize().verticalScroll( rememberScrollState())) {

        Column {
            TopAppBar(
                modifier = Modifier.fillMaxWidth().background(Color(0xFFF5F5F5)),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(start = 15.dp),
                        text = "",
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
            text = "Forgot Password",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Left,
            color = Color.Black,
            fontSize = 20.sp
        )
        Text(
            modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp),
            text = "No worries, we'll send you instructions for reset",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.SemiBold,
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
                Text("User ID",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Normal,
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

        Spacer(modifier = Modifier.height(15.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Text(modifier = Modifier.fillMaxWidth(),
                text = "Or",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = mobileNo,
            onValueChange = { mobileNo = it },
            visualTransformation = PasswordVisualTransformation(),

            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            // Hint
            placeholder = {
                Text("Mobile/Email",
                        fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Normal,
                )
            },

            // Floating label
            label = {
                Text(
                    buildAnnotatedString {
                        append("Email/Mobile ")
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

        if(userName.isEmpty() && mobileNo.isEmpty() && isClick){
            Text(
                text = "Please enter user name OR Mobile/Email",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
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
                if(userName.isNotEmpty() || mobileNo.isNotEmpty()){
                    val req= RequestForgetPassword(userName = userName)
                    loginViewModel.toForgotPassword(req)
                }

            },
            shape = RoundedCornerShape(15)
        ) {
            Text("Continue",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(modifier = Modifier.height(80.dp))

    }


    if(showPasswordDialog){
        NewPasswordDialog(
            onDismiss = {
                showPasswordDialog = false
            },
            onUpdatePassword = { newPassword ->

                // Call your API here

                println("New password: $newPassword")

                showPasswordDialog = false
            }
        )
    }

}



@Composable
fun VerifyOtpBottomSheetFP(
    userName: String,
    loginViewModel: LoginViewModel,
    phoneNumber: String,
    otp: String,
    onOtpChange: (String) -> Unit,
    onVerify: () -> Unit,
    onResend: () -> Unit,
    modifier: Modifier = Modifier
) {

    var timeLeft by rememberSaveable { mutableIntStateOf(120) }
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
            fontWeight = FontWeight.Bold,
            fontFamily = mulishFontFamily(),

        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "We've sent a 4-digit verification code to",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.Normal,
        )

        Text(
            text = phoneNumber,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(28.dp))

        OTPTextFieldFP(
            otp = otp,
            onOtpChange = onOtpChange
        )

        Spacer(modifier = Modifier.height(24.dp))

        if(isResendEnabled){
            Text(
                modifier= Modifier.fillMaxWidth().clickable{
                    val req= RequestForgetPassword(userName = userName)
                    loginViewModel.toForgotPassword(req)
                },
                text = "You can resend OTP",
                color = Color(0xFFC85100),
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.SemiBold,
            )
        }else{
            Text(
                modifier= Modifier.fillMaxWidth().clickable{
                    val req= RequestForgetPassword(userName = userName)
                    loginViewModel.toForgotPassword(req)
                },
                text =  "Resend OTP in ${timeLeft}s",
                color = Color(0xFFC85100),
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.SemiBold,
            )
        }

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
fun OTPTextFieldFP(
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


@Composable
fun NewPasswordDialog(
    onDismiss: () -> Unit,
    onUpdatePassword: (String) -> Unit
) {
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var newPasswordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    val passwordsMatch =
        newPassword.isNotEmpty() &&
        confirmPassword.isNotEmpty() &&
        newPassword == confirmPassword

    val isPasswordValid =
        newPassword.length >= 8

    val isValid = isPasswordValid && passwordsMatch

    AlertDialog(
        onDismissRequest = onDismiss,

        title = {
            Text(
                text = "Create New Password",
                style = MaterialTheme.typography.titleLarge
            )
        },

        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                OutlinedTextField(
                    value = newPassword,
                    onValueChange = {
                        newPassword = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text("New Password")
                    },
                    singleLine = true,
                    visualTransformation =
                        if (newPasswordVisible)
                            VisualTransformation.None
                        else
                            PasswordVisualTransformation(),

                    trailingIcon = {
                        IconButton(
                            onClick = {
                                newPasswordVisible =
                                    !newPasswordVisible
                            }
                        ) {
                            Icon(
                                imageVector =
                                    if (newPasswordVisible)
                                        Icons.Default.Visibility
                                    else
                                        Icons.Default.VisibilityOff,
                                contentDescription =
                                    if (newPasswordVisible)
                                        "Hide password"
                                    else
                                        "Show password"
                            )
                        }
                    }
                )

                if (newPassword.isNotEmpty() && !isPasswordValid) {
                    Text(
                        text = "Password must contain at least 8 characters",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = {
                        confirmPassword = it
                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text("Confirm Password")
                    },
                    singleLine = true,
                    visualTransformation =
                        if (confirmPasswordVisible)
                            VisualTransformation.None
                        else
                            PasswordVisualTransformation(),

                    trailingIcon = {
                        IconButton(
                            onClick = {
                                confirmPasswordVisible =
                                    !confirmPasswordVisible
                            }
                        ) {
                            Icon(
                                imageVector =
                                    if (confirmPasswordVisible)
                                        Icons.Default.Visibility
                                    else
                                        Icons.Default.VisibilityOff,
                                contentDescription =
                                    if (confirmPasswordVisible)
                                        "Hide password"
                                    else
                                        "Show password"
                            )
                        }
                    },

                    isError =
                        confirmPassword.isNotEmpty() &&
                        !passwordsMatch
                )

                if (
                    confirmPassword.isNotEmpty() &&
                    !passwordsMatch
                ) {
                    Text(
                        text = "Passwords do not match",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        },

        confirmButton = {
            Button(
                onClick = {
                    onUpdatePassword(newPassword)
                },
                enabled = isValid
            ) {
                Text("Update Password")
            }
        },

        dismissButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text("Cancel")
            }
        }
    )
}

