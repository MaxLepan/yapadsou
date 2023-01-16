package com.maxlepan.yapadsou.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxlepan.yapadsou.R

@Composable
fun ProductCard() {
    Card(
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
                .width(width = 142.dp))
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
}