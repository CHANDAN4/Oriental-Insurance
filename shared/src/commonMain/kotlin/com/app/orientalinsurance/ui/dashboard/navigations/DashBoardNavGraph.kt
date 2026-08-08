package com.app.orientalinsurance.ui.dashboard.navigations

import ChoosePolicyScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.orientalinsurance.ui.dashboard.home.viewmodel.HomeViewModel
import com.app.orientalinsurance.ui.dashboard.home.views.AboutPage
import com.app.orientalinsurance.ui.dashboard.home.views.HomePage
import com.app.orientalinsurance.ui.dashboard.home.views.ProfilePage
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.viewmodel.FlightViewModel
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views.ChooseOfficeScreen
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views.CoverAmountScreen
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views.FlightDetailsScreen
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views.FlightPersonalDetailsScreen
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views.PolicyDetailsScreen
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views.ProposerDetailsScreen
import com.app.orientalinsurance.ui.dashboard.policies.travels.flight_coupon_policy.views.RightWayScreen

@Composable
fun DashBoardNavGraph(homeViewModel: HomeViewModel,flightViewModel: FlightViewModel, navController: NavHostController){


    NavHost(navController = navController, startDestination = Dashboards.HomePage.route){

        composable(route= Dashboards.HomePage.route){
            HomePage(homeViewModel,navController)
        }

        composable(route= Dashboards.ProfilePage.route){
            ProfilePage(homeViewModel,navController)
        }

        composable(route= Dashboards.AboutPage.route){
            AboutPage(homeViewModel,navController)
        }


        //Flight Coupon Policy
        composable(route= Dashboards.ChoosePolicy.route){
            ChoosePolicyScreen(homeViewModel, navController)
        }

        composable(route= Dashboards.RightWayScreen.route){
            RightWayScreen(flightViewModel, navController)
        }

        composable(route= Dashboards.FlightDetails.route){
            PolicyDetailsScreen(flightViewModel, navController)
        }

        composable(route= Dashboards.CoverAmount.route){
            CoverAmountScreen(flightViewModel, navController)
        }

        composable(route= Dashboards.ChooseOfficeScreen.route){
            ChooseOfficeScreen(flightViewModel, navController)
        }

        composable(route= Dashboards.FlightDetailsScreen.route){
            FlightDetailsScreen(flightViewModel, navController)
        }

        composable(route= Dashboards.ProposerDetailsScreen.route){
            ProposerDetailsScreen(flightViewModel, navController)
        }

        composable(route= Dashboards.PersonalDetails.route){
            FlightPersonalDetailsScreen(flightViewModel, navController)
        }


    }

}


sealed class Dashboards(val route: String){

    object HomePage: Dashboards("homePage")
    object ProfilePage: Dashboards("profilePage")
    object AboutPage: Dashboards("searchPage")



    //Bharat Darshan Policy
    object BharatDarshan : Dashboards("BharatDarshan")



    //Flight Coupon Policy
    object ChoosePolicy : Dashboards("choosePolicy")

    object RightWayScreen : Dashboards("RightWayScreen")

    object FlightDetails : Dashboards("FlightDetails")

    object CoverAmount : Dashboards("CoverAmount")

    object ChooseOfficeScreen : Dashboards("ChooseOfficeScreen")

    object FlightDetailsScreen : Dashboards("FlightDetailsScreen")

    object ProposerDetailsScreen : Dashboards("ProposerDetailsScreen")
    object PersonalDetails : Dashboards("PersonalDetails")



    //Overseas Medicalim Policy
    object OverseasMediclaim : Dashboards("OverseasMediclaim")



}