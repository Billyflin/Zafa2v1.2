package com.example.zafa2v11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    fun onMenuItemClick(item: MenuItem): Boolean {
        var itemSelected: Fragment? = null
        when (item.itemId) {
            R.id.tienda_menu -> Toast.makeText(this,"hola",Toast.LENGTH_LONG).show()
        }
        return true
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(bottomAppBarMenu)
        qrScanner()
        bottomAppBarMenu.setOnClickListener { togle() }
        bottomAppBarMenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.perfil_menu -> onMenu(profileFragment)
                R.id.tienda_menu -> replaceFragment(tiendaFragment)
                R.id.inventario_menu -> replaceFragment(inventarioFragment)
            }
            true
        }
    }
    private fun onMenu(profileFragment: Fragment) {
        togle()
        replaceFragment(profileFragment)
    }

    private fun replaceFragment(fragment:Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_frame_layout,fragment)
        transaction.commit()
    }

    private fun togle() {
        if (bottomAppBarMenu.fabAlignmentMode== BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
        bottomAppBarMenu.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
        else{
            bottomAppBarMenu.fabAlignmentMode= BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.bottom_app_menu,menu)
        return true;

    }

}