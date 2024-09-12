package com.github.juanncode.data.datasources.remote.responses

import com.google.gson.annotations.SerializedName

data class GenerationI(
    @SerializedName("red-blue")
    val redBlue: com.github.juanncode.data.datasources.remote.responses.RedBlue,
    val yellow: com.github.juanncode.data.datasources.remote.responses.Yellow
)