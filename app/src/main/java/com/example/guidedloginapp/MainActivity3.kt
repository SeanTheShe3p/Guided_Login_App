package com.example.guidedloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.graphics.Color
import android.graphics.Color.GREEN

//private var ctv1: CheckedTextView? = null
//private var ctv2: CheckedTextView? = null
//private var ctv3: CheckedTextView? = null
//private var ctv4: CheckedTextView? = null
//
//private var rad1: RadioButton? = null
//private var rad2: RadioButton? = null
//private var rad3: RadioButton? = null
//private var rad4: RadioButton? = null
//private var rad5: RadioButton? = null
//private var rad6: RadioButton? = null
//private var rad7: RadioButton? = null
//private var rad18: RadioButton? = null
//
//private var rg1: RadioGroup? = null
//private var rg2: RadioGroup? = null
//private var rg3: RadioGroup? = null
//private var rg4: RadioGroup? = null

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)



        if (intent.extras != null) {
            var dateOfBirth = intent.getStringExtra("dateOfBirth")
            var firstName = intent.getStringExtra("firstName")
            var lastName = intent.getStringExtra("lastName")
            var phoneNumber = intent.getStringExtra("phoneNumber")
            var type = intent.getStringExtra("type")
            var program = intent.getStringExtra("program")
        }

        var ctv1 = findViewById<CheckedTextView>(R.id.ctvClassOption1)
        var ctv2 = findViewById<CheckedTextView>(R.id.ctvClassOption2)
        var ctv3 = findViewById<CheckedTextView>(R.id.ctvClassOption3)
        var ctv4 = findViewById<CheckedTextView>(R.id.ctvClassOption4)

        var rad1 = findViewById<RadioButton>(R.id.radBtnClassOption1)
        var rad2 = findViewById<RadioButton>(R.id.radBtnClassOption2)
        var rad3 = findViewById<RadioButton>(R.id.radBtnClassOption3)
        var rad4 = findViewById<RadioButton>(R.id.radBtnClassOption4)
        var rad5 = findViewById<RadioButton>(R.id.radBtnClassOption5)
        var rad6 = findViewById<RadioButton>(R.id.radBtnClassOption6)
        var rad7 = findViewById<RadioButton>(R.id.radBtnClassOption7)
        var rad8 = findViewById<RadioButton>(R.id.radBtnClassOption8)

        var btnFin = findViewById<Button>(R.id.btnFinal)

        btnFin.setOnClickListener {

            var ctv1Text = ""
            var ctv2Text = ""
            var ctv3Text = ""
            var ctv4Text = ""
            var radio1Text = ""
            var radio2Text = ""
            var radio3Text = ""
            var radio4Text = ""
            var rg1 = findViewById<RadioGroup>(R.id.radioGroup)
            var rg2 = findViewById<RadioGroup>(R.id.radioGroup2)
            var rg3 = findViewById<RadioGroup>(R.id.radioGroup3)
            var rg4 = findViewById<RadioGroup>(R.id.radioGroup4)
            var selectedTime1 = 0
            var selectedTime2 = 0
            var selectedTime3 = 0
            var selectedTime4 = 0

            if (ctv1!!.isChecked) {
                var radioButton: RadioButton
                ctv1Text = ctv1.text.toString() // redundant?
                selectedTime1 = rg1!!.checkedRadioButtonId
                radioButton = findViewById<RadioButton>(selectedTime1)
                radio1Text = radioButton.text.toString()
            }
            if (ctv2!!.isChecked) {
                var radioButton: RadioButton
                ctv2Text = ctv2.text.toString() // redundant?
                selectedTime2 = rg2!!.checkedRadioButtonId
                radioButton = findViewById<RadioButton>(selectedTime2)
                radio2Text = radioButton.text.toString()
            }
            if (ctv3!!.isChecked) {
                var radioButton: RadioButton
                ctv3Text = ctv3.text.toString() // redundant?
                selectedTime3 = rg3!!.checkedRadioButtonId
                radioButton = findViewById<RadioButton>(selectedTime3)
                radio3Text = radioButton.text.toString()
            }
            if (ctv4!!.isChecked) {
                var radioButton: RadioButton
                ctv4Text = ctv4.text.toString() // redundant?
                selectedTime4 = rg4!!.checkedRadioButtonId
                radioButton = findViewById<RadioButton>(selectedTime4)
                radio4Text = radioButton.text.toString()
            }
            fun radioCheck(selectedTime1: Int, selectedTime2: Int, selectedTime3: Int, selectedTime4: Int): Boolean {
                if (selectedTime1 == R.id.radBtnClassOption2 && selectedTime4 == R.id.radBtnClassOption7) {
                    rad2!!.error = "Timeslot conflict."
                    rad7!!.error = "Timeslot conflict."
                    return false
                }

                if (selectedTime1 == R.id.radBtnClassOption1 && selectedTime2 == R.id.radBtnClassOption3) {
                    rad1!!.error = "Timeslot conflict."
                    rad3!!.error = "Timeslot conflict."
                    return false
                }
                if (selectedTime3 == R.id.radBtnClassOption5 && selectedTime4 == R.id.radBtnClassOption8) {
                    rad5!!.error = "Timeslot conflict."
                    rad8!!.error = "Timeslot conflict."
                    return false
                } else
                    return true
            }

                if (radioCheck(selectedTime1, selectedTime2, selectedTime3, selectedTime4)) {
                    val finalScreen = Intent(this, MainActivity4::class.java).apply {
                        var firstName = intent.getStringExtra("firstName")
                        var lastName = intent.getStringExtra("lastName")
                        var dob = intent.getStringExtra("dateOfBirth")
                        var phone = intent.getStringExtra("phone")
                        var type = intent.getStringExtra("type")
                        var program = intent.getStringExtra("program")
                        putExtra("firstName", firstName)
                        putExtra("lastName", lastName)
                        putExtra("dob", dob)
                        putExtra("phone", phone)
                        putExtra("type", type)
                        putExtra("program", program)
                        putExtra("Class1", ctv1Text)
                        putExtra("Selected1", radio1Text)
                        putExtra("Class2", ctv2Text)
                        putExtra("Selected2", radio2Text)
                        putExtra("Class3", ctv3Text)
                        putExtra("Selected3", radio3Text)
                        putExtra("Class4", ctv4Text)
                        putExtra("Selected4", radio4Text)
                    }
                    startActivity(finalScreen)
                } else {
                    Toast.makeText(this, "Preselected Class Conflict", Toast.LENGTH_SHORT).show()
                }
                rad1!!.setOnCheckedChangeListener { buttonView, isChecked ->
                    rad1!!.error = null
                    rad2!!.error = null
                    rad3!!.error = null
                    rad4!!.error = null
                    rad5!!.error = null
                    rad6!!.error = null
                    rad7!!.error = null
                    rad8!!.error = null
                }
                rad2!!.setOnCheckedChangeListener { buttonView, isChecked ->
                    rad1!!.error = null
                    rad2!!.error = null
                    rad3!!.error = null
                    rad4!!.error = null
                    rad5!!.error = null
                    rad6!!.error = null
                    rad7!!.error = null
                    rad8!!.error = null
                }
                rad3!!.setOnCheckedChangeListener { buttonView, isChecked ->
                    rad1!!.error = null
                    rad2!!.error = null
                    rad3!!.error = null
                    rad4!!.error = null
                    rad5!!.error = null
                    rad6!!.error = null
                    rad7!!.error = null
                    rad8!!.error = null
                }
                rad4!!.setOnCheckedChangeListener { buttonView, isChecked ->
                    rad1!!.error = null
                    rad2!!.error = null
                    rad3!!.error = null
                    rad4!!.error = null
                    rad5!!.error = null
                    rad6!!.error = null
                    rad7!!.error = null
                    rad8!!.error = null
                }
                rad5!!.setOnCheckedChangeListener { buttonView, isChecked ->
                    rad1!!.error = null
                    rad2!!.error = null
                    rad3!!.error = null
                    rad4!!.error = null
                    rad5!!.error = null
                    rad6!!.error = null
                    rad7!!.error = null
                    rad8!!.error = null
                }
                rad6!!.setOnCheckedChangeListener { buttonView, isChecked ->
                    rad1!!.error = null
                    rad2!!.error = null
                    rad3!!.error = null
                    rad4!!.error = null
                    rad5!!.error = null
                    rad6!!.error = null
                    rad7!!.error = null
                    rad8!!.error = null
                }
                rad7!!.setOnCheckedChangeListener { buttonView, isChecked ->
                    rad1!!.error = null
                    rad2!!.error = null
                    rad3!!.error = null
                    rad4!!.error = null
                    rad5!!.error = null
                    rad6!!.error = null
                    rad7!!.error = null
                    rad8!!.error = null
                }
                rad8!!.setOnCheckedChangeListener { buttonView, isChecked ->
                    rad1!!.error = null
                    rad2!!.error = null
                    rad3!!.error = null
                    rad4!!.error = null
                    rad5!!.error = null
                    rad6!!.error = null
                    rad7!!.error = null
                    rad8!!.error = null
                }
                fun enableDisable(
                    ctv: CheckedTextView?,
                    rad1: RadioButton?,
                    rad2: RadioButton?,
                    bgColor: Int?,
                    state: Boolean?
                ) {
                    ctv!!.isChecked = state!!
                    ctv.setBackgroundColor(bgColor!!)
                    rad1!!.isEnabled = state
                    rad2!!.isEnabled = state

                    rad1.isChecked = state

                    if (!state) {
                        rad1.isChecked = state
                        rad2.isChecked = state
                    }
                }
                ctv1!!.setOnClickListener {
                    if (ctv1!!.isChecked) {
                        enableDisable(ctv1, rad1, rad2, Color.GREEN, false)
                    } else {
                        enableDisable(ctv1, rad1, rad2, Color.BLACK, true)
                    }
                }
        }
    }
}
