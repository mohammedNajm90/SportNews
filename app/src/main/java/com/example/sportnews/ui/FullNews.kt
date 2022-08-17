package com.example.sportnews.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appbook.base.BaseFragment
import com.example.sportnews.R
import com.example.sportnews.databinding.FragmentFullNewsBinding
import com.example.sportnews.databinding.FragmentRecicleNewsDataBinding

class FullNews: BaseFragment<FragmentFullNewsBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFullNewsBinding = FragmentFullNewsBinding::inflate

}
