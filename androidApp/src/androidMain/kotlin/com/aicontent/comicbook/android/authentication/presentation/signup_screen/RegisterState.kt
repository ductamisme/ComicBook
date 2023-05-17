package com.aicontent.comicbook.android.authentication.presentation.signup_screen


data class RegisterState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""

)