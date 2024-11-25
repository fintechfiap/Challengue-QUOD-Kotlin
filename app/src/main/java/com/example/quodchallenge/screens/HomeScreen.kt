package com.example.quodchallenge.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
fun HomeScreen(navController : NavController) {

    val image = painterResource(R.drawable.title)

    Column(
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
            .background(color = Color.White)
            .padding(top = 55.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.width(177.dp).height(100.dp),
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Text(
            text = "Explore nossos serviços:",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF55575C)
            )
        )

        val faceIcon = painterResource(R.drawable.face)
        val fingerprintIcon = painterResource(R.drawable.fingerprint)
        val docIcon = painterResource(R.drawable.doc)
        val swapIcon = painterResource(R.drawable.swap)
        val authIcon = painterResource(R.drawable.auth)
        val scoreIcon = painterResource(R.drawable.score)

//        Button( onClick = { navController.navigate("validating") }) {
//            Text(text = "Navegar")
//        }
//
//        Button( onClick = { navController.navigate("success") }) {
//            Text(text = "Navegar")
//        }
//
//        Button( onClick = { navController.navigate("failed") }) {
//            Text(text = "Navegar")
//        }
//
//        Button( onClick = { navController.navigate("error") }) {
//            Text(text = "Navegar")
//        }

        Column(
            modifier = Modifier.padding(top = 36.dp)
        ) {
            BotaoModular(faceIcon, "Biometria facial", navController, "biometriaFacial")
            BotaoModular(fingerprintIcon, "Biometria digital", navController, "biometriaDigital")
            BotaoModular(docIcon, "Documentoscopia", navController, "documentoscopia")
            BotaoModular(swapIcon, "SIM SWAP", navController, "simSwap")
            BotaoModular(authIcon, "Autenticação cadastral", navController, "autenticacaoCadastral")
            BotaoModular(scoreIcon, "Score Antifraude", navController, "scoreAntiFraude")
        }
    }
}