package com.example.guidedloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var results = findViewById<TextView>(R.id.textselectionResults) // retieve data from intent

        var dateOfBirth = intent.getStringExtra("dateOfBirth")
        var firstName = intent.getStringExtra("firstName")
        var lastName = intent.getStringExtra("lastName")
        var phoneNumber = intent.getStringExtra("phoneNumber")
        var type = intent.getStringExtra("type")
        var program = intent.getStringExtra("program")

        results.setText(firstName + lastName + "\n" + dateOfBirth + "\n"+ phoneNumber + "\n" + type + program)
    }
}// set "results" TextView to user's entered information :-)