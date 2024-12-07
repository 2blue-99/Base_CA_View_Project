package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.domain.model.TestData
import kotlinx.coroutines.flow.Flow

@Dao
interface TestDao {
    @Query("SELECT * FROM test")
    fun getAll(): Flow<TestData>
}