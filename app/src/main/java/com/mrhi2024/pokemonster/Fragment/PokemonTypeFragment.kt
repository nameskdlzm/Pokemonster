package com.mrhi2024.pokemonster.Fragment

import NamedAPIResource
import PokemonAbility
import PokemonData
import PokemonType
import RealPokemon
import TypePokemon
import VersionEncounterDetail
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.mrhi2024.pokemon.Activities.LoginActivity
import com.mrhi2024.pokemon.Activities.MainActivity
import com.mrhi2024.pokemon.R
import com.mrhi2024.pokemon.databinding.FragmentPokemonBinding
import com.mrhi2024.pokemon.databinding.FragmentTypeBinding
import com.mrhi2024.pokemonster.Activities.TypeActivity
import com.mrhi2024.pokemonster.Adapter.PokemonDataAdapter

class PokemonTypeFragment : Fragment() {

    lateinit var binding: FragmentTypeBinding

//    var typeUnit:RealPokemon = RealPokemon(pokemon = List<PokemonData>(0,))

    var type: String? = null

    private lateinit var mainActivity: MainActivity

//    var s = clickchoic()


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
        mainActivity =  requireActivity() as MainActivity
        val ma:MainActivity = activity as MainActivity
        ma.realPokemon ?: return

            binding.typeFighting.setOnClickListener { showPokemonOfType("Fighting") }
            binding.typeNormal.setOnClickListener { showPokemonOfType("Normal") }
            binding.typeBug.setOnClickListener { showPokemonOfType("Bug") }
            binding.typeIce.setOnClickListener { showPokemonOfType("Ice") }
            binding.typeDragon.setOnClickListener { showPokemonOfType("Dragon") }
            binding.typePsychic.setOnClickListener { showPokemonOfType("Psychic") }
            binding.typeElectric.setOnClickListener { showPokemonOfType("Electric") }
            binding.typeGrass.setOnClickListener { showPokemonOfType("Grass") }
            binding.typeWater.setOnClickListener { showPokemonOfType("Water") }
            binding.typeFire.setOnClickListener { showPokemonOfType("Fire") }
            binding.typeRock.setOnClickListener { showPokemonOfType("Rock") }
            binding.typeGhost.setOnClickListener { showPokemonOfType("Ghost") }
            binding.typeGround.setOnClickListener { showPokemonOfType("Ground") }
            binding.typeFlying.setOnClickListener { showPokemonOfType("Flying") }
            binding.typePoison.setOnClickListener { showPokemonOfType("Poison") }



        }
    fun showPokemonOfType(type: String) {
        val pokemonList = mainActivity.realPokemon?.pokemon?.filter { it.type.contains(type) }
        if (pokemonList.isNullOrEmpty()) {
            Toast.makeText(requireContext(), "해당 타입의 포켓몬이 없습니다.", Toast.LENGTH_SHORT).show()
        } else {
//            val pokemonNames = pokemonList.joinToString("\n") { it.name }
//            AlertDialog.Builder(requireContext())
//                .setTitle("$type 타입 포켓몬")
//                .setMessage(pokemonNames)
//                .setPositiveButton("확인") { dialog, _ -> dialog.dismiss() }
//                .show()
            val ma:MainActivity = activity as MainActivity
            val intent:Intent = Intent(requireContext(),TypeActivity::class.java)
            val gson = Gson()
            val s:String = gson.toJson(ma.realPokemon?.pokemon)
            intent.putExtra("type",s)

            requireContext().startActivity(intent)



        }
    }
}


    // 화면이 사용자에게 보여질때
//    override fun onResume() {
//        super.onResume()
//        val main = activity as MainActivity
//        val ww = main.pokemonmain?.type
//        val s: MutableList<PokemonData> = mutableListOf()
////        val poke:TypePokemon = TypePokemon()
//
//        val ma: MainActivity = activity as MainActivity
//        ma.realPokemon ?: return
//        binding.typeFighting.setOnClickListener {
//
////            for(PokeData in s){
////                val  pokemonName = PokeData.name
////                Log.d("Pokemon" , "포켓몬이름:$pokemonName")
////        }
//
////            Toast.makeText(requireContext(), "$s", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.typeNormal.setOnClickListener {
//            Toast.makeText(requireContext(), "구현되지 않은 기능입니다", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.typeBug.setOnClickListener {
//            Toast.makeText(requireContext(), "구현되지 않은 기능입니다", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.typeIce.setOnClickListener {
//            Toast.makeText(requireContext(), "구현되지 않은 기능입니다", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.typeDragon.setOnClickListener {
//            Toast.makeText(requireContext(), "구현되지 않은 기능입니다", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.typePsychic.setOnClickListener {
//            Toast.makeText(requireContext(), "구현되지 않은 기능입니다", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.typeElectric.setOnClickListener {
//            Toast.makeText(requireContext(), "구현되지 않은 기능입니다", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.typeGrass.setOnClickListener {
//            Toast.makeText(requireContext(), "구현되지 않은 기능입니다", Toast.LENGTH_SHORT).show()
//
//            for (pokemon in ma.realPokemon!!.pokemon) {
//
//                if (pokemon.type == ma.realPokemon!!.pokemon.get(0).type) {
//                    s.add(pokemon)
//                    AlertDialog.Builder(requireContext()).setMessage("$s").create().show()
////                    Log.d("aaa","$s")
//                } else if (pokemon.type == ma.realPokemon!!.pokemon.get(1).type) {
//                    s.add(pokemon)
////                    AlertDialog.Builder(requireContext()).setMessage("$s").create().show()
//                } else if (s.isNotEmpty()) {
////                    AlertDialog.Builder(requireContext()).setMessage("$s").create().show()
//                } else {
//                    Toast.makeText(requireContext(), "aaa", Toast.LENGTH_SHORT).show()
//                }
//            }
//
//
//        }
//
//
//        binding.typeWater.setOnClickListener {
//            Toast.makeText(requireContext(), "구현되지 않은 기능입니다", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.typeFire.setOnClickListener {
//            Toast.makeText(requireContext(), "구현되지 않은 기능입니다", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.typeRock.setOnClickListener {
//            Toast.makeText(requireContext(), "구현되지 않은 기능입니다", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.typeGhost.setOnClickListener {
//            Toast.makeText(requireContext(), "구현되지 않은 기능입니다", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.typeGround.setOnClickListener {
//            Toast.makeText(requireContext(), "구현되지 않은 기능입니다", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.typeFlying.setOnClickListener {
//            Toast.makeText(requireContext(), "구현되지 않은 기능입니다", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.typePoison.setOnClickListener {
//            Toast.makeText(requireContext(), "구현되지 않은 기능입니다", Toast.LENGTH_SHORT).show()
//        }
//
//
//
////        binding.typeNormal.setOnClickListener {
////            while (true) {
//////                if (binding.typeNormal == (binding.typeNormal)) {
//////                    s.add(ma.realPokemon!!)
//////                }
//////                else if (binding.typeNormal !=binding.typeNormal){
//////                    continue
//////                }else if (ww ==null){
//////                    break
//////                }
////                if (ww!!.equals("Normal")){
////                    s.add(ma.realPokemon!!)
////                }else if (ww != binding.root){
////                    continue
//////                    Log.d("aaa","$ww")
////                }
////                break
////            }
//
////            AlertDialog.Builder(requireContext()).setMessage("${ww}").create().show()
////        }
//
//        //
////        private fun setChoiceButton() {
////
////            binding.typeFlying.setOnClickListener { clickchoic() }
////            binding.typePoison.setOnClickListener { clickchoic() }
////            binding.typeGround.setOnClickListener { clickchoic() }
////            binding.typeRock.setOnClickListener { clickchoic() }
////            binding.typeBug.setOnClickListener { clickchoic() }
////            binding.typeGhost.setOnClickListener { clickchoic() }
////            binding.typeFire.setOnClickListener { clickchoic() }
////            binding.typeWater.setOnClickListener { clickchoic() }
////            binding.typeGrass.setOnClickListener { clickchoic() }
////            binding.typeElectric.setOnClickListener { clickchoic() }
////            binding.typePsychic.setOnClickListener { clickchoic() }
////            binding.typeIce.setOnClickListener { clickchoic() }
////            binding.typeDragon.setOnClickListener { clickchoic() }
//////        binding.typeSteel.setOnClickListener { clickchoic() }
//////        binding.typeDark.setOnClickListener { clickchoic() }
//////        binding.typeFalry.setOnClickListener { clickchoic() }
////        }
////
//        fun clickchoic() {
//
//            var choiceId = view?.id
//
//            when (choiceId) {
//                R.id.type_Normal -> type = "Normal"
//                R.id.type_Fighting -> type = "Fighting"
//                R.id.type_Flying -> type = "Flying"
//                R.id.type_Poison -> type = "Poison"
//                R.id.type_Ground -> type = "Ground"
//                R.id.type_Rock -> type = "Rock"
//                R.id.type_Bug -> type = "Bug"
//                R.id.type_Ghost -> type = "Ghost"
//                R.id.type_Fire -> type = "Fire"
//                R.id.type_Water -> type = "Water"
//                R.id.type_Grass -> type = "Grass"
//                R.id.type_Electric -> type = "Electric"
//                R.id.type_Psychic -> type = "Psychic"
//                R.id.type_Ice -> type = "Ice"
//                R.id.type_Dragon -> type = "Dragon"
////            R.id.type_Steel -> type = "Steel"
////            R.id.type_Dark -> type = "Dark"
////            R.id.type_Falry -> type = "Falry"
//            }
//        }


