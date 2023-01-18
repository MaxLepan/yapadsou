package com.maxlepan.yapadsou.modules.Home

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
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
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.google.firebase.firestore.ktx.toObject
import com.maxlepan.yapadsou.R
import com.maxlepan.yapadsou.models.ProductItem
import com.maxlepan.yapadsou.models.User
import com.maxlepan.yapadsou.providers.FirebaseManager
import com.maxlepan.yapadsou.ui.theme.Inter
import com.maxlepan.yapadsou.ui.theme.Typography
import com.maxlepan.yapadsou.ui.components.CategoryCard
import com.maxlepan.yapadsou.ui.components.Footer
import com.maxlepan.yapadsou.ui.components.InputView
import com.maxlepan.yapadsou.ui.components.ProductCard



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Home(navController: NavHostController?, userId: String) {

    var search by remember { mutableStateOf(TextFieldValue("")) }

    val productItems = remember { mutableStateListOf<ProductItem>() }

    val user = remember { mutableStateOf<User>(User()) }

    FirebaseManager.getItemsWithLimit(10){ result ->
        for (document in result) {
            Log.d("###", document.id)
            val productItem = document.toObject<ProductItem>()
            productItem.itemId = document.id
            productItems.add(productItem)
        }
    }

    FirebaseManager.getUserById(userId){result ->
        result.toObject<User>()?.let {newUser ->
            println("### $newUser")
            user.value = newUser
            user.value.userId = result.id
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .zIndex(1f)
    ) {
        Scaffold (
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(color = Color(0xff5f67ea))
                ) {
                    // titre + searchBar
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(33.dp, 0.dp, 33.dp, 35.dp)
                    ) {
                        // titre
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .padding(0.dp, 58.dp, 0.dp, 45.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column() {
                                Text(
                                    text = "COUCOU TOI,",
                                    color = Color.White,
                                    style = Typography.h2
                                )
                                Text(
                                    text = "T’es en manque de thunes ?",
                                    color = Color.White,
                                    style = Typography.subtitle1
                                )
                            }
                            var imageUser = painterResource(id = R.drawable.ic_launcher_background)
                            if (user.value.image !== ""){
                                imageUser = rememberAsyncImagePainter(user.value.image)
                            }
                            Image(
                                painter = imageUser,
                                contentDescription = "Ellipse 1",
                                modifier = Modifier
                                    .size(size = 45.dp)
                                    .clip(shape = CircleShape)
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = 112.dp)
                                .padding(20.dp, 0.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            InputView(
                                placeholder = "Cherche un bon plan",
                                value = search,
                                callback = { new ->
                                    search = new
                                },
                                icon = R.drawable.search_icon,
                                keyboardType = KeyboardType.Text,
                                isPassword = false,
                            )
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
                            modifier = Modifier
                                .padding(25.dp, 30.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CategoryCard(
                                title = "courses",
                                color = Color(0xff605DF5),
                                icon = R.drawable.shopping_icon
                            )
                            CategoryCard(
                                title = "sport",
                                color = Color(0xffF4696A),
                                icon = R.drawable.sport_icon
                            )
                            CategoryCard(
                                title = "trains",
                                color = Color(0xff579BFE),
                                icon = R.drawable.transport_icon
                            )
                            CategoryCard(
                                title = "soirées",
                                color = Color(0xff7C8CF9),
                                icon = R.drawable.party_icon
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(25.dp, 9.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Les PLANS du moment",
                                color = Color(0xff1b191a),
                                style = Typography.h3,
                                modifier = Modifier
                            )
                            Text(
                                text = "Voir tout",
                                color = Color(0xfffc6b68),
                                textAlign = TextAlign.End,
                                style = TextStyle(
                                    fontFamily = Inter,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                            )
                        }
                        LazyVerticalGrid(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalArrangement = Arrangement.spacedBy(0.dp),
                            columns = GridCells.Fixed(2),
                            modifier = Modifier
                                .padding(start = 25.dp, top = 0.dp, end = 25.dp, bottom = 77.dp)
                        ) {
                            items(productItems.size) { index ->
                                Button(
                                    onClick = {
                                              navController?.navigate("item/${productItems[index].itemId}")
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Color.Transparent
                                    ),
                                    elevation = null,
                                    contentPadding = PaddingValues(0.dp)
                                ) {
                                    ProductCard(
                                        title = productItems[index].title,
                                        subTitle = productItems[index].subTitle,
                                        imageProduct = productItems[index].image,
                                        iconUser = "",
                                        height = 157
                                    )
                                }
                            }
                        }
                    }
                }
            },
            bottomBar = {
                Footer(
                    selected = 0,
                    navController = navController,
                    userId = user.value.userId
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home(null, "")
}
