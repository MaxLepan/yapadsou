package com.maxlepan.yapadsou.modules.User

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.maxlepan.yapadsou.R
import com.maxlepan.yapadsou.ui.components.BlueButtonView
import com.maxlepan.yapadsou.ui.components.Footer
import com.maxlepan.yapadsou.ui.components.InputView
import com.maxlepan.yapadsou.ui.theme.MediumBlue
import com.maxlepan.yapadsou.ui.theme.Typography

@Composable
fun UserEdit(navController : NavHostController?, userId : String, navigateToHome : () -> Unit) {
    var userName by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val context = LocalContext.current
    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)
    }

    val launcher = rememberLauncherForActivityResult(
        contract =
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .zIndex(1f)
    ) {
        Scaffold(
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(color = Color(0xff5f67ea))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(33.dp, 0.dp, 33.dp, 35.dp)
                    ) {
                        // titre
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(0.dp, 58.dp, 0.dp, 0.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Column(){
                                Text(
                                    text = "Paramètres",
                                    color = Color.White,
                                    style = Typography.h2
                                )
                                Text(
                                    text = "Utilisateur",
                                    color = Color.White,
                                    style = Typography.subtitle1
                                )
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .clip(RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp))
                            .fillMaxWidth()
                            .heightIn(min = 700.dp)
                            .background(color = Color(0xfff7f7f7)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(15.dp, 15.dp)
                                .fillMaxWidth(),

                            ) {
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Nom d'utilisateur",
                                    color = Color(0xff1b191a),
                                    style = Typography.h3,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(0.dp, 20.dp, 0.dp, 5.dp)
                                )
                                InputView(
                                    placeholder = "Nom d'utilisateur",
                                    value = userName,
                                    callback = { newUserName ->
                                        userName = newUserName
                                    },
                                    isPassword = false,
                                    keyboardType = KeyboardType.Text
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Email",
                                    color = Color(0xff1b191a),
                                    style = Typography.h3,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(0.dp, 20.dp, 0.dp, 5.dp)
                                )
                                InputView(
                                    placeholder = "ton@email.com",
                                    value = email,
                                    callback = { newEmail ->
                                        email = newEmail
                                    },
                                    isPassword = false,
                                    keyboardType = KeyboardType.Email
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Photo de profil",
                                    color = Color(0xff1b191a),
                                    style = Typography.h3,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(0.dp, 20.dp, 0.dp, 5.dp)
                                )
                                Button(
                                    onClick = {
                                        launcher.launch("image/*")
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Color(0xFF5F67EA)
                                    ),
                                    modifier = Modifier
                                        .padding(20.dp)
                                        .size(150.dp)
                                ) {
                                    if (imageUri == null) {
                                        Image(
                                            painter = painterResource(id = R.drawable.plus_square),
                                            contentDescription = "plus_square"
                                        )
                                    } else {
                                        bitmap.value?.let { btm ->
                                            Image(
                                                bitmap = btm.asImageBitmap(),
                                                contentDescription = null
                                            )
                                        }
                                    }
                                }
                                imageUri?.let {
                                    if (Build.VERSION.SDK_INT < 28) {
                                        bitmap.value = MediaStore.Images
                                            .Media.getBitmap(context.contentResolver, it)

                                    } else {
                                        val source = ImageDecoder
                                            .createSource(context.contentResolver, it)
                                        bitmap.value = ImageDecoder.decodeBitmap(source)
                                    }
                                }
                            }
                            BlueButtonView(
                                text = "Sauvegarder",
                                onClick = {
                                    navigateToHome()
                                }
                            )
                        }
                    }
                }
            },
            bottomBar = {
                Footer(
                    selected = 2,
                    navController = navController,
                    userId = userId
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserEditPreview() {
    UserEdit(null, "") {}
}