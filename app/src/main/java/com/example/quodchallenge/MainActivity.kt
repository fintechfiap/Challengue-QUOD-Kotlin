package com.example.quodchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quodchallenge.screens.BiometriaDigitalExplicacaoScreen
import com.example.quodchallenge.screens.BiometriaFacialExplicacaoScreen
import com.example.quodchallenge.screens.CadastralExplicacaoScreen
import com.example.quodchallenge.screens.DocumentoscopiaExplicacaoScreen
import com.example.quodchallenge.screens.ErrorScreen
import com.example.quodchallenge.screens.FailedScreen
import com.example.quodchallenge.screens.HomeScreen
import com.example.quodchallenge.screens.ScoreAntiFraudeExplicacaoScreen
import com.example.quodchallenge.screens.SimSwapAuthScreen
import com.example.quodchallenge.screens.SimSwapExplicacaoScreen
import com.example.quodchallenge.screens.SuccessScreen
import com.example.quodchallenge.screens.ValidatingScreen
import com.example.quodchallenge.ui.theme.QuodChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuodChallengeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),

                    ) { innerPadding ->
                    val navController = rememberNavController()
                    Column(modifier = Modifier.padding(innerPadding)) {
                        NavHost(
                            navController = navController,
                            startDestination = "home"
                        ) {
                            composable("home") {
                                HomeScreen(navController = navController)
                            }
                            composable("biometriaFacial") {
                                BiometriaFacialExplicacaoScreen(navController = navController)
                            }
                            composable("biometriaDigital") {
                                BiometriaDigitalExplicacaoScreen(navController = navController)
                            }
                            composable("validating") {
                                ValidatingScreen(navController = navController)
                            }
                            composable("success") {
                                SuccessScreen(navController = navController)
                            }
                            composable("failed") {
                                FailedScreen(navController = navController)
                            }
                            composable("error") {
                                ErrorScreen(navController = navController)
                            }
                            composable("documentoscopia") {
                                DocumentoscopiaExplicacaoScreen(navController = navController)
                            }
                            composable("simSwap") {
                                SimSwapExplicacaoScreen(navController = navController)
                            }
                            composable("simSwapAuth") {
                                SimSwapAuthScreen(navController = navController)
                            }
                            composable("scoreAntiFraude") {
                                ScoreAntiFraudeExplicacaoScreen(navController = navController)
                            }
                            composable("cadastral") {
                                CadastralExplicacaoScreen(navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}




