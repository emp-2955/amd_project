package com.application.amd_project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.application.amd_project.R
import com.google.android.material.button.MaterialButton

class EditProfileActivity : AppCompatActivity() {

    private lateinit var firstNameEt: EditText
    private lateinit var lastNameEt: EditText
    private lateinit var mobileEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var submitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        // View binding
        firstNameEt = findViewById(R.id.firstname)
        lastNameEt = findViewById(R.id.lastname)
        mobileEt = findViewById(R.id.mobilenumber)
        emailEt = findViewById(R.id.emailid)
        submitBtn = findViewById(R.id.submitBtn)

        // TODO: Load user profile data from Firebase
        // Example:
        // - Get current user ID
        // - Fetch user document
        // - Set values in EditTexts

        submitBtn.setOnClickListener {
            validateAndSubmit()
        }
    }

    private fun validateAndSubmit() {
        val firstName = firstNameEt.text.toString().trim()
        val lastName = lastNameEt.text.toString().trim()
        val mobile = mobileEt.text.toString().trim()
        val email = emailEt.text.toString().trim()

        if (firstName.isEmpty() || lastName.isEmpty() || mobile.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return
        }

        // TODO: Update user profile in Firebase
        // Example:
        // - Create user map
        // - Save/update data in Firestore
        // - Show success/failure message

        Toast.makeText(this, "Profile submitted (TODO)", Toast.LENGTH_SHORT).show()
    }
}
