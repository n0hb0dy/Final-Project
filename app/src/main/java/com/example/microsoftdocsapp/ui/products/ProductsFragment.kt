package com.example.microsoftdocsapp.ui.products

import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.microsoftdocsapp.R
import com.example.microsoftdocsapp.ui.products.ProductsViewModel
import com.example.microsoftdocsapp.databinding.FragmentProductsBinding

class ProductsFragment : Fragment() {

    private var products : ArrayList<ProductsViewModel> = ArrayList()
    private var _binding: FragmentProductsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_products, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.productsRV)
        initializeList(resources.getStringArray(R.array.products), resources.getStringArray(R.array.urls))

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = ProductsAdapter(products)
        recyclerView.setHasFixedSize(true)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeList(productNames: Array<String>, urls: Array<String>){
        for (element in productNames.zip(urls))
            products.add(ProductsViewModel(element.first, element.second))
    }
}