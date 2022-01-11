package com.example.narutin.repository.local

import com.example.narutin.CharactersModel

interface CharacterRepository {

    fun getAll(): List<CharactersModel>

    fun save(character: CharactersModel)
}