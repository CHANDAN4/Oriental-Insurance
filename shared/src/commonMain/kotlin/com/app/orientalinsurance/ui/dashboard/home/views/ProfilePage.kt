package com.app.orientalinsurance.ui.dashboard.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.RenderIntent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.app.orientalinsurance.ui.dashboard.home.viewmodel.HomeViewModel
import com.app.orientalinsurance.ui.font.mulishFontFamily
import com.app.orientalinsurance.ui.login.navigation.Login
import com.app.orientalinsurance.ui.splash.SplashScreen
import org.jetbrains.compose.resources.painterResource
import orientalinsurance.shared.generated.resources.Res
import orientalinsurance.shared.generated.resources.power_button
import orientalinsurance.shared.generated.resources.profile

@Composable
fun ProfilePage(homeViewModel: HomeViewModel, navController: NavController) {


    var isLogout by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth().background(Color(0xFFF2F2FF)).padding(16.dp)) {

        Spacer(modifier = Modifier.height(50.dp))
        Row(modifier = Modifier.fillMaxWidth().height(50.dp).padding(end = 15.dp)) {
            Text(
                modifier = Modifier.weight(1f).padding(start = 10.dp),
                text = "Profile",
                fontFamily = mulishFontFamily(),
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Left,
                color = Color.Black,
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(Res.drawable.power_button),
                contentDescription = "",
                modifier = Modifier.size(25.dp).clickable {
                    isLogout = true

                },
                contentScale = ContentScale.Fit
            )

        }


        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier.fillMaxSize().background(Color(0xFFF5F5F5))
        ) {

            Card(
                modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(Res.drawable.profile),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp).clip(CircleShape)
                    )

                    Spacer(Modifier.height(12.dp))

                    Column(modifier = Modifier.padding(16.dp)) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                modifier = Modifier.weight(.5f),
                                text = "Name",
                                fontFamily = mulishFontFamily(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                            Text(
                                text = ":",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                            Text(
                                modifier = Modifier.weight(1f),
                                text = "Chandan Singh",
                                color = Color.Gray,
                                fontSize = 14.sp,
                                fontFamily = mulishFontFamily(),
                                fontWeight = FontWeight.SemiBold,
                            )
                        }

                        Spacer(Modifier.height(6.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                modifier = Modifier.weight(.5f),
                                text = "Mobile No",
                                fontFamily = mulishFontFamily(),
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp
                            )
                            Text(
                                text = ":",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )

                            Text(
                                modifier = Modifier.weight(1f),
                                text = "+91-9767678660",
                                color = Color.Gray,
                                fontSize = 14.sp,
                                fontFamily = mulishFontFamily(),
                                fontWeight = FontWeight.SemiBold,
                            )
                        }

                        Spacer(Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                modifier = Modifier.weight(.5f),
                                text = "Email",
                                fontFamily = mulishFontFamily(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                            Text(
                                text = ":",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )

                            Text(
                                modifier = Modifier.weight(1f),
                                text = "ram@gmail.com",
                                color = Color.Gray,
                                fontSize = 14.sp,
                                fontFamily = mulishFontFamily(),
                                fontWeight = FontWeight.SemiBold,
                            )
                        }

                        Spacer(Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                modifier = Modifier.weight(.5f),
                                text = "Address",
                                fontFamily = mulishFontFamily(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                            Text(
                                text = ":",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                            Text(
                                modifier = Modifier.weight(1f),
                                text = "Ghaziabad-UP,Pin-201300\nGaur Siddhartha",
                                color = Color.Gray,
                                fontSize = 14.sp,
                                fontFamily = mulishFontFamily(),
                                fontWeight = FontWeight.SemiBold,
                            )
                        }

                        Spacer(Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                modifier = Modifier.weight(.5f),
                                text = "Role",
                                fontFamily = mulishFontFamily(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                            Text(
                                text = ":",
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                            Text(
                                modifier = Modifier.weight(1f),
                                text = "Employee",
                                color = Color.DarkGray,
                                fontSize = 14.sp,
                                fontFamily = mulishFontFamily(),
                                fontWeight = FontWeight.Bold,
                            )
                        }


                    }

                    Spacer(Modifier.height(15.dp))

                    Button(
                        onClick = {
                            // Handle click
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFC85100),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            "Edit Profile",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Bold,
                        )
                    }

                }
            }

        }


        if (isLogout) {
            LogoutDialog(
                onDismiss = {
                    isLogout = false
                },
                onLogout = {
                    isLogout = false
                    homeViewModel.settingsManager.saveIsLogin(false)
                }
            )
        }


    }

}


@Composable
fun LogoutDialog(
    onDismiss: () -> Unit,
    onLogout: () -> Unit
) {

    Dialog(
        onDismissRequest = onDismiss
    ) {

        Card(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {

            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(
                    imageVector = Icons.Default.Logout,
                    contentDescription = null,
                    tint = Color(0xFFC85100),
                    modifier = Modifier.size(60.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Logout",
                    style = MaterialTheme.typography.titleLarge,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Are you sure you want to logout?",
                    textAlign = TextAlign.Center,
                    fontFamily = mulishFontFamily(),
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            "Cancel",
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Bold,
                        )
                    }

                    Button(
                        onClick = onLogout,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFC85100)
                        )
                    ) {
                        Text(
                            "Logout",
                            color = Color.White,
                            fontFamily = mulishFontFamily(),
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}



