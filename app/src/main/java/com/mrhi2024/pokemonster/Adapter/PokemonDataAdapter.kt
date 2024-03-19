package com.mrhi2024.pokemonster.Adapter

import PokemonData
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.mrhi2024.pokemon.databinding.RecyclerItemListFragmentBinding

class PokemonDataAdapter(val context: Context, val document: List<PokemonData>) :
    Adapter<PokemonDataAdapter.VH>() {

    inner class VH(val binding: RecyclerItemListFragmentBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val binding = RecyclerItemListFragmentBinding.inflate(layoutInflater, parent, false)
        return VH(binding)
    }

    override fun getItemCount(): Int {
        return document.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val poke: PokemonData = document[position]

        holder.binding.tvName.text = poke.name
        holder.binding.tvNum.text = poke.id.toString()
        Glide.with(context).load(poke.img).into(holder.binding.ivCat)

        holder.binding.root.setOnClickListener {
            val intent = Intent(context, PokemonData::class.java)

            val gson = Gson()
            val s: String = gson.toJson(poke)
            intent.putExtra("poke", s)

            context.startActivity(intent)
        }

    }


}

