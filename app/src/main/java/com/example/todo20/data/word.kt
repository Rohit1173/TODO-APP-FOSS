package com.example.todo20.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class word(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val work:String

)