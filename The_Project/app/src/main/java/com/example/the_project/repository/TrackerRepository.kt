package com.example.the_project.repository

import com.example.the_project.api.RetrofitInstance
import com.example.the_project.model.LoginRequest
import com.example.the_project.model.LoginResponse
import com.example.the_project.model.User
import retrofit2.Response

class TrackerRepository {
    suspend fun login(request: LoginRequest): Response<LoginResponse> {
        return RetrofitInstance.api.login(request)
    }

    suspend fun getUsers(token: String): Response<List<User>> {
        return RetrofitInstance.api.getUsers(token)
    }
}