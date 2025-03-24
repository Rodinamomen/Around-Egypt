package com.example.aroundegypt.features.home.data.mappers

import com.example.aroundegypt.common.data.models.Dto.ExperiencesDto
import com.example.aroundegypt.features.home.domain.models.Experiences

internal object ExperiencesMapper {
    fun dtoToDomain(experiencesDto: ExperiencesDto): Experiences {
        return Experiences(data = experiencesDto.data.orEmpty().filterNotNull().map {
            DataMapper.dtoToDomain(it)
        })
    }
}