package com.example.aroundegypt.common.domain.local.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.RawQuery
import androidx.room.Update
import androidx.sqlite.db.SupportSQLiteQuery

interface IBaseDao<Entity> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: Entity)

    @Update
    suspend fun update(entity: Entity)

    @Delete
    suspend fun delete(entity: Entity)

    @RawQuery
    suspend fun getById(query: SupportSQLiteQuery): Entity

    @RawQuery
    suspend fun getAll(query: SupportSQLiteQuery): List<Entity>
}