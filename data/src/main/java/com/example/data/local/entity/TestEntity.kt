package com.example.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.local.dao.TestDao
import com.example.domain.model.TestData

@Entity(tableName = "test")
data class TestEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val firstName: String
){
    fun toDomain(): TestData{
        return TestData(
            id = id,
            title = firstName,
            content = firstName,
            createdAt = firstName,
            updatedAt = firstName,
            userId = id
        )
    }
}
