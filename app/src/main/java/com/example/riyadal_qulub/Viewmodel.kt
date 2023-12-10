package com.example.riyadal_qulub

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riyadal_qulub.data.repository.WirdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Viewmodel @Inject constructor(
    private val repository: WirdRepository
) : ViewModel() {

    fun getWirds() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllWirds()
        }
    }
}