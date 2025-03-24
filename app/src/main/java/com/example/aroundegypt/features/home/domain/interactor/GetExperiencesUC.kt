package com.example.aroundegypt.features.home.domain.interactor

import com.example.aroundegypt.common.data.models.Resource
import com.example.aroundegypt.common.data.models.exception.AroundEgyptException
import com.example.aroundegypt.common.domain.remote.model.Experiences
import com.example.aroundegypt.features.home.domain.repo.IHomeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion

internal class GetExperiencesUC(private val homeRepo: IHomeRepo) {
    operator fun invoke(): Flow<Resource<Experiences>> = flow {
        emit(Resource.Loading(true))
        val remoteResponse = homeRepo.getExperiences()
        emit(Resource.Success(remoteResponse))
    }.catch { throwable ->
        val failureResource = if (throwable is AroundEgyptException) throwable else
            AroundEgyptException.UnKnownException.UnKnown(message = throwable.message.toString())
        emit(Resource.Failure(failureResource))
    }.onCompletion {
        emit(Resource.Loading(false))
    }.flowOn(Dispatchers.IO)
}