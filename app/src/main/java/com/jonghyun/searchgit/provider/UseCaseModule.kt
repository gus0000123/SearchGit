package com.jonghyun.searchgit.provider

import com.jonghyun.domain.repository.GitRepository
import com.jonghyun.domain.usecase.GetGitRepoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
object UseCaseModule {
    @Provides
    fun provideInitAppInfoUseCase(repo: GitRepository): GetGitRepoUseCase {
        return GetGitRepoUseCase(repo)
    }
}