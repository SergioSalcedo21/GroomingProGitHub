package com.ebc.groomingPro.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class TipoCambioViewModel: ViewModel() {
    private val _tipoCambio = MutableStateFlow("$00.00 MXN (presiona consultar)")
    val tipoCambio: StateFlow<String> = _tipoCambio

    fun consultaTipoCambio() {

        viewModelScope.launch(Dispatchers.IO) {

            try {
                val url = URL(
                    "https://www.banxico.org.mx/SieAPIRest/service/v1/series/SF43718/datos/oportuno"
                )

                val connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.setRequestProperty("Bmx-Token", "99ff8005f8a6ed20cdc3e62ea37f2550e28facf00fc7b6859b7d2609a1b3e8b6")
                connection.connectTimeout = 5000
                connection.readTimeout = 5000

                val response = connection.inputStream
                    .bufferedReader()
                    .readText()

                // Parseo del JSON
                val json = JSONObject(response)
                val dato = json
                    .getJSONObject("bmx")
                    .getJSONArray("series")
                    .getJSONObject(0)
                    .getJSONArray("datos")
                    .getJSONObject(0)
                    .getString("dato")

                _tipoCambio.value = "$ $dato MXN"

            } catch (e: Exception) {
                _tipoCambio.value = "Error al consultar"
            }
        }
    }

}