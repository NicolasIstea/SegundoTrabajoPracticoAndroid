package com.example.ejercicioclase

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import com.example.ejercicioclase.models.animal

class AsignacionDeCaso : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asignacion_de_caso)

        inicializarElementos()

        aceptar.setOnClickListener(){

            gotToActity(this,MainActivity::class.java)
        }

    }

    lateinit var diagnostico:EditText
    lateinit var causas:EditText
    lateinit var medicamentos:EditText
    lateinit var tratamiento:EditText
    lateinit var reposo:EditText
    lateinit var aceptar: Button

    private fun inicializarElementos(){
        diagnostico=findViewById(R.id.c_e_diagnostico)
        causas=findViewById(R.id.c_e_causas)
        medicamentos=findViewById(R.id.c_e_medicamentos)
        tratamiento=findViewById(R.id.c_e_tratamiento)
        reposo=findViewById(R.id.c_e_reposo)
        aceptar=findViewById(R.id.c_b_crear)
    }

    private fun <T>gotToActity(context: Context, activity:Class<T>){
        val i = Intent(context,activity)
        startActivity(i)
    }
}