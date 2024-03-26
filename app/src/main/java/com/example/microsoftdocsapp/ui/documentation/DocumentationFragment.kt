package com.example.microsoftdocsapp.ui.documentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.ViewModelProvider
import com.example.microsoftdocsapp.R
import com.example.microsoftdocsapp.databinding.FragmentDocumentationBinding


class DocumentationFragment : Fragment() {

    private var _binding: FragmentDocumentationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDocumentationBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val webViewer = root.findViewById<WebView>(R.id.webViewer)

        webViewer.webViewClient = object : WebViewClient() {
            @Deprecated("Deprecated in Java")
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }

        webViewer.loadUrl("https://www.geeksforgeeks.org/")

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}