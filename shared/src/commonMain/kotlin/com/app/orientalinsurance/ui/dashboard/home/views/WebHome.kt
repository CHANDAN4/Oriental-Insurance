package com.app.orientalinsurance.ui.dashboard.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.orientalinsurance.ui.login.viewModel.LoginViewModel
import org.jetbrains.compose.resources.painterResource
import orientalinsurance.shared.generated.resources.Res
import orientalinsurance.shared.generated.resources.logo

@Composable
fun WebHome(loginViewModel: LoginViewModel,navController: NavController){

    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(horizontal = 20.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text("1800 118 485")

                Row {

                    Text("English")

                    Spacer(Modifier.width(20.dp))

                    Text("Login")
                }
            }
            NavigationBar()

            HeroSection()

            //ProductSection()

            //Footer()
        }

    }

}



@Composable
fun NavigationBar() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color(0xFF0058CC))
            .padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painterResource(Res.drawable.logo),
            "",
            modifier = Modifier.size(60.dp)
        )

        Spacer(Modifier.width(30.dp))

        Text(
            "About Us",
            color = Color.White
        )

        Spacer(Modifier.width(20.dp))

        Text(
            "Products",
            color = Color.White
        )

        Spacer(Modifier.weight(1f))

        Button(
            onClick = {}
        ) {
            Text("Login")
        }
    }
}


@Composable
fun HeroSection() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {

        Image(
            painter = painterResource(Res.drawable.logo),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(50.dp)
        ) {

            Text(
                "Miscellaneous Class D Insurance",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(16.dp))

            Text(
                "Your right way to buy the right Insurance",
                fontSize = 22.sp
            )

            Spacer(Modifier.height(30.dp))

            Button(
                onClick = {}
            ) {
                Text("Know More")
            }
        }
    }
}

