package com.furkan.datastore.utils

import androidx.datastore.preferences.core.stringPreferencesKey

const val USER_PREFERENCES_NAME = "furkan_app"

object PreferenceHelper {

    val APP_NAME = stringPreferencesKey("APP_NAME")

}