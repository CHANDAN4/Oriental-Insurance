import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.orientalinsurance.ui.dashboard.home.viewmodel.HomeViewModel
import com.app.orientalinsurance.ui.dashboard.navigations.Dashboards
import com.app.orientalinsurance.ui.font.mulishFontFamily

@Composable
fun ChoosePolicyScreen(homeViewModel: HomeViewModel, navController: NavHostController) {

    val policies = listOf(
        "Bharat Darshan Policy",
        "Flight Coupon Policy",
        "Overseas Mediclaim Policy"
    )

    Scaffold(

        topBar = {
            Surface(
                shadowElevation = 8.dp,
                color = Color(0xFFF2F2FF)
            ) {
                TopAppBar(
                    title = {
                        Text(
                            modifier = Modifier.fillMaxWidth().padding(start = 10.dp),
                            text = "Travel",
                            textAlign = TextAlign.Left,
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                    },
                    navigationIcon = {

                        IconButton(
                            onClick = {
                                navController.navigateUp()
                            }
                        ) {
                            Icon(
                                Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }

                    }
                )
            }

        }

    ) { padding ->

        Column(modifier = Modifier.fillMaxSize().background(Color(0xFFF2F2FF)).padding(padding)) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                modifier = Modifier.fillMaxWidth().padding(start = 15.dp),
                text = "Choose Travel Policy",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                color = Color.Black,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(50.dp))
            LazyColumn(modifier = Modifier.fillMaxWidth()) {

                items(policies) { policy ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .padding(horizontal = 15.dp),
                        onClick = {
                            when(policy){
                                "Bharat Darshan Policy"->{

                                }
                                "Flight Coupon Policy"->{
                                    navController.navigate(Dashboards.RightWayScreen.route)
                                }
                                "Overseas Mediclaim Policy"->{

                                }
                            }

                        },
                        shape = RoundedCornerShape(50.dp),
                        border = BorderStroke(
                            width = 1.dp,
                            color = Color(0xFFE0E0E0) // Gray border
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White // White background
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 0.dp // Optional: remove shadow
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = policy,
                                fontSize = 14.sp,
                                fontFamily = mulishFontFamily(),
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                }

            }

        }

    }

}