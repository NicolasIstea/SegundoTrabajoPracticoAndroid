package com.example.ejercicioclase.models

import java.io.Serializable

data class revision(var diagnostico: String, var causas: String, var medicamentos: String, var tratamiento: String, var reposo: String) :
    Serializable