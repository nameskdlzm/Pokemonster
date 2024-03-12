package com.mrhi2024.pokemon.Activities

import PokemonData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.mrhi2024.pokemon.R
import com.mrhi2024.pokemon.databinding.ActivityMainBinding
import com.mrhi2024.pokemonster.Fragment.PokemonFragment
import com.mrhi2024.pokemonster.Fragment.PokemonMapFragment
import com.mrhi2024.pokemonster.Fragment.PokemonTypeFragment
import com.mrhi2024.tpsearchplacebykakao.network.RetrofitHelper
import retrofit2.Retrofit
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var pokemon:PokemonData? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.container_fragment,PokemonFragment()).commit()

        binding.bnv.setOnItemSelectedListener {

            when(it.itemId){

                R.id.menu_bnv_map -> supportFragmentManager.beginTransaction().replace(R.id.container_fragment,PokemonFragment()).commit()
//                R.id.menu_bnv_search -> supportFragmentManager.beginTransaction().replace(R.id.container_fragment,PokemonMapFragment()).commit()
                R.id.menu_bnv_type -> supportFragmentManager.beginTransaction().replace(R.id.container_fragment,PokemonTypeFragment()).commit()

            }

            true

        }

    }

    private fun Pokemon(){

        val inputStream = assets.open("https://pokeapi.co/api/v2/pokemon/")
        val inputStreamReader =InputStreamReader(inputStream)
        val reader = BufferedReader(inputStreamReader)

        val builder =StringBuilder()
        while (true){
            val line =reader.readLine() ?: break
            builder.append(line+"\n")

        }
        val jsonString = builder.toString()

        val gson = Gson()
        var pokemon:PokemonData = gson.fromJson(jsonString,pokemon!!::class.java)
//        binding.containerFragment = jsonString



    }

}