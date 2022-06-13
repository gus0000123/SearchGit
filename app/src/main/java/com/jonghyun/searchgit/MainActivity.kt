package com.jonghyun.searchgit

import android.util.Log
import androidx.activity.viewModels
import com.jonghyun.searchgit.databinding.ActivityMainBinding
import com.jonghyun.searchgit.extends.hideKeyboard
import com.jonghyun.searchgit.viewmodel.MainVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val TAG = javaClass.simpleName
    private val mainVM by viewModels<MainVM>()
    override fun observeUi() {
        mainVM.repos.observe(this) {
            Log.d(TAG, it.toString())
        }

        binding.vm = mainVM
    }

    override fun setListener() {
        binding.tvRetry.setOnClickListener {
            doSearch()
        }
        binding.tvSearch.setOnClickListener {
            doSearch()
        }
        binding.flProgressbar.setOnClickListener {
            //로딩중에 입력을 막음으로써 오동작을 방지하였습니다.
        }
    }

    private fun doSearch() {
        binding.etSearch.hideKeyboard()
        mainVM.getRepos(binding.etSearch.text.toString())

    }
}