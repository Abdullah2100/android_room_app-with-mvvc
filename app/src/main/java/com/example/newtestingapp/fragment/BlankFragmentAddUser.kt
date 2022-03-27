package com.example.newtestingapp.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.newtestingapp.R
import com.example.newtestingapp.ViewModel.UserViewModle
import com.example.newtestingapp.model.entitity
import kotlinx.coroutines.launch

class BlankFragmentAddUser : Fragment() {
    private lateinit var userViewMoldee: UserViewModle


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_blank_add_user,container,false)

        val buttonnn=view.findViewById<Button>(R.id.submitting)

        userViewMoldee= ViewModelProvider(this).get(UserViewModle::class.java)
        buttonnn.setOnClickListener{
            insertDAta()
        }

        return  view
    }



    private fun insertDAta(){
        var name= view?.findViewById<EditText>(R.id.nameid_tr)!!.text.toString()
        var job=view?.findViewById<EditText>(R.id.jobid)!!.text.toString()

           if(checikInput(name,job)){
             val user= entitity(id = 0,name = name,job = job)
               userViewMoldee.addUser(user = user)
               Toast.makeText(requireContext(),"the add was seccesfoly", Toast.LENGTH_LONG).show()
              findNavController().navigate(R.id.action_blankFragmentAddUser_to_displayUser)
           }


           else{
               Toast.makeText(requireContext(),"the not add was", Toast.LENGTH_LONG).show()
           }


    }
    private fun checikInput(name:String,job:String):Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(job))
    }

}