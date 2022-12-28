package com.example.the_project.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Task(
    var ID: Long,
    var title : String,
    var description: String,
    var created_time: Long,
    var created_by_user_ID: Int,
    var asigned_to_user_ID: Int,
    var priority: Int,
    var deadline: Int,
    var department_id: Int,
    var status: Int,
    //var progress: null
)