package com.github.juanncode.data.datasources.remote.model

import kotlinx.serialization.Serializable

data class PokemonResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonDto> = emptyList()
)
