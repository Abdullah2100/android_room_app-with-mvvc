package com.example.newtestingapp


import android.icu.text.ListFormatter
import android.os.Bundle
import android.view.ActionProvider
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController

import androidx.recyclerview.widget.RecyclerView
import com.example.newtestingapp.ViewModel.UserViewModle
import com.example.newtestingapp.fragment.UpdateFragment
import com.example.newtestingapp.fragment.displayUser
import com.example.newtestingapp.fragment.displayUserDirections

import com.example.newtestingapp.model.entitity
import com.google.android.material.navigation.NavigationView
import androidx.navigation.Navigation as Navigation1


class ListAdapterr() :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private lateinit var userViewMoldee: UserViewModle
   private  var userList= emptyList<entitity>()
   inner class ViewHolder( itemView: View): RecyclerView.ViewHolder(itemView) {
        var id: TextView
        var name  : TextView
       var job : TextView

       init {
           id=itemView.findViewById(R.id.idd)
           name=itemView.findViewById(R.id.title)
          job=itemView.findViewById(R.id.pict)
       }
   }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.shape,parent,false)
        return  ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       holder.itemView.findViewById<TextView>(R.id.title).text=userList[position].name
        holder.itemView.findViewById<TextView>(R.id.pict).text=userList[position].job
        holder.itemView.findViewById<TextView>(R.id.idd).text=userList[position].id.toString()
        var card=holder.itemView.findViewById<CardView>(R.id.cadee)
           card .setOnClickListener {

               val action =displayUserDirections.actionDisplayUserToUpdateFragment(userList[position])


            holder.itemView.findNavController().navigate(action)
        }




    }

    override fun getItemCount(): Int {
        return userList.size
    }
    fun setData(uesr:List<entitity>){
        this.userList = uesr

        notifyDataSetChanged()
    }
}