package com.example.aroundegypt.features.home.domain.repo

import com.example.aroundegypt.common.domain.remote.model.Experiences
import com.example.aroundegypt.features.home.domain.models.LikesResponse

interface IHomeRepo {
    suspend fun getExperiences(): Experiences
    suspend fun getRecommendedExperiences(): Experiences
    suspend fun likeExperience(id: String): LikesResponse
    suspend fun search(title: String): Experiences
}