package com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.utils.ShowDatePicker

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Form60TransactionDetailScreen(
    flightViewModel: FlightViewModel,
    navHostController: NavHostController,
    onComplete:()->Unit
) {

    val responseSaveData by flightViewModel.responseSaveData.collectAsState()
    var traAmt by remember { mutableStateOf(flightViewModel.traAmt ?: "") }
    var selectedTraDate by remember { mutableStateOf(flightViewModel.selectedTraDate ?: "") }
    var showPicker by remember {
        mutableStateOf(false)
    }
    var noOfPerson by remember { mutableStateOf(flightViewModel.noOfPerson ?: "") }
    var modeOfTran by remember { mutableStateOf(flightViewModel.modeOfTran ?: "") }
    var panCardAppNo by remember { mutableStateOf(flightViewModel.panCardAppNo ?: "") }
    var agricultureIncome by remember { mutableStateOf(flightViewModel.agricultureIncome ?: "") }
    var otherIncome by remember { mutableStateOf(flightViewModel.otherIncome ?: "") }
    var aadharNo by remember { mutableStateOf(flightViewModel.aadharNo ?: "") }


    var isClick by remember { mutableStateOf(false) }




    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFF2F2FF))
            .padding(start = 20.dp, end = 20.dp)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Transaction Details",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            color = Color.Black,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = traAmt,
            onValueChange = { traAmt = it },

            modifier = Modifier
                .fillMaxWidth(),

            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Transaction Amount ")
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
                        append("Transaction Amount ")
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
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = selectedTraDate,
            readOnly = true,
            onValueChange = {
                //selectedDateOfTravel = it
            },
            modifier = Modifier
                .fillMaxWidth(),
            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Transaction Date ")
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
                        append("Transaction Date  ")
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
            trailingIcon = {
                IconButton(
                    onClick = {
                        showPicker = true
                        // Open DatePicker here
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Calendar",
                        tint = Color.Gray
                    )
                }
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
        OutlinedTextField(
            value = noOfPerson,
            onValueChange = { noOfPerson = it },
            modifier = Modifier.fillMaxWidth(),

            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("No of Person Involved ")
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
                        append("No of Person Involved ")
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
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = modeOfTran,
            onValueChange = { modeOfTran = it },
            modifier = Modifier
                .fillMaxWidth(),
            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Mode of Transaction ")
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
                        append("Mode of Transaction  ")
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

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = panCardAppNo,
            onValueChange = { panCardAppNo = it },
            modifier = Modifier
                .fillMaxWidth(),
            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Pan-Card Application No ")
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
                        append("Pan-Card Application No  ")
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

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = agricultureIncome,
            onValueChange = { agricultureIncome = it },
            modifier = Modifier
                .fillMaxWidth(),
            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Agriculture Income ")
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
                        append("Agriculture Income  ")
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

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = otherIncome,
            onValueChange = { otherIncome = it },
            modifier = Modifier
                .fillMaxWidth(),
            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Other Income ")
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
                        append("Other Income  ")
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

        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = aadharNo,
            onValueChange = { aadharNo = it },
            modifier = Modifier
                .fillMaxWidth(),
            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Aadhaar No ")
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
                        append("Aadhaar No  ")
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
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC85100), // Background color
                contentColor = Color.White          // Text color
            ),
            onClick = {
                isClick = true
                onComplete()
            },
            shape = RoundedCornerShape(15)
        ) {
            Text(
                "Generate Form 60",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        ShowDatePicker(
            show = showPicker,
            onDismiss = {
                showPicker = false
            },
            onDateSelected = {
                selectedTraDate = it
            }
        )

    }

}

