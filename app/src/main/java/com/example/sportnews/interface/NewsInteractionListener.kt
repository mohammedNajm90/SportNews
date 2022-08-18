package com.example.sportnews

import com.example.sportnews.Data.Articles


interface NewsInteractionListener {
    fun onClickItem(news: Articles?)
}