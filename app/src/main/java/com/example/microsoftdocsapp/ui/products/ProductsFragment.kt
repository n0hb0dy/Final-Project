package com.example.microsoftdocsapp.ui.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.microsoftdocsapp.R
import com.example.microsoftdocsapp.databinding.FragmentProductsBinding


class ProductsFragment : Fragment() {
    private var _binding: FragmentProductsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val productCards = root.findViewById<RecyclerView>(R.id.productsRV)

        productCards.layoutManager = LinearLayoutManager(this.context)

        productCards.adapter = ProductCardsAdaptor(
            arrayListOf<ProductCardsModel>(
                ProductCardsModel("Test1", "https://www.google.com"),
                ProductCardsModel("Test2", "https://www.youtube.com")
                ))


        return root
    }

}