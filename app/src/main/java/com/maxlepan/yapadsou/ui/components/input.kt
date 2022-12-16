package com.maxlepan.yapadsou.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputView(placeholder:String, value: TextFieldValue, callback:(TextFieldValue) -> Unit, icon: Icon?) {

    TextField(
            value = value,
            onValueChange = callback,
            shape = RoundedCornerShape(20.dp),
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 10.dp),
        leadingIcon = {
            // NE FONCTIONNE PAS A REVOIR
            icon
        }


    )





}

@Preview(showBackground = true)
@Composable
fun InputViewPreview() {
    var test by remember { mutableStateOf(TextFieldValue("")) }

    InputView(placeholder = "Test", value = test,callback = { new ->
        test = new
        println(test)
    })
}