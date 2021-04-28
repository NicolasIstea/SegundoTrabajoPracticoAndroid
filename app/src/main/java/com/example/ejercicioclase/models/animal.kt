package com.example.ejercicioclase.models

import java.io.Serializable

data class animal(var nombre: String, var tipo: String, var raza: String, var edad: Number, var causaDeAtencion: String) : Serializable
