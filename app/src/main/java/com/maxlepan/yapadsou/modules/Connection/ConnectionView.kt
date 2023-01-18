package com.maxlepan.yapadsou.modules.Connection

import android.os.Bundle
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
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.maxlepan.yapadsou.modules.AddPlan_desc.AddPlanDescView
import com.maxlepan.yapadsou.modules.AddPlan_desc.AddPlanPhotoView
import com.maxlepan.yapadsou.modules.Connection.Login.LoginView
import com.maxlepan.yapadsou.modules.Connection.Register.RegisterView
import com.maxlepan.yapadsou.modules.Home.Home
import com.maxlepan.yapadsou.modules.Onboarding.OnboardingView
import com.maxlepan.yapadsou.modules.Plan.PlanView
import com.maxlepan.yapadsou.modules.User.UserEdit
import com.maxlepan.yapadsou.providers.FirebaseManager

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
                OnboardingView {
                    navController.navigate("register")
                }
            }
            composable("register") {
                RegisterView(
                    navigateToLogin = {
                        navController.navigate("login")
                    },
                    navigateToHome = {userId ->
                        navController.navigate("home/${userId}")
                    }
                )


            }
            composable("login") {
                LoginView(
                    navigateToRegister = {
                        navController.navigate("register")
                    },
                    navigateToHome = {userId ->
                        navController.navigate("home/${userId}")
                    }
                )
            }
            composable("home/{userId}") { navBackStackEntry ->

                val userId = navBackStackEntry.arguments?.getString("userId")
                userId?.let {
                    Home(navController, userId)
                }
            }
            composable("add-plan-description/{userId}") { navBackStackEntry ->

                val userId = navBackStackEntry.arguments?.getString("userId")
                userId?.let {
                    AddPlanDescView(
                        navigateToAddPlanPhoto = {
                            navController.navigate("add-plan-photo/${userId}")
                        },
                        navController = navController,
                        userId = userId
                    )
                }
            }
            composable(
                "add-plan-photo/{userId}"
            ) { navBackStackEntry ->
                val userId = navBackStackEntry.arguments?.getString("userId")
                userId?.let {
                    AddPlanPhotoView(navController, userId)
                }
            }
            composable(
                "user-edit/{userId}"
            ) { navBackStackEntry ->

                val userId = navBackStackEntry.arguments?.getString("userId")
                userId?.let {
                    UserEdit(navController = navController, userId = userId) {
                        navController.navigate("home/${userId}")
                    }
                }
            }
            composable("item/{itemId}") { navBackStackEntry ->
                val itemId = navBackStackEntry.arguments?.getString("itemId")
                itemId?.let {
                    PlanView(navController = navController, planId = itemId)
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