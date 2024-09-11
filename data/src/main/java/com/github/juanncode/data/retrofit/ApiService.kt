package com.github.juanncode.data.retrofit

import com.github.juanncode.data.datasources.remote.model.PokemonResponse
import com.github.juanncode.data.datasources.remote.responses.PokemonDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/v2/pokemon?limit=150")
    suspend fun fetchPokemons(): PokemonResponse

    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name: String
    ): PokemonDetailDto
}