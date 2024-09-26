package com.example.simplemvvmcompose.domain

import android.util.Log
import com.example.simplemvvmcompose.data.User
import com.example.simplemvvmcompose.data.UserApi
import javax.inject.Inject

class UserRepository @Inject constructor(private var api: UserApi) {

    suspend fun reqUser(): User? {
        return try {
            api.user()
        } catch (e: Exception) {
            Log.d("Tag", "${e.message}")
            null
        }
    }
}