package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.data.local.entity.TestEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TestDao {
    @Query("SELECT * FROM test")
    fun getAll(): Flow<List<TestEntity>>
}