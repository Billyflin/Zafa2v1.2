package com.example.zafa2v11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.google.android.material.bottomappbar.BottomAppBar
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(BottomAppBarMenu)
        BottomAppBarMenu.setOnClickListener { BottomAppBarMenu.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END}
    }

    fun togle() {
        Toast.makeText(this,"funciona",Toast.LENGTH_LONG).show()
        BottomAppBarMenu.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.bottom_app_menu,menu)
        return true;

    }
}