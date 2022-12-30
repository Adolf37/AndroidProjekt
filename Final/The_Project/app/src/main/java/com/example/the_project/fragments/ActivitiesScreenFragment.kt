package com.example.the_project.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.the_project.R
import com.example.the_project.repository.TrackerRepository
import com.example.the_project.viewmodel.ActivitieListViewModel
import com.example.the_project.viewmodel.ActivitieListViewModelFactory
import com.example.the_project.viewmodel.UserListViewModel
import com.example.the_project.viewmodel.UserListViewModelFactory
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView


class ActivitiesScreenFragment : Fragment() {

    private lateinit var topAppBar: MaterialToolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    private lateinit var type: TextView
    private lateinit var created_by_user_id: TextView
    private lateinit var sub_type: TextView
    private lateinit var sub_id: TextView
//    private lateinit var created_time: TextView


    private lateinit var activitieListViewModel : ActivitieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ActivitieListViewModelFactory(TrackerRepository())
        activitieListViewModel = ViewModelProvider(this, factory).get(ActivitieListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_activities_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topAppBar = view.findViewById(R.id.topAppBar)
        drawerLayout = view.findViewById(R.id.drawerLayout)
        navigationView = view.findViewById(R.id.navigationView)

        initMenu()  //felso menu menjen

        type = view.findViewById(R.id.activities_type)
        created_by_user_id = view.findViewById(R.id.activities_createdbyuserid)
        sub_type = view.findViewById(R.id.activities_subtype)
        sub_id = view.findViewById(R.id.activities_subid)
 //       created_time = view.findViewById(R.id.activities_createdtime)


        activitieListViewModel.readActivities()
        activitieListViewModel.activitieList.observe(viewLifecycleOwner){
            val activitieslistInfo = activitieListViewModel.activitieList.value

            type.setText(activitieslistInfo!![0].type.toString())
            Log.i("xxx", activitieslistInfo.toString())
            created_by_user_id.setText(activitieslistInfo!![0].created_by_user_id.toString())
            sub_type.setText(activitieslistInfo!![0].sub_type.toString())
            sub_id.setText(activitieslistInfo!![0].sub_ID.toString())
  //          created_time.setText(activitieslistInfo!![0].created_time.time.toString())
        }
    }

    private fun initMenu(){
        topAppBar.setNavigationOnClickListener {
            drawerLayout.open()
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true

            when( menuItem.itemId ){
                R.id.activities -> findNavController().navigate(R.id.action_activitiesScreenFragment_self)
                R.id.my_task -> findNavController().navigate(R.id.action_activitiesScreenFragment_to_myTaskScreenFragment)
                R.id.my_groups -> findNavController().navigate(R.id.action_activitiesScreenFragment_to_userListFragment)
                R.id.settings -> findNavController().navigate(R.id.action_activitiesScreenFragment_to_settingsFragment)
                R.id.login -> findNavController().navigate(R.id.action_activitiesScreenFragment_to_loginFragment)
            }

            drawerLayout.close()
            true
        }
    }
}