package com.example.microsoftdocsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.microsoftdocsapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

//    private lateinit var docsModel : ArrayList<DocsModel>;
//    private lateinit var recyclerView: RecyclerView;
//    private lateinit var webView: WebView;

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        //setUpDocsMadel()
    }

    private fun setUpWebView(): Unit {
        binding.webView.webViewClient = WebViewClient()
    }
    private fun goToWebsite(url: String ="https://learn.microsoft.com/en-us/power-automate/getting-started"): Unit {
        binding.webView.apply {
            loadUrl(url)
            settings.safeBrowsingEnabled = true
        }
    }

//    private fun setUpDocsMadel(): Unit {
//        val docsNames: Array<String> = resources.getStringArray(R.array.products)
//
//        for (i in 0..docsNames.size){
//            docsModel.add(DocsModel(docsNames[i]))
//        }
//
//        recyclerView.adapter = D_RecyclerViewAdapter(docsModel)
//    }
}
