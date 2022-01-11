package com.example.narutin.repository.remote

import com.example.narutin.CharactersModel
import retrofit2.Call

interface RemoteRepository {

    fun getAllCharacters(): Call<List<CharactersModel>>
}