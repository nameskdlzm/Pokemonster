package com.mrhi2024.pokemonster.Fragment

import android.app.Activity
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mrhi2024.pokemon.databinding.FragmentPokemonBinding


class PokemonFragment: Fragment() {

    private val binding by lazy { FragmentPokemonBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onResume() {
        super.onResume()

        loadData()
    }

    private fun loadData(){

        val db =requireContext().openOrCreateDatabase("PokemonShape", Activity.MODE_PRIVATE,null)

        val shape = db.rawQuery("SELECT * FROM favor",null)

        shape?.apply {
            moveToFirst()

            val ShapeList:MutableList<Shape> = mutableListOf()



        }

    }

}