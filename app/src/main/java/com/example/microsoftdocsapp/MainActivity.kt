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

    private var products : ArrayList<ProductsViewModel> = ArrayList()
    private var productNames = ArrayList<String>()
    private var urls = ArrayList<URL>()

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var fragmentProductsBinding: FragmentProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        fragmentProductsBinding = FragmentProductsBinding.inflate(layoutInflater)

        initializeLists(resources.getStringArray(R.array.products), resources.getStringArray(R.array.urls))

        val navView: BottomNavigationView = activityMainBinding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_products, R.id.navigation_documentation
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun initializeLists(productNames: Array<String>, urls: Array<String>){
        for (element in productNames.zip(urls))
            products.add(ProductsViewModel(element.first, element.second))


        fragmentProductsBinding.productsRV.layoutManager = LinearLayoutManager(this)
        fragmentProductsBinding.productsRV.adapter = ProductsAdapter(productNames, urls)
        fragmentProductsBinding.productsRV.setHasFixedSize(true)
    }
}