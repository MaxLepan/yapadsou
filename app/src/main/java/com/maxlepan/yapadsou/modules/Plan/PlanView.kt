package com.maxlepan.yapadsou.modules.Plan

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.firestore.ktx.toObject
import com.maxlepan.yapadsou.R
import com.maxlepan.yapadsou.models.ProductItem
import com.maxlepan.yapadsou.providers.FirebaseManager
import com.maxlepan.yapadsou.ui.components.BlueButtonView
import com.maxlepan.yapadsou.ui.theme.IntegralCF
import com.maxlepan.yapadsou.ui.theme.Inter
import com.maxlepan.yapadsou.ui.theme.Typography

@Composable
fun PlanView(navController: NavHostController?, planId: String) {
    val item = remember {
        mutableStateOf<ProductItem>(ProductItem())
    }
    FirebaseManager.getItemFromId(planId) {result ->
        result.toObject<ProductItem>()?.let {productItem ->
            println("### $productItem")
            item.value = productItem
        }
    }
    val uriHandler = LocalUriHandler.current

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 30.dp)
            .background(color = Color(0xfff7f7f7))
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(0.dp, 0.dp, 25.dp, 25.dp))
                    .fillMaxWidth()
                    .height(height = 246.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Group 23",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer(alpha = 0.99f)
                        .drawWithCache {
                            onDrawWithContent {
                                drawContent()
                                drawRect(
                                    Brush.horizontalGradient(
                                        colors = listOf(
                                            Color(0, 0, 0, 0xAA),
                                            Color(0, 0, 0, 0x33)
                                        )
                                    ), blendMode = BlendMode.SrcAtop
                                )
                            }
                        }
                )
                Column(
                    modifier = Modifier
                        .padding(end = 50.dp)
                ) {
                    Text(
                        text = item.value.title,
                        color = Color.White,
                        style = TextStyle(
                            fontFamily = IntegralCF,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = item.value.subTitle,
                        color = Color.White,
                        style = Typography.body2
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 30.dp
                    )
            ) {
                Spacer(
                    Modifier.height(30.dp)
                )
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(start = 20.dp, top = 20.dp, end = 20.dp, bottom = 30.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 23.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "author",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(30.dp)
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 11.dp, end = 20.dp)
                        ) {
                            Text(
                                text = "Proposé par",
                                style = Typography.caption,
                                color = Color.Gray
                            )
                            Text(
                                text = "Killian74",
                                style = TextStyle(
                                    fontFamily = Inter,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }
                        Row {
                            for (i in 1..5) {
                                var icon = R.drawable.ic_launcher_background
                                if (i > item.value.stars) { // on va remplacer 2 par item.stars
                                    icon = R.drawable.ic_launcher_foreground
                                }
                                Image(
                                    painter = painterResource(id = icon),
                                    contentDescription = icon.toString(),
                                    modifier = Modifier
                                        .size(20.dp)
                                        .padding(horizontal = 2.dp)
                                )
                            }
                        }
                    }
                    Text(
                        text = item.value.description,
                        style = TextStyle(
                            fontFamily = Inter,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }
                Text(
                    text = "testÉe PAR ${item.value.nbTest} GALÉRIENS",
                    color = Color(0xff1b191a),
                    style = Typography.h3,
                    modifier = Modifier
                        .padding(top = 17.dp)
                )
            }

        }
        Column(
            modifier = Modifier
                .padding(
                    horizontal = 30.dp
                )
        ) {
            BlueButtonView(text = "Profiter de l'offre") {
                uriHandler.openUri(item.value.lien)
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun PlanPreview() {
    PlanView(null, "")
}
