package com.mrhi2024.pokemonster.Network

import PokemonData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("/api/v2/pokemon")
    fun pokemonSearch(@Query("name") name: String): Call<PokemonData>

//    @GET("v2/ability/?limit=20&offset=20")
//    fun pokemonSearch5(@Query("name") name: String): Call<PokemonData>


    @GET("/api/v2/pokemon/{id}")
    fun pokemonSearch2(@Path("id") id:Int ): Call<PokemonData>

    @GET("/api/v2/pokemon/{id}")
    fun pokemonSearch3(@Path("id") id: Int): Call<PokemonData>

    @GET("/api/v2/ability/{id}")
    fun pokemonSearch4(@Path("id") id: Int): Call<PokemonData>

}