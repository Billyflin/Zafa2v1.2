package com.example.zafa2v11

import android.content.ContentValues
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.WriterException
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_qractivity.*
import java.util.*


class QRActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qractivity)
        initIU()
    }

    private fun initIU() {
        button3.setOnClickListener {
            imageView4.setImageBitmap(
                createQRGradientImage(
                    editTextTextPersonName.text.toString(),
                    330.dpToPx(),
                    330.dpToPx()
                )
            )
        }
    }

    fun Int.dpToPx(): Int {
        return (this * Resources.getSystem().displayMetrics.density).toInt()
    }


    fun createQRGradientImage(url: String?, width: Int, height: Int): Bitmap? {
        try {
            // Juzga la legalidad de la URL
            if (url == null || "" == url || url.length < 1) {
                return null
            }
            val hints = Hashtable<EncodeHintType, Any>()
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8")
            hints.put(EncodeHintType.MARGIN, 0)
            // Conversión de datos de imagen, usando conversión de matriz
            val bitMatrix = QRCodeWriter().encode(
                url,
                BarcodeFormat.QR_CODE, width, height, hints
            )
            val pixels = IntArray(width * height)

            // Los colores degradados se dibujan de izquierda a derecha
            for (x in 0 until width) {
                for (y in 0 until height) {
                    if (bitMatrix.get(x, y)) {
                        val red = (56 - (56.0 - 14.0) / height * (y + 1)).toInt()
                        val green = (247 - (247.0 - 145.0) / height * (y + 1)).toInt()
                        val blue = (195 - (195.0 - 79.0) / height * (y + 1)).toInt()
                        val colorInt = Color.argb(255, red, green, blue)
                        // Modifique el color del código QR, y el color del código QR y el fondo se pueden formular por separado
                        pixels[x * height + y] =
                            if (bitMatrix.get(x, y)) colorInt else 16777215// 0x000000:0xffffff
                    } else {
                        pixels[x * height + y] = 0x00ffffff // color de fondo
                    }
                }
            }

            // Formato para generar imágenes de código QR, utilizando ARGB_8888
            val bitmap = Bitmap.createBitmap(
                width, height,
                Bitmap.Config.ARGB_8888
            )
            bitmap.setPixels(pixels, 0, width, 0, 0, width, height)
            return bitmap
        } catch (e: WriterException) {
            e.printStackTrace()
        }
        return null
    }
}