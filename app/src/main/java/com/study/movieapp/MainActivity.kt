package com.study.movieapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.study.movieapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpNavigation()
    }

    override fun onSupportNavigateUp() = findNavController(R.id.fragment_container).navigateUp()

    private fun setUpNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController: NavController = navHostFragment.navController
//        val appBarConfiguration = AppBarConfiguration(
//            topLevelDestinationIds = setOf( // todo
//                R.id.popular_graph, R.id.favorite_graph
//            ), fallbackOnNavigateUpListener = ::onSupportNavigateUp
//        )
        with(binding) {
            bottomNav.setupWithNavController(navController)
            setSupportActionBar(toolbar)
        }
        setupActionBarWithNavController(
            navController = navController,
//            configuration = appBarConfiguration
        )
    }
}
