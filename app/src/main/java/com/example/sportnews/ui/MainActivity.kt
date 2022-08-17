package com.example.sportnews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.appbook.base.BaseActivity
import com.example.sportnews.Data.Articles
import com.example.sportnews.Data.NewsData
import com.example.sportnews.adpter.AdapterNewsList
import com.example.sportnews.databinding.ActivityMainBinding
import com.example.sportnews.network.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : BaseActivity<ActivityMainBinding>() {
    override lateinit var binding: ActivityMainBinding
    private val newsRepository = com.example.sportnews.news.NewsRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestNewsData()
    }
    private fun requestNewsData() {
        lifecycleScope.launch(Dispatchers.Main) {
            newsRepository.getNewsInfo().collect{ state ->
                showResponseState(state)
            }
        }
    }
    private fun showResponseState(responseState: State<NewsData>) = when(responseState) {
        is State.Fail -> showFailState()
        is State.Loading -> showLoadingState()
        is State.Success -> responseState.data.articles.let { showSuccessState(it) }
    }
    private fun showFailState() {
        Log.i("Moh","Fail")
    }
    private fun showLoadingState() {
        Log.i("Moh","Loading")
    }
    private fun showSuccessState(responseData: List<Articles>) {
        bindNewsData(responseData)
    }
    private fun  bindNewsData(news: List<Articles>) {
        val adpater = AdapterNewsList(news)
        binding.recyclerView.adapter = adpater
    }

    override fun bindingInflater()= ActivityMainBinding.inflate(layoutInflater)

    override fun setUp() {

    }
}