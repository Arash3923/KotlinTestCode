package com.kotlintestcode

import android.os.Bundle
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.kotlintestcode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        activityBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(activityBinding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupNavigationComponent()
    }

    private fun setupNavigationComponent() {
        val navHostFragment  = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController=navHostFragment.navController

        val appBarConfiguration= AppBarConfiguration(setOf(R.id.homeFragment,R.id.listFragment,R.id.settingFragment),activityBinding.drawerLayout)
        activityBinding.navView.setupWithNavController(navController)

        val popupMenu=PopupMenu(this,null)
        popupMenu.inflate(R.menu.menu_bottom)
        val menu=popupMenu.menu

        activityBinding.bottomBar.setupWithNavController(menu,navController)

    }
}