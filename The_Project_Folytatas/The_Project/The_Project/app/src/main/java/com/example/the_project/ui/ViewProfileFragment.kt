package com.example.the_project.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.the_project.MyApplication
import com.example.the_project.R
import com.example.the_project.repository.TrackerRepository
import com.example.the_project.viewmodel.ProfileViewModel
import com.example.the_project.viewmodel.ProfileViewModelFactory


class ViewProfileFragment : Fragment() {

    lateinit var userProfileImage : ImageView
    lateinit var userName : TextView
    lateinit var userEmail : TextView
    lateinit var userPhoneNumber : TextView

    private lateinit var profViewModel : ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ProfileViewModelFactory(requireContext(), TrackerRepository())
        profViewModel = ViewModelProvider(this, factory).get(ProfileViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userProfileImage = view.findViewById(R.id.fragProfile_profilePic)
        userName = view.findViewById(R.id.fragProfile_firstName)
        userEmail = view.findViewById(R.id.fragProfile_email)
        userPhoneNumber = view.findViewById(R.id.fragProfile_phoneNumber)

        profViewModel.getUserInformation()
        profViewModel.user.observe(viewLifecycleOwner){
            val profuser = profViewModel.user.value

            userName.setText(profuser!!.first_name)
            Log.i("xxx", profuser.toString())
            userEmail.setText(profuser!!.email)
            Log.i("xxx", profuser.toString())
          //  userPhoneNumber.setText(profuser!!.phone_number)
            Log.i("xxx", profuser.toString())
            //userProfileImage.setImageURI()
            userPhoneNumber.setText(profuser!!.phone_number.toString())
        }
    }
}