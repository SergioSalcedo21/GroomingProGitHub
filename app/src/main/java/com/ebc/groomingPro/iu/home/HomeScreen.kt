package com.ebc.groomingPro.iu.home




import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen (navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(
            text = "GroomingPro!!!",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Agenda y administra las citas de tu estética canina!",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            navController.navigate("crear") //linkeando boton con la pag de agregar cita
            }
        ) {
            Text(text = "Agregar Cita" )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Ver Citas",

            Modifier.clickable{
                navController.navigate("citas")
            },
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelMedium

        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {navController.navigate("tipo_cambio")}) {
            Text("Ir a tipo de cambio")
        }

    }


}

@Preview (showBackground = true)
@Composable
fun HomeScreenPreview (){
    val navController = rememberNavController()
    HomeScreen(navController)
}