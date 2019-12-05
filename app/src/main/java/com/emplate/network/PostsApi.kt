package com.emplate.network

import com.emplate.model.Post
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PostsApi {

    @GET("posts")
    fun getPosts(@Query("include") includeQuery: String): Flowable<List<Post>>
}