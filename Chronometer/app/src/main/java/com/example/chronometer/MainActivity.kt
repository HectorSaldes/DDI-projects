package com.example.chronometer

import android.app.Activity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import com.example.chronometer.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chronometer:Chronometer = binding.chronometerID;
        val btnPlay:Button = binding.btnPlay;

        btnPlay.setOnClickListener { chronometer.start() }

        binding.btnStop.setOnClickListener { chronometer.stop() }

        binding.btnRefresh.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime();
            chronometer.stop()
        }
    }
}