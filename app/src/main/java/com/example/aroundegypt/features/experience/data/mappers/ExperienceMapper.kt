package com.example.aroundegypt.features.experience.data.mappers

import com.example.aroundegypt.common.data.mappers.CityMapper
import com.example.aroundegypt.common.domain.remote.model.City
import com.example.aroundegypt.common.domain.remote.model.Data
import com.example.aroundegypt.features.experience.data.model.dto.ExperienceDto

internal object ExperienceMapper {
    fun dtoToDomain(experienceDto: ExperienceDto): Data {
        return Data(
            address = experienceDto.data?.address.orEmpty(),
            city = experienceDto.data?.city?.let { CityMapper.dtoToDomain(it) } ?: City(
                cityId = 1,
                cityName = ""
            ),
            coverPhoto = experienceDto.data?.coverPhoto.orEmpty(),
            description = experienceDto.data?.description.orEmpty(),
            detailedDescription = experienceDto.data?.detailedDescription.orEmpty(),
            dataId = experienceDto.data?.dataId.orEmpty(),
            isLiked = experienceDto.data?.isLiked ?: false,
            likesNumber = experienceDto.data?.likesNumber ?: 0,
            recommended = experienceDto.data?.recommended ?: 0,
            title = experienceDto.data?.title.orEmpty(),
            tour360ViewLink = experienceDto.data?.tour360ViewLink.orEmpty(),
            viewsNumber = experienceDto.data?.viewsNumber ?: 0
        )
    }
}