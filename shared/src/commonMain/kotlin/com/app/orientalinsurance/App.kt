package com.app.orientalinsurance

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.app.orientalinsurance.ui.login.navigation.LoginNavGraph
import com.app.orientalinsurance.ui.login.viewModel.LoginViewModel
import com.app.orientalinsurance.ui.splash.Screen
import com.app.orientalinsurance.ui.splash.SplashScreen
import kotlinx.coroutines.delay
import org.koin.compose.koinInject

@Composable
@Preview
fun App() {

    var currentScreen by remember {
        mutableStateOf(Screen.Splash)
    }


    LaunchedEffect(Unit) {

        delay(2000)
        currentScreen = Screen.Home

    }

    when(currentScreen){

        Screen.Splash ->{
            MaterialTheme {
                SplashScreen()
            }
        }

        Screen.Home -> {
            MaterialTheme {
                //val loginViewModel: LoginViewModel = koinViewModel()
                val loginViewModel: LoginViewModel = koinInject()
                val navController = rememberNavController()
                LoginNavGraph(loginViewModel,navController)
            }
        }


    }

}