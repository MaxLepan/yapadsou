package com.maxlepan.yapadsou.modules.Home

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
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

@Composable
fun Home() {
    // global Container
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xff5f67ea))
            .zIndex(1f)
    ) {
        // titre + searchBar
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(33.dp,0.dp,33.dp,35.dp)
        ) {
            // titre
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(0.dp,58.dp, 0.dp, 45.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column(){
                    Text(
                        text = "COUCOU TOI,",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = "T’es en manque de thunes ?",
                        color = Color.White,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium)
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
                    .padding(30.dp,0.dp),
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
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium),
                    modifier = Modifier
                        .padding(start = 10.dp)
                )

            }

        }

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(40.dp,40.dp,0.dp,0.dp))
                .fillMaxWidth()
                .heightIn(min = 700.dp)
                .background(color = Color(0xfff7f7f7)),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row(
                modifier = Modifier
                    .padding(25.dp, 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Les PLANS du moment",
                    color = Color(0xff1b191a),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                )
                Text(
                    text = "Voir tout",
                    color = Color(0xfffc6b68),
                    textAlign = TextAlign.End,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                )
            }
        }
        /*Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .zIndex(zIndex = 100f)
                .height(height = 78.dp)
                .padding(end = 2.dp,
                    top = 736.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(width = 377.dp)
                    .height(height = 78.dp)
                    .background(color = Color.Yellow))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(width = 175.dp)
                    .height(height = 49.dp)
                    .padding(start = 102.dp,
                        top = 752.dp)
                    .background(Color.Black)
            ) {
                Box(
                    modifier = Modifier
                        .size(size = 49.dp)
                        .background(color = Color(0xfff2f2f2)))
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Group 16",
                    colorFilter = ColorFilter.tint(Color(0xff5f67ea)),
                    modifier = Modifier
                        .width(width = 19.dp)
                        .height(height = 21.dp))
                Spacer(
                    modifier = Modifier
                        .width(width = 30.dp))
                Box(
                    modifier = Modifier
                        .size(size = 49.dp)
                        .background(color = Color(0xfff2f2f2)))
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Vector")
                Spacer(
                    modifier = Modifier
                        .width(width = 27.dp))
                Box(
                    modifier = Modifier
                        .size(size = 47.dp)
                        .background(color = Color(0xfff2f2f2)))
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Vector",
                    modifier = Modifier
                        .size(size = 26.dp))
            }
        }

        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .width(width = 327.dp)
                .height(height = 508.dp)
                .padding(start = 26.dp,
                    top = 444.dp)
        ) {
            ProductCard()
            ProductCard()
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
                    text = "Abonnement 1 an",
                    color = Color(0xff1b191a),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .width(width = 142.dp)
                        .height(height = 16.dp))
                Text(
                    text = "2 mois offerts ",
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
            ProductCard()
            ProductCard()
            ProductCard()
        }
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .width(width = 315.dp)
                .height(height = 162.dp)
                .padding(start = 33.dp,
                    top = 58.dp)
        ) {
            Text(
                text = "Coucou toi,",
                color = Color.White,
                style = TextStyle(
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .width(width = 204.dp)
                    .height(height = 26.dp))
            Text(
                text = "T’es en manque de thunes ?",
                color = Color.White,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .width(width = 222.dp)
                    .height(height = 22.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .width(width = 312.dp)
                    .height(height = 56.dp)
                    .padding(start = 33.dp,
                        top = 164.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(width = 312.dp)
                        .height(height = 56.dp)
                        .background(color = Color.White))
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Vector",
                    modifier = Modifier
                        .size(size = 18.dp))
                Spacer(
                    modifier = Modifier
                        .width(width = 11.dp))
                Text(
                    text = "Cherche un bon plan",
                    color = Color(0xffd2cece),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium),
                    modifier = Modifier
                        .width(width = 164.dp)
                        .height(height = 20.dp))
            }
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Ellipse 1",
                modifier = Modifier
                    .size(size = 45.dp)
                    .clip(shape = CircleShape))
        }
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(width = 57.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(size = 57.dp)
                    .background(color = Color(0xff605df5)))
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "material-symbols:shopping-bag-outline",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(size = 24.dp))
            Spacer(
                modifier = Modifier
                    .size(size = 24.dp))
            Spacer(
                modifier = Modifier
                    .height(height = 26.dp))
            Text(
                text = "Courses",
                color = Color(0xff605df5),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .width(width = 72.dp)
                    .height(height = 16.dp))
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .size(size = 57.dp)
                .padding(top = 284.dp)
        ) {
            CategoryCard()
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Vector",
                modifier = Modifier
                    .width(width = 18.dp)
                    .height(height = 21.dp))
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .size(size = 57.dp)
                .padding(top = 284.dp)
        ) {
            CategoryCard()
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "ph:train",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(size = 26.dp))
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .size(size = 57.dp)
                .padding(top = 284.dp)
        ) {
            CategoryCard()
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Group",
                modifier = Modifier
                    .width(width = 20.dp)
                    .height(height = 20.dp))
        }*/
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
