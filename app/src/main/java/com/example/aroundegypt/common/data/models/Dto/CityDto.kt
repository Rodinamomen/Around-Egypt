package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class CityDto(
    @SerializedName("disable")
    val disable: Boolean? = null,
    @SerializedName("id")
    val cityId: Int? = null,
    @SerializedName("name")
    val cityName: String? = null,
    @SerializedName("top_pick")
    val topPick: Int? = null
)