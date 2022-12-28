package com.example.the_project

import android.os.Bundle
import android.util.Log
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var topAppBar: MaterialToolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeView()
        initMenu()  //felso menu menjen

        val controller = findNavController(R.id.nav_host_fragment)

        // Read data from preferences
        val prefs = this.getPreferences(MODE_PRIVATE)
        val token = prefs.getString("token", "")
        val deadline = prefs.getLong("deadline", 0L)

        Log.i("xxx", "token: " + token)
        // @TODO - check the token's validity
        val isValid = true
        if (!token.equals("") && isValid ) {
            MyApplication.token = token!!
            MyApplication.email = prefs.getString("email","")!!

            controller.navigate(R.id.activitiesScreenFragment)
        }

    }

    private fun initializeView() {
        topAppBar = findViewById(R.id.topAppBar)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
    }

    private fun initMenu(){
        topAppBar.setNavigationOnClickListener {
            drawerLayout.open()
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item selected
            menuItem.isChecked = true

            when( menuItem.itemId ){
                R.id.activities -> findNavController(R.id.nav_host_fragment).navigate(R.id.activitiesScreenFragment)
                R.id.my_task -> findNavController(R.id.nav_host_fragment).navigate(R.id.myTaskScreenFragment)
                R.id.my_groups -> findNavController(R.id.nav_host_fragment).navigate(R.id.userListFragment)
                R.id.settings -> findNavController(R.id.nav_host_fragment).navigate(R.id.settingsFragment)
                R.id.login -> findNavController(R.id.nav_host_fragment).navigate(R.id.loginFragment)
            }

            drawerLayout.close()
            true
        }
    }

}