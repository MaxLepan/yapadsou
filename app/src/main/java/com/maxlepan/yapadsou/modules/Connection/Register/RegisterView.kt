package com.maxlepan.yapadsou.modules.Connection.Register

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
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
fun RegisterView(navigateToLogin: () -> Unit, navigateToHome: () -> Unit) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }

    val h1 = "BIENVENUE"
    val h2 = "Inscris-toi pour avoir les meilleurs plans étudiants !"

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
            }, keyboardType = KeyboardType.Email, isPassword = false)

            InputView(placeholder =
              "Ton mot de passe", value = password, callback = { new ->
                password = new
            }, keyboardType = KeyboardType.Password, isPassword = true)


            InputView(placeholder = "Confirme ton mot de passe", value = confirmPassword, callback = { new ->
                confirmPassword = new
            }, keyboardType = KeyboardType.Password, isPassword = true)

            Text(

                text = "En t’inscrivant, tu acceptes les Conditions générales d’utilisation de Padsou",
                style = Typography.body2,
                color = Color(0xFF747685),
                modifier = Modifier.padding(top = 63.dp, bottom = 12.dp)
            )

            Box() {
                val context = LocalContext.current



                BlueButtonView(text = "S'enregistrer") {




                    FirebaseManager.registration(
                        email = email.text,
                        password = password.text,
                        confirmPassword = confirmPassword.text,
                        context = context,
                        callback = {
                            navigateToHome()
                        }
                    )
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
                text = "Déjà un compte ?",
                style = Typography.body2,
                color = Color(0xFF747685)
            )
            ClickableText(
                text = buildAnnotatedString{ withStyle(
                    style = SpanStyle(
                        color = Color(0xFF5F67EA)
                    )
                ) {
                    append(" Connecte-toi !")
                }},
                style = Typography.body2,

                onClick = {
                    navigateToLogin()
                })

        }
    }


}

@Preview(showBackground = true)
@Composable
fun RegisterViewPreview() {
    RegisterView(navigateToHome = {}, navigateToLogin = {})
}