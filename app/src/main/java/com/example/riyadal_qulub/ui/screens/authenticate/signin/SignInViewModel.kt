package com.example.riyadal_qulub.ui.screens.authenticate.signin

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


const val TAG = "signInViewModel"
@HiltViewModel
class SignInViewModel @Inject constructor(
    val auth: FirebaseAuth
) : ViewModel() {

    private val _signInResult = MutableStateFlow<String?>(null)
    val signInResult: StateFlow<String?> get() = _signInResult

    private val _state = MutableStateFlow(SignInViewState())
    val state = _state.asStateFlow()
    fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    _signInResult.value = "Success"
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    _signInResult.value = "Failure"
                }
            }
    }


    fun updateEmail(newEmail: String) {
        _state.value = _state.value.copy(email = newEmail)
    }

    fun updatePassword(newPassword: String) {
        _state.value = _state.value.copy(password = newPassword)
    }
}