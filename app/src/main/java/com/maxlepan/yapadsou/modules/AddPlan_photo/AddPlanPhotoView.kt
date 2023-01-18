package com.maxlepan.yapadsou.modules.AddPlan_desc

import android.graphics.Bitmap
import android.graphics.BitmapFactory
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
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.maxlepan.yapadsou.R
import com.maxlepan.yapadsou.ui.components.BlueButtonView
import com.maxlepan.yapadsou.ui.components.Footer
import com.maxlepan.yapadsou.ui.theme.MediumBlue
import com.maxlepan.yapadsou.ui.theme.Typography

@Composable
fun AddPlanPhotoView(navController : NavHostController?) {
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
                        ) {
                            Column() {
                                Text(
                                    text = "Ajouter",
                                    color = Color.White,
                                    style = Typography.h2
                                )
                                Text(
                                    text = "Un bon plan pour en faire profiter les autres",
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
                        Row(
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(30.dp, 5.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color.LightGray)
                            )
                            Spacer(Modifier.width(10.dp))
                            Box(
                                modifier = Modifier
                                    .size(30.dp, 5.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(MediumBlue)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .padding(15.dp, 15.dp)
                                .fillMaxWidth(),

                            ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Photo du bon plan",
                                    color = Color(0xff1b191a),
                                    style = Typography.h3,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(0.dp, 0.dp, 0.dp, 5.dp),
                                    textAlign = TextAlign.Center
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
                            BlueButtonView(text = "Ajouter ce bon plan") {

                            }
                        }
                    }
                }
            },
            bottomBar = {
                Footer(
                    selected = 1,
                    navController = navController
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddPlanPhotoPreview() {
    AddPlanPhotoView(null)
}