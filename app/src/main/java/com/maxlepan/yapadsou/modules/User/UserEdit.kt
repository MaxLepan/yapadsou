package com.maxlepan.yapadsou.modules.User

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxlepan.yapadsou.R

@Composable
fun UserEdit() {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .width(width = 375.dp)
            .height(height = 812.dp)
            .background(color = Color(0xfff7f7f7))
    ) {
        Box(
            modifier = Modifier
                .width(width = 377.dp)
                .height(height = 78.dp)
                .background(color = Color.White))
        Box(
            modifier = Modifier
                .width(width = 380.dp)
                .height(height = 812.dp)
                .background(color = Color(0xff5f67ea)))
        Box(
            modifier = Modifier
                .width(width = 375.dp)
                .height(height = 810.dp)
                .background(color = Color(0xfff7f7f7)))
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .width(width = 313.dp)
                .height(height = 148.dp)
                .padding(start = 29.dp,
                    top = 357.dp)
        ) {
            Text(
                text = "DESCRIPTION",
                color = Color(0xff1b191a),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .width(width = 226.dp)
                    .height(height = 22.dp))
            Spacer(
                modifier = Modifier
                    .height(height = 7.dp))
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier
                    .width(width = 313.dp)
                    .height(height = 119.dp)
                    .padding(start = 29.dp,
                        top = 386.dp)
            ) {
                Box(
                    modifier = Modifier
                        .width(width = 313.dp)
                        .height(height = 119.dp)
                        .background(color = Color.White))
                Text(
                    text = "Ne soit pas trop bavard, on s’en fou, va à l’essentiel",
                    color = Color(0xffa6a6a6),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium),
                    modifier = Modifier
                        .width(width = 251.dp)
                        .height(height = 36.dp))
            }
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .width(width = 313.dp)
                .height(height = 81.dp)
                .padding(start = 29.dp,
                    top = 535.dp)
        ) {
            Text(
                text = "LIEN",
                color = Color(0xff1b191a),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .width(width = 226.dp)
                    .height(height = 22.dp))
            Spacer(
                modifier = Modifier
                    .height(height = 7.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("www.lienverstonbonplan.com") },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xffa6a6a6),
                    backgroundColor = Color.White),
                modifier = Modifier
                    .padding(all = 49.10107421875.dp))
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .width(width = 313.dp)
                .height(height = 74.dp)
                .padding(start = 29.dp,
                    top = 251.dp)
        ) {
            Text(
                text = "TITRE",
                color = Color(0xff1b191a),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .width(width = 226.dp)
                    .height(height = 22.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Abonnement 1 an Basic-Fit") },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xffa6a6a6),
                    backgroundColor = Color.White),
                modifier = Modifier
                    .padding(all = 49.10107421875.dp))
        }
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("suivant") },
            textStyle = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                backgroundColor = Color(0xff5f67ea)),
            modifier = Modifier
                .padding(all = 68.dp))
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .width(width = 275.dp)
                .height(height = 61.dp)
                .padding(top = 58.dp)
        ) {
            Text(
                text = "AJOUTER",
                color = Color.White,
                style = TextStyle(
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .width(width = 275.dp)
                    .height(height = 26.dp))
            Spacer(
                modifier = Modifier
                    .height(height = 13.dp))
            Text(
                text = "Un bon plan pour en faire profiter les autres",
                color = Color.White,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium),
                modifier = Modifier
                    .width(width = 244.dp)
                    .height(height = 22.dp))
        }
        Box(
            modifier = Modifier
                .width(width = 46.dp)
                .height(height = 7.dp)
                .background(color = Color(0xffbabfcd)))
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Vector",
            modifier = Modifier
                .width(width = 16.dp)
                .height(height = 22.dp))
        Spacer(
            modifier = Modifier
                .size(size = 24.dp))
        Box(
            modifier = Modifier
                .width(width = 46.dp)
                .height(height = 7.dp)
                .background(color = Color(0xffbabfcd)))
    }
}

@Preview(showBackground = true)
@Composable
fun UserEditPreview() {
    UserEdit()
}