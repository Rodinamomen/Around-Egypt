package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class GMapLocationDto(
    @SerializedName("coordinates")
    val coordinates: List<Double>? = null,
    @SerializedName("type")
    val locationType: String? = null
)