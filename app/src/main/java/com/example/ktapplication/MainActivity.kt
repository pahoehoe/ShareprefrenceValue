package com.example.ktapplication

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kaptowka.preference.Preferences
import com.kaptowka.preference.PreferencesValue
import com.kaptowka.preference.preferenceGet
import com.kaptowka.preference.preferenceSave


class MainActivity : AppCompatActivity() {

    private var isUp: Boolean by PreferencesValue("isUp", false)
    private var age: Int by PreferencesValue("age", 2222)
    private var number: Long by PreferencesValue("number", 333L)
    private var price: Float by PreferencesValue("price", 444F)
    private var name: String by PreferencesValue("name", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        isUp = true
//        age = 230001
//        number = 330001L
//        price = 44001F
//        name = "tttt1"


//        println(isUp as Boolean)
//        println(age)
//        println(number)
//        println(price)
//        println(name)

//        testBoolean("isUp",false)
//        testInt("age", -1)
//        testLong("number",-1L)
//        testFloat("price", -1F)
//        testString("name", "noname")

        true.preferenceSave("isOK")
        999.preferenceSave("valueInt")
        90L.preferenceSave("valueLong")
        1010F.preferenceSave("valueFloat")
        "testString".preferenceSave("valueString")

        println("isOk".preferenceGet(false))
        println("valueInt".preferenceGet(-1))
        println("valueLong".preferenceGet(-1L))
        println("valueFloat".preferenceGet(-1F))
        println("valueString".preferenceGet("valueString"))

        println("-----------------------------")

        Preferences["isOK"] = true
        Preferences["valueInt"] = -2
        Preferences["valueLong"] = -2L
        Preferences["valueFloat"] = -2F
        Preferences["valueString"] = "no Str"

        println(Preferences["isOK",false])
        println(Preferences["valueInt",-1])
        println(Preferences["valueLong",-1L])
        println(Preferences["valueFloat",-1F])
        println(Preferences["valueString",""])

    }

    private fun testBoolean(key: String, defalut: Boolean) {
        val value: Boolean =
            getSharedPreferences("Preferences2", Context.MODE_PRIVATE).getBoolean(key, defalut)
        println("test:$value")
    }

    private fun testInt(key: String, defalut: Int) {
        val value: Int =
            getSharedPreferences("Preferences2", Context.MODE_PRIVATE).getInt(key, defalut)
        println("test:$value")
    }

    private fun testLong(key: String, defalut: Long) {
        val value: Long =
            getSharedPreferences("Preferences2", Context.MODE_PRIVATE).getLong(key, defalut)
        println("test:$value")
    }

    private fun testFloat(key: String, defalut: Float) {
        val value: Float =
            getSharedPreferences("Preferences2", Context.MODE_PRIVATE).getFloat(key, defalut)
        println("test:$value")
    }

    private fun testString(key: String, defalut: String) {
        val value: String = getSharedPreferences("Preferences2", Context.MODE_PRIVATE).getString(key, defalut)!!
        println("test:$value")
    }

    private fun share() {
        println("run!!")

        Preferences["booleanValue"] = true
        Preferences["intValue"] = 100
        Preferences["floatValue"] = 300F
        Preferences["longValue"] = 200L
        Preferences["StringValue"] = "400Str"

        println(Preferences["booleanValue", false])
        println(Preferences["intValue", -1])
        println(Preferences["floatValue", -1F])
        println(Preferences["longValue", -1L])
        println(Preferences["StringValue", "not found"])
    }
}

