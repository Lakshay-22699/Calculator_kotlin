package com.example.calculator_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.calculator_kotlin.databinding.ActivityMain2Binding
import com.example.calculator_kotlin.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var txtInput: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)
        txtInput=binding.textView
    }

    fun addd(view: View) {
        val txt = binding.editTextTextPersonName.text.toString()+binding.editTextTextPersonName2.text.toString()+binding.editTextTextPersonName3.text.toString()
        val expression = ExpressionBuilder(txt).build()
        try {
            val result = expression.evaluate()
            txtInput.text = result.toString()
        } catch (ex: ArithmeticException) {
            txtInput.text = "Error"
        }

    }

    fun cal(view: View) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}