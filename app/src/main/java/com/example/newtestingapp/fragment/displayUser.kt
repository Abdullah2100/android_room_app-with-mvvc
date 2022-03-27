package com.example.newtestingapp.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newtestingapp.ListAdapterr
import com.example.newtestingapp.R
import com.example.newtestingapp.ViewModel.UserViewModle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class displayUser : Fragment() {

    private lateinit var userViewMoldee: UserViewModle

 override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_display_user,container,false)
  //recylerView
     var recycler=view.findViewById<RecyclerView>(R.id.scri)
     var bott=view.findViewById<FloatingActionButton>(R.id.floating)

     val adapterr= ListAdapterr()
     recycler.adapter=adapterr
     recycler.layoutManager=LinearLayoutManager(requireContext())

     userViewMoldee=  ViewModelProvider(this).get(UserViewModle::class.java)
     userViewMoldee.readData.observe(viewLifecycleOwner, Observer {
             user -> adapterr.setData(user)

     })
     bott.setOnClickListener{

            findNavController().navigate(R.id.action_displayUser_to_blankFragmentAddUser)

     }
//
     return  view
    }


}
