package com.jonghyun.searchgit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonghyun.domain.usecase.GetGitRepoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(val getGitRepoUseCase: GetGitRepoUseCase) : ViewModel() {
    fun getRepos(query: String) {
        viewModelScope.launch {
            getGitRepoUseCase(query)
        }
    }
}