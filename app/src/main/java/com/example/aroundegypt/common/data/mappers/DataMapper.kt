package com.example.aroundegypt.common.data.mappers

import com.example.aroundegypt.common.data.models.Dto.DataDto
import com.example.aroundegypt.common.domain.remote.model.City
import com.example.aroundegypt.common.domain.remote.model.Data

internal object DataMapper {
    fun dtoToDomain(dataDto: DataDto): Data {
        return Data(
            address = dataDto.address.orEmpty(),
            city = dataDto.city?.let { CityMapper.dtoToDomain(it) } ?: City(
                cityId = 1,
                cityName = ""
            ),
            coverPhoto = dataDto.coverPhoto.orEmpty(),
            description = dataDto.description.orEmpty(),
            detailedDescription = dataDto.detailedDescription.orEmpty(),
            dataId = dataDto.dataId.orEmpty(),
            isLiked = dataDto.isLiked ?: false,
            likesNumber = dataDto.likesNumber ?: 0,
            recommended = dataDto.recommended ?: 0,
            title = dataDto.title.orEmpty(),
            tour360ViewLink = dataDto.tour360ViewLink.orEmpty(),
            viewsNumber = dataDto.viewsNumber ?: 0
        )
    }
}