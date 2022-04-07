package com.example.tuturuintershiptest.presentation.ui.catfacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tuturuintershiptest.R
import com.example.tuturuintershiptest.databinding.FragmentCatFactsBinding
import com.example.tuturuintershiptest.presentation.MainActivity.Companion.FACT_TAG
import kotlinx.coroutines.launch

class CatFactsFragment : Fragment() {

    private lateinit var binding: FragmentCatFactsBinding
    private lateinit var catFactsViewModel: CatFactsViewModel
    private val adapter = RecyclerViewAdapter {
        val bundle = Bundle()
        bundle.putParcelable(FACT_TAG, it)
        findNavController(binding.root)
            .navigate(R.id.action_catFactsFragment_to_factDetailsFragment, bundle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatFactsBinding.inflate(inflater)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        catFactsViewModel = ViewModelProvider(requireActivity())[CatFactsViewModel::class.java]
        catFactsViewModel.facts.observe(requireActivity()) { facts ->
            adapter.clearFacts()
            facts.forEach { adapter.addFact(it) }
        }
        binding.swipeRefresh.setOnRefreshListener {
            lifecycleScope.launch {
                catFactsViewModel.getCatFacts().join()
                binding.swipeRefresh.isRefreshing = false
            }
        }
        return binding.root
    }
}