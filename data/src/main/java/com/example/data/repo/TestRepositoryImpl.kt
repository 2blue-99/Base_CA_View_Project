package com.example.data.repo

import com.example.data.remote.TestDataSourceImpl
import com.example.domain.repo.TestRepository
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(
    private val dataSource: TestDataSourceImpl
): TestRepository {
    override suspend fun getTestData(): String {
        return dataSource.getDataSource().body().toString()
    }
}