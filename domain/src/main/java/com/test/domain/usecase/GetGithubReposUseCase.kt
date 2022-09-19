package com.test.domain.usecase

import com.test.domain.model.GithubRepo
import com.test.domain.repository.GithubRepository
import kotlinx.coroutines.*

class GetGithubReposUseCase(private val githubRepository: GithubRepository) {
    operator fun invoke(
        owner: String,
        scope: CoroutineScope,
        onResult: (List<GithubRepo>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO){
                githubRepository.getRepos(owner)
            }
            onResult(deferred.await())
        }
    }
}