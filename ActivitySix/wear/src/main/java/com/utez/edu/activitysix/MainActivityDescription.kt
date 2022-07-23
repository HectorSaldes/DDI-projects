package com.utez.edu.activitysix

import android.app.Activity
import android.os.Bundle
import com.utez.edu.activitysix.databinding.ActivityMainDescriptionBinding

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

        binding.txtTitle.text = intent.extras?.getString(TITLE)
        binding.txtDescription.text = intent.extras?.getString(DESCRIPTION)

    }
}