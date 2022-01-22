package com.example.zafa2v11

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.zafa2v11.adapter.EventAdapter
import com.example.zafa2v11.data.EventItem
import com.example.zafa2v11.data.EventProvider
import com.example.zafa2v11.databinding.ActivityEventSelectorBinding
import kotlinx.android.synthetic.main.activity_event_selector.*

class EventSelectorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventSelectorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_selector)
        initRecycler()
    }

    private fun initRecycler() {
        rvEventSelector.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = GridLayoutManager(Activity(),1)
            // set the custom adapter to the RecyclerView
            adapter = EventAdapter(EventProvider.listaEventos) { onEventSelected(it) }
        }
    }

    private fun onEventSelected(event: EventItem) {
        when(event.nombreProductora){
            "Zafa2" -> startActivity( Intent(this,MenuActivity::class.java))
            "Pandora" -> startActivity( Intent(this,MenuActivity::class.java))
//            "Pandora" -> startActivity( Intent(this,MenuActivity::class.java))
            "Mestizo" -> startActivity( Intent(this,MenuActivity::class.java))
        }
    }
}