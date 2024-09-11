package com.github.juanncode.data.datasources.local

import com.github.juanncode.domain.Pokemon
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getPokemons(): Flow<List<Pokemon>>
    suspend fun upsertPokemon(pokemons: List<Pokemon>)
}