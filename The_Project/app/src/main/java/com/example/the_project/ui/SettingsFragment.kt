package com.example.the_project.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.the_project.R


class SettingsFragment : Fragment() {

    private lateinit var logoutbutton: Button
    private lateinit var viewprofile : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        if(view!=null){
            initializeView(view)
        }

        return view
    }

    private fun initializeView(view: View) {
        logoutbutton = view.findViewById(R.id.log_out)
        viewprofile = view.findViewById(R.id.viewprofile)
    }

    private fun registerListener(){
        logoutbutton.setOnClickListener{ LogOut() }
        viewprofile.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_viewProfileFragment)
        }

    }

    private fun LogOut(){

    }





}