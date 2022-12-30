package com.example.the_project.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UpdateProfileRequest(var first_name: String, var email: String, var phone_number: String, var lccation: String)