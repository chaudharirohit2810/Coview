package com.rohit2810.coview

import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.rohit2810.coview.News.NewsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
//    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        setTitle("News")
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)

//        newsViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
//
//        newsViewModel.allNews.observe(this, Observer { res ->
//            res?.let {
//                Log.d("MainActivity", it.toString())
//            }
//        })


        NavigationUI.setupWithNavController(navView, navController)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onNavigateUp(): Boolean {
        navController.navigateUp()
        return super.onNavigateUp()
    }

}
