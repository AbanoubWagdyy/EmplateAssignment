package com.emplate.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(private val mApi_key: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("X-Api-Key", mApi_key)
                .build()
        )
    }
}