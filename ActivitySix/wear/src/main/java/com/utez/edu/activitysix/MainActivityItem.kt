package com.utez.edu.activitysix

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.wear.widget.WearableLinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.utez.edu.activitysix.databinding.ActivityMainItemBinding
import com.utez.edu.activitysix.item.Item
import com.utez.edu.activitysix.item.ItemAdapter
import com.utez.edu.activitysix.menu.Menu
import com.utez.edu.activitysix.menu.MenuAdapter

class MainActivityItem : Activity() {

    companion object{
        const val KEY = "item"
        const val IMG = "img"
    }

    private lateinit var binding: ActivityMainItemBinding
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val collection:String? = intent.extras?.getString(KEY)
        val img:String? = intent.extras?.getString(IMG)

        val db: FirebaseFirestore = Firebase.firestore
        val list: ArrayList<Item> = ArrayList();
        if (collection != null && img != null) {
            db.collection(collection).get().addOnSuccessListener {
                if (it != null) {
                    for (doc in it) list.add(Item(doc.id, doc.data["title"].toString(), doc.data["description"].toString(), img))
                    adapter = ItemAdapter(list, this@MainActivityItem)
                    binding.rvItem.isEdgeItemsCenteringEnabled = true
                    binding.rvItem.layoutManager = WearableLinearLayoutManager(this@MainActivityItem)
                    binding.rvItem.isCircularScrollingGestureEnabled = true
                    binding.rvItem.adapter = adapter
                }
            }.addOnFailureListener { e ->
                Log.d("TAG", "get failed with ", e)
            }
        }
    }
}