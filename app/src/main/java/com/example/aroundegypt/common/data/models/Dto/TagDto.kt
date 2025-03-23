package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class TagDto(
    @SerializedName("disable")
    val tagDisable: Boolean? = null,
    @SerializedName("id")
    val tagId: Int? = null,
    @SerializedName("name")
    val tagName: String? = null,
    @SerializedName("top_pick")
    val tagTopPick: Int? = null
)