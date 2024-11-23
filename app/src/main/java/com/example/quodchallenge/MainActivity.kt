package com.example.quodchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quodchallenge.ui.theme.QuodChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuodChallengeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Greeting(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

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

        Column(
            modifier = Modifier.padding(top = 36.dp)
        ) {
            ModularButton(faceIcon, "Biometria facial")
            ModularButton(fingerprintIcon, "Biometria digital")
            ModularButton(docIcon, "Documentoscopia")
            ModularButton(swapIcon, "SIM SWAP")
            ModularButton(authIcon, "Autenticação cadastral")
            ModularButton(scoreIcon, "Score Antifraude")
        }

    }
}

@Composable
fun ModularButton(icon: Painter ,text: String){
    Button(
        onClick = {},
        modifier = Modifier.padding(top = 36.dp).width(300.dp).height(55.dp),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF753CFD)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = icon,
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFECEEED)
                )
            )
        }
    }
}
