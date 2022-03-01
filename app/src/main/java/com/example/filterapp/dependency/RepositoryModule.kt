package com.example.filterapp.dependency

import com.example.filterapp.repositories.EditImageRepository
import com.example.filterapp.repositories.EditImageRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    factory <EditImageRepository> { EditImageRepositoryImpl(androidContext()) }
}