package com.example.domain.usecase

import com.example.domain.repo.TestRepository

class TestUseCase(
    private val repo: TestRepository
)  {
    suspend fun test(): String{
        return repo.getTestData()
    }
}