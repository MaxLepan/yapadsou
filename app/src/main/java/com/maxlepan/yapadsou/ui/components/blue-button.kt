package com.maxlepan.yapadsou.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxlepan.yapadsou.ui.theme.*


@Composable
fun BlueButtonView(text: String, onClick : () -> Unit) {

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF5F67EA)
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .height(height = 56.dp)
    ) {
        Text(
            text = text,
            style = Typography.button,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 3.dp)
                .align(Alignment.CenterVertically)
        )
    }

}


@Preview(showBackground = true)
@Composable
fun BlueButtonPreview() {
    BlueButtonView("Button", onClick = {
        println("Do nothing")
    })
}