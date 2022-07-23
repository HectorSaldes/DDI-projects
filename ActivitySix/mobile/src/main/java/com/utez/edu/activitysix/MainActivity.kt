package com.utez.edu.activitysix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.utez.edu.activitysix.databinding.ActivityMainBinding
import com.utez.edu.activitysix.menu.Menu
import com.utez.edu.activitysix.menu.MenuAdapter

class MainActivity : AppCompatActivity() {

    companion object {
        const val MENU = "menu"
        const val KEY_TITLE = "title"
        const val KEY_IMG = "img"
        const val DATA_LOAD_ERROR = "Ocurrió un fallo al traer los datos"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MenuAdapter
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = Firebase.firestore
        binding.fabCreate.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity, MainActivityNewMenu::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val list: ArrayList<Menu> = ArrayList()
        db.collection(MENU).get().addOnSuccessListener {
            if (it != null) {
                for (doc in it) list.add(
                    Menu(
                        doc.id,
                        doc.data[KEY_TITLE].toString(),
                        doc.data[KEY_IMG].toString()
                    )
                )
                binding.txtNoData.visibility = View.INVISIBLE
                adapter = MenuAdapter(list, this@MainActivity)
                binding.rvMenu.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rvMenu.adapter = adapter
            }
        }.addOnFailureListener {
            makeSnackbar(DATA_LOAD_ERROR)
        }
    }

    fun makeSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }
}