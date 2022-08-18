package com.example.sportnews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.example.appbook.base.BaseActivity
import com.example.sportnews.Data.Articles
import com.example.sportnews.Data.NewsData
import com.example.sportnews.adpter.AdapterNewsList
import com.example.sportnews.databinding.ActivityMainBinding
import com.example.sportnews.databinding.FragmentHomeBinding
import com.example.sportnews.network.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding =ActivityMainBinding::inflate


}