package com.ss303.authtest.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ss303.authtest.R

class SignupPage1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup_page1)

        findViewById<Button>(R.id.btn_signup_next).setOnClickListener {
            val name = findViewById<EditText>(R.id.tbx_name).text.toString()
            val address = findViewById<EditText>(R.id.tbx_address).text.toString()
            val age = findViewById<EditText>(R.id.tbx_age).text.toString().toIntOrNull() ?: 0

            if (name == "" || address == "" || age <= 0) {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
            } else {
                val signupPage2 = Intent(this, SignupPage2::class.java)

                signupPage2.putExtra("name", name)
                signupPage2.putExtra("address", address)
                signupPage2.putExtra("age", age)

                startActivity(signupPage2)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}