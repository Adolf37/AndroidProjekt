package com.example.the_project.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.the_project.R
import com.example.the_project.repository.TrackerRepository
import com.example.the_project.viewmodel.*


class MyTaskScreenFragment : Fragment() {

    lateinit var taskTitle: TextView
    lateinit var taskDescription: TextView
    lateinit var taskCreatedTime: TextView

    private lateinit var taskListViewModel : TaskListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = TaskListViewModelFactory(requireContext(), TrackerRepository())
        taskListViewModel = ViewModelProvider(this, factory).get(TaskListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_task_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskTitle = view.findViewById(R.id.task_title)
        taskDescription = view.findViewById(R.id.task_description)
        taskCreatedTime = view.findViewById(R.id.task_created_time)

        taskListViewModel.getTasks()
        taskListViewModel.taskList.observe(viewLifecycleOwner){
            val taskListInfo = taskListViewModel.taskList.value

            taskTitle.setText(taskListInfo!![0].title)
            Log.i("xxx", taskListInfo.toString())
            taskDescription.text = taskListInfo!![0].description
            //taskDescription.setText(taskListInfo!!.description)
            taskCreatedTime.setText(taskListInfo!![0].created_time.toString())
        }
    }
}