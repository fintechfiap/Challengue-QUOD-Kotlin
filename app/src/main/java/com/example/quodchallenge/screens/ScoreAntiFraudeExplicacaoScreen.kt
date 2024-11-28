package com.example.quodchallenge.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Stroke
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

@Composable
fun ScoreAntiFraudeExplicacaoScreen(navController: NavController){
    val inquiryIcon = painterResource(R.drawable.inquiry)
    val phoneNumber = remember { mutableStateOf("") }
    val score = remember { mutableStateOf<Int?>(null) } // Para armazenar o score gerado

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
            .background(Color.White)
    ) {
        BarraSuperior("Score Antifraude", navController)
        Text(
            text = "Informe seu CPF para verificar o Score Antifraude. Um valor de 1 a 1000 será gerado, onde quanto maior o score, menor a chance de fraude.",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 30.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF55575C),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.padding(top = 44.dp, bottom = 24.dp).width(353.dp).height(150.dp)
        )
        Text(
            text = "CPF",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF753CFD)
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 20.dp, bottom = 8.dp)
        )

        BasicTextField(
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            textStyle = TextStyle(
                fontSize = 16.sp,
                color = Color(0xFF55575C)
            ),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(55.dp)
                .background(
                    color = Color.White,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                )
                .border(
                    width = 2.dp,
                    color = Color(0xFF753CFD),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 12.dp, vertical = 16.dp),
            cursorBrush = SolidColor(Color(0xFF753CFD)),
            decorationBox = { innerTextField ->
                if (phoneNumber.value.isEmpty()) {
                    Text(
                        text = "Digite o CPF",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color(0xFFAAAAAA)
                        )
                    )
                }
                innerTextField()
            }
        )

        BotaoModular(
            icon = inquiryIcon,
            text = "Consultar",
            onClick = {
                score.value = (1..1000).random()
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        score.value?.let { generatedScore ->
            ScoreDisplay(generatedScore)
        }
    }
}

@Composable
fun ScoreDisplay(score: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 24.dp)
    ) {
        CircularScoreIndicator(score = score)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "$score de 1000",
            style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        )

        val riskLevel = when {
            score > 750 -> "Baixo"
            score in 500..750 -> "Médio"
            else -> "Alto"
        }

        val paymentProbability = when {
            score > 750 -> "100%"
            score in 500..750 -> "70%"
            else -> "30%"
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Risco de Crédito: $riskLevel",
            style = TextStyle(fontSize = 18.sp, color = Color.Black)
        )
        Text(
            text = "Probabilidade de Pagamento: $paymentProbability",
            style = TextStyle(fontSize = 18.sp, color = Color.Black)
        )
    }
}

@Composable
fun CircularScoreIndicator(score: Int) {
    var animatedSweepAngle by remember { mutableStateOf(0f) }

    LaunchedEffect(score) {
        animatedSweepAngle = (score / 1000f) * 360f
    }

    val sweepAngle by animateFloatAsState(
        targetValue = animatedSweepAngle,
        animationSpec = tween(durationMillis = 1000)
    )

    val progressColor = if (score < 400) Color.Red else Color(0xFF1BA456)

    Canvas(
        modifier = Modifier.size(200.dp)
    ) {
        drawArc(
            color = Color(0xFFECEEED),
            startAngle = -90f,
            sweepAngle = 360f,
            useCenter = false,
            style = Stroke(width = 16.dp.toPx())
        )
        drawArc(
            color = progressColor,
            startAngle = -90f,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(width = 16.dp.toPx())
        )
    }
}