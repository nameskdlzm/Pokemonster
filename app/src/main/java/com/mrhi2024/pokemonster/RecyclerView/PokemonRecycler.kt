package com.mrhi2024.pokemonster.RecyclerView

import PokemonData
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mrhi2024.pokemon.databinding.RecyclerItemFragmentBinding

class PokemonRecycler(val context: Context , val document:List<PokemonData>):Adapter<PokemonRecycler.VH>() {

    inner class VH(val binding:RecyclerItemFragmentBinding):ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutInflater:LayoutInflater =LayoutInflater.from(context)
        val binding = RecyclerItemFragmentBinding.inflate(layoutInflater,parent,false)
        return VH(binding)
    }

    override fun getItemCount(): Int {
        return document.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val Poke:PokemonData =document[position]

        holder.binding.tvNum.text =Poke.toString()
        holder.binding.ivCat
    }


}