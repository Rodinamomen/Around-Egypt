package com.example.aroundegypt.features.home.data.mappers

import com.example.aroundegypt.common.data.models.Dto.CityDto
import com.example.aroundegypt.features.home.domain.models.City

internal object CityMapper {
    fun dtoToDomain(city: CityDto): City {
        return City(cityId = city.cityId ?: 0, cityName = city.cityName.orEmpty())
    }
}