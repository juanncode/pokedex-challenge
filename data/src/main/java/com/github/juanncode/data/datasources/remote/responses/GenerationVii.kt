package com.github.juanncode.data.datasources.remote.responses

import com.google.gson.annotations.SerializedName

data class GenerationVii(
    val icons: com.github.juanncode.data.datasources.remote.responses.Icons,
    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: com.github.juanncode.data.datasources.remote.responses.UltraSunUltraMoon
)