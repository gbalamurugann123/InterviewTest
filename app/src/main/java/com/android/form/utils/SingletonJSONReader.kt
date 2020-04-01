package com.android.form.utils

import android.app.Activity
import com.android.form.model.FormModel
import com.google.gson.Gson
import java.io.IOException
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets.UTF_8
import kotlin.text.Charsets.UTF_8

class SingletonJSONReader private constructor(activity: Activity) {
    var formModel: FormModel? = null

    fun loadJSONFromAsset(context: Activity): String? {
        var json: String?
        json = try {
            val `is` = context.assets.open("pages.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    companion object {
        private var singleInstance: SingletonJSONReader? = null
        fun getInstance(activity: Activity): SingletonJSONReader? {
            if (singleInstance == null) singleInstance = SingletonJSONReader(activity)
            return singleInstance
        }
    }

    init {
        val gson = Gson()
        formModel = gson.fromJson(loadJSONFromAsset(activity), FormModel::class.java)
    }
}