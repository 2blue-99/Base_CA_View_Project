package com.example.domain.repo

interface TestRepository {

    suspend fun getTestData():String

}