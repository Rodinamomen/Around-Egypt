package com.example.aroundegypt.common.data.models.Dto

import com.google.gson.annotations.SerializedName

internal data class DataDto(
    @SerializedName("address")
    val address: String? = null,
    @SerializedName("audio_url")
    val audioUrl: String? = null,
    @SerializedName("city")
    val city: CityDto? = null,
    @SerializedName("cover_photo")
    val coverPhoto: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("detailed_description")
    val detailedDescription: String? = null,
    @SerializedName("era")
    val eraDto: EraDto? = null,
    @SerializedName("experience_tips")
    val experienceTips: List<Any>? = null,
    @SerializedName("famous_figure")
    val famousFigure: String? = null,
    @SerializedName("founded")
    val founded: String? = null,
    @SerializedName("gmap_location")
    val gMapLocationDto: GMapLocationDto? = null,
    @SerializedName("has_audio")
    val hasAudio: Boolean? = null,
    @SerializedName("has_video")
    val hasVideo: Int? = null,
    @SerializedName("id")
    val dataId: String? = null,
    @SerializedName("is_liked")
    val isLiked: Boolean? = null,
    @SerializedName("likes_no")
    val likesNumber: Int? = null,
    @SerializedName("opening_hours")
    val openingHours: OpeningHoursDto? = null,
    @SerializedName("period")
    val period: PeriodDto? = null,
    @SerializedName("rating")
    val rating: Int? = null,
    @SerializedName("recommended")
    val recommended: Int? = null,
    @SerializedName("reviews")
    val reviews: List<ReviewDto>? = null,
    @SerializedName("reviews_no")
    val reviewsNumber: Int? = null,
    @SerializedName("starting_price")
    val startingPrice: Int? = null,
    @SerializedName("tags")
    val tagsList: List<TagDto>? = null,
    @SerializedName("ticket_prices")
    val ticketPrices: List<TicketPriceDto>? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("tour_html")
    val tour360ViewLink: String? = null,
    @SerializedName("translated_opening_hours")
    val translatedOpeningHoursMapDto: TranslatedOpeningHoursMapDto? = null,
    @SerializedName("views_no")
    val viewsNumber: Int? = null
)