package vcmsa.projects.budgettrackergroup10

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var transactions: ArrayList<Transaction>
    private lateinit var transactionAdapter: TransactionAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    // Add references to your TextViews
    private lateinit var balance: TextView
    private lateinit var budget: TextView
    private lateinit var expense: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize TextViews
        balance = findViewById(R.id.balance)
        budget = findViewById(R.id.budget)
        expense = findViewById(R.id.expense)

        // 1. Prepare data
        transactions = arrayListOf(
            Transaction(label = "Weekend budget", amount = 400.00),
            Transaction(label = "Bananas", amount = -4.00),
            Transaction(label = "Gasoline", amount = -40.90),
            Transaction(label = "Breakfast", amount = -9.99),
            Transaction(label = "Water bottles", amount = -4.00),
            Transaction(label = "Suncream", amount = -8.00),
            Transaction(label = "Car Park", amount = -15.00)
        )

        // 2. Set up RecyclerView
        transactionAdapter = TransactionAdapter(transactions)
        linearLayoutManager = LinearLayoutManager(this)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        recyclerView.apply {
            adapter = transactionAdapter
            layoutManager = linearLayoutManager
        }

        // 3. Update dashboard
        updateDashboard()
    }

    private fun updateDashboard() {
        val totalAmount: Double = transactions.map { it.amount }.sum()
        val budgetAmount: Double = transactions.filter { it.amount > 0 }.map { it.amount }.sum()
        val expenseAmount: Double = totalAmount - budgetAmount

        balance.text = "R %.2f".format(totalAmount)
        budget.text = "R %.2f".format(budgetAmount)
        expense.text = "R %.2f".format(expenseAmount)
    }
}
