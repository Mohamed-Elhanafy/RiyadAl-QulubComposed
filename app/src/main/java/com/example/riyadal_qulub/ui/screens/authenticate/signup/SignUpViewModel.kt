package com.example.riyadal_qulub.ui.screens.authenticate.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.riyadal_qulub.ui.screens.authenticate.signin.SignInViewState
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


const val TAG = "signUpViewModel"
@HiltViewModel
class SignUpViewModel @Inject constructor(
    val auth: FirebaseAuth
) : ViewModel() {

    private val _signUpResult = MutableStateFlow<String?>(null)
    val signUpResult: StateFlow<String?> get() = _signUpResult

    private val _state = MutableStateFlow(SignInViewState())
    val state = _state.asStateFlow()
    fun signUp(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    _signUpResult.value = "Success"
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    _signUpResult.value = "Failure"
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