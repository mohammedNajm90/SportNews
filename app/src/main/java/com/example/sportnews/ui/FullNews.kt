package com.example.sportnews.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.appbook.base.BaseFragment
import com.example.sportnews.Data.Articles
import com.example.sportnews.databinding.FragmentFullNewsBinding
import com.example.sportnews.util.Constants.HttpUrl.Values.NULL_Image


class FullNews : BaseFragment<FragmentFullNewsBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFullNewsBinding =
        FragmentFullNewsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val news = arguments?.getSerializable("Yaali") as Articles
        binding.apply {
            if (news.urlToImage != null) {
                Glide.with(this.root).load(news.urlToImage).into(newImage)
            } else {
                Glide.with(this.root).load(NULL_Image).into(newImage)

            }
            titleNews.text = news.title?.toString()
            datePublish.text = news.publishedAt?.toString()
            sourceName.text = news.source?.name.toString()
            fullReport.text = news.description?.toString()

        }
        binding.backBtn.setOnClickListener {
            backFunction(this)
        }

    }

    private fun backFunction(fragment: Fragment) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.remove(fragment)
        transaction?.commit()
    }
}
