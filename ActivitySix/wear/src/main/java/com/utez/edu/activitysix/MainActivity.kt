package com.utez.edu.activitysix

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.wear.widget.WearableLinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.utez.edu.activitysix.databinding.ActivityMainBinding
import com.utez.edu.activitysix.menu.Menu
import com.utez.edu.activitysix.menu.MenuAdapter

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db: FirebaseFirestore = Firebase.firestore
        val list: ArrayList<Menu> = ArrayList();
        db.collection("menu").get().addOnSuccessListener {
            if (it != null) {
                for (doc in it) list.add(Menu(doc.id, doc.data["title"].toString(), doc.data["img"].toString()))
                adapter = MenuAdapter(list, this@MainActivity)
                binding.rvMenu.isEdgeItemsCenteringEnabled = true
                binding.rvMenu.layoutManager = WearableLinearLayoutManager(this@MainActivity)
                binding.rvMenu.isCircularScrollingGestureEnabled = true
                binding.rvMenu.adapter = adapter
            }
        }.addOnFailureListener { e ->
            Log.d("TAG", "get failed with ", e)
        }
    }
}