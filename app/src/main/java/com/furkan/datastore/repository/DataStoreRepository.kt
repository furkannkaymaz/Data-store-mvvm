package com.furkan.datastore.repository

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun readString(key: Preferences.Key<String>): Flow<String>
    suspend fun saveString(key: Preferences.Key<String>, name: String)
}