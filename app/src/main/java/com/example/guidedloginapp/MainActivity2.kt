package com.example.guidedloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val getFirstName = findViewById<EditText>(R.id.editFirstName) //find all the views
        val getLastName = findViewById<EditText>(R.id.editLastName)
        val getBirthMonth = findViewById<Spinner>(R.id.spnBirthMonth)
        val getBirthDay = findViewById<EditText>(R.id.editDay)
        val getBirthYear = findViewById<EditText>(R.id.editYear)
        val getPhone = findViewById<EditText>(R.id.editPhone)

        val textCertificate = findViewById<TextView>(R.id.textCert)
        val textAssociates = findViewById<TextView>(R.id.textAAS)

        var programSwitch = findViewById<Switch>(R.id.swtCertAAS)
        val prgmCert = findViewById<Spinner>(R.id.spnCert)
        val prgmAAS = findViewById<Spinner>(R.id.spnAAS)

        val btnNext = findViewById<Button>(R.id.btnNext)

        getFirstName.requestFocus() //better fill in the name..

        programSwitch.setOnCheckedChangeListener { buttonView, isChecked -> // the switch, and the if else for visible spinners
            if (isChecked) {
                textAssociates.visibility = View.VISIBLE
                prgmAAS.visibility = View.VISIBLE
                textCertificate.visibility = View.GONE
                prgmCert.visibility = View.GONE
            } else {
                textAssociates.visibility = View.GONE
                prgmAAS.visibility = View.GONE
                textCertificate.visibility = View.VISIBLE
                prgmCert.visibility = View.VISIBLE
            }
        }

        fun validation(): Boolean {
            val firstName = findViewById<EditText>(R.id.editFirstName) // function, and error codes, return success if all boxes are filled out(except date and progam)
            val lastName = findViewById<EditText>(R.id.editLastName)
            val phoneNumber = findViewById<EditText>(R.id.editPhone)
            val dayOfBirth = findViewById<EditText>(R.id.editDay)
            val yearOfBirth = findViewById<EditText>(R.id.editYear)

            if (firstName.text.toString().isBlank()) {
                firstName.error = "First name is empty."
                getFirstName.requestFocus()
                return false
            }
            if (lastName.text.toString().isBlank()) {
                lastName.error = "Last name is empty."
                lastName.requestFocus()
                return false
            }
            if (phoneNumber.text.toString().isBlank()) {
                phoneNumber.error = "The phone number is empty."
                phoneNumber.requestFocus()
                return false
            }
            if (dayOfBirth.text.toString().isBlank()) {
                dayOfBirth.error = "The date of Birth is empty."
                dayOfBirth.requestFocus()
                return false
            }
            if (yearOfBirth.text.toString().isBlank()) {
                yearOfBirth.error = "The year is empty."
                yearOfBirth.requestFocus()
                return false
            }
            return true
        }

        btnNext.setOnClickListener {  // putextra the user's information, and open the next page
            if (validation()) {
                var doDob = ""
                doDob = getBirthMonth.selectedItem.toString() + "/" +
                        getBirthDay.text.toString() + "/" + getBirthYear.text.toString()

                val nextPage = Intent(this, MainActivity3::class.java)
                nextPage.putExtra("dateOfBirth", doDob)
                nextPage.putExtra("firstName", getFirstName.text.toString())
                nextPage.putExtra("lastName", getLastName.text.toString())
                nextPage.putExtra("phoneNumber", getPhone.text.toString())

                if (programSwitch.isChecked){
                    var selectedPrgram = prgmAAS.selectedItem.toString()!!
                    nextPage.putExtra("type", "AAS")
                    nextPage.putExtra("program", selectedPrgram)
                } else{
                    var selectedPrgram = prgmCert.selectedItem.toString()!!
                    nextPage.putExtra("type", "Certificate")
                    nextPage.putExtra("program", selectedPrgram)
                }

//                    if (prgmCert.visibility == View.VISIBLE  && prgmAAS.visibility == View.GONE) {
//                        nextPage.putExtra("program", "Certificate")
//                        nextPage.putExtra("certificate", prgmCert.selectedItem.toString())
//                    } else {
//                        nextPage.putExtra("program", "AAS")
//                        nextPage.putExtra("degree", prgmAAS.selectedItem.toString())
//                    }
                startActivity(nextPage)
            }
        }
    }
}