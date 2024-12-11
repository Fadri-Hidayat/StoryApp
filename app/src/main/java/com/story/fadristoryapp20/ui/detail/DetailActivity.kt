package com.story.fadristoryapp20.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.story.fadristoryapp20.R
import com.story.fadristoryapp20.data.response.ListStoryItem
import com.story.fadristoryapp20.databinding.ActivityDetailBinding
import com.story.fadristoryapp20.utils.loadImage
import java.util.TimeZone

class DetailActivity : AppCompatActivity() {

    private var detailBinding: ActivityDetailBinding? = null
    private val binding get() = detailBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.detail_story)

        setData()
    }

    private fun setData() {
        @Suppress("DEPRECATION")
        val story = intent.getParcelableExtra<ListStoryItem>(DETAIL_STORY) as ListStoryItem
        loadImage(applicationContext, story.photoUrl, binding.ivDetail)
        binding.tvDetailName.text = story.name
        binding.tvGetDeskripsi.text = story.description
        binding.tvDateCreated.text =
            com.story.fadristoryapp20.utils.formatDate(story.createdAt, TimeZone.getDefault().id)
        binding.tvGetLocationLon.text = story.lon.toString()
        binding.tvGetLocationLat.text = story.lat.toString()
    }

    companion object {
        const val DETAIL_STORY = "detail_story"
    }
}