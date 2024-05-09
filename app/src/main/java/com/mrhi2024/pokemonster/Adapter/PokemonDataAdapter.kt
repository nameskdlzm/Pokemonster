package com.mrhi2024.pokemonster.Adapter

import PokemonData
import RealPokemon
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.mrhi2024.pokemon.databinding.RecyclerItemListFragmentBinding
import com.mrhi2024.pokemonster.Activities.TypeActivity

class PokemonDataAdapter(val context: Context, val document: List<PokemonData>) : Adapter<PokemonDataAdapter.VH>() {

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
        holder.binding.tvPoketv.text = poke.id.toString()
        holder.binding.pokeType.text = poke.type.toString()
        Glide.with(context).load(poke.img).into(holder.binding.ivCat)

//        holder.binding.root.setOnClickListener {
//            val intent:Intent = Intent(context,TypeActivity::class.java)
//
//            val gson = Gson()
//            val s:String = gson.toJson(poke)
//            intent.putExtra("type",s)
//
//            context.startActivity(intent)
//        }

    }


}

