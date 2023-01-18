package com.maxlepan.yapadsou.modules.AddPlan_desc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.maxlepan.yapadsou.R
import com.maxlepan.yapadsou.ui.components.BlueButtonView
import com.maxlepan.yapadsou.ui.components.CategoryCard
import com.maxlepan.yapadsou.ui.components.Footer
import com.maxlepan.yapadsou.ui.components.InputView
import com.maxlepan.yapadsou.ui.theme.Inter
import com.maxlepan.yapadsou.ui.theme.MediumBlue
import com.maxlepan.yapadsou.ui.theme.Typography

@Composable
fun AddPlanDescView(navController : NavHostController?, userId: String, navigateToAddPlanPhoto: () -> Unit) {
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }
    var link by remember { mutableStateOf(TextFieldValue("")) }
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
                                    .background(MediumBlue)
                            )
                            Spacer(Modifier.width(10.dp))
                            Box(
                                modifier = Modifier
                                    .size(30.dp, 5.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color.LightGray)
                            )
                        }
                        Column(
                            modifier = Modifier
                                .padding(15.dp, 15.dp)
                                .fillMaxWidth(),

                            ) {
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Titre",
                                    color = Color(0xff1b191a),
                                    style = Typography.h3,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(0.dp, 0.dp, 0.dp, 5.dp)
                                )
                                InputView(
                                    placeholder = "Abonnement 1 an - Basic-Fit",
                                    value = title,
                                    callback = { newTitle ->
                                        title = newTitle
                                    },
                                    isPassword = false,
                                    keyboardType = KeyboardType.Text
                                )
                            }
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Description",
                                    color = Color(0xff1b191a),
                                    style = Typography.h3,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(0.dp, 20.dp, 0.dp, 5.dp)
                                )
                                InputView(
                                    placeholder = "Ne soit pas trop bavard, on s’en fout, va à l’essentiel",
                                    value = description,
                                    callback = { newDescription ->
                                        description = newDescription
                                    },
                                    isPassword = false,
                                    keyboardType = KeyboardType.Text
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 20.dp)
                            ) {
                                Text(
                                    text = "Lien",
                                    color = Color(0xff1b191a),
                                    style = Typography.h3,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(0.dp, 20.dp, 0.dp, 5.dp)
                                )
                                InputView(
                                    placeholder = "www.lienverstonbonplan.com",
                                    value = link,
                                    callback = { newLink ->
                                        link = newLink
                                    },
                                    isPassword = false,
                                    keyboardType = KeyboardType.Uri
                                )
                            }
                            BlueButtonView(
                                text = "Suivant",
                                onClick = {
                                    navigateToAddPlanPhoto()
                                }
                            )
                        }
                    }
                }
            },
            bottomBar = {
                Footer(
                    selected = 1,
                    navController = navController,
                    userId = userId
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddPlanDescPreview(){
    AddPlanDescView(null, userId = ""){

    }
}