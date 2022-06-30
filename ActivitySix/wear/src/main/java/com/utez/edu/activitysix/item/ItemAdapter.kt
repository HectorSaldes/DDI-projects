package com.utez.edu.activitysix.item

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.utez.edu.activitysix.MainActivityDescription
import com.utez.edu.activitysix.R
import com.utez.edu.activitysix.databinding.ActivityPreviewMenuBinding

class ItemAdapter(private val list: MutableList<Item>, private val context: Context) :
    RecyclerView.Adapter<ItemAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.Holder {
        val binding = DataBindingUtil.inflate<ActivityPreviewMenuBinding>(
            LayoutInflater.from(context),
            R.layout.activity_preview_menu,
            parent,
            false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: ItemAdapter.Holder, position: Int) {
        val item: Item = list[position]
        holder.binding.txtTitle.text = item.title
        Glide.with(context).load(item.img).into(holder.binding.imgIcon)
        holder.binding.root.setOnClickListener {
            context.apply {
                val intent:Intent = Intent(context, MainActivityDescription::class.java)
                intent.putExtra(MainActivityDescription.TITLE, item.title)
                intent.putExtra(MainActivityDescription.DESCRIPTION, item.description)
                startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    class Holder(val binding: ActivityPreviewMenuBinding) : RecyclerView.ViewHolder(binding.root)
}