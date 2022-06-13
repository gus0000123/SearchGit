package com.jonghyun.domain.dto.res

data class ResGitRepos(
    val incomplete_results: Boolean,
    val items: ArrayList<Item>,
    val total_count: Int
)