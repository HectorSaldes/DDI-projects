package com.utez.edu.activitysix.menu

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.utez.edu.activitysix.MainActivityItem
import com.utez.edu.activitysix.R
import com.utez.edu.activitysix.databinding.ActivityPreviewItemBinding

class MenuAdapter(private val list: MutableList<Menu>, private val context: Context) :
    RecyclerView.Adapter<MenuAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.Holder {
        val binding = DataBindingUtil.inflate<ActivityPreviewItemBinding>(
            LayoutInflater.from(context),
            R.layout.activity_preview_item,
            parent,
            false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MenuAdapter.Holder, position: Int) {
        val menu: Menu = list[position]
        holder.binding.txtTitle.text = menu.title
        Glide.with(context).load(menu.img).into(holder.binding.imgIcon)
        holder.binding.root.setOnClickListener {
            context.apply {
                val intent = Intent(context, MainActivityItem::class.java)
                intent.putExtra(MainActivityItem.KEY_ITEM, menu.title)
                intent.putExtra(MainActivityItem.KEY_IMG, menu.img)
                startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    class Holder(val binding: ActivityPreviewItemBinding) : RecyclerView.ViewHolder(binding.root)
}