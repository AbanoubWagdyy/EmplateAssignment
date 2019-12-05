package com.emplate.model

data class Thumbnail(
    val filetype: String,
    val height: Int,
    val id: Int,
    val name: Any,
    val type: String,
    val urls: Urls,
    val width: Int
)