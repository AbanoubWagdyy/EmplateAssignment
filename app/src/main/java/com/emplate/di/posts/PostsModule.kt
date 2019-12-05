package com.emplate.di.posts

import android.content.Context
import com.emplate.BuildConfig
import com.emplate.network.PostsApi
import com.emplate.network.UnsafeOkHttpClient
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class PostsModule {

    @PostsScope
    @Provides
    fun providePostsApi(retrofit: Retrofit): PostsApi {
        return retrofit.create(PostsApi::class.java)
    }
}