package com.maxlepan.yapadsou.ui.components

import android.widget.ImageView.ScaleType
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.maxlepan.yapadsou.R
import com.maxlepan.yapadsou.ui.theme.Inter
import com.maxlepan.yapadsou.ui.theme.Typography
import kotlin.text.Typography

@Composable
fun ProductCard(title:String, subTitle:String, imageProduct : String, iconUser : String, height: Int) {
    Column (
        modifier = Modifier
            .padding(bottom = 5.dp)
            .fillMaxWidth()
            .height(height = (height + 5).dp)
            ){
        Card(
            elevation = 0.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .height(height = (height*0.8 + height * 20/height).dp)
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight()
                    .background(color = Color.White)
                    .padding(7.dp)
            )
            {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((height/2 + (height/10)).dp)
                ){
                    var imageProductPainter = painterResource(id = R.drawable.ic_launcher_background)
                    if (imageProduct !== "") imageProductPainter = rememberAsyncImagePainter(imageProduct)
                    Image(
                        painter = imageProductPainter,
                        contentDescription = "image",
                        alignment = Alignment.Center,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height = (height/2).dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                    )
                    var imageUserPainter = painterResource(id = R.drawable.ic_launcher_background)
                    if (iconUser !== "") imageUserPainter = rememberAsyncImagePainter(iconUser)
                    Image(
                        painter = imageUserPainter,
                        contentDescription = "logo",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(size = (height/5.5).dp)
                            .align(Alignment.BottomCenter)
                            .border(3.dp, Color.White, CircleShape)
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 7.dp, end = 7.dp)
                ) {
                    Text(
                        text = title,
                        color = Color(0xff1b191a),
                        style = TextStyle(
                            fontFamily = Inter,
                            fontSize = (height/13).sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Text(
                        text = subTitle,
                        color = Color(0xff1b191a),
                        style = TextStyle(
                            fontFamily = Inter,
                            fontSize = (height/15.7).sp,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun ProductCardPreview() {
    ProductCard("Abonnement 1 an", "2 mois offerts", "", "", 105)
}