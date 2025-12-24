package com.ebc.groomingPro.iu.citasLista

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ebc.groomingPro.viewmodel.CitasViewModel


@Composable
fun CitasScreen(
    navController: NavController,
    viewModel: CitasViewModel = viewModel()
    ){

    val citas = viewModel.obtenerCitas()

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
     ){
        Text(
            "Lista de citas",
            style = MaterialTheme.typography.headlineMedium
        )

        LazyColumn {
            items(citas) { cita -> // cada elemento de la lista citas lo llamara cita
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .clickable{
                        navController.navigate(
                            "detalle/${cita.nombreMascota}/${cita.servicio}"
                        )
                    }
                    .padding(8.dp)) {
                    Text(text = "Nombre Mascotaaa: ${cita.nombreMascota}")
                    Text(text = "Serviciiio: ${cita.servicio}")
                }

            }
        }



    }

}


@Preview(showBackground = true)
@Composable
fun CitasScreenPreview (){
    val navController = rememberNavController()
    CitasScreen(navController = navController)
}