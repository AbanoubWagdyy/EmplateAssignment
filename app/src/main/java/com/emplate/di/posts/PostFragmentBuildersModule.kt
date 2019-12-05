package com.emplate.di.posts

import com.emplate.ui.posts.PostsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PostFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributePostsFragment(): PostsFragment?
}