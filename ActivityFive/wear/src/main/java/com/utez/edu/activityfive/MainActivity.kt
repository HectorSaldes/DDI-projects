package com.utez.edu.activityfive

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.wear.widget.WearableLinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.utez.edu.activityfive.databinding.ActivityMainBinding
import com.utez.edu.activityfive.note.Note
import com.utez.edu.activityfive.note.NoteAdapter

class MainActivity : Activity() {

    companion object {
        const val TAG: String = "firebase"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db: FirebaseFirestore = Firebase.firestore
        val listNotes: ArrayList<Note> = ArrayList<Note>()

        /* val docRef = db.collection("notes") .document("OpOuNz4Hf3Zn8Ixb6hwr") // id
         docRef.get()
             .addOnSuccessListener { document ->
                 if (document != null)
                     Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                 else
                     Log.d(TAG, "No such document")
             }
             .addOnFailureListener { exception ->
                 Log.d(TAG, "get failed with ", exception)
             }*/

        val collecRef = db.collection("notes")
        collecRef.get().addOnSuccessListener { documents ->
            if (documents != null) {
                for (doc in documents) {
                    val note = Note(
                        doc.id,
                        doc.data["title"].toString(),
                        doc.data["description"].toString()
                    )
                    listNotes.add(note)
                }
                adapter = NoteAdapter(listNotes, this@MainActivity)
                binding.recyclerView.isEdgeItemsCenteringEnabled = true
                binding.recyclerView.layoutManager = WearableLinearLayoutManager(this@MainActivity)
                binding.recyclerView.isCircularScrollingGestureEnabled = true
                binding.recyclerView.adapter = adapter
            }
        }.addOnFailureListener { exception ->
            Log.d(TAG, "get failed with ", exception)
        }
    }
}