package com.example.the_project

import android.app.Application

class MyApplication : Application() {
    companion object {
        var token: String = ""
        var deadline: Long = 0L

        var email: String = ""
    }
}