package com.github.juanncode.data.datasources.remote

import com.github.juanncode.domain.Pokemon
import com.github.juanncode.domain.PokemonDetail
import com.github.juanncode.domain.utils.Resource

interface RemoteDataSource {
    suspend fun fetchPokemons(): Resource<List<Pokemon>>
    suspend fun getPokemonDetail(id: Int): Resource<PokemonDetail>
}