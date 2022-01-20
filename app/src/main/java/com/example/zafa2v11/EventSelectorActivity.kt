package com.example.zafa2v11

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.zafa2v11.adapter.EventAdapter
import com.example.zafa2v11.data.EventProvider
import kotlinx.android.synthetic.main.activity_event_selector.*

class EventSelectorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_selector)
        initRecycler()
    }

    private fun initRecycler() {
        rvEventSelector.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = GridLayoutManager(Activity(),2)
            // set the custom adapter to the RecyclerView
            adapter = EventAdapter(EventProvider.listaEventos)
        }
    }
}