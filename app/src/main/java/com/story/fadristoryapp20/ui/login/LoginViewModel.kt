package com.story.fadristoryapp20.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.story.fadristoryapp20.data.repository.UserRepository
import com.story.fadristoryapp20.data.retrofit.UserModel
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {

    fun loginUser(email: String, password: String)=
        userRepository.login(email, password)

    fun saveSession(user: UserModel)=
        viewModelScope.launch {
            userRepository.saveSession(user)
        }
}