package com.maxlepan.yapadsou.modules.Connection.Login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxlepan.yapadsou.providers.FirebaseManager
import com.maxlepan.yapadsou.ui.components.BigTitleView
import com.maxlepan.yapadsou.ui.components.BlueButtonView
import com.maxlepan.yapadsou.ui.components.InputView
import com.maxlepan.yapadsou.ui.theme.Typography

@Composable
fun LoginView(navigateToRegister: () -> Unit, navigateToHome: () -> Unit) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }

    val h1 = "TE REVOILA !"
    val h2 = "Reviens vite pour profiter des bons plans"

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            Modifier
                .fillMaxWidth()
        ) {
            BigTitleView(h1, h2)

            InputView(placeholder = "Ton adresse e-mail", value = email, callback = { new ->
                email = new
            }, null)

            InputView(placeholder = "Ton mot de passe", value = password, callback = { new ->
                password = new
            }, null)

            Text(
                text = "Mot de passe oublié ?",
                style = Typography.body2,
                color = Color(0xFF747685),
                modifier = Modifier
                    .padding(top = 22.dp, bottom = 43.dp)
                    .align(Alignment.End)
            )


            BlueButtonView(text = "Se connecter") {
                FirebaseManager.connection(email = email.text, password = password.text) {
                    navigateToHome()
                }
            }


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 38.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Pas encore inscrit ?",
                style = Typography.body2,
                color = Color(0xFF747685)
            )
            ClickableText(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF5F67EA)
                        )
                    ) {
                        append(" Allez viens !")
                    }
                },
                style = Typography.body2,

                onClick = {
                    navigateToRegister()
                })

        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginViewPreview() {
    LoginView(navigateToHome = {}, navigateToRegister = {})
}