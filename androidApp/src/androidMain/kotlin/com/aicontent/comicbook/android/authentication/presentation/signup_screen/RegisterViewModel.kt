package com.aicontent.comicbook.android.authentication.presentation.signup_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aicontent.comicbook.android.authentication.data.AuthRepository
import com.aicontent.comicbook.android.authentication.presentation.login_screen.SignInState
import com.example.firebaseauthyt.util.Resource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject



class RegisterViewModel : ViewModel(), KoinComponent {

    private val repository by inject<AuthRepository>()

    val _registerState  = Channel<RegisterState>()
    val registerState  = _registerState.receiveAsFlow()


    fun registerUser(email:String, password:String) = viewModelScope.launch {
        repository.registerUser(email, password).collect{result ->
            when(result){
                is Resource.Success ->{
                    _registerState.send(RegisterState(isSuccess = "Sign Up Success "))
                }
                is Resource.Loading ->{
                    _registerState.send(RegisterState(isLoading = true))
                }
                is Resource.Error ->{

                    _registerState.send(RegisterState(isError = result.message))
                }
            }

        }
    }

}