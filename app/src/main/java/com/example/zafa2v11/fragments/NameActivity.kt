package com.example.zafa2v11.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zafa2v11.EventSelectorActivity
import com.example.zafa2v11.R
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        initComps()
    }

    private fun initComps() {
        imageButton3.setOnClickListener { startActivity( Intent(this, EventSelectorActivity::class.java))  }
    }
}