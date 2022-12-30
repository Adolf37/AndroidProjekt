package com.example.the_project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController
import com.example.the_project.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView


class SettingsFragment : Fragment() {

    private lateinit var logoutbutton: Button
    private lateinit var viewprofile : Button

    private lateinit var topAppBar: MaterialToolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logoutbutton = view.findViewById(R.id.log_out)
        viewprofile = view.findViewById(R.id.view_profile)

        topAppBar = view.findViewById(R.id.topAppBar)
        drawerLayout = view.findViewById(R.id.drawerLayout)
        navigationView = view.findViewById(R.id.navigationView)
        initMenu()

        logoutbutton.setOnClickListener{ LogOut() }
        viewprofile.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_viewProfileFragment)
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
                R.id.activities -> findNavController().navigate(R.id.action_settingsFragment_to_activitiesScreenFragment)
                R.id.my_task -> findNavController().navigate(R.id.action_settingsFragment_to_myTaskScreenFragment)
                R.id.my_groups -> findNavController().navigate(R.id.action_settingsFragment_to_userListFragment)
                //R.id.settings -> findNavController().navigate(R.id.action_settingsFragment_to_self)
                R.id.login -> findNavController().navigate(R.id.action_settingsFragment_to_loginFragment)
            }

            drawerLayout.close()
            true
        }
    }

    private fun LogOut(){

    }
}