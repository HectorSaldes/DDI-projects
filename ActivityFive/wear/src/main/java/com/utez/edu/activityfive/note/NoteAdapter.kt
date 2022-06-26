package com.utez.edu.activityfive.note

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.utez.edu.activityfive.R
import com.utez.edu.activityfive.databinding.ActivityPreviewRecyclerBinding

class NoteAdapter(private val listNotes: MutableList<Note>, private val context: Context) :
    RecyclerView.Adapter<NoteAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.Holder {
        val binding = DataBindingUtil.inflate<ActivityPreviewRecyclerBinding>(
            LayoutInflater.from(context),
            R.layout.activity_preview_recycler,
            parent,
            false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: NoteAdapter.Holder, position: Int) {
        val note: Note = listNotes[position]
        holder.binding.txtTitle.text = note.title

        // Hacemos referencia al Relative (padre) del item que estaremos pintando al dar click
        holder.binding.root.setOnClickListener {
            Log.w("click", "Me ha dado click en ${note.title}")
        }
    }

    override fun getItemCount(): Int = listNotes.size

    class Holder(val binding: ActivityPreviewRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}