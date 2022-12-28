package com.example.the_project.repository

import com.example.the_project.api.RetrofitInstance
import com.example.the_project.model.*
import retrofit2.Response

class TrackerRepository {
    suspend fun login(request: LoginRequest): Response<LoginResponse> {
        return RetrofitInstance.api.login(request)
    }

    suspend fun getUsers(token: String): Response<List<User>> {
        return RetrofitInstance.api.getUsers(token)
    }

    suspend fun getUser(token: String): Response<User> {
        return RetrofitInstance.api.getUser(token)
    }

    suspend fun getTasks(token: String): Response<List<Task>> {
        return RetrofitInstance.api.getTasks(token)
    }

    suspend fun getActivities(token: String): Response<List<Activitie>>{
        return RetrofitInstance.api.getActivites(token)
    }
}