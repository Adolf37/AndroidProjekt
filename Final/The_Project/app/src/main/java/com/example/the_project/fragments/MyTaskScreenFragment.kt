package com.example.the_project.fragments


import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.the_project.R
import com.example.the_project.databinding.FragmentMyTaskScreenBinding
import com.example.the_project.model.Task
import com.example.the_project.repository.TrackerRepository
import com.example.the_project.viewmodel.*
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MyTaskScreenFragment : Fragment() {

    private var _binding : FragmentMyTaskScreenBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var taskListViewModel: TaskListViewModel
    private lateinit var recycler_view: RecyclerView
    private lateinit var adapter: TaskAdapter
    private lateinit var layoutManager: LayoutManager

    private lateinit var topAppBar: MaterialToolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyTaskScreenBinding.inflate(inflater, container, false)
        val view = binding.root

        topAppBar = binding.topAppBar
        drawerLayout = binding.drawerLayout
        navigationView = binding.navigationView

        val factory = TaskListViewModelFactory(requireContext(), TrackerRepository())
        taskListViewModel = ViewModelProvider(this, factory).get(TaskListViewModel::class.java)

        recycler_view = binding.recyclerView
        setupRecyclerView()
        taskListViewModel.getTasks()
        taskListViewModel.taskList.observe(viewLifecycleOwner){
            adapter.setData(taskListViewModel.taskList.value as ArrayList<Task>)
            adapter.notifyDataSetChanged()
        }

        initMenu()

        return view
    }

    private fun setupRecyclerView(){
        Log.d("myMarketFragxxx", "idaig eljut5!")
        adapter = TaskAdapter(ArrayList<Task>(), this.requireContext())
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        recycler_view.setHasFixedSize(true)
    }

    private fun initMenu() {
        topAppBar.setNavigationOnClickListener {
            drawerLayout.open()
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true

            when (menuItem.itemId) {
                R.id.activities -> findNavController().navigate(R.id.action_myTaskScreenFragment_to_activitiesScreenFragment)
                R.id.my_task -> findNavController().navigate(R.id.action_myTaskScreenFragment_self)
                R.id.my_groups -> findNavController().navigate(R.id.action_myTaskScreenFragment_to_userListFragment)
                R.id.settings -> findNavController().navigate(R.id.action_myTaskScreenFragment_to_settingsFragment)
                R.id.login -> findNavController().navigate(R.id.action_myTaskScreenFragment_to_loginFragment)
            }

            drawerLayout.close()
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

