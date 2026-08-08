package com.app.orientalinsurance.data.multiplateformData

import com.russhwolf.settings.Settings

class SettingsManager( private val settings: Settings) {

    companion object {
        private const val TOKEN = "token"
        private const val IS_LOGIN = "islogin"
        private const val EMAIL_ID = "email"
        private const val MOBILE_NO = "mobile"
    }

    fun saveToken(token: String) {
        settings.putString(TOKEN, token)
    }

    fun getToken(): String? {
        return settings.getStringOrNull(TOKEN)
    }

    fun saveEmail(email: String) {
        settings.putString(EMAIL_ID, email)
    }

    fun getEmail(): String? {
        return settings.getStringOrNull(EMAIL_ID)
    }

    fun saveMobileNo(mobileno: String) {
        settings.putString(MOBILE_NO, mobileno)
    }

    fun getMobileNo(): String? {
        return settings.getStringOrNull(MOBILE_NO)
    }

    fun saveIsLogin(isLogin: Boolean) {
        settings.putBoolean(IS_LOGIN, isLogin)
    }

    fun getIsLogin(): Boolean ?{
        return settings.getBooleanOrNull(IS_LOGIN)
    }

    fun clearToken() {
        settings.remove(TOKEN)
    }

}