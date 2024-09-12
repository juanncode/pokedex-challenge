package com.github.juanncode.data.datasources.remote.responses

import com.google.gson.annotations.SerializedName

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int,
    val effort: Int,
    val stat: com.github.juanncode.data.datasources.remote.responses.StatX
)