package com.example.timemanagement

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class TaskAdapter(
    private val context: Context,
    private val resource: Int,
    private val textViewResourceId: Int
) : ArrayAdapter<Task>(context, resource, textViewResourceId) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        view.findViewById<TextView>(android.R.id.text1).text = getItem(position)?.name
        view.findViewById<TextView>(android.R.id.text2).text = getItem(position)?.description
        return view
    }
}
