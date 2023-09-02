package com.example.timemanagement

// MainActivity.kt
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var taskListView: ListView
    private val tasks = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskListView = findViewById(R.id.taskListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks.map { it.name })
        taskListView.adapter = adapter

        taskListView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, TaskDescriptionActivity::class.java)
            intent.putExtra("taskName", tasks[position].name)
            intent.putExtra("taskDescription", tasks[position].description)
            startActivity(intent)
        }
    }

    fun createTask(view: View) {
        val intent = Intent(this, CreateTaskActivity::class.java)
        startActivityForResult(intent, 1)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val taskName = data?.getStringExtra("taskName")
            val taskDescription = data?.getStringExtra("taskDescription")
            if (taskName != null && taskDescription != null) {
                val task = Task(taskName, taskDescription)
                tasks.add(task)
                (taskListView.adapter as ArrayAdapter<*>).notifyDataSetChanged()
            }
        }
    }
}
