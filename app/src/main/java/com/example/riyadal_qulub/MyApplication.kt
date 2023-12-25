package com.example.riyadal_qulub

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import dagger.hilt.android.HiltAndroidApp
import java.util.Locale

@HiltAndroidApp
class MyApplication : Application(){

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(updateBaseContextLocale(base))
    }

    private fun updateBaseContextLocale(context: Context): Context {
        val locale = Locale("ar") // Arabic locale
        Locale.setDefault(locale)

        val res: Resources = context.resources
        val configuration: Configuration = res.configuration
        configuration.setLocale(locale)

        return context.createConfigurationContext(configuration)
    }
}