package com.example.microsoftdocsapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.microsoftdocsapp.databinding.ActivityMainBinding
import com.example.microsoftdocsapp.databinding.FragmentWebViewerBinding
import com.example.microsoftdocsapp.databinding.FragmentRecyclerViewBinding
import java.net.URL


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var recyclerViewFragment: FragmentRecyclerViewBinding
    private lateinit var webViewerBinding: FragmentWebViewerBinding

    private var docModels : ArrayList<DocsModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(applicationContext))
        setContentView(activityMainBinding.mainFragment)


        setUpDocsModel(getProductNames(), getURLs())
    }

    fun changeFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_fragment, fragment)
        fragmentTransaction.commit()
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

        recyclerViewFragment.productsRV.layoutManager = LinearLayoutManager(this)
        recyclerViewFragment.productsRV.adapter = DRecyclerViewAdapter(this@MainActivity, docModels)
        recyclerViewFragment.productsRV.setHasFixedSize(true)
    }

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
