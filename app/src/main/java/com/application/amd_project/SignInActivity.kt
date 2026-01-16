package com.application.amd_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class SignInActivity : ComponentActivity() {

    private lateinit var etUsernameEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnGoogle: Button
    private lateinit var tvSignup: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in) // your XML file

        // Initialize views
        etUsernameEmail = findViewById(R.id.etUsernameEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnGoogle = findViewById(R.id.btnGoogle)
        tvSignup = findViewById(R.id.tvSignup)

        // Login button click
        btnLogin.setOnClickListener {
            validateAndLogin()
        }

        // Google Sign-In
        btnGoogle.setOnClickListener {
            Toast.makeText(this, "Google Sign-In clicked", Toast.LENGTH_SHORT).show()
            // TODO: Implement Google Sign-In
        }

        // "Don't have an account? Sign Up"
        tvSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validateAndLogin() {
        val usernameOrEmail = etUsernameEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        if (usernameOrEmail.isEmpty()) {
            etUsernameEmail.error = "Username or Email is required"
            etUsernameEmail.requestFocus()
            return
        }

        if (password.isEmpty()) {
            etPassword.error = "Password is required"
            etPassword.requestFocus()
            return
        } else if (password.length < 6) {
            etPassword.error = "Password must be at least 6 characters"
            etPassword.requestFocus()
            return
        }

        Toast.makeText(this, "Login Successful (placeholder)", Toast.LENGTH_SHORT).show()
        // TODO: Implement Firebase login
    }
}
