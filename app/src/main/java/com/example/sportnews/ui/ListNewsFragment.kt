package com.example.sportnews.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.appbook.base.BaseFragment
import com.example.sportnews.Data.Articles
import com.example.sportnews.Data.NewsData
import com.example.sportnews.NewsInteractionListener
import com.example.sportnews.R
import com.example.sportnews.adpter.AdapterNewsList
import com.example.sportnews.databinding.FragmentHomeBinding
import com.example.sportnews.network.State
import com.example.sportnews.news.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListNewsFragment: BaseFragment<FragmentHomeBinding>(), NewsInteractionListener {
    val fullNews= FullNews()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding = FragmentHomeBinding::inflate
    val newsRepository = NewsRepository()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestBookData()
    }
    private fun requestBookData() {
        lifecycleScope.launch(Dispatchers.Main) {
            newsRepository.getNewsInfo().collect { state ->
                showResponseState(state)
            }
        }
    }

    private fun showResponseState(responseState: State<NewsData>) = when (responseState) {
        is State.Fail -> showFailState()
        is State.Loading -> showLoadingState()
        is State.Success -> responseState.data.articles?.let { showSuccessState(it) }
    }

    private fun showFailState() {
        Log.i("AAAA", "AMEER")
    }

    private fun showLoadingState() {
        Log.i("AAAA", "AMEER")
    }

    private fun showSuccessState(responseData: List<Articles>) {
        bindBooksData(responseData)
    }

    private fun bindBooksData(news: List<Articles>){
        val adpater = AdapterNewsList(news, this)
        binding.recyclerView.adapter = adpater
    }

    override fun onClickItem(news: Articles?) {
        val bundle = Bundle()
        bundle.putSerializable("Yaali", news)
        fullNews.arguments = bundle
        openFragment(fullNews)
    }
    fun openFragment(fragment:Fragment){
        val transaction= activity?.supportFragmentManager?.beginTransaction()
        transaction?.add(R.id.fragment_container,fragment)
        transaction?.commit()
    }

}