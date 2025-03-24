package com.example.aroundegypt.common.data.mappers

import com.example.aroundegypt.common.data.models.Dto.CityDto
import com.example.aroundegypt.common.domain.remote.model.City

internal object CityMapper {
    fun dtoToDomain(city: CityDto): City {
        return City(cityId = city.cityId ?: 0, cityName = city.cityName.orEmpty())
    }
}