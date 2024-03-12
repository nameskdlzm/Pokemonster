package com.mrhi2024.pokemon.Activities

import PokemonData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mrhi2024.pokemon.R
import com.mrhi2024.pokemon.databinding.ActivityMainBinding
import com.mrhi2024.pokemonster.Fragment.PokemonFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var pokemon:PokemonData? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        supportFragmentManager.beginTransaction().add(R.id.container_fragment,)

    }
}