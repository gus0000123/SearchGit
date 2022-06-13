package com.jonghyun.domain.dto.res

data class ResGitRepos(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)