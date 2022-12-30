package com.example.the_project.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.the_project.R
import com.example.the_project.repository.TrackerRepository
import com.example.the_project.viewmodel.UserListViewModel
import com.example.the_project.viewmodel.UserListViewModelFactory


class UserListFragment : Fragment() {
    private lateinit var userListViewModel: UserListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = UserListViewModelFactory(TrackerRepository())
        userListViewModel = ViewModelProvider(this, factory).get(UserListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText: EditText = view.findViewById(R.id.editTextTextMultiLine)

        userListViewModel.readUsers()
        userListViewModel.userList.observe(viewLifecycleOwner) {
            val userList = userListViewModel.userList.value
            editText.setText("User list size ${userList!!.size}")
            Log.i("xxx", userList.toString())
        }
    }


}