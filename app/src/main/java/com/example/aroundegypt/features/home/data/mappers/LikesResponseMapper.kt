package com.example.aroundegypt.features.home.data.mappers

import com.example.aroundegypt.common.data.models.Dto.LikesResponseDto
import com.example.aroundegypt.features.home.domain.models.LikesResponse

internal object LikesResponseMapper {
    fun dtoToDomain(likesResponseDto: LikesResponseDto):LikesResponse{
        return LikesResponse(likesResponseDto.numberOfLikes?:0)
    }
}