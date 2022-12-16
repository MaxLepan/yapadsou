package com.maxlepan.yapadsou.modules.Connection.Login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxlepan.yapadsou.ui.components.InputView

@Composable
fun LoginView() {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }

    val inputModifier:Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 40.dp, vertical = 10.dp)

    Column(
        Modifier
            .fillMaxWidth()
    ) {
        InputView(placeholder = "Ton adresse e-mail", value = email,callback = { new ->
            email = new
        })

        InputView(placeholder = "Ton mot de passe", value = password,callback = { new ->
            password = new
        })

        InputView(placeholder = "Confirme ton mot de passe", value = confirmPassword,callback = { new ->
            confirmPassword = new
        })
        
        

    }


}

@Preview(showBackground = true)
@Composable
fun LoginViewPreview() {
    LoginView()
}