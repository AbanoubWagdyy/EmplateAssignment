package com.emplate.ui.posts

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.emplate.App
import com.emplate.di.DaggerAppComponent
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PostsViewModelTest {

    private var instrumentationContext: Context? = null

    @Before
    fun before_Test() {

        instrumentationContext = InstrumentationRegistry.getInstrumentation().context as Context

        DaggerAppComponent.builder()
            .application(App())
            ?.context(instrumentationContext!!)
            ?.build()

        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun observePosts() {

        viewModel.observePosts()
    }

    val viewModel:PostsViewModel = mock(PostsViewModel::class.java)
}