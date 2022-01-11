package com.example.narutin.repository.local

import com.example.narutin.CharactersModel
import com.example.narutin.repository.CharacterDAO

class CharacterRepositoryImpl(private val characterDao: CharacterDAO):CharacterRepository {
    override fun getAll(): List<CharactersModel> {
        return characterDao.getAll()
    }

    override fun save(character: CharactersModel) {
        return characterDao.save(character)
    }
}