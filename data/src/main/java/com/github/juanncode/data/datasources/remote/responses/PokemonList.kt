package com.github.juanncode.data.datasources.remote.responses

import com.google.gson.annotations.SerializedName

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<com.github.juanncode.data.datasources.remote.responses.Result>
)