package com.maxlepan.yapadsou.ui.components

import android.net.eap.EapSessionConfig.EapTtlsConfig
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.maxlepan.yapadsou.R
import com.maxlepan.yapadsou.models.IconFooter
import com.maxlepan.yapadsou.models.User
import com.maxlepan.yapadsou.providers.FirebaseManager
import java.util.Objects
import kotlin.math.round

@Composable
fun Footer(selected: Int, navController: NavHostController?, userId : String) {
    val footerIcons: List<IconFooter> = listOf(
        IconFooter(
            icon = R.drawable.home_icon,
            iconActive = R.drawable.home_icon_active,
            navDirection = "home",
            selected = false
        ),
        IconFooter(
            icon = R.drawable.circle_add_icon,
            iconActive = R.drawable.circle_add_icon_active,
            navDirection = "add-plan-description",
            selected = false
        ),
        IconFooter(
            icon = R.drawable.user_icon,
            iconActive = R.drawable.user_icon_active,
            navDirection = "user-edit",
            selected = false
        )
    )
    footerIcons[selected].selected = true
    Card(
        elevation = 9.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 78.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.Transparent)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(height = 50.dp)
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                footerIcons.forEach { iconFooter ->
                    var res = iconFooter.icon
                    if (iconFooter.selected) {
                        res = iconFooter.iconActive
                    }
                    Button(
                        onClick = {
                            if (!iconFooter.selected) {
                                FirebaseManager.firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
                                    param(FirebaseAnalytics.Param.ITEM_ID, 1)
                                    param(FirebaseAnalytics.Param.ITEM_NAME, "Button Footer")
                                    param(FirebaseAnalytics.Param.CONTENT_TYPE, "User have navigate with footer")
                                }
                                navController?.navigate(iconFooter.navDirection + "/" + userId)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xffF2F2F2)
                        )
                    ) {
                        Image(

                            painter = painterResource(id = res),
                            contentDescription = res.toString(),
                            modifier = Modifier
                                .clip(RoundedCornerShape(5.dp))
                                .background(color = Color(0xffF2F2F2))
                                .size(25.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun FooterPreview() {
    Footer(selected = 0, null, "")
}
