package com.example.newtestingapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newtestingapp.model.entitity

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun adduser ( entitity: entitity)


    @Query("SELECT * FROM user ORDER BY id ASC ")
    fun getAllStudent(): LiveData<List< entitity>>



    //deletes single user
    @Delete
    suspend fun deleteUser(user:  entitity)
    @Update
    suspend fun updateUser(user:  entitity)

}