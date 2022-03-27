package com.example.newtestingapp.reposetory

import androidx.lifecycle.LiveData
import com.example.newtestingapp.data.StudentDao
import com.example.newtestingapp.model.entitity

class UserRepasotory (private val userdata: StudentDao){

    val reaAlldata : LiveData<List<entitity>> = userdata.getAllStudent()

    suspend fun addUser(user: entitity){
        userdata.adduser(user)
    }

    suspend fun updateUse(user: entitity){
        userdata.updateUser(user)
    }
    suspend fun deleteUser(user: entitity){
        userdata.deleteUser(user)
    }
}