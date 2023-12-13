package com.example.riyadal_qulub.ui.addingWirdScreen

import androidx.lifecycle.ViewModel
import com.example.riyadal_qulub.domain.repository.WirdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class AddViewModel @Inject constructor(
    val repository: WirdRepository
) :ViewModel(){

    private val _state =MutableStateFlow(AddWirdViewState())
    val state = _state


    fun updateWirdName(newName: String) {
        state.value = state.value.copy(wirdName = newName)
    }

}