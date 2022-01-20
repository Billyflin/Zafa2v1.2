package com.example.zafa2v11

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.activity_qractivity.*
import java.util.*


class QRActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qractivity)
        initIU()
    }

    private fun initIU() {
        button3.setOnClickListener {
            imageView4.setImageBitmap(
                createQRGradientImage(
                    "Hola",
                    350.dpToPx(),
                    350.dpToPx()
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
            hints.put(EncodeHintType.ERROR_CORRECTION,"H")
            // Conversión de datos de imagen, usando conversión de matriz
            val bitMatrix = QRCodeWriter().encode(
                url,
                BarcodeFormat.QR_CODE, width, height, hints
            )
            val pixels = IntArray(width * height)
            //61, 225, 203
            //255, 0, 232 rosa
            // Los colores degradados se dibujan de izquierda a derecha
            for (x in 0 until width) {
                for (y in 0 until height) {
                    if (bitMatrix.get(x, y)) {
                        val red = (61 - (61.0 - 255.0) / height * (y + 1)).toInt()
                        val green = (225- (225.0 - 0.0) / height * (y + 1)).toInt()
                        val blue = (203 - (203.0 - 232.0) / height * (y + 1)).toInt()
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

    fun mergeBitmaps(overlay: Bitmap, bitmap: Bitmap): Bitmap? {
        val height = bitmap.height
        val width = bitmap.width
        val combined = Bitmap.createBitmap(width, height, bitmap.config)
        val canvas = Canvas(combined)
        val canvasWidth: Int = canvas.getWidth()
        val canvasHeight: Int = canvas.getHeight()
        canvas.drawBitmap(bitmap, Matrix(), null)
        val centreX = (canvasWidth - overlay.width) / 2.0
        val centreY = (canvasHeight - overlay.height) / 2.0
//        canvas.drawBitmap(overlay,centreX, centreY, null)
        return combined
    }
}