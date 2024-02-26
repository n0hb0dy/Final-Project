package com.example.microsoftdocsapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.microsoftdocsapp.databinding.ActivityMainBinding
import com.example.microsoftdocsapp.databinding.FragmentWebViewerBinding
import com.example.microsoftdocsapp.databinding.FragmentRecyclerViewBinding
import java.net.URL


class MainActivity : AppCompatActivity(R.layout.fragment_recycler_view) {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var recyclerViewFragment: FragmentRecyclerViewBinding
    private lateinit var webViewerBinding: FragmentWebViewerBinding

    private var docModels : ArrayList<DocsModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(applicationContext))
        setContentView(activityMainBinding.root)

        setUpDocsModel(getProductNames(), getURLs())

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<RecyclerViewFragment>(R.id.recyclerFrame)
            }
        }
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
