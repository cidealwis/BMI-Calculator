
package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interface2)
        val i = intent
        val name = i.getStringExtra("name")
        val age = i.getIntExtra("age", 0)
        val bmi = i.getDoubleExtra("bmi", 0.0)

        val nameTextView: TextView = findViewById(R.id.getName)
        val ageTextView: TextView = findViewById(R.id.getAge)
        val bmiTextView: TextView = findViewById(R.id.getBMI)
        nameTextView.text = "$name"
        ageTextView.text = "$age"
        bmiTextView.text = "${String.format("%.2f", bmi)}"
    }
}
