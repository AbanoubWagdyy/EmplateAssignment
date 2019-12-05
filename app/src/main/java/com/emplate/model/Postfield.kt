package com.emplate.model

data class Postfield(
    val content: String,
    val created_at: String,
    val id: Int,
    val order: Int,
    val postFieldType_id: Int,
    val post_id: Int,
    val type: String,
    val updated_at: String
)