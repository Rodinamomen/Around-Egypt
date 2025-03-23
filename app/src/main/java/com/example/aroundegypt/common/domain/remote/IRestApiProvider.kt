package com.example.aroundegypt.common.domain.remote

import java.lang.reflect.Type

interface IRestApiProvider {
    suspend fun <ResponseBody, RequestBody> post(
        endpoint: String,
        params: Map<String, Any>? = null,
        headers: Map<String, Any>? = null,
        requestBody: RequestBody? = null,
        type: Type
    ): ResponseBody

    suspend fun <ResponseBody> get(
        endpoint: String,
        params: Map<String, Any>? = null,
        headers: Map<String, Any>? = null,
        type: Type
    ): ResponseBody

    suspend fun <ResponseBody, RequestBody> put(
        endpoint: String,
        params: Map<String, Any>,
        headers: Map<String, Any>? = null,
        requestBody: RequestBody? = null,
        type: Type
    ): ResponseBody

    suspend fun <ResponseBody, RequestBody> delete(
        endpoint: String,
        params: Map<String, Any>? = null,
        headers: Map<String, Any>? = null,
        requestBody: RequestBody? = null,
        type: Type
    ): ResponseBody
}