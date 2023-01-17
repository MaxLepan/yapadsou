package com.maxlepan.yapadsou.modules.Onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
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
import com.maxlepan.yapadsou.R
import com.maxlepan.yapadsou.models.ProductItem
import com.maxlepan.yapadsou.ui.components.ProductCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingView(navigateToConnection: () -> Unit) {
    var productItems : List<ProductItem> = listOf(
        ProductItem(image = R.drawable.ic_launcher_background, user = R.drawable.ic_launcher_background, title = "", subTitle = ""),
        ProductItem(image = R.drawable.ic_launcher_background, user = R.drawable.ic_launcher_background, title = "", subTitle = ""),
        ProductItem(image = R.drawable.ic_launcher_background, user = R.drawable.ic_launcher_background, title = "titre", subTitle = "sous titre"),
        ProductItem(image = R.drawable.ic_launcher_background, user = R.drawable.ic_launcher_background, title = "titre", subTitle = "sous titre")
    )
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(MediumBlue)
            .padding(top = 70.dp, start = 55.dp, bottom = 50.dp, end = 55.dp)
    ) {
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
            LazyVerticalGrid(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                cells = GridCells.Fixed(2),
                modifier = Modifier
                    .clip(RoundedCornerShape(10))
                    .background(Color.White)
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp, bottom = 10.dp)
            ) {
                items(productItems.size) { index ->
                    ProductCard(
                        title = productItems[index].title,
                        subTitle = productItems[index].subTitle,
                        imageProduct = productItems[index].image,
                        iconUser = productItems[index].user,
                        height = 105
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
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 56.dp)
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
    OnboardingView{

    }
}