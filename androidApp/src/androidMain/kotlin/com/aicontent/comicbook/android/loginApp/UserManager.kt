package com.aicontent.comicbook.android.loginApp

import android.content.SharedPreferences
import androidx.core.content.edit

class UserManager(private val preferences: SharedPreferences) {
    private val pinKey = "PIN"

    fun hasLoggedIn(): Boolean {
        return preferences.getBoolean("HasLoggedIn", false)
    }

    fun setLoggedIn() {
        preferences.edit { putBoolean("HasLoggedIn", true) }
    }

    fun verifyPin(pin: String): Boolean {
        val savedPin = preferences.getString(pinKey, "")
        return savedPin == pin
    }

    fun changePin(oldPin: String, newPin: String): Boolean {
        val savedPin = preferences.getString(pinKey, "")
        return if (savedPin == oldPin) {
            preferences.edit {
                putString(pinKey, newPin)
            }
            true
        } else {
            false
        }
    }
}

