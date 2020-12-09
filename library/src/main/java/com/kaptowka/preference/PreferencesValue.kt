package com.kaptowka.preference

import android.content.Context
import java.lang.RuntimeException
import kotlin.reflect.KProperty

class PreferencesValue<T>(private val key: String, private val default: T) {

    operator fun getValue(context: Context, property: KProperty<*>): T {
        val sharedPreferences =
            context.getSharedPreferences(Preferences.PREFERENCES_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.run {
            when (default) {
                is Boolean -> getBoolean(key, default as Boolean)
                is Int -> getInt(key, default as Int)
                is Long -> getLong(key, default as Long)
                is Float -> getFloat(key, default as Float)
                is String -> getString(key, default as String)
                else -> throw RuntimeException("[defaultValue:$default] is not support!Support type:[Boolean,Int,Long,Float,String]")
            }

        } as T
    }

    operator fun setValue(context: Context, property: KProperty<*>, value: T) {
        val sharedPreferences = context.getSharedPreferences("Preferences2", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            when (value) {
                is Boolean -> putBoolean(key, value as Boolean)
                is Int -> putInt(key, value as Int)
                is Long -> putLong(key, value as Long)
                is Float -> putFloat(key, value as Float)
                is String -> putString(key, value as String)
                else -> throw RuntimeException("[value:$value] is not support!Support type:[Boolean,Int,Long,Float,String]")
            }

            commit()
        }
    }

}
