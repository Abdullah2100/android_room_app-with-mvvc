package com.example.newtestingapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.newtestingapp.data.StudentDatabas
import com.example.newtestingapp.model.entitity
import com.example.newtestingapp.reposetory.UserRepasotory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModle (application: Application): AndroidViewModel(application){
 



        val readData: LiveData<List<entitity>>
        private var reposetory : UserRepasotory
        init {
            val userData = StudentDatabas.getDatabase(application).wordDao()
            reposetory = UserRepasotory(userData)
            readData = reposetory.reaAlldata
        }
        fun addUser (user: entitity) {
            viewModelScope.launch(Dispatchers.IO) {
                reposetory.addUser(user)
            }
        }
    fun upateUser (user: entitity) {
        viewModelScope.launch(Dispatchers.IO) {
            reposetory.updateUse(user)
        }
    }
    fun deleteUser (user: entitity) {
        viewModelScope.launch(Dispatchers.IO) {
            reposetory.deleteUser(user)
        }
    }

}