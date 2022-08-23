package com.example.sportnews.adpter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportnews.Data.Articles
import com.example.sportnews.NewsInteractionListener
import com.example.sportnews.R
import com.example.sportnews.databinding.ItemNewsBinding
import com.example.sportnews.util.Constants.HttpUrl.Values.NULL_Image


class AdapterNewsList(val list: List<Articles>, val listener: NewsInteractionListener) :
    RecyclerView.Adapter<AdapterNewsList.HolderNewsList>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderNewsList {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return HolderNewsList(view)
    }


    override fun onBindViewHolder(holder: HolderNewsList, position: Int) {
        val list = list[position]

        holder.binding.apply {
            if (list.urlToImage != null) {
                Glide.with(this.root).load(list.urlToImage).into(newImage)
            } else {
                Glide.with(this.root).load(NULL_Image).into(newImage)
            }
            titleNews.text = list.title.toString()
            datePublish.text = list.publishedAt.toString()
            sourceName.text = list.source?.name.toString()
            newImage.setOnClickListener {
                listener.onClickItem(list)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    class HolderNewsList(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemNewsBinding.bind(itemView)
    }
}