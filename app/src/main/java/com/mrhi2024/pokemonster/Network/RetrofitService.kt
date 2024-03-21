package com.mrhi2024.pokemonster.Network

import KakaoSearchPlaceResponse
import PokemonData
import RealPokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

//    @GET("/Biuni/PokemonGO-Pokedex/master/pokedex.json")
//    fun pokemonSearch(): Call<RealPokemon>

    @GET("robert-z/simple-pokemon-json-api/blob/master/data/pokemon.json")
    fun pokemonSearch(): Call<RealPokemon>

    @Headers("Authorization: KakaoAK 218ae28eb63a74438ec96a51e9568f9b")
    @GET("/v2/local/search/keyword.json?sort=distance")
    fun searchPlace(@Query("query") query:String,@Query("x") longitude:String,@Query("y") letitude:String) : Call<KakaoSearchPlaceResponse>


}