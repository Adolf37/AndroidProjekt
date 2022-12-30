package com.example.the_project.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.the_project.MyApplication
import com.example.the_project.R
import com.example.the_project.model.LoginRequest
import com.example.the_project.model.LoginResult
import com.example.the_project.model.UpdateProfileRequest
import com.example.the_project.model.UpdateProfileResult
import com.example.the_project.repository.TrackerRepository
import com.example.the_project.viewmodel.*
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.launch


class UpdateProfileFragment : Fragment() {

    private lateinit var emailField : EditText
    private lateinit var userNameField : EditText
    private lateinit var phoneNumberField : EditText
    private lateinit var locationField: EditText
    private lateinit var submitBtn : Button

    private lateinit var updateProfViewModel : UpdateProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val factory = LoginViewModelFactory(TrackerRepository())
//        updateProfViewModel = ViewModelProvider(this, factory).get(UpdateProfileViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_update_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailField = view.findViewById(R.id.updateprof_email)
        userNameField = view.findViewById(R.id.updateprof_name)
        phoneNumberField = view.findViewById(R.id.updateprof_phonenumber)
        locationField = view.findViewById(R.id.updateprof_location)
        submitBtn = view.findViewById(R.id.submitbutton)

        submitBtn.setOnClickListener {
            val username = userNameField.text.toString().trim()
            val email = emailField.text.toString().trim()
            val phone_number = phoneNumberField.text.toString().trim()
            val location = locationField.text.toString().trim()
            if (email.isEmpty() || username.isEmpty()) {
                Toast.makeText(
                    this.requireContext(),
                    "Please, enter your name and email",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                updateProfViewModel.updateprofile(UpdateProfileRequest(username, email, phone_number, location))
            }
        }
//
//        updateProfViewModel.updateprofileResult.observe(viewLifecycleOwner) {
//            // Save data to preferences
//            if ( it == UpdateProfileResult.SUCCESS ) {
//                val prefs = requireActivity().getPreferences(Context.MODE_PRIVATE)
//                val edit = prefs.edit()
//                edit.putString("first_name", userNameField.text.toString())
//                edit.putString("email", emailField.text.toString())
//                edit.putString("phone_number", phoneNumberField.text.toString())
//                edit.putString("location", locationField.text.toString())
//                edit.apply()
//                findNavController().navigate(R.id.action_updateProfileFragment_to_viewProfileFragment)
//            }
//        }
    }
}