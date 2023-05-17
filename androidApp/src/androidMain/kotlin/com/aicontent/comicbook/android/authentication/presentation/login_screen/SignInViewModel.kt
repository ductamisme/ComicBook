package com.aicontent.comicbook.android.authentication.presentation.login_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aicontent.comicbook.android.authentication.data.AuthRepository
import com.example.firebaseauthyt.util.Resource
import com.google.firebase.auth.AuthCredential
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SignInViewModel : ViewModel(), KoinComponent {

    private val repository by inject<AuthRepository>()

    private val _signInState = Channel<SignInState>()
    val signInState = _signInState.receiveAsFlow()

//    private val _googleState = mutableStateOf(GoogleSignInState())
//    val googleState: MutableState<GoogleSignInState> = _googleState
//
//    fun googleSignIn(credential: AuthCredential) = viewModelScope.launch {
//        repository.googleSignIn(credential).collect { result ->
//            when (result) {
//                is Resource.Success -> {
//                    _googleState.value = GoogleSignInState(success = result.data)
//                }
//                is Resource.Loading -> {
//                    _googleState.value = GoogleSignInState(loading = true)
//                }
//                is Resource.Error -> {
//                    _googleState.value = GoogleSignInState(error = result.message!!)
//                }
//            }
//        }
//    }

    fun loginUser(email: String, password: String) = viewModelScope.launch {
        repository.loginUser(email, password).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _signInState.send(SignInState(isSuccess = "Sign In Success "))
                }
                is Resource.Loading -> {
                    _signInState.send(SignInState(isLoading = true))
                }
                is Resource.Error -> {
                    _signInState.send(SignInState(isError = result.message))
                }
            }
        }
    }
}
