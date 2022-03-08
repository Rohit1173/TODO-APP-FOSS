package com.example.todo20

import androidx.lifecycle.LiveData
import com.example.todo20.data.word
import com.example.todo20.data.worddao

class repository(private val worddao: worddao) {
    suspend fun insertitem(word: word){
        worddao.addword(word)

    }
    suspend fun updateword(word:word){
        worddao.updateword(word)
    }
    suspend fun deleteword(word: word){
        worddao.deleteword(word)

    }
    val getwords: LiveData<MutableList<word>> = worddao.getwords()
}
