package com.emplate.di

import com.emplate.di.posts.PostFragmentBuildersModule
import com.emplate.di.posts.PostViewModelsModule
import com.emplate.di.posts.PostsModule
import com.emplate.di.posts.PostsScope
import com.emplate.ui.posts.PostsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [
            PostFragmentBuildersModule::class,
            PostViewModelsModule::class,
            PostsModule::class
        ]
    )
    @PostsScope
    abstract fun contributePostsActivity(): PostsActivity
}