package com.example.narutin.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.narutin.CharactersModel
import com.example.narutin.repository.CharacterDAO
import com.example.narutin.repository.Converter

@Database(entities = [CharactersModel::class], version = 1)@TypeConverters(Converter::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun characterDAO(): CharacterDAO

    companion object {

        private lateinit var INSTANCE: AppDatabase
        fun getDatabase(context: Context): AppDatabase {
            if (!::INSTANCE.isInitialized) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "narutoDB")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}