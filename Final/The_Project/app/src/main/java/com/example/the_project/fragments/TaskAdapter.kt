package com.example.the_project.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.the_project.R
import com.example.the_project.model.Task

class TaskAdapter(
    private var list: ArrayList<Task>,
    private val context: Context
    ) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.findViewById(R.id.task_title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.task_description)
       // val asignedToTextView: TextView = itemView.findViewById(R.id.task_asigned)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentItem = list[position]

        holder.titleTextView.text = currentItem.title
        holder.descriptionTextView.text = currentItem.description
       // holder.asignedToTextView.text = currentItem.asigned_to_user_ID.toString()
    }

    override fun getItemCount() = list.size

    fun setData(newlist: ArrayList<Task>){
        list = newlist
    }


}