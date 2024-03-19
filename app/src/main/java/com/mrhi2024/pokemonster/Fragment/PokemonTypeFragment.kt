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

    //Fragment에 속한 View나 ViewGroup에 대한 UI 바인딩 작업을 할 수 있다
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setOnClickListener {


        }
    }

    // 화면이 사용자에게 보여질때
    override fun onResume() {
        super.onResume()


    }
}