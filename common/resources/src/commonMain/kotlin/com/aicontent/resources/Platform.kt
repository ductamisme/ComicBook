package com.aicontent.resources

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform