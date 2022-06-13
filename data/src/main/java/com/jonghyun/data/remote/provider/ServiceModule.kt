package com.jonghyun.data.remote.provider

import com.jonghyun.data.remote.service.GitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object ServiceModule {
    @Provides
    fun providePushService(retrofit: Retrofit): GitService {
        return retrofit.create(GitService::class.java)
    }
}