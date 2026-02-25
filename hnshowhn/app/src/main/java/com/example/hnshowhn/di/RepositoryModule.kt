package com.example.hnshowhn.di

import com.example.hnshowhn.data.repository.HnRepositoryImpl
import com.example.hnshowhn.domain.repository.HnRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHnRepository(
        impl: HnRepositoryImpl
    ): HnRepository
}