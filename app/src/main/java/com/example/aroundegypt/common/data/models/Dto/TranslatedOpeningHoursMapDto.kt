package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class TranslatedOpeningHoursMapDto(
    @SerializedName("translated_opening_hours")
    val translatedOpeningHours: Map<String, TranslatedOpeningHourDto>? = null
)