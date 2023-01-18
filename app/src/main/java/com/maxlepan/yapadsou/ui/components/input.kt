package com.maxlepan.yapadsou.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maxlepan.yapadsou.R


@Composable
fun InputView(
    placeholder:String,
    value: TextFieldValue,
    callback:(TextFieldValue) -> Unit,
    icon: Int = -1,
    keyboardType: KeyboardType,
    isPassword: Boolean
) {
    var leadingIcon : @Composable (() -> Unit)? = null
    if (icon > 0) leadingIcon = {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "",
            modifier = Modifier
                .height(56.dp)
                .padding(start = 15.dp)
        )
    }
    TextField(
            value = value,
            onValueChange = callback,
            shape = RoundedCornerShape(20.dp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation =  if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Gray,
                disabledTextColor = Color.Transparent,
                backgroundColor = Color(0xFFFFFFFF),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
        ),
            placeholder = {
                Text(
                    text = placeholder,
                    color = Color(0xFFA6A6A6),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                )
            },
            leadingIcon = leadingIcon,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
    )





}

@Preview(showBackground = false)
@Composable
fun InputViewPreview() {
    var test by remember { mutableStateOf(TextFieldValue("")) }

    InputView(placeholder = "Test", value = test,callback = { new ->
        test = new
        println(test)
    }, keyboardType = KeyboardType.Email, icon = R.drawable.search_icon, isPassword = false)
}