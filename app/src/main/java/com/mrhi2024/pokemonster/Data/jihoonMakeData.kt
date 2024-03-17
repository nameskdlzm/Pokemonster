package com.mrhi2024.pokemonster.Data

data class jihoonMakeData(val count:Int,var next:String, var previous:String,var results: List<Name>)
data class Name(
    var name:String,
    var url:String,
)
data class Abilites(val abilities:List<Ability>,val base_experience:Int,val cries:Cries,val forms:List<Forms>,val game_indices:List<GameIndices>,val height:Int)
data class Ability(val ability:Abilitt,val is_hidden:Boolean,val slot:Int)
data class Abilitt(val name: String,val url :String)
data class Cries(val latest:String,val legacy:String)
data class Forms(val name:String,val url:String)
data class GameIndices(val game_index:String,val version:Version )
data class Version(val name:String,val url:String)
//data class HeldItems()
//val held_items:List<HeldItems> // 배열