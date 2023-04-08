package com.example.mysecondapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
interface MovieSelectionListener {
    fun onMovieSelected(movie: Movie)
}

class MainActivity : AppCompatActivity(), MovieSelectionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onMovieSelected(movie: Movie) {
        val bundle = Bundle()
        bundle.putParcelable("selected_movie", movie)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.action_moviesListFragment_to_movieDetailsFragment, bundle)
    }
}
