package com.app.orientalinsurance.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.UIKitView
import androidx.compose.ui.window.Dialog
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCAction
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSSelectorFromString
import platform.UIKit.UIControlEventValueChanged
import platform.UIKit.UIDatePicker
import platform.UIKit.UIDatePickerMode
import platform.UIKit.UIDatePickerStyle
import platform.darwin.NSObject

@OptIn(ExperimentalForeignApi::class)
private class DatePickerTarget(
    private val onDateSelected: (String) -> Unit
) : NSObject() {

    @ObjCAction
    fun dateChanged(sender: UIDatePicker) {

        val formatter = NSDateFormatter().apply {
            dateFormat = "dd-MM-yyyy"
        }

        val selectedDate = formatter.stringFromDate(sender.date)

        onDateSelected(selectedDate)
    }
}

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun ShowDatePicker(
    show: Boolean,
    onDismiss: () -> Unit,
    onDateSelected: (String) -> Unit
) {
    if (!show) return

    Dialog(
        onDismissRequest = onDismiss
    ) {

        UIKitView(
            factory = {

                UIDatePicker().apply {

                    datePickerMode =
                        UIDatePickerMode.UIDatePickerModeDate

                    preferredDatePickerStyle =
                        UIDatePickerStyle.UIDatePickerStyleWheels

                    val target = DatePickerTarget { date ->

                        onDateSelected(date)
                        onDismiss()
                    }

                    addTarget(
                        target = target,
                        action = NSSelectorFromString("dateChanged:"),
                        forControlEvents = UIControlEventValueChanged
                    )
                }
            }
        )
    }
}



