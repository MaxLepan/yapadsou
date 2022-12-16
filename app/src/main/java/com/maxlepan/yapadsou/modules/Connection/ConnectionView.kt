package com.maxlepan.yapadsou.modules.Connection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.maxlepan.yapadsou.modules.Connection.Login.LoginView

@Composable
fun ConnectionView() {

    Column(
        Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFFF7F7F7))
    ) {
        LoginView()
    }

}

@Preview(showBackground = true)
@Composable
fun ConnectionViewPreview() {
    ConnectionView()
}