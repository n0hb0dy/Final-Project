package com.example.microsoftdocsapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.microsoftdocsapp.databinding.ActivityMainBinding
import com.example.microsoftdocsapp.databinding.FragmentWebViewerBinding
import com.example.microsoftdocsapp.databinding.FragmentRecyclerViewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import java.net.URL


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
//    private lateinit var recyclerViewFragment: FragmentRecyclerViewBinding
//    private lateinit var webViewerBinding: FragmentWebViewerBinding

    private var docModels : ArrayList<DocsModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(activityMainBinding.root)

        val navigationView: BottomNavigationView = activityMainBinding.navView
        val navigationController = findNavController(androidx.navigation.fragment.R.id.nav_host_fragment_container)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard
            )
        )

        setupActionBarWithNavController(navigationController, appBarConfiguration)
        navigationView.setupWithNavController(navigationController)

//        setUpDocsModel(getProductNames(), getURLs())
//
//        if (savedInstanceState == null) {
//            supportFragmentManager.commit {
//                setReorderingAllowed(true)
//                add<RecyclerViewFragment>(R.id.recyclerFrame)
//            }
//        }
    }


    private fun getProductNames() : Array<String>{
        return resources.getStringArray(R.array.products)
    }
    private fun getURLs() : Array<String>{
        return resources.getStringArray(R.array.urls)
    }
    private fun setUpDocsModel(productNames: Array<String>, urls: Array<String>) {
        for (element in productNames.zip(urls))
            docModels.add(DocsModel(element.first, URL(element.second)))

//        recyclerViewFragment.productsRV.layoutManager = LinearLayoutManager(this)
//        recyclerViewFragment.productsRV.adapter = DRecyclerViewAdapter(this@MainActivity, docModels)
//        recyclerViewFragment.productsRV.setHasFixedSize(true)
    }

//    fun changeFragment(fragment: Fragment){
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.main_fragment, fragment)
//        fragmentTransaction.commit()
//    }
//    private fun setUpWebView(): Unit {
//        webViewerBinding.webView.webViewClient = WebViewClient()
//    }
//    private fun goToWebsite(url: String ="https://learn.microsoft.com/en-us/power-automate/getting-started"): Unit {
//        activityMainBinding.webView.apply {
//            loadUrl(url)
//            settings.safeBrowsingEnabled = true
//        }
//    }
}
