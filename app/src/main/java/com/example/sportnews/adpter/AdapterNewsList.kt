package com.example.sportnews.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportnews.Data.Articles
import com.example.sportnews.Data.NewsData
import com.example.sportnews.R
import com.example.sportnews.databinding.FragmentRecicleNewsDataBinding

class AdapterNewsList(val list:List<Articles>):RecyclerView.Adapter<AdapterNewsList.HolderNewsList>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderNewsList {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_recicle_news_data,parent,false)
        return HolderNewsList(view)
    }


    override fun onBindViewHolder(holder: HolderNewsList, position: Int) {
        val list = list[position]

        holder.binding.apply {
                list.urlToImage?.let{
                    Glide.with(this.root).load(list.urlToImage).into(newImage)
                    titleNews.text = list.title.toString()
                    datePublish.text = list.publishedAt.toString()
                    sourceName.text = list.source.name.toString()
                }


        }
    }

    override fun getItemCount():Int = list.size

    class HolderNewsList(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding= FragmentRecicleNewsDataBinding.bind(itemView)
    }
}