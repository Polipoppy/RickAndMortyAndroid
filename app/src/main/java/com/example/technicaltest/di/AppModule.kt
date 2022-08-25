package com.example.technicaltest.di

import com.example.technicaltest.data.remote.RickAndMortyApi
import com.example.technicaltest.data.repository.RickMortyRepositoryImpl
import com.example.technicaltest.domain.repository.RickMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRickMortyApi(): RickAndMortyApi {
        return RickAndMortyApi()
    }

    @Provides
    @Singleton
    fun provideRickMortyRepository(api: RickAndMortyApi): RickMortyRepository {
        return RickMortyRepositoryImpl(api)
    }
}