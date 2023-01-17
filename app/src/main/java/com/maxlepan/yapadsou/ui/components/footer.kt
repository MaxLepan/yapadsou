package com.maxlepan.yapadsou.ui.components

import android.net.eap.EapSessionConfig.EapTtlsConfig
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maxlepan.yapadsou.R
import com.maxlepan.yapadsou.models.IconFooter
import java.util.Objects
import kotlin.math.round

@Composable
fun Footer(selected : Int) {
    var footerIcons : List<IconFooter> = listOf(
        IconFooter(icon = R.drawable.home_icon, iconActive = R.drawable.home_icon_active, selected = false),
        IconFooter(icon = R.drawable.circle_add_icon, iconActive = R.drawable.circle_add_icon_active, selected = false),
        IconFooter(icon = R.drawable.user_icon, iconActive = R.drawable.user_icon_active, selected = false)
    )
    footerIcons[selected].selected = true
    Card(
        elevation = 9.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(25.dp, 25.dp,0.dp,0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(height = 78.dp)
    ){
        Column(verticalArrangement = Arrangement.Center,
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
                    if(iconFooter.selected) {
                        res = iconFooter.iconActive
                    }
                    Image(
                        painter = painterResource(id = res),
                        contentDescription = res.toString(),
                        modifier = Modifier
                            .clip(RoundedCornerShape(5.dp))
                            .background(color = Color(0xffF2F2F2))
                            .size(50.dp)
                            .padding(10.dp)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun FooterPreview() {
    Footer(selected = 0)
}