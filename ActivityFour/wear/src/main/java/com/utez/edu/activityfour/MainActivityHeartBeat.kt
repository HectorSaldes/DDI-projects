package com.utez.edu.activityfour

import android.app.Activity
import android.os.Bundle
import com.utez.edu.activityfour.databinding.ActivityMainHeartBeatBinding

class MainActivityHeartBeat : Activity() {

    companion object {
        const val BEAT = "beat"
    }

    private lateinit var binding: ActivityMainHeartBeatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainHeartBeatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // obtener los datos enviados con intent
        binding.txtHeartBeat.text = intent.extras?.getString(BEAT)

    }
}