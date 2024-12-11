package com.story.fadristoryapp20.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.story.fadristoryapp20.data.injection.Injection
import com.story.fadristoryapp20.data.repository.UserRepository
import com.story.fadristoryapp20.ui.login.LoginViewModel
import com.story.fadristoryapp20.ui.main.MainViewModel
import com.story.fadristoryapp20.ui.maps.MapsViewModel
import com.story.fadristoryapp20.ui.register.RegisterViewModel
import com.story.fadristoryapp20.ui.story.UploadStoryViewModel
import com.story.fadristoryapp20.ui.welcome.WelcomeViewModel

class ViewModelFactory private constructor(
    private val userRepository: UserRepository,
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(userRepository) as T
        }
        else if(modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(userRepository) as T
        } else if(modelClass.isAssignableFrom(WelcomeViewModel::class.java)) {
            return WelcomeViewModel(userRepository) as T
        } else if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(userRepository) as T
        }else if(modelClass.isAssignableFrom(UploadStoryViewModel::class.java)) {
            return UploadStoryViewModel(userRepository) as T
        }else if(modelClass.isAssignableFrom(MapsViewModel::class.java)) {
            return MapsViewModel(userRepository) as T
        }
        throw IllegalArgumentException("No ModelClass: " + modelClass.name)
    }

    companion object {
        fun getInstance(context: Context): ViewModelFactory {
            return ViewModelFactory(Injection.provideRepository(context))
        }
    }
}