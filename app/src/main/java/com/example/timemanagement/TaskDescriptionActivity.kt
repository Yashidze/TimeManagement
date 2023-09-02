package com.example.timemanagement

// TaskDescriptionActivity.kt
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TaskDescriptionActivity : AppCompatActivity() {
    private lateinit var taskNameTextView: TextView
    private lateinit var taskDescriptionTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_description)

        taskNameTextView = findViewById(R.id.taskNameTextView)
        taskDescriptionTextView = findViewById(R.id.taskDescriptionTextView)

        val taskName = intent.getStringExtra("taskName")
        val taskDescription = intent.getStringExtra("taskDescription")
        if (taskName != null && taskDescription != null) {
            taskNameTextView.text = taskName
            taskDescriptionTextView.text = taskDescription
        }
    }
}
