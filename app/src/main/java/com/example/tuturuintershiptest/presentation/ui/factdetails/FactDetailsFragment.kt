package com.example.tuturuintershiptest.presentation.ui.factdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tuturuintershiptest.R
import com.example.tuturuintershiptest.databinding.FragmentFactDetailsBinding
import com.example.tuturuintershiptest.presentation.MainActivity.Companion.FACT_TAG

class FactDetailsFragment : Fragment() {

    private lateinit var binding: FragmentFactDetailsBinding
    private lateinit var factDetailsViewModel: FactDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFactDetailsBinding.inflate(inflater)

        factDetailsViewModel = FactDetailsViewModel()
        factDetailsViewModel.fact.observe(requireActivity()) {
            binding.fact.text = getString(R.string.fact, it.text)
            binding.created.text = getString(R.string.created, it.createdAt)
            if (it?.status?.verified == null || !it.status.verified) binding.verified.text =
                getString(R.string.verified, false.toString())
            else binding.verified.text = getString(R.string.verified, true.toString())
        }
        factDetailsViewModel.fact.value = arguments?.getParcelable(FACT_TAG)
        return binding.root
    }
}