package com.aicontent.comicbook

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform