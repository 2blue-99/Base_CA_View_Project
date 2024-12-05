package com.example.data.repo

import com.example.data.remote.TestDataSourceImpl
import com.example.data.remote.util.toDomainFlow
import com.example.domain.model.TestData
import com.example.domain.repo.TestRepository
import com.example.domain.util.ResourceState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(
    private val dataSource: TestDataSourceImpl
): TestRepository {
    override suspend fun getTestData(): Flow<ResourceState<TestData>> {
        return dataSource.getDataSource().toDomainFlow { it.mapper() }
    }
}