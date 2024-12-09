package com.example.domain.usecase

import com.example.domain.util.ResourceState
import com.example.domain.model.TestData
import com.example.domain.repo.TestRepository
import kotlinx.coroutines.flow.Flow

class TestDaoUseCase(
    private val repo: TestRepository,
)  {
    fun testDao(): Flow<List<TestData>> {
        return repo.getTestDao()
    }
}