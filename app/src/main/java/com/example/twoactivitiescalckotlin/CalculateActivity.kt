package com.example.twoactivitiescalckotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_calculate.*

class CalculateActivity : AppCompatActivity() {

    private var numberOne: String? = null
    private var numberTwo: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)
        fillFields()
    }

    private fun fillFields() {
        val intent = intent
        numberOne = intent.getStringExtra(MainActivity.FIRST_NUMBER)
        numberTwo = intent.getStringExtra(MainActivity.SECOND_NUMBER)
        firstNumber.text = numberOne
        secondNumber.text = numberTwo
    }

    fun add(view: View){
        val sum = numberOne!!.toInt().plus(numberTwo!!.toInt())
        mathResult(sum)
    }

    fun subtract(view: View){
        val sum = numberOne!!.toInt().minus(numberTwo!!.toInt())
        mathResult(sum)
    }

    private fun mathResult(sum: Int){
        setResult(
            Activity.RESULT_OK, Intent(this, MainActivity::class.java).
            putExtra(MainActivity.FIRST_NUMBER, numberOne).
            putExtra(MainActivity.SECOND_NUMBER, numberTwo).
            putExtra(MainActivity.SUM, sum))
            finish()
    }
}
