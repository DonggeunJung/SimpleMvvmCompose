package com.example.simplemvvmcompose.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplemvvmcompose.data.User
import com.example.simplemvvmcompose.domain.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _user = mutableStateOf(User())
    val user: State<User> = _user

    // Request Card data list to Repository
    fun reqUser() {
        viewModelScope.launch {
            val user = userRepository.reqUser()

            withContext(Dispatchers.Main) {
                user?.let { _user.value = it }
            }
        }
    }
}