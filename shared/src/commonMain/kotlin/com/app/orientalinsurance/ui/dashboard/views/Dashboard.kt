package com.app.orientalinsurance.ui.dashboard.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import orientalinsurance.shared.generated.resources.home
import orientalinsurance.shared.generated.resources.search
import com.app.orientalinsurance.ui.dashboard.navigations.DashBoardNavGraph
import com.app.orientalinsurance.ui.dashboard.home.viewmodel.HomeViewModel
import com.app.orientalinsurance.ui.dashboard.navigations.Dashboards
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import orientalinsurance.shared.generated.resources.Res
import orientalinsurance.shared.generated.resources.about_icon
import orientalinsurance.shared.generated.resources.user


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard() {

    val homeViewModel: HomeViewModel = koinInject()
    val flightViewModel: FlightViewModel = koinInject()

    val navController = rememberNavController()
    var selectedTab by remember {
        mutableStateOf(0)
    }
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val showBottomBar = currentRoute in listOf(
        Dashboards.HomePage.route,
        Dashboards.ProfilePage.route,
        Dashboards.AboutPage.route
    )

    Scaffold(
        containerColor = Color(0xFFF5F5F5),
        bottomBar = {
            if(showBottomBar){
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp
                    ),
                    color = Color.White,
                    shadowElevation = 12.dp
                ) {
                    NavigationBar(
                        containerColor = Color.Transparent,
                        tonalElevation = 0.dp
                    ) {

                        NavigationBarItem(
                            selected = selectedTab == 0,
                            onClick = {
                                selectedTab = 0
                                navController.navigate(Dashboards.HomePage.route) {
                                    launchSingleTop = true
                                }
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(Res.drawable.home),
                                    contentDescription = "Home",
                                    tint = Color.Gray,
                                    modifier = Modifier.size(30.dp)
                                )
                            },

                            label = {
                                Text("Home")
                            }
                        )

                        NavigationBarItem(
                            selected = selectedTab == 1,
                            onClick = {
                                selectedTab = 1
                                navController.navigate(Dashboards.ProfilePage.route) {
                                    launchSingleTop = true
                                }

                            },
                            icon = {
                                Icon(
                                    painter = painterResource(Res.drawable.user),
                                    contentDescription = "Profile",
                                    tint = Color.Gray,
                                    modifier = Modifier.size(30.dp)
                                )
                            },
                            label = {
                                Text("Profile")
                            }
                        )

                        NavigationBarItem(
                            selected = selectedTab == 2,
                            onClick = {
                                selectedTab = 2
                                navController.navigate(Dashboards.AboutPage.route) {
                                    launchSingleTop = true
                                }
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(Res.drawable.about_icon),
                                    contentDescription = "About",
                                    tint = Color.Gray,
                                    modifier = Modifier.size(30.dp)
                                )
                            },
                            label = {
                                Text("About")
                            }
                        )

                        /* NavigationBarItem(
                        selected = selectedTab == 3,
                        onClick = {
                            selectedTab = 3
                            navController.navigate(Dashboard.SettingPage.route) {
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(Res.drawable.settings),
                                contentDescription = "Setting",
                                tint = Color.Gray,
                                modifier = Modifier.size(30.dp)
                            )
                        },
                        label = {
                            Text("Setting")
                        }
                    )*/

                    }
                }
            }

        }
    ) { paddingValues ->

        Box(modifier = Modifier.fillMaxSize().padding(bottom = 50.dp)) {

            DashBoardNavGraph(homeViewModel,flightViewModel,navController)

        }
    }

}