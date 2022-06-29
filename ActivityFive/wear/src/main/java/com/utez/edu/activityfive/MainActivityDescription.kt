package com.utez.edu.activityfive

import android.app.Activity
import android.os.Bundle
import com.utez.edu.activityfive.databinding.ActivityMainDescriptionBinding

class MainActivityDescription : Activity() {

    companion object {
        const val TITLE: String = "title"
        const val DESCRIPTION: String = "description"
    }

    private lateinit var binding: ActivityMainDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val title = bundle?.getString(TITLE)
        val description = bundle?.getString(DESCRIPTION)

        binding.txtTitle.text = title
        binding.txtDescription.text = description
    }
}