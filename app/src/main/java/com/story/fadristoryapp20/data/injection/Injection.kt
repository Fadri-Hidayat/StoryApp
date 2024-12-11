package com.story.fadristoryapp20.data.injection

import android.content.Context
import android.util.Log
import com.story.fadristoryapp20.R
import com.story.fadristoryapp20.data.database.StoryDatabase
import com.story.fadristoryapp20.data.repository.UserRepository
import com.story.fadristoryapp20.data.retrofit.ApiConfig
import com.story.fadristoryapp20.utils.UserPreference
import com.story.fadristoryapp20.utils.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking


object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val user = runBlocking { pref.getUser().first() }
        Log.d(context.getString(R.string.token_disimpan), user.token)
        val apiService = ApiConfig.getApiService(user.token)
        val storyDatabase = StoryDatabase.getDatabase(context)
        return UserRepository(apiService, pref, storyDatabase)
    }

}