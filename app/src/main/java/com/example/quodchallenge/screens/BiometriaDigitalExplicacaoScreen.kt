package com.example.quodchallenge.screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quodchallenge.R
import com.example.quodchallenge.common.components.BarraSuperior

@Composable
fun BiometriaDigitalExplicacaoScreen(navController: NavController){
    val fingerprintIcon = painterResource(R.drawable.giant_fingerprint)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
            .background(Color.White)
    ) {
        BarraSuperior("Biometria Digital", navController)
        Text(
            text = "Coloque seu dedo no sensor para realizar a validação da biometria digital. ",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 30.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF55575C),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.padding(top = 44.dp).width(353.dp).height(150.dp)
        )
        androidx.compose.foundation.Image(
            painter = fingerprintIcon,
            contentDescription = "Ícone de impressão digital",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Transparent)
        )
    }
}