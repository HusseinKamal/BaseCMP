package com.hussein.basecmp.databasename.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import android.content.Context

actual fun createDataStore(context: Any?): DataStore<Preferences> {
    require(
        value = context is Context,
        lazyMessage = { "Context object is required." }
    )
    return AppSettings.getDataStore(
        producePath = {
            context.filesDir
                .resolve(dataStoreFileName)
                .absolutePath
        })
}