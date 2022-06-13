package com.jonghyun.searchgit.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonghyun.domain.dto.Stateful
import com.jonghyun.domain.dto.res.Item
import com.jonghyun.domain.usecase.GetGitRepoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(private val getGitRepoUseCase: GetGitRepoUseCase) : ViewModel() {
    var repos = MutableLiveData<ArrayList<Item>>()
    var info = ObservableField<String>()
    var valid = ObservableField<Boolean>()
    var loading = ObservableField<Boolean>()
    var retryable = ObservableField<Boolean>()

    init {
        info.set("검색할 데이터를 입력하세요.")
        retryable.set(false)
    }

    fun getRepos(query: String) {
        viewModelScope.launch {
            getGitRepoUseCase(query).collect {
                retryable.set(true)
                when (it) {
                    is Stateful.Success -> {
                        repos.postValue(it.value.items)
                    }
                    is Stateful.Empty -> {
                        info.set("데이터가 비어있습니다.")
                    }
                    is Stateful.Failure -> {
                        info.set("데이터 요청중 오류가 발생했습니다.")
                    }
                }
                //로딩중과 데이터가 정상적으로 수신된 경우만 유효하다고 판단하였습니다.
                valid.set(it is Stateful.Loading || it is Stateful.Success)
                loading.set(it is Stateful.Loading)
            }
        }
    }
}