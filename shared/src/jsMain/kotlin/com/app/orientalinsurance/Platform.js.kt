package com.app.orientalinsurance

import web.navigator.navigator

class JsPlatform: Platform {
    override val name="web"
   /* private val userAgent = navigator.userAgent
    private val browserList = listOf("Chrome", "Firefox", "Safari", "Edge")

    override val name: String = userAgent.findAnyOf(browserList, ignoreCase = true)
            ?.let { (startIndex) -> userAgent.substring(startIndex).substringBefore(" ") }
            ?: "Unknown"*/
}

actual fun getPlatform(): Platform = JsPlatform()