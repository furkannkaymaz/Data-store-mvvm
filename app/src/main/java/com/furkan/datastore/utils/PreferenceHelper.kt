package com.furkan.datastore.utils

import androidx.datastore.preferences.core.*

const val USER_PREFERENCES_NAME = "furkan_app"

object PreferenceHelper {

    val APP_NAME = stringPreferencesKey("APP_NAME")
    val BOOLEAN_VALUE = booleanPreferencesKey("BOOLEAN_VALUE")
    val FLOAT_VALUE = floatPreferencesKey("FLOAT_VALUE")
    val LONG_VALUE = longPreferencesKey("LONG_VALUE")
    val INT_VALUE = intPreferencesKey("INT_VALUE")

}