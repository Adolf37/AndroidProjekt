package com.zoltanlorinczi.project_retrofit.api.model

import com.google.gson.annotations.SerializedName

/**
 * Author:  Zoltan Lorinczi
 * Date:    11/8/2021
 */
data class LoginRequestBody(
    @SerializedName("adolfadolfbalint@gmail.com")
    var username: String,

    @SerializedName("postman37")
    var password: String
)