package com.test.domain.repository

import com.test.domain.model.GithubRepo

interface GithubRepository {
    suspend fun getRepos(owner: String): List<GithubRepo>
}