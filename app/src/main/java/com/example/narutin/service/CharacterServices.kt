package com.example.narutin.service

import com.example.narutin.CharactersModel
import retrofit2.Call
import retrofit2.http.GET

interface CharacterServices {

    @GET("characters")
    fun list(): Call<List<CharactersModel>>
}