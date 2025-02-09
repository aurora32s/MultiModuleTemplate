package com.seomseom.datastore.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

private const val SAMPLE_DATASTORE_NAME = "sample"
private val Context.sampleDatastore: DataStore<Preferences> by preferencesDataStore(name = SAMPLE_DATASTORE_NAME)

@Singleton
class SampleDataStore @Inject constructor(
    @ApplicationContext
    private val context: Context
) {}