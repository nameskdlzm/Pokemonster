package com.mrhi2024.pokemonster.Fragment

import NamedAPIResource
import PokemonAbility
import PokemonData
import PokemonType
import VersionEncounterDetail
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mrhi2024.pokemon.databinding.FragmentPokemonBinding

class PokemonTypeFragment:Fragment() {

        lateinit var binding: FragmentPokemonBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

//        loadData()
    }

//    private fun loadData(){
//
//        val db =requireContext().openOrCreateDatabase("type", Activity.MODE_PRIVATE,null)
//
//        val cursor =db.rawQuery("SELECT * FROM type",null)
//
//        cursor?.apply {
//            moveToFirst()
//
//            val PokemonType:MutableList<PokemonData> = mutableListOf()
//
//                var id = Int
//                var name = getString(0)
//                var base_experience = Int
//                var height = Int
//                var is_default = Boolean
//                var order = Int
//                var weight = Int
//                var abilities = List<PokemonAbility>
//                var forms = List<NamedAPIResource>
//                var game_indices = List<VersionEncounterDetail>
//                var
//        }
//
//    }

}