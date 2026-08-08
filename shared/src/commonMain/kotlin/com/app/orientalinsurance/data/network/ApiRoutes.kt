package com.app.orientalinsurance.data.network


object ApiRoute{


    const val BASE_URL = "https://y4132nnj76.execute-api.ap-south-1.amazonaws.com/pre-prod/api/v1/" // Pre Prod Url
    const val LOGIN="auth/login/user-name"
    const val SIGN_UP="customers/check/mobile-email"
    const val FORGOT_PASSWORD="auth/forgot-password/otp"
    const val VERIFY_OTP="auth/forgot-password/otp/verification"
    const val BASIC_DETAILS="proposals/travel-policy-flight/basic-details"

    const val TRAVEL_QUOTE = "proposals/travel-policy-flight/quote"
    const val BRANCH_OFFICE = "others/common/branch-office"

    const val CREATE_FLIGHT = "others/common/branch-office"

    const val SAVE_DATA = "proposals/travel-policy-flight/save-dates"

    const val ADDITIONAL_DETAILS = "proposals/travel-policy-flight/additional-details"



}
