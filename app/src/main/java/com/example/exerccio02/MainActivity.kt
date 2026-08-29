package com.example.exerccio02

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.exerccio02.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalc.setOnClickListener {
            calcularIMC()
        }
    }

    private fun calcularIMC() {

        val peso = binding.EditPeso.text.toString().toFloatOrNull()
        val altura = binding.EditAltura.text.toString().toFloatOrNull()

        if (peso != null && altura != null && altura > 0) {

            val imc = peso / altura.pow(2)

            val imcResultado = String.format("%.2f", imc)

            val imcCategoria = when {
                imc < 18.5 -> "Abaixo do peso"
                imc < 25.0 -> "Peso normal"
                imc < 30.0 -> "Sobrepeso"
                imc < 35.0 -> "Obesidade grau I"
                imc < 40.0 -> "Obesidade grau II"
                else -> "Obesidade grau III"
            }

            binding.txtResultado.text =
                "IMC: $imcResultado\nCategoria: $imcCategoria"

        } else {

            binding.txtResultado.text = "Entrada inválida"
        }
    }
}