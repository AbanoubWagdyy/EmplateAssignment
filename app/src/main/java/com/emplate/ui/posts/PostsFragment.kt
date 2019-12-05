package com.emplate.ui.posts

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.emplate.R
import com.emplate.model.Resource
import com.emplate.ui.BaseFragment
import javax.inject.Inject

class PostsFragment : BaseFragment() {

    override fun layoutRes() = R.layout.fragment_posts

    companion object {
        fun newInstance(): PostsFragment {
            return PostsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.observePosts()?.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.LOADING -> {

                }

                Resource.Status.SUCCESS -> {

                }

                Resource.Status.ERROR -> {

                }
            }
        })
    }

    @Inject
    lateinit var viewModel: PostsViewModel
}