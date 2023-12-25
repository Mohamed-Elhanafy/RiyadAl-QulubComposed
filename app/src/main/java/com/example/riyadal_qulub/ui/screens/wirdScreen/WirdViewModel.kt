package com.example.riyadal_qulub.ui.screens.wirdScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riyadal_qulub.domain.model.Wird
import com.example.riyadal_qulub.domain.repository.WirdRepository
import com.example.riyadal_qulub.ui.screens.addingWirdScreen.AddWirdViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class WirdViewModel @Inject constructor(
    val repository: WirdRepository
) : ViewModel(){
    private val _state = MutableStateFlow(WirdViewState())
    val state = _state
    fun getWirdById(wirdId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val wird = repository.getWirdById(wirdId)
            withContext(Dispatchers.Main) {
                if (wird != null) {
                    _state.value = state.value.copy(wird = wird)
                } else {
                    // Handle the case where the Wird is not found
                }
            }
        }
    }
}