package com.jonghyun.data.remote.service

import com.jonghyun.domain.dto.res.ResGitRepos
import retrofit2.http.GET
import retrofit2.http.Query

interface GitService {
    @GET("repositories")
    suspend fun getRepositories(
        @Query("q")
        query: String
    ): ResGitRepos
}