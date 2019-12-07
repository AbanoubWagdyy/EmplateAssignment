package com.emplate.di.posts

import com.emplate.network.posts.PostsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class PostsModule {

    @PostsScope
    @Provides
    fun providePostsApi(retrofit: Retrofit): PostsApi {
        return retrofit.create(PostsApi::class.java)
    }
}