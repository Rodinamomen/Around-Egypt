package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class TicketPriceDto(
    @SerializedName("price")
    val ticketPrice: Int? = null,
    @SerializedName("type")
    val ticketType: String? = null
)