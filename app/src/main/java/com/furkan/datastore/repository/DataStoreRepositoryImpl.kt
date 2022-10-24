package com.furkan.datastore.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

class DataStoreRepositoryImpl
@Inject constructor(private var dataStore: DataStore<Preferences>) : DataStoreRepository {

    override suspend fun readString(key: Preferences.Key<String>): Flow<String> {
        return dataStore.data
            .catch { ex ->
                if (ex is IOException) {
                    emit(emptyPreferences())
                } else throw ex
            }
            .map { preferences ->
                val showCompleted = preferences[key] ?: "null"
                showCompleted
            }
    }

    override suspend fun saveString(key: Preferences.Key<String>, name: String) {
        dataStore.edit { preferences ->
            preferences[key] = name
        }
    }

}