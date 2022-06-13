package com.jonghyun.searchgit.provider

import com.jonghyun.data.remote.service.GitService
import com.jonghyun.data.repository.GitRepositoryImpl
import com.jonghyun.domain.repository.GitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {
    @Provides
    fun provideInitAppInfoRepo(
        service: GitService,
    ): GitRepository {
        return GitRepositoryImpl(service)
    }
}