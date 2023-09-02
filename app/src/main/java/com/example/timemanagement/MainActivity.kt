package com.example.timemanagement

// MainActivity.kt
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var taskListView: ListView
    private val tasks = mutableListOf<Task>()
    private val adapter by lazy { TaskAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskListView = findViewById(R.id.taskListView)
        adapter.addAll(tasks)
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
                adapter.clear()
                adapter.addAll(tasks)
                adapter.notifyDataSetChanged()
            }
        }
    }
}
