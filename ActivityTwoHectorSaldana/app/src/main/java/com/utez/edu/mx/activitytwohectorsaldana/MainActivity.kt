package com.utez.edu.mx.activitytwohectorsaldana

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.utez.edu.mx.activitytwohectorsaldana.databinding.ActivityMainBinding

class MainActivity : Activity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private val zero: String = "|"
    private var numberOne: Double = 0.0
    private var numberTwo: Double = 0.0
    private var total: Double = 0.0
    private var operation: String = ""
    private var isPush: Int = 0
    private var timesEquals: Boolean = true
    private var clean: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn0.setOnClickListener(this)
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn9.setOnClickListener(this)
        binding.btnDivide.setOnClickListener(this)
        binding.btnMultiply.setOnClickListener(this)
        binding.btnSubtract.setOnClickListener(this)
        binding.btnAdd.setOnClickListener(this)
        binding.btnCE.setOnClickListener(this)
        binding.btnPoint.setOnClickListener(this)
        binding.btnEquals.setOnClickListener(this)
    }

    override fun onClick(btn: View?) {
        when (btn?.id) {
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9 -> setDigit(
                btn as Button
            )
            R.id.btnDivide, R.id.btnMultiply, R.id.btnSubtract, R.id.btnAdd -> setOperation(btn as Button)
            R.id.btnPoint -> setPoint(btn as Button)
            R.id.btnCE -> clear()
            R.id.btnEquals -> result()
        }
    }

    private fun result() {
        try {
            if (timesEquals && binding.txtDisplayID.text != zero) {
                numberTwo = binding.txtDisplayID.text.toString().toDouble()
                println(numberOne)
                println(numberTwo)
                when (operation) {
                    "+" -> total = numberOne.plus(numberTwo)
                    "-" -> total = numberOne.minus(numberTwo)
                    "×" -> total = numberOne.times(numberTwo)
                    "÷" -> total = numberOne.div(numberTwo)
                }
                if (total.isNaN() || total.isInfinite()) {
                    messages("OCURRIÓ UN ERROR: :C")
                    binding.txtDisplayID.text = zero
                } else {
                    binding.txtDisplayID.text = String.format("%.2f", total)
                }
                timesEquals = false
            }
        } catch (ex: Exception) {
            binding.txtDisplayID.text = zero
            messages("OCURRIÓ UN ERROR: ${ex.message}")
        } finally {
            isPush = 0
        }
    }

    private fun setOperation(btn: Button) {
        if (isPush == 0) {
            timesEquals = true
            numberOne = binding.txtDisplayID.text.toString().toDouble()
            operation = btn.text.toString()
            clean = true;
            isPush++;
        } else
            messages("YA PRESIONASTE UN OPERADOR")
    }

    private fun setDigit(btn: Button) {
        if (clean) {
            binding.txtDisplayID.text = zero
            clean = false
        }
        if (binding.txtDisplayID.text == "|") binding.txtDisplayID.text = ""
        binding.txtDisplayID.text = "${binding.txtDisplayID.text}${btn.text}"
    }

    private fun setPoint(btn: Button) {
        if (binding.txtDisplayID.text.contains("."))
            messages("SOLÓ UN PUNTO DECIMAL")
        else
            binding.txtDisplayID.text =
                if (binding.txtDisplayID.text.toString() == zero) zero else "${binding.txtDisplayID.text}${btn.text}"
    }

    private fun clear() {
        binding.txtDisplayID.text = zero
        timesEquals = true
        numberOne = 0.0
        numberTwo = 0.0
        total = 0.0
        messages("PANTALLA LIMPIADA")
    }

    private fun messages(sms: String) {
        Toast.makeText(this@MainActivity, sms, Toast.LENGTH_SHORT)
            .show()
    }
}