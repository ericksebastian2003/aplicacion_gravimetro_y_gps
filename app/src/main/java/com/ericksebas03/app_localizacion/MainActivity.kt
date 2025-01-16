package com.ericksebas03.app_localizacion

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnGravimetro: Button = findViewById(R.id.btn_gravimetro)
        val btnGps: Button = findViewById(R.id.btn_gps)

        // Configurar eventos onClick para los botones
        btnGravimetro.setOnClickListener {
            // Abrir la actividad del gravímetro
            val intent = Intent(this, com.ericksebas03.app_localizacion.Gravimetro::class.java)
            startActivity(intent)
        }

        btnGps.setOnClickListener {
            // Abrir la actividad del GPS
            val intent = Intent(this, com.ericksebas03.app_localizacion.GPS::class.java)
            startActivity(intent)
        }
    }
}
