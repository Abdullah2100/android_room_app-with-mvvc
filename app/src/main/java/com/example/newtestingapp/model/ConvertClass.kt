package com.example.newtestingapp.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

class ConvertClass {
    @TypeConverter
    fun fromBitmap( bit: Bitmap):ByteArray{
        val outbuitmap=ByteArrayOutputStream()
        bit.compress(Bitmap.CompressFormat.PNG,100,outbuitmap)
        return  outbuitmap.toByteArray();
    }
    @TypeConverter
    fun toBitmap( bit: ByteArray):Bitmap{
        return BitmapFactory.decodeByteArray(bit,0,bit.size)
    }
}