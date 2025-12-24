package com.ebc.groomingPro.iu.detalleCitas


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController



@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun DetalleCitaScreen(
    navController: NavController,
    nombreMascota: String,
    servicio: String
) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {Text("Detalle de la cita con scaffold")},
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                }

            ) //TopAppBar
        } //TopBar

    ) //Parametros Scaffold
    { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Detalle de la Cita",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column (modifier = Modifier.padding(12.dp)

                ){
                    Text(
                        text = "Nombre de la maskota",
                        style = MaterialTheme.typography.labelMedium
                    )

                    Text(
                        text = nombreMascota,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Servicio",
                        style = MaterialTheme.typography.labelMedium
                    )

                    Text(
                        text = servicio,
                        style = MaterialTheme.typography.bodyLarge
                    )

                }// Contenido Columna 2
            } //Contenido Card
        } // contenido columna
    } //Scaffold

}




@Preview(showBackground = true)
@Composable
fun DetalleCitaScreenPreview () {
    val navController = rememberNavController()
    DetalleCitaScreen(
        navController = navController,
        nombreMascota = "Tiger",
        servicio = "Baño"
    )
}