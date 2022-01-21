package com.example.zafa2v11.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zafa2v11.R
import com.example.zafa2v11.data.EventItem


class EventViewHolder(view: View):RecyclerView.ViewHolder(view) {

//    val event_name=view.findViewById<TextView>(R.id.tvEventName)
//    val event_producer=view.findViewById<TextView>(R.id.item_price)
    val event_photo=view.findViewById<ImageView>(R.id.ivEvent_Photo)

    fun render(item: EventItem){
//        event_name.text=item.nombreProductora
//        event_producer.text=item.imagenProductora
        Glide.with(event_photo.context).load(item.imagenProductora).into(event_photo)
    }
}
