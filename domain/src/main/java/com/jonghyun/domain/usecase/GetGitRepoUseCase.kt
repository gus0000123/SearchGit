package com.jonghyun.domain.usecase

import com.jonghyun.domain.repository.GitRepository

class GetGitRepoUseCase(private var gitRepo: GitRepository) {
    suspend operator fun invoke(query: String) {
        gitRepo.getRepositories(query)
    }
}