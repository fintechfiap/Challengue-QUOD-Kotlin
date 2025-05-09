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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import kotlinx.coroutines.delay

@Composable
fun BiometriaFacialAuthScreen(navController: NavController){

    val context = LocalContext.current
    var fotoFoiTirada : Boolean by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
            .background(Color.White),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BarraSuperior("Biometria facial", navController)

        Text(
            text = "Centralize o rosto na moldura",
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

        if(fotoFoiTirada == false){
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
        }
        if(fotoFoiTirada == true){
            Box(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .width(343.dp)
                    .height(61.dp)
                    .background(color = Color(0xFF1BA456)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Biometria facial concluida!",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFECEEED),
                    )
                )
            }

            BotaoModular(
                icon = painterResource(R.drawable.arrow_back),
                text = "Voltar para Home",
                onClick = { navController.navigate("home") }
            )
        }
    }

    LaunchedEffect(true) {
        delay(6000L)
        fotoFoiTirada = true
    }
}


