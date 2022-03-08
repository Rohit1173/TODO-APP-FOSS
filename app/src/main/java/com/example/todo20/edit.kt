package com.example.todo20

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.todo20.data.word


class edit(myid:Int,myword:String) : DialogFragment() {
  val newid:Int = myid
    val newword:String = myword
 lateinit var vm:viewmodel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        val v= inflater.inflate(R.layout.fragment_edit, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        vm = ViewModelProvider(this).get(viewmodel::class.java)
        val editword:EditText = v.findViewById(R.id.rename)
        editword.setText(newword)
        val newsave:Button =v.findViewById(R.id.renamesave)
        newsave.setOnClickListener {
            vm.updateword(word(newid,editword.text.toString()))
            dismiss()
        }


        return v
    }


}