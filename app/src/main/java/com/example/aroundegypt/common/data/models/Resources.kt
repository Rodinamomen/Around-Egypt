package com.example.aroundegypt.common.data.models

import com.example.aroundegypt.common.data.models.exception.AroundEgyptException


sealed class Resource<out Model> {
    data class Success<out Model>(val model: Model) : Resource<Model>()
    data class Failure(val exception: AroundEgyptException) : Resource<Nothing>()
    data class Loading(val isLoading: Boolean = false) : Resource<Nothing>()
}
