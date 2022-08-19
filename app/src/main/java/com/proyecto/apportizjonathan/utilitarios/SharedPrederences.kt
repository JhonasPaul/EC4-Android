package com.proyecto.apportizjonathan.utilitarios

import android.content.Context
import android.content.SharedPreferences

class SharedPrederences {
    private val APP_SETTINGS_FILE = "APP_SETTINGS"

    private fun getSharedPreferences(): SharedPreferences {
        return MiApp.applicationContext.getSharedPreferences(
            APP_SETTINGS_FILE, Context.MODE_PRIVATE
        )
    }

    fun getSomeBooleanValue(nombre: String):Boolean{
        return getSharedPreferences().getBoolean(nombre, false)
    }

    fun getSomeStringeanValue(nombre: String):String{
        return getSharedPreferences().getString(nombre, "").toString()
    }
}