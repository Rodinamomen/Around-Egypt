package com.example.aroundegypt.features.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aroundegypt.common.data.models.Resource
import com.example.aroundegypt.common.domain.remote.model.Experiences
import com.example.aroundegypt.features.home.domain.interactor.GetExperiencesUC
import com.example.aroundegypt.features.home.domain.interactor.GetRecommendedExperiencesUC
import com.example.aroundegypt.features.home.domain.interactor.LikeExperienceUC
import com.example.aroundegypt.features.home.domain.interactor.SearchUC
import com.example.aroundegypt.features.home.domain.models.LikesResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getExperiencesUC: GetExperiencesUC,
    private val getRecommendedExperiencesUC: GetRecommendedExperiencesUC,
    private val likeExperienceUC: LikeExperienceUC,
    private val searchUC: SearchUC
) : ViewModel() {
    private val _experienceState = MutableStateFlow<Resource<Experiences>>(Resource.Loading())
    val experienceState: StateFlow<Resource<Experiences>> = _experienceState
    private val _recommendExperienceState =
        MutableStateFlow<Resource<Experiences>>(Resource.Loading())
    val recommendExperienceState: StateFlow<Resource<Experiences>> = _recommendExperienceState
    private val _likeExperienceState = MutableStateFlow<Resource<LikesResponse>>(Resource.Loading())
    val likeExperienceState: StateFlow<Resource<LikesResponse>> = _likeExperienceState
    private val _searchState = MutableStateFlow<Resource<Experiences>>(Resource.Loading())
    val searchState: StateFlow<Resource<Experiences>> = _searchState
    fun getExperiences() {
        viewModelScope.launch {
            getExperiencesUC.invoke().collect { resource ->
                when (resource) {
                    is Resource.Success -> _experienceState.emit(Resource.Success(resource.model))
                    is Resource.Failure -> _experienceState.emit(Resource.Failure(resource.exception))
                    is Resource.Loading -> _experienceState.emit(Resource.Loading(resource.isLoading))
                }
            }
        }
    }

    fun getRecommendedExperiences() {
        viewModelScope.launch {
            getRecommendedExperiencesUC.invoke().collect { resource ->
                when (resource) {
                    is Resource.Success -> _recommendExperienceState.emit(Resource.Success(resource.model))
                    is Resource.Failure -> _recommendExperienceState.emit(Resource.Failure(resource.exception))
                    is Resource.Loading -> _recommendExperienceState.emit(Resource.Loading(resource.isLoading))
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

    fun search(title: String) {
        viewModelScope.launch {
            searchUC.invoke(title).collect { resource ->
                when (resource) {
                    is Resource.Success -> _searchState.emit(Resource.Success(resource.model))
                    is Resource.Failure -> _searchState.emit(Resource.Failure(resource.exception))
                    is Resource.Loading -> _searchState.emit(Resource.Loading(resource.isLoading))
                }
            }
        }
    }
}