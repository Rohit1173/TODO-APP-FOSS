package com.example.todo20.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface worddao {
    @Insert
    suspend fun addword(word: word)

    @Delete
    suspend fun  deleteword(word: word)

    @Update
    suspend fun updateword(word: word)

    @Query("SELECT * FROM words_table ORDER BY id ASC")
    fun getwords():LiveData<MutableList<word>>

}