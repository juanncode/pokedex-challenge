package com.github.juanncode.data.datasources.remote.responses

import com.google.gson.annotations.SerializedName

data class Versions(
    @SerializedName("generation-i")
    val generationI: com.github.juanncode.data.datasources.remote.responses.GenerationI,
    @SerializedName("generation-ii")
    val generationIi: com.github.juanncode.data.datasources.remote.responses.GenerationIi,
    @SerializedName("generation-iii")
    val generationIii: com.github.juanncode.data.datasources.remote.responses.GenerationIii,
    @SerializedName("generation-iv")
    val generationIv: com.github.juanncode.data.datasources.remote.responses.GenerationIv,
    @SerializedName("generation-v")
    val generationV: com.github.juanncode.data.datasources.remote.responses.GenerationV,
    @SerializedName("generation-vi")
    val generationVi: com.github.juanncode.data.datasources.remote.responses.GenerationVi,
    @SerializedName("generation-vii")
    val generationVii: com.github.juanncode.data.datasources.remote.responses.GenerationVii,
    @SerializedName("generation-viii")
    val generationViii: com.github.juanncode.data.datasources.remote.responses.GenerationViii
)