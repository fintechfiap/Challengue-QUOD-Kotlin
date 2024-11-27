package com.example.quodchallenge.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quodchallenge.R
import com.example.quodchallenge.common.components.BarraSuperior
import com.example.quodchallenge.common.components.BotaoModular
import com.example.quodchallenge.common.components.CameraX

@Composable
fun DocumentoscopiaAuthScreen(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize(1.0f)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BarraSuperior("Documentoscopia", navController)

        Text(
            text = "Tire foto do documento",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
            ),
            modifier = Modifier
                .padding(top = 33.dp, bottom = 33.dp)
                .width(234.dp)
                .height(16.dp),
            textAlign = TextAlign.Center
        )

        CameraX()

        val cameraIcon = painterResource(R.drawable.camera)

        BotaoModular(icon = cameraIcon, text = "Tirar foto", onClick = {
            navController.navigate("success")
        })
    }
}