package com.ebc.groomingPro.viewmodel

import androidx.lifecycle.ViewModel
import com.ebc.groomingPro.data.repository.CitasRepository
import com.ebc.groomingPro.model.CitaServicio

class CrearViewModel : ViewModel() {

    fun guardarCita(cita: CitaServicio){
        CitasRepository.agregarCita(cita)
    }

}