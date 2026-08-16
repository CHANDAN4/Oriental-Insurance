package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.Content
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestBranchOffice
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestProposalCreate
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.RequestProposalQuote
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.models.ResponseChooseOffice
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.ui.login.models.RequestLogin
import kotlinx.coroutines.launch
import kotlin.text.get

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseOfficeScreen(flightViewModel: FlightViewModel, navController: NavHostController) {


    val responseChooseOffice by flightViewModel.responseChooseOffice.collectAsState()
    val responseCreate by flightViewModel.responseCreateFlight.collectAsState()

    var chooseCity by remember { mutableStateOf(flightViewModel.branchOffice ?: "") }
    var policySummary by remember { mutableStateOf(false) }

    var isClick by remember { mutableStateOf(false) }
    val isEnable by remember(chooseCity) {
        derivedStateOf {
            chooseCity.isNotBlank()
        }
    }
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    var primumBreakup by remember { mutableStateOf(false) }
    val sheetStatePA = rememberModalBottomSheetState()
    val scopePA = rememberCoroutineScope()

    LaunchedEffect(chooseCity) {
        val req = RequestBranchOffice(chooseCity)
        flightViewModel.chooseOffice(req)
    }



    when (val result = responseCreate) {

        is ApiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize().padding(top = 250.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                CircularProgressIndicator()
            }
        }

        is ApiState.Success -> {
            flightViewModel.branchOffice = chooseCity
            navController.navigate(Dashboards.FlightDetailsScreen.route)
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
                                        primumBreakup = false
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
                        modifier = Modifier.weight(1f).clickable {
                            primumBreakup = true
                            policySummary = false
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
                            val request = RequestProposalCreate(
                                branchAddress = flightViewModel?.branchAddress ?: "",
                                branchEmail = flightViewModel?.branchEmail ?: "",
                                branchOffice = flightViewModel?.branchOffice ?: "",
                                branchOfficeId = flightViewModel?.branchOfficeId ?: "",
                                officeCity = flightViewModel?.officeCity ?: "",
                                saveProposalFlag = false,
                                branchState = flightViewModel?.branchState ?: "",
                            )
                            flightViewModel.create(request, flightViewModel.id)
                        },
                        modifier = Modifier.width(150.dp)
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
                text = "Choose Office",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                color = Color.Black,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(50.dp))


            when (val res = responseChooseOffice) {

                is ApiState.Success -> {

                    val content = res.data.content
                    BranchSearchField(
                        content,
                        onBranchSelected = {
                            chooseCity = it.officeCity
                            flightViewModel.branchOffice = it.description
                            flightViewModel.branchOfficeId = it.code
                            flightViewModel.branchAddress = it.address
                            flightViewModel.branchEmail = it.officeEmail
                            flightViewModel.branchState = it.stateCode
                            flightViewModel.branchName = it.description
                            flightViewModel.branchCode_ = it.description
                            flightViewModel.officeCity = it.description

                        })

                }

                is ApiState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize().padding(top = 250.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is ApiState.Error -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = res.message,
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal,
                        )
                    }
                }

                else -> {

                }
            }


            if (chooseCity.isNotEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = chooseCity,
                    onValueChange = { chooseCity = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),

                    // Hint
                    placeholder = {
                        Text(
                            buildAnnotatedString {
                                append("Branch Address ")
                                withStyle(
                                    style = SpanStyle(color = Color.Red)
                                ) {
                                    append("")
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
                                append("Branch Address ")
                                withStyle(
                                    style = SpanStyle(color = Color.Red)
                                ) {
                                    append("")
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
                    PolicySummaryChooseOffice(flightViewModel)
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
                    PrimumSummaryChooseOffice(flightViewModel)
                }

            }

        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BranchSearchField(
    branches: List<Content>,
    onBranchSelected: (Content) -> Unit
) {

    var query by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    val filtered = remember(query) {
        if (query.isBlank()) {
            branches
        } else {
            branches.filter {
                it.officeCity.contains(query, true) ||
                        it.code.contains(query)
            }
        }
    }

    Column(modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {

            OutlinedTextField(
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                value = query,
                shape = RoundedCornerShape(12.dp),
                onValueChange = {
                    query = it
                    expanded = true
                },
                label = {
                    Text(
                        "Branch Code / Name / City",
                        fontFamily = mulishFontFamily(),
                        fontWeight = FontWeight.Normal
                    )
                },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded)
                }
            )

            ExposedDropdownMenu(
                expanded = expanded && filtered.isNotEmpty(),
                onDismissRequest = {
                    expanded = false
                }
            ) {

                filtered.forEach { branch ->

                    DropdownMenuItem(
                        text = {
                            Column {

                                Text(
                                    "${branch.code} : ${branch.officeCity}",
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Normal
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    branch.address,
                                    style = MaterialTheme.typography.bodySmall,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Normal
                                )

                            }
                        },
                        onClick = {

                            query = "${branch.code} : ${branch.officeCity}"

                            expanded = false

                            onBranchSelected(branch)
                        }
                    )
                }
            }
        }
    }

}


@Composable
fun PolicySummaryChooseOffice(flightViewModel: FlightViewModel) {

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
fun PrimumSummaryChooseOffice(flightViewModel: FlightViewModel) {

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
