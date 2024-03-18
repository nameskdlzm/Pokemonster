package com.mrhi2024.pokemon.Activities
import PokemonData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.mrhi2024.pokemon.R
import com.mrhi2024.pokemon.databinding.ActivityMainBinding
import com.mrhi2024.pokemonster.Fragment.PokemonListFragment
import com.mrhi2024.pokemonster.Fragment.PokemonMapFragment
import com.mrhi2024.pokemonster.Fragment.PokemonTypeFragment
import com.mrhi2024.pokemonster.Network.RetrofitService
import com.mrhi2024.tpsearchplacebykakao.network.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    // 포켓몬 프래그먼트
    var pokemonmain: PokemonData? = null

    //    var pokemonmain2: Pokefinal2? = null
    var pokelist: MutableList<PokemonData>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.container_fragment, PokemonListFragment())
            .commit()

        binding.bnv.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.menu_bnv_main -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment, PokemonListFragment()).commit()

                R.id.menu_bnv_map -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment, PokemonMapFragment()).commit()

                R.id.menu_bnv_type -> supportFragmentManager.beginTransaction()
                    .replace(R.id.container_fragment, PokemonTypeFragment()).commit()

//                R.id.menu_bnv_favor -> supportFragmentManager.beginTransaction()
//                    .replace(R.id.container_fragment),PokemonFavorFragment())

            }

            true

        }

        binding.toolbar.setNavigationOnClickListener {
            pokemon()
        }


    }


    private fun pokemon() {
//        Toast.makeText(this, "aaa", Toast.LENGTH_SHORT).show()
        val s = binding.etSearch.text.toString()

        val retrofit = RetrofitHelper.getRetrofitInstance("http://www.serebii.net")
        val retrofitSevice = retrofit.create(RetrofitService::class.java)
        val call = retrofitSevice.pokemonSearch2(s.toInt())

//        call.enqueue(object : Callback<PokemonData> {
//            override fun onResponse(call: Call<PokemonData>, response: Response<PokemonData>) {
//                for (i in 0..20){
////                    val pogo = PokemonData(pokemonmain!!.id,pokemonmain!!.name,pokemonmain!!.sprites,pokemonmain!!.species)
////                    pokelist.add(pokemonmain!!.id.toString(0),pokemonmain!!.name,pokemonmain!!.sprites,pokemonmain!!.species).
//                    response.body()
//
//
////                }
//                pokemonmain = response.body()
//
//                AlertDialog.Builder(this@MainActivity).setMessage("${pokemonmain}").create().show()
//            }
//
//            override fun onFailure(call: Call<PokemonData>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
//            }
//
//        })
////
//        }
////
////
    }

}
