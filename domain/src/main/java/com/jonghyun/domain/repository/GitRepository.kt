package com.jonghyun.domain.repository

import com.jonghyun.domain.dto.Stateful
import com.jonghyun.domain.dto.res.ResGitRepos
import kotlinx.coroutines.flow.Flow

interface GitRepository {
    suspend fun getRepositories(query: String): Flow<Stateful<ResGitRepos>>
}