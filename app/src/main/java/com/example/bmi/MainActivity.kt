
package com.example.bmi

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun visitNextUI(view: View?) {
        val inputName: EditText = findViewById<View>(R.id.editName) as EditText
        val inputAge: EditText = findViewById<View>(R.id.editAge) as EditText
        val inputHeight: EditText = findViewById<View>(R.id.editHeight) as EditText
        val inputWeight: EditText = findViewById<View>(R.id.editWeight) as EditText

        val name = inputName.text.toString()
        val age = inputAge.text.toString().toIntOrNull() ?: 0
        val height = inputHeight.text.toString().toDoubleOrNull() ?: 0.0
        val weight = inputWeight.text.toString().toDoubleOrNull() ?: 0.0

        val bmi = calculateBMI(weight, height)

        val roundedBmi = String.format("%.2f", bmi).toDouble()

        val bundle = Bundle().apply {
            putString("name", name)
            putInt("age", age)
            putDouble("bmi", roundedBmi)
        }

        val gotoNextScreen = Intent(this, SecondScreen::class.java)
        gotoNextScreen.putExtras(bundle)
        startActivity(gotoNextScreen)
    }

    private fun calculateBMI(weight: Double, height: Double): Double {
        return weight / (height * height)
    }
}
