package com.emplate.ui.posts

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.emplate.R
import com.emplate.model.Post
import com.emplate.model.Resource
import com.emplate.ui.BaseFragment
import com.emplate.ui.posts.adapter.PostsAdapter
import kotlinx.android.synthetic.main.fragment_posts.*
import javax.inject.Inject


class PostsFragment : BaseFragment(), PostsAdapter.OnPostItemClickListener {

    override fun layoutRes() = R.layout.fragment_posts

    companion object {
        fun newInstance(): PostsFragment {
            return PostsFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            viewModel.observePosts().removeObservers(viewLifecycleOwner)
            viewModel.observePosts()?.observe(viewLifecycleOwner, Observer {
                when (it.status) {
                    Resource.Status.LOADING -> {
                        if (!isDetached)
                            progressBar.visibility = View.VISIBLE
                    }
                    Resource.Status.SUCCESS -> {
                        if (!isDetached) {
                            progressBar.visibility = View.GONE
                            val layoutManager = LinearLayoutManager(context!!)
                            recyclerPosts.layoutManager = layoutManager
                            mAdapter = PostsAdapter(context!!, it.data!!, this@PostsFragment)
                            recyclerPosts.adapter = mAdapter
                        }
                    }
                    Resource.Status.ERROR -> {
                        if (!isDetached) {
                            progressBar.visibility = View.GONE
                            Toast.makeText(context!!, it.message, Toast.LENGTH_LONG).show()
                        }
                    }
                }
            })
        }

    }

    @Inject
    lateinit var viewModel: PostsViewModel

    lateinit var mAdapter: PostsAdapter

    override fun onPostClicked(post: Post) {
        Log.d("Post", post.toString())
    }
}