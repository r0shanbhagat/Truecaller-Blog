package com.truecaller.truecallerblog.ui.view

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.truecaller.truecallerblog.R
import com.truecaller.truecallerblog.core.BaseActivity
import com.truecaller.truecallerblog.core.BaseViewModel
import com.truecaller.truecallerblog.databinding.ActivityTruecallerBlogBinding
import dagger.hilt.android.AndroidEntryPoint


/**
/**
 * @Details TruecallerBlogActivity : Main activity where user0interface will
 * be displayed and user can interact with app on launch
 * @Author Roshan Bhagat
*/ *
 * @constructor Create Truecaller blog activity
 */
@AndroidEntryPoint
class TruecallerBlogActivity :
    BaseActivity<ActivityTruecallerBlogBinding, BaseViewModel>() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun createViewModel(): BaseViewModel? = null

    override val layoutResId: Int = R.layout.activity_truecaller_blog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
         * Adding Navigation Callback for Analytics
         */
        addNavigateCallback()
    }

    /**
     * Adding Navigation Callback
     */
    private fun addNavigateCallback() {
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }


    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}