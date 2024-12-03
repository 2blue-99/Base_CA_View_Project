package com.example.data.remote

import retrofit2.Response
import javax.inject.Inject

class TestDataSourceImpl @Inject constructor(
    private val testAPI: TestDataSource
) {
    suspend fun getDataSource(): Response<ResponseData> {
        return testAPI.getDataSource()
    }
}