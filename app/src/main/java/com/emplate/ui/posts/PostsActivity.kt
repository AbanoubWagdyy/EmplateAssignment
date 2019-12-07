package com.emplate.ui.posts

import android.os.Bundle
import com.emplate.R
import com.emplate.ui.BaseActivity

class PostsActivity : BaseActivity() {

    override fun layoutRes() =
        R.layout.activity_posts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame, PostsFragment.newInstance(),"PostsFragment")
                .commit()
        }
    }
}