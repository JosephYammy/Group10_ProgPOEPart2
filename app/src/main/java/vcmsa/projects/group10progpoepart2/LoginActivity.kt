package vcmsa.projects.group10progpoepart2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initializing EditText fields and Button
        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val loginButton = findViewById<Button>(R.id.buttonLogin)

        // Login button click listener
        loginButton.setOnClickListener {
            val enteredEmail = emailEditText.text.toString()
            val enteredPassword = passwordEditText.text.toString()

            // Perform validation checks
            if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
                showToast("Email and Password are required.")
            } else if (enteredEmail != storedEmail || enteredPassword != storedPassword) {
                showToast("Invalid credentials. Please try again.")
            } else {
                showToast("Login Successful!")
                // Optionally, navigate to the main app screen (e.g., HomeActivity)
                // startActivity(Intent(this, HomeActivity::class.java))
            }
        }
    }

    // Helper function to show a toast message
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
