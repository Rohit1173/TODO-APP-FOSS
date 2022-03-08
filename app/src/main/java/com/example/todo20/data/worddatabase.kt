package com.example.todo20.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [word::class], version = 1, exportSchema = false)
abstract class worddatabase: RoomDatabase() {
    abstract fun wordDao(): worddao
    companion object{
        @Volatile
        private var INSTANCE: worddatabase? = null

        fun getDatabase(context: Context): worddatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    worddatabase::class.java,
                    "item_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}