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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.navigation.Form60Screen
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.utils.ShowDatePicker

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Form60FatherDetailScreen(
    flightViewModel: FlightViewModel,
    navHostController: NavHostController
) {

    val responseSaveData by flightViewModel.responseSaveData.collectAsState()
    var firstName by remember { mutableStateOf(flightViewModel.firstNameF ?: "") }
    var middleNmae by remember { mutableStateOf(flightViewModel.middleNmaeF ?: "") }
    var surName by remember { mutableStateOf(flightViewModel.surNameF ?: "") }

    var isClick by remember { mutableStateOf(false) }
    val isEnable by remember(firstName, surName) {
        derivedStateOf {
            firstName.isNotBlank() && surName.isNotBlank()
        }
    }


    var selectedTitle by remember { mutableStateOf("Mr") }
    var expanded by remember { mutableStateOf(false) }
    val titles = listOf("Mr", "Mrs", "Miss")


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
            text = "Father's Name(In case of individual)",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            color = Color.Black,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(15.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            OutlinedTextField(
                value = selectedTitle,
                onValueChange = {},
                readOnly = true,
                // Hint
                placeholder = {
                    Text(
                        buildAnnotatedString {
                            append("Father Title ")
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
                            append("Father Title ")
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
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                titles.forEach { title ->
                    DropdownMenuItem(
                        modifier = Modifier.fillMaxWidth(),
                        text = {
                            Text(text = title)
                        },
                        onClick = {
                            selectedTitle = title
                            expanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },

            modifier = Modifier
                .fillMaxWidth(),

            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Father First Name ")
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
                        append("Father First Name ")
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
            value = middleNmae,
            onValueChange = { middleNmae = it },

            modifier = Modifier
                .fillMaxWidth(),

            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Father Middle Name ")
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
                        append("Father Middle Name ")
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
            value = surName,
            onValueChange = { surName = it },
            modifier = Modifier
                .fillMaxWidth(),
            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Father Sur Name ")
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
                        append("Father Sur Name  ")
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
            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC85100), // Background color
                contentColor = Color.White          // Text color
            ),
            onClick = {
                isClick = true
                navHostController.navigate(Form60Screen.Form60Location.rout)
            },
            shape = RoundedCornerShape(15)
        ) {
            Text(
                "Next",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(50.dp))



    }

}

