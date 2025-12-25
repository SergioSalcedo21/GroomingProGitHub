package com.ebc.groomingPro.iu.tipocambio

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ebc.groomingPro.viewmodel.TipoCambioViewModel


// Crear UI - Pantallas

@Composable
fun TipoDeCambioScreen (
    viewModel: TipoCambioViewModel = viewModel()  // conectar ViewModel con UI

){
    val tipoCambio by viewModel.tipoCambio.collectAsState()  // conectar ViewModel con UI

    Column ( modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(text = "Tipo de Cambio de Dolar",
            style = MaterialTheme.typography.headlineMedium)

        Text(text = "Considerando la Rest API del Banco de México",
            style = MaterialTheme.typography.labelMedium)

        // Aquí va un espaciado
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.consultaTipoCambio()      // CONECTAR BOTÓN CON VIEWMODEL
            }
        ) {
            Text("Consultar")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Resultado",
            style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = tipoCambio,
            style = MaterialTheme.typography.headlineMedium)






    } // Aquí acaba columna




}



@Preview(showBackground = true)
@Composable
fun tipodecambioPreview(){
    TipoDeCambioScreen()
}