package com.maxlepan.yapadsou.ui.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun BlueButtonView(text: String, onClick : () -> Unit) {

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF5F67EA)
        ),
        shape = RoundedCornerShape(15.dp),
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 18.dp)
                .fillMaxWidth()
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