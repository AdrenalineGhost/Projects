package com.example.trafficfeed.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.trafficfeed.R

val Montserrat = FontFamily(
    Font(R.font.montserrat_regular),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
//val Typography = Typography(
//    body1 = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    )
//)
 val Typography = Typography(
     body1 = TextStyle(
         fontFamily = FontFamily.Default,
         fontWeight = FontWeight.Normal,
         fontSize = 14.sp
     ),
     h1 = TextStyle(
         fontSize = 30.sp,
         fontFamily = FontFamily.Default,
         fontWeight = FontWeight.Normal
     ),
     h2 = TextStyle(
         fontSize = 14.sp,
         fontFamily = FontFamily.Default,
         fontWeight = FontWeight.Bold
     )
 )