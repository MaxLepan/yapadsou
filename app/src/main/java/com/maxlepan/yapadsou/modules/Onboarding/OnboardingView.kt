package com.maxlepan.yapadsou.modules.Onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.maxlepan.yapadsou.ui.theme.*

@Composable
fun OnboardingView(){

    Column (
        Modifier
            .fillMaxSize()
            .background(MediumBlue)
    ) {
        Column (
            Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
                ) {
            Text(
                "PAS DE SOUS ?",
                color = Color.White
            )
            Text("Y'A PADSOU.",
                style = Typography.h1,
                color = Salmon
            )
        }
        Column (
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
                ) {
            Button(
                onClick = {

                }
            ) {
                Text(
                    "C'est parti!"
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    OnboardingView()
}