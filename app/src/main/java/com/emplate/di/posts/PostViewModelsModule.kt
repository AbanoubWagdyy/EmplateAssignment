package com.emplate.di.posts

import com.emplate.di.InjectionViewModelProvider
import com.emplate.di.ViewModelInjection
import com.emplate.ui.posts.PostsActivity
import com.emplate.ui.posts.PostsViewModel
import dagger.Module
import dagger.Provides

@Module
class PostViewModelsModule {

    @Provides
    @ViewModelInjection
    fun providePostsVM(
        activity: PostsActivity,
        viewModelProvider: InjectionViewModelProvider<PostsViewModel>
    ) = viewModelProvider.get(activity, PostsViewModel::class)
}