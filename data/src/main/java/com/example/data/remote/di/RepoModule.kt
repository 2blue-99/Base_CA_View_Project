package com.example.data.remote.di

import com.example.data.remote.TestDataSource
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
    fun provideRepo(dataSource: TestDataSourceImpl): TestRepository = TestRepositoryImpl(dataSource)
}