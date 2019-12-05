package com.emplate.ui.posts.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.emplate.R
import com.emplate.model.Post
import kotlinx.android.synthetic.main.post_list_item.view.*

class PostsAdapter(
    val mContext: Context,
    private var posts: List<Post>,
    val listener: OnPostItemClickListener
) : RecyclerView.Adapter<PostsAdapter.MyScheduleHolder>() {

    private val inflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyScheduleHolder {
        return MyScheduleHolder(
            inflater.inflate(
                R.layout.post_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: MyScheduleHolder, position: Int) {
        holder.bindScheduleData(posts[position])
    }

    inner class MyScheduleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindScheduleData(post: Post) {
            if (adapterPosition % 2 == 0)
                itemView.reservableRelativeLayout.visibility = View.GONE
            else
                itemView.reservableRelativeLayout.visibility = View.VISIBLE
            Glide.with(mContext)
                .load(post.thumbnail.urls.original)
                .into(itemView.ivPostCover)
            itemView.title.text = post.name
            itemView.setOnClickListener {
                listener.onPostClicked(post)
            }
        }
    }

    interface OnPostItemClickListener {
        fun onPostClicked(post: Post)
    }
}