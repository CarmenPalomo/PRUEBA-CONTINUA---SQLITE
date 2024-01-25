package com.example.pruebacontinua_sqlite

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val baseDatos = BaseDatos(this)
        val texto = findViewById<TextView>(R.id.texto)

        texto.text= "EL numero de articulos es ${baseDatos.getNumeroArticulos()}. El listado de articulos es ${baseDatos.getContenido()}"




    }
}