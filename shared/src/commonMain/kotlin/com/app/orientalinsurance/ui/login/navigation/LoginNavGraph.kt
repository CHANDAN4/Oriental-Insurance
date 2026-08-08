package com.app.orientalinsurance.ui.login.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.orientalinsurance.data.multiplateformData.SettingsManager
import com.app.orientalinsurance.getPlatform
import com.app.orientalinsurance.ui.dashboard.home.views.WebHome
import com.app.orientalinsurance.ui.dashboard.views.Dashboard
import com.app.orientalinsurance.ui.login.viewModel.LoginViewModel
import com.app.orientalinsurance.ui.login.views.ForgotPassword
import com.app.orientalinsurance.ui.login.views.LoginScreen
import com.app.orientalinsurance.ui.login.views.LoginWithUID
import com.app.orientalinsurance.ui.login.views.SignupScreen
import org.koin.compose.koinInject


@Composable
fun LoginNavGraph(loginViewModel: LoginViewModel,navController: NavHostController){

    val settingsManager: SettingsManager = koinInject()
    var initPath=""

    if(settingsManager?.getIsLogin()==true){
        initPath=Login.Dashboard.route
    }else{
        initPath=Login.Login1.route
    }
   /* if(getPlatform().name=="web"){
       initPath="web"
    }else{
        if(settingsManager?.getIsLogin()==true){
            initPath=Login.Dashboard.route
        }else{
            initPath=Login.Login1.route
        }
    }*/

    NavHost(navController = navController, startDestination = initPath){

        composable(route= Login.Login1.route){
            LoginScreen(loginViewModel,navController)
        }

        composable(route= Login.LoginWithUID.route){
            LoginWithUID(loginViewModel,navController)
        }

        composable(route= Login.SignupScreen.route){
            SignupScreen(loginViewModel,navController)
        }

        composable(route= Login.ForgotPassword.route){
            ForgotPassword(loginViewModel,navController)
        }

        composable(route= Login.ForgotPassword.route){
            ForgotPassword(loginViewModel,navController)
        }

        composable(route= Login.Dashboard.route){
            Dashboard()
        }

        composable(route= Login.Web.route){
            WebHome(loginViewModel,navController )
        }


    }



}


sealed class Login(val route: String){

    object Login1: Login("login_1")
    object LoginWithUID: Login("LoginWithUID")
    object SignupScreen: Login("SignupScreen")
    object ForgotPassword: Login("ForgotPassword")
    object Dashboard: Login("Dashboard")

    object Web: Login("web")


}