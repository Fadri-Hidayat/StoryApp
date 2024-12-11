package com.story.fadristoryapp20.ui.maps

import androidx.lifecycle.ViewModel
import com.story.fadristoryapp20.data.repository.UserRepository

class MapsViewModel (private val userRepository: UserRepository) : ViewModel() {
    fun getListStoryLocation() = userRepository.getStoryWithLocation()
}