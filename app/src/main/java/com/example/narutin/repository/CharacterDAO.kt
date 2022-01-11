package com.example.narutin.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.narutin.CharactersModel

@Dao
interface CharacterDAO {

    @Query("SELECT * FROM character")
    fun getAll(): List<CharactersModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(character: CharactersModel)
}