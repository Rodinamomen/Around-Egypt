package com.example.aroundegypt.features.experience.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aroundegypt.common.data.models.Resource
import com.example.aroundegypt.common.domain.remote.model.Data
import com.example.aroundegypt.features.experience.domain.interactors.GetExperienceUC
import com.example.aroundegypt.features.experience.domain.interactors.LikeExperienceUC
import com.example.aroundegypt.features.home.domain.models.LikesResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ExperienceViewModel @Inject constructor(
    private val getExperienceUC: GetExperienceUC,
    private val likeExperienceUC: LikeExperienceUC
) :
    ViewModel() {
    private val _experienceState = MutableStateFlow<Resource<Data>>(Resource.Loading())
    val experienceState: StateFlow<Resource<Data>> = _experienceState
    private val _likeExperienceState = MutableStateFlow<Resource<LikesResponse>>(Resource.Loading())
    val likeExperienceState: StateFlow<Resource<LikesResponse>> = _likeExperienceState
    fun getExperiences(id: String) {
        viewModelScope.launch {
            getExperienceUC.invoke(id).collect { resource ->
                when (resource) {
                    is Resource.Success -> _experienceState.emit(Resource.Success(resource.model))
                    is Resource.Failure -> _experienceState.emit(Resource.Failure(resource.exception))
                    is Resource.Loading -> _experienceState.emit(Resource.Loading(resource.isLoading))
                }
            }
        }
    }

    fun likeExperience(id: String) {
        viewModelScope.launch {
            likeExperienceUC.invoke(id).collect { resource ->
                when (resource) {
                    is Resource.Success -> _likeExperienceState.emit(Resource.Success(resource.model))
                    is Resource.Failure -> _likeExperienceState.emit(Resource.Failure(resource.exception))
                    is Resource.Loading -> _likeExperienceState.emit(Resource.Loading(resource.isLoading))
                }
            }
        }
    }

}