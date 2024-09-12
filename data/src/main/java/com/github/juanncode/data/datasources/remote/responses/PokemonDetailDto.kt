package com.github.juanncode.data.datasources.remote.responses

import com.google.gson.annotations.SerializedName

data class PokemonDetailDto(
    val abilities: List<com.github.juanncode.data.datasources.remote.responses.Ability>,
    @SerializedName("base_experience")
    val baseExperience: Int,
    val forms: List<com.github.juanncode.data.datasources.remote.responses.Form>,
    @SerializedName("game_indices")
    val gameIndices: List<com.github.juanncode.data.datasources.remote.responses.GameIndice>,
    val height: Int,
    @SerializedName("held_items")
    val heldItems: List<Any>,
    val id: Int,
    @SerializedName("is_default")
    val isDefault: Boolean,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String,
    val moves: List<com.github.juanncode.data.datasources.remote.responses.Move>,
    val name: String,
    val order: Int,
    @SerializedName("past_types")
    val pastTypes: List<Any>,
    val species: com.github.juanncode.data.datasources.remote.responses.Species,
    val sprites: com.github.juanncode.data.datasources.remote.responses.Sprites,
    val stats: List<com.github.juanncode.data.datasources.remote.responses.Stat>,
    val types: List<com.github.juanncode.data.datasources.remote.responses.Type>,
    val weight: Int
)