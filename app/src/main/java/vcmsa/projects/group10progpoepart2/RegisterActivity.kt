package vcmsa.projects.group10progpoepart2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// Global variables to store user details
var storedEmail: String? = null
var storedPassword: String? = null

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initializing EditText and Button
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val registerButton = findViewById<Button>(R.id.button2)

        // Register button click listener
        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Perform validation checks
            if (email.isEmpty() || password.isEmpty()) {
                showToast("Email and Password are required.")
            } else if (!isValidEmail(email)) {
                showToast("Please enter a valid email.")
            } else {
                // Store user details in global variables
                storedEmail = email
                storedPassword = password

                // Go to LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

                // Optionally, show a success message
                showToast("Registration Successful!")
            }
        }
    }

    // Helper function to show a toast message
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Helper function to validate email format using regex
    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@(.+)\$"
        return email.matches(emailRegex.toRegex())
    }
}
