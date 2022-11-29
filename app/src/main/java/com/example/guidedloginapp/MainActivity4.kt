package com.example.guidedloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var textView = findViewById<TextView>(R.id.textResults)

        var firstName = intent.getStringExtra("firstName")
        var lastName = intent.getStringExtra("lastName")
        var dob = intent.getStringExtra("dateOfBirth")
        var phone = intent.getStringExtra("phone")
        var type = intent.getStringExtra("type")
        var program = intent.getStringExtra("program")

        var class1 = intent.getStringExtra("Class1")
        var selected1 = intent.getStringExtra("radio1Text")
        var class2 = intent.getStringExtra("Class2")
        var selected2 = intent.getStringExtra("radio2Text")
        var class3 = intent.getStringExtra("Class3")
        var selected3 = intent.getStringExtra("radio3Text")
        var class4 = intent.getStringExtra("Class4")
        var selected4 = intent.getStringExtra("radio4Text")

        val ClassSchedule = StringBuilder(250)
        if (class1 != ""){
            ClassSchedule.append(class1 + "\n" + selected1 + "\n\n")
        }
        if (class2 != ""){
            ClassSchedule.append(class1 + "\n" + selected1 + "\n\n")
        }
        if (class3 != ""){
            ClassSchedule.append(class1 + "\n" + selected1 + "\n\n")
        }
        if (class4 != ""){
            ClassSchedule.append(class1 + "\n" + selected1 + "\n\n")
        }
        textView.setText(firstName+" "+ lastName + "\n" + dob + "\n" + phone + "\n" + type + ": " + program + "\n" + ClassSchedule)


//        putExtra("Class1", ctv1Text)
//        putExtra("Selected1", radio1Text)
//        putExtra("Class2", ctv2Text)
//        putExtra("Selected2", radio2Text)
//        putExtra("Class3", ctv3Text)
//        putExtra("Selected3", radio3Text)
//        putExtra("Class4", ctv4Text)
//        putExtra("Selected4", radio4Text)

    }
}