package com.example.zafa2v11.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zafa2v11.R
import com.example.zafa2v11.data.EventItem

class EventAdapter(private val eventList: List<EventItem>) : RecyclerView.Adapter<EventViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EventViewHolder(layoutInflater.inflate(R.layout.activity_event_selector, parent, false))
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val item = eventList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return eventList.size
    }
}