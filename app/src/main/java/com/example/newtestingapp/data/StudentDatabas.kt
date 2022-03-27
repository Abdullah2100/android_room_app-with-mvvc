package com.example.newtestingapp.data

import android.content.Context
import androidx.room.*
import com.example.newtestingapp.model.ConvertClass
import com.example.newtestingapp.model.entitity

@Database(entities =[ entitity::class], version = 1,exportSchema = false)
@TypeConverters(ConvertClass::class)
abstract class StudentDatabas : RoomDatabase() {

    abstract fun wordDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: StudentDatabas? = null
            fun getDatabase(
            context: Context
             ): StudentDatabas {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StudentDatabas::class.java,
                    "word_database"
                )


                    .build()
                INSTANCE = instance
                 return instance
//                instance
            }
        }
    }}