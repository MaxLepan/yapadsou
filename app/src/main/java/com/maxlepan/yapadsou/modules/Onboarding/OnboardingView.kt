package com.maxlepan.yapadsou.modules.Onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.maxlepan.yapadsou.ui.theme.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingView(navigateToConnection: () -> Unit) {

    Column(
        Modifier
            .fillMaxSize()
            .background(MediumBlue)
    ) {
        Spacer(Modifier.height(100.dp))
        Column(
            Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "PAS DE SOUS ?",
                color = Color.White,
                style = Typography.h1
            )
            Text(
                "Y'A PADSOU.",
                style = Typography.h1,
                color = Salmon
            )
            Spacer(Modifier.height(80.dp))
        }
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(30.dp, 5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Box(
                    modifier = Modifier
                        .size(30.dp, 5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Box(
                    modifier = Modifier
                        .size(30.dp, 5.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                )
            }
            Spacer(Modifier.height(35.dp))
            Column(
                Modifier
                    .clip(RoundedCornerShape(10))
                    .background(Color.White)
                    .padding(20.dp)
            ) {
                Row {
                    Box(
                        Modifier
                            .size(105.dp)
                            .clip(RoundedCornerShape(10))
                            .background(Color.LightGray)
                    )
                    Spacer(Modifier.size(20.dp))
                    Box(
                        Modifier
                            .size(105.dp)
                            .clip(RoundedCornerShape(10))
                            .background(Color.LightGray)
                    )
                }
                Spacer(Modifier.size(20.dp))
                Row {
                    Box(
                        Modifier
                            .size(105.dp)
                            .clip(RoundedCornerShape(10))
                            .background(Color.LightGray)
                    )
                    Spacer(Modifier.size(20.dp))
                    Box(
                        Modifier
                            .size(105.dp)
                            .clip(RoundedCornerShape(10))
                            .background(Color.LightGray)
                    )
                }
            }
            Spacer(Modifier.height(20.dp))
            Text(
                text = "Accède aux 500 bons plans qu’on te propose chaque mois",
                color = Color.White,
                modifier = Modifier.width(260.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(Modifier.height(80.dp))
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    navigateToConnection()
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Salmon
                ),
                shape = RoundedCornerShape(25)
            ) {
                Text(
                    "C'EST PARTI!",
                    color = Color.White,
                    style = Typography.h1,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(30.dp, 5.dp)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    OnboardingView {

    }
}