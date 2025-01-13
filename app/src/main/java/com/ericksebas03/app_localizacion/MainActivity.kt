package com.ericksebas03.app_localizacion
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.widget.TextView

class MainActivity : AppCompatActivity(),SensorEventListener {

    private lateinit var sensorManager:SensorManager
    private var gravitySensor: Sensor?=null

    private lateinit var tvX: TextView
    private lateinit var tvY: TextView
    private lateinit var tvZ: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvX=findViewById(R.id.tv_x)
        tvY=findViewById(R.id.tv_y)
        tvZ=findViewById(R.id.tv_z)

        sensorManager=getSystemService(SENSOR_SERVICE) as SensorManager

        gravitySensor=sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
        if(gravitySensor==null){
            tvX.text="Sensor de gravedad no disponible"
        }
    }
    override fun onResume(){
        super.onResume()
        gravitySensor?.let {
            sensorManager.registerListener(this,it,SensorManager.SENSOR_DELAY_NORMAL)
        }
    }
    override fun onPause(){
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type==Sensor.TYPE_GRAVITY){
            val x=event.values[0]
            val y=event.values[1]
            val z=event.values[2]

            tvX.text="X: $x"
            tvY.text="Y: $y"
            tvZ.text="Z: $z"
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //
    }
}