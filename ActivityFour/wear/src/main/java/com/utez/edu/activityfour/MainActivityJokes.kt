package com.utez.edu.activityfour

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.utez.edu.activityfour.databinding.ActivityMainJokesBinding

class MainActivityJokes : Activity() {

    private lateinit var binding: ActivityMainJokesBinding
    private val jokesMap: MutableMap<Int, Joke> = mutableMapOf()
    private var increment: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainJokesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        jokesMap[1] = Joke(
            "¿Cuál es el último animal que subió al arca de Noé? El del-fin.",
            R.drawable.delfin
        )
        jokesMap[2] = Joke("¿Cómo se dice pañuelo en japonés? Saka-moko.", R.drawable.moco)
        jokesMap[3] = Joke("¿Cómo se dice disparo en árabe? Ahí-va-la-bala.", R.drawable.disparo)

        enabledButtons()
        setJokeOnView()
        setTextIndex()

        binding.btnLeft.setOnClickListener {
            decreaseIncrement()
            setTextIndex()
            setJokeOnView()
            enabledButtons()
        }
        binding.btnRight.setOnClickListener {
            addIncrement()
            setTextIndex()
            setJokeOnView()
            enabledButtons()
        }
    }

    private fun addIncrement() {
        if (increment <= jokesMap.keys.last()) increment++
    }

    private fun decreaseIncrement() {
        if (increment >= jokesMap.keys.first()) increment--
    }

    private fun enabledButtons() {
        binding.btnLeft.visibility =
            if (increment == jokesMap.keys.first()) View.INVISIBLE else View.VISIBLE
        binding.btnRight.visibility =
            if (increment == jokesMap.keys.last()) View.INVISIBLE else View.VISIBLE
    }

    private fun setJokeOnView() {
        binding.txtJoke.text = jokesMap[increment]?.name
        binding.imgJoke.setBackgroundResource(jokesMap[increment]!!.image)
    }

    private fun setTextIndex() {
        binding.txtIndex.text = "$increment / ${jokesMap.keys.last()}"
    }
}