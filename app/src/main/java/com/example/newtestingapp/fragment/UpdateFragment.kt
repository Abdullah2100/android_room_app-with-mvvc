package com.example.newtestingapp.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgument
import com.example.newtestingapp.R
import com.example.newtestingapp.ViewModel.UserViewModle
import com.example.newtestingapp.model.entitity



class UpdateFragment : Fragment() {
   private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var userViewMoldee: UserViewModle
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_update,container,false)
        userViewMoldee= ViewModelProvider(this).get(UserViewModle::class.java)
        view.findViewById<EditText>(R.id.nameid_or)?.setText(args.currentuser.name)
        view.findViewById<EditText>(R.id.jobht)?.setText(args.currentuser.job)
        var bott=view.findViewById<Button>(R.id.submitt)

          bott?.setOnClickListener{
              updateData()



        }
        setHasOptionsMenu(true)
        return view
    }

    private fun updateData(){

        var name= view?.findViewById<EditText>(R.id.nameid_or)!!.text
        var job= view?.findViewById<EditText>(R.id.jobht)!!.text

        if(checikInput(name.toString(),job.toString())){
            val user= entitity(args.currentuser.id,name.toString(), job.toString())
            userViewMoldee.upateUser(user)
            Toast.makeText(requireContext(),"the add was update ", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_displayUser)
        }


        else{
            Toast.makeText(requireContext(),"the not update was", Toast.LENGTH_LONG).show()
        }


    }
    private fun checikInput(name:String,job:String):Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(job))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
       inflater.inflate(R.menu.delete,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.deleteIcon){
            deleteIcon()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteIcon() {
        val builder=AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_,_ ->
            userViewMoldee.deleteUser(args.currentuser)
            Toast.makeText(requireContext(),"the add was update ", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_displayUser)

        }
        builder.setNegativeButton("No"){_,_ ->}
        builder.setTitle("delete  ${args.currentuser.name}")
        builder.setMessage("are you sure to delete this user ${args.currentuser.name}").create().show()
    }

}