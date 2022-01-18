package com.example.zafa2v11.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zafa2v11.R
import com.example.zafa2v11.data.ShopItem

class ItemViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val item_name=view.findViewById<TextView>(R.id.item_name)
    val item_price=view.findViewById<TextView>(R.id.item_price)
    val item_photo=view.findViewById<ImageView>(R.id.item_photo)

    fun render(item: ShopItem){
        item_name.text=item.item
        item_price.text=item.precio
        Glide.with(item_photo.context).load(item.photo).into(item_photo)
    }
}