package com.app.orientalinsurance.utils

import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
actual fun ShowDatePicker(
    show: Boolean,
    onDismiss: () -> Unit,
    onDateSelected: (String) -> Unit
) {

    if (show) {

        val state = rememberDatePickerState()

        DatePickerDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                Button(onClick = {

                    state.selectedDateMillis?.let {

                        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

                        onDateSelected(formatter.format(Date(it)))
                    }

                    onDismiss()

                }) {
                    Text("OK")
                }
            }
        ) {

            DatePicker(state = state)

        }
    }
}