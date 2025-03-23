package com.example.aroundegypt.common.data.repo.local.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.example.aroundegypt.common.data.models.exception.AroundEgyptException
import com.example.aroundegypt.common.domain.local.datasource.ILocalDataSourceEnum
import com.example.aroundegypt.common.domain.local.datasource.ILocalDataSourceProvider
import kotlinx.coroutines.flow.first

internal class LocalDataSourceProvider(private val dataStore: DataStore<Preferences>) :
    ILocalDataSourceProvider {
    private fun <Value> preferencesKey(
        key: ILocalDataSourceEnum,
        type: Class<*>
    ): Preferences.Key<Value> {
        return when (type) {
            Boolean::class.java -> booleanPreferencesKey(key.keyValue)
            Float::class.java -> floatPreferencesKey(key.keyValue)
            Int::class.java -> intPreferencesKey(key.keyValue)
            Long::class.java -> longPreferencesKey(key.keyValue)
            String::class.java -> stringPreferencesKey(key.keyValue)
            Set::class.java -> stringSetPreferencesKey(key.keyValue)
            else -> throw AroundEgyptException.UnKnownException.UnKnown("unsurenesss")
        } as Preferences.Key<Value>

    }

    override suspend fun <Value> create(key: ILocalDataSourceEnum, value: Value, type: Class<*>) {
        val preferencesKey = preferencesKey<Value>(key, type)
        dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun <Value> read(
        key: ILocalDataSourceEnum,
        defaultValue: Value,
        type: Class<*>
    ): Value {
        val preferencesKey = preferencesKey<Value>(key, type)
        val preferences = dataStore.data.first()
        return preferences[preferencesKey] ?: defaultValue
    }

    override suspend fun <Value> update(key: ILocalDataSourceEnum, value: Value, type: Class<*>) {
        val preferencesKey = preferencesKey<Value>(key, type)
        dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun <Value> delete(key: ILocalDataSourceEnum, value: Value, type: Class<*>) {
        val preferencesKey = preferencesKey<Value>(key, type)
        dataStore.edit { preferences ->
            preferences.remove(preferencesKey)
        }
    }
}