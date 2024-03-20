package com.mrhi2024.pokemonster.Fragment

import NamedAPIResource
import PokemonAbility
import PokemonData
import PokemonType
import RealPokemon
import VersionEncounterDetail
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mrhi2024.pokemon.Activities.MainActivity
import com.mrhi2024.pokemon.R
import com.mrhi2024.pokemon.databinding.FragmentPokemonBinding
import com.mrhi2024.pokemon.databinding.FragmentTypeBinding
import com.mrhi2024.pokemonster.Adapter.PokemonDataAdapter
import typedata

class PokemonTypeFragment : Fragment() {

    lateinit var binding: FragmentTypeBinding

//    var typeUnit:RealPokemon = RealPokemon(pokemon = List<PokemonData>(0,))

    var type: String? = null

    var s = clickchoic()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTypeBinding.inflate(layoutInflater)
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

        val ma: MainActivity = activity as MainActivity
        ma.realPokemon ?: return

//        binding.recyclerView.adapter = PokemonDataAdapter(requireContext(),ma.realPokemon!!.pokemon)
        when(s){
            s -> binding.typeNormal.setOnClickListener { setChoiceButton() }
        }

    }

    private fun setChoiceButton() {
        binding.typeNormal.setOnClickListener { clickchoic() }
        binding.typeFighting.setOnClickListener { clickchoic() }
        binding.typeFlying.setOnClickListener { clickchoic() }
        binding.typePoison.setOnClickListener { clickchoic() }
        binding.typeGround.setOnClickListener { clickchoic() }
        binding.typeRock.setOnClickListener { clickchoic() }
        binding.typeBug.setOnClickListener { clickchoic() }
        binding.typeGhost.setOnClickListener { clickchoic() }
        binding.typeSteel.setOnClickListener { clickchoic() }
        binding.typeFire.setOnClickListener { clickchoic() }
        binding.typeWater.setOnClickListener { clickchoic() }
        binding.typeGrass.setOnClickListener { clickchoic() }
        binding.typeElectric.setOnClickListener { clickchoic() }
        binding.typePsychic.setOnClickListener { clickchoic() }
        binding.typeIce.setOnClickListener { clickchoic() }
        binding.typeDragon.setOnClickListener { clickchoic() }
        binding.typeDark.setOnClickListener { clickchoic() }
        binding.typeFalry.setOnClickListener { clickchoic() }
    }

    private fun clickchoic() {

        var choiceId = view?.id

        when (choiceId) {
            R.id.type_Normal -> type = "Normal"
            R.id.type_Fighting -> type = "Fighting"
            R.id.type_Flying -> type = "Flying"
            R.id.type_Poison -> type = "Poison"
            R.id.type_Ground -> type = "Ground"
            R.id.type_Rock -> type = "Rock"
            R.id.type_Bug -> type = "Bug"
            R.id.type_Ghost -> type = "Ghost"
            R.id.type_Steel -> type = "Steel"
            R.id.type_Fire -> type = "Fire"
            R.id.type_Water -> type = "Water"
            R.id.type_Grass -> type = "Grass"
            R.id.type_Electric -> type = "Electric"
            R.id.type_Psychic -> type = "Psychic"
            R.id.type_Ice -> type = "Ice"
            R.id.type_Dragon -> type = "Dragon"
            R.id.type_Dark -> type = "Dark"
            R.id.type_Falry -> type = "Falry"
        }
    }
}