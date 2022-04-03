package com.truecaller.truecallerblog

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

/**
 * @Details TruecallerBlogApp is the Application class to manage the entire App scope
 * @Author Roshan Bhagat
 */
@HiltAndroidApp
class TruecallerBlogApp : MultiDexApplication() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}