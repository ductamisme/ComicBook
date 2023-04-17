package com.aicontent.local

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform