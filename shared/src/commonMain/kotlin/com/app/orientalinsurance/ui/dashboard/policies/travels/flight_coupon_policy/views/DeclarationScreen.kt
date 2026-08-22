package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.app.orientalinsurance.data.network.ApiState
import com.app.orientalinsurance.ui.dashboard.navigations.Dashboards
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestProposalAdditionalDetails
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.utils.ShowDatePicker
import io.ktor.websocket.Frame
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.Resource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import orientalinsurance.shared.generated.resources.Res
import orientalinsurance.shared.generated.resources.shield
import kotlin.js.JsExport
import kotlin.time.Duration.Companion.minutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeclarationScreen(
    flightViewModel: FlightViewModel,
    navController: NavHostController
) {



    var isUnderstandAndAgree by remember { mutableStateOf(false) }
    var isClick by remember { mutableStateOf(false) }

    var policySummary by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()

    var primumBreakup by remember { mutableStateOf(false) }
    val sheetStatePA = rememberModalBottomSheetState()
    val scopePA = rememberCoroutineScope()

    //Kyc
    var isSheetOpen by remember { mutableStateOf(true) }


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
                        modifier = Modifier.weight(1f)
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


        Column(modifier = Modifier.fillMaxSize().background(Color.White)) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Declaration",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = mulishFontFamily(),
                    textAlign = TextAlign.Left,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {

                    Spacer(modifier = Modifier.height(10.dp))

                    Column(modifier = Modifier.fillMaxWidth()) {

                        Text(
                            modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
                            text = "GENERAL DECLARATION:",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Left,
                            color = Color.Black,
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
                            text = "I/we hereby declare that the above statements and answers are true and correct and that no material fact has been withheld/misrepresented and that I/we agree that this proposal-cum-policy schedule and this declaration shall be the basis of the contract between me/us and Oriental Insurance Company whose standard policy terms and exceptions are acceptable to me/us.",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Left,
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
                            text = "PROHIBITION OF REBATES (Section 41 of the Insurance Act 1938 provides):",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Left,
                            color = Color.Black,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
                            text = "No person shall allow, or offer to allow, either directly or indirectly, as an inducement to any person to take out or renew or continue an insurance in respect of any kind of risk relating to lives or property in India, any rebate of the whole or part of the commission payable or any rebate of the premium shown on the policy, nor shall any person taking out or renewing or continuing a policy accept any rebate except such rebate as may be allowed in accordance with the published prospectus or tables of the Insurer. Any person making default in complying with the provisions of this section shall be liable for a penalty which may extend to ten lakh rupees.",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Left,
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = isUnderstandAndAgree,
                                onCheckedChange = {
                                    isUnderstandAndAgree = it
                                },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = if (isUnderstandAndAgree) Color.Blue else Color.Gray,
                                    uncheckedColor = if (isUnderstandAndAgree) Color.Green else Color.Gray
                                ),
                                modifier = Modifier.size(25.dp),
                            )
                            Text(
                                text = "I understand and agree with the above statements",
                                modifier = Modifier
                                    .padding(start = 10.dp)
                                    .weight(1f),
                                fontSize = 13.sp,
                                lineHeight = 12.sp,
                                color = Color.Black,
                                fontFamily = mulishFontFamily(),
                                fontWeight = FontWeight.Medium
                            )
                        }

                    }

                    if (!isUnderstandAndAgree && isClick) {
                        Text(text = "Please accept term & conditions.", color = Color.Red)
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                    Spacer(modifier = Modifier.height(200.dp))

                }

            }

        }


    }


    var isSheetOpen1 by remember { mutableStateOf(true) }
    //scope1 = viewModel?.openOtpSheet!!.value

    val scope1 = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState()

    if (isSheetOpen1) {
        ModalBottomSheet(
            sheetState = bottomSheetState,
            onDismissRequest = {
                scope1.launch {
                    if (!bottomSheetState.isVisible) {
                        bottomSheetState.show()
                    }
                }
            },
            modifier = Modifier.height(650.dp)
        ) {
            val codeLength = 4
            val emailCodeLength = 4

            val codes = remember { mutableStateListOf<String>().apply { repeat(codeLength) { add("") } } }
            val emailOtp = remember { mutableStateListOf<String>().apply { repeat(emailCodeLength) { add("") } } }
            var mobileInitialTime by remember {
                mutableLongStateOf(2.minutes.inWholeMilliseconds)
            }
            val (mobileTimeRemaining, mobileSetTimeRemaining) = remember {
                mutableLongStateOf(
                    mobileInitialTime
                )
            }
            var showMobileTimer by remember { mutableStateOf(true) }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
                    .padding(16.dp)
            ) {

                Text(
                    text = "Confirm Your Declaration",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
                Text(text = "We have sent an otp to your email id and phone numbe")
                Spacer(modifier = Modifier.height(10.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    val focusRequesters = remember { List(4) { FocusRequester() } }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(15.dp),
                        modifier = Modifier.padding(10.dp)
                    ) {
                        for (i in 0 until codeLength) {
                            OutlinedTextField(
                                value = codes[i],
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Number
                                ),
                                onValueChange = {
                                    try {
                                        if (it.length <= 1) {
                                            codes[i] = it
                                            if (i < 3 && it != "") {
                                                focusRequesters[i + 1].requestFocus()
                                            }
                                        }
                                    } catch (e: Throwable) {

                                    }
                                },
                                singleLine = true,
                                modifier = Modifier
                                    .size(60.dp)
                                    .focusRequester(focusRequesters[i]),
                                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                            )

                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row {
                        if (showMobileTimer) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically

                            ) {
                                LaunchedEffect(true) {
                                    /*object : CountDownTimer(mobileTimeRemaining, 1000) {
                                        override fun onTick(millisUntilFinished: Long) {
                                            mobileSetTimeRemaining(millisUntilFinished)
                                        }

                                        override fun onFinish() {
                                            showMobileTimer = false

                                        }
                                    }.start()*/
                                }

                                val minutes = mobileTimeRemaining / 60_000L
                                val seconds = (mobileTimeRemaining / 1_000L) % 60

                                Text(
                                    text = "Don't you receive any code? "
                                )

                                Text(
                                    color = Color.Blue,
                                    fontWeight = FontWeight.Bold,
                                    text = "${minutes.toString().padStart(2, '0')}:${
                                        seconds.toString().padStart(2, '0')
                                    }"
                                )

                            }
                        } else {
                            Text(text = "Don't you receive any code? ")
                            Text(
                                text = "Resend OTP",
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline,
                                modifier = Modifier.clickable {
                                    showMobileTimer = true
                                    mobileInitialTime = 2.minutes.inWholeMilliseconds
                                    mobileSetTimeRemaining(mobileInitialTime)

                                   /* val requestMobile = RequestDeclaration(
                                        viewModel.emailId ?: "",
                                        viewModel.mobileNo ?: ""
                                    )
                                    viewModel.getResendDeclarationVerifyOtp(
                                        requestMobile,
                                        navController
                                    )

*/
                                })
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    androidx.compose.material3.Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp), onClick = {


                        }, colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                            Color.Blue
                        ), shape = RoundedCornerShape(10.dp) // Set the corner radius here

                    ) {
                        androidx.compose.material3.Text(
                            text = "Verify",
                            fontSize = 18.sp,
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                }

            }
        }
        Spacer(modifier = Modifier.height(40.dp))
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
            PolicySummaryDeclaration(flightViewModel)
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
            PremiumSummaryDeclaration(flightViewModel)
        }

    }


}


@Composable
fun PolicySummaryDeclaration(flightViewModel: FlightViewModel) {

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

@Composable
fun PremiumSummaryDeclaration(flightViewModel: FlightViewModel) {

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
                text = "₹${flightViewModel.basicPreAmt}",
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
                text = "₹${flightViewModel.minPreAmt}",
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
                text = "₹${flightViewModel.gst}",
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
                text = "₹${flightViewModel.totalAmt}",
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
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            OutlinedButton(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(end = 5.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    Color.White,
                    contentColor = Color.Black
                ),
                onClick = {


                }) {
                Icon(
                    imageVector = Icons.Filled.Download,
                    tint = Color.Gray,
                    contentDescription = "Download"
                )
                Text(
                    textAlign = TextAlign.Left,
                    text = " Download Quote",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray,
                )
            }

            OutlinedButton(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(end = 5.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    Color.White,
                    contentColor = Color.Black
                ),
                onClick = {

                }) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    tint = Color.Gray,
                    contentDescription = "  Share"
                )
                Text(
                    textAlign = TextAlign.Left,
                    text = "  Share Quote",
                    fontFamily = mulishFontFamily(),
                    fontSize = 14.sp,
                    color = Color.Gray,
                )
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}




