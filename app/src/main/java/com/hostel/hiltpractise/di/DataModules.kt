package com.hostel.hiltpractise.di

import android.content.Context
import androidx.room3.Room
import com.hostel.hiltpractise.data.TaskRepository
import com.hostel.hiltpractise.data.source.DefaultTaskRepository
import com.hostel.hiltpractise.data.source.local.TaskDao
import com.hostel.hiltpractise.data.source.local.ToDoDatabase
import com.hostel.hiltpractise.data.source.network.NetworkDataSource
import com.hostel.hiltpractise.data.source.network.TaskNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindTaskRepository(repository: DefaultTaskRepository): TaskRepository
}

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindNetworkDataSource(
        dataSource: TaskNetworkDataSource
    ):NetworkDataSource
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): ToDoDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            ToDoDatabase::class.java,
            "Tasks.db"
        ).build()
    }

    @Provides
    fun provideTaskDao(database: ToDoDatabase): TaskDao = database.taskDao()
}