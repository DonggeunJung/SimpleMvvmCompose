package com.example.simplemvvmcompose.data

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