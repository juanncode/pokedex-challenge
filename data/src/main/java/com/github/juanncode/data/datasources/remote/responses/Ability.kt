package com.github.juanncode.data.datasources.remote.responses


import com.google.gson.annotations.SerializedName

data class Ability(
    val ability: com.github.juanncode.data.datasources.remote.responses.AbilityX,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    val slot: Int
)