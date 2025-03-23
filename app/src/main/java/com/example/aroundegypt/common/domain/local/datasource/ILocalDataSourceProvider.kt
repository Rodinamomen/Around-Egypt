package com.example.aroundegypt.common.domain.local.datasource

interface ILocalDataSourceProvider {
    suspend fun <Value> create(key: ILocalDataSourceEnum, value: Value, type: Class<*>)
    suspend fun <Value> read(key: ILocalDataSourceEnum, defaultValue: Value, type: Class<*>): Value
    suspend fun <Value> update(key: ILocalDataSourceEnum, value: Value, type: Class<*>)
    suspend fun <Value> delete(key: ILocalDataSourceEnum, value: Value, type: Class<*>)
}