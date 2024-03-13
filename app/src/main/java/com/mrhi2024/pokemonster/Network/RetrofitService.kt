package com.mrhi2024.pokemonster.Network

import PokemonData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

@GET("/api/v2/pokemon")
fun PokemonSearch(@Query("name") name:String): Call<PokemonData>




}