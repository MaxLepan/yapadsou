package com.maxlepan.yapadsou.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxlepan.yapadsou.ui.theme.Typography



@Composable
fun BigTitleView(h1: String, h2: String) {


    Column {
        Text(
            text = h1,
            color = Color.Black,
            style = Typography.h1,
            textAlign = TextAlign.Center,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 26.dp, bottom = 13.dp)
        )
        Text(
            text = h2,
            color = Color.Black,
            style = Typography.h2,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 63.dp)

        )
    }
}


@Preview(showBackground = true)
@Composable
fun BigTitleViewPreview() {
    BigTitleView("Test h1", "Test h2")
}