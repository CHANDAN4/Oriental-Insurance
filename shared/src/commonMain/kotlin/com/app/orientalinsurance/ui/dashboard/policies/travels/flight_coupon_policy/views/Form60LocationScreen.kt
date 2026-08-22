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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Form60LocationDetailScreen(
    flightViewModel: FlightViewModel,
    navHostController: NavHostController
) {

    //val uiState by flightViewModel.uiState.collectAsState()
    var roomNo by remember { mutableStateOf(flightViewModel.roomNo ?: "") }
    var floorNo by remember { mutableStateOf(flightViewModel.floorNo ?: "") }
    var nameOfPremises by remember { mutableStateOf(flightViewModel.nameOfPremises ?: "") }
    var blockName by remember { mutableStateOf(flightViewModel.blockName ?: "") }
    var streetNo by remember { mutableStateOf(flightViewModel.streetNo ?: "") }
    var state by remember { mutableStateOf(flightViewModel.state ?: "") }
    var city by remember { mutableStateOf(flightViewModel.city ?: "") }
    var pincode by remember { mutableStateOf(flightViewModel.pincode ?: "") }
    var telephonNo by remember { mutableStateOf(flightViewModel.telephonNo ?: "") }
    var mobileNo by remember { mutableStateOf(flightViewModel.mobileNo ?: "") }


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
            text = "Location Details",
            fontFamily = mulishFontFamily(),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            color = Color.Black,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = roomNo,
            onValueChange = { roomNo = it },

            modifier = Modifier
                .fillMaxWidth(),

            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Room No ")
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
                        append("Room No ")
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
            value = floorNo,
            onValueChange = { floorNo = it },

            modifier = Modifier
                .fillMaxWidth(),

            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Floor No ")
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
                        append("Floor No ")
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
            value = nameOfPremises,
            onValueChange = { nameOfPremises = it },
            modifier = Modifier
                .fillMaxWidth(),
            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Name of Premises ")
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
                        append("Name of Premises  ")
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
            value = blockName,
            onValueChange = { blockName = it },
            modifier = Modifier
                .fillMaxWidth(),
            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Block Name ")
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
                        append("Block Name  ")
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
            value = streetNo,
            onValueChange = { streetNo = it },
            modifier = Modifier
                .fillMaxWidth(),
            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Street No ")
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
                        append("Street No  ")
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
       /* Spacer(modifier = Modifier.height(15.dp))
        // STATE
        AddressDropdown(
            label = "State",
            items = uiState.states,
            selectedItem = uiState.selectedState,
            itemText = { it.name },
            enabled = !uiState.isLoadingStates,
            onItemSelected = {
               //call api
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        // CITY
        AddressDropdown(
            label = "City",
            items = uiState.cities,
            selectedItem = uiState.selectedCity,
            itemText = { it.name },
            enabled = uiState.selectedState != null &&
                    !uiState.isLoadingCities,
            onItemSelected = {
                viewModel.onCitySelected(it)
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        // PINCODE
        AddressDropdown(
            label = "Pincode",
            items = uiState.pincodes,
            selectedItem = uiState.selectedPincode,
            itemText = { it.code },
            enabled = uiState.selectedCity != null &&
                    !uiState.isLoadingPincodes,
            onItemSelected = {
                viewModel.onPincodeSelected(it)
            }
        )*/
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = telephonNo,
            onValueChange = { telephonNo = it },
            modifier = Modifier
                .fillMaxWidth(),
            // Hint
            placeholder = {
                Text(
                    buildAnnotatedString {
                        append("Telephone No ")
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
                        append("Telephone No ")
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
            value = mobileNo,
            onValueChange = { mobileNo = it },
            modifier = Modifier
                .fillMaxWidth(),
            // Hint
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
                        append("Mobile No  ")
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

        Spacer(modifier = Modifier.height(50.dp))
        Button(

            modifier = Modifier.fillMaxWidth().height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC85100), // Background color
                contentColor = Color.White          // Text color
            ),
            onClick = {
                navHostController.navigate(Form60Screen.Form60Transaction.rout)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> AddressDropdown(
    label: String,
    items: List<T>,
    selectedItem: T?,
    itemText: (T) -> String,
    enabled: Boolean = true,
    onItemSelected: (T) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            if (enabled) {
                expanded = !expanded
            }
        }
    ) {

        OutlinedTextField(
            value = selectedItem?.let(itemText) ?: "",
            onValueChange = {},
            readOnly = true,
            enabled = enabled,
            label = {
                Text(label)
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

            items.forEach { item ->

                DropdownMenuItem(
                    text = {
                        Text(
                            text = itemText(item)
                        )
                    },
                    onClick = {

                        onItemSelected(item)

                        expanded = false
                    }
                )
            }
        }
    }
}