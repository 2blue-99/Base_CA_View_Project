package com.example.data.remote

import com.example.data.remote.model.ResponseData
import retrofit2.Response
import javax.inject.Inject

class TestDataSourceImpl @Inject constructor(
    private val testAPI: TestDataSource
) {
    suspend fun getDataSource(): Response<ResponseData> {
        return testAPI.getDataSource()
    }
}