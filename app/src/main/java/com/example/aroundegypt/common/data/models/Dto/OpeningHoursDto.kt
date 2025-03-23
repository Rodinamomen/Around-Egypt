package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class OpeningHoursDto(
    @SerializedName("opening_hours")
    val openingHours: Map<String, List<String>>? = null
)