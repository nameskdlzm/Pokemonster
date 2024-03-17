import com.mrhi2024.pokemonster.Data.Ability
import com.mrhi2024.pokemonster.Data.Name

//data class Pokefinal(val count:Int, var next:String, var previous:String, var results: List<NamedAPIResource>)
data class Pokefinal(var abilities: List<Ability>,var pogo: List<PokemonData>)



data class PokemonData(
//    var abilities: List<PokemonAbility>,
    var id: Int,
    var name: String,
//    var base_experience: Int,
    var height: Int,
//    var is_default: Boolean,
    var order: Int,
    var weight: Int,
//    var forms: List<NamedAPIResource>,
//    var game_indices: List<VersionEncounterDetail>,
//    var held_items: List<PokemonHeldItem>,
//    var location_area_encounters: String,
//    var moves: List<PokemonMove>,
//    var past_types: List<PokemonTypePast>,
    var sprites: PokemonSprites,
//    var cries: PokemonCries,
//    var species: NamedAPIResource,
//    var stats: List<PokemonStat>,
    var types: List<PokemonType>
)


data class Name(var name:String , var url:String)

data class PokemonAbility(
    var is_hidden: Boolean,
    var slot: Int,
    var ability: NamedAPIResource
)

data class NamedAPIResource(
    var name: String,
    var url: String
)

data class VersionEncounterDetail(
    var version: NamedAPIResource,
    var max_chance: Int,
    var encounter_details: List<Encounter>
)

data class Encounter(
    var min_level: Int,
    var max_level: Int,
    var condition_values: List<NamedAPIResource>,
    var chance: Int,
    var method: NamedAPIResource
)

data class PokemonHeldItem(
    var item: NamedAPIResource,
    var version_details: List<PokemonHeldItemVersion>
)

data class PokemonHeldItemVersion(
    var version: NamedAPIResource,
    var rarity: Int
)

data class PokemonMove(
    var move: NamedAPIResource,
    var version_group_details: PokemonMoveVersion
)

data class PokemonMoveVersion(
    var move_learn_method: NamedAPIResource,
    var version_group: NamedAPIResource,
    var level_learned_at: Int
)

data class PokemonTypePast(
    var generation: NamedAPIResource,
    var types: PokemonType
)

data class PokemonType(
    var slot: Int,
    var type: NamedAPIResource
)

data class PokemonSprites(
    var back_default: String
)

data class PokemonCries(
    var latest: String
)

data class PokemonStat(
    var stat: NamedAPIResource,
    var effort: Int,
    var base_stat: Int
)