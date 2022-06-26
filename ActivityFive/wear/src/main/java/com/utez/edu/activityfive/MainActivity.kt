package com.utez.edu.activityfive

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.utez.edu.activityfive.databinding.ActivityMainBinding

class MainActivity : Activity() {

    companion object {
        const val TAG: String = "firebase"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db: FirebaseFirestore = Firebase.firestore

        val docRef = db.collection("notes").document("OpOuNz4Hf3Zn8Ixb6hwr") // id
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null)
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                else
                    Log.d(TAG, "No such document")
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }
}