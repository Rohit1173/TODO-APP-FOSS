package com.example.todo20

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todo20.data.word
import com.example.todo20.data.worddatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class viewmodel(application: Application) :AndroidViewModel(application){

    private val  myrepo:repository
    val allwords : LiveData<MutableList<word>>
    init {
        val dao =worddatabase.getDatabase(application).wordDao()
        myrepo =repository(dao)
        allwords =myrepo.getwords
    }
    fun additem(myword: word){
        viewModelScope.launch(Dispatchers.IO) {
            myrepo.insertitem(myword)
        }
    }
    fun updateword(myword: word){
        viewModelScope.launch(Dispatchers.IO) {
            myrepo.updateword(myword)
        }
    }
    fun deleteword(myword: word){
        viewModelScope.launch(Dispatchers.IO) {
            myrepo.deleteword(myword)
        }
    }




}