package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class TranslatedOpeningHourDto(
    @SerializedName("day")
    val day: String? = null,
    @SerializedName("time")
    val time: String? = null
)
