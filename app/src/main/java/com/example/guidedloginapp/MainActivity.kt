package com.example.guidedloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

enum class LoginSuccess constructor(val failureValue: Int){ //class for testing login credentials
    username(1),
    password(2),
    noFail(3)
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textUsername = findViewById<TextView>(R.id.textUsernameEntry) // get the views
        val textPassword = findViewById<TextView>(R.id.textPasswordEntry)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener{
            var username = textUsername.text.toString()
            var password = textPassword.text.toString()


            fun checkLogin(username:String, password:String):LoginSuccess { //LoginSuccess method for returning boolean
                val holdUsername = "sean"
                val holdPassword = "password"

                if (username != holdUsername) {
                    return LoginSuccess.username }
                return if (password != holdPassword){
                    return LoginSuccess.password }
                else LoginSuccess.noFail

            }
            when(checkLogin(username, password)){
                LoginSuccess.username -> {
                    Toast.makeText(applicationContext, getString(R.string.errUsername),Toast.LENGTH_LONG).show()
                }
                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errPassword),Toast.LENGTH_LONG).show()
                }
                else -> {
                    val chooseClassesOpen = Intent(this, MainActivity2::class.java) // if user credentials are filled in, open class selection
                    startActivity(chooseClassesOpen)
                }
            }
        }
    }
}