package com.example.simplemvvmcompose.data

import kotlinx.serialization.Serializable

@Serializable
data class User(var name: String="", var location: String="", var bio: String="")