package com.github.juanncode.domain.repository

import com.github.juanncode.domain.Pokemon
import com.github.juanncode.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getPokemons() : Flow<List<Pokemon>>
    suspend fun fetchPokemons(): Resource<Unit>
}