package com.maxlepan.yapadsou.modules.Connection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maxlepan.yapadsou.modules.Connection.Login.LoginView
import com.maxlepan.yapadsou.modules.Connection.Register.RegisterView
import com.maxlepan.yapadsou.modules.Home.Home
import com.maxlepan.yapadsou.modules.Onboarding.OnboardingView

@Composable
fun ConnectionView() {

    val navController = rememberNavController()

    Column(
        Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFF7F7F7))
    ) {
        NavHost(navController = navController, startDestination = "onboarding") {
            composable("onboarding") {
                OnboardingView() {
                    navController.navigate("register")
                }
            }
            composable("register") {
                RegisterView() {
                    navController.navigate("login")
                }
            }
            composable("login") {
                LoginView() {
                    navController.navigate("register")
                }
            }
        }



    }

}

@Preview(showBackground = true)
@Composable
fun ConnectionViewPreview() {
    ConnectionView()
}