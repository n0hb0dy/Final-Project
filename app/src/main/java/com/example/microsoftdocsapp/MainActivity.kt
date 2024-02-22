package com.example.microsoftdocsapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.microsoftdocsapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    private lateinit var docsModel : ArrayList<DocsModel>;
    private lateinit var recyclerView: RecyclerView;
//    private lateinit var webView: WebView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(activityMainBinding.root)

        setUpDocsMadel()
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

    private fun setUpDocsMadel(): Unit {
        val productNames: Array<String> = resources.getStringArray(R.array.products)

        for (i in 0..productNames.size){
            docsModel.add(DocsModel(productNames[i]))
        }

        activityMainBinding.productsRV.layoutManager = LinearLayoutManager(this)
        activityMainBinding.productsRV.adapter = D_RecyclerViewAdapter(docsModel)
    }
}
