package com.example.tuturuintershiptest.presentation.ui.factdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tuturuintershiptest.domain.entities.Fact

class FactDetailsViewModel: ViewModel() {
    var fact = MutableLiveData<Fact>()
}