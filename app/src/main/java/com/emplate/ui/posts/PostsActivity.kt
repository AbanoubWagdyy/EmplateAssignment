package com.emplate.ui.posts

import android.os.Bundle
import com.emplate.R
import com.emplate.ui.BaseActivity

class PostsActivity : BaseActivity() {

    override fun layoutRes() =
        R.layout.activity_posts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().add(R.id.frame, PostsFragment.newInstance())
            .commitAllowingStateLoss()
    }
}