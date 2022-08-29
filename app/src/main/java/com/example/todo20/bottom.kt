package com.example.todo20

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
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

        //ensure mainbtn is greyed out when bottom_fragment opens as ditText in initially empty
        mainbtn.setBackgroundColor(resources.getColor(R.color.grey))


        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      vm=ViewModelProvider(this).get(viewmodel::class.java)

        //when text is changed check if the string is empty
        input.doAfterTextChanged {
            //if empty mainbtn color to grey and make non clickable
            if(input.text.toString() == ""){
                mainbtn.isClickable = false
                mainbtn.setBackgroundColor(resources.getColor(R.color.grey))
            }
            else{
                mainbtn.isClickable = true
                mainbtn.setBackgroundColor(resources.getColor(R.color.purple_500))
            }
        }


        mainbtn.setOnClickListener {
          vm.additem(word(0,input.text.toString()))
            input.text?.clear()
            dismiss()
        }
    }


}
