package com.example.microsoftdocsapp.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.net.URL

data class ProductsViewModel (
     val productName: String,
     val url: String
):java.io.Serializable