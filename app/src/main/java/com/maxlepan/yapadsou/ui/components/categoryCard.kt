package com.maxlepan.yapadsou.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxlepan.yapadsou.R
import com.maxlepan.yapadsou.modules.Home.Home
import com.maxlepan.yapadsou.ui.theme.Typography

@Composable
fun CategoryCard(title : String, color: Color, icon: Int) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(width = 79.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .width(width = 57.dp)
                .height(height = 57.dp)
                .background(color = color)
        ){
            Image(
                painter = painterResource(id = icon),
                contentDescription = icon.toString(),
                modifier = Modifier
                    .size(size = 26.dp))
        }
        Text(
            text = title,
            color = color,
            textAlign = TextAlign.Center,
            style = Typography.overline,
            modifier = Modifier
                .padding(top = 10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryCardPreview() {
    CategoryCard("Soirées", Color(0xff7c8cf9), R.drawable.party_icon)
}