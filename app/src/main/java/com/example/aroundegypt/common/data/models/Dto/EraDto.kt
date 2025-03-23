package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class EraDto(
    @SerializedName("created_at")
    val eraCreatedAt: String? = null,
    @SerializedName("id")
    val eraId: String? = null,
    @SerializedName("updated_at")
    val eraUpdatedAt: String? = null,
    @SerializedName("value")
    val eraValue: String? = null
)