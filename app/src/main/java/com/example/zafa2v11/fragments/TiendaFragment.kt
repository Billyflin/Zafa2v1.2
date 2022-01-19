package com.example.zafa2v11.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zafa2v11.R
import com.example.zafa2v11.adapter.ItemAdapter
import com.example.zafa2v11.adapter.ItemViewHolder
import com.example.zafa2v11.data.ItemProvider
import kotlinx.android.synthetic.main.fragment_tienda.*

class TiendaFragment : Fragment() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<ItemViewHolder>? = null




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tienda, container, false)
    }
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        rvFragmentTienda.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = GridLayoutManager(activity,2)
            // set the custom adapter to the RecyclerView
            adapter =ItemAdapter(ItemProvider.itemList)
        }
    }

}