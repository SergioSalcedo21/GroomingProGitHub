/*
1️⃣ Crear la clase de base de datos ✅
2️⃣ Heredar de SQLiteOpenHelper
3️⃣ Crear la tabla con SQL
4️⃣ Insertar una cita
5️⃣ Leer las citas
6️⃣ Conectar esto con el Repository
7️⃣ ViewModel → Repository → SQLite

 */

package com.ebc.groomingPro.data.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.ebc.groomingPro.model.CitaServicio

// cascaron de SQLite

/*
class CitasDatabaseHelper {
}
*/

class CitasDatabaseHelper(
    context: Context
) : SQLiteOpenHelper(   //Es una clase que crea LA BASE DE DATOS
    context,
    DATABASE_NAME,
    null,
    DATABASE_VERSION
) {

    // Aquí se crean las tablas - Analoigía construye  la mesa

    override fun onCreate(db: SQLiteDatabase) {
        val crearTablaCitas = """
            CREATE TABLE citas(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nombreMascota TEXT NOT NULL,
            servicio TEXT NOT NULL,
            nombreDueno TEXT NOT NULL,
            telefono TEXT NOT NULL,
            raza TEXT,
            precio REAL
            )
        """.trimIndent()
        db.execSQL(crearTablaCitas)    // Esto le da formato de tabla -ejecuta la instrucción-
    }


// Analogía remodela la mesa
    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        // Aquí se maneja cuando cambia la versión
    }

    // Insertar Datos en SQLite desde Android - Analogía - Mete cosas a la mesa

    fun insertarCita(cita: CitaServicio): Long {        // INSERT → Guardar las citas en SQLite
        val db = writableDatabase                       //Abre la base de datos en modo escritura

        val values = ContentValues().apply {            // Es el objeto que guarda los datos antes de insertarlos
            put("nombreMascota", cita.nombreMascota)    // put ("columna", valor) El nombre de la columna debe coincidir EXACTO con la tabla
            put("servicio", cita.servicio)
            put("nombreDueno", cita.nombreDueno)
            put("telefono", cita.telefono)
            put("raza", cita.raza)
            put("precio", cita.precio)
        }

        val resultado = db.insert("citas", null, values)     // Estás guardando una cita en la base de datos SQLite.
        db.close()

        return resultado
    }


    fun obtenerCitas(): List<CitaServicio> {
        val listaCitas = mutableListOf<CitaServicio>()    // Aquí guardaremos las citas que vengan de SQLite.

        val db = readableDatabase

        val cursor = db.rawQuery("SELECT * FROM citas", null)

        if (cursor.moveToFirst()) {
            do {
                val cita = CitaServicio(
                    id = cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                    nombreMascota = cursor.getString(cursor.getColumnIndexOrThrow("nombreMascota")),
                    servicio = cursor.getString(cursor.getColumnIndexOrThrow("servicio")),
                    nombreDueno = cursor.getString(cursor.getColumnIndexOrThrow("nombreDueno")),
                    telefono = cursor.getString(cursor.getColumnIndexOrThrow("telefono")),
                    raza = cursor.getString(cursor.getColumnIndexOrThrow("raza")),
                    precio = cursor.getDouble(cursor.getColumnIndexOrThrow("precio"))
                )

                listaCitas.add(cita)       //Ya tenemos una cita Kotlin, ahora la guardamos.

            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return listaCitas
    }


    // Analogía Etiquetas de la caja

    companion object {
        const val DATABASE_NAME = "citas.db"
        const val DATABASE_VERSION = 1
    }
}
