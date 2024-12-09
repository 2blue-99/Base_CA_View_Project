package com.example.data.repo.di

import com.example.data.local.dao.TestDao
import com.example.data.remote.TestDataSourceImpl
import com.example.data.repo.TestRepositoryImpl
import com.example.domain.repo.TestRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun provideRepo(
        dataSource: TestDataSourceImpl,
        testDao: TestDao,
    ): TestRepository = TestRepositoryImpl(dataSource, testDao)
}