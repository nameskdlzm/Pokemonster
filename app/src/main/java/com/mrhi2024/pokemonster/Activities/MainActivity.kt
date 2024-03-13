package com.mrhi2024.pokemon.Activities

import PokemonData
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.gson.Gson
import com.mrhi2024.pokemon.R
import com.mrhi2024.pokemon.databinding.ActivityMainBinding
import com.mrhi2024.pokemonster.Fragment.PokemonFragment
import com.mrhi2024.pokemonster.Fragment.PokemonMapFragment
import com.mrhi2024.pokemonster.Fragment.PokemonTypeFragment
import com.mrhi2024.pokemonster.Network.RetrofitService
import com.mrhi2024.tpsearchplacebykakao.network.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
//    private lateinit var binding:ActivityMainBinding

    var pokemon:PokemonData? =null

    // 포켓몬 이름
    var pokemonmain:PokemonData? =null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.container_fragment,PokemonFragment()).commit()

        binding.bnv.setOnItemSelectedListener {

            when(it.itemId){

                R.id.menu_bnv_map -> supportFragmentManager.beginTransaction().replace(R.id.container_fragment,PokemonFragment()).commit()
                R.id.menu_bnv_search -> supportFragmentManager.beginTransaction().replace(R.id.container_fragment,PokemonMapFragment()).commit()
                R.id.menu_bnv_type -> supportFragmentManager.beginTransaction().replace(R.id.container_fragment,PokemonTypeFragment()).commit()

            }

            true

        }

        Pokemon()

    }

    private fun Pokemon(){
//        Toast.makeText(this, "aaa", Toast.LENGTH_SHORT).show()

        val retrofit = RetrofitHelper.getRetrofitInstance("https://pokeapi.co")
        val retrofitSevice = retrofit.create(RetrofitService::class.java)
        val call = retrofitSevice.PokemonSearch("clefairy")
        call.enqueue(object :Callback<PokemonData>{
            override fun onResponse(call: Call<PokemonData>, response: Response<PokemonData>) {
                val s = response.body()
                val name = s?.id
//                Pokemonname = response.body()
                AlertDialog.Builder(this@MainActivity).setMessage("$s").create().show()

            }

            override fun onFailure(call: Call<PokemonData>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })



    }

}