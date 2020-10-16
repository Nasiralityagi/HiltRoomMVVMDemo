package com.android.offlineexample.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.offlineexample.R
import com.android.offlineexample.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        //Set your theme before super.onCreate() to replace your previous theme of Manifest
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navView.post { // wait for NavHostFragment to inflate
            val navController = findNavController(R.id.nav_host_fragment)
            binding.navView.setupWithNavController(navController)
            navController.addOnDestinationChangedListener(this)
        }
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when (destination.id) {
            R.id.navigation_home -> {

            }
            R.id.navigation_discovery -> {

            }
            R.id.navigation_add -> {

            }
            R.id.navigation_inbox -> {

            }
            R.id.navigation_me -> {

            }
        }
    }

}