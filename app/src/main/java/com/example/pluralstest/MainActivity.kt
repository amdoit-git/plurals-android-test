package com.example.pluralstest

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

//        val locale = Locale("ru")
//        Locale.setDefault(locale)
//        val config: Configuration = baseContext.resources.configuration
//        val list = LocaleList(locale)
//        config.setLocales(list)
//        createConfigurationContext(config)


        var str: String = ""

        for (i in 0..33) {
            val systemPlural = resources.getQuantityString(R.plurals.plurals_1, i, i)
            val catPlural = resources.getQuantityString(R.plurals.plurals_2, i, i)
            str += "$systemPlural : $catPlural\n"
            Log.d("WWW", "$systemPlural : $catPlural")
        }

        findViewById<TextView>(R.id.tvHeader).text = str
    }

    fun getResourcesByLocale(): Resources {
        val configuration: Configuration = Configuration(resources.configuration)
        configuration.setLocale(Locale("ru"))

        return createConfigurationContext(configuration).resources
    }
}