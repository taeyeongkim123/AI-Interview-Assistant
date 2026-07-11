package com.nayeon.daechungapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.nayeon.daechungapp2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // MainActivity Data Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setNavigation()

    }

    // navigation 설정
    private fun setNavigation() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val navigator = KeepStateFragment(this, navHostFragment.childFragmentManager, R.id.nav_host_fragment)

        navController.navigatorProvider.addNavigator(navigator)

        navController.setGraph(R.navigation.nav_graph)

        // MainActivity의 main_navi와 navController 연결
        binding.mainNavi.setupWithNavController(navController)

    }
}