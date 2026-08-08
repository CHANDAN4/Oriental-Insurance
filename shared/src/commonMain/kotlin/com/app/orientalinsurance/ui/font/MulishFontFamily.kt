package com.app.orientalinsurance.ui.font

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import orientalinsurance.shared.generated.resources.Res
import orientalinsurance.shared.generated.resources.mulish_bold
import orientalinsurance.shared.generated.resources.mulish_extrabold
import orientalinsurance.shared.generated.resources.mulish_regular
import orientalinsurance.shared.generated.resources.mulish_semibold

@Composable
fun mulishFontFamily() = FontFamily(
    Font(Res.font.mulish_regular, FontWeight.Normal),
    Font(Res.font.mulish_extrabold, FontWeight.Medium),
    Font(Res.font.mulish_semibold, FontWeight.SemiBold),
    Font(Res.font.mulish_bold, FontWeight.Bold)
)