package com.utez.edu.activitysix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.utez.edu.activitysix.databinding.ActivityMainItemBinding
import com.utez.edu.activitysix.item.Item
import com.utez.edu.activitysix.item.ItemAdapter

class MainActivityItem : AppCompatActivity() {

    companion object {
        const val KEY_ITEM = "item"
        const val KEY_IMG = "img"
        const val TITLE = "title"
        const val DESCRIPTION = "description"
    }

    private lateinit var binding: ActivityMainItemBinding
    private lateinit var adapter: ItemAdapter
    private lateinit var db: FirebaseFirestore
    private lateinit var itemMenu: String
    private lateinit var imgMenu: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = Firebase.firestore
        itemMenu = intent.extras?.getString(KEY_ITEM).toString()
        imgMenu = intent.extras?.getString(KEY_IMG).toString()
        binding.txtItem.text = itemMenu
        binding.fabCreate.setOnClickListener {
            val intent: Intent = Intent(this@MainActivityItem, MainActivityItemContent::class.java)
            intent.putExtra(MainActivityItemContent.KEY_ITEM, itemMenu.lowercase())
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val list: ArrayList<Item> = ArrayList()
        db.collection(itemMenu.lowercase()).get().addOnSuccessListener {
            if (it != null) {
                for (doc in it) list.add(
                    Item(
                        doc.id,
                        doc.data[TITLE].toString(),
                        doc.data[DESCRIPTION].toString(),
                        imgMenu
                    )
                )
                binding.txtNoData.visibility = View.INVISIBLE
                adapter = ItemAdapter(list, this@MainActivityItem)
                binding.rvItem.layoutManager = LinearLayoutManager(this@MainActivityItem)
                binding.rvItem.adapter = adapter
            }
        }.addOnFailureListener {
            makeSnackbar(MainActivity.DATA_LOAD_ERROR)
        }
    }
    fun makeSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }
}