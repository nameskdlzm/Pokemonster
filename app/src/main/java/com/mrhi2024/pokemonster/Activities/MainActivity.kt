package com.mrhi2024.pokemon.Activities

import Pokefinal
import PokemonData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
//    private lateinit var binding:ActivityMainBinding


    // 포켓몬 프래그먼트
    var pokemonmain: PokemonData? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.container_fragment, PokemonFragment())
            .commit()

        binding.bnv.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.menu_bnv_map -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment, PokemonFragment()).commit()

                R.id.menu_bnv_search -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment, PokemonMapFragment()).commit()

                R.id.menu_bnv_type -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment, PokemonTypeFragment()).commit()

            }

            true

        }

        Pokemon()


    }

    private fun Pokemon() {
        Toast.makeText(this, "aaa"  , Toast.LENGTH_SHORT).show()

        val retrofit = RetrofitHelper.getRetrofitInstance("https://pokeapi.co")
        val retrofitSevice = retrofit.create(RetrofitService::class.java)
//        val call = retrofitSevice.pokemonSearch("Bulbasaur")
//        val call = retrofitSevice.pokemonSearch2(1)
        val call = retrofitSevice.pokemonSearch3(1)

//        call.enqueue(object :Callback<String> {
//            override fun onResponse(call: Call<String>, response: Response<String>) {
//                val s = response.body()
//                AlertDialog.Builder(this@MainActivity).setMessage("$s").create().show()
//            }
//
//            override fun onFailure(call: Call<String>, t: Throwable) {
//                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
//            }
//
//        })

        call.enqueue(object : Callback<PokemonData> {
            override fun onResponse(call: Call<PokemonData>, response: Response<PokemonData>) {
                pokemonmain = response.body()
//                AlertDialog.Builder(this@MainActivity).setMessage("${pokemonmain?.pogo?.get(0)?.id} : ${pokemonmain?.pogo?.get(0)?.name}\n ${pokemonmain?.pogo?.get(0)?.height}\n${pokemonmain?.pogo?.get(0)?.weight}\n${pokemonmain?.pogo?.get(0)?.order}\n${pokemonmain?.pogo?.get(0)?.sprites?.back_default}").create().show()
//                Log.d("poData", "${pokemonmain}")
                    AlertDialog.Builder(this@MainActivity).setMessage("${pokemonmain}").create().show()
            }

            override fun onFailure(call: Call<PokemonData>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}



//}