package com.example.zafa2v11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.zafa2v11.fragments.InventarioFragment
import com.example.zafa2v11.fragments.ProfileFragment
import com.example.zafa2v11.fragments.TiendaFragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_menu.*





class MenuActivity : AppCompatActivity() {
    private val profileFragment:Fragment= ProfileFragment()
    private val tiendaFragment:Fragment=  TiendaFragment()
    private val inventarioFragment:Fragment= InventarioFragment()

    private fun onMenuItemClick(){
        val menuBottomAppBar= findViewById<BottomAppBar>(R.id.bottomAppBarMenu)
        menuBottomAppBar.setNavigationOnClickListener{onMenuPressed()}

    }

    private fun onMenuPressed() {
        centerFab()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(bottomAppBarMenu)
        qrScanner()
        onMenuItemClick()
        bottomAppBarMenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.perfil_menu -> perfil_menu()
                R.id.tienda_menu -> tienda_menu()
                R.id.inventario_menu -> inventario_menu()
            }
            true
        }
    }

    private fun inventario_menu() {
        endFab()
        replaceFragment(inventarioFragment)
    }

    private fun tienda_menu() {
        endFab()
        replaceFragment(tiendaFragment)
    }

    private fun perfil_menu() {
        endFab()
        replaceFragment(profileFragment)
    }

    private fun replaceFragment(fragment:Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_frame_layout,fragment)
        transaction.commit()
    }

    private fun endFab() {
        if (bottomAppBarMenu.fabAlignmentMode== BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
        bottomAppBarMenu.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
    }

    private fun centerFab() {
        if (bottomAppBarMenu.fabAlignmentMode== BottomAppBar.FAB_ALIGNMENT_MODE_END)
            bottomAppBarMenu.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.bottom_app_menu,menu)
        return true;

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        var result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this,
                    "El contenido del qr es: ${result.contents}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
    private fun qrScanner(){
        qrLauncher.setOnClickListener { initScan() }
    }

    private fun initScan() {
            val integrator = IntentIntegrator(this)
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            integrator.setPrompt("")
            integrator.setBeepEnabled(true)
            integrator.initiateScan()
        }

}
