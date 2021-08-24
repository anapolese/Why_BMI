package com.plsana.whybmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.plsana.whybmi.databinding.ActivityMainBinding
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setListeners()
    }

    private fun setListeners() {
        val heightInput = binding.heightInput
        val kgInput = binding.kgInput
        val calcBtn = binding.calculateBtn

        heightInput.doAfterTextChanged { text ->

        }

        kgInput.doOnTextChanged {text, start, before, count ->  }

        calcBtn.setOnClickListener {
            calculateBMI(kgInput.text.toString(), heightInput.text.toString())
        }
    }

    private fun calculateBMI(weight: String, height: String) {

        val h = height.toDouble()
        val kg = weight.toDouble()

        if (kg != null && h != null) {
            val bmiResult: Double = kg/(h*h)
            val decimal = DecimalFormat("#.##")
            val bmiFinal = decimal.format(bmiResult).toString()
            binding.resultsBMI.text = "Your bmi is $bmiFinal"
        }
    }



}