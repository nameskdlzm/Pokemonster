package com.mrhi2024.pokemonster.Fragment


import PokemonData
import PokemonSprites
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.mrhi2024.pokemon.Activities.MainActivity
import com.mrhi2024.pokemon.databinding.FragmentPokemonBinding
import com.mrhi2024.pokemonster.Adapter.PokemonDataAdapter
import com.mrhi2024.pokemonster.Network.RetrofitService
import com.mrhi2024.tpsearchplacebykakao.network.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonListFragment : Fragment() {

    private val binding by lazy { FragmentPokemonBinding.inflate(layoutInflater) }
    private val pokemonList: MutableList<PokemonData>? = null
    var pokemonmain: PokemonData? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ma: MainActivity = activity as MainActivity
        ma.realPokemon ?: return

//        AlertDialog.Builder(requireContext()).setMessage("${ma.pokemonmain}").create().show()
//        pokemonList!!.add(
//            PokemonData(
//                ma.pokemonmain!!.id,
//                ma.pokemonmain!!.name,
//                ma.pokemonmain!!.sprites,
//                ma.pokemonmain!!.species
//            )
//        )
//        val data  = List<Pokefinal2>(0,ma.pokemonmain.)
//        val popo = List<Pokefinal>(0,ma.pokemonmain )
        binding.recyclerView.adapter = PokemonDataAdapter(requireContext(), ma.realPokemon!!.pokemon)

//        for (i in 0..20) {
//
////         val pogo:PokemonData =PokemonData(ma.pokemonmain!!.id, ma.pokemonmain!!.name,ma.pokemonmain!!.sprites,ma.pokemonmain!!.species)


        }




    }


//List<Pokefinal2>(0,ma.pokemonmain)
