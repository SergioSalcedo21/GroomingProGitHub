// Esto es mi repositorio

package com.ebc.groomingPro.data.repository

import com.ebc.groomingPro.model.CitaServicio

object CitasRepository {

    // Aquí guardo TODAS las citas - Cuaderno único -
    private val citas = mutableListOf<CitaServicio>()


    //Si alguien quiere ver las citas, yo se las doy
    fun obtenerCitas(): List <CitaServicio> {
        return citas
    }


    // Cuando alguien quiera guardar una cita, que venga conmigo
    fun agregarCita(cita: CitaServicio){
        citas.add(cita)
    }
}