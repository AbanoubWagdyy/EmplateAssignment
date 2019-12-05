package com.emplate.model

data class Post(
    val type: String,
    val approved: Boolean,
    val collectible: Boolean,
    val created_at: String,
    val id: Int,
    val name: String,
    val thumbnail: Thumbnail,
    val updated_at: String,
    val url: String
)