package com.google.ar.core.codelab.cloudanchor.language

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import java.util.*

class LanguageManager(val context: Context) {

    val sharedPreferences: SharedPreferences = context.getSharedPreferences("Language", MODE_PRIVATE)

    @JvmOverloads
    fun updateLanguage(languageCode: String? = sharedPreferences.getString("Selected Language", Language.ENGLISH.code)) {
        languageCode?.let{
            val locale = Locale(it)
            Locale.setDefault(locale)
            val resources: Resources = context.resources
            val config: Configuration = resources.configuration
            config.setLocale(locale)
            resources.updateConfiguration(config, resources.displayMetrics)
            sharedPreferences.edit().putString("Selected Language", it).apply()
        }

    }
}