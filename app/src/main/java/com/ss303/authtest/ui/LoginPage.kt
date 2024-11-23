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

class LoginPage : AppCompatActivity() {
    val users = mapOf(
        "ss303@mail.com" to "pass",
        "test@mail.com" to "test"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)

        findViewById<Button>(R.id.btn_loginpage_login).setOnClickListener{
            val email = findViewById<EditText>(R.id.tbox_loginpage_email).text.toString()
            val pass = findViewById<EditText>(R.id.tbox_loginpage_password).text.toString()

            if (users.containsKey(email) && users[email] == pass) {
                val home = Intent(this, Home::class.java)
                home.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(home)
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}