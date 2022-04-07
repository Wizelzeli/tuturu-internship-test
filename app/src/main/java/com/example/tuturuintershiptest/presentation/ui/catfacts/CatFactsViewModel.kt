package com.example.tuturuintershiptest.presentation.ui.catfacts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tuturuintershiptest.domain.entities.Facts
import com.example.tuturuintershiptest.domain.usecase.GetCatFactsUseCase
import kotlinx.coroutines.launch
import java.lang.Exception

class CatFactsViewModel : ViewModel() {
    private val getCatFactsUseCase = GetCatFactsUseCase()
    var facts = MutableLiveData<Facts>()

    init {
        getCatFacts()
    }

    fun getCatFacts() = viewModelScope.launch {
        try { facts.value = getCatFactsUseCase.execute() } catch (e: Exception) { }
    }
}