package com.example.microsoftdocsapp.ui.documentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.deletethis.ui.documentation.DocumentationViewModel
import com.example.microsoftdocsapp.databinding.FragmentDocumentationBinding

class DocumentationFragment : Fragment() {

    private var _binding: FragmentDocumentationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val documentationViewModel =
            ViewModelProvider(this).get(DocumentationViewModel::class.java)

        _binding = FragmentDocumentationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        documentationViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}