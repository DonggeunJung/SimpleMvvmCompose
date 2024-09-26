package com.example.simplemvvmcompose.data.di

import com.example.simplemvvmcompose.data.UserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideUserApi(): UserApi {
        // Create Retrofit API object & return
        return UserApi.instance
    }

}