package com.app.orientalinsurance

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform


