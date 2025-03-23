package com.example.aroundegypt.common.data.repo.local.database

import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.aroundegypt.common.domain.local.database.IBaseDao
import com.example.aroundegypt.common.domain.local.database.IRoomDataBase

internal class RoomDataBase : IRoomDataBase {
    override suspend fun <Entity> insert(entity: Entity, dao: IBaseDao<Entity>) {
        dao.insert(entity)
    }


    override suspend fun <Entity> update(entity: Entity, dao: IBaseDao<Entity>) {
        dao.update(entity)
    }

    override suspend fun <Entity> delete(entity: Entity, dao: IBaseDao<Entity>) {
        dao.delete(entity)
    }

    override suspend fun <Entity> getAll(dao: IBaseDao<Entity>, query: String): List<Entity> {
        val rawQuery = SimpleSQLiteQuery(query)
        return dao.getAll(rawQuery)
    }

    override suspend fun <Entity> getById(
        id: Int?,
        dao: IBaseDao<Entity>,
        query: SimpleSQLiteQuery
    ): Entity {
        return dao.getById(query)
    }
}