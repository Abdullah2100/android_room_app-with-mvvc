package com.example.newtestingapp.model


import android.graphics.Bitmap
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "user")
data class entitity (
    @PrimaryKey(autoGenerate = true)
    var id :Int = 0,


      var name:String,


     var job:String,
     var profileImage: Bitmap

): Parcelable
