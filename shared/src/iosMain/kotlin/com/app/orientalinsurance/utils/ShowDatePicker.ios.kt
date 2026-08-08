package com.app.orientalinsurance.utils

import androidx.compose.runtime.Composable
import platform.UIKit.UIDatePicker

@Composable
actual fun ShowDatePicker(
    show: Boolean,
    onDismiss: () -> Unit,
    onDateSelected: (String) -> Unit
) {
    UIDatePicker()
}