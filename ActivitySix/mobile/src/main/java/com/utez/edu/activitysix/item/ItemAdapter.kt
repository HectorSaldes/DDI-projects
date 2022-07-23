package com.utez.edu.activitysix.item

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.utez.edu.activitysix.R
import com.utez.edu.activitysix.databinding.ActivityPreviewItemBinding

class ItemAdapter(private val list: MutableList<Item>, private val context: Context) :
    RecyclerView.Adapter<ItemAdapter.Holder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.Holder {
        val binding = DataBindingUtil.inflate<ActivityPreviewItemBinding>(
            LayoutInflater.from(context),
            R.layout.activity_preview_item,
            parent,
            false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: ItemAdapter.Holder, position: Int) {
        val item: Item = list[position]
        holder.binding.txtTitle.text = item.title
        Glide.with(context).load(item.img).into(holder.binding.imgIcon)
    }

    override fun getItemCount(): Int = list.size

    class Holder(val binding: ActivityPreviewItemBinding) : RecyclerView.ViewHolder(binding.root)
}