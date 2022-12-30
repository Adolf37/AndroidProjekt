package com.example.the_project.model

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class Activitie (
    var ID: Int,
    var type: Int,
    var created_by_user_id: Int,
    var sub_type: Int,
//    var created_time: Date,
    var sub_ID: Int,
//    var sub_user_ID: Int,
//    var note: String,
//    var progress: String
)