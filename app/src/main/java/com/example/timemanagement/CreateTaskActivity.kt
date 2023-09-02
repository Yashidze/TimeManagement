package com.example.timemanagement

// CreateTaskActivity.kt
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class CreateTaskActivity : AppCompatActivity() {
    private lateinit var taskEditText: EditText
    private lateinit var descriptionEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        taskEditText = findViewById(R.id.taskEditText)
        descriptionEditText = findViewById(R.id.descriptionEditText)
    }

    fun saveTask(view: View) {
        val taskName = taskEditText.text.toString()
        val taskDescription = descriptionEditText.text.toString()
        val intent = Intent()
        intent.putExtra("taskName", taskName)
        intent.putExtra("taskDescription", taskDescription)
        setResult(RESULT_OK, intent)
        finish()
    }
}

