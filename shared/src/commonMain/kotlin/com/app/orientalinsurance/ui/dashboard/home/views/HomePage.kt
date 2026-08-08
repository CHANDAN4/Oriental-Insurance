package com.app.orientalinsurance.ui.dashboard.home.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.orientalinsurance.ui.dashboard.home.viewmodel.HomeViewModel
import com.app.orientalinsurance.ui.dashboard.navigations.Dashboards
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.utils.SetStatusBarColor
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import orientalinsurance.shared.generated.resources.Res
import orientalinsurance.shared.generated.resources.home_bike
import orientalinsurance.shared.generated.resources.home_car
import orientalinsurance.shared.generated.resources.home_claim_registration
import orientalinsurance.shared.generated.resources.home_health
import orientalinsurance.shared.generated.resources.home_irdai_governance
import orientalinsurance.shared.generated.resources.home_liability
import orientalinsurance.shared.generated.resources.home_marine
import orientalinsurance.shared.generated.resources.home_misc
import orientalinsurance.shared.generated.resources.home_motor
import orientalinsurance.shared.generated.resources.home_oicl_renewal
import orientalinsurance.shared.generated.resources.home_quick_pay
import orientalinsurance.shared.generated.resources.home_rural
import orientalinsurance.shared.generated.resources.home_travel
import orientalinsurance.shared.generated.resources.home_upload_document
import orientalinsurance.shared.generated.resources.logo

@Composable
fun HomePage(homeViewModel: HomeViewModel, navController: NavController) {

    val response by homeViewModel.responseProducts.collectAsState()

    SetStatusBarColor(
        color = Color(0xFF005BAC),
        darkIcons = false
    )
    LaunchedEffect(Unit) {
        // homeViewModel.getProductsList()

    }


   /* when (val result = response) {

        is ApiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is ApiState.Success -> {
            SurveyorAssessList(result.data, navController)
        }

        is ApiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = result.message)
            }
        }

        is ApiState.Empty -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No Data Found")
            }
        }


    }
*/

    Column(
        modifier = Modifier.fillMaxWidth().background(Color(0xFFF2F2FF)).verticalScroll(
        rememberScrollState()
    )) {
        Column {
            Spacer(modifier = Modifier.height(50.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier.weight(1f).height(60.dp),
                    painter = painterResource(Res.drawable.logo),
                    contentDescription = "",
                )
                Text(
                    modifier = Modifier.weight(.8f).padding(start = 10.dp),
                    text = "",
                    fontWeight = FontWeight.ExtraBold,
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            BannerSlider()

            Spacer(modifier = Modifier.height(15.dp))

            Column(modifier = Modifier.fillMaxWidth().padding(start = 15.dp, end = 15.dp)) {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    )
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFD2E6FF))
                            .padding(vertical = 14.dp, horizontal = 16.dp)
                    ) {
                        Text(
                            text = "Get Insurance Today",
                            style = MaterialTheme.typography.titleMedium,
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }

                    Column(modifier = Modifier.padding(20.dp)) {

                        Row {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_car),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Car\n",
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_bike),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Bike",
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_motor),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Motor",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_health),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Health",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Row {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_car),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Accident",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f).clickable{
                                    navController.navigate(Dashboards.ChoosePolicy.route)
                                }
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_travel),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Travel",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_rural),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Rural",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_marine),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Marine",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(5.dp))
                        Row {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_liability),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Liability",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_misc),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Misc",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {}

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {}

                        }

                    }
                }

                Spacer(modifier = Modifier.fillMaxWidth().height(15.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    )
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFD2E6FF))
                            .padding(vertical = 14.dp, horizontal = 16.dp)
                    ) {
                        Text(
                            text = "Services",
                            style = MaterialTheme.typography.titleMedium,
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }

                    Column(modifier = Modifier.padding(20.dp)) {

                        Row {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_quick_pay),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Quick Pay",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_oicl_renewal),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Quick Ren.",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_claim_registration),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Claim Reg.",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_upload_document),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )
                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "Upload Att.",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Row {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {

                                Image(
                                    painter = painterResource(Res.drawable.home_irdai_governance),
                                    contentDescription = "",
                                    modifier = Modifier.size(50.dp),
                                    contentScale = ContentScale.Fit
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(
                                    text = "IRDAI Gri.",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontFamily = mulishFontFamily(),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {
                            }

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(8.dp).weight(1f)
                            ) {
                            }
                        }

                        Spacer(modifier = Modifier.height(5.dp))
                    }

                }

                Spacer(modifier = Modifier.fillMaxWidth().height(100.dp))


            }

        }
    }

}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerSlider() {

    val banners = listOf(
        Res.drawable.logo,
        Res.drawable.logo,
        Res.drawable.logo,
        Res.drawable.logo,
        Res.drawable.logo
    )
    val pagerState = rememberPagerState(
        pageCount = { banners.size }
    )

    // Auto Slide
    LaunchedEffect(Unit) {

        while (true) {
            delay(3000)
            val nextPage = (pagerState.currentPage + 1) % banners.size
            pagerState.animateScrollToPage(nextPage)
        }

    }


    Card(
        modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column {

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 5.dp)
                    .aspectRatio(2.4f)
                    .height(180.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) { page ->

                Image(
                    painter = painterResource(banners[page]),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                repeat(banners.size) { index ->

                    Box(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .size(
                                if (pagerState.currentPage == index)
                                    10.dp
                                else
                                    8.dp
                            )
                            .clip(CircleShape)
                            .background(
                                if (pagerState.currentPage == index)
                                    Color(0xFF005BAC)
                                else
                                    Color.LightGray
                            )
                    )
                }
            }


        }
        Spacer(modifier = Modifier.height(10.dp))
    }

}








