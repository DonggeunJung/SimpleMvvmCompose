package com.example.simplemvvmcompose.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

interface UserApi {

    @GET("users/DonggeunJung")
    suspend fun user(): User

    companion object {
        private const val BASE_URL = "https://api.github.com/"

        val instance: UserApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json {
                isLenient = true
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType())) //Here we are using the GsonConverterFactory to directly convert json data to object
            .build().create(UserApi::class.java)
    }
}