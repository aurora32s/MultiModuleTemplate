package com.seomseom.datastore.pref

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SampleSharedPrefHelper @Inject constructor(
    @ApplicationContext
    private val context: Context
) {
    fun sample() {
        val sharedPreferences = context.getSharedPreferences(SAMPLE_STORAGE, PREF_MODE)
    }

    companion object {
        private const val SAMPLE_STORAGE = "sample"
        private const val PREF_MODE = Context.MODE_PRIVATE
    }
}