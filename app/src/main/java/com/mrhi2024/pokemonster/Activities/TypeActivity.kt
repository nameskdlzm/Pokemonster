package com.mrhi2024.pokemonster.Activities

import PokemonData
import PokemonType
import RealPokemon
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.google.gson.Gson
import com.mrhi2024.pokemon.databinding.ActivityTypeBinding

class TypeActivity : AppCompatActivity() {

    private val binding by lazy { ActivityTypeBinding.inflate(layoutInflater) }

    lateinit var type: RealPokemon
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val s: String? = intent.getStringExtra("type")
//
//        val s: String? = intent.getStringExtra("type")
//        val typeList: List<RealPokemon> = Gson().fromJson(s, Array<RealPokemon>::class.java).toList()
//
//        val s: String? = intent.getStringExtra("type")
//        val type: RealPokemon? = Gson().fromJson(s, RealPokemon::class.java)


        s.also {

            type = Gson().fromJson(it,RealPokemon::class.java)

        }


    }


}
