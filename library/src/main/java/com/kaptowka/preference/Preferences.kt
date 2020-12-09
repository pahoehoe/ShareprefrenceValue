package com.kaptowka.preference

import android.content.Context
import android.content.SharedPreferences
import java.lang.RuntimeException

object Preferences {

    private lateinit var sharedPreferences: SharedPreferences

    val PREFERENCES_NAME: String = Preferences.javaClass.canonicalName;

    fun init(context: Context) {
        sharedPreferences =
            context.getSharedPreferences(Preferences.javaClass.canonicalName, Context.MODE_PRIVATE)
    }

    operator fun set(key: String, value: Any) {
        val edit = sharedPreferences.edit()
        when (value) {
            is Int -> edit.putInt(key, value)
            is Long -> edit.putLong(key, value)
            is Float -> edit.putFloat(key, value)
            is String -> edit.putString(key, value)
            is Boolean -> edit.putBoolean(key, value)
            else -> throw RuntimeException("[value:$value] is not support! Support type:[Boolean,Int,Long,Float,String]")
        }

        edit.commit()
    }

    operator fun <Value> get(key: String, default: Value): Value {
        return with(sharedPreferences) {
            when (default) {
                is Int -> getInt(key, default)
                is Long -> getLong(key, default)
                is Float -> getFloat(key, default)
                is String -> getString(key, default)
                is Boolean -> getBoolean(key, default)
                else -> throw RuntimeException("[defaultValue:$default] is not support! Support type:[Boolean,Int,Long,Float,String]")
            }
        } as Value
    }

}


fun <Value> Value.preferenceSave(key: String) {
    Preferences[key] = this!!
}

fun <Value> String.preferenceGet(default: Value):Value{
    return Preferences[this,default]
}