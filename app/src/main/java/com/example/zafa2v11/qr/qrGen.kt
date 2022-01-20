package com.example.zafa2v11.qr

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.WriterException
import com.google.zxing.qrcode.QRCodeWriter
import java.util.*

class qrGen {


    fun Int.dpToPx(): Int {
        return (this * Resources.getSystem().displayMetrics.density).toInt()
    }


    fun createQRGradientImage(s:String?,width: Int, height: Int): Bitmap? {
        try {
            // Juzga la legalidad de la URL
            if (s != null) {
                if ("" == s || s.isEmpty()) {
                    return null
                }
            }
            val hints = Hashtable<EncodeHintType, Any>()
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8")
            hints.put(EncodeHintType.MARGIN, 0)
            hints.put(EncodeHintType.ERROR_CORRECTION, "H")
            // Conversión de datos de imagen, usando conversión de matriz
            val bitMatrix = QRCodeWriter().encode(
                s,
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
                        val green = (225 - (225.0 - 0.0) / height * (y + 1)).toInt()
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
        canvas.drawBitmap(overlay, centreX.toFloat(), centreY.toFloat(), null)
        return combined
    }

//    private fun addLogo(bitmapCode: Bitmap): Bitmap? {
//        val bitmapLogo = BitmapFactory.decodeResource(getResources(), R.drawable.dummy)
//        val qrCodeWidth = bitmapCode.width
//        val qrCodeHeight = bitmapCode.height
//        val logoWidth = bitmapLogo.width
//        val logoHeight = bitmapLogo.height
//        val blankBitmap = Bitmap.createBitmap(qrCodeWidth, qrCodeHeight, Bitmap.Config.ARGB_8888)
//        val canvas = Canvas(blankBitmap)
//        canvas.drawBitmap(bitmapCode, 0f, 0f, null)
//        canvas.save()
//        var scaleSize = 1.0f
//        while (logoWidth / scaleSize > qrCodeWidth / 5 || logoHeight / scaleSize > qrCodeHeight / 5) {
//            scaleSize *= 2f
//        }
//        val sx = 1.0f / scaleSize
//        canvas.scale(sx, sx, (qrCodeWidth / 2).toFloat(), (qrCodeHeight / 2).toFloat())
//        canvas.drawBitmap(
//            bitmapLogo,
//            ((qrCodeWidth - logoWidth) / 2).toFloat(),
//            ((qrCodeHeight - logoHeight) / 2).toFloat(),
//            null
//        )
//        canvas.restore()
//        return blankBitmap
//    }
}