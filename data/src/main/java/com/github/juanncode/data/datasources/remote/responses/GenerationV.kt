package com.github.juanncode.data.datasources.remote.responses

import com.google.gson.annotations.SerializedName

data class GenerationV(
    @SerializedName("black-white")
    val blackWhite: com.github.juanncode.data.datasources.remote.responses.BlackWhite
)