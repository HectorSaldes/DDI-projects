package com.utez.edu.activityfour

import android.app.Activity
import android.os.Bundle
import com.utez.edu.activityfour.databinding.ActivityMainBookBinding

class MainActivityBook : Activity() {

    private lateinit var binding: ActivityMainBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBookBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}