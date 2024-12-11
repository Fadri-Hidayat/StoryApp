package com.story.fadristoryapp20.ui.register

import androidx.lifecycle.ViewModel
import com.story.fadristoryapp20.data.repository.UserRepository

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun registerUser(name: String, email: String, password: String) =
        userRepository.register(name ,email, password)
    }