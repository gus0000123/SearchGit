package com.jonghyun.data.repository

import com.jonghyun.data.remote.service.GitService
import com.jonghyun.domain.dto.Stateful
import com.jonghyun.domain.dto.res.ResGitRepos
import com.jonghyun.domain.repository.GitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GitRepositoryImpl(private val gitService: GitService) : GitRepository {
    override suspend fun getRepositories(query: String): Flow<Stateful<ResGitRepos>> {
        return flow {
            emit(Stateful.Loading)
            kotlin.runCatching {
                gitService.getRepositories(query = query)
            }.onSuccess {
                if (it.items.isNullOrEmpty()) {
                    emit(Stateful.Empty)
                } else {
                    emit(Stateful.Success(it))
                }
            }.onFailure {
                emit(Stateful.Error(it))
            }
        }
    }
}