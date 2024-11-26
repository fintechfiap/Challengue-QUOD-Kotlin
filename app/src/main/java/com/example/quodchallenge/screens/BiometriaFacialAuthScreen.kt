package com.example.quodchallenge.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quodchallenge.R
import com.example.quodchallenge.common.components.BarraSuperior
import com.example.quodchallenge.common.components.BotaoModular
import com.example.quodchallenge.common.components.CameraX

@Composable
fun BiometriaFacialAuthScreen(navController: NavController){

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
            .background(Color.White),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BarraSuperior("Biometria facial", navController)

        Text(
            text = "Centralize o rosto na modura",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
            ),
            modifier = Modifier
                .padding(top = 33.dp, bottom = 33.dp)
                .width(234.dp)
                .height(16.dp)
        )

        CameraX()

        Box(
            modifier = Modifier
                .padding(top = 30.dp)
                .width(343.dp)
                .height(61.dp)
                .background(color = Color(0xFFECEEED)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Mantenha assim, não se mova.",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
        }

        val cameraIcon = painterResource(R.drawable.camera)

        BotaoModular(text = "Iniciar captura", icon = cameraIcon, onClick = {teste()})

    }
}

fun teste(){
    println("TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE TESTE ")
}