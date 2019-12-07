package com.emplate.ui.posts

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.emplate.R
import com.emplate.di.DaggerAppComponent
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class PostsFragmentTest {

    @get: Rule
    val mActivityRule: ActivityTestRule<PostsActivity> =
        ActivityTestRule<PostsActivity>(PostsActivity::class.java)

    @Before
    fun beforeTest() {
        DaggerAppComponent.builder()
            .application(mActivityRule.activity.application)
            ?.context(mActivityRule.activity.applicationContext)
            ?.build()
    }

    @Test
    fun testPostFragment_IsVisible() {
        mActivityRule.activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, PostsFragment.newInstance(), "PostsFragment")
            .commit()
    }
}