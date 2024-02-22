package com.example.microsoftdocsapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.microsoftdocsapp.databinding.ActivityMainBinding
import com.example.microsoftdocsapp.databinding.WebviewActivityBinding


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var webViewerbinding: WebviewActivityBinding

    private var docsModel : ArrayList<DocsModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(applicationContext))
        setContentView(activityMainBinding.MainConstraint)

        setUpDocsModel(getProductNames())
    }

    private fun getProductNames() : Array<String>{
        return resources.getStringArray(R.array.products)
    }
    private fun setUpDocsModel(productNames: Array<String>) {
        for (element in productNames)
            docsModel.add(DocsModel(element))


        activityMainBinding.productsRV.layoutManager = LinearLayoutManager(this)
        activityMainBinding.productsRV.adapter = DRecyclerViewAdapter(docsModel)
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
