package com.mrhi2024.pokemonster.Fragment


import PokemonData
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mrhi2024.pokemon.Activities.MainActivity
import com.mrhi2024.pokemon.databinding.FragmentPokemonBinding
import com.mrhi2024.pokemonster.Adapter.PokemonDataAdapter


class PokemonFragment : Fragment() {

    private val binding by lazy { FragmentPokemonBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ma:MainActivity =activity as MainActivity
        ma.pokemonmain ?: return
//        binding.recyclerView.adapter = PokemonDataAdapter(requireContext(), ma.pokemonmain)

    }



}