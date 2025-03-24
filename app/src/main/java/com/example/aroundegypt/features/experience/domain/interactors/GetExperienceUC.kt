package com.example.aroundegypt.features.experience.domain.interactors

import android.util.Log
import com.example.aroundegypt.common.data.models.Resource
import com.example.aroundegypt.common.data.models.exception.AroundEgyptException
import com.example.aroundegypt.common.domain.remote.model.Data
import com.example.aroundegypt.features.experience.domain.repo.IExperienceRpo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion

internal class GetExperienceUC(private val experienceRepo: IExperienceRpo) {
    operator fun invoke(id: String): Flow<Resource<Data>> = flow {
        emit(Resource.Loading(true))

        val remoteResponse = experienceRepo.getExperience(id)
        Log.d("exc", "invoke:${id} ")
        emit(Resource.Success(remoteResponse))
    }.catch { throwable ->
        val failureResource = if (throwable is AroundEgyptException) throwable else
            AroundEgyptException.UnKnownException.UnKnown(message = throwable.message.toString())
        emit(Resource.Failure(failureResource))
    }.onCompletion {
        emit(Resource.Loading(false))
    }.flowOn(Dispatchers.IO)
}