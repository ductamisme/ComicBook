package com.aicontent.localization

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform