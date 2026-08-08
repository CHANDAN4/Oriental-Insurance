package com.app.orientalinsurance.ui.dashboard.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.orientalinsurance.ui.dashboard.home.viewmodel.HomeViewModel
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.utils.SetStatusBarColor

@Composable
fun AboutPage(homeViewModel: HomeViewModel, navController: NavController){

    val response by homeViewModel.responseProducts.collectAsState()

    SetStatusBarColor(
        color = Color(0xFF005BAC),
        darkIcons = false
    )

    LaunchedEffect(Unit){

    }
    Column( modifier = Modifier.fillMaxSize().background(Color(0xFFF2F2FF)).padding(16.dp)) {

        Column(modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState())) {

            Spacer(modifier = Modifier.height(50.dp))
            Column {
                Text(
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
                    text = "About",
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Left,
                    color = Color.Black,
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.fillMaxWidth().height(20.dp))

                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
                        text = "To be the most respected & preferred Non-Life Insurer in the markets we operate.\n" +
                                "To ensure that we :",
                        fontFamily = mulishFontFamily(),
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Left,
                        color = Color.Black,
                        fontSize = 16.sp
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Text(
                            text = "•",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(
                            text = "Act as a financially sound corporate entity with high business ethics.",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Text(
                            text = "•",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(
                            text = "Implement best human resource development practices to build a highly efficient, dedicated and motivated workforce with high morale and moral values.",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Text(
                            text = "•",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(
                            text = "Optimally utilize the information technology infrastructure.",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Text(
                            text = "•",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(
                            text = "Provide excellent customer service.",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Text(
                            text = "•",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(
                            text = "Run the business profitably through prudent underwriting and efficient & proper claim management.",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Text(
                            text = "•",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(
                            text = "Effectively manage our reinsurance operations",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Text(
                            text = "•",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(
                            text = "Effectively manage our investments for optimising yield",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Text(
                            text = "•",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(
                            text = "Have effective risk management systems",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Text(
                            text = "•",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(
                            text = "Improve the penetration of non-life insurance by proper underwriting, innovation & marketing",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Spacer(modifier = Modifier.fillMaxWidth().height(8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {

                        Text(
                            text = "•",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(end = 8.dp)
                        )

                        Text(
                            text = "To evolve as a vibrant & dynamic leading non-life insurer",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Spacer(modifier = Modifier.fillMaxWidth().height(100.dp))
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

    }

}