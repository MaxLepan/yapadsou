package com.maxlepan.yapadsou.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(

    // Placeholders + body text (16px)
    body1 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),

    // Little body texts (12px) + product cards title
    body2 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    ),

    // Subtitles
    subtitle1 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),

    // Big titles in Onboarding view
    h1 = TextStyle(
        fontFamily = IntegralCF,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),

    // Titles on all other views
    h2 = TextStyle(
        fontFamily = IntegralCF,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp
    ),

    // Bold labels
    h3 = TextStyle(
        fontFamily = IntegralCF,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),

    // Button text
    button = TextStyle(
        fontFamily = IntegralCF,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    // Small description of product cards
    caption = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp
    ),

    // Name of the category cards
    overline = TextStyle(
        fontFamily = IntegralCF,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    )

)