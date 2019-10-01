package com.example.twoactivitiescalckotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val FIRST_NUMBER = "FIRST"
        const val SECOND_NUMBER = "SECOND"
        const val SUM = "SUM"
        const val RESULT = 42
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnChangeListeners()
    }

    fun calculate(view: View){
        if(!checkIfEmpty()) sendToCalculate()
    }

    private fun sendToCalculate() {
        val intent = Intent(this, CalculateActivity::class.java)
        putIntent(intent)
        startActivityForResult(intent, RESULT)
    }

    private fun setOnChangeListeners(){

        firstNumber.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus && firstNumber.text.toString() == "0"){
                firstNumber.setText("")
            }
        }

        secondNumber.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus && secondNumber.text.toString() == "0"){
                secondNumber.setText("")
            }
        }

    }

    private fun putIntent(intent: Intent){
        intent.putExtra(FIRST_NUMBER ,firstNumber.text.toString())
        intent.putExtra(SECOND_NUMBER, secondNumber.text.toString())
    }

    private fun checkIfEmpty() = firstNumber.text.toString().isEmpty()
            && secondNumber.text.toString().isEmpty()

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RESULT){
            if(resultCode == Activity.RESULT_OK) {
                val numberOne = data!!.getStringExtra(FIRST_NUMBER)
                val numberTwo = data.getStringExtra(SECOND_NUMBER)
                val sum = data.getIntExtra(SUM, 0)

                firstNumber.setText(numberOne)
                secondNumber.setText(numberTwo)
                result.text = sum.toString()
            }
        }
    }
}
