package com.ss303.authtest.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ss303.authtest.R
import kotlin.math.log

class SignupPage2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup_page2)

        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val age = intent.getIntExtra("age", 0)

        findViewById<Button>(R.id.btn_signup_register).setOnClickListener {
            val email = findViewById<EditText>(R.id.tbx_signup_email).text.toString()
            val pass = findViewById<EditText>(R.id.tbx_signup_password).text.toString()
            val confirm_pass = findViewById<EditText>(R.id.tbx_signup_confirm_password).text.toString()
            if (email != "" && pass != "") {
                if (pass == confirm_pass) {
//                    if (BuildConfig.DEBUG) {
                        Log.i("signup", """
                        | Signup complete with following info
                        |   name:    $name
                        |   address: $address
                        |   age:     $age
                        |   email:   $email
                        |   pass:    $pass
                    """.trimMargin())
//                    }
                    Toast.makeText(this, "Signup Successful!!", Toast.LENGTH_SHORT)

                    val home = Intent(this, Home::class.java)
                    home.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)

                    startActivity(home)
                } else {
                    Toast.makeText(this, "Passwords didn't match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}