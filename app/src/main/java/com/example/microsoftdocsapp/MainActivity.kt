package com.example.microsoftdocsapp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.microsoftdocsapp.databinding.ActivityMainBinding
import com.example.microsoftdocsapp.databinding.FragmentProductsBinding
import com.example.microsoftdocsapp.ui.products.ProductsAdapter
import com.example.microsoftdocsapp.ui.products.ProductsViewModel
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var fragmentProductsBinding: FragmentProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        fragmentProductsBinding = FragmentProductsBinding.inflate(layoutInflater)



        val navView: BottomNavigationView = activityMainBinding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_products, R.id.navigation_documentation
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}