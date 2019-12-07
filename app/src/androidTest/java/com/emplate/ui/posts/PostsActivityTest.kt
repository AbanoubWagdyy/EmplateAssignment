package com.emplate.ui.posts

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.emplate.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class PostsActivityTest {

    @get: Rule
    val activityRunner = ActivityScenarioRule(PostsActivity::class.java)

    @Test
    fun testActivity_inView() {
        onView(withId(R.id.frame)).check(matches(isDisplayed()))
    }

    @Test
    fun testVisibility_frame() {
        onView(withId(R.id.frame)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
}