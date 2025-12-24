package com.ebc.groomingPro.viewmodel

import androidx.lifecycle.ViewModel
import com.ebc.groomingPro.data.repository.CitasRepository
import com.ebc.groomingPro.model.CitaServicio

class CitasViewModel : ViewModel() {
    fun obtenerCitas(): List<CitaServicio> {
        return CitasRepository.obtenerCitas()
    }

    fun agregarCita(cita: CitaServicio){
        CitasRepository.agregarCita(cita)
    }
}