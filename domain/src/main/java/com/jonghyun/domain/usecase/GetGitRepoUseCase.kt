package com.jonghyun.domain.usecase

import com.jonghyun.domain.dto.Stateful
import com.jonghyun.domain.dto.res.ResGitRepos
import com.jonghyun.domain.repository.GitRepository
import kotlinx.coroutines.flow.Flow

class GetGitRepoUseCase(private var gitRepo: GitRepository) {
    suspend operator fun invoke(query: String): Flow<Stateful<ResGitRepos>> {
        return gitRepo.getRepositories(query)
    }
}