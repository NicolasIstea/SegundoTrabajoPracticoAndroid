package com.example.ejercicioclase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicioclase.models.animal
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializarElementos()

        atender.setOnClickListener(View.OnClickListener {

            val i = Intent(this,AsignacionDeCaso::class.java)

            doctorSeleccionado=findViewById(opcionId.checkedRadioButtonId)

            if(i.getSerializableExtra("animales") != null) {
                listaAnimales = i.getSerializableExtra("animales") as ArrayList<animal>
            }

            listaAnimales.add(animal(nombre.text.toString(),
                tipo.text.toString(),
                raza.text.toString(),
                edad.text.toString().toInt(),
                causaDeAtencion.text.toString()))

            i.putExtra("animales", listaAnimales)

            if(listaAnimales.count() == 5) {
                Toast.makeText(this, "No se pueden atender mas animales", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }

            if(tipo.text.toString().equals("perro") && doctorSeleccionado.text.toString().equals("Pedro")){
                Toast.makeText(this,"Pedro no puede atender perros", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }

            if(doctorSeleccionado.text.toString().equals("Pedro") && listaAnimales.count() > 3){
                Toast.makeText(this,"Pedro no puede atender mas de 3 animales", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }

            startActivity(i)

        })
    }

    lateinit var nombre:EditText
    lateinit var tipo:EditText
    lateinit var raza:EditText
    lateinit var edad:EditText
    lateinit var causaDeAtencion:EditText
    lateinit var atender:Button
    lateinit var opcionId: RadioGroup
    lateinit var doctorSeleccionado: RadioButton
    var listaAnimales:ArrayList<animal> = ArrayList<animal>()


    private fun inicializarElementos(){
        nombre=findViewById(R.id.e_nombre)
        tipo=findViewById(R.id.e_tipo)
        raza=findViewById(R.id.e_raza)
        edad=findViewById(R.id.e_edad)
        causaDeAtencion=findViewById(R.id.e_causaDeAtencion)
        atender=findViewById(R.id.b_atender)
        opcionId=findViewById(R.id.rg_doctor)
    }


}

