package com.furkan.datastore.di

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import com.furkan.datastore.repository.DataStoreRepository
import com.furkan.datastore.repository.DataStoreRepositoryImpl
import com.furkan.datastore.utils.USER_PREFERENCES_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val Context.dataStore by preferencesDataStore(
    name = USER_PREFERENCES_NAME,
)

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Singleton
    @Provides
    fun providePreferenceStorage(@ApplicationContext context: Context): DataStoreRepository =
        DataStoreRepositoryImpl(context.dataStore)
}