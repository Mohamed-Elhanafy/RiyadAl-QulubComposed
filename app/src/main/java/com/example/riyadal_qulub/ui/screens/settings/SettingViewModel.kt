package com.example.riyadal_qulub.ui.screens.settings

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riyadal_qulub.domain.repository.WirdRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SettingViewModel @Inject constructor(
    val repository: WirdRepository,
    val auth: FirebaseAuth,
) : ViewModel() {


    fun deleteAllWirds() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllWirds()
        }
    }

    fun logout() {
        auth.signOut()

    }
}