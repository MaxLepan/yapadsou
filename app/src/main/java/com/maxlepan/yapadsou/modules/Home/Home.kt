package com.maxlepan.yapadsou.modules.Home

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxlepan.yapadsou.R
import com.maxlepan.yapadsou.ui.theme.Inter
import com.maxlepan.yapadsou.ui.theme.Typography
import com.maxlepan.yapadsou.ui.components.CategoryCard
import com.maxlepan.yapadsou.ui.components.Footer

@Composable
fun Home() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .zIndex(1f)
    ) {
        Scaffold (
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(color = Color(0xff5f67ea))
                ) {
                    // titre + searchBar
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(33.dp, 0.dp, 33.dp, 35.dp)
                    ) {
                        // titre
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(0.dp, 58.dp, 0.dp, 45.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Column(){
                                Text(
                                    text = "COUCOU TOI,",
                                    color = Color.White,
                                    style = Typography.h2
                                )
                                Text(
                                    text = "T’es en manque de thunes ?",
                                    color = Color.White,
                                    style = Typography.subtitle1
                                )
                            }
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background),
                                contentDescription = "Ellipse 1",
                                modifier = Modifier
                                    .size(size = 45.dp)
                                    .clip(shape = CircleShape))
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = 56.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.White)
                                .padding(30.dp, 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background),
                                contentDescription = "Vector",
                                modifier = Modifier
                                    .size(size = 18.dp)
                            )
                            Text(
                                text = "Cherche un bon plan",
                                color = Color(0xffd2cece),
                                style = Typography.subtitle1,
                                modifier = Modifier
                                    .padding(start = 10.dp)
                            )

                        }

                    }

                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp))
                            .fillMaxWidth()
                            .heightIn(min = 700.dp)
                            .background(color = Color(0xfff7f7f7)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Row(
                            modifier = Modifier
                                .padding(25.dp, 30.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CategoryCard(title = "courses", color = Color(0xff605DF5), icon = R.drawable.shopping_icon)
                            CategoryCard(title = "sport", color = Color(0xffF4696A), icon = R.drawable.sport_icon)
                            CategoryCard(title = "trains", color = Color(0xff579BFE), icon = R.drawable.transport_icon)
                            CategoryCard(title = "soirées", color = Color(0xff7C8CF9), icon = R.drawable.party_icon)
                        }
                        Row(
                            modifier = Modifier
                                .padding(25.dp, 9.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Les PLANS du moment",
                                color = Color(0xff1b191a),
                                style = Typography.h3,
                                modifier = Modifier
                            )
                            Text(
                                text = "Voir tout",
                                color = Color(0xfffc6b68),
                                textAlign = TextAlign.End,
                                style = TextStyle(
                                    fontFamily = Inter,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold),
                                modifier = Modifier
                            )
                        }
                    }
                }
            },
            bottomBar = {
                Footer(
                    selected = 0
                )
            }
        )
    }
}

@Composable
fun ProductCard() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(width = 159.dp)
            .height(height = 162.dp)
    ) {
        Box(
            modifier = Modifier
                .width(width = 159.dp)
                .height(height = 162.dp)
                .background(color = Color.White))
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "image",
            modifier = Modifier
                .width(width = 144.dp)
                .height(height = 90.dp)
                .clip(shape = RoundedCornerShape(10.dp)))
        Text(
            text = "Giga MAXI Tacos",
            color = Color(0xff1b191a),
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .width(width = 142.dp)
                .height(height = 16.dp))
        Text(
            text = "5€99, dépêche toi !",
            color = Color(0xff1b191a),
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium),
            modifier = Modifier
                .width(width = 142.dp)
                .height(height = 13.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "logo",
            modifier = Modifier
                .size(size = 36.dp))
    }
}

@Composable
fun CategoryCard() {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(width = 57.dp)
    ) {
        Box(
            modifier = Modifier
                .size(size = 57.dp)
                .background(color = Color(0xff7c8cf9)))
        Spacer(
            modifier = Modifier
                .size(size = 24.dp))
        Spacer(
            modifier = Modifier
                .height(height = 26.dp))
        Text(
            text = "Soirées",
            color = Color(0xff7c8cf9),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .width(width = 72.dp)
                .height(height = 16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home()
}
