package com.example.zafa2v11.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zafa2v11.R
import com.example.zafa2v11.data.ShopItem

class ItemAdapter(private val itemList:List<ShopItem>) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return ItemViewHolder(layoutInflater.inflate(R.layout.shop_item,parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item= itemList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}