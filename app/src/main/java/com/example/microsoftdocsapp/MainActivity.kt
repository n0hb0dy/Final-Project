package com.example.microsoftdocsapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.microsoftdocsapp.databinding.ActivityMainBinding
import com.example.microsoftdocsapp.databinding.WebviewActivityBinding
import java.net.URL


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var webViewerbinding: WebviewActivityBinding

    private var docModels : ArrayList<DocsModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(applicationContext))
        setContentView(activityMainBinding.MainConstraint)

        setUpDocsModel(getProductNames(), getURLs())
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


        activityMainBinding.productsRV.layoutManager = LinearLayoutManager(this)
        activityMainBinding.productsRV.adapter = DRecyclerViewAdapter(this@MainActivity, docModels)
        activityMainBinding.productsRV.setHasFixedSize(true)
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
