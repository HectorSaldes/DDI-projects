package com.utez.edu.activityfour

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.utez.edu.activityfour.databinding.ActivityMainBinding

class MainActivity : Activity() {



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBook.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivityBook::class.java)
            startActivity(intent)
        }

        binding.btnHeart.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivityHeartBeat::class.java)
            intent.putExtra(MainActivityHeartBeat.BEAT, "999")
            startActivity(intent)
        }

        binding.btnPlayMusic.setOnClickListener {  }

        binding.btnJokes.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivityJokes::class.java)
            startActivity(intent)
        }
    }
}