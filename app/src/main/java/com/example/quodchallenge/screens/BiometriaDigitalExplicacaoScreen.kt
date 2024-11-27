package com.example.quodchallenge.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.quodchallenge.common.enum.ValidationState
import kotlinx.coroutines.delay

@Composable
fun BiometriaDigitalExplicacaoScreen(navController: NavController){
    var validationState by remember { mutableStateOf<ValidationState>(ValidationState.Pending) }

    LaunchedEffect(Unit) {
        delay(5000)
        validationState = if ((0..1).random() == 0) {
            ValidationState.Success
        } else {
            ValidationState.Failed
        }
    }

    val fingerprintIcon = when (validationState) {
        ValidationState.Success -> painterResource(R.drawable.giant_fingerprint_success)
        ValidationState.Failed -> painterResource(R.drawable.giant_fingerprint_failed)
        ValidationState.Pending -> painterResource(R.drawable.giant_fingerprint)
    }

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

        Spacer(modifier = Modifier.height(24.dp))

        when (validationState) {
            ValidationState.Success -> {
                Text(
                    text = "Biometria concluída com sucesso!",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF55575C),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(top = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                BotaoModular(
                    icon = painterResource(R.drawable.arrow_back),
                    text = "Voltar para Home",
                    onClick = { navController.navigate("home") }
                )
            }

            ValidationState.Failed -> {
                Text(
                    text = "Biometria falhou. Tente novamente!",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF55575C),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(top = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                BotaoModular(
                    icon = painterResource(R.drawable.arrow_back),
                    text = "Voltar para Home",
                    onClick = { navController.navigate("home") }
                )
            }

            ValidationState.Pending -> {
            }
        }
    }
}