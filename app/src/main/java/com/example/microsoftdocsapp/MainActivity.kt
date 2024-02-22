package com.example.microsoftdocsapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.microsoftdocsapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    private var docsModel : ArrayList<DocsModel> = ArrayList()
//    private lateinit var recyclerView: RecyclerView;
//    private lateinit var webView: WebView;

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
        for (i in 0..<productNames.size)
            docsModel.add(DocsModel(productNames[i]))


        activityMainBinding.productsRV.layoutManager = LinearLayoutManager(this)
        activityMainBinding.productsRV.adapter = DRecyclerViewAdapter(docsModel)
        activityMainBinding.productsRV.setHasFixedSize(true)
    }

//    private fun setUpWebView(): Unit {
//        activityMainBinding.webView.webViewClient = WebViewClient()
//    }
//    private fun goToWebsite(url: String ="https://learn.microsoft.com/en-us/power-automate/getting-started"): Unit {
//        activityMainBinding.webView.apply {
//            loadUrl(url)
//            settings.safeBrowsingEnabled = true
//        }
//    }
}
