package com.app.orientalinsurance.utils

import androidx.compose.runtime.Composable

@Composable
expect fun ShowDatePicker(
    show: Boolean,
    onDismiss: () -> Unit,
    onDateSelected: (String) -> Unit
)