package com.emplate.di

import android.app.Application
import android.content.Context
import com.emplate.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ActivityBuildersModule::class,
        AppModule::class]
)
interface AppComponent : AndroidInjector<App?> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder?

        @BindsInstance
        fun context(context: Context): Builder?

        fun build(): AppComponent?
    }
}