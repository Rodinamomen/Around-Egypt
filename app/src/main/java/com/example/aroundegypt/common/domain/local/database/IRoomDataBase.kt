package com.example.aroundegypt.common.domain.local.database

import androidx.sqlite.db.SimpleSQLiteQuery

interface IRoomDataBase {
    suspend fun <Entity> insert(entity: Entity, dao: IBaseDao<Entity>)
    suspend fun <Entity> update(entity: Entity, dao: IBaseDao<Entity>)
    suspend fun <Entity> delete(entity: Entity, dao: IBaseDao<Entity>)
    suspend fun <Entity> getAll(dao: IBaseDao<Entity>, query: String): List<Entity>
    suspend fun <Entity> getById(id: Int?, dao: IBaseDao<Entity>, query: SimpleSQLiteQuery): Entity

}