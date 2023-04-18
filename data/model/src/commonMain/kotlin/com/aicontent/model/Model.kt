package com.aicontent.model

interface Model {
    fun toLocalDto(): Dto
    fun toRemoteDto(): Dto
}