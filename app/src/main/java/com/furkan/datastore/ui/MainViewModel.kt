package com.furkan.datastore.ui

import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.furkan.datastore.repository.DataStoreRepository
import com.furkan.datastore.utils.PreferenceHelper.APP_NAME
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val dataStore: DataStoreRepository
) : ViewModel() {

    fun saveData(appName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            dataStore.saveString(APP_NAME, appName)
        }
    }

    suspend fun readString(key: Preferences.Key<String>): Flow<String> =
        withContext(Dispatchers.IO) {
            return@withContext dataStore.readString(key)
        }

}