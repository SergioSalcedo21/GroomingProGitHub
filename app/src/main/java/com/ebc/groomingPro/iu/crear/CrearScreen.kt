//Pantalla Crear cita

package com.ebc.groomingPro.iu.crear

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ebc.groomingPro.model.CitaServicio
import com.ebc.groomingPro.viewmodel.CrearViewModel

@Composable
fun CrearScreen(
    navController: NavController,
    crearViewModel: CrearViewModel = viewModel()
){
    var nombreMascota by remember { mutableStateOf("") }
    var nombreDueno by remember { mutableStateOf("") }
    var servicioSeleccionado by remember {mutableStateOf("Baño")}
    var razaMascota by remember { mutableStateOf("") }
    var telefonoDueno by remember { mutableStateOf("") }
    var precioServicio by remember { mutableStateOf("") }



    Column (modifier = Modifier.padding(32.dp)){
        Text(text = "Agregar Cita")

        OutlinedTextField(
            value = nombreDueno,
            onValueChange = { nombreDueno = it},
            label = { Text("Nombre del dueño")}
        )

        OutlinedTextField(
            value = telefonoDueno,
            onValueChange = { telefonoDueno = it},
            label = { Text("Número de teléfono")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        OutlinedTextField(
            value = nombreMascota,
            onValueChange = { nombreMascota = it},
            label = { Text("Nombre de la mascota")}
        )

        OutlinedTextField(
            value = razaMascota,
            onValueChange = { razaMascota = it},
            label = { Text("Raza")}
        )


        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Servicios")

        //Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically){
            RadioButton(
                selected = servicioSeleccionado == "Baño",
                onClick = {servicioSeleccionado = "Baño"}
            )
            Text(text="Baño")

        }

        Row(verticalAlignment = Alignment.CenterVertically){
            RadioButton(
                selected = servicioSeleccionado == "Corte",
                onClick = {servicioSeleccionado = "Corte"}
            )
            Text(text="Corte")

        }

        Row(verticalAlignment = Alignment.CenterVertically){
            RadioButton(
                selected = servicioSeleccionado == "Baño y Corte",
                onClick = {servicioSeleccionado = "Baño y Corte"}
            )
            Text(text="Baño y Corte")

        }
        OutlinedTextField(
            value = precioServicio,
            onValueChange = { precioServicio = it},
            label = { Text("Costo del servicio")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

// creo estos campos se mostraran en otra pantalla citasLista o detalleLista
        Button(
            onClick = {
                val nuevaCita = CitaServicio(
                    nombreMascota = nombreMascota,
                    servicio = servicioSeleccionado,
                    nombreDueno = nombreDueno,
                    telefono = telefonoDueno,
                    raza = razaMascota,
                    precio = precioServicio.toDoubleOrNull() ?: 0.0
                )
                crearViewModel.guardarCita(nuevaCita)
                navController.navigate("citas")

                println("Cita guardada: $nuevaCita")
            }
        ) {
            Text(text = "Guardaaaar Citaaa")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun CrearScreenPreview(){
    val navController = rememberNavController()
    CrearScreen(navController)

}

