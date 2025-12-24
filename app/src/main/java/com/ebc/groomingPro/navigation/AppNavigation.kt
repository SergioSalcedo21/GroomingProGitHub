package com.ebc.groomingPro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ebc.groomingPro.iu.citasLista.CitasScreen
import com.ebc.groomingPro.iu.crear.CrearScreen
import com.ebc.groomingPro.iu.detalleCitas.DetalleCitaScreen
import com.ebc.groomingPro.iu.home.HomeScreen


@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable ("home") {
            HomeScreen(navController)
        }
        composable ("crear"){ // Este es el "link"/composable con el que debe de coincidir el botón
            CrearScreen(navController)
        }


        composable ("citas"){
            CitasScreen(navController)

        }

        composable (route = "detalle/{nombreMascota}/{servicio}") {
            backStackEntry ->
            val nombreMascota =
                backStackEntry.arguments?.getString("nombreMascota") ?: ""

            val servicio =
                backStackEntry.arguments?.getString("servicio") ?: ""

            DetalleCitaScreen(
                navController = navController,
                nombreMascota = nombreMascota,
                servicio = servicio
            )
        }


    }


}