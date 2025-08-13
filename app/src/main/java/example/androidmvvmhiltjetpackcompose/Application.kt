package example.androidmvvmhiltjetpackcompose

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG,"onCreate Success()")
    }

    companion object{
        const val TAG = "Application"
    }
}