package com.example.todo20

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.todo20.data.word
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class bottom : BottomSheetDialogFragment() {
    lateinit var vm:viewmodel
    lateinit var mainbtn:Button
    lateinit var input:EditText
    override  fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v= inflater.inflate(R.layout.fragment_bottom, container, false )
        mainbtn= v.findViewById(R.id.mainbtn)
        input=v.findViewById(R.id.input)


        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      vm=ViewModelProvider(this).get(viewmodel::class.java)

        mainbtn.setOnClickListener {
          vm.additem(word(0,input.text.toString()))
            input.text?.clear()
            dismiss()
        }
    }


}