package com.ebc.groomingPro.model

data class CitaServicio(
    val id: Int = 0,
    val nombreMascota: String,
    val servicio: String,
    val nombreDueno: String,
    val telefono: String,
    val raza: String,
    val precio: Double
)