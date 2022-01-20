package com.example.zafa2v11.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zafa2v11.R
import com.example.zafa2v11.data.EventItem

class EventViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val item_name=view.findViewById<TextView>(R.id.item_name)
    val item_photo=view.findViewById<ImageView>(R.id.item_photo)

    fun render(item: EventItem){
        item_name.text=item.nombreProductora
        Glide.with(item_photo.context).load(item.imagenProductora).into(item_photo)
    }

}
