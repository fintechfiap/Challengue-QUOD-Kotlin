package com.example.quodchallenge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quodchallenge.R
import com.example.quodchallenge.common.components.BotaoModular

@Composable
fun ErrorScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
            .background(color = Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.error),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(220.dp)
        )

        Text(
            text = "Ooops! Não foi possível concluir a verificação!",
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF55575C),
                lineHeight = 30.sp
            ),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Text(
            text = "Tente novamente ou entre em contato para suporte, caso necessário.",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 30.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF55575C),
            ),
            modifier = Modifier.padding(top = 24.dp, bottom = 12.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Column(
        ) {
            BotaoModular(
                icon = painterResource(R.drawable.arrow_back),
                text = "Voltar para Home",
                onClick = { navController.navigate("home") }
            )
            BotaoModular(
                icon = painterResource(R.drawable.retry),
                text = "Tentar Novamente",
                onClick = { navController.navigate("home") }
            )
        }
    }
}
