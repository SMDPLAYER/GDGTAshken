package uz.smd.gdgtashkent.app

import android.app.Application
import android.content.Context



class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: Context
    }
}