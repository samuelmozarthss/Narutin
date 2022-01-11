package com.example.narutin.repository.remote

import com.example.narutin.CharactersModel
import com.example.narutin.service.CharacterServices
import retrofit2.Call

class RemoteRepositoryImpl(private val characterServices: CharacterServices): RemoteRepository {
    override fun getAllCharacters(): Call<List<CharactersModel>> {
        return characterServices.list()
    }
}