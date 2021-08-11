package com.example.simpleandroidtoptech.di.module

import com.example.simpleandroidtoptech.domain.repositories.IRepository
import com.example.simpleandroidtoptech.domain.repositories.Repository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(repository: Repository) : IRepository
}