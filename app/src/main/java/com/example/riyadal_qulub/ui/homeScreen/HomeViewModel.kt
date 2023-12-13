package com.example.riyadal_qulub.ui.homeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riyadal_qulub.data.local.db.WirdDatabase
import com.example.riyadal_qulub.domain.repository.WirdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "HomeViewModel"
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: WirdRepository,
//    private val database : WirdDatabase
) : ViewModel() {
    private val _state  = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    init {
        getWirds()
    }
    private fun getWirds() {
      viewModelScope.launch(Dispatchers.IO) {
            val wirds = repository.getAllWirds()
          _state.value = state.value.copy(wirds = wirds)
          Log.i(TAG, "getWirds: Done ")
      }
    }

}