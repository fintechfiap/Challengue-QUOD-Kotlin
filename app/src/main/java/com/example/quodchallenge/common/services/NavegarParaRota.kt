package com.example.quodchallenge.common.services

import androidx.navigation.NavController

fun navegarParaRota(rota : String, navController: NavController){
    navController.navigate(rota)
}