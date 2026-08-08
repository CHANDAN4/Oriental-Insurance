package com.app.orientalinsurance.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.utils.SetStatusBarColor
import org.jetbrains.compose.resources.painterResource
import orientalinsurance.shared.generated.resources.Res
import orientalinsurance.shared.generated.resources.launcher_icon_round

@Composable
fun SplashScreen() {

    SetStatusBarColor(
        color = Color(0xFF005BAC),
        darkIcons = false
    )

    Box(
        modifier = Modifier.fillMaxSize()/*.background(Color(0xFF0057B8))*/,
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(Res.drawable.launcher_icon_round),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )

            Spacer(Modifier.height(20.dp))

            Text(
                "Oriental Insurance",
                color =  Color(0xFF0057B8),
                fontSize = 24.sp,
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
            )
        }
    }
}