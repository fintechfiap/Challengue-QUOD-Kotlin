package com.example.quodchallenge.screens

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.quodchallenge.R
import com.example.quodchallenge.common.components.BarraSuperior
import com.example.quodchallenge.common.components.BotaoModular

@Composable
fun BiometriaFacialExplicacaoScreen(navController: NavController){
    val arrowIcon = painterResource(R.drawable.arrow_forward)

    val contexto = LocalContext.current

    val promptPermissao = rememberLauncherForActivityResult(
        ActivityResultContracts
            .RequestPermission()) {
        if(it) {
            Toast.makeText(contexto, "Permissão de câmera concedida", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(contexto, "Permissão de câmera negada", Toast.LENGTH_SHORT).show()
        }

    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .fillMaxHeight(1.0f)
            .background(Color.White)
    ) {
        BarraSuperior("Biometria Facial", navController)
        Text(
            text = "Posicione seu rosto na câmera para realizar a validação facial. Certifique-se de que está em um ambiente bem iluminado e com um fundo neutro.",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 30.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF55575C),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.padding(top = 44.dp).width(353.dp).height(150.dp)
        )
        val cameraIcon = painterResource(R.drawable.camera)

        BotaoModular(text = "Iniciar captura", icon = cameraIcon, onClick = {
            val verificarPermissao = ContextCompat.checkSelfPermission(contexto, Manifest.permission.CAMERA)
            if(verificarPermissao == PackageManager.PERMISSION_GRANTED){
                navController.navigate("biometriaFacialAuth")
            }
            else{
                promptPermissao.launch(Manifest.permission.CAMERA)
            }
        })



    }

}
