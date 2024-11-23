package com.example.quodchallenge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
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
fun ValidatingScreen(navController: NavController) {
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
            painter = painterResource(id = R.drawable.validating),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(120.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Verificação em análise!",
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF55575C),
                lineHeight = 30.sp
            ),
            modifier = Modifier.padding(top = 24.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Text(
            text = "Fique tranquilo! Estamos processando suas informações. Aguarde um momento.",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 30.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF55575C),
            ),
            modifier = Modifier.padding(top = 24.dp, bottom = 48.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        CircularProgressIndicator(
            modifier = Modifier.size(48.dp),
            color = Color(0xFF753CFD),
            strokeWidth = 4.dp
        )
    }
}
