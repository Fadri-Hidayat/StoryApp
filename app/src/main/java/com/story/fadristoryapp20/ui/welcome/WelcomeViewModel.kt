package com.story.fadristoryapp20.ui.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.story.fadristoryapp20.data.repository.UserRepository
import com.story.fadristoryapp20.data.retrofit.UserModel

class WelcomeViewModel (private val userRepository: UserRepository) : ViewModel() {
    fun getSession(): LiveData<UserModel> {
        return userRepository.getSession().asLiveData()
    }
}