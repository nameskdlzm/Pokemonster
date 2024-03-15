package com.mrhi2024.pokemonster.Network

import Pokefinal
import PokemonData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("/api/v2/pokemon")
    fun pokemonSearch(@Query("name") name: String): Call<Pokefinal>


    @GET("/api/v2/pokemon/{id}")
    fun pokemonSearch2(@Path("id") id:Int ): Call<String>

    @GET("/api/v2/pokemon/{id}")
    fun pokemonSearch3(@Path("id") id: Int): Call<PokemonData>


}